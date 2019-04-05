package com.weweibuy.webuy.auth.core.validate.code;

import com.weweibuy.webuy.auth.core.model.vo.ValidateCode;

/**
 * @ClassName ValidateCodeGenerator
 * @Description
 * @Author durenhao
 * @Date 2018/12/15 22:49
 **/
public interface ValidateCodeGenerator {

    ValidateCode generator();

}
