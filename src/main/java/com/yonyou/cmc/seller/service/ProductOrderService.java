package com.yonyou.cmc.seller.service;

import com.yonyou.cmc.seller.dto.OrderDTO;

public interface ProductOrderService {

    //根据orderDto保存订单
    OrderDTO createOrder(OrderDTO dto);
}
