package com.applaudo.kotlin.applaudohomework.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.FrameLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.applaudo.kotlin.applaudohomework.R
import com.applaudo.kotlin.applaudohomework.network.model.Team
import com.applaudo.kotlin.applaudohomework.ui.fragment.TeamDetailFragment

class TeamDetailActivity : AppCompatActivity() {
    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.fl_team_detail_container)
    lateinit var teamDetailContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        ButterKnife.bind(this)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);


        if (savedInstanceState == null) {
            val team: Team = intent.getParcelableExtra(Team.TEAM_LIST_TAG)
            supportFragmentManager.beginTransaction()
                    .add(R.id.fl_team_detail_container, TeamDetailFragment.getInstance(team))
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            navigateUpTo(Intent(this, TeamListActivity::class.java))
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}