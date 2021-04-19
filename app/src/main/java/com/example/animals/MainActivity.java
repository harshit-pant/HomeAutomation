package com.example.animals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalsAdapter.MyClickInterface {

    RecyclerView recyclerView;
    ArrayList<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        animals = new ArrayList<>();


        animals.add(new Animal("Dolphin", R.drawable.dolphin));
        animals.add(new Animal("Dog", R.drawable.dog));
        animals.add(new Animal("Cat", R.drawable.cat));
        animals.add(new Animal("Cow", R.drawable.cow));
        animals.add(new Animal("Tiger", R.drawable.tiger));
        animals.add(new Animal("Lion", R.drawable.lion));
        animals.add(new Animal("Deer", R.drawable.deer));
        animals.add(new Animal("Fox", R.drawable.fox));
        animals.add(new Animal("Owl", R.drawable.owl));
        animals.add(new Animal("Horse", R.drawable.horse));

        AnimalsAdapter animalsAdapter = new AnimalsAdapter(animals, this, this);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animalsAdapter);
    }

    @Override
    public void onItemClickItem(int PositionOfTheAnimal) {
        Toast.makeText(this, "Clicked " +animals.get(PositionOfTheAnimal).getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AnimalInfo.class);
        intent.putExtra("image", animals.get(PositionOfTheAnimal).getImage());
        intent.putExtra("name", animals.get(PositionOfTheAnimal).getName());
        startActivity(intent);
    }
}