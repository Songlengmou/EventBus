package com.example.eventbus.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.eventbus.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author Administrator
 */
public class SeventhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);
        //注册
        EventBus.getDefault().register(this);

        findViewById(R.id.btn_return).setOnClickListener(view -> onBackPressed());
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onMessageEventMainThread(String event) {
        Log.e("event MainThread", "消息： " + event + "  thread: " + Thread.currentThread().getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册 , 防止Activity内存泄漏
        EventBus.getDefault().unregister(this);
    }
}
