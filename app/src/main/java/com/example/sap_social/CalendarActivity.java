package com.example.sap_social;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Calendar calendar;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        setupActionBar();


        calendar = Calendar.getInstance();
        setupBottomNav();


        calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 9);
        calendar.set(Calendar.YEAR, 2012);


        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.YEAR, 1);


        calendarView = findViewById(R.id.calendarView);


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {

                CalendarView calendar = findViewById(R.id.calendarView);
                calendar.setVisibility(View.INVISIBLE);
                TextView text = findViewById(R.id.whosComingText);
                text.setText("RAJNESH \nALEX \nKIARASH");
                text.setVisibility(View.VISIBLE);
                Button metoo = findViewById(R.id.metooButton);
                metoo.setVisibility(View.VISIBLE);

                setupOkButton();
                setupMetooButton();
            }

            private void setupMetooButton() {
                Button metoo = findViewById(R.id.metooButton);
                metoo.setOnClickListener(view-> {
                    TextView text = findViewById(R.id.whosComingText);
                    text.append("\nME!");
                    metoo.setVisibility(View.INVISIBLE);
                });
            }

            private void setupOkButton() {
                Button button = findViewById(R.id.okDoneButton);
                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(view -> {
                    CalendarView calendar = findViewById(R.id.calendarView);
                    calendar.setVisibility(View.VISIBLE);
                    TextView text = findViewById(R.id.whosComingText);
                    text.setVisibility(View.INVISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    Button metoo = findViewById(R.id.metooButton);
                    metoo.setVisibility(View.INVISIBLE);
                });
            }
        });
    }

        public static Intent makeIntent (Context context){
            return new Intent(context, CalendarActivity.class);
        }
        private void setupBottomNav () {
            bottomNavigationView = findViewById(R.id.bottom_navigator);
            bottomNavigationView.setSelectedItemId(R.id.calender);

            bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                switch (item.getItemId()) {
                    case R.id.todolist:
                        Intent intent = to_do.makeIntent(CalendarActivity.this);
                        startActivity(intent);
                        return true;
                    case R.id.calender:
                        return true;
                    case R.id.homeNAV:
                        Intent intent2 = MainActivity.makeIntent(CalendarActivity.this);
                        startActivity(intent2);
                        return true;
                }
                return false;
            });
        }
        @Override
        protected void onResume () {
            super.onResume();
            setupBottomNav();
        }
    private void setupActionBar() {

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        //ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CALENDAR");
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

}


