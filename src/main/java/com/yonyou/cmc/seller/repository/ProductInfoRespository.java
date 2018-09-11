package com.yonyou.cmc.seller.repository;

import com.yonyou.cmc.seller.po.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品信息PO类
 */
public interface ProductInfoRespository extends JpaRepository<ProductInfo,String> {

    //根据商品状态查询
    List<ProductInfo> findByProductStatusEquals(Integer productStatus);

    //根据商品的productId查询商品信息
    ProductInfo findByProductId(String productId);

}
