package com.myandroid.wzh.utilscollections.LogUtil.KLog;


import android.text.TextUtils;
import android.util.Log;

/**
 * @author W.Z.H
 * @time 2018/6/11 14:51
 * @description
 */
public class KLogUtil {
    public static boolean isEmpty(String line) {
        return TextUtils.isEmpty(line) || line.equals("\n") || line.equals("\t") || TextUtils.isEmpty(line.trim());
    }

    public static void printLine(String tag, boolean isTop) {
        if (isTop) {
            Log.d(tag, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            Log.d(tag, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }
}
