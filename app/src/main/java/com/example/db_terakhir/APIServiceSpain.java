package com.example.db_terakhir;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServiceSpain {
    @GET("search_all_teams.php?s=Soccer&c=Spain")
    Call<SpainResponse> getTeamSpain();
}
