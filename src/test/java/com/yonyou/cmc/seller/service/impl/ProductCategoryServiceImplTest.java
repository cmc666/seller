package com.yonyou.cmc.seller.service.impl;

import com.yonyou.cmc.seller.po.ProductCategory;
import com.yonyou.cmc.seller.service.ProductCategoryService;
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
public class ProductCategoryServiceImplTest {

    @Autowired
    ProductCategoryService categoryService;

    @Test
    public void findCategoryByType() {
        List<Integer> typeList = new ArrayList<Integer>();
        typeList.add(10001);
        List<ProductCategory> categoryList = categoryService.findCategoryByType(typeList);
        Assert.assertNotNull(categoryList);
    }
}