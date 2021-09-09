package com.example.eventbus.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.eventbus.R;

import org.greenrobot.eventbus.EventBus;

/**
 * @author Administrator
 */
public class FourthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        findViewById(R.id.tv_four).setOnClickListener(view -> {
            EventBusMessageBean msg = new EventBusMessageBean(EventBusMessageBean.TEST_TYPE, "yp8023zl");
            EventBus.getDefault().post(msg);
            Log.e("TAG_fa", String.valueOf(msg.date));
        });
    }
}