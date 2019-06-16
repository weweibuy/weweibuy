package com.weweibuy.webuy.learning.spring.service;

import com.weweibuy.webuy.learning.spring.annotation.MyAnnotation;
import com.weweibuy.webuy.learning.spring.model.eum.BillTypeEum;
import com.weweibuy.webuy.learning.spring.model.eum.ChannelCodeEum;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2019/6/11 22:23
 **/
@Primary
@MyAnnotation(channel = ChannelCodeEum.JIT, billType = BillTypeEum.SALE)
@Service
public class BTypeInterfaceImpl implements TypeInterface{
}
