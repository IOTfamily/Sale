package com.iot.sale.Service.service;

import com.iot.sale.Base.util.Sms;
import com.iot.sale.Service.dao.FruitVcodeDao;
import com.iot.sale.Service.entity.FruitVcode;
import com.iot.sale.Service.util.CheckUtil;
import com.iot.sale.Service.util.VcodeUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/12/21
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
public interface SmsService {
    //默认渠道
    public static final String CHANNEL = "Alidayu";

    /**
     * 发送短信入口,自行根据规则进行分流
     * @param mobile
     * @param tmplNo
     * @return
     */
    public Boolean sendSms(String mobile, String tmplNo, Map<String,Object> parameter);


    public Map<String,Object> createVcode(String mobile);

    public Boolean isValidCode(String mobile,String vcode);

//    /**
//     * 获取合适的驱动配置
//     * @param $mobile string 电话号码
//     *
//     * @return array 返回合适的驱动配置
//     */
//    public static function config($mobile,$tmpl_no) {
//        $switch_chanel = C('SWITCH_CHANEL');
//        $chanel = self::$chanel;
//        if(in_array($tmpl_no,$switch_chanel)) {
//            //获取有无发送失败短信
//            $vcode = M('Vcode')->where(['status' => 0,'mobile' => $mobile])->find();
//            if(!empty($vcode)) {
//                $chanel = ($vcode['chanel'] == 'Alidayu')?'MdSms':'Alidayu';
//                M('Vcode')->where(['status' => 0,'mobile' => $mobile])->save(['chanel' => $chanel]);
//            }
//        }
//        return C('SMS_CONFIG')[$chanel];
//    }
}
