package com.tommydenreijer.workshop_2_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(R.drawable.pikachu, "pikachu"));
        pokemons.add(new Pokemon(R.drawable.bullbasur, "bullbasaur"));
        pokemons.add(new Pokemon(R.drawable.dragonite, "dragonite"));

        PokemonAdapter adapter = new PokemonAdapter(pokemons);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}