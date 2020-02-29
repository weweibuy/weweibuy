package com.weweibuy.webuy.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonPageResult<T> {

    private static final CommonPageResult EMPTY = new CommonPageResult(0L, Collections.emptyList());

    private Long total;

    private Collection<T> list;


}
