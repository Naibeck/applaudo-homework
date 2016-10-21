package com.applaudo.kotlin.applaudohomework.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.applaudo.kotlin.applaudohomework.R
import com.applaudo.kotlin.applaudohomework.network.model.Team
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import java.util.*

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {
    private var mTeamList: ArrayList<Team>
    private var mContext: Context

    constructor(teamList: ArrayList<Team>, context: Context) {
        this.mTeamList = teamList
        this.mContext = context
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TeamViewHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.item_team_list, parent, false)
        return TeamViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mTeamList.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder?, position: Int) {
        Glide.with(mContext)
                .load(mTeamList[position].mImgLogo)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder!!.teamPicture)
        holder.teamName.text = mTeamList[position].mTeamName
        holder.teamDescription.text = mTeamList[position].mDescription
    }


    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        @BindView(R.id.iv_item_team_picture)
        lateinit var teamPicture: ImageView

        @BindView(R.id.tv_item_team_list_name)
        lateinit var teamName: TextView

        @BindView(R.id.tv_item_team_list_description)
        lateinit var teamDescription: TextView

        init {
            ButterKnife.bind(this, view)
        }

    }
}