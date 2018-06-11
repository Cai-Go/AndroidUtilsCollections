package com.myandroid.wzh.utilscollections.AppUtil;


import android.content.Context;
import android.content.Intent;

import com.myandroid.wzh.utilscollections.R;
import com.myandroid.wzh.utilscollections.ToastUtil.ToastUtils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author W.Z.H
 * @time 2018/6/11 13:32
 * @escription 退出 app
 */
public class ExitAppUtil {
    private static Boolean isExit = false;

    public static boolean isExitApp(Context context) {
        Timer mEixt = null;
        if (isExit == false) {
            isExit = true;
            ToastUtils.toastShortShow(context,
                    context.getResources().getString(R.string.sys_exit_tip));
            //创建定时器
            mEixt = new Timer();

            // 如果2秒钟内没有按下返回键则启动定时器取消刚才执行的任务
            mEixt.schedule(new TimerTask() {
                @Override
                public void run() {
                    //取消退出
                    isExit = false;
                }
            }, 2000);
        } else {
            AppActivityMgrUtil.getScreenManager().removeAllActivity();
            //创建 ACTION_MAIN
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Context content = context;
            //启动 ACTION_MAIN
            content.startActivity(intent);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
        return isExit;
    }
}
