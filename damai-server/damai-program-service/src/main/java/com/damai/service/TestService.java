package com.damai.service;

import com.baidu.fsg.uid.utils.PaddedAtomicLong;
import com.damai.dto.TestSendDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program:
 * @description: Test service
 * @author:  旷智仁
 **/
@Slf4j
@Service
public class TestService {
    
    AtomicLong count = new PaddedAtomicLong(0);
    
    public Boolean reset(final TestSendDto testSendDto) {
        count.set(0);
        return true;
    }
}
