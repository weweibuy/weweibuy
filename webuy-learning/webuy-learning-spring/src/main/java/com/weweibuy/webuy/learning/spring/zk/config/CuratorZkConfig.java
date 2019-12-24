package com.weweibuy.webuy.learning.spring.zk.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/4/22 22:42
 **/
@Slf4j
//@Configuration
public class CuratorZkConfig {

    @Bean
    @Primary
    public CuratorFramework curatorFramework(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework curatorZkClient = CuratorFrameworkFactory.builder()
                .connectString("106.12.95.245:2181")
                .sessionTimeoutMs(60 * 1000)
                .retryPolicy(retryPolicy)
                .namespace("learn-spring")
                .build();
        curatorZkClient.start();

        //  添加节点监听器
        final NodeCache cache = new NodeCache(curatorZkClient, "/1", false);

        PathChildrenCache childrenCache = new PathChildrenCache(curatorZkClient, "/", false);

        try {
            cache.start();
            childrenCache.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        cache.getListenable().addListener(() -> log.error("1节点数据有变化!"));
        childrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                String path = pathChildrenCacheEvent.getData()
                        .getPath();
                List<ChildData> initialData = pathChildrenCacheEvent.getInitialData();
                log.error("子节点: {} 数据有变化, 数据: {}", path);
            }
        });
        return curatorZkClient;
    }


}
