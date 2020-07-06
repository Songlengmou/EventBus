package com.example.eventbus.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.eventbus.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author Administrator
 * lai: https://blog.csdn.net/huyangsk/article/details/70896201
 */
public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        //注册
        EventBus.getDefault().register(this);

        findViewById(R.id.btn_in).setOnClickListener(view -> {
            EventBus.getDefault().post("我发射了");
        });
    }

    /**
     * 自定义一个方法
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void hello(String event) {
        Toast.makeText(this, event, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册 , 防止Activity内存泄漏
        EventBus.getDefault().unregister(this);
    }
}
