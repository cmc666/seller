package com.yonyou.cmc.seller.service;

import com.yonyou.cmc.seller.po.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    //根据类目类型集合查询对应的类目信息
    List<ProductCategory> findCategoryByType(List<Integer> typeList);
}
