package com.example.sap_social;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class to_do extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private TaskManager taskManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        taskManager = TaskManager.getInstance();

        setupActionBar();
        setupBottomNav();
        setupFAB();
        populateListView();
    }

    private void populateListView() {
//        if (eventManager.isEmpty()) {
//            emptyState(View.VISIBLE);
//        } else {
//            emptyState(View.INVISIBLE);
//        }
        List<String> theTasks = new ArrayList<>();
        for (String task: taskManager) {
            theTasks.add(task);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.todo_layout, R.id.toDoText, theTasks);
        ListView list = findViewById(R.id.toDoListView);
        list.setAdapter(adapter);
    }

    private void setupFAB() {
        FloatingActionButton fab = findViewById(R.id.floatingActionButtonToDO);
        fab.setOnClickListener(view->{
            Intent intent = addTask.makeIntent(to_do.this);
            startActivity(intent);
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, to_do.class);
    }
    private void setupActionBar() {

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        //ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TO DO LIST");
        ColorDrawable colour = new ColorDrawable(Color.parseColor("#1976D3"));
        ab.setBackgroundDrawable(colour);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupBottomNav() {
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.todolist);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.todolist:
                        return true;
                    case R.id.calender:
                        Intent intent = CalendarActivity.makeIntent(to_do.this);
                        startActivity(intent);
                        return true;
                    case R.id.homeNAV:
                        Intent intent2 = MainActivity.makeIntent(to_do.this);
                        startActivity(intent2);
                        return true;
                }
                return false;
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        setupBottomNav();
        populateListView();
    }
}