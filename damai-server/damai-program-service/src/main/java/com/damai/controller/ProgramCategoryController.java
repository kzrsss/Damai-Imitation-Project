package com.damai.controller;

import com.damai.common.ApiResponse;
import com.damai.dto.ParentProgramCategoryDto;
import com.damai.dto.ProgramCategoryAddDto;
import com.damai.dto.ProgramCategoryDto;
import com.damai.service.ProgramCategoryService;
import com.damai.vo.ProgramCategoryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program:
 * @description: 节目类型 控制层
 * @author:  旷智仁
 **/
@RestController
@RequestMapping("/program/category")
@Tag(name = "program-category", description = "节目类型")
public class ProgramCategoryController {
    
    @Autowired
    private ProgramCategoryService programCategoryService;
    
    @Operation(summary  = "查询所有节目类型")
    @PostMapping (value = "/select/all")
    public ApiResponse<List<ProgramCategoryVo>> selectAll() {
        return ApiResponse.ok(programCategoryService.selectAll());
    }
    
    @Operation(summary  = "通过类型查询节目类型")
    @PostMapping(value = "/selectByType")
    public ApiResponse<List<ProgramCategoryVo>> selectByType(@Valid @RequestBody ProgramCategoryDto programCategoryDto) {
        return ApiResponse.ok(programCategoryService.selectByType(programCategoryDto));
    }
    
    @Operation(summary  = "通过父节目类型查询子节目类型")
    @PostMapping(value = "/selectByParentProgramCategoryId")
    public ApiResponse<List<ProgramCategoryVo>> selectByParentProgramCategoryId(@Valid @RequestBody ParentProgramCategoryDto parentProgramCategoryDto) {
        return ApiResponse.ok(programCategoryService.selectByParentProgramCategoryId(parentProgramCategoryDto));
    }
    
    @Operation(summary  = "批量添加节目类型")
    @PostMapping(value = "/save/batch")
    public ApiResponse<Void> saveBatch(@Valid @RequestBody List<ProgramCategoryAddDto> programCategoryAddDtoList) {
        programCategoryService.saveBatch(programCategoryAddDtoList);
        return ApiResponse.ok();
    }
}
