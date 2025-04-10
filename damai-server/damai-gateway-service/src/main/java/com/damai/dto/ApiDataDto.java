package com.damai.dto;

import lombok.Data;

import java.util.Date;

/**
 * @program:
 * @description: api调用记录 接受参数
 * @author:  旷智仁
 **/
@Data
public class ApiDataDto {
    
    private Long id;
    
    private String headVersion;
    
    private String apiAddress;
    
    private String apiMethod;
    
    private String apiBody;
    
    private String apiParams;
    
    private String apiUrl;
    
    private Date createTime;
    
    private Integer status;
    
    private String callDayTime;
    
    private String callHourTime;
    
    private String callMinuteTime;
    
    private String callSecondTime;
    
    private Integer type;
    
}
