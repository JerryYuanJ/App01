package com.example.joker.app01.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.joker.app01.R;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener {

    private Button button1, button2, button3, button4, button5, button6, button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            CharSequence temp = savedInstanceState.getCharSequence("temp");
            Toast.makeText(this, "临时数据:" + temp, Toast.LENGTH_SHORT).show();
        }
        setContentView(R.layout.activity_1);
        button1 = findViewById(R.id.btn_go_1);
        button2 = findViewById(R.id.btn_go_2);
        button3 = findViewById(R.id.btn_go_3);
        button4 = findViewById(R.id.btn_go_4);
        button5 = findViewById(R.id.btn_go_5);
        button6 = findViewById(R.id.btn_go_6);
        button7 = findViewById(R.id.btn_go_7);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
    }

    //在活动被回收之前一定会被调用
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putCharSequence("temp", "temp_data");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //两个参数的含义:把哪个菜单文件挂到哪个menu下面
        getMenuInflater().inflate(R.menu.main, menu);
        //返回true-显示,返回false不显示
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                Toast.makeText(this, "确认添加", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_remove:
                Toast.makeText(this, "确认删除", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    //用来接收上一个Activity返回数据的回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String return_data = data.getStringExtra("data_return");
                    Toast.makeText(ActivityMain.this, "接收到的返回数据:" + return_data, Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_go_1:
                //显式Intent
                intent.setClass(ActivityMain.this, Activity2.class);
                startActivity(intent);
                break;
            case R.id.btn_go_2:
                //隐式:只有当action和category同时匹配上manifest中定义的，这个活动才能响应该Intent.
                //android.intent.category.DEFAULT  这是个默认的category，会在调用startActivity()时自动添加到Intent中
                //每个Intent只有定义一个action，但是可以定义多个category
                intent.setAction("com.example.joker.app01.MY_ACTION");
                intent.addCategory("com.example.joker.app01.MY_CATEGORY");
                startActivity(intent);
                break;
            case R.id.btn_go_3:
                //使用隐式意图打开一个浏览器
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.btn_go_4:
                //自己定义了一个可以响应http schema的Activity，让系统提示选择
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.btn_go_5:
                //使用隐式意图打电话
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
                break;
            case R.id.btn_go_6:
                //传递数据给下一个Activity
                intent.setClass(ActivityMain.this, Activity2.class);
                intent.putExtra("name", "Troye Sivan");
                startActivity(intent);
                break;
            case R.id.btn_go_7:
                //返回数据给上一个活动
                intent.setClass(ActivityMain.this, Activity2.class);
                startActivityForResult(intent, 1);
                break;
            default:
                break;
        }

    }
}
