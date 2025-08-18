package com.example.assmt02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView result;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI components to Java variables
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.txtResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        // Button listeners
        btnAdd.setOnClickListener(v -> calculate("+"));
        btnSubtract.setOnClickListener(v -> calculate("-"));
        btnMultiply.setOnClickListener(v -> calculate("*"));
        btnDivide.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String op) {
        double n1 = Double.parseDouble(num1.getText().toString());
        double n2 = Double.parseDouble(num2.getText().toString());
        double res = 0;

        switch (op) {
            case "+": res = n1 + n2; break;
            case "-": res = n1 - n2; break;
            case "*": res = n1 * n2; break;
            case "/":
                if (n2 != 0) res = n1 / n2;
                else {
                    result.setText("Cannot divide by zero!");
                    return;
                }
                break;
        }

        result.setText("Result: " + res);
    }
}