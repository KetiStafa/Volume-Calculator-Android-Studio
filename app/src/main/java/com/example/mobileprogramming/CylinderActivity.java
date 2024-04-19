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

public class CylinderActivity extends AppCompatActivity {

    private EditText radiusEditText;
    private EditText heightEditText;
    private TextView volumeTextView;
    private TextView surfaceAreaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        radiusEditText = findViewById(R.id.radius);
        heightEditText = findViewById(R.id.height);
        volumeTextView = findViewById(R.id.volume);
        surfaceAreaTextView = findViewById(R.id.surfaceArea);

        Button calculateButton = findViewById(R.id.button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCylinder();
            }
        });
    }

    private void calculateCylinder() {
        try {

            double radius = Double.parseDouble(radiusEditText.getText().toString());
            double height = Double.parseDouble(heightEditText.getText().toString());


            double volume = Math.PI * Math.pow(radius, 2) * height;
            double surfaceArea = (2 * Math.PI * radius * height) + (2 * Math.PI * Math.pow(radius, 2));


            volumeTextView.setText("Volume: " + volume);
            surfaceAreaTextView.setText("Surface Area: " + surfaceArea);
        } catch (NumberFormatException e) {

            volumeTextView.setText("Volume: N/A");
            surfaceAreaTextView.setText("Surface Area: N/A");
        }
    }
}
