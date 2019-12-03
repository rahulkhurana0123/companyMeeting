package com.android.meetingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.meetingapp.model.data.Meeting
import com.android.meetingapp.viewModel.MeetingViewModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.DividerItemDecoration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var meetingViewModel = ViewModelProviders.of(this).get(MeetingViewModel::class.java);



       var data = meetingViewModel.retrieveCurrentMeetings(getDate(meetingViewModel.dayCounter),application);

        recyclerView.addItemDecoration(
            DividerItemDecoration(this,1 )
        )

        val adapter = CompanyMeetingAdapter(meetingViewModel)
        recyclerView.adapter = adapter

        val meetingObserver = Observer<List<Meeting>> { meetings ->

            adapter.notifyDataSetChanged()
        }
        data.observe(this,meetingObserver);


        ll_forward.setOnClickListener({ view ->

            meetingViewModel.dayCounter+=1;
            data =   meetingViewModel.retrieveMeetingsforOtherDay(getDate(meetingViewModel.dayCounter),application);
            data.observe(this,meetingObserver);
            Log.d("date..",getDate(meetingViewModel.dayCounter))

        })
        ll_previous.setOnClickListener({ view ->
            meetingViewModel.dayCounter-=1;
            data =   meetingViewModel.retrieveMeetingsforOtherDay(getDate(meetingViewModel.dayCounter),application);
            data.observe(this,meetingObserver);
            Log.d("date..",getDate(meetingViewModel.dayCounter))

        })

    }


    fun getDate(day : Int): String {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        var cal = Calendar.getInstance();
        cal.add(Calendar.DATE,day);
        val date =  cal.getTime()
        return formatter.format(date)
    }

}
