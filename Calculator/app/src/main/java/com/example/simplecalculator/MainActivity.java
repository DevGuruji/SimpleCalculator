package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView ans;
    private EditText num1, num2;
    private Button add, subtract, multiplication, divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multiplication = findViewById(R.id.multiplication);
        divide = findViewById(R.id.divide);
        ans = findViewById(R.id.ans);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('+');
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('-');
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('*');
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('/');
            }
        });
    }
        private void calculate(char operator) {
            String n1str = num1.getText().toString();
            String n2str = num2.getText().toString();

            if (!n1str.isEmpty() && !n2str.isEmpty()) {
                double n1 = Double.parseDouble(n1str);
                double n2 = Double.parseDouble(n2str);
                double result = 0;

                switch (operator) {
                    case '+':
                        result = n1 + n2;
                        break;
                    case '-':
                        result = n1 - n2;
                        break;
                    case '*':
                        result = n1 * n2;
                        break;
                    case '/':
                        result = n1 / n2;
                        break;
                }
                DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Format to show two decimal places
                String formattedResult = decimalFormat.format(result);

                ans.setText("Ans: " + formattedResult);

            } else {
                Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();

        }

    }
}