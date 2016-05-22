package com.project.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 17895 on 2016/5/17.
 */
public abstract  class BaseFragmentCommon extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        init();
        super.onCreate(savedInstanceState);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView();
    }
    /**
     * @des 初始化view,而且是必须实现,但是不知道具体实现,定义成抽象方法
     * @return
     */
    public abstract View initView();

    private void init() {

    }

    public void initData(){

    }
    public void initListener(){

    }

}
