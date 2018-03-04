package com.example.joker.app01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.joker.app01.activity.ActivityMain;
import com.example.joker.app01.ui.UIActivityMain;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.btn_menu_1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.btn_menu_2);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_menu_1:
                intent.setClass(this, ActivityMain.class);
                break;
            case R.id.btn_menu_2:
                intent.setClass(this, UIActivityMain.class);
                break;
        }
        startActivity(intent);
    }
}
