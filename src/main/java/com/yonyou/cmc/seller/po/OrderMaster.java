package com.yonyou.cmc.seller.po;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 订单主表PO
 */
@Entity
@Data
public class OrderMaster {

    /** 订单id. */
    @Id
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

}
