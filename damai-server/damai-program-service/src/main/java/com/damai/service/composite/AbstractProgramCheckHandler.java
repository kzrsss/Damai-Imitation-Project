package com.damai.service.composite;

import com.damai.dto.ProgramOrderCreateDto;
import com.damai.enums.CompositeCheckType;
import com.damai.initialize.impl.composite.AbstractComposite;

/**
 * @program:
 * @description: 生成节目订单验证基类，生成节目订单的相关验证逻辑继承此类
 * @author:  旷智仁
 **/
public abstract class AbstractProgramCheckHandler extends AbstractComposite<ProgramOrderCreateDto> {
    
    @Override
    public String type() {
        return CompositeCheckType.PROGRAM_ORDER_CREATE_CHECK.getValue();
    }
}
