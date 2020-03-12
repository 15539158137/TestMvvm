package com.example.testmvvm.use_github;

import android.os.Bundle;

import com.example.testmvvm.InnerBean;
import com.example.testmvvm.R;
import com.example.testmvvm.User;
import com.example.testmvvm.databinding.GithubActivityBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

public class GitHubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GithubActivityBinding githubActivityBinding= DataBindingUtil.setContentView(this, R.layout.github_activity);

        GithubModel recycleviewModel=new GithubModel();


        ObservableList<User> users=new ObservableArrayList<>();
        for(int i=0;i<5;i++){
            User user=new User();
            ObservableList<InnerBean> innerBeans=new ObservableArrayList<>();
            for (int j=0;j<4;j++){
                InnerBean innerBean=new InnerBean("子view"+j);
                //如果上面是1 那里面的item也需要是1 建立对应关系
                if(i%2==1){
                    innerBean.setViewType(1);
                }
                innerBeans.add(innerBean);
            }
            user.setInnerBeans(innerBeans);
            user.setName("item"+i);
            if(i%2==1){
                user.setViewType(1);
            }
            users.add(user);
        }
        recycleviewModel.setItems(users);
        githubActivityBinding.setRecycleViewmodel(recycleviewModel);



    }
}
