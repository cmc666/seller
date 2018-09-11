package com.yonyou.cmc.seller.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class OrderDetailForm {

    String productId;

    String productQuantity;
}
