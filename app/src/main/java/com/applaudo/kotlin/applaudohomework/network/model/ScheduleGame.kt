package com.applaudo.kotlin.applaudohomework.network.model

import java.util.*
import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

data class ScheduleGame(@SerializedName("date") private val mDate: String,
                        @SerializedName("stadium") private val mStadium: String) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<ScheduleGame> = object : Parcelable.Creator<ScheduleGame> {
            override fun createFromParcel(source: Parcel): ScheduleGame = ScheduleGame(source)
            override fun newArray(size: Int): Array<ScheduleGame?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(mDate)
        dest?.writeString(mStadium)
    }
}