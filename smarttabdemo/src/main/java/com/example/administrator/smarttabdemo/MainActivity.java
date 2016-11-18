package com.example.administrator.smarttabdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private List<String> mTitleList;
    private List<View> mViewList;

    private LayoutInflater mInflater;

    private View view1, view2, view3, view4, view5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initviews();
        initDatas();
        setTabLayout();
    }

    private void initviews() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        mTitleList = new ArrayList<>();
        mViewList = new ArrayList<>();
    }

    private void initDatas() {
        mInflater = LayoutInflater.from(MainActivity.this);
        view1 = mInflater.inflate(R.layout.activity_main, null);
        view2 = mInflater.inflate(R.layout.activity_main, null);
        view3 = mInflater.inflate(R.layout.activity_main, null);
        view4 = mInflater.inflate(R.layout.activity_main, null);
        view5 = mInflater.inflate(R.layout.activity_main, null);

        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);
        mViewList.add(view5);

        mTitleList.add("标题1");
        mTitleList.add("标题2");
        mTitleList.add("标题3");
        mTitleList.add("标题4");
        mTitleList.add("标题5");
    }

    private void setTabLayout() {
        tabLayout.setTabMode(TabLayout.MODE_FIXED);//系统默认模式、
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(3)));
        tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(4)));


        MyPagerAdapter mAdapter = new MyPagerAdapter(MainActivity.this, mViewList, mTitleList);
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);//tablayout和viewpager关联起来
        tabLayout.setTabsFromPagerAdapter(mAdapter);//给TabLayout设置适配器

    }


}
