package com.weweibuy.webuy.message.config.properties.xxljob;

import lombok.Data;

/**
 * job执行器配置
 * @ClassName ExecutorProperties
 * @Description
 * @Author durenhao
 * @Date 2019/1/20 20:25
 **/
@Data
public class ExecutorProperties {

    private String appName;

    private String ip;

    /**
     * 调度线程执行端口;不是应用的端口
     */
    private Integer port;

    private String logPath;

    /**
     * 日志保持天数
     */
    private Integer logRetentionDays = 15;

}
