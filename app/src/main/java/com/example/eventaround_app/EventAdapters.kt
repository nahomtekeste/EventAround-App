package com.example.eventaround_app

import android.R
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventaround_app.EventAdapter.EventViewHolder


class EventAdapter(internal var context: Context, internal var eventList: List<Event>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): EventViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.activity_list_item, null)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(eventViewHolder: EventViewHolder, i: Int) {

        val event = eventList[i]

        eventViewHolder.eventtitle.text = event.eventitle
        eventViewHolder.eventcategory.text = event.eventcategory
        eventViewHolder.eventpicture.setImageDrawable(event.eventpicture?.let {
            context.getResources().getDrawable(
                it
            )
        })

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