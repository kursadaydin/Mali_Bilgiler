package com.kaproduction.malibilgiler.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.kaproduction.malibilgiler.Pojo.Calculater;
import com.kaproduction.malibilgiler.R;

import java.math.BigDecimal;

/**
 * Created by reis on 04/11/16.
 */

public class Fragment5KapiciUcret extends Fragment implements AdapterView.OnItemSelectedListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private final Double ASGARIUCRET2014_1 = 1071.0;
    private final Double ASGARIUCRET2014_2 = 1134.0;
    private final Double ASGARIUCRET2015_1 = 1201.5;
    private final Double ASGARIUCRET2015_2 = 1273.5;
    private final Double ASGARIUCRET2016_1 = 1647.0;
    private final Double ASGARIUCRET2016_2 = 1647.0;

    Calculater calculater;

    Spinner spinnerYilSecimi;
    EditText editTextKapiciUcretTutar, editTextSigortaPrimiKapici, editTextIssizlikPrimiKapici, editTextGelirVergisiMatrahiKapici, editTextGelirVergisiKumulatifMatrahiKapici, editTextHesaplanangelirVergisiKapici, editTextHesaplananDamgaVergisiKapici;
    EditText editTextAsgariGecimIndirimiKapici, editTextNetOdenenKapici;

    public static Fragment5KapiciUcret newInstance(String param1, String param2) {
        Fragment5KapiciUcret fragment = new Fragment5KapiciUcret();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment5KapiciUcret() {
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
        View layout = inflater.inflate(R.layout.fragment_5kapiciucret, container, false);

        AdView mAdView = new AdView(getActivity());
        mAdView.setAdUnitId("ca-app-pub-5654718909401990/1281750267");
        mAdView.setAdSize(AdSize.BANNER);
        RelativeLayout rr = (RelativeLayout) layout.findViewById(R.id.relativeLayoutKapiciUcret);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mAdView.setLayoutParams(lp);
        rr.addView(mAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        generateComponents();
    }

    public void generateComponents() {

        calculater = new Calculater();
        editTextKapiciUcretTutar = (EditText) getActivity().findViewById(R.id.editTextKapiciUcretTuta);
        editTextSigortaPrimiKapici = (EditText) getActivity().findViewById(R.id.editTextSigortaPrimiKapici);
        editTextIssizlikPrimiKapici = (EditText) getActivity().findViewById(R.id.editTextIssizlikPrimiKapici);
        editTextNetOdenenKapici = (EditText) getActivity().findViewById(R.id.editTextNetOdenenKapici);

        spinnerYilSecimi = (Spinner) getActivity().findViewById(R.id.spinnerYilSecimi);
        final ArrayAdapter<CharSequence> adapterYillar = ArrayAdapter.createFromResource(getActivity(), R.array.kapiciyillar, android.R.layout.simple_spinner_item);
        adapterYillar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYilSecimi.setAdapter(adapterYillar);
        spinnerYilSecimi.setSelection(adapterYillar.getPosition("2016 2. dönem"));
        spinnerYilSecimi.setOnItemSelectedListener(this);




    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Spinner spinner = (Spinner) adapterView;
        if (spinner.getId() == R.id.spinnerYilSecimi) {
            switch (i) {
                case 0:
                    getSonuclar("2014 1. dönem", i);
                    break;

                case 1:
                    getSonuclar("2014 2. dönem", i);
                    break;

                case 2:
                    getSonuclar("2015 1. dönem", i);
                    break;

                case 3:
                    getSonuclar("2015 2. dönem", i);
                    break;

                case 4:
                    getSonuclar("2016 1. dönem", i);
                    break;

                case 5:
                    getSonuclar("2016 2. dönem", i);
                    break;

            }

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public Double getBrutAsgariUcret(String year) {
        Double sonuc = 0.0;
        switch (year) {
            case "2014 1. dönem":
                sonuc = ASGARIUCRET2014_1;
                break;
            case "2014 2. dönem":
                sonuc = ASGARIUCRET2014_2;
                break;
            case "2015 1. dönem":
                sonuc = ASGARIUCRET2015_1;
                break;
            case "2015 2. dönem":
                sonuc = ASGARIUCRET2015_2;
                break;
            case "2016 1. dönem":
                sonuc = ASGARIUCRET2016_1;
                break;
            case "2016 2. dönem":
                sonuc = ASGARIUCRET2016_2;
                break;
        }
        return sonuc;
    }

    public Double getSGKPrim(String year) {
        Double sonuc = 0.0;
        switch (year) {
            case "2014 1. dönem":
                sonuc = ASGARIUCRET2014_1 * 0.14;
                break;
            case "2014 2. dönem":
                sonuc = ASGARIUCRET2014_2 * 0.14;
                break;
            case "2015 1. dönem":
                sonuc = ASGARIUCRET2015_1 * 0.14;
                break;
            case "2015 2. dönem":
                sonuc = ASGARIUCRET2015_2 * 0.14;
                break;
            case "2016 1. dönem":
                sonuc = ASGARIUCRET2016_1 * 0.14;
                break;
            case "2016 2. dönem":
                sonuc = ASGARIUCRET2016_2 * 0.14;
                break;
        }
        return sonuc;
    }

    public Double getIssizlikSigortasi(String year) {
        Double sonuc = 0.0;
        switch (year) {
            case "2014 1. dönem":
                sonuc = ASGARIUCRET2014_1 * 0.01;
                break;
            case "2014 2. dönem":
                sonuc = ASGARIUCRET2014_2 * 0.01;
                break;
            case "2015 1. dönem":
                sonuc = ASGARIUCRET2015_1 * 0.01;
                break;
            case "2015 2. dönem":
                sonuc = ASGARIUCRET2015_2 * 0.01;
                break;
            case "2016 1. dönem":
                sonuc = ASGARIUCRET2016_1 * 0.01;
                break;
            case "2016 2. dönem":
                sonuc = ASGARIUCRET2016_2 * 0.01;
                break;
        }
        return sonuc;
    }

    public Double getNetOdenen(String year, long i) {
        Double sonuc = 0.0;
        switch (year) {
            case "2014 1. dönem":
                sonuc = getBrutAsgariUcret("2014 1. dönem") - getSGKPrim("2014 1. dönem") - getIssizlikSigortasi("2014 1. dönem");
                break;
            case "2014 2. dönem":
                sonuc = getBrutAsgariUcret("2014 2. dönem") - getSGKPrim("2014 2. dönem") - getIssizlikSigortasi("2014 2. dönem");
                break;
            case "2015 1. dönem":
                sonuc = getBrutAsgariUcret("2015 1. dönem") - getSGKPrim("2015 1. dönem") - getIssizlikSigortasi("2015 1. dönem");
                break;
            case "2015 2. dönem":
                sonuc = getBrutAsgariUcret("2015 2. dönem") - getSGKPrim("2015 2. dönem") - getIssizlikSigortasi("2015 2. dönem");
                break;
            case "2016 1. dönem":
                sonuc = getBrutAsgariUcret("2016 1. dönem") - getSGKPrim("2016 1. dönem") - getIssizlikSigortasi("2016 1. dönem");
                break;
            case "2016 2. dönem":
                sonuc = getBrutAsgariUcret("2016 2. dönem") - getSGKPrim("2016 2. dönem") - getIssizlikSigortasi("2016 2. dönem");
                break;
        }
        return sonuc;
    }

    public void getSonuclar(String year, long i) {

        editTextKapiciUcretTutar.setText(get2digit(getBrutAsgariUcret(year)).toString());
        editTextSigortaPrimiKapici.setText(get2digit(getSGKPrim(year)) + " TL");
        editTextIssizlikPrimiKapici.setText(get2digit((getIssizlikSigortasi(year))) + " TL");
        editTextNetOdenenKapici.setText(get2digit(getNetOdenen(year, i)) + " TL");


    }

    public Double get2digit(Double result) {
        Double sonuc = 0.0;
        BigDecimal bd = new BigDecimal(result);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        sonuc = bd.doubleValue();
        return sonuc;
    }


}
