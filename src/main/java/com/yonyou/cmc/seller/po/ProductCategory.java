package com.yonyou.cmc.seller.po;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *类目PO
 */
@Entity
@Data
public class ProductCategory {
    @Id
    private Integer categoryId;

    /* 类目名称. */
    private String categoryName;

    /* 类目编码. */
    private Integer categoryType;
}

