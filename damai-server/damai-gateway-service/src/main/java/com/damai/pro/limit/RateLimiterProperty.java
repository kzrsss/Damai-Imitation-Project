package com.damai.pro.limit;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @program:
 * @description: 线上限流工具属性
 * @author:  旷智仁
 **/
@Data
public class RateLimiterProperty {
    
    @Value("${rate.switch:false}")
    private Boolean rateSwitch;

    @Value("${rate.permits:200}")
    private Integer ratePermits;
}
