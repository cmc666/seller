package com.yonyou.cmc.seller.converter;


import com.alibaba.fastjson.JSONArray;
import com.yonyou.cmc.seller.dto.OrderDTO;
import com.yonyou.cmc.seller.enums.ResultEnum;
import com.yonyou.cmc.seller.exception.SellException;
import com.yonyou.cmc.seller.form.OrderForm;
import com.yonyou.cmc.seller.po.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ConverterOrderForm2OrderDto {

    public static OrderDTO converter(OrderForm orderForm){

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        //创建一个商品明细
        List<OrderDetail> orderDetails = new ArrayList<>();
        try {
            orderDetails = JSONArray.parseArray(orderForm.getItems(),OrderDetail.class);
        }catch (Exception e){
            log.error("【对象转换错误】 转换对象为:{}",orderForm.getItems());
            throw  new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetails);
        return orderDTO;
    }
}
