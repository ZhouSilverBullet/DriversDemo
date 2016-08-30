package com.qianphone.driversdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by 周周 on 2016/8/25.
 */
public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragmentList;
    private String[] tabTitles;
    public MyFragmentStatePagerAdapter(FragmentManager fm,List<Fragment> fragmentList,String[] tabTitles) {
        super(fm);
        mFragmentList =fragmentList;
        this.tabTitles =tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList==null?0:mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
