package com.damai.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @program:
 * @description: 所有规则 vo
 * @author:  旷智仁
 **/
@Data
@Schema(title="AllDepthRuleVo", description ="全部规则")
public class AllDepthRuleVo {
    
    @Schema(name ="ruleDto", type ="RuleDto", description ="普通规则")
    private RuleVo ruleVo;
    
    @Schema(name ="depthRuleDtoList", type ="DepthRuleDto[]", description ="深度规则")
    private List<DepthRuleVo> depthRuleVoList;
}
