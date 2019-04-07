package com.weweibuy.webuy.message.config;

import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;

import java.util.Collection;

/**
 * sharding 分片策略
 * @author durenhao
 * @date 2019/4/7 15:46
 **/
public class StandardShardingStrategy implements RangeShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection collection, RangeShardingValue rangeShardingValue) {

        return null;
    }
}
