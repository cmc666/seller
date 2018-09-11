package com.yonyou.cmc.seller.repository;

import com.yonyou.cmc.seller.po.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品类目
 */
public interface ProductCategoryRespository extends JpaRepository<ProductCategory,Integer> {

    /**
     * 根据商品类目编码查询
     * @param categoryTypeList 商品类目编码list
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
