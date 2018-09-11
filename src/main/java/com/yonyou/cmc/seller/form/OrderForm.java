package com.yonyou.cmc.seller.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Data
public class OrderForm {

    /** 客户名称. */
    @NotEmpty(message = "姓名必填")
    private String name;


    /** 手机号. */
    @NotEmpty(message = "手机号必填")
    private String phone;


    /** 地址. */
    @NotEmpty(message = "地址必填")
    private String address;


    /** 微信openId. */
    @NotEmpty(message = "openid必填")
    private String openId;

    /** 商品明细. */
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
