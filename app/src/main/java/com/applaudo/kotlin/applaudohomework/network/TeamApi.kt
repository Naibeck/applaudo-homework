package com.applaudo.kotlin.applaudohomework.network

import com.applaudo.kotlin.applaudohomework.network.model.Team
import retrofit2.Call
import retrofit2.http.GET

interface TeamApi {
    @GET("/external/applaudo_homework.json")
    fun getTeamList(): Call<List<Team>>
}