package com.yonyou.cmc.seller.service;

import com.yonyou.cmc.seller.VO.ProductVO;
import com.yonyou.cmc.seller.po.ProductInfo;

import java.util.List;

public interface ProductInfoService {

    //查询所有上架的商品
    List<ProductInfo> findAllUpProduct();

}
