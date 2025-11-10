package com.example.swansquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.swansquiz.MainActivity3;
import com.example.swansquiz.R;

public class MainActivity2 extends AppCompatActivity {
    TextView t1;
    RadioGroup rg1;
    RadioButton r1, r2, r3;
    CheckBox c1;
    Button b2;

    int score = 0;
    String correctAnswer = "White";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1 = findViewById(R.id.textView);
        rg1 = findViewById(R.id.radioGroup);
        r1 = findViewById(R.id.radioButton);
        r2= findViewById(R.id.radioButton2);
        r3 = findViewById(R.id.radioButton3);
        c1 = findViewById(R.id.checkBox);
        b2 = findViewById(R.id.button2);

        t1.setText("What is Swan's Color");
        r1.setText("Pink");
        r2.setText("White");
        r3.setText("Blue");

        b2.setOnClickListener(v -> {
            int selectedId = rg1.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(this, "Select an answer!", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selected = findViewById(selectedId);
            if (selected.getText().toString().equals(correctAnswer))
                score += 10;

            if (c1.isChecked())
                score += 5;

            Toast.makeText(this, "Quiz Submitted!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra("score", score);
            startActivity(intent);
        });
    }
}
