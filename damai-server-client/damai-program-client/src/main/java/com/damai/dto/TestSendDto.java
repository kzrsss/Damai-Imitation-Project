package com.damai.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @program:   
 * @description: test dto
 * @author:  旷智仁
 **/
@Data
public class TestSendDto {
    
    private Long count;
    
    @Schema(name ="message", type ="String", description ="消息",requiredMode= RequiredMode.REQUIRED)
    @NotBlank
    private String message;
    
    private Long time;
}
