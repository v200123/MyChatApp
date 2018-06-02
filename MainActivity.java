package com.study.lc.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private List<Msg> msgList = new ArrayList<>();
    ImageView TopicImage;
    EditText editText;
    Button btn_Communication,btn_Contact,btn_Zone,btn_Send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        CreateFragment(new MainGUIFragment());
        msgRecyclerView = findViewById(R.id.ChatItems);
        editText = findViewById(R.id.input_text);
        TopicImage = findViewById(R.id.TOP_image);
        (btn_Send = findViewById(R.id.Send)).setOnClickListener(this);
        (btn_Communication = findViewById(R.id.Communication)).setOnClickListener(this);
        (btn_Contact = findViewById(R.id.Contact)).setOnClickListener(this);
        (btn_Zone = findViewById(R.id.Zone)).setOnClickListener(this);

        adapter = new MsgAdapter(msgList);
        initMsgs();


    }


    private void CreateFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction  FT = fm.beginTransaction();
        FT.replace(R.id.MainGUI,fragment).commit();
    }

    /**
     * 对聊天界面。联系人，空间做监听事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Communication:
                break;
            case  R.id.Contact:
                break;
            case R.id.Zone:
                break;
            case R.id.Send:
                Date date = new Date();
                String  content = editText.getText().toString();
//                int Image = 0;
                if (!"".equals(content)) {
                    Msg msg = new Msg(date,content,R.mipmap.dahuangmao06,Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1); // 当有新消息时，刷新RecyclerView 中的显示
//                    msgRecyclerView.scrollToPosition(msgList.size() - 1); // 将RecyclerView 定位到最后一行
                    editText.setText("");
                    Toast.makeText(this,"OK",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
    private void initMsgs() {
        Msg msg1 = new Msg(new Date(),"hi Guy",0,Msg.TYPE_SENT);
        msgList.add(msg1);
    }
}
