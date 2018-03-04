package com.example.joker.app01.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joker.app01.ui.bean.Player;

import java.util.List;

import com.example.joker.app01.R;

public class PlayerAdapter extends ArrayAdapter<Player> {
    private int resourceId;

    public PlayerAdapter(@NonNull Context context, int textViewResourceId, List<Player> list) {
        super(context, textViewResourceId, list);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Player player = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView imageView = view.findViewById(R.id.iv_player);
        TextView name = view.findViewById(R.id.tv_player_name);
        TextView team = view.findViewById(R.id.tv_player_team);
        imageView.setImageResource(player.getImageId());
        name.setText(player.getName());
        team.setText(player.getTeamName());
        return view;
    }
}
