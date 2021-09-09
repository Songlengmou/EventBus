package com.example.eventbus.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.eventbus.R;

import rx.Observable;

/**
 * @author Administrator
 * desc:使用RxJava和RxAndroid封装RxBus，实现EventBus功能
 * https://blog.csdn.net/qq_33689414/article/details/51586250
 * <p>
 * 第一种方法
 */
public class MainActivity extends AppCompatActivity {
    private Observable<String> observable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SecondActivity.class)));
        observable = RxBus.get().register("data", String.class);
        observable.subscribe(smg -> Log.e("data", "+++++++++++++++++++++++++++++++" + smg));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("data", observable);
    }
}