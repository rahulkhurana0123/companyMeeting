package com.android.meetingapp.model.dao

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.meetingapp.MeetingApplication
import com.android.meetingapp.model.data.Meeting
import com.android.meetingapp.model.networkLayer.CompanyMeetingService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MeetingDao {

    @Inject
    lateinit var companyMeetingService: CompanyMeetingService

    fun retrieveMeetings(date : String, application: Application) : LiveData<List<Meeting>> {

        (application as MeetingApplication).getMeetingBaseServiceComponent().injectMeetingBaseServiceModule(this)
        val meetingData : MutableLiveData<List<Meeting>> = MutableLiveData()
       val call = companyMeetingService.retrieveMeetings(  date)
        call.enqueue(object : Callback<List<Meeting>>{
            override fun onFailure(call: Call<List<Meeting>>, t: Throwable) {
                meetingData.value = null
            }



            override fun onResponse(call: Call<List<Meeting>>, response: Response<List<Meeting>>) {
                meetingData.value = response.body()
            }

        })

        return meetingData
    }
}