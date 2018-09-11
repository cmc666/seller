package com.yonyou.cmc.seller.dto;

import com.yonyou.cmc.seller.po.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class OrderDTO {

    /** 订单id. */
    private String orderId;

    /** 买家姓名. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家收货地址. */
    private String buyerAddress;

    /** 买家微信openID. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态. */
    private Integer orderStatus;

    /** 订单支付状态. */
    private Integer payStatus;

    /** 订单明细. */
    List<OrderDetail> orderDetailList;


}
