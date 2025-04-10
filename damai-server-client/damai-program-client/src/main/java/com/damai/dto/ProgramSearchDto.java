package com.damai.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @program:
 * @description: 节目搜索 dto
 * @author:  旷智仁
 **/
@Data
@Schema(title="ProgramSearchDto", description ="节目搜索")
public class ProgramSearchDto extends ProgramPageListDto{
    
    @Schema(name ="content", type ="String", description ="搜索内容")
    private String content;
}
