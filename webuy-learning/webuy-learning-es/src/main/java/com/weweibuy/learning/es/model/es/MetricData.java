package com.weweibuy.learning.es.model.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Date;

/**
 * @author durenhao
 * @date 2019/8/3 22:30
 **/
@Data
@Document(indexName = "sentinel", type = "metric_data", createIndex = false)
public class MetricData {

    @Id
    @Field
    private Long id;

    private String resourceId;

    private String projectName;

    private Long passQps;

    private Long successQps;

    private Long blockQps;

    private Long exceptionQps;

    private Double responseTime;

    private Date getMetricTime;

    private Date clientMetricTime;

    private Integer count;

    private Date createTime;

    private Date updateTime;


}
