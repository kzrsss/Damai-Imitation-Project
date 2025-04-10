package com.damai.service.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program:
 * @description: 订单支付 回调地址配置
 * @author:  旷智仁
 **/
@Data
@Component
public class OrderProperties {

    /**
     * 支付成功后通知接口地址
     * */
    @Value("${orderPayNotifyUrl:http://localhost:6085/damai/order/order/alipay/notify}")
    private String orderPayNotifyUrl;
    
    /**
     * 支付成功后跳转页面
     * */
    @Value("${orderPayReturnUrl:http://localhost:5173/order/paySuccess}")
    private String orderPayReturnUrl;
}
