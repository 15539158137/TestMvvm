package com.example.testmvvm;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.testmvvm.databinding.ItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<User> mList;
    public Context mContext;

    public RecycleviewAdapter(List<User> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //注意点-1
        ItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item, viewGroup, false);
        RecycleviewHolder_Title recycleviewHolder_title = new RecycleviewHolder_Title(itemBinding.getRoot());
        recycleviewHolder_title.setItemBinding(itemBinding);
        return recycleviewHolder_title;

    }

    @Override
    public int getItemViewType(int position) {
        return 0;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        User dataBean = mList.get(i);
        //注意点-2 这里和之前的使用类似   和activity里面设置数据源是一样的道理
        RecycleviewHolder_Title recycleviewHolder_title = (RecycleviewHolder_Title) viewHolder;
        ;
        recycleviewHolder_title.itemBinding.setItem(dataBean);
        ///避免闪烁
        recycleviewHolder_title.itemBinding.executePendingBindings();
        recycleviewHolder_title.itemBinding.setOnItemClickListener(onItemClickListener);
    }


    @Override
    public int getItemCount() {
        if (mList == null || mList.size() == 0) {
            return 0;
        }
        return mList.size();
    }

    class RecycleviewHolder_Title extends RecyclerView.ViewHolder {
        private ItemBinding itemBinding;

        public RecycleviewHolder_Title(@NonNull View itemView) {
            super(itemView);
        }


        public void setItemBinding(ItemBinding itemBinding) {
            this.itemBinding = itemBinding;
        }
    }


    private OnItemClickListener onItemClickListener;
    ;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        public void onClick(User index);

    }
}


