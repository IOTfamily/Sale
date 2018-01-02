package com.iot.sale.util;

import org.junit.Test;

import java.util.Random;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/12/21
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description: 建议填写
 ******************************************/
public class FunTest {

    @Test
    public void random(){
        Integer length = 6;
        StringBuilder randCode = new StringBuilder();
        while (randCode.length() < length) {
            Random rand =new Random();
            System.out.println(rand.nextInt(10));

            randCode.append(rand.nextInt(10));
        }
        System.out.println(randCode.toString());
    }

    @Test
    public void log(){
        log();
    }
}
