package com.android.meetingapp.di.module

import android.content.Context
import com.android.meetingapp.model.dao.MeetingDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MeetingDaoModule(context: Context) {

    @Provides
    @Singleton
    fun  provideDao() : MeetingDao {
        return MeetingDao()
    }


}