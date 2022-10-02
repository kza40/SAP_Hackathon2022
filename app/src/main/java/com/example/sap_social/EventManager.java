package com.example.sap_social;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 Class that manages the inputted tasks, also singleton
 */
public class EventManager implements Iterable<Event> {
    private final List<Event> events = new ArrayList<>();
    private static EventManager instance;

    private EventManager() {
        // private to prevent anyone else from instantiating
    }

    public static EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }
        return instance;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void removeEventByIdx(int idx) {
        events.remove(idx);
    }

    public Event retrieveEventByIdx(int idx){
        return events.get(idx);
    }

    public String getEventTitle(int idx) {
        return events.get(idx).getEventTitle();
    }

    public void replaceEvent(Event event, int idx) {
        events.set(idx, event);
        //events.get(idx).setEventTitle(name);
        //events.get(idx).setEventDescription(Des);
    }

    public boolean isEmpty() {
        return events.isEmpty();
    }

    public List<Event> returnEventListCopy() {
        return events;
    }

    @NonNull
    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}

