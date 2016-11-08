package com.kaproduction.malibilgiler.Fragments;

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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.kaproduction.malibilgiler.Pojo.Info;
import com.kaproduction.malibilgiler.Pojo.RecyclerAdapter;
import com.kaproduction.malibilgiler.R;

import java.util.ArrayList;
import java.util.Collections;

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
            AdView mAdView = new AdView(getActivity());
            mAdView.setAdUnitId("ca-app-pub-5654718909401990/7293087869");
            mAdView.setAdSize(AdSize.BANNER);
            RelativeLayout rr = (RelativeLayout) layout.findViewById(R.id.content_main);
            rr.addView(mAdView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);


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
            Info i = new Info();
            arrayList = i.getTab4();
            Collections.sort(arrayList, i);

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