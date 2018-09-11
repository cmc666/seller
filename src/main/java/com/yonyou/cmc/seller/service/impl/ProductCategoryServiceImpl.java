package com.yonyou.cmc.seller.service.impl;

import com.yonyou.cmc.seller.po.ProductCategory;
import com.yonyou.cmc.seller.repository.ProductCategoryRespository;
import com.yonyou.cmc.seller.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryRespository categoryRespository;

    @Override
    public List<ProductCategory> findCategoryByType(List<Integer> typeList) {
        return categoryRespository.findByCategoryTypeIn(typeList);
    }
}
