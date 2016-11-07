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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.kaproduction.malibilgiler.R;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * Created by reis on 04/11/16.
 */

public class Fragment6GecikmeFaizi extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    ImageButton imageButtonBaslangicTarihiGecikmeFaizi, imageButtonOdemeTarihiGecikmeFaizi;
    Button buttonGecikmeFaiziHesapla;

    TextView textViewTarihSecimiGecikmeFaiziBaslangic, textViewTarihSecimiGecikmeFaiziOdeme;

    static EditText baslangicTarihiGecikmeFaizi;
    static EditText odemeTarihiGecikmeFaizi;

    ArrayList<Integer> listOfDateBaslangic, listOfDateOdeme;

    Verilerim verilerim;


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

        baslangicTarihiGecikmeFaizi = (EditText) getActivity().findViewById(R.id.baslangicTarihiGecikmeFaizi);
        odemeTarihiGecikmeFaizi = (EditText) getActivity().findViewById(R.id.odemeTarihiGecikmeFaizi);

        listOfDateBaslangic = new ArrayList<>();
        listOfDateOdeme = new ArrayList<>();

        verilerim = new DatePickerOdemeFragment();






     /*   DatePickerFragment fragment = new DatePickerFragment();

            if(imageButtonOdemeTarihiGecikmeFaizi.isPressed()){
                listOfDateOdeme.addAll(fragment.getDate());
                odemeTarihiGecikmeFaizi.setText(listOfDateOdeme.get(0)+"/"+listOfDateOdeme.get(1)+"/"+listOfDateOdeme.get(2));
            }else if(imageButtonBaslangicTarihiGecikmeFaizi.isPressed()){
                listOfDateBaslangic.addAll(fragment.getDate());
                baslangicTarihiGecikmeFaizi.setText(listOfDateBaslangic.get(0)+"/"+listOfDateBaslangic.get(1)+"/"+listOfDateBaslangic.get(2));
            }
        if(imageButtonOdemeTarihiGecikmeFaizi.isPressed()){
            DatePickerBaslangicFragment fragment1 = new DatePickerBaslangicFragment();
            listOfDateOdeme.addAll(fragment1.getDate());
            odemeTarihiGecikmeFaizi.setText(listOfDateOdeme.get(0)+"/"+listOfDateOdeme.get(1)+"/"+listOfDateOdeme.get(2));
        }else if(imageButtonBaslangicTarihiGecikmeFaizi.isPressed()){
            DatePickerBaslangicFragment fragment2 = new DatePickerBaslangicFragment();
            listOfDateBaslangic.addAll(fragment2.getDate());
            baslangicTarihiGecikmeFaizi.setText(listOfDateBaslangic.get(0)+"/"+listOfDateBaslangic.get(1)+"/"+listOfDateBaslangic.get(2));
        }*/


    }


        // AdView mAdView = (AdView) getActivity().findViewById(R.id.adViewTab1);
        // AdRequest adRequest = new AdRequest.Builder().build();
        // mAdView.loadAd(adRequest);


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageButtonBaslangicTarihiGecikmeFaizi:
                DialogFragment newFragment = new DatePickerBaslangicFragment();
                newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");

                //listOfDate = fragment.getDate();
                //Toast.makeText(getActivity().getApplicationContext(),listOfDate.get(0)+"/"+listOfDate.get(1)+"/"+listOfDate.get(2),Toast.LENGTH_SHORT).show();

                break;

            case R.id.imageButtonOdemeTarihiGecikmeFaizi:
                DialogFragment newFragment2 = new DatePickerOdemeFragment();
                newFragment2.show(getActivity().getSupportFragmentManager(), "datePicker");

                //listOfDate = fragment2.getDate();
                //Toast.makeText(getActivity().getApplicationContext(),listOfDate.get(0)+"/"+listOfDate.get(1)+"/"+listOfDate.get(2),Toast.LENGTH_SHORT).show();
                break;

            case R.id.buttonGecikmeFaiziHesapla:
                // verilerim = new DatePickerOdemeFragment();
                //  verilerim = (Verilerim) getActivity().getFragmentManager();
                int i = verilerim.veriler().get(0);
                Toast.makeText(getActivity().getApplicationContext(), i, Toast.LENGTH_LONG).show();

                break;


        }

    }


    public static class DatePickerBaslangicFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        ArrayList<Integer> list;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            list = new ArrayList<>();

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            setDate(year, month + 1, day);
            month = month + 1;
            baslangicTarihiGecikmeFaizi.setText(day + "/" + month + "/" + year);


        }

        public ArrayList<Integer> setDate(int year, int month, int day) {

            list.add(day);
            list.add(month);
            list.add(year);

            return list;
        }

        public ArrayList<Integer> getDate() {

            return list;
        }


    }

    public static class DatePickerOdemeFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener, Verilerim {
        ArrayList<Integer> list;

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


            list = new ArrayList<>();
            list.add(day);
            list.add(month);
            list.add(year);
            veriler();

            odemeTarihiGecikmeFaizi.setText(day + "/" + month + "/" + year);


        }


        @Override
        public ArrayList<Integer> veriler() {
            return list;
        }
    }


}

interface Verilerim {

    public ArrayList<Integer> veriler();

}
