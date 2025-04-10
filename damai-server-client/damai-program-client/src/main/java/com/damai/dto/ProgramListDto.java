package com.damai.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

/**
 * @program:
 * @description: 主页节目列表查询 dto
 * @author:  旷智仁
 **/
@Data
@Schema(title="ProgramListDto", description ="主页节目列表")
public class ProgramListDto {
    
    @Schema(name ="areaId", type ="Long", description ="所在区域id")
    private Long areaId;
    
    @Schema(name ="parentProgramCategoryIds", type ="Long[]", description ="父节目类型id集合",requiredMode= RequiredMode.REQUIRED)
    @NotNull
    @Size(max = 4)
    private List<Long> parentProgramCategoryIds;
}
