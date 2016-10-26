package com.applaudo.kotlin.applaudohomework.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ProgressBar
import butterknife.BindView
import butterknife.ButterKnife
import com.applaudo.kotlin.applaudohomework.R
import com.applaudo.kotlin.applaudohomework.network.TeamService
import com.applaudo.kotlin.applaudohomework.network.model.Team
import com.applaudo.kotlin.applaudohomework.ui.adapter.ItemTeamClick
import com.applaudo.kotlin.applaudohomework.ui.adapter.TeamAdapter
import com.applaudo.kotlin.applaudohomework.ui.fragment.TeamDetailFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * TeamListActivity.kty.kt
 * ---------------
 * This class will handle the list for teams and will handle the clicks
 */

class TeamListActivity : AppCompatActivity(), ItemTeamClick<Team> {
    @BindView(R.id.toolbar)
    lateinit var mToolbar: Toolbar

    @BindView(R.id.rv_team_list_data)
    lateinit var mTeamList: RecyclerView

    @BindView(R.id.pb_team_list_loading)
    lateinit var mProgressBar: ProgressBar

    private var isDetailShow: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_list)

        ButterKnife.bind(this)

        setSupportActionBar(mToolbar)
        setTitle(R.string.app_name)

        getTeams()

        if (R.id.fl_team_list_detail_container != null) {
            isDetailShow = true
        }
    }

    private fun getTeams() {
        val callTeamList: Call<List<Team>> = TeamService.getAPI().getTeamList()
        callTeamList.enqueue(object : Callback<List<Team>> {
            override fun onResponse(call: Call<List<Team>>?, response: Response<List<Team>>?) {
                val teamList: ArrayList<Team> = response!!.body() as ArrayList<Team>
                val adapter: TeamAdapter = TeamAdapter(teamList, applicationContext, this@TeamListActivity)
                mTeamList.adapter = adapter
                mProgressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<List<Team>>?, t: Throwable?) {

            }

        })
    }

    override fun onResume() {
        super.onResume()
        if (!isDetailShow) {
            supportFragmentManager.beginTransaction().detach(TeamDetailFragment())
                    .commit()
        }
    }

    override fun onItemSelected(item: Team) {
        if (isDetailShow) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_team_list_detail_container, TeamDetailFragment.getInstance(item))
                    .commit()
        } else {
            val intent: Intent = Intent(this, TeamDetailActivity::class.java)
            intent.putExtra(Team.TEAM_LIST_TAG, item)
            startActivity(intent)
        }
    }

}
