package com.applaudo.kotlin.applaudohomework.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Team(@SerializedName("id") val mId: Int,
                @SerializedName("team_name") val mTeamName: String,
                @SerializedName("since") val mSince: String,
                @SerializedName("coach") val mCoach: String,
                @SerializedName("team_nickname") val mTeamNickname: String,
                @SerializedName("stadium") val mStadium: String,
                @SerializedName("img_logo") val mImgLogo: String,
                @SerializedName("img_stadium") val mImgStadium: String,
                @SerializedName("latitude") val mLatitude: String,
                @SerializedName("longitude") val mLongitude: String,
                @SerializedName("website") val mWebsite: String,
                @SerializedName("tickets_url") val mTicketsUrl: String,
                @SerializedName("address") val mAddress: String,
                @SerializedName("phone_number") val mPhoneNumber: String,
                @SerializedName("description") val mDescription: String,
                @SerializedName("video_url") val mVideoUrl: String,
                @SerializedName("schedule_games") val mGames: List<ScheduleGame>) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Team> = object : Parcelable.Creator<Team> {
            override fun createFromParcel(source: Parcel): Team = Team(source)
            override fun newArray(size: Int): Array<Team?> = arrayOfNulls(size)
        }

        @JvmStatic val TEAM_LIST_TAG: String = "team_data"
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
