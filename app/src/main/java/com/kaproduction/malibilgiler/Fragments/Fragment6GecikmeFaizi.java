package com.kaproduction.malibilgiler.Fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.kaproduction.malibilgiler.R;

import java.util.Calendar;

/**
 * Created by reis on 04/11/16.
 */

public class Fragment6GecikmeFaizi extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    static int gun;
    static int ay;
    static int yil = 0;

    ImageButton imageButtonBaslangicTarihiGecikmeFaizi, imageButtonOdemeTarihiGecikmeFaizi;
    Button buttonGecikmeFaiziHesapla;

    static TextView textViewTarihSecimiGecikmeFaiziBaslangic, textViewTarihSecimiGecikmeFaiziOdeme;

    DatePickerDialog.OnDateSetListener datePickerFragment;

    public static Fragment6GecikmeFaizi newInstance(String param1, String param2) {
        Fragment6GecikmeFaizi fragment = new Fragment6GecikmeFaizi();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment6GecikmeFaizi() {
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
        View layout = inflater.inflate(R.layout.fragment_6gecikmefaizi, container, false);

        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        generateComponents();
    }

    public void generateComponents() {

        imageButtonBaslangicTarihiGecikmeFaizi = (ImageButton) getActivity().findViewById(R.id.imageButtonBaslangicTarihiGecikmeFaizi);
        imageButtonOdemeTarihiGecikmeFaizi = (ImageButton) getActivity().findViewById(R.id.imageButtonOdemeTarihiGecikmeFaizi);
        buttonGecikmeFaiziHesapla = (Button) getActivity().findViewById(R.id.buttonGecikmeFaiziHesapla);

        imageButtonBaslangicTarihiGecikmeFaizi.setOnClickListener(this);
        imageButtonOdemeTarihiGecikmeFaizi.setOnClickListener(this);
        buttonGecikmeFaiziHesapla.setOnClickListener(this);

        textViewTarihSecimiGecikmeFaiziBaslangic = (TextView) getActivity().findViewById(R.id.textViewTarihSecimiGecikmeFaiziBaslangic);
        textViewTarihSecimiGecikmeFaiziOdeme = (TextView) getActivity().findViewById(R.id.textViewTarihSecimiGecikmeFaiziOdeme);


        // AdView mAdView = (AdView) getActivity().findViewById(R.id.adViewTab1);
        // AdRequest adRequest = new AdRequest.Builder().build();
        // mAdView.loadAd(adRequest);


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageButtonBaslangicTarihiGecikmeFaizi:
                DialogFragment baslangicTarihi = new DatePickerFragment();
                baslangicTarihi.show(getActivity().getSupportFragmentManager(), "datePicker");

                break;

            case R.id.imageButtonOdemeTarihiGecikmeFaizi:
                DialogFragment odemeTarihi = new DatePickerFragment();
                odemeTarihi.show(getActivity().getSupportFragmentManager(), "datePicker");

                break;

            case R.id.buttonGecikmeFaiziHesapla:
                Toast.makeText(getActivity().getApplicationContext(), "Hesapla", Toast.LENGTH_SHORT).show();
                break;


        }

    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user

            month = month + 1;

            gun = day;
            ay = month;
            yil = year;

            textViewTarihSecimiGecikmeFaiziBaslangic.setText(day + "/" + month + "/" + year);
            textViewTarihSecimiGecikmeFaiziOdeme.setText(day + "/" + month + "/" + year);


            Toast.makeText(getActivity().getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
        }


        public void ekranaYaz(TextView v, int year, int month, int day) {
            v.setText("Seçilen Tarih : " + day + "/" + month + "/" + year);

        }

    }

}