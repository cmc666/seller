package com.yonyou.cmc.seller.repository;

import com.yonyou.cmc.seller.po.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRespositoryTest {

    @Autowired
    ProductCategoryRespository productCategoryRespository;

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> categoryTypeList =  new ArrayList<>();
        categoryTypeList.add(10001);
        List<ProductCategory> categoryList = productCategoryRespository.findByCategoryTypeIn(categoryTypeList);
        Assert.assertNotNull("【商品类目】 查询结果不正确",categoryList);
    }
}