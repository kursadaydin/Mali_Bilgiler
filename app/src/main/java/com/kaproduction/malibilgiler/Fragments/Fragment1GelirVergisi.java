package com.kaproduction.malibilgiler.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.kaproduction.malibilgiler.Pojo.Calculater;
import com.kaproduction.malibilgiler.Pojo.Info;
import com.kaproduction.malibilgiler.Pojo.RecyclerAdapter;
import com.kaproduction.malibilgiler.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by reis on 04/11/16.
 */

public class Fragment1GelirVergisi extends Fragment implements AdapterView.OnItemSelectedListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    Spinner spinnerYillar;
    EditText editTextTutar;
    TextView textViewSonuc;
    Button buttonHesapla;
    int year;
    AdView adViewGelirVergisi;

    Calculater calculater;

    Double sonuc;




    public static Fragment1GelirVergisi newInstance(String param1, String param2) {
        Fragment1GelirVergisi fragment = new Fragment1GelirVergisi();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment1GelirVergisi() {
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
        View layout = inflater.inflate(R.layout.fragment_1gelirvergisi, container, false);

        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        calculater = new Calculater();
        generateComponents();
    }

    public void generateComponents() {

        spinnerYillar = (Spinner) getActivity().findViewById(R.id.spinnerYillarGelirVergisi);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.yillar, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYillar.setAdapter(adapter);

        editTextTutar = (EditText) getActivity().findViewById(R.id.editTextTutar);
        textViewSonuc = (TextView) getActivity().findViewById(R.id.textViewSonucGelirVergisi);
        buttonHesapla = (Button) getActivity().findViewById(R.id.buttonGelirVergisiHesapla);
        final Double hesaplanacakTutar = Double.valueOf(editTextTutar.getText().toString());


        buttonHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                sonuc = calculater.hesaplananVergiUcret(year, hesaplanacakTutar);
                textViewSonuc.setText(year + " yılı için hesaplanan gelir vergisi " + sonuc + " TL dir.");


            }
        });


        adViewGelirVergisi = (AdView) getActivity().findViewById(R.id.adViewGelirVergisiHesapla);
        AdRequest adRequest = new AdRequest.Builder().build();
        adViewGelirVergisi.loadAd(adRequest);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        year = (int) adapterView.getItemAtPosition(i);
        Toast.makeText(getActivity(), year, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
