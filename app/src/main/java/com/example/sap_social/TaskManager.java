package com.example.sap_social;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 Class that manages the inputted tasks, also singleton
 */
public class TaskManager implements Iterable<String> {
    private final List<String> tasks = new ArrayList<>();
    private static TaskManager instance;

    private TaskManager() {
        // private to prevent anyone else from instantiating
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTaskByIdx(int idx) {
        tasks.remove(idx);
    }

    public String retrieveTaskByIdx(int idx){
        return tasks.get(idx);
    }


    public void replaceTask(String task, int idx) {
        tasks.set(idx, task);
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public List<String> returnTaskListCopy() {
        return tasks;
    }

    @NonNull
    @Override
    public Iterator<String> iterator() {
        return tasks.iterator();
    }
}

