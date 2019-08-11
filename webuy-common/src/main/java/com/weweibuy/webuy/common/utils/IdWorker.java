package com.weweibuy.webuy.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


@Slf4j
public final class IdWorker {

    /**
     * 起始的时间戳
     */
    private static final long START_TIMESTAMP = 1565440502296L;

    /**
     * 毫秒内自增位：10位支持1024个
     */
    private static final long SEQUENCE_BITS = 10L;

    /**
     * IP标识位数
     */
    private static final long IP_BITS = 8L;

    /**
     * PID标识位数
     */
    private static final long PID_BITS = 5L;

    /**
     * 机器标识位数：13位支持8192台机器
     */
    private static final long WORKER_ID_BITS = IP_BITS + PID_BITS;

    /**
     * 时间毫秒左移位数
     */
    private static final long TIMESTAMP_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;

    /**
     * 序列号左移位数
     */
    private static final long SEQUENCE_SHIFT = WORKER_ID_BITS;

    /**
     * 序列号最大值
     */
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);

    /**
     * 机器ID最大值
     */
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);

    /**
     * 上次生成ID时间戳
     */
    private long lastTimestamp = -1L;

    /**
     * 机器ID
     */
    private final long workerId;

    /**
     * 序列号
     */
    private long sequence = 0L;

    private static final IdWorker WORKER = new IdWorker();

    private IdWorker() {
        long id = getWorkerId();
        if (id > MAX_WORKER_ID || id < 0) {
            throw new RuntimeException(String.format("worker Id can't be greater than %d or less than 0",
                    MAX_WORKER_ID));
        }
        this.workerId = id;
    }

    private long nextId() {
        synchronized (this) {
            long timestamp = currentTimestamp();
            if (this.lastTimestamp == timestamp) {
                this.sequence = (this.sequence + 1) & MAX_SEQUENCE;
                if (this.sequence == 0) {
                    timestamp = tilNextMillis(this.lastTimestamp);
                }
            } else {
                this.sequence = 0;
            }

            if (timestamp < this.lastTimestamp) {
                log.error("Clock moved backwards. Refusing to generate id for %d milliseconds", this.lastTimestamp - timestamp);
            }

            this.lastTimestamp = timestamp;
            return ((timestamp - START_TIMESTAMP) << TIMESTAMP_SHIFT) | (this.sequence << SEQUENCE_SHIFT) | this.workerId;
        }
    }

    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = currentTimestamp();
        while (timestamp <= lastTimestamp) {
            timestamp = currentTimestamp();
        }
        return timestamp;
    }

    private long currentTimestamp() {
        return System.currentTimeMillis();
    }

    public static long getNextId() {
        return WORKER.nextId();
    }

    public static String getNextStrId() {
        return WORKER.nextId() + "";
    }


    /**
     * 生成机器ID
     */
    private static long getWorkerId() {
        byte[] ip;

        long workerId;

        try {
            ip = getPrivateIp().getAddress();
            workerId = (ip[2] << 8 | (int) ip[3]) & ((1 << IP_BITS) - 1);
        } catch (SocketException e) {
            throw new RuntimeException("无法获取本机IP地址", e);
        }

        long pid = getPid() & ((1 << PID_BITS) - 1);

        return (workerId << PID_BITS) | pid;

    }


    /**
     * 取得本机内网IP
     */
    private static InetAddress getPrivateIp() throws SocketException {
        List<InetAddress> addresses = getAllIPs();
        if (CollectionUtils.isEmpty(addresses)) {
            throw new RuntimeException("无法获取本机IP地址");
        }
        List<InetAddress> localAddresses = new ArrayList<>();
        for (InetAddress address : addresses) {
            if (address.isSiteLocalAddress()) {
                localAddresses.add(address);
            }
        }

        if (CollectionUtils.isEmpty(localAddresses)) {
            throw new RuntimeException("无法获取本机内网IP地址");
        }

        if (1 != localAddresses.size()) {
            StringBuilder ips = new StringBuilder();
            for (InetAddress address : localAddresses) {
                ips.append(address.getHostAddress()).append(",");
            }
            ips.deleteCharAt(ips.length() - 1);
        }

        return localAddresses.get(0);
    }

    /**
     * 取得本机所有IP
     */
    private static List<InetAddress> getAllIPs() throws SocketException {
        List<InetAddress> result = new ArrayList<>();
        Enumeration<NetworkInterface> netInterfaces;
        netInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip;
        while (netInterfaces.hasMoreElements()) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> addresses = ni.getInetAddresses();
            while (addresses.hasMoreElements()) {
                ip = addresses.nextElement();
                if (!ip.getHostAddress().contains(":")) {
                    result.add(ip);
                }
            }
        }
        return result;
    }

    /**
     * 取得PID
     */
    private static int getPid() {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        int index = name.indexOf('@');
        if (index == -1) {

            throw new RuntimeException("获取PID错误, name=" + name);
        }

        try {
            int pid = Integer.parseInt(name.substring(0, index));
            return pid;
        } catch (NumberFormatException e) {
            throw new RuntimeException("获取PID错误, name=" + name, e);
        }
    }

}