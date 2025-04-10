package com.damai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.damai.entity.DepthRule;

/**
 * @program:   
 * @description: 深度规则 mapper
 * @author:  旷智仁
 **/
public interface DepthRuleMapper extends BaseMapper<DepthRule> {
    
    /**
     * 删除所有规则
     * @return 结果
     * */
    int delAll();
}
