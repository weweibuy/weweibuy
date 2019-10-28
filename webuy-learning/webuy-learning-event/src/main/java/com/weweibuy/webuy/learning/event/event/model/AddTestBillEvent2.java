package com.weweibuy.webuy.learning.event.event.model;

import lombok.*;

/**
 * @author durenhao
 * @date 2019/10/26 10:38
 **/
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddTestBillEvent2 implements Event{

    private String eventNo;

    private String billNo;

    private String billType;

    private String bizType;

    private String whType;

}
