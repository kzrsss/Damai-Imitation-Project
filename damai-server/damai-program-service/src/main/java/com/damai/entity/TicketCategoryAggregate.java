package com.damai.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program:
 * @description: 票档统计 实体
 * @author:  旷智仁
 **/
@Data
public class TicketCategoryAggregate implements Serializable {
    
    /**
     * 节目表id
     */
    private Long programId;
    
    /**
     * 最低价格
     */
    private BigDecimal minPrice;
    
    /**
     * 最高价格
     */
    private BigDecimal maxPrice;
}
