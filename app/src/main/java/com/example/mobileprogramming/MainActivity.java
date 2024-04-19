package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Shape> shapesList = new ArrayList<>();
        shapesList.add(new Shape(R.drawable.sphere, "Sphere"));
        shapesList.add(new Shape(R.drawable.cube, "Cube"));
        shapesList.add(new Shape(R.drawable.cylinder, "Cylinder"));
        shapesList.add(new Shape(R.drawable.prism, "Prism"));


        MyCustomAdapter adapter = new MyCustomAdapter(shapesList, this);
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent;
            switch (position) {
                case 0: // Sphere
                    intent = new Intent(MainActivity.this, SphereActivity.class);
                    startActivity(intent);
                    break;
                case 1: // Cube
                    intent = new Intent(MainActivity.this, CubeActivity.class);
                    startActivity(intent);
                    break;
                case 2: // Cylinder
                    intent = new Intent(MainActivity.this, CylinderActivity.class);
                    startActivity(intent);
                    break;
                case 3: // Prism
                    intent = new Intent(MainActivity.this, PrismActivity.class);
                    startActivity(intent);
                    break;
            }
        });
    }
}


