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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEvent extends AppCompatActivity {
    public static final String edit = "com.example.cmpt276_parentsupportapp_EDITT";
    public static final String index = "com.example.cmpt276_parentsupportapp_INDEXT";

    private boolean isExistingEventClicked;
    private int indexOfEventClicked;
    EditText eventTitle;
    EditText eventDescription;
    EventManager eventManager;
    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        eventTitle = findViewById(R.id.eventTitleText);
        eventDescription = findViewById(R.id.eventDescriptionText);
        eventManager = EventManager.getInstance();


        extractDataFromIntent();
        if (isExistingEventClicked && indexOfEventClicked != -1) {
            existingEventClicked();
        }

        setupActionBar();
        setUpSaveButton();
    }

    private void existingEventClicked() {
        eventTitle.setText(eventManager.retrieveEventByIdx(indexOfEventClicked).getEventTitle());
        eventDescription.setText(eventManager.retrieveEventByIdx(indexOfEventClicked).getEventDescription());
        eventManager.replaceEvent(eventManager.retrieveEventByIdx(indexOfEventClicked), indexOfEventClicked);
    }

    private void setUpSaveButton() {
        Button save = findViewById(R.id.saveEventButton);
        save.setOnClickListener(view -> {
            if(!eventTitle.getText().toString().equals("")) {
                event = new Event(eventTitle.getText().toString(), eventDescription.getText().toString());
                if(isExistingEventClicked){
                    eventManager.replaceEvent(event, indexOfEventClicked);
                } else{
                    eventManager.addEvent(event);
                }
                finish();
            } else {
                Toast.makeText(AddEvent.this, "Incomplete Title, Cannot Save...", Toast.LENGTH_LONG).show();
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, AddEvent.class);
    }

    private void setupActionBar() {
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ADD A NEW EVENT");
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

    private void extractDataFromIntent() {
        Intent intent = getIntent();
        isExistingEventClicked = intent.getBooleanExtra(edit, false);
        indexOfEventClicked = intent.getIntExtra(index, -1);
    }
    public static Intent makeLaunchIntent(Context c, int index, boolean edit) {
        Intent intent = new Intent(c, AddEvent.class);
        intent.putExtra(AddEvent.index, index);
        intent.putExtra(AddEvent.edit, edit);
        return intent;
    }
}