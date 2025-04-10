package com.damai.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.damai.dto.ProgramListDto;
import com.damai.dto.ProgramPageListDto;
import com.damai.entity.Program;
import com.damai.entity.ProgramJoinShowTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program:
 * @description: 节目 mapper
 * @author:  旷智仁
 **/
public interface ProgramMapper extends BaseMapper<Program> {
    
    /**
     * 主页查询
     * @param programListDto 参数
     * @return 结果
     * */
    List<Program> selectHomeList(@Param("programListDto")ProgramListDto programListDto);
    
    /**
     * 分页查询
     * @param page 分页对象
     * @param programPageListDto 参数
     * @return 结果
     * */
    IPage<ProgramJoinShowTime> selectPage(IPage<ProgramJoinShowTime> page, 
                                          @Param("programPageListDto")ProgramPageListDto programPageListDto);
}
