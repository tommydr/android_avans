package com.tommydenreijer.myfragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OverviewFragment.onClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        boolean portrait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;

        if (portrait){
            manager.beginTransaction().add(R.id.container, new OverviewFragment(), "overview").commit();
        }

    }

    @Override
    public void onItemSelected(String pokemon) {

        boolean portrait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;

        if (portrait){
            FragmentManager manager = getSupportFragmentManager();

            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(new Bundle());
            fragment.getArguments().putString("Pokemon", pokemon);

            manager.beginTransaction().replace(R.id.container, fragment, "detail").addToBackStack(null).commit();
        }
        else {
            DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
            detailFragment.setPokemon(pokemon);
        }
    }
}