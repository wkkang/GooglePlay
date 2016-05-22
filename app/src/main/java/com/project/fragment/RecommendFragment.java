package com.project.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.base.BaseFragment;
import com.project.base.LoadingPager;
import com.project.util.UIUtils;

import java.util.Random;

/**
 * Created by 17895 on 2016/5/17.
 */
public class RecommendFragment extends BaseFragment {
    @Override
    public LoadingPager.LoadedResult initData() {// 真正加载数据
        // 执行耗时的操作
        SystemClock.sleep(2000);
        // 随机返回3中状态中的一种

        LoadingPager.LoadedResult[] arr = { LoadingPager.LoadedResult.ERROR, LoadingPager.LoadedResult.SUCCESS, LoadingPager.LoadedResult.EMPTY };
        Random random = new Random();
        int index = random.nextInt(arr.length);// 0 1 2

        return arr[index];
    }

    @Override
    public View initSuccessView() {
        // 返回成功的视图
        TextView tv = new TextView(UIUtils.getContext());
        tv.setText(this.getClass().getSimpleName());
        return tv;
    }
}
