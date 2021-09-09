package com.example.eventbus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eventbus.one.MainActivity;
import com.example.eventbus.two.ThirdActivity;

/**
 * @author Administrator
 */
public class ClassificationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        initView();
    }

    private void initView() {
        Button mBtnOne = findViewById(R.id.btn_one);
        mBtnOne.setOnClickListener(this);
        Button mBtnTwo = findViewById(R.id.btn_two);
        mBtnTwo.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                startActivity(new Intent(ClassificationActivity.this, MainActivity.class));
                break;
            case R.id.btn_two:
                startActivity(new Intent(ClassificationActivity.this, ThirdActivity.class));
                break;
            default:
                break;
        }
    }
}