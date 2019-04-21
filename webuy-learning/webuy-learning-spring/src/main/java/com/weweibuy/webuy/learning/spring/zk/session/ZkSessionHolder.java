package com.weweibuy.webuy.learning.spring.zk.session;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.ZkClient;

/**
 * @author durenhao
 * @date 2019/4/21 22:30
 **/
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ZkSessionHolder {

    private static class InnerHolder {

        private static ZkClient zkClient;

        static {
            zkClient = new ZkClient("106.12.95.245:2181", 30000);

        }
    }

    public static ZkClient getZooKeeper() {
        return InnerHolder.zkClient;
    }

}
