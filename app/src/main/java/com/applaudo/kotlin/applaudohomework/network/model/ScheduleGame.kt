package com.applaudo.kotlin.applaudohomework.network.model

import com.google.gson.annotations.SerializedName

data class ScheduleGame(@SerializedName("date") private val mDate: String,
                        @SerializedName("stadium") private val mStadium: String)