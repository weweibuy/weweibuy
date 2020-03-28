package com.weweibuy.learning.es.service;

import com.weweibuy.learning.es.model.dto.PageQueryDto;
import com.weweibuy.learning.es.model.es.EsDispatchBillInfo;
import com.weweibuy.learning.es.model.vo.DispatchPageQueryVo;
import com.weweibuy.learning.es.respository.EsDispatchRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2019/8/11 9:44
 **/
@Service
public class EsDispatchService {

    @Autowired
    private EsDispatchRepository esDispatchRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    public EsDispatchBillInfo getById(String id) {
        return esDispatchRepository.findById(id).orElseGet(null);
    }

    public PageQueryDto pageSearch(DispatchPageQueryVo pageQueryVo) {
        PageRequest of = PageRequest.of(pageQueryVo.getPage() - 1, pageQueryVo.getSize());
        BoolQueryBuilder filter = QueryBuilders.boolQuery();

        pageQueryVo.getBillSource().ifPresent(i -> filter.filter(QueryBuilders.termQuery("bill_source", i)));
        pageQueryVo.getBizType().ifPresent(i -> filter.filter(QueryBuilders.termQuery("biz_type", i)));
        pageQueryVo.getChannel().ifPresent(i -> filter.filter(QueryBuilders.termQuery("channel_code", i)));
        pageQueryVo.getWarehouseCode().ifPresent(i -> filter.filter(QueryBuilders.termQuery("warehouse_code", i)));

        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(filter);
        queryBuilder.withPageable(of);

        pageQueryVo.getOrderList().ifPresent(list -> {
            list.forEach(i -> {
                FieldSortBuilder create_time = SortBuilders.fieldSort(i.getFiled()).order("ASC".equals(i.getValue()) ? SortOrder.ASC : SortOrder.DESC);
                queryBuilder.withSort(create_time);
            });
        });


        Page<EsDispatchBillInfo> search = esDispatchRepository.search(queryBuilder.build());
        return new PageQueryDto(search.getTotalElements(), search.getContent());
    }
}
