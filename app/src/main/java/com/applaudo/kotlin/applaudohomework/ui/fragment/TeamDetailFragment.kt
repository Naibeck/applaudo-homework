package com.applaudo.kotlin.applaudohomework.ui.fragment

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import butterknife.BindView
import butterknife.ButterKnife
import com.applaudo.kotlin.applaudohomework.R
import com.applaudo.kotlin.applaudohomework.network.model.Team
import com.bumptech.glide.Glide

class TeamDetailFragment : Fragment() {

    @BindView(R.id.tv_team_detail_name)
    lateinit var teamDetailName: TextView

    @BindView(R.id.tv_team_detail_description)
    lateinit var teamDetailDescription: TextView

    @BindView(R.id.iv_team_logo)
    lateinit var teamPicture: ImageView

    @BindView(R.id.vv_team_detail_video)
    lateinit var teamVideo: VideoView

    lateinit private var mTeam: Team

    companion object {
        fun getInstance(team: Team): TeamDetailFragment {
            val arguments = Bundle()
            arguments.putParcelable(Team.TEAM_LIST_TAG, team)

            val teamDetailFragment = TeamDetailFragment()
            teamDetailFragment.arguments = arguments

            return teamDetailFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments.containsKey(Team.TEAM_LIST_TAG)) {
            mTeam = arguments.getParcelable(Team.TEAM_LIST_TAG)
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamDetailName.text = mTeam.mTeamName
        teamDetailDescription.text = mTeam.mDescription
        Glide.with(this)
                .load(mTeam.mImgLogo)
                .into(teamPicture)
        teamVideo.setVideoURI(Uri.parse(mTeam.mVideoUrl))
        teamVideo.start()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root: View = inflater!!.inflate(R.layout.fragment_team_detail, container, false)
        ButterKnife.bind(this, root)
        return root
    }
}