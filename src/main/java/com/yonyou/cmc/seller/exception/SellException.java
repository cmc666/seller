package com.yonyou.cmc.seller.exception;

import com.yonyou.cmc.seller.enums.ResultEnum;

public class SellException extends RuntimeException {

    private String code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(String code,String msg){
        super(msg);
        this.code = code;
    }
}
