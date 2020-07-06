package com.example.eventbus.two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.eventbus.R;

import org.greenrobot.eventbus.EventBus;

/**
 * @author Administrator
 */
public class SixthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        findViewById(R.id.btn_in).setOnClickListener(v -> {
            Log.e("event 发射数据线程 : ", Thread.currentThread().getName());
            EventBus.getDefault().postSticky("我发射了");
            startActivity(new Intent(SixthActivity.this, SeventhActivity.class));
        });
    }
}
