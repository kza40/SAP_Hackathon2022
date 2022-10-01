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

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Calander extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander);

        setupActionBar();
        setupBottomNav();
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, Calander.class);
    }

    private void setupActionBar() {

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        //ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CALENDAR");
        ColorDrawable colour = new ColorDrawable(Color.parseColor("#CAE1FF"));
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
        bottomNavigationView.setSelectedItemId(R.id.calender);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.todolist:
                    Intent intent = to_do.makeIntent(Calander.this);
                    startActivity(intent);
                    return true;
                case R.id.calender:
                    return true;
                case R.id.homeNAV:
                    Intent intent2 = MainActivity.makeIntent(Calander.this);
                    startActivity(intent2);
                    return true;
            }
            return false;
        });
    }
}