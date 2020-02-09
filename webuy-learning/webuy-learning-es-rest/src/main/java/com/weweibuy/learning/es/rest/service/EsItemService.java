package com.weweibuy.learning.es.rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weweibuy.learning.es.rest.mapper.TbItemMapper;
import com.weweibuy.learning.es.rest.model.po.TbItem;
import com.weweibuy.learning.es.rest.utils.JacksonUtils;
import com.weweibuy.webuy.common.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author durenhao
 * @date 2020/2/8 14:17
 **/
@Service
@Slf4j
public class EsItemService {

    private final RestHighLevelClient restHighLevelClient;

    private final TbItemMapper tbItemMapper;

    private final ObjectMapper objectMapper;

    public EsItemService(RestHighLevelClient restHighLevelClient, TbItemMapper tbItemMapper, ObjectMapper objectMapper) {
        this.restHighLevelClient = restHighLevelClient;
        this.tbItemMapper = tbItemMapper;
        this.objectMapper = objectMapper;
    }


    public List search(String keyword) throws IOException {

        SearchRequest searchRequest = new SearchRequest("learning_item");

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("title", keyword));

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.size(2);
        sourceBuilder.from(2);

        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("create_time");
        rangeQuery.from(DateTimeUtils.toDateFormat(LocalDateTime.now().plusYears(-2)));
        rangeQuery.to(DateTimeUtils.toDateFormat(LocalDateTime.now()));

        boolQueryBuilder.filter(rangeQuery);
        sourceBuilder.query(boolQueryBuilder);
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        List<TbItem> arrayList = new ArrayList<>();
        searchResponse.getHits().forEach(message -> {
            try {
                String sourceAsString = message.getSourceAsString();
                TbItem tbItem = JacksonUtils.stringToObject(sourceAsString, TbItem.class);
                arrayList.add(tbItem);
                log.info("查询结果: {}", sourceAsString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return arrayList;
    }

    public void update() {

    }

    public void insert() {

    }


    public void batchInsert() {

    }

    public Long aggQuery() {

        return null;
    }

    public void sync() throws IOException {
        List<TbItem> itemList = tbItemMapper.selectByExample(null);


        BulkRequest bulkRequest = new BulkRequest();
        itemList.stream().map(i -> JacksonUtils.objectToString(i))
                .forEach(s -> {
                    IndexRequest indexRequest = new IndexRequest("learning_item");
                    indexRequest.source(s, XContentType.JSON);
                    bulkRequest.add(indexRequest);
                });

        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        if (bulkResponse.hasFailures()) {
            String s = bulkResponse.buildFailureMessage();

            log.error("批量同步ES 异常: {}", s);
        }

    }

}
