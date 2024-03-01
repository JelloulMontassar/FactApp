package com.example.factapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultatActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultat);

        int factorial = getIntent().getIntExtra("factorial", 0);

        TextView resultTextView = findViewById(R.id.textView2);
        resultTextView.setText("Factorielle: " + factorial);
    }
}
