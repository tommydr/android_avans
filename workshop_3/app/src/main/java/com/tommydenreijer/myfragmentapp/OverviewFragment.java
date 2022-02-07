package com.tommydenreijer.myfragmentapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class OverviewFragment extends Fragment {

    interface onClickListener
    {
        void onItemSelected(String pokemon);
    }

    onClickListener listener;

    public OverviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        String[] myStringArray = { "Bulbasaur", "Dragonite", "Pikachu" } ;

        ListView listView = view.findViewById(R.id.listView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, myStringArray);

        listView.setAdapter(adapter);



        AdapterView.OnItemClickListener mMessageClickedHandler = new
                AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView parent, View v, int position, long id)
                    {
                        String pokemon = adapter.getItem(position);

                        if (listener != null){
                            listener.onItemSelected(pokemon);
                        }

                    }
                };
        listView.setOnItemClickListener(mMessageClickedHandler);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listener = (MainActivity) getActivity();
    }
}