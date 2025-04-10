package com.damai.service.lua;

import com.damai.vo.SeatVo;
import lombok.Data;

import java.util.List;

/**
 * @program:
 * @description: 节目缓存更新 实体
 * @author:  旷智仁
 **/
@Data
public class ProgramCacheCreateOrderData {

    private Integer code;
    
    private List<SeatVo> purchaseSeatList;
}
