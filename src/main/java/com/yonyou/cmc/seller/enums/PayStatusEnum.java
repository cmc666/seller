package com.yonyou.cmc.seller.enums;


import lombok.Getter;

@Getter
public enum PayStatusEnum {

    WAITING(1,"等待支付");

    private Integer code;
    private String msg;


    PayStatusEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    };
}
