package com.weweibuy.webuy.learning.spring.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HelloZk
 * @Description
 * @Author durenhao
 * @Date 2019/3/10 21:43
 **/
@Slf4j
//@RestController
//@RequestMapping("/zk")
public class HelloZk {

    /*
     *   Zookeeper的节点创建模式：
     *   PERSISTENT：持久化
     *   PERSISTENT_SEQUENTIAL：持久化并且带序列号
     *   EPHEMERAL：临时
     *   EPHEMERAL_SEQUENTIAL：临时并且带序列号
     */
    @Autowired
    private CuratorFramework curatorFramework;

    /**
     * 创建持久化节点
     *
     * @param node
     * @return
     */
    @RequestMapping("/create-node")
    public String create(String node) {
        try {
            // 默认为持久化创建
            return curatorFramework.create()
                    .forPath("/" + node, "你好zk".getBytes());
        }catch (KeeperException.NodeExistsException e){
            log.error("节点已经存在");
            return "节点已经存在";
        } catch (Exception e) {
            log.error("zk 创建节点异常: {}", e.getMessage());
            return "fail: " + e.getMessage();
        }
    }

    @RequestMapping("/create-temp-node")
    public String createTemp(String node) {
        try {
            return curatorFramework.create()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath("/" + node, "这是一个临时节点".getBytes());
        } catch (Exception e) {
            log.error("zk 创建节点异常: {}", e.getMessage());
            return "fail: " + e.getMessage();
        }
    }

    @RequestMapping("/create-temp-node-p")
    public String createP(String node) {
        try {
            return curatorFramework.create()
                    .creatingParentContainersIfNeeded()
                    .forPath("/parent/" + node, "递归创建节点".getBytes());
        } catch (Exception e) {
            log.error("zk 创建节点异常: {}", e.getMessage());
            return "fail: " + e.getMessage();
        }
    }

    @RequestMapping("/delete")
    public String delete(String node) {
        try {
            curatorFramework.delete()
                    .forPath("/" + node);
        } catch (Exception e) {
            log.error("zk 删除节点异常: {}", e.getMessage());
            return "fail: " + e.getMessage();
        }
        return "success";
    }


    @RequestMapping("/get-data")
    public String getData(String node) {
        try {
            byte[] bytes = curatorFramework.getData()
                    .forPath("/" + node);
            return new String(bytes);
        } catch (Exception e) {
            log.error("zk 获取: {}", e.getMessage());
            return "fail: " + e.getMessage();
        }
    }

    @RequestMapping("/get-data-version")
    public String getData2(String node) {
        try {
            Stat stat = new Stat();
            byte[] bytes = curatorFramework.getData()
                    .storingStatIn(stat)
                    .forPath("/" + node);
            return node + "节点的版本:" +stat.getVersion();
        } catch (Exception e) {
            log.error("zk 获取: {}", e.getMessage());
            return "fail: " + e.getMessage();
        }
    }

    @RequestMapping("/change-data")
    public String changeData(String node, String data) {
        try {
            Stat stat = new Stat();
            curatorFramework.getData()
                    .storingStatIn(stat)
                    .forPath("/" + node);
            curatorFramework.setData()
                    .withVersion(stat.getVersion())
                    .forPath("/" + node, ("节点数据变化为:" + data).getBytes());
            return "success";
        } catch (Exception e) {
            log.error("zk 获取: {}", e.getMessage());
            return "fail: " + e.getMessage();
        }
    }



    @RequestMapping("/check-exist")
    public String helloZk4(String node) {
        try {
            Stat stat = curatorFramework.checkExists()
                    .forPath("/" + node);
            if(stat == null){
                return "不存在";
            }
            return "存在:" + stat.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fall";
    }

    @RequestMapping("/write-version")
    public String helloZk5(String node, Integer version) {
        try {
            Stat stat = curatorFramework.setData()
                    .withVersion(version)
                    .forPath("/" + node);
        }catch (KeeperException.BadVersionException e){
            log.error("设置节点数据版本异常: {}", e.getMessage());
            return "fall:" + e.getMessage();
        } catch (Exception e) {
            log.error("zk异常: {}", e.getMessage());
            return "fall:" + e.getMessage();
        }
        return "success";
    }


    @RequestMapping("/add-observer")
    public String helloZk6(String node) {
        final NodeCache cache = new NodeCache(curatorFramework, "/" + node, false);
        try {
            cache.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        cache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                log.error("/" + node + "节点数据有变化" );
            }
        });
        return "success";
    }

}
