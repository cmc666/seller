package com.yonyou.cmc.seller.controller;


import com.yonyou.cmc.seller.VO.ProductVO;
import com.yonyou.cmc.seller.VO.ProductInfoVO;
import com.yonyou.cmc.seller.VO.ResultVO;
import com.yonyou.cmc.seller.po.ProductCategory;
import com.yonyou.cmc.seller.po.ProductInfo;
import com.yonyou.cmc.seller.service.ProductCategoryService;
import com.yonyou.cmc.seller.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yonyou.cmc.seller.utils.ResultVOUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerProductController {

    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    ProductCategoryService categoryService;


    @RequestMapping("/product/list")
    public ResultVO<List<ProductVO>> findProductList(){
        //创建一个商品类目类型集合
        List<Integer> typeList =  new ArrayList<Integer>();

        //查询出所有上架的商品
        List<ProductInfo> productInfoList = productInfoService.findAllUpProduct();
        for (ProductInfo item:productInfoList) {
            if(!typeList.contains(item.getCategoryType())){
                typeList.add(item.getCategoryType());
            }
        }
        //查询所有上架商品对应的类目信息
        List<ProductCategory> productCategoriesList = categoryService.findCategoryByType(typeList);

        //创建一个productVo的集合
        List<ProductVO> productVOList =  new ArrayList<ProductVO>();
        //封装productVoList
        for (ProductCategory item: productCategoriesList) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(item,productVO);
            //创建一个ProductInfoVo集合
            List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();
            for (ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(item.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProuductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.sucess(productVOList);
    }
}
