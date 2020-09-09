/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package com.huawei.healthkit.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;


/**
 * Third-party Demo program page
 */
public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private Button btnRequestAuth, btnQuery;

    private TextView tvRestult;

    private MyHandler mHandler = new MyHandler();

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindDataView();
        setOnClickListener();
    }

    private void setOnClickListener() {

    }


    private void bindDataView() {
        mContext = this;
        btnRequestAuth = findViewById(R.id.btn_click_11);
        btnQuery = findViewById(R.id.btn_click_33);
        tvRestult = findViewById(R.id.result_view);
    }

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg == null) {
                return;
            }
            handleMessageInfo(msg);
        }

        private void handleMessageInfo(Message msg) {
            String deviceList01 = String.valueOf(msg.obj);
            tvRestult.setText(deviceList01);
        }
    }

    public void sendMsg(String result) {
        Message message = Message.obtain();
        message.obj = result;
        mHandler.sendMessage(message);
    }

    public void combineResult(int resultCode, Object object) {
        StringBuilder sb = new StringBuilder();
        sb.append("resultCode = ").append(resultCode);
        sb.append(" result = ").append(object);
        sendMsg(sb.toString());
    }
}