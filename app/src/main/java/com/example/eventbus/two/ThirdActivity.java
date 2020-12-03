package com.example.eventbus.two;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eventbus.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 第二种方法，引入implementation 'org.greenrobot:eventbus:3.0.0'
 *
 * @author Administrator
 */
public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnIn;
    private Button mBtnOne;
    private Button mBtnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        mBtnIn = findViewById(R.id.btn_in);
        mBtnOne = findViewById(R.id.btn_one);
        mBtnTwo = findViewById(R.id.btn_two);
        mBtnIn.setOnClickListener(this);
        mBtnOne.setOnClickListener(this);
        mBtnTwo.setOnClickListener(this);

        EventBus.getDefault().register(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_in:
                startActivity(new Intent(ThirdActivity.this, FourthActivity.class));
                break;
            case R.id.btn_one:
                startActivity(new Intent(ThirdActivity.this, FifthActivity.class));
                break;
            case R.id.btn_two:
                startActivity(new Intent(ThirdActivity.this, SixthActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(EventBusMessageBean messageEvent) {
        if (EventBusMessageBean.TEST_TYPE == EventBusMessageBean.TEST_TYPE) {
            String date = (String) messageEvent.date;
            Log.e("TAG_Receive", date);
        }
    }
}
