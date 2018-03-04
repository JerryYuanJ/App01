package com.example.joker.app01.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joker.app01.R;


public class HeaderLayout extends RelativeLayout {

    private TextView tv1, tv2;

    public HeaderLayout(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.header, this);
        tv1 = findViewById(R.id.tv_layout_back);
        tv2 = findViewById(R.id.tv_layout_edit);
        tv1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "返回", Toast.LENGTH_SHORT).show();
            }
        });
        tv2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "编辑", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
