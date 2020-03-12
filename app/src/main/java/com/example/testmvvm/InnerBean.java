package com.example.testmvvm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class InnerBean  extends BaseObservable {
    private String innerName;
    private int viewType;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public InnerBean(String innerName) {
        this.innerName = innerName;
    }
    @Bindable
    public String getInnerName() {
        return innerName;
    }

    public void setInnerName(String innerName) {
        this.innerName = innerName;
        notifyPropertyChanged(BR.innerName);
    }
}
