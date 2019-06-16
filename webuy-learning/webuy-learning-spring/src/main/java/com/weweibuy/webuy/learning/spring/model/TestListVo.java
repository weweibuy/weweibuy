package com.weweibuy.webuy.learning.spring.model;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.cglib.beans.BeanCopier;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author durenhao
 * @date 2019/6/9 20:53
 **/
@Data
@EqualsAndHashCode
public class TestListVo {

    private static final BeanCopier copier = BeanCopier.create(TestListVo.class, ResponseVo.class, false);

    private Integer age;

    @NotNull(message = "userNames 不能为空")
    private List<String> userNames;

    private String[] userNames2;

    private List<TestUser> users;

    private CommonJsonResponse response;

}
