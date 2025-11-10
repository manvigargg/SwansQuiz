package com.example.swansquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.swansquiz.MainActivity2;
import com.example.swansquiz.R;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    Spinner s1;
    Button b1;
    ImageView i1;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);
        s1 = findViewById(R.id.spinner);
        b1 = findViewById(R.id.button);
        i1= findViewById(R.id.imageView);

        i1.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Toast.makeText(this, "Welcome to Swan's Quiz!", Toast.LENGTH_SHORT).show();
                    v.setAlpha(0.7f); // small visual feedback when touched
                    return true;

                case MotionEvent.ACTION_UP:
                    v.setAlpha(1.0f); // restore normal look
                    return true;
            }
            return false;
        });

        String[] categories = {"General Knowledge", "Science", "Sports"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        s1.setAdapter(adapter);

        b1.setOnClickListener(v -> {
            String name = e1.getText().toString();
            String category = s1.getSelectedItem().toString();

            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("username", name);
                intent.putExtra("category", category);
                startActivity(intent);
            }
        });
    }
}
