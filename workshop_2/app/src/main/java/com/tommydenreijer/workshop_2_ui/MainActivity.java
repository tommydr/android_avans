package com.tommydenreijer.workshop_2_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] myStringArray = { "Bulbasaur", "Dragonite", "Pikachu" } ;
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, myStringArray);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener mMessageClickedHandler = new
                AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView parent, View v, int position, long id)
                    {
                        String message = adapter.getItem(position);
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                    }
                };
        listView.setOnItemClickListener(mMessageClickedHandler);

    }
}