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

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupActionBar();
        setupBottomNav();
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
    }

    private void setupActionBar() {
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        //ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SAP SOCIAL");
        ColorDrawable colour = new ColorDrawable(Color.parseColor("#CAE1FF"));
        ab.setBackgroundDrawable(colour);
    }
    public static Intent makeIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

}
