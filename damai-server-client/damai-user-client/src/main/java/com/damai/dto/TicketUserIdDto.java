package com.damai.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
/**
 * @program:
 * @description: 购票人id dto
 * @author:  旷智仁
 **/
@Data
@Schema(title="TicketUserIdDto", description ="购票人id入参")
public class TicketUserIdDto {
    
    @Schema(name ="id", type ="Long", description ="购票人id", requiredMode= RequiredMode.REQUIRED)
    @NotNull
    private Long id;
}