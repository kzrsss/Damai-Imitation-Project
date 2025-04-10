package com.damai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.damai.dto.ApiDataDto;
import com.damai.entity.ApiData;
import com.damai.vo.ApiDataVo;

/**
 * @program:
 * @description: api调用记录 mapper
 * @author:  旷智仁
 **/
public interface ApiDataMapper extends BaseMapper<ApiData> {
    /**
     * 分页查询
     * @param page 分页对象
     * @param apiDataDto 参数
     * @return 分页数据
     * */
    Page<ApiDataVo> pageList(Page<ApiData> page, ApiDataDto apiDataDto);
}
