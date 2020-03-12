package com.example.testmvvm;

import java.util.List;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableList;

public class User extends BaseObservable {
    private String name;
    private String pass;
    private int viewType;
    //bean的内部子bean
    private ObservableList<InnerBean> innerBeans;

    //设置这个才能自动更新-1
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //设置这个才能自动更新-2
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
        notifyPropertyChanged(BR.pass);
    }


    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public ObservableList<InnerBean> getInnerBeans() {
        return innerBeans;
    }

    public void setInnerBeans(ObservableList<InnerBean> innerBeans) {
        this.innerBeans = innerBeans;
    }
}
