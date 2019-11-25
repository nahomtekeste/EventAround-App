package com.example.eventaround_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.annotation.NonNull
import androidx.core.view.ViewCompat.animate
import android.R.attr.start
import android.R
import android.widget.LinearLayout
import android.view.animation.AccelerateInterpolator
import androidx.core.os.HandlerCompat.postDelayed
import android.view.Gravity
import androidx.recyclerview.widget.SnapHelper
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {

    internal lateinit var eventsplace: RecyclerView
    internal lateinit var eventAdapter: EventAdapter
    internal lateinit var eventList: MutableList<Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eventsplace = findViewById(R.id.eventsplace)

        eventList = ArrayList()
        eventList.add(
            Event(
                "Ecoturism with a Master Pank",
                "WORKSHOP",
                R.drawable.picone
            )
        )

        eventList.add(
            Event(
                "Cooking with Me and Julie",
                "CLASSES",
                R.drawable.pictwo
            )
        )

        eventList.add(
            Event(
                "Learn Gratitude from Monk",
                "SEMINAR",
                R.drawable.picone
            )
        )
        eventList.add(
            Event(
                "Ecoturism with a Master Pank",
                "WORKSHOP",
                R.drawable.picone
            )
        )

        eventList.add(
            Event(
                "Cooking with Me and Julie",
                "CLASSES",
                R.drawable.pictwo
            )
        )

        eventList.add(
            Event(
                "Learn Gratitude from Monk",
                "SEMINAR",
                R.drawable.picone
            )
        )

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        eventsplace.layoutManager = linearLayoutManager
        eventsplace.setHasFixedSize(true)

        eventAdapter = EventAdapter(this, eventList)
        eventsplace.adapter = eventAdapter

        // snapping the scroll items
        val snapHelper = GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(eventsplace)


        // set a timer for default item
        val handler = Handler()
        handler.postDelayed(Runnable {
            // Do something after 1ms = 100ms
            val viewHolderDefault = eventsplace.findViewHolderForAdapterPosition(0)

            val eventparentDefault = viewHolderDefault!!.itemView.findViewById(R.id.eventparent)
            eventparentDefault.animate().scaleY(1f).scaleX(1f).setDuration(350)
                .setInterpolator(AccelerateInterpolator()).start()

            val eventcategoryDefault = viewHolderDefault.itemView.findViewById(R.id.eventbadge)
            eventcategoryDefault.animate().alpha(1f).setDuration(300).start()
        }, 100)


        // add animate scroll
        eventsplace.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val view = snapHelper.findSnapView(linearLayoutManager)
                    val pos = linearLayoutManager.getPosition(view!!)

                    val viewHolder = eventsplace.findViewHolderForAdapterPosition(pos)

                    val eventparent = viewHolder!!.itemView.findViewById(R.id.eventparent)
                    eventparent.animate().scaleY(1f).scaleX(1f).setDuration(350)
                        .setInterpolator(AccelerateInterpolator()).start()

                    val eventcategory = viewHolder.itemView.findViewById(R.id.eventbadge)
                    eventcategory.animate().alpha(1f).setDuration(300).start()

                } else {

                    val view = snapHelper.findSnapView(linearLayoutManager)
                    val pos = linearLayoutManager.getPosition(view!!)

                    val viewHolder = eventsplace.findViewHolderForAdapterPosition(pos)

                    val eventparent = viewHolder!!.itemView.findViewById(R.id.eventparent)
                    eventparent.animate().scaleY(0.7f).scaleX(0.7f)
                        .setInterpolator(AccelerateInterpolator()).setDuration(350).start()

                    val eventcategory = viewHolder.itemView.findViewById(R.id.eventbadge)
                    eventcategory.animate().alpha(0f).setDuration(300).start()
                }

            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })

    }
}
