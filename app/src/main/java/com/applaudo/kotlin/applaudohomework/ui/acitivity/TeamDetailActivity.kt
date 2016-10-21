package com.applaudo.kotlin.applaudohomework.ui.acitivity

import android.app.TaskStackBuilder
import android.support.v7.app.AppCompatActivity
import com.applaudo.kotlin.applaudohomework.R

/**
 * Created by Trainee-Dev on 10/21/2016.
 */
class TeamDetailActivity : AppCompatActivity() {

    override fun onCreateNavigateUpTaskStack(builder: TaskStackBuilder?) {
        super.onCreateNavigateUpTaskStack(builder)
        setContentView(R.layout.activity_team_detail)
    }

}