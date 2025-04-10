package com.damai.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @program:   
 * @description: 节目数据重置 dto
 * @author:  旷智仁
 **/
@Data
@Schema(title="ProgramResetExecuteDto", description ="节目数据重置")
public class ProgramResetExecuteDto {
    
    @Schema(name ="programId", type ="Long", description ="节目id",requiredMode= RequiredMode.REQUIRED)
    @NotNull
    private Long programId;
}
