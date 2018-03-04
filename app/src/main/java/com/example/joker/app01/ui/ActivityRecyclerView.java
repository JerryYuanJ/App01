package com.example.joker.app01.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.joker.app01.R;
import com.example.joker.app01.ui.adapter.RecyclerViewPlayerAdapter;
import com.example.joker.app01.ui.bean.Player;

import java.util.ArrayList;
import java.util.List;

public class ActivityRecyclerView extends AppCompatActivity {

    private RecyclerView rv;
    private List<Player> players = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initPlayer();
        rv = findViewById(R.id.rv);
        //线性布局
        LinearLayoutManager layout=new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        /*//瀑布流布局,将所有的item分成三列显示
        StaggeredGridLayoutManager layout=new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);*/
        rv.setLayoutManager(layout);
        RecyclerViewPlayerAdapter playerAdapter = new RecyclerViewPlayerAdapter(players);
        rv.setAdapter(playerAdapter);
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
