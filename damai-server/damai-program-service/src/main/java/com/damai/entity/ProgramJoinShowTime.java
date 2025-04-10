package com.damai.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @program:
 * @description: 节目 实体 连表使用
 * @author:  旷智仁
 **/
@Data
public class ProgramJoinShowTime extends Program implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    
    /**
     * 演出时间
     */
    private Date showTime;
    
    /**
     * 演出时间(精确到天)
     */
    private Date showDayTime;
    
    /**
     * 演出时间所在的星期
     */
    private String showWeekTime;
}
