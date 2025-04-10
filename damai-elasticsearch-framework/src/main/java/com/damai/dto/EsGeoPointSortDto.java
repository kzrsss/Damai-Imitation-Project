package com.damai.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program:
 * @description: elasticsearch GeoPoint定位
 * @author:  旷智仁
 **/
@Data
public class EsGeoPointSortDto {
    /**
     * 字段名
     * */
    private String paramName;
    /**
     * 纬度值
     * */
    private BigDecimal latitude;
    /**
     * 经度值
     * */
    private BigDecimal longitude;
    
    
}
