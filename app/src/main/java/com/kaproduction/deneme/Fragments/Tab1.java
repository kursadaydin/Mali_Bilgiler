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

public class Tab1 extends Fragment implements SearchView.OnQueryTextListener {
    TextView textView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Info> arrayList;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab1 newInstance(String param1, String param2) {
        Tab1 fragment = new Tab1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Tab1() {
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
        View layout = inflater.inflate(R.layout.fragment_tab1, container, false);

        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        generateComponents();
    }

    public void generateComponents() {
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerTab1);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        arrayList = new ArrayList<>();
        Info i1 = new Info("Amortismana Tabi İktisadi Kıymetler", R.mipmap.ic_action_action_assignment_turned_in);
        Info i2 = new Info("Amortisman Ayırmada Alt Sınır", R.mipmap.ic_action_action_assignment_turned_in);
        Info i3 = new Info("Anlaşmalı Bankalar ", R.mipmap.ic_action_action_assignment_turned_in);
        Info i4 = new Info("Arızi Kazançlara İlişkin İstisna Tutarı", R.mipmap.ic_action_action_assignment_turned_in);
        Info i5 = new Info("Asgari Ücretten Yapılan Kesintileri", R.mipmap.ic_action_action_assignment_turned_in);
        Info i6 = new Info("Ba ve Bs Formlarının Bildirimi", R.mipmap.ic_action_action_assignment_turned_in);
        Info i7 = new Info("Basit Usulde Vergilendirmeye İlişkin Had ve Tutarlar", R.mipmap.ic_action_action_assignment_turned_in);
        Info i8 = new Info("Beyanname Verme ve Ödeme Süreleri", R.mipmap.ic_action_action_assignment_turned_in);
        Info i9 = new Info("Damga Vergisi Tutarları", R.mipmap.ic_action_action_assignment_turned_in);
        Info i10 = new Info("Defter Tutma Hadleri", R.mipmap.ic_action_action_assignment_turned_in);
        Info i11 = new Info("Gecikme Zammı Oranı", R.mipmap.ic_action_action_assignment_turned_in);
        Info i12 = new Info("Gelir Vergisi Tarifesi", R.mipmap.ic_action_action_assignment_turned_in);
        Info i13 = new Info("Gelir Vergisi Kanununun 94. Maddesinde Yer Alan Kesinti Oranları ", R.mipmap.ic_action_action_assignment_turned_in);
        Info i14= new Info("Gelir Vergisi Kanunu Geçici 67. Madde Kapsamında Kesinti Oranları ", R.mipmap.ic_action_action_assignment_turned_in);
        Info i15 = new Info("Harç Tutarları", R.mipmap.ic_action_action_assignment_turned_in);
        Info i16 = new Info("K.D.V. Oranları", R.mipmap.ic_action_action_assignment_turned_in);
        Info i17 = new Info("Mesken Kira Gelirinde İstisna Tutarları", R.mipmap.ic_action_action_assignment_turned_in);
        Info i18 = new Info("MTV Tutarları", R.mipmap.ic_action_action_assignment_turned_in);
        Info i19= new Info("Özel Tüketim Vergisi Tutarları ve Oranları", R.mipmap.ic_action_action_assignment_turned_in);
        Info i20 = new Info("Tecil Faizi Oranı", R.mipmap.ic_action_action_assignment_turned_in);
        Info i21 = new Info("Veraset ve İntikal Vergisi Oranları", R.mipmap.ic_action_action_assignment_turned_in);
        Info i22 = new Info("Vergi Cezaları", R.mipmap.ic_action_action_assignment_turned_in);
        Info i23 = new Info("Vergi Takvimi ", R.mipmap.ic_action_action_assignment_turned_in);
        Info i24= new Info("Vergi Türü Kodları  ", R.mipmap.ic_action_action_assignment_turned_in);
        Info i25 = new Info("Yeniden Değerleme Oranları", R.mipmap.ic_action_action_assignment_turned_in);

        arrayList.add(i1); arrayList.add(i2); arrayList.add(i3); arrayList.add(i4); arrayList.add(i5); arrayList.add(i6); arrayList.add(i7);arrayList.add(i8); arrayList.add(i9); arrayList.add(i10);
        arrayList.add(i11); arrayList.add(i12); arrayList.add(i13); arrayList.add(i14); arrayList.add(i15); arrayList.add(i16); arrayList.add(i17);arrayList.add(i18); arrayList.add(i19); arrayList.add(i20);
        arrayList.add(i21); arrayList.add(i22); arrayList.add(i23); arrayList.add(i24); arrayList.add(i25);


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