package com.yonyou.cmc.seller.controller;


import com.yonyou.cmc.seller.VO.OrderMasterVO;
import com.yonyou.cmc.seller.VO.ResultVO;
import com.yonyou.cmc.seller.converter.ConverterOrderForm2OrderDto;
import com.yonyou.cmc.seller.dto.OrderDTO;
import com.yonyou.cmc.seller.enums.ResultEnum;
import com.yonyou.cmc.seller.exception.SellException;
import com.yonyou.cmc.seller.form.OrderForm;
import com.yonyou.cmc.seller.service.ProductOrderService;
import com.yonyou.cmc.seller.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.BindException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {


    @Autowired
    ProductOrderService orderService;


    /**
     * 创建一个订单
     * @return
     */
    @RequestMapping("/created")
    @ResponseBody
    public ResultVO<Map<String,String>> createdOrder(@Valid OrderForm orderForm, BindingResult bindResult){
        if (bindResult.hasErrors()){
            log.error("【创建订单的参数不正确】 订单参数为{}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindResult.getFieldError().getDefaultMessage());
        }
        //根据前端传递过来的信息封装订单数据
        OrderDTO orderDTO = ConverterOrderForm2OrderDto.converter(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【购物车数量不能为空】");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createdOrderDto = orderService.createOrder(orderDTO);
        //保存订单
        Map<String,String> result = new HashMap<String,String>();
        result.put("orderId",createdOrderDto.getOrderId());
        return ResultVOUtil.sucess(result);
    }


    public ResultVO<List<OrderDTO>> findOrderListByOpenId(
                                @RequestParam("openid") String openid,
                                @RequestParam(value = "page",defaultValue = "0") Integer page,
                                @RequestParam(value = "size",defaultValue = "10") Integer size){

        PageRequest pageRequest = new PageRequest(page,size);


        return null;
    }
}
