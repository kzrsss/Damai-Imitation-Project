package com.damai.conf;

import com.damai.common.ApiResponse;
import lombok.Data;

import java.util.Map;

/**
 * @program:
 * @description: 临时信息
 * @author:  旷智仁
 **/
@Data
public class RequestTemporaryWrapper {
    
    private Map<String,String> map;
    
    private ApiResponse<?> apiResponse;
}
