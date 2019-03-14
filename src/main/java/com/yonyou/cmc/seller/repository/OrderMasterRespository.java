package com.yonyou.cmc.seller.repository;

import com.yonyou.cmc.seller.po.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRespository extends JpaRepository<OrderMaster,String> {

    //根据opendId查询出所有订单信息
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
