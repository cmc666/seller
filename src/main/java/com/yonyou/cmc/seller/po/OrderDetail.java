package com.yonyou.cmc.seller.po;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品明细表PO
 */
@Entity
@Data
public class OrderDetail {

    /** 订单明细id. */
    @Id
    private String detailId;

    /** 订单id. */
    private String orderId;

    /** 商品Id. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品单价. */
    private BigDecimal  productPrice;

    /** 商品数量. */
    private Integer productQuantity;

    /** 商品图片. */
    private String productIcon;

}
