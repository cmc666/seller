package com.yonyou.cmc.seller.service.impl;

import com.yonyou.cmc.seller.VO.OrderMasterVO;
import com.yonyou.cmc.seller.converter.ConverterOrderMaster2OrderDto;
import com.yonyou.cmc.seller.dto.OrderDTO;
import com.yonyou.cmc.seller.enums.OrderStatusEnum;
import com.yonyou.cmc.seller.enums.PayStatusEnum;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
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
            //将商品信息里面的数据copy到订单明细表里面
            BeanUtils.copyProperties(productInfo,orderDetail);
            //设置商品的item_id
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            //获取购物车的订单数量
            BigDecimal productQuantity = new BigDecimal(item.getProductQuantity()+"");
            //计算总金额
            totalAmount = salesPrice.multiply(productQuantity).add(totalAmount);
            orderDetail.setProductQuantity(item.getProductQuantity());
            orderDetailRespository.save(orderDetail);
        }
        orderMaster.setOrderAmount(totalAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW_ORDER.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAITING.getCode());
        orderMasterRespository.save(orderMaster);
        //扣库存

        dto.setOrderId(orderId);
        return dto;
    }

    @Override
    public Page<OrderDTO> findList(String openId, Pageable pageable) {

        Page<OrderMaster> orderMasters = orderMasterRespository.findByBuyerOpenid(openId,pageable);

        List<OrderDTO> result = ConverterOrderMaster2OrderDto.converter(orderMasters.getContent());

        return new PageImpl<OrderDTO>(result,pageable,orderMasters.getTotalElements());
    }
}
