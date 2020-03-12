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

public class GithubModel {

    public final GitHubRecyclerViewAdapter gitHubRecyclerViewAdapter = new GitHubRecyclerViewAdapter();

    //多item时候的显示
    public final OnItemBind<User> onItemBind = new OnItemBind<User>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, User item) {
            //这是设置子recycleview的绑定信息
            ItemRecycleviewModel itemRecycleviewModel = new ItemRecycleviewModel();
            itemRecycleviewModel.setItems(item.getInnerBeans());
            if (item.getViewType() == 0) {
                //这个是设置当type为0时 这个item显示的layout和需要的事件处理
                itemBinding.set(BR.data, R.layout.github_item).bindExtra(BR.item_event, github_onclickListener)
                        .bindExtra(BR.item_model, itemRecycleviewModel);
            } else {
                //这个是设置当type为1时 这个item显示的layout和需要的事件处理
                itemBinding.set(BR.data, R.layout.github_item1).bindExtra(BR.item_event, github_onclickListener)
                        .bindExtra(BR.item_model, itemRecycleviewModel);
                ;
            }

        }
    };
//数据源
    public ObservableList<User> items = new ObservableArrayList<>();
    //点击事件--必须直接实例化 不能通过外部set 因为绑定关系建立后不能更新
    public Github_OnclickListener github_onclickListener = new Github_OnclickListener() {
        @Override
        public void onClick(User user) {
            Log.e("点击的item", user.getName() + "");
user.setName("显示变化了");
            User user1 = new User();
            if (items.size() % 2 == 1) {
                user1.setViewType(1);
            }
            ObservableList<InnerBean> innerBeans = new ObservableArrayList<>();
            for (int j = 0; j < 4; j++) {
                InnerBean innerBean = new InnerBean("子view" + j);
                //如果上面是1 那里面的item也需要是1 建立对应关系
                if (items.size() % 2 == 1) {
                    innerBean.setViewType(1);
                }
                innerBeans.add(innerBean);
            }
            user1.setInnerBeans(innerBeans);
            user1.setName("item" + items.size());
            items.add(user1);

        }

        @Override
        public void onClickItem(InnerBean user) {

        }
    };
    //  如果是单item使用这个
    public final ItemBinding<User> itemBinding = ItemBinding.<User>of(BR.data, R.layout.github_item).bindExtra(BR.item_event, github_onclickListener);

    public ObservableList<User> getItems() {
        return items;
    }

    public void setItems(ObservableList<User> items) {
        this.items = items;
    }
}
