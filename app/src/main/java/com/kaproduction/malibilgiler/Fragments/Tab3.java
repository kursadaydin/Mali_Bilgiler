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
import android.widget.TextView;

import com.kaproduction.malibilgiler.Pojo.Info;
import com.kaproduction.malibilgiler.Pojo.RecyclerAdapter;
import com.kaproduction.malibilgiler.R;

import java.util.ArrayList;

/**
 * Created by reis on 27/10/16.
 */

public class Tab3 extends Fragment implements SearchView.OnQueryTextListener{

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
        public static Tab3 newInstance(String param1, String param2) {
            Tab3 fragment = new Tab3();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
            return fragment;
        }

        public Tab3() {
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
            View layout = inflater.inflate(R.layout.fragment_tab3, container, false);





            return layout;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            generateComponents();
        }

        public void generateComponents() {
            recyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerTab3);
            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            arrayList = new ArrayList<>();
            Info i = new Info(" GSYH (Cari Fiyatlarla)", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/GSYH_cari.htm");
            Info i2 = new Info("GSYH (Sabit Fiyatlarla)", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/GSYH_sabit.htm");
            Info i3 = new Info("Mevsim ve Takvim Etkisinden Arındırılmış GSYH", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/GSYH_mevsim.htm");
            Info i4 = new Info("Saatlik İşgücü Maliyeti Endeksi", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/isgucu_maliyet.htm");
            Info i6 = new Info("Aylık Ortalama Brüt Ücret ve Yıllık Ortalama Brüt Kazanç", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/ortalama_kazanc.htm");
            Info i7 = new Info("İstihdam Edilenlerin Yıllara Göre Dağılımı", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/istihdam.htm");
            Info i8 = new Info("Tüketici Fiyat Endeks Rakamları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/TUFE.htm");
            Info i9 = new Info("Üretici Fiyat Endeks Rakamları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/UFE.htm");
            Info i10 = new Info("Dış Ticaret, 1997-2016", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/dis_ticaret.htm");
            Info i11 = new Info("Konut Satış Sayıları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/konut_satis.htm");
            Info i12 = new Info("Sanayi Ciro Endeksi", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/sanayi_ciro.htm");
            Info i13 = new Info("Sanayi Üretim Endeksi", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/sanayi_uretim.htm");
            Info i14 = new Info("Ticaret ve Hizmet Endeksleri", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/ticaret_hizmet.htm");
            Info i15 = new Info("Tüketici Güven Endeksi", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/tuketici_guven.htm");


            arrayList.add(i);
            arrayList.add(i2);
            arrayList.add(i3);
            arrayList.add(i4);
            arrayList.add(i6);
            arrayList.add(i7);arrayList.add(i8);arrayList.add(i9);arrayList.add(i10);arrayList.add(i11);arrayList.add(i12);
            arrayList.add(i13);
            arrayList.add(i14);
            arrayList.add(i15);


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