package com.example.administrator.smarttabdemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * MyPagerAdapter[v 1.0.0]
 * classes:com.example.administrator.smarttabdemo.MyPagerAdapter
 *
 * @author kangliang
 * @date 2016/5/18
 * @time 10:31
 * @description
 */
public class MyPagerAdapter extends PagerAdapter {

    private List<View> mViewList;
    private List<String> mTitleList;
    private Context context;

    public MyPagerAdapter(Context context, List<View> mViewList, List<String> mTitleList) {
        this.context = context;
        this.mViewList = mViewList;
        this.mTitleList = mTitleList;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 添加页卡
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    /**
     * 删除页卡
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(mViewList.get(position));
    }

    /**
     *
     * Title
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }
}
