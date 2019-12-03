package com.android.meetingapp.di.module

import android.app.Application
import com.android.meetingapp.R
import com.android.meetingapp.model.networkLayer.CompanyMeetingService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class MeetingBaseServiceModule(application: Application) {


    private var baseURL: String = application.getString(R.string.base_url)
    private var builder: Retrofit.Builder

    init {
        builder = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())

    }


    @Provides
    @Singleton
    fun createService(): CompanyMeetingService {
        val retrofit = builder.build()
        return retrofit.create(CompanyMeetingService::class.java)
    }


}