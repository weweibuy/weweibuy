package com.weweibuy.learning.es.rest.controller;

import com.weweibuy.learning.es.rest.model.po.TbItem;
import com.weweibuy.learning.es.rest.service.EsItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author durenhao
 * @date 2020/2/8 18:54
 **/
@RestController
@RequestMapping("/es/item")
public class EsItemController {

    private final EsItemService esItemService;

    public EsItemController(EsItemService esItemService) {
        this.esItemService = esItemService;
    }

    @GetMapping("/sync")
    public Object sync() throws IOException {
        esItemService.sync();
        return "SUCCESS";
    }


    @GetMapping("/search")
    public List<TbItem> search(String keyword) throws IOException {
        return esItemService.search(keyword);
    }

}
