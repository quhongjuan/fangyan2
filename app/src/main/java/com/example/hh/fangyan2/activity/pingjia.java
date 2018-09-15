package com.example.hh.fangyan2.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hh.fangyan2.R;
import com.example.hh.fangyan2.util.OkHttpUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Response;

public class pingjia extends AppCompatActivity {
    private EditText edit;
    private Button bt;
    private String edittext;
    private Handler handler =new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Toast.makeText(pingjia.this, "提交成功", Toast.LENGTH_LONG).show();
                    break;
                case 0:
                    Toast.makeText(pingjia.this, "提交失败", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pingjia);

        edit=(EditText)findViewById(R.id.editSms);
        bt=(Button)findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              edittext=edit.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map<String,String> map=new HashMap<>();
                        map.put("pingjia",edittext);

                          Response response= OkHttpUtils.doPost("/pj.php",map);
                        String s= null;
                        try {
                            s = response.body().string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        JsonObject root = (JsonObject) new JsonParser().parse(s);
                        String ok = root.get("ok").getAsString();
                        Message msg = new Message();
                        if(ok.equals("true"))
                        {
                            msg.what =1;

                        }
                        else if(ok.equals("false"))
                        {
                            msg.what=0;
                        }
                        handler.sendMessage(msg);
                    }
                }).start();
            }
        });
    }
}
