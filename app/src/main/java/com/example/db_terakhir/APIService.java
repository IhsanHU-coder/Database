package com.example.db_terakhir;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("search_all_teams.php")
    Call<TeamResponse> getTeams(@Query("l") String league);
}

