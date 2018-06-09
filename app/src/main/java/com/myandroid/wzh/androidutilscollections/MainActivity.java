package com.myandroid.wzh.androidutilscollections;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.myandroid.wzh.utilscollections.ToastUtil.ToastUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastUtils.toastShortShow(this,"sssssss");
    }
}
