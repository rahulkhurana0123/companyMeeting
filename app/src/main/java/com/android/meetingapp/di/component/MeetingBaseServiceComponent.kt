package com.android.meetingapp.di.component

import com.android.meetingapp.di.module.MeetingBaseServiceModule
import com.android.meetingapp.model.dao.MeetingDao
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MeetingBaseServiceModule::class])
interface MeetingBaseServiceComponent {
    fun injectMeetingBaseServiceModule(dao : MeetingDao)
}