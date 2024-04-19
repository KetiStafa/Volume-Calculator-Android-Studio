package com.example.mobileprogramming;

import android.graphics.Color;
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

public class CubeActivity extends AppCompatActivity {

    private EditText length;
    private TextView volumeTextView;
    private TextView surfaceAreaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        length = findViewById(R.id.length);
        volumeTextView = findViewById(R.id.volume);
        surfaceAreaTextView = findViewById(R.id.surfaceArea);

        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    double sideLength = Double.parseDouble(length.getText().toString());


                    double volume = Math.pow(sideLength, 3);
                    double surfaceArea = 6 * Math.pow(sideLength, 2);

                    volumeTextView.setText("Volume: " + volume);
                    surfaceAreaTextView.setText("Surface Area: " + surfaceArea);
                }
                catch (NumberFormatException n){
                    volumeTextView.setText("Volume: N/A");
                    surfaceAreaTextView.setText("Surface Area: N/A");
                }
            }
        });
    }
}