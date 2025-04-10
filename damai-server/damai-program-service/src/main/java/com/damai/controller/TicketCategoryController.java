package com.damai.controller;

import com.damai.common.ApiResponse;
import com.damai.dto.TicketCategoryAddDto;
import com.damai.dto.TicketCategoryDto;
import com.damai.service.TicketCategoryService;
import com.damai.vo.TicketCategoryDetailVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program:
 * @description: 票档 控制层
 * @author:  旷智仁
 **/
@RestController
@RequestMapping("/ticket/category")
@Tag(name = "ticket-category", description = "票档")
public class TicketCategoryController {
    
    @Autowired
    private TicketCategoryService ticketCategoryService;
    
    
    @Operation(summary  = "添加")
    @PostMapping(value = "/add")
    public ApiResponse<Long> add(@Valid @RequestBody TicketCategoryAddDto ticketCategoryAddDto) {
        return ApiResponse.ok(ticketCategoryService.add(ticketCategoryAddDto));
    }
    
    @Operation(summary  = "查询详情")
    @PostMapping(value = "/detail")
    public ApiResponse<TicketCategoryDetailVo> detail(@Valid @RequestBody TicketCategoryDto ticketCategoryDto) {
        return ApiResponse.ok(ticketCategoryService.detail(ticketCategoryDto));
    }
}
