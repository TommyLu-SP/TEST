package com.lu.lifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static int status = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG_MA","TAG_onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG_MA","TAG_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG_MA","TAG_onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG_MA","TAG_onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG_MA","TAG_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG_MA","TAG_onStop");
        status = 1;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG_MA","TAG_onDestroy");
    }

}