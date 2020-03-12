package com.example.testmvvm.use_github;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.testmvvm.User;
import com.example.testmvvm.databinding.GithubItem1Binding;
import com.example.testmvvm.databinding.GithubItemBinding;

import androidx.annotation.LayoutRes;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

public class GitHubRecyclerViewAdapter<T> extends BindingRecyclerViewAdapter<T> {
    Context context;

    @Override
    public ViewDataBinding onCreateBinding(LayoutInflater inflater, @LayoutRes int layoutId, ViewGroup viewGroup) {
        ViewDataBinding binding = super.onCreateBinding(inflater, layoutId, viewGroup);
        Log.d("TAG", "created binding: " + binding);
        context = viewGroup.getContext();
        return binding;
    }

    @Override
    public void onBindBinding(ViewDataBinding binding, int bindingVariable, @LayoutRes int layoutId, int position, T item) {
        super.onBindBinding(binding, bindingVariable, layoutId, position, item);
        User user = (User) item;
        if (user.getViewType() == 0) {
            //里面有recycleview  横向的
            GithubItemBinding githubItemBinding = (GithubItemBinding) binding;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
            githubItemBinding.recycleview.setLayoutManager(gridLayoutManager);
        }else {
            //横向的recycleview
            GithubItem1Binding githubItemBinding = (GithubItem1Binding) binding;
            LinearLayoutManager gridLayoutManager = new LinearLayoutManager(context);
            gridLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            githubItemBinding.recycleview.setLayoutManager(gridLayoutManager);
        }
        Log.d("TAG", "bound binding: " + binding + " at position: " + position);
    }
}
