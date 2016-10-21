package com.applaudo.kotlin.applaudohomework.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.applaudo.kotlin.applaudohomework.network.model.Team

class TeamDetailFragment : Fragment() {
    companion object {
        fun getInstance(team: Team): TeamDetailFragment {
            val arguments = Bundle()
            arguments.putParcelable(Team.TEAM_LIST_TAG, team)

            val teamDetailFragment = TeamDetailFragment()
            teamDetailFragment.arguments = arguments

            return teamDetailFragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
    }
}