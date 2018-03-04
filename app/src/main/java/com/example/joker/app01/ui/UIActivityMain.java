package com.example.joker.app01.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.joker.app01.R;

public class UIActivityMain extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4, btn5, btn6,btn7;
    private ImageView iv;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_main);
        btn1 = findViewById(R.id.btn_ui_1);
        btn2 = findViewById(R.id.btn_ui_2);
        btn3 = findViewById(R.id.btn_ui_3);
        btn4 = findViewById(R.id.btn_ui_4);
        btn5 = findViewById(R.id.btn_ui_5);
        btn6 = findViewById(R.id.btn_ui_6);
        btn7 = findViewById(R.id.btn_ui_7);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);

        iv = findViewById(R.id.iv_ui_1);
        pb = findViewById(R.id.pb_ui_1);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_ui_1:
                iv.setImageResource(R.drawable.p2);
                break;
            case R.id.btn_ui_2:
                if (pb.getVisibility() == View.GONE) {
                    pb.setVisibility(View.VISIBLE);
                } else {
                    pb.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_ui_3:
                showDialog();
                break;
            case R.id.btn_ui_4:
                showProgressDialog();
                break;
            case R.id.btn_ui_5:
                intent = new Intent(UIActivityMain.this, ActivityLayout.class);
                startActivity(intent);
                break;
            case R.id.btn_ui_6:
                intent = new Intent(UIActivityMain.this, ActivityListView.class);
                startActivity(intent);
                break;
            case R.id.btn_ui_7:
                intent = new Intent(UIActivityMain.this, ActivityListViewCustom.class);
                startActivity(intent);
                break;
        }
    }

    private void showProgressDialog() {
        //已过时，建议最好使用Activity中的ProgressBar组件来代替这个组件
        ProgressDialog d = new ProgressDialog(this);
        d.setTitle("信息");
        d.setMessage("加载中...");
        d.setCancelable(true);
        d.show();
    }


    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("This is Dialog");
        builder.setMessage("这是显示消息");
        builder.setCancelable(false);
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(UIActivityMain.this, "确认", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(UIActivityMain.this, "取消", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
