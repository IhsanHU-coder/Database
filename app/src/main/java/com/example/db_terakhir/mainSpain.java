package com.example.db_terakhir;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mainSpain extends AppCompatActivity {
    private RecyclerView rvTeamSpain;
    private TeamSpainAdapter teamSpainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_spain);

        rvTeamSpain = findViewById(R.id.rvTeamSpain);
        rvTeamSpain.setLayoutManager(new LinearLayoutManager(this));

        fetchTeams();
    }

    private void fetchTeams() {
        APIServiceSpain apiService = ApiClient.getClient().create(APIServiceSpain.class);
        Call<SpainResponse> call = apiService.getTeamSpain();

        call.enqueue(new Callback<SpainResponse>() {
            @Override
            public void onResponse(Call<SpainResponse> call, Response<SpainResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<TeamSpain> teams = response.body().getTeams();
                    teamSpainAdapter = new TeamSpainAdapter(mainSpain.this, teams);
                    rvTeamSpain.setAdapter(teamSpainAdapter);
                } else {
                    Toast.makeText(mainSpain.this, "Failed to get team list", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SpainResponse> call, Throwable t) {
                Toast.makeText(mainSpain.this, "API Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("API", "onFailure: ", t);
            }
        });
    }

    public void back(View view) {
        Intent intent = new Intent(mainSpain.this, Menu.class);
        startActivity(intent);
    }
}
