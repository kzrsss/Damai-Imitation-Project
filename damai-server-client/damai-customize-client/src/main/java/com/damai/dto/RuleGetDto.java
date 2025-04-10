package com.damai.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @program:
 * @description: 普通规则查询 dto
 * @author:  旷智仁
 **/
@Data
@Schema(title="RuleGetDto", description ="普通规则查询")
public class RuleGetDto {
    
    @Schema(name ="id", type ="String", description ="普通规则id", requiredMode= RequiredMode.REQUIRED)
    @NotNull
    private Long id;
}
