package com.project.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStripExtends;
import com.project.base.BaseFragment;
import com.project.factory.FragmentFactory;
import com.project.util.LogUtils;
import com.project.util.UIUtils;

public class MainActivity extends AppCompatActivity{
    private com.astuetz.PagerSlidingTabStripExtends mMainTabs;
    private ViewPager mViewPager;
    private String[] mMainTitles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initActionBar();
        initData();
        initListener();
        //initAdapter();
    }

    private void initListener() {
        mMainTabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                  //完成触发加载
                BaseFragment fragment = FragmentFactory.getFragment(position);
                if(fragment != null){
                    fragment.getLoadingPager().loadData();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.ic_launcher);
        actionBar.setTitle("GooglePlay");
    }

    private void initView(){
         mMainTabs = (PagerSlidingTabStripExtends) findViewById(R.id.main_tabs);
        mViewPager = (ViewPager) findViewById(R.id.main_viewPager);

    }
    private void initData(){
        mMainTitles = UIUtils.getStringArr(R.array.main_titles);
       // MainPagerAdapter adapter = new MainPagerAdapter();
        MainFragmentStatePagerAdapter adapter = new MainFragmentStatePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mMainTabs.setViewPager(mViewPager);
    }

    class MainPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            if(mMainTitles !=null){
                return mMainTitles.length;
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(UIUtils.getContext());
            tv.setText(mMainTitles[position]);
            container.addView(tv);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mMainTitles[position];
        }
    }
    class MainFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

        public MainFragmentStatePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            if(mMainTitles !=null){
                return mMainTitles.length;
            }
          return 0;
        }


        @Override
        public Fragment getItem(int position) {
            Fragment fragment = FragmentFactory.getFragment(position);
            //LogUtils.sf("初始化"+mMainTitles[position]);
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mMainTitles[position];
        }
    }
}
