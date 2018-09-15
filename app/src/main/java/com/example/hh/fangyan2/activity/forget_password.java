package com.example.hh.fangyan2.activity;

import android.content.Intent;
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

public class forget_password extends AppCompatActivity {

    private EditText text1;
    private EditText text2;
    private EditText text3;
    private Button bt;

    private String username;
    private String school;
    private String birthday;
    private Handler handler=new Handler(){
      public void handleMessage(Message msg){
          switch (msg.what) {
              case 1:
                  Toast.makeText(forget_password.this, "登陆成功", Toast.LENGTH_LONG).show();
                  Intent it =new Intent(forget_password.this,MainActivity.class);
                  startActivity(it);
                  break;
              case 0:
                  Toast.makeText(forget_password.this, "登陆失败", Toast.LENGTH_LONG).show();
                  break;
              default:
                  break;
          }
      }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);

        text1=(EditText)findViewById(R.id.text1);
        text2=(EditText)findViewById(R.id.text2);
        text3=(EditText)findViewById(R.id.text3);
        bt=(Button)findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=text1.getText().toString();
                school=text2.getText().toString();
                birthday=text3.getText().toString();
                if(username.equals("")||school.equals("")||birthday.equals("")){
                    Toast.makeText(forget_password.this," 请将信息添加完整",Toast.LENGTH_LONG).show();;
                    return;
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map<String,String> map=new HashMap<>();
                        map.put("username",username);
                        map.put("school",school);
                        map.put("birthday",birthday);

                        Response respose= OkHttpUtils.doPost("/forget.php",map);
                        String s=null;
                        try{
                         s=respose.body().string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        JsonObject root=(JsonObject)new JsonParser().parse(s);
                        String ok=root.get("ok").getAsString();
                        Message msg=new Message();
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
