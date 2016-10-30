package com.kaproduction.deneme.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaproduction.deneme.Pojo.Info;
import com.kaproduction.deneme.Pojo.RecyclerAdapter;
import com.kaproduction.deneme.R;

import java.util.ArrayList;

/**
 * Created by reis on 27/10/16.
 */

public class Tab4 extends Fragment implements SearchView.OnQueryTextListener{

        TextView textView;
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        RecyclerView recyclerView;
        RecyclerAdapter recyclerAdapter;
        RecyclerView.LayoutManager layoutManager;
        ArrayList<Info> arrayList;



        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;


        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Tab1.
         */
        // TODO: Rename and change types and number of parameters
        public static Tab4 newInstance(String param1, String param2) {
            Tab4 fragment = new Tab4();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
            return fragment;
        }

        public Tab4() {
            // Required empty public constructor
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
            }
            setHasOptionsMenu(true);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View layout = inflater.inflate(R.layout.fragment_tab4, container, false);





            return layout;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            generateComponents();
        }

        public void generateComponents() {
            recyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerTab4);
            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            arrayList = new ArrayList<>();
            Info i = new Info("deneme", R.mipmap.ic_action_action_assignment_turned_in);
            Info i2 = new Info("ankara", R.mipmap.ic_action_action_assignment_turned_in);
            Info i3 = new Info("istanbul", R.mipmap.ic_action_action_assignment_turned_in);
            arrayList.add(i);
            arrayList.add(i2);
            arrayList.add(i3);

            recyclerAdapter = new RecyclerAdapter(arrayList,getActivity());
            recyclerView.setAdapter(recyclerAdapter);




        }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.menu_tabbed, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Info> newArrayList = new ArrayList<>();

        for (Info information : arrayList) {

            String name = information.getParent().toLowerCase();
            if (name.contains(newText))
                newArrayList.add(information);
        }
        recyclerAdapter.setFilter(newArrayList);
        return true;
    }



    }