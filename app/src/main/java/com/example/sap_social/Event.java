package com.example.sap_social;

import java.util.List;

/**
 Task object, holds name and stack of children inorder of who must do the task
 */
public class Event {
    private String eventTitle;
    private String eventDescription;

    public Event(String eventTitle, String eventDescription) {
        this.eventDescription = eventDescription;
        this.eventTitle = eventTitle;
    }

    public void setEventTitle(String name) {
        eventTitle = name;
    }

    public String getEventTitle() {
        return eventTitle;
    }


    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String des){
        this.eventDescription = des;
    }
}
