package com.yonyou.cmc.seller.service.impl;

import com.yonyou.cmc.seller.enums.ProductStatusEnum;
import com.yonyou.cmc.seller.po.ProductInfo;
import com.yonyou.cmc.seller.repository.ProductInfoRespository;
import com.yonyou.cmc.seller.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品信息service
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {


    @Autowired
    ProductInfoRespository productInfoRespository;

    @Override
    public List<ProductInfo> findAllUpProduct() {
        return productInfoRespository.findByProductStatusEquals(ProductStatusEnum.UP.getCode());
    }
}
