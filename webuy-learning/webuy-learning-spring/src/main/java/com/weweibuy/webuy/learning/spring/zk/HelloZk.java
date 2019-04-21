package com.weweibuy.webuy.learning.spring.zk;

import com.weweibuy.webuy.learning.spring.zk.session.ZkSessionHolder;
import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloZk
 * @Description
 * @Author durenhao
 * @Date 2019/3/10 21:43
 **/
@Slf4j
@RestController
@RequestMapping("/zk")
public class HelloZk {

    @RequestMapping("/lock-p")
    public String helloZk(String node) {
        ZkClient zkClient = ZkSessionHolder.getZooKeeper();
        zkClient.createPersistent("/test/lock-" + node, true);
        return "zk..";
    }

    @RequestMapping("/lock")
    public String helloZk2(String node) {
        ZkClient zkClient = ZkSessionHolder.getZooKeeper();
        try {
            zkClient.create("/test/lock-" + node, System.currentTimeMillis(), CreateMode.EPHEMERAL);
        } catch (Exception e) {
            if (e instanceof KeeperException.NodeExistsException) {
                return "fail get lock";
            }
        }
        return "zk..";
    }

    @RequestMapping("/get-data")
    public String helloZk3(String node) {
        ZkClient zkClient = ZkSessionHolder.getZooKeeper();
        Object o = zkClient.readData("/test/lock-" + node);
        Stat stat = new Stat();
        zkClient.readData("/test/lock-" + node, stat);

        int version = stat.getVersion();

        log.error("节点数据: {}, 版本: {}", o, version);
        return o.toString();
    }

    @RequestMapping("/write-data-version")
    public String helloZk4(String node) {
        ZkClient zkClient = ZkSessionHolder.getZooKeeper();


        Object readData = zkClient.readData("/test/lock-" + node);
        zkClient.writeData("/test/lock-" + node, System.currentTimeMillis(), 7);
        return "success";
    }

    @RequestMapping("/write-data")
    public String helloZk5(String node) {
        ZkClient zkClient = ZkSessionHolder.getZooKeeper();
        Object readData = zkClient.readData("/test/lock-" + node);
        zkClient.writeData("/test/lock-" + node, System.currentTimeMillis());
        return "success";
    }


    @RequestMapping("/add-observer")
    public String helloZk6(String node) {
        ZkClient zkClient = ZkSessionHolder.getZooKeeper();
        Object readData = zkClient.readData("/test/lock-" + node);
        zkClient.subscribeDataChanges("/test/lock-" + node, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                log.info("dataPath: {}; 数据变为: {}", dataPath, data);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {

            }
        });

        return "success";
    }

}
