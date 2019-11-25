package com.example.eventaround_app

class Event {

    lateinit var eventitle: String
    lateinit var eventcategory: String
    var eventpicture: Int? = null

    constructor() {}

    constructor(eventitle: String, eventcategory: String, eventpicture: Int?) {
        this.eventitle = eventitle
        this.eventcategory = eventcategory
        this.eventpicture = eventpicture
    }
}