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

public class SphereActivity extends AppCompatActivity {

    private EditText radiusEditText;
    private TextView volumeTextView;
    private TextView surfaceAreaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        radiusEditText = findViewById(R.id.radius);
        volumeTextView = findViewById(R.id.volume);
        surfaceAreaTextView = findViewById(R.id.surfaceArea);

        Button calculateButton = findViewById(R.id.button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSphere();
            }
        });
    }

    private void calculateSphere() {
        try {

            double radius = Double.parseDouble(radiusEditText.getText().toString());


            double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
            double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);




            volumeTextView.setText("Volume: " + volume);
            surfaceAreaTextView.setText("Surface Area: " + surfaceArea);
        } catch (NumberFormatException e) {

            volumeTextView.setText("Volume: N/A");
            surfaceAreaTextView.setText("Surface Area: N/A");
        }
    }
}
