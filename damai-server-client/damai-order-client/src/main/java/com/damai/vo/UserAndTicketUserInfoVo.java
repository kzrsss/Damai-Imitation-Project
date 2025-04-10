package com.damai.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
/**
 * @program:
 * @description: 用户和购票人 vo
 * @author:  旷智仁
 **/
@Data
@Schema(title="UserAndTicketUserInfoVo", description ="用户和购票人集合数据")
public class UserAndTicketUserInfoVo {
    
    @Schema(name ="userInfoVo", type ="UserInfoVo", description ="用户")
    private UserInfoVo userInfoVo;
    
    @Schema(name ="ticketUserInfoVoList", type ="List<TicketUserInfoVo>", description ="购票人集合")
    private List<TicketUserInfoVo> ticketUserInfoVoList;
}
