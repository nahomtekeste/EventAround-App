package com.example.eventaround_app

import android.R
import android.content.Context
import androidx.annotation.NonNull
import android.widget.TextView
import java.nio.file.Files.size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


class EventAdapter(internal var context: Context, internal var eventList: List<Event>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val itemCount: Int
        get() = eventList.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): EventViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.item_e, null)
        return EventViewHolder(view)
    }

    fun onBindViewHolder(eventViewHolder: EventViewHolder, i: Int) {

        val event = eventList[i]

        eventViewHolder.eventtitle.text = event.eventitle
        eventViewHolder.eventcategory.text = event.eventcategory
        eventViewHolder.eventpicture.setImageDrawable(context.getResources().getDrawable(event.eventpicture))

    }

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var eventtitle: TextView
        var eventcategory: TextView
        var eventpicture: ImageView

        init {

            eventtitle = itemView.findViewById(R.id.eventtitle)
            eventcategory = itemView.findViewById(R.id.eventcategory)
            eventpicture = itemView.findViewById(R.id.eventpicture)


        }
    }

}