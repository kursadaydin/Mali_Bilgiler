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


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.kaproduction.malibilgiler.Pojo.Calculater;
import com.kaproduction.malibilgiler.R;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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

    static TextView textViewTarihSecimiGecikmeFaiziBaslangic;
    static TextView textViewTarihSecimiGecikmeFaiziOdeme;
    TextView textViewAyGunGoster, textViewOranGoster, textViewTutarGoster;
    EditText editTextGecikmeFaizi;

    static EditText baslangicTarihiGecikmeFaizi;
    static EditText odemeTarihiGecikmeFaizi;

    Calculater calculater;

    public static int baslangic_gun = 0;
    public static int baslangic_ay = 0;
    public static int baslangic_yil = 0;

    public static int odeme_gun = 0;
    public static int odeme_ay = 0;
    public static int odeme_yil = 0;

    Date start, end;
    Map<String, Integer> fark;
    int ayFarki, gunFarki;


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

        textViewAyGunGoster = (TextView) getActivity().findViewById(R.id.textViewAyGunGoster);
        textViewOranGoster = (TextView) getActivity().findViewById(R.id.textViewOranGoster);
        textViewTutarGoster = (TextView) getActivity().findViewById(R.id.textViewTutarGoster);


        editTextGecikmeFaizi = (EditText) getActivity().findViewById(R.id.editTextGecikmeFaizi);

        calculater = new Calculater();

        fark = new HashMap<>();


        AdView mAdView = (AdView) getActivity().findViewById(R.id.adViewGecikmeZammi);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }





    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageButtonBaslangicTarihiGecikmeFaizi:
                DialogFragment newFragment = new DatePickerBaslangicFragment();
                newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");


                break;

            case R.id.imageButtonOdemeTarihiGecikmeFaizi:
                DialogFragment newFragment2 = new DatePickerOdemeFragment();
                newFragment2.show(getActivity().getSupportFragmentManager(), "datePicker");

                break;

            case R.id.buttonGecikmeFaiziHesapla:

                if (editTextGecikmeFaizi.getText().length() == 0) {
                    Toast.makeText(getActivity(), "Değer Girmeden Hesaplama Yapamazsınız", Toast.LENGTH_SHORT).show();
                } else {

                    String baslangic = baslangic_gun + "/" + baslangic_ay + "/" + baslangic_yil;
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        start = formatter.parse(baslangic);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    String odeme = odeme_gun + "/" + odeme_ay + "/" + odeme_yil;
                    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        end = format.parse(odeme);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    fark = calculater.getFarkTarih(start, end);

                    // Toast.makeText(getActivity().getApplicationContext(), "2 tarih arasinda " + fark.get("farkay") + " ay ve " + fark.get("farkgun") + " gun vardir. ", Toast.LENGTH_LONG).show();

                    ayFarki = fark.get("farkay");
                    gunFarki = fark.get("farkgun");

                    textViewAyGunGoster.setText("2 tarih arasinda " + fark.get("farkay") + " ay ve " + fark.get("farkgun") + " gun vardir. ");
                    textViewOranGoster.setText("Toplam Oran :" + get2digit(ayFarki * 1.4));
                    Double result = toplamTutarHesapla(Double.parseDouble(editTextGecikmeFaizi.getText().toString()), 1.4);

                    textViewTutarGoster.setText("Toplam ödenmesi gereken tutar : " + get2digit((double) result));

                }


                break;
        }
    }

    public Double toplamTutarHesapla(Double tutar, Double oran) {
        Double result = 0.0;
        Double rate = oran / 100;
        rate = rate + 1;
        result = rate * tutar;

        result = get2digit(result);


        return result;
    }

    public Double get2digit(Double result) {
        Double sonuc = 0.0;
        BigDecimal bd = new BigDecimal(result);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        sonuc = bd.doubleValue();
        return sonuc;
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

            month = month + 1;

            baslangic_gun = day;
            baslangic_ay = month;
            baslangic_yil = year;

            // Toast.makeText(getActivity().getApplicationContext(),"Vade tarihi : "+baslangic_gun+"/"+baslangic_ay+"/"+baslangic_yil+" olarak seçildi",Toast.LENGTH_SHORT).show();
            textViewTarihSecimiGecikmeFaiziBaslangic.setText("Vade tarihi : " + baslangic_gun + "/" + baslangic_ay + "/" + baslangic_yil + " olarak seçildi");


        }




    }

    public static class DatePickerOdemeFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
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


            odeme_gun = day;
            odeme_ay = month;
            odeme_yil = year;
            textViewTarihSecimiGecikmeFaiziOdeme.setText("Ödeme tarihi : " + odeme_gun + "/" + odeme_ay + "/" + odeme_yil + " olarak seçildi");
            //Toast.makeText(getActivity().getApplicationContext(),"Ödeme tarihi : "+odeme_gun+"/"+odeme_ay+"/"+odeme_yil+" olarak seçildi",Toast.LENGTH_SHORT).show();

        }


    }


}

