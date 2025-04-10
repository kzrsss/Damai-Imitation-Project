package com.damai.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @program:   
 * @description: 分页dto
 * @author:  旷智仁
 **/
@Data
public class BasePageDto {
    
    
    @NotNull
    private Integer pageNumber;
    
    
    @NotNull
    private Integer pageSize;
}
