package com.example.testmvvm.use_github;

import android.util.Log;

import com.example.testmvvm.BR;
import com.example.testmvvm.InnerBean;
import com.example.testmvvm.R;
import com.example.testmvvm.User;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

public class ItemRecycleviewModel {
    //多item时候的显示
    public final OnItemBind<InnerBean> onItemBind = new OnItemBind<InnerBean>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, InnerBean item) {
            if (item.getViewType() == 0) {
                itemBinding.set(BR.data_item, R.layout.github_item_item).bindExtra(BR.item_event_item, github_onclickListener);
            } else {
                itemBinding.set(BR.data_item, R.layout.github_item_item1).bindExtra(BR.item_event_item, github_onclickListener);
            }

        }
    };

    public ObservableList<InnerBean> items = new ObservableArrayList<>();
    public Github_OnclickListener github_onclickListener = new Github_OnclickListener() {
        @Override
        public void onClick(User user) {

        }

        @Override
        public void onClickItem(InnerBean user) {
            Log.e("点击了item里面的item", user.getInnerName() + "");
            for(int i=0;i<5;i++){
                InnerBean user1=new InnerBean("子view"+(items.size()));
                user1.setViewType(user.getViewType());
                items.add(user1);
            }
        }
    };

    public ObservableList<InnerBean> getItems() {
        return items;
    }

    public void setItems(ObservableList<InnerBean> items) {
        this.items = items;
    }
}
