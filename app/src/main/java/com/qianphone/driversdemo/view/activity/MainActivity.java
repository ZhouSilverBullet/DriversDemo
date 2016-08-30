package com.qianphone.driversdemo.view.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.qianphone.driversdemo.R;
import com.qianphone.driversdemo.adapter.MyFragmentStatePagerAdapter;
import com.qianphone.driversdemo.presenter.BasePresenter;
import com.qianphone.driversdemo.view.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private String[] tab_titles;
    private MyFragmentStatePagerAdapter mPagerAdapter;
    private List<Fragment> mFragmentList;
    private RecommendFragment mRecommendFragment;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        mToolbar.setTitle(R.string.app_name);
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, 0, 0);
        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);


        tab_titles = getResources().getStringArray(R.array.tab_titles);
        mFragmentList = new ArrayList<>();
        mRecommendFragment = new RecommendFragment();
        mFragmentList.add(mRecommendFragment);
        mPagerAdapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager(), mFragmentList, tab_titles);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.na_night:
                //todo 夜间模式
                Toast.makeText(MainActivity.this, "夜间模式", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.watch_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.na_watch:
                //todo
                Toast.makeText(MainActivity.this, "关注", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
