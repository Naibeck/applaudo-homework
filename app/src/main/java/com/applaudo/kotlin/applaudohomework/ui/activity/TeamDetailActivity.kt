package com.applaudo.kotlin.applaudohomework.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.applaudo.kotlin.applaudohomework.R
import com.applaudo.kotlin.applaudohomework.network.model.Team

class TeamDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        val team: Team = intent.getParcelableExtra(Team.TEAM_LIST_TAG)
        Log.d("TeamDetail", "Team: ${team.mTeamName} ${team.mCoach}")
    }
}