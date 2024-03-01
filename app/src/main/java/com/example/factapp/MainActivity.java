package com.example.factapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText numInput;
    private Button btnCalc;
    private TextView resultat;
    private Button goTo;
    int fact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        btnCalc = findViewById(R.id.button);
        numInput = findViewById(R.id.editTextNumber);
        resultat = findViewById(R.id.textView4);
        goTo = findViewById(R.id.button2);
        goTo.setEnabled(false);

    }

    private void initEvent() {

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFactorial();
                goTo.setEnabled(true);
            }
        });
        goTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!numInput.getText().toString().equals("")){
                    goTo.setEnabled(true);

                Intent intent = new Intent(MainActivity.this, ResultatActivity.class);

                // Pass the factorial value to ResultActivity
                intent.putExtra("factorial", fact);

                // Start ResultActivity
                startActivity(intent);}
                else{
                    goTo.setEnabled(false);
                }
            }

        });
    }

    public void calculateFactorial() {
        try {
            int num = Integer.parseInt(numInput.getText().toString());
             fact = CalculFactorielle.getFact(num);
            resultat.setText(("Le Factorielle de " + num + " est: " + fact));
        } catch (NumberFormatException e) {
            Log.e("Factorielle", "Invalid input: " + e.getMessage());
        }
    }
}