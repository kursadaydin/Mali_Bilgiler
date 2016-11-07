package com.kaproduction.malibilgiler.Fragments;

import android.app.Service;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kaproduction.malibilgiler.Other.SoftKeyboard;
import com.kaproduction.malibilgiler.R;

/**
 * Created by reis on 04/11/16.
 */

public class Fragment3Agi extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private static final Double ASGARIUCRET2016 = 1647.0;


    Spinner spinnerYillar;
    RadioGroup radioGroupMedeniDurum, radioGroupEsCalismaDurumu, radioGroupCocukSayisi;
    boolean medeniDurumEvli = true;
    boolean esCalismaDurumu = false;
    int cocukSayisi = 0;
    Double asgariUcret = ASGARIUCRET2016;
    Button buttonAgiGoster;
    TextView textViewAgiGoster;


    public static Fragment3Agi newInstance(String param1, String param2) {
        Fragment3Agi fragment = new Fragment3Agi();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment3Agi() {
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
        View layout = inflater.inflate(R.layout.fragment_3agi, container, false);

        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        generateComponents();
    }

    public void generateComponents() {
        textViewAgiGoster = (TextView) getActivity().findViewById(R.id.textViewAgiGoster);
        radioGroupMedeniDurum = (RadioGroup) getActivity().findViewById(R.id.radioGroupMedeniDurum);
        radioGroupEsCalismaDurumu = (RadioGroup) getActivity().findViewById(R.id.radioGroupEsCalismaDurumu);
        radioGroupCocukSayisi = (RadioGroup) getActivity().findViewById(R.id.radioGroupCocukSayisi);
        buttonAgiGoster = (Button) getActivity().findViewById(R.id.buttonAgiHesapla);
        buttonAgiGoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double result = hesapla(asgariUcret, medeniDurumEvli, esCalismaDurumu, cocukSayisi);
                textViewAgiGoster.setText("Asgari Geçim Tutarınız :" + Math.round(result) + " TL");

            }
        });

        radioGroupMedeniDurum.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                if (checkedId == R.id.radioButtonBekar) {
                    textViewAgiGoster.setText("");
                    medeniDurumEvli = false;
                    for (int i = 0; i < radioGroupCocukSayisi.getChildCount(); i++) {
                        radioGroupCocukSayisi.getChildAt(i).setEnabled(false);
                    }

                    for (int i = 0; i < radioGroupEsCalismaDurumu.getChildCount(); i++) {
                        radioGroupEsCalismaDurumu.getChildAt(i).setEnabled(false);
                    }


                } else if (checkedId == R.id.radioButtonEvli) {
                    textViewAgiGoster.setText("");
                    medeniDurumEvli = true;
                    for (int i = 0; i < radioGroupCocukSayisi.getChildCount(); i++) {
                        radioGroupCocukSayisi.getChildAt(i).setEnabled(true);
                    }

                    for (int i = 0; i < radioGroupEsCalismaDurumu.getChildCount(); i++) {
                        radioGroupEsCalismaDurumu.getChildAt(i).setEnabled(true);
                    }
                }
            }
        });

        radioGroupEsCalismaDurumu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.radioButtonEsCalismaEvet) {
                    textViewAgiGoster.setText("");
                    esCalismaDurumu = true;
                } else if (checkedId == R.id.radioButtonEsCalismaHayir) {
                    textViewAgiGoster.setText("");
                    esCalismaDurumu = false;
                }
            }
        });


        radioGroupCocukSayisi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.radioButton0cocuk) {
                    textViewAgiGoster.setText("");
                    cocukSayisi = 0;
                } else if (checkedId == R.id.radioButton1cocuk) {
                    textViewAgiGoster.setText("");
                    cocukSayisi = 1;
                } else if (checkedId == R.id.radioButton2cocuk) {
                    textViewAgiGoster.setText("");
                    cocukSayisi = 2;
                } else if (checkedId == R.id.radioButton3cocuk) {
                    textViewAgiGoster.setText("");
                    cocukSayisi = 3;
                } else if (checkedId == R.id.radioButton4cocuk) {
                    textViewAgiGoster.setText("");
                    cocukSayisi = 4;
                } else {
                    textViewAgiGoster.setText("");
                    cocukSayisi = 5;
                }
            }
        });







        //   AdView mAdView = (AdView) getActivity().findViewById(R.id.adViewTab1);
        //   AdRequest adRequest = new AdRequest.Builder().build();
        //   mAdView.loadAd(adRequest);


    }


    public Double hesapla(Double asgariUcretTutari, boolean medeniDurum, boolean esCalismaDurumu, int cocukSayisi) {
        Double result = 0.0;
        this.asgariUcret = asgariUcretTutari;
        if (medeniDurum) {
            //evli ise burada
            if (esCalismaDurumu) {
                //eger es calisiyorsa burada
                switch (cocukSayisi) {
                    case 0:
                        result = asgariUcret * (0.50) * (0.15);
                        break;
                    case 1:
                        result = asgariUcret * (0.575) * (0.15);
                        break;
                    case 2:
                        result = asgariUcret * (0.65) * (0.15);
                        break;
                    case 3:
                        result = asgariUcret * (0.75) * (0.15);
                        break;
                    case 4:
                        result = asgariUcret * (0.80) * (0.15);
                        break;
                    case 5:
                        result = asgariUcret * (0.85) * (0.15);
                        break;

                }

            } else {
                //eger es calismiyorsa burada
                switch (cocukSayisi) {
                    case 0:
                        result = asgariUcret * (0.60) * (0.15);
                        break;
                    case 1:
                        result = asgariUcret * (0.675) * (0.15);
                        break;
                    case 2:
                        result = asgariUcret * (0.75) * (0.15);
                        break;
                    case 3:
                        result = asgariUcret * (0.85) * (0.15);
                        break;
                    case 4:
                        result = asgariUcret * (0.85) * (0.15);
                        break;
                    case 5:
                        result = asgariUcret * (0.85) * (0.15);
                        break;
                }

            }

        } else {
            //bekar ise burada
            result = asgariUcret * (0.50) * (0.15);

        }


        return result;
    }


}