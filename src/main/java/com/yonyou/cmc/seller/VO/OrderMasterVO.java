package com.yonyou.cmc.seller.VO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderMasterVO {

    /** 订单id .*/
    private String orderId;

    /** 买家姓名 .*/
    private String buyerName;

    /** 买家手机号 .*/
    private String buyerPhone;

    /** 买家地址 .*/
    private String buyerAddress;

    /** 买家微信openId .*/
    private String buyerOpenid;

    /** 订单总金额 .*/
    private BigDecimal orderAmount;

    /** 订单状态 .*/
    private Integer orderStatus;

    /** 订单支付状态 .*/
    private Integer payStatus;

    /** 订单创建时间 .*/
    private Date createTime;

    /** 订单更新时间 .*/
    private Date updateTime;

    /** 订单明细列表 .*/
    private String orderDetailList;

}
