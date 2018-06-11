package com.myandroid.wzh.utilscollections.AppUtil;


import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * @author W.Z.H
 * @time 2018/6/11 15:27
 * @description 键盘管理
 */
public class AppKeyBoardMgr {
    /**
     * 打开软键盘
     *
     * @param mEditText 输入框
     * @param mContext  上下文
     */
    public static void openKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 关闭软键盘
     *
     * @param mEditText 输入框
     * @param mContext  上下文
     */
    public static void closeKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }

    /**
     * 输入法是否显示
     */
    public static boolean KeyBoard(EditText edittext) {
        boolean bool = false;
        InputMethodManager imm = (InputMethodManager) edittext
                .getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            bool = true;
        }
        return bool;
    }

    /**
     * 切换软键盘的状态
     * 如当前为收起变为弹出,若当前为弹出变为收起
     */
    public static void toggleKeybord(EditText edittext) {
        InputMethodManager inputMethodManager = (InputMethodManager)
                edittext.getContext()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0,
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 强制隐藏输入法键盘
     */
    public static void hideKeybord(EditText edittext) {
        InputMethodManager inputMethodManager = (InputMethodManager)
                edittext.getContext()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(edittext.getWindowToken(), 0);
        }
    }

    /**
     * 强制显示输入法键盘
     */
    public static void showKeybord(EditText edittext) {
        InputMethodManager inputMethodManager = (InputMethodManager)
                edittext.getContext()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(edittext, InputMethodManager.SHOW_FORCED);
    }

    /**
     * 输入法是否显示
     */
    public static boolean isKeybord(EditText edittext) {
        boolean bool = false;
        InputMethodManager inputMethodManager = (InputMethodManager)
                edittext.getContext()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            bool = true;
        }
        return bool;
    }

    /**
     * 隐藏输入法
     *
     * @param activity activity
     */
    public static void hideInputMethod(Activity activity) {
        try {// hide keybord anyway
            View v = activity.getWindow()
                    .getCurrentFocus();
            if (v != null) {
                InputMethodManager imm = (InputMethodManager) activity
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /**
     * 显示输入法
     *
     * @param mAct activity
     */
    public static void showInputMethod(final Activity mAct) {
        View v = mAct.getCurrentFocus();
        if (null == v) {
            return;
        }
        ((InputMethodManager) mAct
                .getSystemService(Activity.INPUT_METHOD_SERVICE))
                .showSoftInput(v, 0);
    }
}
