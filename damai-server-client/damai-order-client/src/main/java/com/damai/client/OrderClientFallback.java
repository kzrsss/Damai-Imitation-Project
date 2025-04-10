package com.damai.client;

import com.damai.common.ApiResponse;
import com.damai.dto.AccountOrderCountDto;
import com.damai.dto.OrderCreateDto;
import com.damai.enums.BaseCode;
import com.damai.vo.AccountOrderCountVo;
import org.springframework.stereotype.Component;

/**
 * @program:   
 * @description: 订单服务 feign 异常
 * @author:  旷智仁
 **/
@Component
public class OrderClientFallback implements OrderClient {
    
    @Override
    public ApiResponse<String> create(final OrderCreateDto orderCreateDto) {
        return ApiResponse.error(BaseCode.SYSTEM_ERROR);
    }
    
    @Override
    public ApiResponse<AccountOrderCountVo> accountOrderCount(final AccountOrderCountDto dto) {
        return ApiResponse.error(BaseCode.SYSTEM_ERROR);
    }
}
