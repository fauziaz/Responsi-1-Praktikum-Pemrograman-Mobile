package com.example.responsi1mobileh1d023117.data.api

import com.example.responsi1mobileh1d023117.data.model.Team
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("teams/576")
    fun getTeamData(): Call<Team>
}