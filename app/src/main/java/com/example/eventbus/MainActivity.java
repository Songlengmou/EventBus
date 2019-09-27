package com.example.eventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import rx.Observable;
import rx.functions.Action1;

/**
 * @author Administrator
 * desc:使用RxJava和RxAndroid封装RxBus，实现EventBus功能
 * https://blog.csdn.net/qq_33689414/article/details/51586250
 */
public class MainActivity extends AppCompatActivity {
    private Observable<String> zhang;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SecondActivity.class)));
        zhang = RxBus.get().register("zhang", String.class);
        zhang.subscribe(s -> Log.e("zhang", "+++++++++++++++++++++++++++++++" + s));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("zhang", zhang);
    }
}
