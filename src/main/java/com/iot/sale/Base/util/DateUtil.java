package com.iot.sale.Base.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/12/17
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
public class DateUtil {
    /**
     * 获取格式化的时间
     * 输出格式：2015-08-04 20:55:35
     */
    public String getFormatDate(){
        Date date = new Date();
        long times = date.getTime();//时间戳
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }
}
