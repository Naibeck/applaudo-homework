package com.applaudo.kotlin.applaudohomework.network

import com.applaudo.kotlin.applaudohomework.ApplaudoApplication
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private var mTeamApi: TeamApi? = null

class TeamService {
    companion object {
        @Synchronized fun getAPI(): TeamApi {
            return getAPI(TeamApi.URL)
        }

        @Synchronized fun getAPI(url: String): TeamApi {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(ApplaudoApplication.instance!!.gson()))
                    .baseUrl(url)
                    .build()
            mTeamApi = retrofit.create(TeamApi::class.java)

            return mTeamApi!!
        }

    }
}