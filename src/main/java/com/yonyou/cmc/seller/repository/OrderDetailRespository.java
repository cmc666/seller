package com.yonyou.cmc.seller.repository;

import com.yonyou.cmc.seller.po.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRespository extends JpaRepository<OrderDetail,String> {

}
