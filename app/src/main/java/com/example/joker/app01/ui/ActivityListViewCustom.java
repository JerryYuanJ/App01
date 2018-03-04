package com.example.joker.app01.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.joker.app01.R;
import com.example.joker.app01.ui.adapter.PlayerAdapter;
import com.example.joker.app01.ui.bean.Player;

import java.util.ArrayList;
import java.util.List;

public class ActivityListViewCustom extends AppCompatActivity {

    private ListView lv;
    private List<Player> players = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_custom);
        initPlayer();
        lv = findViewById(R.id.lv_custom);
        PlayerAdapter adapter = new PlayerAdapter(ActivityListViewCustom.this,
                R.layout.list_view_item_1, players);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Player player = players.get(position);
                Toast.makeText(ActivityListViewCustom.this,
                        player.getTeamName() + ":" + player.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initPlayer() {
        for (int i = 0; i < 2; i++) {
            Player kobe = new Player("kobe", R.drawable.kobe, "LakersAll");
            players.add(kobe);
            Player casol = new Player("casol", R.drawable.casol, "Lakers2007");
            players.add(casol);
            Player atist = new Player("atist", R.drawable.atist, "Lakers2008");
            players.add(atist);
            Player kuzma = new Player("kuzma", R.drawable.kuzma, "Lakers2018");
            players.add(kuzma);
            Player ingram = new Player("ingram", R.drawable.ingram, "Lakers2016");
            players.add(ingram);
            Player nancy = new Player("nancy", R.drawable.nancy, "Lakers2015");
            players.add(nancy);
            Player ball = new Player("ball", R.drawable.ball, "Lakers2018");
            players.add(ball);

        }
    }
}
