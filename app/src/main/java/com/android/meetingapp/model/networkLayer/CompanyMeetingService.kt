package com.android.meetingapp.model.networkLayer
import com.android.meetingapp.model.data.Meeting
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface CompanyMeetingService{

    @GET("schedule")
    fun retrieveMeetings(
        @Query("date") date : String) : Call<List<Meeting>>
}