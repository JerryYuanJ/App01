package com.example.joker.app01.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joker.app01.R;

import com.example.joker.app01.ui.bean.Player;

import java.util.List;

/**
 * RecyclerViewPlayerAdapter
 */

public class RecyclerViewPlayerAdapter extends RecyclerView.Adapter<RecyclerViewPlayerAdapter.ViewHolder> {

    private List<Player> players;

    //数据源的入口
    public RecyclerViewPlayerAdapter(List<Player> players) {
        this.players = players;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_item_1, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Player player = players.get(position);
                Toast.makeText(parent.getContext(),"player image id:"+player.getImageId(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Player player = players.get(position);
                Toast.makeText(parent.getContext(),"player name:"+player.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.teamName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Player player = players.get(position);
                Toast.makeText(parent.getContext(),"player team:"+player.getTeamName(),Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Player player=players.get(position);
        holder.image.setImageResource(player.getImageId());
        holder.name.setText(player.getName());
        holder.teamName.setText(player.getTeamName());
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView teamName;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_player_name);
            teamName = itemView.findViewById(R.id.tv_player_team);
            image = itemView.findViewById(R.id.iv_player);
        }
    }
}
