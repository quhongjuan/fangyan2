package com.example.hh.fangyan2.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hh.fangyan2.R;
import com.example.hh.fangyan2.fragment.MyFragment1;
import com.example.hh.fangyan2.fragment.MyFragment2;
import com.example.hh.fangyan2.fragment.MyFragment3;
import com.example.hh.fangyan2.util.SnackBarUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private TabLayout mTabTl;
    private ViewPager mContentVp;

    private DrawerLayout mDrawerLayout;//侧边菜单视图
    private ActionBarDrawerToggle mDrawerToggle;  //菜单开关
    private Toolbar mToolbar;
    private NavigationView mNavigationView;//侧边菜单项
    private MenuItem mPreMenuItem;

    private List<String> tabIndicators;
    private List<Fragment> tabFragments;
    private ContentPagerAdapter contentAdapter;


    private ViewPager vpager;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTabTl = (TabLayout) findViewById(R.id.tl_tab);
        mContentVp = (ViewPager) findViewById(R.id.vp_content);

        mToolbar = $(R.id.toolbar);
        mDrawerLayout = $(R.id.drawer_layout);
        mNavigationView = $(R.id.navigation_view);


        mToolbar.setTitle("方言识别");

        //这句一定要在下面几句之前调用，不然就会出现点击无反应
        setSupportActionBar(mToolbar);
        setNavigationViewItemClickListener();
        //ActionBarDrawerToggle配合Toolbar，实现Toolbar上菜单按钮开关效果。
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mToolbar.setNavigationIcon(R.drawable.ic_drawer_home);

        initContent();
        initTab();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);
        }
//        } else if (id == R.id.action_ckpt) {
//            Intent intent=new Intent(MainActivity.this,CkptActivity.class);
//            startActivity(intent);
//        }


        return super.onOptionsItemSelected(item);
    }

    private void setNavigationViewItemClickListener() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (null != mPreMenuItem) {
                    mPreMenuItem.setChecked(false);
                }
                switch (item.getItemId()) {
                    case R.id.navigation_item_user:
                        Intent intent1=new Intent(MainActivity.this,change_password.class);
                        startActivity(intent1);
                        break;
                    case R.id.navigation_item_addbook:
                        Intent intent2=new Intent(MainActivity.this,pingjia.class);
                        startActivity(intent2);
                        break;
                    case R.id.navigation_item_about:
                        Intent intent3=new Intent(MainActivity.this,Mo.class);
                        startActivity(intent3);
                        break;
                    case R.id.navigation_item_logout:
                        Intent intent4=new Intent(MainActivity.this,AgentApplication.class);
                        startActivity(intent4);
                        break;

                    default:
                        break;
                }
                item.setChecked(true);
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                mPreMenuItem = item;
                return false;
            }
        });
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_main;
    }

    private void initTab(){
        mTabTl.setTabMode(TabLayout.MODE_FIXED);
        ViewCompat.setElevation(mTabTl, 30);
        mTabTl.setupWithViewPager(mContentVp);
    }

    private void initContent(){
        tabIndicators = new ArrayList<>();
        tabIndicators.add("首页");
        tabIndicators.add("识别");
        tabIndicators.add("微趣");


        tabFragments = new ArrayList<>();
        tabFragments.add(new MyFragment1());
        tabFragments.add(new MyFragment2());
        tabFragments.add(new MyFragment3());

        contentAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        mContentVp.setAdapter(contentAdapter);
    }

    class ContentPagerAdapter extends FragmentPagerAdapter {

        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabIndicators.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabIndicators.get(position);
        }
    }



    //返回
    private long lastBackKeyDownTick = 0;
    public static final long MAX_DOUBLE_BACK_DURATION = 1500;
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {//当前抽屉是打开的，则关闭
            mDrawerLayout.closeDrawer(Gravity.LEFT);
            return;
        }
        long currentTick = System.currentTimeMillis();
        if (currentTick - lastBackKeyDownTick > MAX_DOUBLE_BACK_DURATION) {
            SnackBarUtils.makeShort(mDrawerLayout, "再按一次退出").success();
            lastBackKeyDownTick = currentTick;
        } else {
            finish();
            System.exit(0);
        }
    }

}
