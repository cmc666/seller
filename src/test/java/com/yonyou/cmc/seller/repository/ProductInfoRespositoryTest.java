package com.yonyou.cmc.seller.repository;

import com.yonyou.cmc.seller.enums.ProductStatusEnum;
import com.yonyou.cmc.seller.po.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRespositoryTest {

    @Autowired
    ProductInfoRespository productInfoRespository;


    @Test
    public void saveProductInfo(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("100002");
        productInfo.setCategoryType(10001);
        productInfo.setProductName("芒果冰");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setProductPrice(new BigDecimal(18));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的芒果冰");
        ProductInfo result = productInfoRespository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatusEquals() {
        List<ProductInfo> productInfoList = productInfoRespository.findByProductStatusEquals(ProductStatusEnum.UP.getCode());
        Assert.assertNotEquals(0,productInfoList.size());
    }
}