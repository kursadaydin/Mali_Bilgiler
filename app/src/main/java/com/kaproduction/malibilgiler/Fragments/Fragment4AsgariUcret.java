package com.kaproduction.malibilgiler.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.kaproduction.malibilgiler.Pojo.Calculater;
import com.kaproduction.malibilgiler.R;

import java.math.BigDecimal;


/**
 * Created by reis on 04/11/16.
 */

public class Fragment4AsgariUcret extends Fragment implements AdapterView.OnItemSelectedListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private final Double ASGARIUCRET2014 = 1071.0;
    private final Double ASGARIUCRET2015 = 1201.5;
    private final Double ASGARIUCRET2016 = 1647.0;

    Calculater calculater;

    Spinner spinnerYilSecimi, spinnerAySecimi;
    EditText editTextAsgariUcretTutar, editTextSigortaPrimi, editTextIssizlikPrimi, editTextGelirVergisiMatrahi, editTextGelirVergisiKumulatifMatrahi, editTextHesaplanangelirVergisi, editTextHesaplananDamgaVergisi;
    EditText editTextAsgariGecimIndirimi, editTextNetOdenen;

    public static Fragment4AsgariUcret newInstance(String param1, String param2) {
        Fragment4AsgariUcret fragment = new Fragment4AsgariUcret();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment4AsgariUcret() {
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
        View layout = inflater.inflate(R.layout.fragment_4asgariucret, container, false);

      /*  AdView mAdView = new AdView(getActivity());
        mAdView.setAdUnitId("ca-app-pub-5654718909401990/8805017063");
        mAdView.setAdSize(AdSize.BANNER);
        RelativeLayout rr = (RelativeLayout) layout.findViewById(R.id.relativeLayoutAsgariUcret);
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
        generateComponents();
    }

    public void generateComponents() {
        calculater = new Calculater();
        editTextAsgariUcretTutar = (EditText) getActivity().findViewById(R.id.editTextAsgariUcretTuta);
        editTextSigortaPrimi = (EditText) getActivity().findViewById(R.id.editTextSigortaPrimi);
        editTextIssizlikPrimi = (EditText) getActivity().findViewById(R.id.editTextIssizlikPrimi);
        editTextGelirVergisiMatrahi = (EditText) getActivity().findViewById(R.id.editTextGelirVergisiMatrahi);
        editTextGelirVergisiKumulatifMatrahi = (EditText) getActivity().findViewById(R.id.editTextGelirVergisiKumulatifMatrahi);
        editTextHesaplanangelirVergisi = (EditText) getActivity().findViewById(R.id.editTextHesaplanangelirVergisi);
        editTextHesaplananDamgaVergisi = (EditText) getActivity().findViewById(R.id.editTextHesaplananDamgaVergisi);
        editTextAsgariGecimIndirimi = (EditText) getActivity().findViewById(R.id.editTextAsgariGecimIndirimi);
        editTextNetOdenen = (EditText) getActivity().findViewById(R.id.editTextNetOdenen);

        spinnerAySecimi = (Spinner) getActivity().findViewById(R.id.spinnerAySecimi);
        final ArrayAdapter<CharSequence> adapterAylar = ArrayAdapter.createFromResource(getActivity(), R.array.aylar, android.R.layout.simple_spinner_item);
        adapterAylar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAySecimi.setAdapter(adapterAylar);
        spinnerAySecimi.setOnItemSelectedListener(this);


    }

    public Double getBrutAsgariUcret(String year) {
        Double sonuc = 0.0;
        switch (year) {
            case "2014":
                sonuc = ASGARIUCRET2014;
                break;
            case "2015":
                sonuc = ASGARIUCRET2015;
                break;
            case "2016":
                sonuc = ASGARIUCRET2016;
                break;
        }
        return sonuc;
    }

    public Double getSGKPrim(String year) {
        Double sonuc = 0.0;
        switch (year) {
            case "2014":
                sonuc = ASGARIUCRET2014 * 0.14;
                break;
            case "2015":
                sonuc = ASGARIUCRET2015 * 0.14;
                break;
            case "2016":
                sonuc = ASGARIUCRET2016 * 0.14;
                break;
        }
        return sonuc;
    }

    public Double getIssizlikSigortasi(String year) {
        Double sonuc = 0.0;
        switch (year) {
            case "2014":
                sonuc = ASGARIUCRET2014 * 0.01;
                break;
            case "2015":
                sonuc = ASGARIUCRET2015 * 0.01;
                break;
            case "2016":
                sonuc = ASGARIUCRET2016 * 0.01;
                break;
        }
        return sonuc;
    }

    public Double getGelirVergisiMatrahi(String year) {
        Double sonuc = 0.0;
        switch (year) {
            case "2014":
                sonuc = ASGARIUCRET2014 - getSGKPrim("2014") - getIssizlikSigortasi("2014");
                break;
            case "2015":
                sonuc = ASGARIUCRET2015 - getSGKPrim("2015") - getIssizlikSigortasi("2015");
                break;
            case "2016":
                sonuc = ASGARIUCRET2016 - getSGKPrim("2016") - getIssizlikSigortasi("2016");
                break;
        }
        return sonuc;
    }


    public Double getKumulatifMatrah(String year, long kacinciAy) {
        return getGelirVergisiMatrahi(year) * (kacinciAy + 1);
    }

    public Double getHesaplananGelirVergisi(String year, long i) {
        //Eger ocak ayinindan sonra bir ay geliyorsa yani 0 dan buyuk bir (i) rakam geliyorsa
        //aylik vergiyi bulmak icin kumulatif den bir onceki kumulatifi cikariyoruz...
        //boylelikle aylik gelir vergisini buluyoruz
        Double sonuc = 0.0;

        if (i > 0) {

            switch (year) {
                case "2014":
                    sonuc = (calculater.hesaplananVergiUcret("2014", getKumulatifMatrah(year, (int) i))) - (calculater.hesaplananVergiUcret("2014", getKumulatifMatrah(year, (int) i - 1)));
                    break;
                case "2015":
                    sonuc = (calculater.hesaplananVergiUcret("2015", getKumulatifMatrah(year, (int) i))) - (calculater.hesaplananVergiUcret("2015", getKumulatifMatrah(year, (int) i - 1)));
                    break;
                case "2016":
                    sonuc = (calculater.hesaplananVergiUcret("2016", getKumulatifMatrah(year, (int) i))) - (calculater.hesaplananVergiUcret("2016", getKumulatifMatrah(year, (int) i - 1)));
                    break;
            }
        } else {
            switch (year) {
                case "2014":
                    sonuc = (calculater.hesaplananVergiUcret("2014", getKumulatifMatrah(year, (int) i)));
                    break;
                case "2015":
                    sonuc = (calculater.hesaplananVergiUcret("2015", getKumulatifMatrah(year, (int) i)));
                    break;
                case "2016":
                    sonuc = (calculater.hesaplananVergiUcret("2016", getKumulatifMatrah(year, (int) i)));
                    break;
            }


        }
        return sonuc;
    }

    public Double getDamgaVergisi(String year) {
        Double sonuc = 0.0;
        switch (year) {
            case "2014":
                sonuc = getBrutAsgariUcret("2014") * 0.00759;
                break;
            case "2015":
                sonuc = getBrutAsgariUcret("2015") * 0.00759;
                break;
            case "2016":
                sonuc = getBrutAsgariUcret("2016") * 0.00759;
                break;
        }
        return sonuc;
    }

    public Double getAsgariGecimIndirimi(String year, String medeniDurum) {
        Double sonuc = 0.0;
        switch (year) {
            case "2014":
                sonuc = calculater.asgariGecimIndirimiTutarlari("2014", medeniDurum);
                break;
            case "2015":
                sonuc = calculater.asgariGecimIndirimiTutarlari("2015", medeniDurum);
                break;
            case "2016":
                sonuc = calculater.asgariGecimIndirimiTutarlari("2016", medeniDurum);
                break;
        }
        return sonuc;
    }

    public Double getNetOdenen(String year, String medeniDurum, long i) {
        Double sonuc = 0.0;
        switch (year) {
            case "2014":
                sonuc = getGelirVergisiMatrahi("2014") - getHesaplananGelirVergisi("2014", i) - getDamgaVergisi("2014") + getAsgariGecimIndirimi("2014", medeniDurum);
                break;
            case "2015":
                sonuc = getGelirVergisiMatrahi("20145") - getHesaplananGelirVergisi("2015", i) - getDamgaVergisi("20145") + getAsgariGecimIndirimi("2015", medeniDurum);
                break;
            case "2016":
                sonuc = getGelirVergisiMatrahi("2016") - getHesaplananGelirVergisi("2016", i) - getDamgaVergisi("2016") + getAsgariGecimIndirimi("2016", medeniDurum);
                break;
        }
        return sonuc;
    }

    public void getSonuclar(String year, long i) {
        editTextAsgariUcretTutar.setText(getBrutAsgariUcret(year).toString());
        editTextSigortaPrimi.setText(get2digit(getSGKPrim(year)) + " TL");
        editTextIssizlikPrimi.setText(get2digit((getIssizlikSigortasi(year))) + " TL");
        editTextGelirVergisiMatrahi.setText(get2digit(getGelirVergisiMatrahi(year)) + " TL");
        editTextGelirVergisiKumulatifMatrahi.setText(get2digit(getKumulatifMatrah(year, i)) + " TL");
        editTextHesaplanangelirVergisi.setText(get2digit(getHesaplananGelirVergisi(year, i)) + " TL");
        editTextHesaplananDamgaVergisi.setText(get2digit(getDamgaVergisi(year)) + " TL");
        editTextAsgariGecimIndirimi.setText(get2digit(getAsgariGecimIndirimi(year, "bekar")) + " TL");
        editTextNetOdenen.setText(get2digit(getNetOdenen(year, "bekar", i)) + " TL");


    }

    public Double get2digit(Double result) {
        Double sonuc = 0.0;
        BigDecimal bd = new BigDecimal(result);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        sonuc = bd.doubleValue();
        return sonuc;
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Spinner spinner = (Spinner) adapterView;
        if (spinner.getId() == R.id.spinnerAySecimi) {

            switch (i) {
                case 0:
                    getSonuclar("2016", l);
                    break;
                case 1:
                    getSonuclar("2016", l);
                    break;
                case 2:
                    getSonuclar("2016", l);
                    break;
                case 3:
                    getSonuclar("2016", l);
                    break;
                case 4:
                    getSonuclar("2016", l);
                    break;
                case 5:
                    getSonuclar("2016", l);
                    break;
                case 6:
                    getSonuclar("2016", l);
                    break;
                case 7:
                    getSonuclar("2016", l);
                    break;
                case 8:
                    getSonuclar("2016", l);
                    break;
                case 9:
                    getSonuclar("2016", l);
                    break;
                case 10:
                    getSonuclar("2016", l);
                    break;
                case 11:
                    getSonuclar("2016", l);
                    break;


            }

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
