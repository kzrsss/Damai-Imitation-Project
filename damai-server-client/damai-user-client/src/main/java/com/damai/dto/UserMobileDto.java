package com.damai.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
/**
 * @program:
 * @description: 用户手机号 dto
 * @author:  旷智仁
 **/
@Data
@Schema(title="UserMobileDto", description ="用户手机号入参")
public class UserMobileDto {
    
    @Schema(name ="name", type ="String", description ="用户手机号", requiredMode= RequiredMode.REQUIRED)
    @NotBlank
    private String mobile;
}