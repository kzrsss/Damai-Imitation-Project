package com.damai.dto;

import lombok.Data;

/**
 * @program:
 * @description: 票据数据操作 dto
 * @author:  旷智仁
 **/
@Data
public class TicketCategoryCountDto {
    
    /**
     * 票档id
     * */
    private Long ticketCategoryId;
    
    /**
     * 数量
     * */
    private Long count;
}
