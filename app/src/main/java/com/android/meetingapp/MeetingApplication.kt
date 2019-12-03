package com.android.meetingapp

import android.app.Application
import com.android.meeting.di.component.DaggerMeetingDaoComponent
import com.android.meeting.di.component.MeetingDaoComponent
import com.android.meetingapp.di.component.DaggerMeetingBaseServiceComponent
import com.android.meetingapp.di.component.MeetingBaseServiceComponent
import com.android.meetingapp.di.module.MeetingBaseServiceModule
import com.android.meetingapp.di.module.MeetingDaoModule


class MeetingApplication : Application() {

    private lateinit var meetingDaoComponent: MeetingDaoComponent

    private lateinit var meetingBaseServiceComponent: MeetingBaseServiceComponent


    override fun onCreate() {
        super.onCreate()

        meetingDaoComponent = DaggerMeetingDaoComponent.builder()
            .meetingDaoModule(MeetingDaoModule(this))
            .build()

        meetingBaseServiceComponent = DaggerMeetingBaseServiceComponent.builder()
            .meetingBaseServiceModule(MeetingBaseServiceModule(this))
            .build()
    }

    fun getMeetingDaoComponent(): MeetingDaoComponent {
        return meetingDaoComponent
    }

    fun getMeetingBaseServiceComponent(): MeetingBaseServiceComponent {
        return meetingBaseServiceComponent
    }

}