package com.example.secondactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activity_second extends AppCompatActivity {

    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvData = findViewById(R.id.tvData);

        // Get data from Intent
        String receivedData = getIntent().getStringExtra("myData");

        // Display it
        tvData.setText(receivedData);
    }
}