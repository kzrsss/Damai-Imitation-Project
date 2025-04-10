package com.damai.service.composite;

import com.damai.dto.ProgramGetDto;
import com.damai.enums.BaseCode;
import com.damai.enums.CompositeCheckType;
import com.damai.exception.DaMaiFrameException;
import com.damai.handler.BloomFilterHandler;
import com.damai.initialize.impl.composite.AbstractComposite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program:
 * @description: 节目详情查询验证
 * @author:  旷智仁
 **/
@Component
public class ProgramBloomFilterCheckHandler extends AbstractComposite<ProgramGetDto> {
    
    @Autowired
    private BloomFilterHandler bloomFilterHandler;
    
    @Override
    protected void execute(final ProgramGetDto param) {
        boolean contains = bloomFilterHandler.contains(String.valueOf(param.getId()));
        if (!contains) {
            throw new DaMaiFrameException(BaseCode.PROGRAM_NOT_EXIST);
        }
    }
    
    @Override
    public String type() {
        return CompositeCheckType.PROGRAM_DETAIL_CHECK.getValue();
    }
    
    @Override
    public Integer executeParentOrder() {
        return 0;
    }
    
    @Override
    public Integer executeTier() {
        return 1;
    }
    
    @Override
    public Integer executeOrder() {
        return 1;
    }
}
