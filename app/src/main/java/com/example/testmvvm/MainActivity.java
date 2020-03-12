package com.example.testmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<User> datas;
    RecycleviewAdapter recycleviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.testmvvm.databinding.ActivityMainBinding activityMainBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_main);


        //设置recycleview的数据
        datas = new ObservableArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("第" + (i + 1) + "的名字");
            user.setPass("第" + (i + 1) + "的密码");
            datas.add(user);
        }

//实例化adapter
        recycleviewAdapter = new RecycleviewAdapter(datas, MainActivity.this);
        recycleviewAdapter.setOnItemClickListener(new RecycleviewAdapter.OnItemClickListener() {
            @Override
            public void onClick(User index) {
                Log.e("点击的位置", index.getName() + "");
                for (int i = 0; i < 5; i++) {
                    User user = new User();
                    user.setName("点击后" + (i + 1) + "的名字");
                    user.setPass("点击后" + (i + 1) + "的密码");
                    datas.add(user);
                    recycleviewAdapter.notifyDataSetChanged();
                }
            }
        });
        //给recycleview设置adapter等
        activityMainBinding.recycleview.setAdapter(recycleviewAdapter);
        activityMainBinding.recycleview.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));


        //文字的显示
        User user = new User();
        user.setName("name");
        user.setPass("pass");

        activityMainBinding.setUser(user);
//点击事件的设置
        activityMainBinding.setHandlers(new Handlers(activityMainBinding));

    }
}
