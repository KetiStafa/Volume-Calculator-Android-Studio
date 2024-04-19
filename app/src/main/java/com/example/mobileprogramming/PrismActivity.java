package com.example.mobileprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class PrismActivity extends AppCompatActivity {

    private EditText baseEditText;
    private EditText heightEditText;
    private EditText depthEditText;
    private TextView volumeTextView;
    private TextView surfaceAreaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prism);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        baseEditText = findViewById(R.id.base);
        heightEditText = findViewById(R.id.height);
        depthEditText = findViewById(R.id.depth);
        volumeTextView = findViewById(R.id.volume);
        surfaceAreaTextView = findViewById(R.id.surfaceArea);

        Button calculateButton = findViewById(R.id.button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePrism();
            }
        });
    }

    private void calculatePrism() {
        try {

            double base = Double.parseDouble(baseEditText.getText().toString());
            double height = Double.parseDouble(heightEditText.getText().toString());
            double depth = Double.parseDouble(depthEditText.getText().toString());


            double volume = base * height * depth;
            double surfaceArea = (2 * base * depth) + (2 * base * height) + (2 * depth * height);


            volumeTextView.setText("Volume: " + volume);
            surfaceAreaTextView.setText("Surface Area: " + surfaceArea);
        } catch (NumberFormatException e) {

            volumeTextView.setText("Volume: N/A");
            surfaceAreaTextView.setText("Surface Area: N/A");
        }
    }
}
