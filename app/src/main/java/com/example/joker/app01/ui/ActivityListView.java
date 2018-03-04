package com.example.joker.app01.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.joker.app01.R;

public class ActivityListView extends AppCompatActivity {

    private ListView lv1;

    private String[] players = {"Kobe", "Casol", "Kuzma", "Ball", "Tomas", "Fisher",
            "Ducun", "Anthony", "Curry", "Iring", "Ingram", "Tompson", "West"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityListView.this,
                android.R.layout.simple_list_item_1, players);
        lv1 = findViewById(R.id.lv_simple);
        lv1.setAdapter(adapter);

    }
}
