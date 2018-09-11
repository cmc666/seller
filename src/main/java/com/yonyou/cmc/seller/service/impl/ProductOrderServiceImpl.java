package com.yonyou.cmc.seller.service.impl;

import com.yonyou.cmc.seller.dto.OrderDTO;
import com.yonyou.cmc.seller.po.OrderDetail;
import com.yonyou.cmc.seller.po.OrderMaster;
import com.yonyou.cmc.seller.po.ProductInfo;
import com.yonyou.cmc.seller.repository.OrderDetailRespository;
import com.yonyou.cmc.seller.repository.OrderMasterRespository;
import com.yonyou.cmc.seller.repository.ProductInfoRespository;
import com.yonyou.cmc.seller.service.ProductOrderService;
import com.yonyou.cmc.seller.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    private OrderMasterRespository orderMasterRespository;

    @Autowired
    private OrderDetailRespository orderDetailRespository;

    @Autowired
    private ProductInfoRespository productInfoRespository;


    @Override
    public OrderDTO createOrder(OrderDTO dto) {
        //创建订单编号
        String orderId = KeyUtil.genUniqueKey();
        OrderMaster orderMaster = new OrderMaster();
        //设置客户订单信息
        BeanUtils.copyProperties(dto,orderMaster);
        orderMaster.setOrderId(orderId);

        BigDecimal totalAmount = new BigDecimal(0);
        //设置订单明细
        for (OrderDetail item: dto.getOrderDetailList()) {
            //根据productId获取商品信息
            ProductInfo productInfo =  productInfoRespository.findByProductId(item.getProductId());
            OrderDetail orderDetail = new OrderDetail();
            BigDecimal salesPrice = productInfo.getProductPrice();
            BeanUtils.copyProperties(item,orderDetail);

            //totalAmount += salesPrice.multiply();






        }

        return null;
    }
}
