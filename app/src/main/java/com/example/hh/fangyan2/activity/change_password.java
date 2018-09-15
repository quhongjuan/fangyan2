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

import java.util.HashMap;
import java.util.Map;

import okhttp3.Response;

public class change_password extends AppCompatActivity {

    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private Button bt;
    private String username;
    private String old_password;
    private String new_password;

    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what) {
                case 1:
                    Toast.makeText(change_password.this, "修改密码成功", Toast.LENGTH_LONG).show();
                    Intent it =new Intent(change_password.this,MainActivity.class);
                    startActivity(it);
                    break;
                case 0:
                    Toast.makeText(change_password.this, "修改密码失败", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        edit1=(EditText)findViewById(R.id.change_ed1);
        edit2=(EditText)findViewById(R.id.change_ed2);
        edit3=(EditText)findViewById(R.id.change_ed3);
        bt=(Button)findViewById(R.id.button);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=edit1.getText().toString();
                old_password=edit2.getText().toString();
                new_password=edit3.getText().toString();

                if(username.equals("")||old_password.equals("")||new_password.equals("")){
                    Toast.makeText(change_password.this," 请将信息添加完整",Toast.LENGTH_LONG).show();;
                    return;
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map<String,String> map=new HashMap<>();
                        map.put("username",username);
                        map.put("old_password",old_password);
                        map.put("new_password",new_password);

                        Response response= OkHttpUtils.doPost("/change.php",map);
                        String s=null;
                        try {
                           s=response.body().string();
                           System.out.print(s);

                            JsonObject root=(JsonObject)new JsonParser().parse(s);
                            String ok=root.get("ok").getAsString();
                            Message msg=new Message();
                            if(ok.equals("true")){
                                msg.what=1;
                            }
                            else if (ok.equals("false")){
                                msg.what=0;
                            }
                            handler.sendMessage(msg);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
        });
    }
}
