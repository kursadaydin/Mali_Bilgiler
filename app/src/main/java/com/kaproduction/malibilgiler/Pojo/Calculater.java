package com.kaproduction.malibilgiler.Pojo;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by reis on 04/11/16.
 */

public class Calculater {

    private int year;
    private double tutar;
    private Date start;
    private Date end;



    public Calculater() {
    }

    public Calculater(int year, double tutar) {
        this.year = year;
        this.tutar = tutar;
    }

    public Calculater(Date start, double tutar, Date end) {
        this.start = start;
        this.tutar = tutar;
        this.end = end;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTutar() {
        return tutar;
    }

    public void setTutar(double tutar) {
        this.tutar = tutar;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Double hesaplananVergiUcret(String year, double income) {
        Double vergi = 0.0;
        switch (year) {
            case "2014":
                if (income <= 11000.0) {
                    vergi = income * 0.15;
                } else if (income > 11000.0 && income < 27000) {
                    vergi = 1650 + (income - 11000) * 0.20;
                } else if (income < 97000 && income >= 27000) {
                    vergi = 4850 + (income - 27000) * 0.27;
                } else if (income >= 97000.0) {
                    vergi = 23750 + (income - 97000) * 0.35;
                }
                break;

            case "2015":
                if (income <= 12000.0) {
                    vergi = income * 0.15;
                } else if (income > 12000.0 && income < 29000) {
                    vergi = 1800 + (income - 12000) * 0.20;
                } else if (income < 106000 && income >= 29000) {
                    vergi = 5200 + (income - 29000) * 0.27;
                } else if (income >= 106000.0) {
                    vergi = 25990 + (income - 106000) * 0.35;
                }
                break;


            case "2016":
                if (income <= 12600.0) {
                    vergi = income * 0.15;
                } else if (income > 12600.0 && income < 30000) {
                    vergi = 1890 + (income - 12600) * 0.20;
                } else if (income < 110000 && income >= 30000) {
                    vergi = 5370 + (income - 30000) * 0.27;
                } else if (income >= 110000.0) {
                    vergi = 26970 + (income - 110000) * 0.35;
                }
                break;


        }


        BigDecimal bd = new BigDecimal(vergi);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    public int birOncekiAy(int kacinciAydayiz) {
        int birOncekiAy = 0;
        if (kacinciAydayiz >= 1) {
            birOncekiAy = kacinciAydayiz - 1;
            return birOncekiAy;
        }
        return 0;
    }


    public Double aylikHesaplananGelirVergisiUcret(String year, int kacinciAy, Double matrah) {

        Double cariAy = 0.0;
        Double birOncekiAy = 0.0;
        Double sonuc = 0.0;
        int i = birOncekiAy(kacinciAy);

        if (i > 0) {
            birOncekiAy = hesaplananVergiUcret(year, matrah);
            cariAy = hesaplananVergiUcret(year, matrah);
            sonuc = cariAy - birOncekiAy;
            return sonuc;
        } else {
            cariAy = hesaplananVergiUcret(year, matrah);
            return cariAy;
        }


    }



    public Double hesaplananVergiUcretDisi(String year, double income) {
        Double vergi = 0.0;
        switch (year) {
            case "2014":
                if (income <= 11000.0) {
                    vergi = income * 0.15;
                } else if (income > 11000.0 && income < 27000) {
                    vergi = 1650 + (income - 11000) * 0.20;
                } else if (income < 60000 && income >= 27000) {
                    vergi = 4850 + (income - 27000) * 0.27;
                } else if (income >= 60000.0) {
                    vergi = 23750 + ((income - 60000) * 0.35);
                }
                break;

            case "2015":
                if (income <= 12000.0) {
                    vergi = income * 0.15;
                } else if (income > 12000.0 && income < 29000) {
                    vergi = 1800 + (income - 12000) * 0.20;
                } else if (income < 66000 && income >= 29000) {
                    vergi = 5200 + (income - 29000) * 0.27;
                } else if (income >= 66000.0) {
                    vergi = 25990 + ((income - 66000) * 0.35);
                }
                break;


            case "2016":
                if (income <= 12600.0) {
                    vergi = income * 0.15;
                } else if (income > 12600.0 && income < 30000) {
                    vergi = 1890 + (income - 12600) * 0.20;
                } else if (income < 69000 && income >= 30000) {
                    vergi = 5370 + (income - 30000) * 0.27;
                } else if (income >= 69000.0) {
                    vergi = 26970 + (income - 69000) * 0.35;
                }
                break;


        }


        BigDecimal bd = new BigDecimal(vergi);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    public Double karPayi(Double brutTutar, String year) {

        Double vergi = 0.0;
        Double stopajTutari = brutTutar * 0.15;
        Double stopajSonrasi = brutTutar - stopajTutari;
        Double istisnaSonrasi = stopajSonrasi - (stopajSonrasi / 2);

        switch (year) {
            case "2014":
                if (istisnaSonrasi >= 27000) {
                    vergi = hesaplananVergiUcretDisi("2014", istisnaSonrasi) - stopajTutari;
                } else {
                    vergi = stopajTutari;
                }

                break;

            case "2015":
                if (istisnaSonrasi >= 29000) {
                    vergi = hesaplananVergiUcretDisi("2015", istisnaSonrasi) - stopajTutari;
                } else {
                    vergi = stopajTutari;
                }

                break;


            case "2016":
                if (istisnaSonrasi >= 30000) {
                    vergi = hesaplananVergiUcretDisi("2016", istisnaSonrasi) - stopajTutari;
                } else {
                    vergi = stopajTutari;
                }

                break;


        }

        Map<String, Double> map = new HashMap<>();
        map.put("stopaj_tutari", stopajTutari);
        map.put("nihai_vergi", vergi);

        BigDecimal bd = new BigDecimal(vergi);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();


    }

    public double netAsgariUcret(int year, Double brutUcret) {

        Double sgkIsci, issizlikIsci, gelirVergisiMatrahi, hesaplananGV, damgaVergisi, agi, netUcret = 0.0;
        Double asgariUcret2016 = 1647.0;
        Double asgariUcret2015 = 1273.5;
        Double asgariUcret2014 = 1071.0;


        switch (year) {
            case 2014:
                sgkIsci = asgariUcret2014 * 0.14;
                issizlikIsci = asgariUcret2014 * 0.01;
                gelirVergisiMatrahi = asgariUcret2014 - sgkIsci - issizlikIsci;
                hesaplananGV = hesaplananVergiUcret("2014", gelirVergisiMatrahi);
                damgaVergisi = asgariUcret2014 * (0.00759);
                agi = asgariGecimIndirimiTutarlari("2014", "bekar");
                netUcret = gelirVergisiMatrahi - hesaplananGV - damgaVergisi + agi;
                break;

            case 2015:
                sgkIsci = asgariUcret2015 * 0.14;
                issizlikIsci = asgariUcret2015 * 0.01;
                gelirVergisiMatrahi = asgariUcret2015 - sgkIsci - issizlikIsci;
                hesaplananGV = hesaplananVergiUcret("2015", gelirVergisiMatrahi);
                damgaVergisi = asgariUcret2015 * (0.00759);
                agi = asgariGecimIndirimiTutarlari("2015", "bekar");
                netUcret = gelirVergisiMatrahi - hesaplananGV - damgaVergisi + agi;

                break;


            case 2016:

                sgkIsci = asgariUcret2016 * 0.14;
                issizlikIsci = asgariUcret2016 * 0.01;
                gelirVergisiMatrahi = asgariUcret2016 - sgkIsci - issizlikIsci;
                hesaplananGV = hesaplananVergiUcret("2015", gelirVergisiMatrahi);
                damgaVergisi = asgariUcret2016 * (0.00759);
                agi = asgariGecimIndirimiTutarlari("2016", "bekar");
                netUcret = gelirVergisiMatrahi - hesaplananGV - damgaVergisi + agi;

                break;


        }


        return netUcret;

    }

    public Double asgariGecimIndirimiTutarlari(String year, String medeniDurum) {
        Double agiTutari = 0.0;

        switch (year) {
            case "2014":
                if (medeniDurum == "bekar") {
                    agiTutari = 80.33;
                } else if (medeniDurum == "evli_es_calismayan_0_cocuk") {
                    agiTutari = 96.39;
                } else if (medeniDurum == "evli_es_calismayan_1_cocuk") {
                    agiTutari = 108.44;
                } else if (medeniDurum == "evli_es_calismayan_2_cocuk") {
                    agiTutari = 120.49;
                } else if (medeniDurum == "evli_es_calismayan_3_cocuk") {
                    agiTutari = 128.53;
                } else if (medeniDurum == "evli_es_calismayan_4_cocuk") {
                    agiTutari = 136.55;
                } else if (medeniDurum == "evli_es_calismayan_5_cocuk") {
                    agiTutari = 136.55;
                } else if (medeniDurum == "evli_es_calisan_0_cocuk") {
                    agiTutari = 80.33;
                } else if (medeniDurum == "evli_es_calisan_1_cocuk") {
                    agiTutari = 92.37;
                } else if (medeniDurum == "evli_es_calisan_2_cocuk") {
                    agiTutari = 104.42;
                } else if (medeniDurum == "evli_es_calisan_3_cocuk") {
                    agiTutari = 112.46;
                } else if (medeniDurum == "evli_es_calisan_4_cocuk") {
                    agiTutari = 120.49;
                } else if (medeniDurum == "evli_es_calisan_5_cocuk") {
                    agiTutari = 128.52;
                }
                return agiTutari;


            case "2015":
                if (medeniDurum == "bekar") {
                    agiTutari = 90.11;
                } else if (medeniDurum == "evli_es_calismayan_0_cocuk") {
                    agiTutari = 108.14;
                } else if (medeniDurum == "evli_es_calismayan_1_cocuk") {
                    agiTutari = 121.65;
                } else if (medeniDurum == "evli_es_calismayan_2_cocuk") {
                    agiTutari = 135.17;
                } else if (medeniDurum == "evli_es_calismayan_3_cocuk") {
                    agiTutari = 153.19;
                } else if (medeniDurum == "evli_es_calismayan_4_cocuk") {
                    agiTutari = 153.19;
                } else if (medeniDurum == "evli_es_calismayan_5_cocuk") {
                    agiTutari = 153.19;
                } else if (medeniDurum == "evli_es_calisan_0_cocuk") {
                    agiTutari = 90.11;
                } else if (medeniDurum == "evli_es_calisan_1_cocuk") {
                    agiTutari = 103.63;
                } else if (medeniDurum == "evli_es_calisan_2_cocuk") {
                    agiTutari = 117.15;
                } else if (medeniDurum == "evli_es_calisan_3_cocuk") {
                    agiTutari = 135.17;
                } else if (medeniDurum == "evli_es_calisan_4_cocuk") {
                    agiTutari = 144.18;
                } else if (medeniDurum == "evli_es_calisan_5_cocuk") {
                    agiTutari = 153.19;
                }

                return agiTutari;

            case "2016":
                if (medeniDurum == "bekar") {
                    agiTutari = 123.53;
                } else if (medeniDurum == "evli_es_calismayan_0_cocuk") {
                    agiTutari = 148.23;
                } else if (medeniDurum == "evli_es_calismayan_1_cocuk") {
                    agiTutari = 166.76;
                } else if (medeniDurum == "evli_es_calismayan_2_cocuk") {
                    agiTutari = 185.29;
                } else if (medeniDurum == "evli_es_calismayan_3_cocuk") {
                    agiTutari = 209.99;
                } else if (medeniDurum == "evli_es_calismayan_4_cocuk") {
                    agiTutari = 209.99;
                } else if (medeniDurum == "evli_es_calismayan_5_cocuk") {
                    agiTutari = 209.99;
                } else if (medeniDurum == "evli_es_calisan_0_cocuk") {
                    agiTutari = 123.53;
                } else if (medeniDurum == "evli_es_calisan_1_cocuk") {
                    agiTutari = 142.05;
                } else if (medeniDurum == "evli_es_calisan_2_cocuk") {
                    agiTutari = 160.58;
                } else if (medeniDurum == "evli_es_calisan_3_cocuk") {
                    agiTutari = 185.29;
                } else if (medeniDurum == "evli_es_calisan_4_cocuk") {
                    agiTutari = 197.64;
                } else if (medeniDurum == "evli_es_calisan_5_cocuk") {
                    agiTutari = 209.99;
                }

                return agiTutari;


        }


        return 0.0;
    }

    public double netKapiciUcret(int year, Double brutKapiciUcret) {

        Double sgkIsci, issizlikIsci, gelirVergisiMatrahi, hesaplananGV, damgaVergisi, agi, netUcret = 0.0;
        Double asgariUcret2016 = 1647.0;
        Double asgariUcret2015 = 1273.5;
        Double asgariUcret2014 = 1071.0;


        switch (year) {
            case 2014:
                sgkIsci = asgariUcret2014 * 0.14;
                issizlikIsci = asgariUcret2014 * 0.01;
                gelirVergisiMatrahi = asgariUcret2014 - sgkIsci - issizlikIsci;
                hesaplananGV = 0.0;
                damgaVergisi = 0.0;
                agi = asgariGecimIndirimiTutarlari("2014", "bekar");
                netUcret = gelirVergisiMatrahi - hesaplananGV - damgaVergisi + agi;
                break;

            case 2015:
                sgkIsci = asgariUcret2015 * 0.14;
                issizlikIsci = asgariUcret2015 * 0.01;
                gelirVergisiMatrahi = asgariUcret2015 - sgkIsci - issizlikIsci;
                hesaplananGV = 0.0;
                damgaVergisi = 0.0;
                agi = asgariGecimIndirimiTutarlari("2015", "bekar");
                netUcret = gelirVergisiMatrahi - hesaplananGV - damgaVergisi + agi;

                break;


            case 2016:

                sgkIsci = asgariUcret2016 * 0.14;
                issizlikIsci = asgariUcret2016 * 0.01;
                gelirVergisiMatrahi = asgariUcret2016 - sgkIsci - issizlikIsci;
                hesaplananGV = 0.0;
                damgaVergisi = 0.0;
                agi = asgariGecimIndirimiTutarlari("2016", "bekar");
                netUcret = gelirVergisiMatrahi - hesaplananGV - damgaVergisi + agi;

                break;


        }


        return netUcret;
    }

    public Double gecikmeZammi(Date start, Date end, Double tutar) {
        Double toplamGecikmeZammiOrani = 0.0;
        Map tarihler = new HashMap();
        tarihler = getFarkTarih(start, end);
        int ay = (int) tarihler.get("farkay");
        int gun = (int) tarihler.get("farkgun");
        //Gecikme zammi aylik olarak hesaplanir ayrica ay kesirleri icin gunluk hesaplama yapilir.....
        double gunlukGecikmeZammiOrani = 1.4 / 30;
        toplamGecikmeZammiOrani = gunlukGecikmeZammiOrani * gun;
        return tutar * toplamGecikmeZammiOrani;
    }

    public Double gecikmeFaizi(Date start, Date end, Double tutar) {
        Double toplamGecikmeFaiziOrani = 0.0;
        Map tarihler = new HashMap();
        tarihler = getFarkTarih(start, end);
        int ay = (int) tarihler.get("farkay");
        int gun = (int) tarihler.get("farkgun");
        //Gecikme faizi aylik olarak hesaplanir ay kesirleri dikkate alinmaz.....
        double gecikmeZammiOrani = 1.4;
        toplamGecikmeFaiziOrani = gecikmeZammiOrani * ay;
        return tutar * toplamGecikmeFaiziOrani;

    }

    public Map getFarkTarih(Date start, Date end) {

        int months, days = 0;
        Map farkMap = null;
        DateTime date1 = new DateTime(start);
        DateTime date2 = new DateTime(end);

        months = Months.monthsBetween(date1, date2).getMonths();
        DateTime newEnd = date2.minusMonths(months);

        days = Days.daysBetween(date1, newEnd).getDays();
        farkMap = new HashMap();
        farkMap.put("farkay", months);
        farkMap.put("farkgun", days);


        return farkMap;

    }

    public int getAydakiGunSayisi(int ay, int yil) {
        Calendar cal = new GregorianCalendar(yil, ay - 1, 1);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);

    }

}
