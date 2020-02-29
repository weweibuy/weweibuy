package com.weweibuy.webuy.learning.spring.swagger;

import com.weweibuy.webuy.common.model.dto.CommonDataJsonResponse;
import com.weweibuy.webuy.learning.spring.model.Dog;
import com.weweibuy.webuy.learning.spring.model.UserInfo;
import com.weweibuy.webuy.learning.spring.model.error.ApiError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@ApiResponses({
        @ApiResponse(code = 400, message = "业务处理异常", response = ApiError.class),
        @ApiResponse(code = 403, message = "没有权限", response = ApiError.class),
        @ApiResponse(code = 500, message = "未知异常", response = ApiError.class)
})
public class SwaggerController {

    @ApiOperation(value = "测试接口")
    @PostMapping("/user")
    public ResponseEntity<CommonDataJsonResponse<Dog>> addUserInfo(@RequestBody UserInfo userInfo){
        return ResponseEntity.ok(CommonDataJsonResponse.success(new Dog()));
    }

}
