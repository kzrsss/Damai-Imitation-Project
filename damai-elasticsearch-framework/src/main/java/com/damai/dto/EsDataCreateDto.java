package com.damai.dto;

import lombok.Data;

/**
 * @program:
 * @description: elasticsearch数据参数
 * @author:  旷智仁
 **/
@Data
public class EsDataCreateDto {
    
    /**
     * 字段名
     * */
    private String paramName;
    /**
     * 字段值
     * */
    private Object paramValue;
}
