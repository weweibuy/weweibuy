package com.weweibuy.webuy.learning.spring.csv.model;

import lombok.Data;

import java.util.Date;

/**
 * @author durenhao
 * @date 2019/7/11 23:05
 **/
@Data
public class CsvUser {

    private String customerNo;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String mailingAddress;

    private Boolean married;

    private Integer numberOfKids;

    private String favouriteQuote;

    private String email;

    private Long loyaltyPoints;

}
