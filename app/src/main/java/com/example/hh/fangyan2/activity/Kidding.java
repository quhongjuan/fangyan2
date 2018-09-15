package com.example.hh.fangyan2.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hh.fangyan2.R;
import com.example.hh.fangyan2.adapter.My3Adapter;
import com.example.hh.fangyan2.bean.Bean3;
import com.example.hh.fangyan2.bean.Icon;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class Kidding extends AppCompatActivity{
    SwipeRefreshLayout swipeRefreshLayout;
    ListView listView;
   // private Activity parentActivity;



    private GridView grid_photo2;
    private BaseAdapter mAdapter2 = null;
    private ArrayList<Icon> mData2 = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kidding);

        swipeRefreshLayout = findViewById(R.id.swid);
        listView = findViewById(R.id.my_list_view);

        final ArrayList<Bean3> dataList = new ArrayList<Bean3>();

        dataList.add(new Bean3("笑话1", "http://www.360doc.com/content/16/0620/17/4666759_569313579.shtml",R.mipmap.dot));
        dataList.add(new Bean3("笑话2", "http://www.pig66.com/show-1714-1114835-1.html",R.mipmap.dot));
        dataList.add(new Bean3("笑话3", "http://baijiahao.baidu.com/s?id=1602480786079558486&wfr=spider&for=pc",R.mipmap.dot));
        dataList.add(new Bean3("笑话4", "http://baijiahao.baidu.com/s?id=1596326167531023513&wfr=spider&for=pc",R.mipmap.dot));
        dataList.add(new Bean3("笑话5", "https://baijiahao.baidu.com/s?id=1573494971428634&wfr=spider&for=pc",R.mipmap.dot));
        dataList.add(new Bean3("笑话6", "https://zhidao.baidu.com/question/23189908.html",R.mipmap.dot));
        dataList.add(new Bean3("笑话7", "http://www.360doc.com/content/17/0616/01/773384_663515322.shtml",R.mipmap.dot));
        dataList.add(new Bean3("笑话8", "http://www.360doc.com/content/16/0819/17/773384_584370456.shtml",R.mipmap.dot));
        dataList.add(new Bean3("笑话9", "http://www.360doc.com/content/17/1215/09/8510298_713243227.shtml",R.mipmap.dot));

        // Toast.makeText(parentActivity, "下拉获取更多内容", Toast.LENGTH_LONG).show();

//        final ArrayAdapter<String> adapter0= new ArrayAdapter<String>(parentActivity,android.R.layout.simple_list_item_1,android.R.id.text1,dataList);
        final My3Adapter adapter0 = new My3Adapter(dataList, this);
        listView.setAdapter(adapter0);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), BrowserActivity.class);
                intent.putExtra("url", dataList.get((int) id).getUrl());
                startActivity(intent);
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {


            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(getApplicationContext(), "加载完成", Toast.LENGTH_LONG).show();
                        for(int i=0;i<20;i++)
                        {
                            dataList.add(new Bean3("笑话"+(i+10),"http://www.taobao.com",R.mipmap.dot));
                        }
                        adapter0.notifyDataSetChanged();
                    }
                }, 4000);
            }
        });
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        swipeRefreshLayout.setProgressViewOffset(false, 5, 10);

    }
}
