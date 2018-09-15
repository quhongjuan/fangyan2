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

public class login2 extends AppCompatActivity {

    private EditText editText5;
    private EditText editText7;
    private EditText editText8;
    private EditText editText9;
    private EditText editText10;
    private Button bt;
    private String username;
    private String password1;
    private String password2;
    private String school;
    private String birthday;

    private Handler  handler =new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Toast.makeText(login2.this, "注册成功", Toast.LENGTH_LONG).show();
                    Intent it =new Intent(login2.this,MainActivity.class);
                    startActivity(it);
                    break;
                case 0:
                    Toast.makeText(login2.this, "注册失败", Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    Toast.makeText(login2.this, "账号已存在", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login2);

        editText5=(EditText)findViewById(R.id.editText5);
        editText7=(EditText)findViewById(R.id.editText7);
        editText8=(EditText)findViewById(R.id.editText8);
        editText9=(EditText)findViewById(R.id.editText9);
        editText10=(EditText)findViewById(R.id.editText10);
        bt=(Button)findViewById(R.id.button);



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=editText5.getText().toString();
                password1=editText7.getText().toString();
                password2=editText8.getText().toString();
                school=editText9.getText().toString();
                birthday=editText10.getText().toString();
                if(username.equals("")||password2.equals("")||password1.equals("")||school.equals("")||birthday.equals("")){
                    Toast.makeText(login2.this," 请将信息添加完整",Toast.LENGTH_LONG).show();;
                    return;
                }


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map<String,String> map=new HashMap<>();
                        map.put("username",username);
                        map.put("password1",password1);
                        map.put("school",school);
                        map.put("birthday",birthday);
                        Response response= OkHttpUtils.doPost("/sign_up.php",map);
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
                              else if(ok.equals("no"))
                            {
                                msg.what=2;
                            }
                            handler.sendMessage(msg);
                        } catch (IOException e) {
                            System.out.print("出错了");
                            e.printStackTrace();
                        }


                    }

                }).start();

            }
        });

    }
}
