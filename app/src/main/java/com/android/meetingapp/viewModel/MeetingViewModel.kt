package com.android.meetingapp.viewModel

import android.app.Application
import androidx.lifecycle.LiveData

import androidx.lifecycle.ViewModel
import com.android.meetingapp.MeetingApplication
import com.android.meetingapp.model.dao.MeetingDao
import com.android.meetingapp.model.data.Meeting
import javax.inject.Inject


class MeetingViewModel : ViewModel() {

     var meetingLiveData: LiveData<List<Meeting>>? = null

    var dayCounter : Int  = 0;

    @Inject
    lateinit var newsFeedDao: MeetingDao


    fun retrieveCurrentMeetings(date: String,  application: Application): LiveData<List<Meeting>> {
        if(meetingLiveData == null){
            (application as MeetingApplication).getMeetingDaoComponent().injectMeetingDaoModule(this)
            meetingLiveData = newsFeedDao.retrieveMeetings(date, application)
        }
        return meetingLiveData!!
    }

    fun retrieveMeetingsforOtherDay(date: String,  application: Application): LiveData<List<Meeting>> {
        (application as MeetingApplication).getMeetingDaoComponent().injectMeetingDaoModule(this)
        meetingLiveData = newsFeedDao.retrieveMeetings(date, application)
        return meetingLiveData!!
    }

    fun getMeetingAtIndex(position: Int?) : Meeting?{
        return when {

            meetingLiveData?.value?.size!! > position!! -> meetingLiveData?.value?.get(position)
            else -> null
        }
    }
    }


