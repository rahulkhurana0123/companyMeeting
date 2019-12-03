package com.android.meetingapp.model.data

import com.google.gson.annotations.SerializedName

data class Meeting(
    @SerializedName("start_time")val startTime : String,
    @SerializedName("end_time")val endTime: String,
    @SerializedName("description") val description: String,
    @SerializedName("participants") val participants: Array<String>
)