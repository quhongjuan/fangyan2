package com.example.hh.fangyan2.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.hh.fangyan2.R;
import com.example.hh.fangyan2.activity.BaseActivity;
import com.example.hh.fangyan2.activity.Kidding;
import com.example.hh.fangyan2.activity.MainActivity;

public class MyFragment3 extends BaseFragment {
    private Button bt1;
    private Button bt2;
    private BaseActivity parentActivity;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.mf3;
    }
    @Override
    protected void setUpView(){
        bt1=$(R.id.button1);
        bt2=$(R.id.button2);
        parentActivity=(BaseActivity)getActivity();
    }
    @Override
    protected void setUpData(){
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent(parentActivity, MainActivity.class);
                startActivity(it1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent(parentActivity, Kidding.class);
                startActivity(it1);
            }
        });
    }
}
