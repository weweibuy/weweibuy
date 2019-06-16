package com.weweibuy.webuy.learning.spring.model;

import com.weweibuy.webuy.learning.spring.model.eum.TypeEum;
import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author durenhao
 * @date 2019/6/9 20:56
 **/
@Data
public class TestUser {

    private static final BeanCopier copier = BeanCopier.create(TestListVo.class, ResponseVo.class, false);

    private String userNames;

    @NotNull(message = "类型不能为空")
    private TypeEum typeEum;

    private List<TestDog> dogList;


}
