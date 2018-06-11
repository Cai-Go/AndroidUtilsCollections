package com.myandroid.wzh.utilscollections.AppUtil;

/**
 * @author W.Z.H
 * @time 2018/6/11 16:07
 * @description 防止点击事件重复提交
 */
public class SingleClick {

    private static final int DEFAULT_TIME = 600;
    private static long lastTime;

    public static boolean isSingle() {
        boolean isSingle;
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime <= DEFAULT_TIME) {
            isSingle = true;
        } else {
            isSingle = false;
        }
        lastTime = currentTime;

        return isSingle;
    }
}
