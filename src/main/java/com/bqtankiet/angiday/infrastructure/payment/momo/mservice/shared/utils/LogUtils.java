package com.bqtankiet.angiday.infrastructure.payment.momo.mservice.shared.utils;


import lombok.extern.slf4j.Slf4j;

/***
 * @author uyen.tran
 */
@Slf4j
public class LogUtils {

    public static void info(String serviceCode, Object object){
        log.info(String.valueOf(new StringBuilder().append("[").append(serviceCode).append("]: ").append(object)));
    }
    public static void info(Object object){
        log.info(object.toString());
    }

    public static void debug(Object object){
        log.debug(object.toString());
    }

    public static void error(Object object){
        log.error(object.toString());
    }

    public static void warn(Object object){
        log.warn(object.toString());
    }
}
