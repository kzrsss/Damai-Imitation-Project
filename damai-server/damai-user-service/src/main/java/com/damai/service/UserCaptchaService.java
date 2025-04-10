package com.damai.service;

import com.damai.captcha.model.common.ResponseModel;
import com.damai.captcha.model.vo.CaptchaVO;
import com.baidu.fsg.uid.UidGenerator;
import com.damai.core.RedisKeyManage;
import com.damai.redis.RedisKeyBuild;
import com.damai.service.lua.CheckNeedCaptchaOperate;
import com.damai.vo.CheckNeedCaptchaDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 判断是否需要验证码
 * @author:  旷智仁
 **/
@Service
public class UserCaptchaService {
    
    @Value("${verify_captcha_threshold:10}")
    private int verifyCaptchaThreshold;
    
    @Value("${verify_captcha_id_expire_time:60}")
    private int verifyCaptchaIdExpireTime;
    
    @Value("${always_verify_captcha:0}")
    private int alwaysVerifyCaptcha;
    
    @Autowired
    private CaptchaHandle captchaHandle;
    
    @Autowired
    private UidGenerator uidGenerator;
    
    @Autowired
    private CheckNeedCaptchaOperate checkNeedCaptchaOperate;
    
    public CheckNeedCaptchaDataVo checkNeedCaptcha() {
        //时间戳和唯一ID的获取
        long currentTimeMillis = System.currentTimeMillis();
        long id = uidGenerator.getUid();
        List<String> keys = new ArrayList<>();
        //这里构造了一个包含三个Redis键的列表：
        //COUNTER_COUNT：可能是用于计数的键。
        //COUNTER_TIMESTAMP：可能是用于记录时间戳的键。
        //VERIFY_CAPTCHA_ID：与生成的唯一ID相关联的键，可能是用于存储验证码信息。
        keys.add(RedisKeyBuild.createRedisKey(RedisKeyManage.COUNTER_COUNT).getRelKey());
        keys.add(RedisKeyBuild.createRedisKey(RedisKeyManage.COUNTER_TIMESTAMP).getRelKey());
        keys.add(RedisKeyBuild.createRedisKey(RedisKeyManage.VERIFY_CAPTCHA_ID,id).getRelKey());
        String[] data = new String[4];
        data[0] = String.valueOf(verifyCaptchaThreshold);
        data[1] = String.valueOf(currentTimeMillis);
        data[2] = String.valueOf(verifyCaptchaIdExpireTime);
        data[3] = String.valueOf(alwaysVerifyCaptcha);
        Boolean result = checkNeedCaptchaOperate.checkNeedCaptchaOperate(keys, data);
        CheckNeedCaptchaDataVo checkNeedCaptchaDataVo = new CheckNeedCaptchaDataVo();
        checkNeedCaptchaDataVo.setCaptchaId(id);
        checkNeedCaptchaDataVo.setVerifyCaptcha(result);
        return checkNeedCaptchaDataVo;
    }
    
    public ResponseModel getCaptcha(CaptchaVO captchaVO) {
        return captchaHandle.getCaptcha(captchaVO);
    }
    
    public ResponseModel verifyCaptcha(final CaptchaVO captchaVO) {
        return captchaHandle.checkCaptcha(captchaVO);
    }
}
