package com.example.testmvvm;

import android.text.Editable;
import android.util.Log;
import android.view.View;

import com.example.testmvvm.databinding.ActivityMainBinding;

public class Handlers {
    private ActivityMainBinding activityMainBinding;

    public Handlers(ActivityMainBinding activityMainBinding) {
        this.activityMainBinding = activityMainBinding;
    }

    public void clickName(View view){
        Log.e("收到name的点击事件","===");
        activityMainBinding.getUser().setName("我是更新后的名字");
    }
    public void afterInputChange(Editable editable){
        Log.e("收到输入框文字变化事件",""+editable.toString());
        activityMainBinding.getUser().setPass(""+editable.toString());
    }
}
