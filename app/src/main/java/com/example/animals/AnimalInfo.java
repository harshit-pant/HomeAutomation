package com.example.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalInfo extends AppCompatActivity {

    TextView txt;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);

        txt = findViewById(R.id.animal);
        img = findViewById(R.id.imgCircled);

        Intent intent = getIntent();
        img.setImageResource(intent.getIntExtra("image", R.drawable.ic_launcher_foreground));
        txt.setText(intent.getStringExtra("name"));
    }
}