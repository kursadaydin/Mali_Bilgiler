package com.kaproduction.malibilgiler.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.kaproduction.malibilgiler.R;

/**
 * Created by reis on 04/11/16.
 */

public class Fragment2KarPayi extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    Spinner spinnerYillarKarPayi;
    EditText editTextTutarKarPayi;
    TextView textViewSonucKarPayi;
    Button buttonHesaplaKarPayi;
    String year;
    AdView adViewKarPayi;

    Calculater calculater;

    Double sonuc;




    public static Fragment2KarPayi newInstance(String param1, String param2) {
        Fragment2KarPayi fragment = new Fragment2KarPayi();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment2KarPayi() {
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
        View layout = inflater.inflate(R.layout.fragment_2karpayi, container, false);

        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        calculater = new Calculater();
        generateComponents();
    }

    public void generateComponents() {

        spinnerYillarKarPayi = (Spinner) getActivity().findViewById(R.id.spinnerYillarKarPayi);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.yillar, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYillarKarPayi.setAdapter(adapter);
        spinnerYillarKarPayi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                year = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        editTextTutarKarPayi = (EditText) getActivity().findViewById(R.id.editTextTutar);
        textViewSonucKarPayi = (TextView) getActivity().findViewById(R.id.textViewTutarKarPayi);
        buttonHesaplaKarPayi = (Button) getActivity().findViewById(R.id.buttonKarPayiHesapla);

        buttonHesaplaKarPayi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editTextTutarKarPayi.getText().length() == 0) {
                    Toast.makeText(getActivity(), "Değer Girmeden Hesaplama Yapamazsınız", Toast.LENGTH_SHORT).show();
                } else {
                    Double hesaplanacakTutar = Double.valueOf(editTextTutarKarPayi.getText().toString());
                    sonuc = calculater.karPayi(hesaplanacakTutar, year);
                    textViewSonucKarPayi.setText("Brüt " + hesaplanacakTutar + " TL kar payının nihai hesaplanan vergisi " + sonuc + "TL'dir.");
                }

            }
        });


        adViewKarPayi = (AdView) getActivity().findViewById(R.id.adViewKarPayi);
        AdRequest adRequest = new AdRequest.Builder().build();
        adViewKarPayi.loadAd(adRequest);


    }
}
