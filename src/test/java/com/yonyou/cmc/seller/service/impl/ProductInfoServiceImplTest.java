package com.yonyou.cmc.seller.service.impl;

import com.yonyou.cmc.seller.po.ProductInfo;
import com.yonyou.cmc.seller.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    ProductInfoService productInfoService;

    @Test
    public void findAllUpProduct() {

        List<ProductInfo> productInfoList = productInfoService.findAllUpProduct();
        Assert.assertNotNull(productInfoList);
    }
}