package com.damai.client;

import com.damai.common.ApiResponse;
import com.damai.dto.NotifyDto;
import com.damai.dto.PayDto;
import com.damai.dto.RefundDto;
import com.damai.dto.TradeCheckDto;
import com.damai.enums.BaseCode;
import com.damai.vo.NotifyVo;
import com.damai.vo.TradeCheckVo;
import org.springframework.stereotype.Component;

/**
 * @program:
 * @description: 支付服务 feign 异常
 * @author:  旷智仁
 **/
@Component
public class PayClientFallback implements PayClient{
    
    @Override
    public ApiResponse<String> commonPay(final PayDto payDto) {
        return ApiResponse.error(BaseCode.SYSTEM_ERROR);
    }
    
    @Override
    public ApiResponse<NotifyVo> notify(final NotifyDto notifyDto) {
        return ApiResponse.error(BaseCode.SYSTEM_ERROR);
    }
    
    @Override
    public ApiResponse<TradeCheckVo> tradeCheck(final TradeCheckDto tradeCheckDto) {
        return ApiResponse.error(BaseCode.SYSTEM_ERROR);
    }
    
    @Override
    public ApiResponse<String> refund(final RefundDto dto) {
        return ApiResponse.error(BaseCode.SYSTEM_ERROR);
    }
}
