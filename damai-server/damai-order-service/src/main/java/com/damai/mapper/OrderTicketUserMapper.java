package com.damai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.damai.entity.OrderTicketUser;
import com.damai.entity.OrderTicketUserAggregate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program:
 * @description: 购票人订单 mapper
 * @author:  旷智仁
 **/
public interface OrderTicketUserMapper extends BaseMapper<OrderTicketUser> {
    
    /**
     * 查询订单下购票人数量
     * @param orderNumberList 参数
     * @return 结果
     * */
    List<OrderTicketUserAggregate> selectOrderTicketUserAggregate(@Param("orderNumberList")List<Long> orderNumberList);
    
    /**
     * 真实删除购票人订单数据
     * @return 结果
     * */
    Integer relDelOrderTicketUser();

}
