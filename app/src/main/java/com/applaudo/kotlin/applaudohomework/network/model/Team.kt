package com.applaudo.kotlin.applaudohomework.network.model

import java.util.*
import android.os.Parcel
import android.os.Parcelable

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
                @SerializedName("schedule_games") private val mGames: List<ScheduleGame>) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Team> = object : Parcelable.Creator<Team> {
            override fun createFromParcel(source: Parcel): Team = Team(source)
            override fun newArray(size: Int): Array<Team?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readInt(), source.readString(), source.readString(), source.readString(), source.readString(), source.readString(), source.readString(), source.readString(), source.readString(), source.readString(), source.readString(), source.readString(), source.readString(), source.readString(), source.readString(), source.readString(), source.createTypedArrayList(ScheduleGame.CREATOR))

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(mId)
        dest?.writeString(mTeamName)
        dest?.writeString(mSince)
        dest?.writeString(mCoach)
        dest?.writeString(mTeamNickname)
        dest?.writeString(mStadium)
        dest?.writeString(mImgLogo)
        dest?.writeString(mImgStadium)
        dest?.writeString(mLatitude)
        dest?.writeString(mLongitude)
        dest?.writeString(mWebsite)
        dest?.writeString(mTicketsUrl)
        dest?.writeString(mAddress)
        dest?.writeString(mPhoneNumber)
        dest?.writeString(mDescription)
        dest?.writeString(mVideoUrl)
        dest?.writeTypedList(mGames)
    }
}
