package com.damai.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @program:
 * @description: 订单列表查询 dto
 * @author:  旷智仁
 **/
@Data
@Schema(title="OrderListDto", description ="订单列表查询")
public class OrderListDto {
    
    @Schema(name ="userId", type ="Long", description ="用户id", requiredMode= RequiredMode.REQUIRED)
    @NotNull
    private Long userId;
    
}
