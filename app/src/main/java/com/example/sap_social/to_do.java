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

public class to_do extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        setupActionBar();
    }
    public static Intent makeIntent(Context context) {
        return new Intent(context, to_do.class);
    }
    private void setupActionBar() {

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TO DO LIST");
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
}