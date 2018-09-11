package com.yonyou.cmc.seller.utils;

import com.yonyou.cmc.seller.VO.ResultVO;

import java.util.List;

/**
 * 前端返回结果工具类
 */
public class ResultVOUtil {

    /**
     * 返回正确的请求
     * @param list
     * @return
     */
    public static ResultVO sucess(List list){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("查询成功");
        resultVO.setData(list);
        return resultVO;
    };

    /**
     * 返回指定的code和msg的信息
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg(msg);
        return resultVO;
    };

    /**
     * 根据指定的code返回错误信息
     * @param code
     * @return
     */
    public static ResultVO error(Integer code){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg("查询失败");
        return resultVO;
    };
}
