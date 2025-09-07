package com.example.secondactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etData;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = findViewById(R.id.etData);   // input field
        btnClick = findViewById(R.id.btnClick); // button

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etData.getText().toString();

                Intent intent = new Intent(MainActivity.this, activity_second.class);
                intent.putExtra("myData", input); // pass data
                startActivity(intent);
            }
        });
    }
}