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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    Button buttonHesaplaKarPayi, buttonTemizleKarPayi;
    String year;
    //AdView adViewKarPayi;

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

        /*AdView mAdView = new AdView(getActivity());
        mAdView.setAdUnitId("ca-app-pub-5654718909401990/5352023060");
        mAdView.setAdSize(AdSize.BANNER);
        RelativeLayout rr = (RelativeLayout) layout.findViewById(R.id.relativeLayoutKarpayi);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mAdView.setLayoutParams(lp);
        rr.addView(mAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
*/

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

        spinnerYillarKarPayi = (Spinner) getActivity().findViewById(R.id.spinnerYillarKarPayi);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.yillar, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYillarKarPayi.setAdapter(adapter);
        spinnerYillarKarPayi.setSelection(adapter.getPosition("2016"));
        spinnerYillarKarPayi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                year = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        editTextTutarKarPayi = (EditText) getActivity().findViewById(R.id.editTextTutarKarPayi);
        textViewSonucKarPayi = (TextView) getActivity().findViewById(R.id.textViewSonucKarPayi);
        buttonHesaplaKarPayi = (Button) getActivity().findViewById(R.id.buttonKarPayiHesapla);
        buttonTemizleKarPayi = (Button) getActivity().findViewById(R.id.buttonKarPayiTemizle);

        editTextTutarKarPayi.setRawInputType(Configuration.KEYBOARD_12KEY);


        buttonTemizleKarPayi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextTutarKarPayi.getText().clear();
                textViewSonucKarPayi.setText("");
            }
        });

        buttonHesaplaKarPayi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //once numpad kapatiliyor
                imm.hideSoftInputFromWindow(editTextTutarKarPayi.getWindowToken(), 0);

                if (editTextTutarKarPayi.getText().length() == 0) {
                    Toast.makeText(getActivity(), "Değer Girmeden Hesaplama Yapamazsınız", Toast.LENGTH_SHORT).show();
                } else {
                    //softKeyboard.closeSoftKeyboard();
                    Double hesaplanacakTutar = Double.valueOf(editTextTutarKarPayi.getText().toString());
                    sonuc = calculater.karPayi(hesaplanacakTutar, year);
                    if (sonuc < 0) {
                        textViewSonucKarPayi.setText("Yapılan hesaplama sonucu " + Math.abs(sonuc) + "TL tutarında iadeniz çıkmaktadır.");
                    } else {
                        textViewSonucKarPayi.setText("Yapılan hesaplama sonucu " + (sonuc) + "TL tutarında vergi ödemeniz gerekmektedir.");
                    }

                }

            }
        });


    }
}
