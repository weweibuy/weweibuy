package com.weweibuy.learning.es.model.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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

    @Field(type = FieldType.keyword, index = false)
    private String resourceId;

    @Field(type = FieldType.keyword, index = false)
    private String projectName;

    @Field(type = FieldType.keyword, index = false)
    private Long passQps;

    @Field(type = FieldType.keyword, index = false)
    private Long successQps;

    @Field(type = FieldType.keyword, index = false)
    private Long blockQps;

    @Field(type = FieldType.keyword, index = false)
    private Long exceptionQps;

    @Field(type = FieldType.keyword, index = false)
    private Double responseTime;

    @Field(type = FieldType.keyword, index = false)
    private Date getMetricTime;

    @Field(type = FieldType.keyword, index = false)
    private Date clientMetricTime;

    @Field(type = FieldType.keyword, index = false)
    private Integer count;

    @Field(type = FieldType.keyword, index = false)
    private Date createTime;

    @Field(type = FieldType.keyword, index = false)
    private Date updateTime;


}
