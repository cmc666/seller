package com.yonyou.cmc.seller.service;

import com.yonyou.cmc.seller.VO.OrderMasterVO;
import com.yonyou.cmc.seller.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductOrderService {

    //根据orderDto保存订单
    OrderDTO createOrder(OrderDTO dto);

    //根据openid分页查询数据
    Page<OrderDTO> findList(String openId, Pageable pageable);
}
