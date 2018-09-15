package com.example.hh.fangyan2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.hh.fangyan2.R;


/**
 * Created by 曾莹 on 2018/7/27.
 */

public class Mo extends AppCompatActivity {

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private CheckBox checkBox7;
    private CheckBox checkBox8;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mo);

        checkBox1=(CheckBox)findViewById(R.id.checkBox1);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        checkBox4=(CheckBox)findViewById(R.id.checkBox4);
        checkBox5=(CheckBox)findViewById(R.id.checkBox5);
        checkBox6=(CheckBox)findViewById(R.id.checkBox6);
        checkBox7=(CheckBox)findViewById(R.id.checkBox7);
        checkBox8=(CheckBox)findViewById(R.id.checkBox8);



        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                if(isChecked)
                {
                    //获得checkBox的文本内容
                    //String text= checkBox1.getText().toString();
                    Toast.makeText(Mo.this, "在人工智能快速发展的今天，语音识别开始成为很多设备的标配， 语音识别开始被越来越多的人关注，国外微软、苹果、谷歌、nuance，国内的科大讯飞、思必驰等厂商都在研发语音识别新策略新算法，似乎人类与语音的自然交互渐行渐近", Toast.LENGTH_LONG).show();
                }

            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                if(isChecked)
                {
                    //获得checkBox的文本内容
                    //String text= checkBox1.getText().toString();
                    Toast.makeText(Mo.this, "方言识别是一种处理语音识别技术的一种识别技术，根据音频的音调和音韵判断出属于哪种语音，目前是发展较好的语音处理技术", Toast.LENGTH_LONG).show();
                }

            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                if(isChecked)
                {
                    //获得checkBox的文本内容
                    //String text= checkBox1.getText().toString();
                    Toast.makeText(Mo.this, "这款APP是是一个以辨别各地方言的语言识别类软件，由于能力有限（几个即将步入大二的菜鸟合力完成），目前仅能实现6种方言（长沙话、河北话、闽南话、客家话、上海话、四川话、合肥话和南昌话八种地方方言），但是方言识别准确率高达96%以上", Toast.LENGTH_LONG).show();
                }

            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                if(isChecked)
                {
                    //获得checkBox的文本内容
                    //String text= checkBox1.getText().toString();
                    Toast.makeText(Mo.this, "由于技术水平和能力限制，该APP能识别的方言种类实在很少(づ◡ど)，但是随着经验的丰富，能力的提升我们有信心，在未来完成一个集更多语音为一身的功能强大的APP！@#￥%…*&", Toast.LENGTH_LONG).show();
                }

            }
        });
        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                if(isChecked)
                {
                    //获得checkBox的文本内容
                    //String text= checkBox1.getText().toString();
                    Toast.makeText(Mo.this, " 十年前的语音识别的研究是完全处在黑暗和探索之中的。人们已经意识到语音信号是一种渐变平稳信号，短时时频分析已经被广泛采用，已经比较成功的探索出能代表语音声音信号的特征提取方法，这类方法大都是以模拟说话人的声道特性为主，比较有代表性的是LPC谱和MFCC谱。但是对于连续语音的识别仍然是一个可望而不可及的高度。", Toast.LENGTH_LONG).show();
                }

            }
        });
        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                if(isChecked)
                {
                    //获得checkBox的文本内容
                    //String text= checkBox1.getText().toString();
                    Toast.makeText(Mo.this, "用户的优质体验是对我们最大的肯定，尽管现在功能并没有很完善，但是，我们会继续完善性能，未来我们会努力实现多种方言语言的识别，对于一些方言进行方言翻译，方便用户使用，而且添加一些有趣的方言小应用，带给用户优质体验(❁´︶`❁)", Toast.LENGTH_LONG).show();
                }

            }
        });
        checkBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                if(isChecked)
                {
                    //获得checkBox的文本内容
                    //String text= checkBox1.getText().toString();
                    Toast.makeText(Mo.this, "｡◕‿◕｡语言识别的用途很多，例如可以作为方言翻译汉语的基础功能，还可以将来作为多语言交互的基础功能", Toast.LENGTH_LONG).show();
                }

            }
        });
        checkBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                if(isChecked)
                {
                    //获得checkBox的文本内容
                    //String text= checkBox1.getText().toString();
                    Toast.makeText(Mo.this, "开发过程中，不仅在方言识别技术上遇到过瓶颈，在APP制作上（采用原生APP开发，现在感觉有点傻。。。）以及安卓后台搭建都面临过困难，最终实现了基本功能，并呈现给用户。在未来的开发中，高品质的追求一直是我们追求的目标，我们会在再接再厉，希望大家继续支持我们♬♩♫♪☻(●´∀｀●）☺♪♫♩♬", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
