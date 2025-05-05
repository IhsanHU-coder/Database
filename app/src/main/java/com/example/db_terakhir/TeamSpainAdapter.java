package com.example.db_terakhir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TeamSpainAdapter extends RecyclerView.Adapter<TeamSpainAdapter.TeamViewHolder> {
    private Context context;
    private List<TeamSpain> teamList;

    public TeamSpainAdapter(Context context, List<TeamSpain> teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view_spain, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        TeamSpain team = teamList.get(position);
        holder.tvTeamName.setText(team.getStrTeam());
        holder.tvTeamId.setText(team.getIdTeam());
    }

    @Override
    public int getItemCount() {
        return teamList == null ? 0 : teamList.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView tvTeamName, tvTeamId;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeamName = itemView.findViewById(R.id.tvTeamName);
            tvTeamId = itemView.findViewById(R.id.tvTeamId);
        }
    }
}
