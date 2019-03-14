package com.yonyou.cmc.seller.enums;

import com.yonyou.cmc.seller.VO.ResultVO;
import lombok.Getter;

import java.util.List;

@Getter
public enum  ResultEnum {

    SUCCESS("0","成功"),

    PARAM_ERROR("1","参数不正确"),

    CART_EMPTY("2","购物车为空");


    private String code;
    private String msg;
    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
