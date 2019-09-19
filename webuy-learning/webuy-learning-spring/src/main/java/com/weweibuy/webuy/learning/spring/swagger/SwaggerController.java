package com.weweibuy.webuy.learning.spring.swagger;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.learning.spring.model.Dog;
import com.weweibuy.webuy.learning.spring.model.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/9/19 21:00
 **/
@Api(tags = "swagger接口")
@RestController
@RequestMapping("/api/v1/swagger")
public class SwaggerController {

    @ApiOperation(value = "测试接口")
    @PostMapping("/user")
    public ResponseEntity<CommonJsonResponse<Dog>> addUserInfo(@RequestBody UserInfo userInfo){
        return ResponseEntity.ok(CommonJsonResponse.success(new Dog()));
    }

}
