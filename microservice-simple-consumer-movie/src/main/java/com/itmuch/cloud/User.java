package com.itmuch.cloud;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by jiaozhiguang on 2017/7/15.
 */
@Data
public class User {

    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;

}
