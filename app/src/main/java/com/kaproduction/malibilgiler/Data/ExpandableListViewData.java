package com.kaproduction.malibilgiler.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by reis on 28/10/16.
 */

public class ExpandableListViewData {

    public static HashMap<String, List<String>> getInfo()
    {
        HashMap<String, List<String>> infos = new HashMap<String, List<String>>();

        List<String> asgariUcret = new ArrayList<String>();


        asgariUcret.add("01.01.2011 -30.06.2011\t\t\t\t\t\t796,50TL");
        asgariUcret.add("01.07.2011 -31.12.2011\t\t\t\t\t\t837,00TL");
        asgariUcret.add("01.01.2012 -30.06.2012\t\t\t\t\t\t886,50TL");
        asgariUcret.add("01.07.2012 -31.12.2012\t\t\t\t\t\t940,50TL");
        asgariUcret.add("01.01.2013 -30.06.2013\t\t\t\t\t\t978,60TL");
        asgariUcret.add("01.07.2013 -31.12.2013\t\t\t\t\t\t1,021,50TL");
        asgariUcret.add("01.01.2014 -30.06.2014\t\t\t\t\t\t1,071,00TL");
        asgariUcret.add("01.07.2014 -31.12.2014\t\t\t\t\t\t1,134,00TL");
        asgariUcret.add("01.01.2015 -30.06.2015\t\t\t\t\t\t1,201,50TL");
        asgariUcret.add("01.07.2015 -31.12.2015\t\t\t\t\t\t1,273,50TL");
        asgariUcret.add("01.01.2016 -31.12.2016\t\t\t\t\t\t1,647,00TL");
        asgariUcret.add("01.01.2017 -31.12.2017  ........");

        List<String> agiTutarlari = new ArrayList<String>();

        agiTutarlari.add("BEKAR 123,53 TL");
        agiTutarlari.add("EVLİ EŞİ ÇALIŞMAYAN 0 ÇOCUKLU 148,23 TL");
        agiTutarlari.add("EVLİ EŞİ ÇALIŞMAYAN 1 ÇOCUKLU 166,76 TL");
        agiTutarlari.add("EVLİ EŞİ ÇALIŞMAYAN 2 ÇOCUKLU 185,29 TL");
        agiTutarlari.add("EVLİ EŞİ ÇALIŞMAYAN 3 ÇOCUKLU 209,99 TL");
        agiTutarlari.add("EVLİ EŞİ ÇALIŞMAYAN 4 ÇOCUKLU 209,99 TL");
        agiTutarlari.add("EVLİ EŞİ ÇALIŞMAYAN 5 ÇOCUKLU 209,99 TL");
        agiTutarlari.add("EVLİ EŞİ ÇALIŞAN 0 ÇOCUKLU 123,53 TL");
        agiTutarlari.add("EVLİ EŞİ ÇALIŞAN 1 ÇOCUKLU 142,05 TL");
        agiTutarlari.add("EVLİ EŞİ ÇALIŞAN 2 ÇOCUKLU 160,58 TL");
        agiTutarlari.add("EVLİ EŞİ ÇALIŞAN 3 ÇOCUKLU 185,29 TL");
        agiTutarlari.add("EVLİ EŞİ ÇALIŞAN 4 ÇOCUKLU 197,64 TL");
        agiTutarlari.add("EVLİ EŞİ ÇALIŞAN 5 ÇOCUKLU 209,99 TL");

        List<String> ydo= new ArrayList<String>();
        ydo.add("2006 yılı yeniden değerleme oranı :%7,8");
        ydo.add("2007 yılı yeniden değerleme oranı :%7,2");
        ydo.add("2008 yılı yeniden değerleme oranı :%12");
        ydo.add("2009 yılı yeniden değerleme oranı :%2,2");
        ydo.add("2010 yılı yeniden değerleme oranı :%7,7");
        ydo.add("2011 yılı yeniden değerleme oranı :%10,26");
        ydo.add("2012 yılı yeniden değerleme oranı :%7,80");
        ydo.add("2013 yılı yeniden değerleme oranı :%3,93");
        ydo.add("2014 yılı yeniden değerleme oranı :%10,11");
        ydo.add("2015 yılı yeniden değerleme oranı :%5,58");
        ydo.add("2016 yılı yeniden değerleme oranı :%7,7");

        List<String> tecil_faizi= new ArrayList<String>();
        tecil_faizi.add("25.01.2000 - 20.12.2000 tarihleri arasında :%48");
        tecil_faizi.add("21.12.2000 - 30.03.2001 tarihleri arasında :%36");
        tecil_faizi.add("31.03.2001 - 01.02.2002 tarihleri arasında :%72");
        tecil_faizi.add("02.02.2002 - 11.11.2003 tarihleri arasında :%60");
        tecil_faizi.add("12.11.2003 - 03.03.2005 tarihleri arasında :%36");
        tecil_faizi.add("04.03.2005 - 27.04.2006 tarihleri arasında :%30");
        tecil_faizi.add("28.04.2006 – 20.11.2009 tarihleri arasında :%24");
        tecil_faizi.add("21.11.2009 - 21.10.2010 tarihleri arasında   :%19");
        tecil_faizi.add("21.10.2010 tarihinden itibaren :%12");

        List<String> arizi_kazanc_siniri = new ArrayList<String>();
        arizi_kazanc_siniri.add("2012 yılı için :20 000 TL");
        arizi_kazanc_siniri.add("2013 yılı için :21 000 TL");
        arizi_kazanc_siniri.add("2014 yılı için :21 000 TL");
        arizi_kazanc_siniri.add("2015 yılı için :23 000 TL");
        arizi_kazanc_siniri.add("2016 yılı için :24 000 TL");

        List<String> fatura_siniri = new ArrayList<String>();
        fatura_siniri.add("2012 yılı için :770 TL");
        fatura_siniri.add("2013 yılı için :800 TL");
        fatura_siniri.add("2014 yılı için :800 TL");
        fatura_siniri.add("2015 yılı için :880 TL");
        fatura_siniri.add("2016 yılı için :900 TL");

        List<String> bankalar = new ArrayList<String>();
        bankalar.add("AKBANK T.A.Ş.");
        bankalar.add("AKTİF YATIRIM BANKASI A.Ş.");
        bankalar.add("ALBARAKA TÜRK KATILIM BANKASI A.Ş.");
        bankalar.add("ALTERNATİFBANK A.Ş.");
        bankalar.add("ANADOLUBANK A.Ş.");
        bankalar.add("ARAP TÜRK BANKASI A.Ş.");
        bankalar.add("CITIBANK A.Ş.");
        bankalar.add("DENİZBANK A.Ş.");
        bankalar.add("BURGAN BANK A.Ş.");
        bankalar.add("FİBABANKA A.Ş.");
        bankalar.add("FİNANSBANK A.Ş.");
        bankalar.add("HSBC BANK A.Ş.");
        bankalar.add("ICBC TURKEY BANK A.Ş.");
        bankalar.add("ING BANK A.Ş.");
        bankalar.add("KUVEYT TÜRK KATILIM BANKASI A.Ş.");
        bankalar.add("ODEA BANK A.Ş.");
        bankalar.add("ŞEKERBANK T.A.Ş.");
        bankalar.add("T.C. ZİRAAT BANKASI A.Ş.");
        bankalar.add("TURKISHBANK A.Ş.");
        bankalar.add("TURKLAND BANK A.Ş.");
        bankalar.add("TÜRK EKONOMİ BANKASI A.Ş.");
        bankalar.add("TÜRKİYE FİNANS KATILIM BANKASI A.Ş.");
        bankalar.add("TÜRKİYE GARANTİ BANKASI A.Ş.");
        bankalar.add("TÜRKİYE HALK BANKASI A.Ş.");
        bankalar.add("TÜRKİYE İŞ BANKASI A.Ş.");
        bankalar.add("POSTA VE TELGRAF TEŞKİLATI ANONİM ŞİRKETİ (PTT)");
        bankalar.add("TÜRKİYE VAKIFLAR BANKASI T.A.O.");
        bankalar.add("VAKIF KATILIM BANKASI A.Ş.");
        bankalar.add("YAPI VE KREDİ BANKASI A.Ş. ");
        bankalar.add("ZİRAAT KATILIM BANKASI A.Ş.");

        infos.put("Arızi Kazançlara İlişkin İstisna Tutarı", arizi_kazanc_siniri);
        infos.put("Asgari Geçim İndirimi Tutarları - 2016", agiTutarlari);
        infos.put("Fatura Düzenleme Sınırı",fatura_siniri);
        infos.put("Tecil Faizi", tecil_faizi);
        infos.put("Vergi Tahsiline Yetkili Bankalar",bankalar);
        infos.put("Yeniden Değerleme Oranları", ydo);
        infos.put("Yıllar İtibariyle Asgari Ücret Tutarları", asgariUcret);


        return infos;

    }
}
