package com.applaudo.kotlin.applaudohomework.network.model

import com.google.gson.annotations.SerializedName

data class Team(@SerializedName("id") private val mId: Int,
                @SerializedName("team_name") private val mTeamName: String,
                @SerializedName("since") private val mSince: String,
                @SerializedName("coach") private val mCoach: String,
                @SerializedName("team_nickname") private val mTeamNickname: String,
                @SerializedName("stadium") private val mStadium: String,
                @SerializedName("img_logo") private val mImgLogo: String,
                @SerializedName("img_stadium") private val mImgStadium: String,
                @SerializedName("latitude") private val mLatitude: String,
                @SerializedName("longitude") private val mLongitude: String,
                @SerializedName("website") private val mWebsite: String,
                @SerializedName("tickets_url") private val mTicketsUrl: String,
                @SerializedName("address") private val mAddress: String,
                @SerializedName("phone_number") private val mPhoneNumber: String,
                @SerializedName("description") private val mDescription: String,
                @SerializedName("video_url") private val mVideoUrl: String,
                @SerializedName("schedule_games") private val mGames: List<ScheduleGame>)
