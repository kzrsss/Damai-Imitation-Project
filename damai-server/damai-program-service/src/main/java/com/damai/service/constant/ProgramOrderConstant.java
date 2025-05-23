package com.damai.service.constant;

import java.util.concurrent.TimeUnit;

/**
 * @program:   
 * @description: 相关常量
 * @author:  旷智仁
 **/
public class ProgramOrderConstant {
    
    public static final String DELAY_ORDER_CANCEL_TOPIC ="d_delay_order_cancel_topic";
    
    public static final Long DELAY_ORDER_CANCEL_TIME = 10L;
    
    public static final TimeUnit DELAY_ORDER_CANCEL_TIME_UNIT = TimeUnit.MINUTES;
    
    public static final String DELAY_OPERATE_PROGRAM_DATA_TOPIC = "d_delay_operate_program_data_topic";
    
    public static final Long ORDER_TABLE_COUNT = 4L;
}
