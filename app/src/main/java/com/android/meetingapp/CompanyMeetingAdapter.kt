package com.android.meetingapp

import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.android.meetingapp.databinding.ListItemMeetingBinding
import com.android.meetingapp.model.data.Meeting
import com.android.meetingapp.viewModel.MeetingViewModel


class CompanyMeetingAdapter(
    private val meetingViewModel: MeetingViewModel
) : RecyclerView.Adapter<CompanyMeetingAdapter.NewsFeedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NewsFeedViewHolder {
        return NewsFeedViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_meeting,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return try {
            meetingViewModel.meetingLiveData?.value?.size!!
        } catch (e: KotlinNullPointerException) {
            0
        }
    }

    override fun onBindViewHolder(viewHolder: NewsFeedViewHolder, position: Int) {
        viewHolder.itemLayoutBinding.meetingViewModel = meetingViewModel
        viewHolder.itemLayoutBinding.position = position


    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class NewsFeedViewHolder(val itemLayoutBinding: ListItemMeetingBinding) :
        RecyclerView.ViewHolder(itemLayoutBinding.root)

}