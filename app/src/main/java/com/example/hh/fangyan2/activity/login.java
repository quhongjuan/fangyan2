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

public class login extends AppCompatActivity{

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private EditText name;
    private EditText pass;
    private String username;
    private String password;


    private Handler handler =new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    System.out.print("啦啦啦");
                    Toast.makeText(login.this, "登陆成功", Toast.LENGTH_LONG).show();
                    Intent it =new Intent(login.this,MainActivity.class);
                    startActivity(it);
                    break;
                case 0:
                    Toast.makeText(login.this, "登陆失败", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        bt1=(Button)findViewById(R.id.zhuce);
        bt2=(Button)findViewById(R.id.wangji);
        bt3=findViewById(R.id.button3);
        name=(EditText)findViewById(R.id.editText2) ;
        pass=(EditText)findViewById(R.id.editText);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(login.this,login2.class);
                startActivity(it);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent it=new Intent(login.this,forget_password.class);
               startActivity(it);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                username=name.getText().toString();
                password=pass.getText().toString();
                if(username.equals("")){
                    Toast.makeText(login.this," 请将用户名添加完整",Toast.LENGTH_LONG).show();
                    return;
                }
                if(password.equals("")){
                    Toast.makeText(login.this," 请将密码添加完整",Toast.LENGTH_LONG).show();;
                    return;
                }
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        Map<String,String> map=new HashMap<>();
                        map.put("username",username);
                        map.put("password",password);
                        Response response= OkHttpUtils.doPost("/login.php",map);
                        String s= null;
                        try {
                            s = response.body().string();
                            System.out.println(s);
                            JsonObject root = (JsonObject) new JsonParser().parse(s);
                            String ok = root.get("ok").getAsString();
                            Message msg = new Message();
                            System.out.print(s);
                            if(ok.equals("true"))
                            {
                                msg.what =1;
                            }
                            else if(ok.equals("false"))
                            {
                                msg.what=0;
                            }
                            handler.sendMessage(msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }).start();

            }
        });
    }
}
