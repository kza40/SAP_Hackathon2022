package com.example.sap_social;

import androidx.activity.result.contract.ActivityResultContracts;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private EventManager eventManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventManager = EventManager.getInstance();
        setupActionBar();
        setupBottomNav();
        populateListView();
        setupAddButton();
    }

    private void setupAddButton() {
        ImageButton add = findViewById(R.id.addEventButton);
        add.setOnClickListener(view -> {
            Intent intent = AddEvent.makeIntent(MainActivity.this);
            startActivity(intent);
        });
    }

    private void populateListView() {
        if (eventManager.isEmpty()) {
            emptyState(View.VISIBLE);
        } else {
            emptyState(View.INVISIBLE);
        }
        List<String> theEvents = new ArrayList<>();
        for (Event event: eventManager) {
                theEvents.add(event.getEventTitle() + "\n\n" + event.getEventDescription());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.events_layout, theEvents);
        ListView list = findViewById(R.id.listOfEvents);
        list.setAdapter(adapter);
    }
    private void emptyState(int visible) {
        TextView noTasks = findViewById(R.id.emptyStateEventText);
        noTasks.setVisibility(visible);
    }
    private void setupBottomNav() {
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.homeNAV);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.todolist:
                        Intent intent = to_do.makeIntent(MainActivity.this);
                        startActivity(intent);
                        return true;
                    case R.id.calender:
                        Intent intent2 = Calander.makeIntent(MainActivity.this);
                        startActivity(intent2);
                        return true;
                    case R.id.homeNAV:
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

    private void setupActionBar() {
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        //ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SAP SOCIAL");
        ColorDrawable colour = new ColorDrawable(Color.parseColor("#1976D3"));
        ab.setBackgroundDrawable(colour);
    }
    public static Intent makeIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
}
