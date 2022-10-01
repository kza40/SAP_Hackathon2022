package com.example.sap_social

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupButtons();
        setupActionBar()
    }
    private fun setupActionBar() {
        val ab = supportActionBar
        val colour = ColorDrawable(Color.parseColor("#CAE1FF"))
        ab!!.setBackgroundDrawable(colour)
        supportActionBar!!.title = "SAP SOCIAL"
    }

    private fun setupButtons() {
        setupTo_DoButton();
        setupCalenderButton();
    }

    private fun setupCalenderButton() {
        val flipCoinButton = findViewById<Button>(R.id.calanderButton)
        flipCoinButton.setOnClickListener { view: View? ->
            val intent: Intent = Calander.makeIntent(this@MainActivity)
            startActivity(intent)
        }
    }

    private fun setupTo_DoButton() {
        val flipCoinButton = findViewById<Button>(R.id.to_doButton)
        flipCoinButton.setOnClickListener { view: View? ->
            val intent: Intent = to_do.makeIntent(this@MainActivity)
            startActivity(intent)
        }
    }
}