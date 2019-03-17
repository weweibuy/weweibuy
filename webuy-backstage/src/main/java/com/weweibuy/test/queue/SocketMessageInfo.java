package com.weweibuy.test.queue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName SocketMessageInfo
 * @Description
 * @Author durenhao
 * @Date 2019/3/17 23:02
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocketMessageInfo {

    private String sessionKey;

    private String message;
}
