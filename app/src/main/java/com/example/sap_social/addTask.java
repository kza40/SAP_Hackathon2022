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


public class addTask extends AppCompatActivity {
    EditText taskName;
    TaskManager taskManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskName = findViewById(R.id.taskInputText);
        taskManager = TaskManager.getInstance();

        setupActionBar();
        setupSaveButton();
    }

    private void setupSaveButton() {
        Button save = findViewById(R.id.newTaskButton);
        save.setOnClickListener(view -> {
            if(!taskName.getText().toString().equals("")) {
                taskManager.addTask(taskName.getText().toString());
                finish();
            } else {
                Toast.makeText(addTask.this, "Incomplete Title, Cannot Save...", Toast.LENGTH_LONG).show();
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, addTask.class);
    }

    private void setupActionBar() {

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ADD TASK");
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