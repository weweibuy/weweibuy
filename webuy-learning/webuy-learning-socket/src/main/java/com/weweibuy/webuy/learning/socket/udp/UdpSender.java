package com.weweibuy.webuy.learning.socket.udp;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.*;
import java.util.stream.Stream;

/**
 * @author durenhao
 * @date 2020/7/1 20:47
 **/
@Slf4j
public class UdpSender {


    public static void main(String[] args) throws IOException {
        InetAddress byName = InetAddress.getByName("106.12.208.53");
        String msg =
                "HikariPool-1.pool.Wait,metricName=HikariPool-1.pool.Wait mean_rate=0.3269502606995024,max=89.929,count=85.0,p50=33.8101,p95=69.9049,p98=89.929,p75=38.4761,m1_rate=0.3337247177472478,p99=89.929,min=29.7524,mean=39.217407533802195,p999=89.929,stddev=13.54972739673291,m15_rate=0.08149578369005078,m5_rate=0.19005944310258288 1593612177919000000\n" +
                        "HikariPool-1.pool.PendingConnections,metricName=HikariPool-1.pool.PendingConnections value=0.0 1593612177919000000\n" +
                        "HikariPool-1.pool.IdleConnections,metricName=HikariPool-1.pool.IdleConnections value=10.0 1593612177919000000\n" +
                        "HikariPool-1.pool.ConnectionCreation,metricName=HikariPool-1.pool.ConnectionCreation p99=318.0,min=266.0,max=318.0,mean=281.58749317210095,count=6.0,p50=272.0,p999=318.0,stddev=18.295186731853466,p95=318.0,p98=318.0,p75=292.0 1593612177919000000\n" +
                        "HikariPool-1.pool.TotalConnections,metricName=HikariPool-1.pool.TotalConnections value=10.0 1593612177919000000\n" +
                        "HikariPool-1.pool.ConnectionTimeoutRate,metricName=HikariPool-1.pool.ConnectionTimeoutRate mean_rate=0.0,count=0.0,m15_rate=0.0,m1_rate=0.0,m5_rate=0.0 1593612177919000000\n" +
                        "HikariPool-1.pool.ActiveConnections,metricName=HikariPool-1.pool.ActiveConnections value=0.0 1593612177919000000\n" +
                        "HikariPool-1.pool.MinConnections,metricName=HikariPool-1.pool.MinConnections value=10.0 1593612177919000000\n" +
//                        "HikariPool-1.pool.Usage,metricName=HikariPool-1.pool.Usage p99=64.0,min=33.0,max=64.0,mean=39.152108169305755,count=85.0,p50=38.0,p999=64.0,stddev=6.424505467872742,p95=50.0,p98=64.0,p75=41.0 1593612177919000000\n" +
//                        "HikariPool-1.pool.MaxConnections,metricName=HikariPool-1.pool.MaxConnections value=10.0 1593612177919000000\n" +
                        "";

        int length = msg.getBytes().length;
        System.err.println(length);

        DatagramSocket ds = new DatagramSocket();
        Stream.iterate(0, i -> i + 1)
                .limit(10)
                .forEach(i -> {
                    byte[] buf = msg.getBytes();
                    DatagramPacket dp = new DatagramPacket(buf, buf.length, byName, 8089);
                    try {
                        ds.send(dp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

    }


}
