package com.example.hh.fangyan2.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hh.fangyan2.R;


/**
 * Created by 曾莹 on 2018/9/12.
 */

public class Music extends AppCompatActivity  implements View.OnClickListener{

    private Button btn_start;
    private Button btn_stop;
    private Button btn_start1;
    private Button btn_stop1;
    private Button btn_start2;
    private Button btn_stop2;
    private Button btn_start3;
    private Button btn_stop3;
    private Button btn_start4;
    private Button btn_stop4;
    private Button btn_start5;
    private Button btn_stop5;

    private MediaPlayer mePlayer=null;
    private boolean isRelease=true;
    private MediaPlayer mePlayer1=null;
    private boolean isRelease1=true;
    private MediaPlayer mePlayer2=null;
    private boolean isRelease2=true;
    private MediaPlayer mePlayer3=null;
    private boolean isRelease3=true;
    private MediaPlayer mePlayer4=null;
    private boolean isRelease4=true;
    private MediaPlayer mePlayer5=null;
    private boolean isRelease5=true;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
        bindViews();
    }

    private void bindViews() {
        btn_start=(Button)findViewById(R.id.t1);
        btn_stop=(Button)findViewById(R.id.t2);
        btn_start1=(Button)findViewById(R.id.t3);
        btn_stop1=(Button)findViewById(R.id.t4);
        btn_start2=(Button)findViewById(R.id.t5);
        btn_stop2=(Button)findViewById(R.id.t6);
        btn_start3=(Button)findViewById(R.id.t7);
        btn_stop3=(Button)findViewById(R.id.t8);
        btn_start4=(Button)findViewById(R.id.t9);
        btn_stop4=(Button)findViewById(R.id.t10);
        btn_start5=(Button)findViewById(R.id.t11);
        btn_stop5=(Button)findViewById(R.id.t12);

        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_start1.setOnClickListener(this);
        btn_stop1.setOnClickListener(this);
        btn_start2.setOnClickListener(this);
        btn_stop2.setOnClickListener(this);
        btn_start3.setOnClickListener(this);
        btn_stop3.setOnClickListener(this);
        btn_start4.setOnClickListener(this);
        btn_stop4.setOnClickListener(this);
        btn_start5.setOnClickListener(this);
        btn_stop5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.t1:
                if(isRelease)
                {
                    mePlayer=MediaPlayer.create(this,R.raw.wdhbx);
                    isRelease=false;
                }
                mePlayer.start();
                btn_start.setEnabled(false);
                btn_stop.setEnabled(true);
                break;
            case R.id.t2:
                mePlayer.reset();
                mePlayer.release();
                isRelease = true;
                btn_start.setEnabled(true);
                btn_stop.setEnabled(false);
                break;
            case R.id.t3:
                if(isRelease1)
                {
                    mePlayer1=MediaPlayer.create(this,R.raw.xixi);
                    isRelease1=false;
                }
                mePlayer1.start();
                btn_start1.setEnabled(false);
                btn_stop1.setEnabled(true);
                break;
            case R.id.t4:
                mePlayer1.reset();
                mePlayer1.release();
                isRelease1 = true;
                btn_start1.setEnabled(true);
                btn_stop1.setEnabled(false);
                break;
            case R.id.t5:
                if(isRelease2)
                {
                    mePlayer2=MediaPlayer.create(this,R.raw.sht);
                    isRelease2=false;
                }
                mePlayer2.start();
                btn_start2.setEnabled(false);
                btn_stop2.setEnabled(true);
                break;
            case R.id.t6:
                mePlayer2.reset();
                mePlayer2.release();
                isRelease2 = true;
                btn_start2.setEnabled(true);
                btn_stop2.setEnabled(false);
                break;
            case R.id.t7:
                if(isRelease3)
                {
                    mePlayer3=MediaPlayer.create(this,R.raw.yueban);
                    isRelease3=false;
                }
                mePlayer3.start();
                btn_start3.setEnabled(false);
                btn_stop3.setEnabled(true);
                break;
            case R.id.t8:
                mePlayer3.reset();
                mePlayer3.release();
                isRelease3 = true;
                btn_start3.setEnabled(true);
                btn_stop3.setEnabled(false);
                break;
            case R.id.t9:
                if(isRelease4)
                {
                    mePlayer4=MediaPlayer.create(this,R.raw.hnj);
                    isRelease4=false;
                }
                mePlayer4.start();
                btn_start4.setEnabled(false);
                btn_stop4.setEnabled(true);
                break;
            case R.id.t10:
                mePlayer4.reset();
                mePlayer4.release();
                isRelease4 = true;
                btn_start4.setEnabled(true);
                btn_stop4.setEnabled(false);
                break;
            case R.id.t11:
                if(isRelease5)
                {
                    mePlayer5=MediaPlayer.create(this,R.raw.awmz);
                    isRelease5=false;
                }
                mePlayer5.start();
                btn_start5.setEnabled(false);
                btn_stop5.setEnabled(true);
                break;
            case R.id.t12:
                mePlayer5.reset();
                mePlayer5.release();
                isRelease5 = true;
                btn_start5.setEnabled(true);
                btn_stop5.setEnabled(false);
                break;
        }
    }
}
