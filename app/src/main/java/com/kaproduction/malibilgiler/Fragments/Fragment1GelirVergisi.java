package com.kaproduction.malibilgiler.Fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.kaproduction.malibilgiler.Pojo.Calculater;
import com.kaproduction.malibilgiler.R;


/**
 * Created by reis on 04/11/16.
 */

public class Fragment1GelirVergisi extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    Spinner spinnerYillar;
    EditText editTextTutar;
    TextView textViewSonuc;
    Button buttonHesapla, buttonTemizle;
    String year;

    Calculater calculater;

    Double sonuc;

    RadioGroup radioGroup;
    boolean booleanUcret = true;




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

       /* AdView mAdView = new AdView(getActivity());
        mAdView.setAdUnitId("ca-app-pub-5654718909401990/7585635869");
        mAdView.setAdSize(AdSize.BANNER);
        RelativeLayout rr = (RelativeLayout) layout.findViewById(R.id.relativeLayoutGelirVergisi);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mAdView.setLayoutParams(lp);
        rr.addView(mAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/


        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        calculater = new Calculater();
        generateComponents();
    }

    public void generateComponents() {

        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);




        radioGroup = (RadioGroup) getActivity().findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.radio_ucret) {
                    booleanUcret = true;
                } else if (checkedId == R.id.radio_ucretdisi) {
                    booleanUcret = false;
                }
            }
        });


        spinnerYillar = (Spinner) getActivity().findViewById(R.id.spinnerYillarGelirVergisi);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.yillar, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYillar.setAdapter(adapter);
        spinnerYillar.setSelection(adapter.getPosition("2016"));

        spinnerYillar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                year = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        editTextTutar = (EditText) getActivity().findViewById(R.id.editTextTutar);
        textViewSonuc = (TextView) getActivity().findViewById(R.id.textViewSonucGelirVergisi);
        buttonHesapla = (Button) getActivity().findViewById(R.id.buttonGelirVergisiHesapla);
        buttonTemizle = (Button) getActivity().findViewById(R.id.buttonGelirVergisiHesaplaTemizle);

        editTextTutar.setRawInputType(Configuration.KEYBOARD_12KEY);


        buttonHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //once numpad kapatiliyor
                imm.hideSoftInputFromWindow(editTextTutar.getWindowToken(), 0);

                if (editTextTutar.getText().length() == 0) {
                    Toast.makeText(getActivity(), "Değer Girmeden Hesaplama Yapamazsınız", Toast.LENGTH_SHORT).show();
                } else {

                    textViewSonuc.setText("");
                    final Double hesaplanacakTutar = Double.valueOf(editTextTutar.getText().toString());
                    if (booleanUcret) {
                        sonuc = calculater.hesaplananVergiUcret(year, hesaplanacakTutar);
                    } else {
                        sonuc = calculater.hesaplananVergiUcretDisi(year, hesaplanacakTutar);
                    }
                    textViewSonuc.setText(year + " yılı için hesaplanan gelir vergisi " + sonuc + " TL dir.");
                }
            }
        });

        buttonTemizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextTutar.getText().clear();
                textViewSonuc.setText("");

            }
        });




    }


}
