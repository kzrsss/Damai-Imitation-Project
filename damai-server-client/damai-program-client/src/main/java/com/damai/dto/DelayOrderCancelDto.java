package com.damai.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @program:
 * @description: 延迟订单取消 dto
 * @author:  旷智仁
 **/
@Data
@Schema(title="DelayOrderCancelDto", description ="延迟订单取消")
public class DelayOrderCancelDto {
    
    @Schema(name ="orderNumber", type ="Long", description ="订单编号",requiredMode= RequiredMode.REQUIRED)
    @NotNull
    private Long orderNumber;
}
