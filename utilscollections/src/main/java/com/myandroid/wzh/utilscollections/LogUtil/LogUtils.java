package com.myandroid.wzh.utilscollections.LogUtil;


import android.util.Log;

import com.myandroid.wzh.utilscollections.BuildConfig;

/**
 * @author W.Z.H
 * @time 2018/6/8 16:20
 * @description Log日志类
 */
public class LogUtils {

    //类名
    public static String className;
    //方法名
    public static String methodName;
    // 行数
    public static int lineNumber;

    private LogUtils() {

    }

    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }


    /**
     * 创建日志
     *
     * @param log
     * @return
     */
    private static String createLog(String log) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(methodName);
        stringBuffer.append("(")
                .append(className)
                .append(":")
                .append(lineNumber)
                .append(")");
        stringBuffer.append(log);
        return stringBuffer.toString();
    }

    /**
     * 获取方法名
     *
     * @param elements
     */
    private static void getMethodNames(StackTraceElement[] elements) {
        className = elements[1].getFileName();
        methodName = elements[1].getMethodName();
        lineNumber = elements[1].getLineNumber();
    }


    /**
     * @param error
     */
    public static void e(String error) {
        if (!isDebug()) {
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        Log.e(className, createLog(error));
    }


    /**
     * @param info
     */
    public static void i(String info) {
        if (!isDebug()) {
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        Log.i(className, createLog(info));
    }

    /**
     * @param debug
     */
    public static void d(String debug) {
        if (!isDebug()) {
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        Log.d(className, createLog(debug));
    }

    /**
     * @param verbose
     */
    public static void v(String verbose) {
        if (!isDebug()) {
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        Log.v(className, createLog(verbose));
    }

    /**
     * @param warning
     */
    public static void w(String warning) {
        if (!isDebug()) {
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        Log.w(className, createLog(warning));
    }

    /**
     * @param message
     */
    public static void wtf(String message) {
        if (!isDebug()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(className, createLog(message));
    }

}
