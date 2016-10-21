package com.applaudo.kotlin.applaudohomework.ui.acitivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import com.applaudo.kotlin.applaudohomework.R
import com.applaudo.kotlin.applaudohomework.network.TeamService
import com.applaudo.kotlin.applaudohomework.network.model.Team
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * TeamListActivity.kty.kt
 * ---------------
 * This class will handle the list for teams and will handle the clicks
 */

class TeamListActivity : AppCompatActivity() {

    @BindView(R.id.toolbar)
    lateinit var mToolbar: Toolbar

    @BindView(R.id.rv_team_list_data)
    lateinit var mTeamList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_list)

        ButterKnife.bind(this)

        setSupportActionBar(mToolbar)
        setTitle(R.string.app_name)

        getTeamName()
    }

    private fun getTeamName() {
        val callTeamList: Call<List<Team>> = TeamService.getAPI().getTeamList()
        callTeamList.enqueue(object : Callback<List<Team>> {
            override fun onResponse(call: Call<List<Team>>?, response: Response<List<Team>>?) {
                //TODO: Will handle the adapter to set for RecyclerView
            }

            override fun onFailure(call: Call<List<Team>>?, t: Throwable?) {

            }

        })
    }

}
