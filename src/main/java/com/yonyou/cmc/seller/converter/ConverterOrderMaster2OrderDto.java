package com.yonyou.cmc.seller.converter;

import com.yonyou.cmc.seller.dto.OrderDTO;
import com.yonyou.cmc.seller.po.OrderMaster;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 将订单PO转换为orderDto
 */
public class ConverterOrderMaster2OrderDto {


    public static List<OrderDTO> converter(List<OrderMaster> orderMasters){
        List<OrderDTO> orderDTOS = new ArrayList<OrderDTO>();
        for (OrderMaster item:orderMasters) {
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(item,orderDTO);
            orderDTOS.add(orderDTO);
        }
        return  orderDTOS;
    }
}
