package com.android.meeting.di.component

import com.android.meetingapp.di.module.MeetingDaoModule
import com.android.meetingapp.viewModel.MeetingViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [MeetingDaoModule::class])
interface MeetingDaoComponent {
    fun injectMeetingDaoModule(viewModel : MeetingViewModel)
}