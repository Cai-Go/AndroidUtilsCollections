package com.myandroid.wzh.utilscollections.AppUtil;

import android.app.Activity;

import java.util.Stack;

/**
 * @author W.Z.H
 * @time 2018/6/11 9:15
 * @description Activity 的管理与回收
 */

public class AppActivityMgrUtil {

    //存储ActivityStack
    private static Stack<Activity> activityStack = new Stack<Activity>();

    //单例模式
    private static AppActivityMgrUtil instance;


    /**
     * 单例堆栈集合对象
     *
     * @return AppActivityMgrUtil 单例堆栈集合对象
     */
    public static AppActivityMgrUtil getScreenManager() {
        if (instance == null) {
            synchronized (AppActivityMgrUtil.class) {
                if (instance == null) {
                    instance = new AppActivityMgrUtil();
                }
            }
        }
        return instance;
    }


    /**
     * 堆栈中销毁并移除
     *
     * @param activity 指定AC对象
     */
    public void removeActivity(Activity activity) {
        if (null != activity) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 栈中销毁并移除所以ac对象
     */
    public void removeAllActivity() {
        if (null != activityStack && activityStack.size() > 0) {
            //创建临时集合对象
            Stack<Activity> activityTemp = new Stack<>();
            for (Activity activity : activityStack) {
                if (null != activity) {
                    //添加到临时集合
                    activityTemp.add(activity);
                    //结束activity
                    activity.finish();
                }
            }
            activityStack.removeAll(activityTemp);
        }
        System.gc();
        System.exit(0);
    }


    /**
     * 获取当前ac对象
     *
     * @return Activity 当前 ac
     */
    public Activity currentActivity() {
        Activity activity = null;
        if (!activityStack.empty()) {
            activity = activityStack.lastElement();
        }
        return activity;
    }


    /**
     * 获得当前 ac 类名
     *
     * @return
     */
    public String getCurrentActivityName() {
        String activityName = "";
        if (!activityStack.empty()) {
            activityName = activityStack.lastElement()
                    .getClass()
                    .getSimpleName();
        }
        return activityName;
    }


    /**
     * 将 ac 纳入到堆栈集合中
     *
     * @param activity ac 对象
     */
    public void addActivity(Activity activity) {
        if (null == activityStack) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * 退出栈中所有 activity
     *
     * @param cls
     */
    public void exitApp(Class<?> cls) {
        while (true) {
            Activity activity = currentActivity();
            if (null == activity) {
                break;
            }
            if (activity.getClass().equals(cls)) {
                break;
            }
            removeActivity(activity);
        }
        System.gc();
        System.exit(0);
    }

}
