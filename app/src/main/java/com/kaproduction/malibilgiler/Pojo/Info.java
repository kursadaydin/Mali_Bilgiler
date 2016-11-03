package com.kaproduction.malibilgiler.Pojo;

import com.kaproduction.malibilgiler.R;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by reis on 29/10/16.
 */

public class Info implements Comparator<Info> {


    String parent;//ust baslik
    String child;//alt baslik
    String url;//eger internetten pdf yi okuyorsak adresi
    int icon;

    public Info() {

    }

    public Info(String parent, String child, int icon) {
        this.parent = parent;
        this.child = child;
        this.icon = icon;
    }

    public Info(String parent, int icon) {
        this.parent = parent;
        this.icon = icon;

    }

    public Info(String parent, int icon, String url) {
        this.parent = parent;
        this.icon = icon;
        this.url = url;
    }


    public String getParent() {
        return parent;
    }

    public String getChild() {
        return child;
    }

    public String getUrl() {
        return url;
    }

    public int getIcon() {
        return icon;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public int compare(Info info1, Info info2) {
        return info1.getParent().compareTo(info2.getParent());
    }

    public ArrayList<Info> getTab1() {
        ArrayList<Info> arrayList = new ArrayList<Info>();


        Info i1 = new Info("Amortismana Tabi Kıymetler", R.mipmap.ic_action_action_assignment_turned_in, "http://www.gib.gov.tr/sites/default/files/fileadmin/user_upload/Yararli_Bilgiler/amortisman_oranlari.pdf");
        Info i2 = new Info("Amortisman Ayırmada Alt Sınır", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/amortisman_altsinir.htm");
        Info i3 = new Info("Anlaşmalı Bankalar ", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/antlasmali_bankalar.htm");
        Info i4 = new Info("Ba ve Bs Formlarının Bildirimi", R.mipmap.ic_action_action_assignment_turned_in, "http://www.gib.gov.tr/sites/default/files/fileadmin/user_upload/Yararli_Bilgiler/ba-bsbildirimi.pdf");
        Info i5 = new Info("Basit Usulde Vergilendirmeye İlişkin Had ve Tutarlar", R.mipmap.ic_action_action_assignment_turned_in, "http://www.gib.gov.tr/sites/default/files/fileadmin/user_upload/Yararli_Bilgiler/basit_usul_had_tutar.pdf");
        Info i6 = new Info("Beyanname Verme ve Ödeme Süreleri", R.mipmap.ic_action_action_assignment_turned_in, "http://www.gib.gov.tr/sites/default/files/fileadmin/user_upload/Yararli_Bilgiler/beyannameverme_odeme.pdf");
        Info i7 = new Info("Damga Vergisi Tutarları", R.mipmap.ic_action_action_assignment_turned_in, "http://www.gib.gov.tr/sites/default/files/fileadmin/mevzuatek/488_I_sayili_tablo.pdf");
        Info i8 = new Info("Defter Tutma Hadleri", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/defter_tutma_hadleri.htm");
        Info i9 = new Info("Gecikme Zammı Oranı", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/gecikme_zammi.htm");
        Info i10 = new Info("Gelir Vergisi Tarifesi", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/gelir_vergisi_tarife.htm");
        Info i11 = new Info("GVK Geçici 67. Madde Kapsamında Kesinti Oranları ", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/gvk67_tevkifat.htm");
        Info i12 = new Info("Harç Tutarları", R.mipmap.ic_action_action_assignment_turned_in, "http://www.gib.gov.tr/sites/default/files/fileadmin/mevzuatek/492_tarifeler.pdf");
        Info i13 = new Info("Mesken Kira Gelirinde İstisna Tutarları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/mesken_kira_istisna.htm");
        Info i14 = new Info("MTV Tutarları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/mtv_tarife.htm");
        Info i15 = new Info("Özel Tüketim Vergisi I sayılı liste", R.mipmap.ic_action_action_assignment_turned_in, "http://www.gib.gov.tr/fileadmin/mevzuatek/otv_oranlari_tum/08092016.htm");
        Info i16 = new Info("Özel Tüketim Vergisi II sayılı liste", R.mipmap.ic_action_action_assignment_turned_in, "http://www.gib.gov.tr/fileadmin/mevzuatek/otv_oranlari_tum/05102016_II_sayili_liste.htm");
        Info i17 = new Info("Özel Tüketim Vergisi III sayılı liste", R.mipmap.ic_action_action_assignment_turned_in, "http://www.gib.gov.tr/fileadmin/mevzuatek/otv_oranlari_tum/otv_3_sayili-OpenPage.htm");
        Info i18 = new Info("Özel Tüketim Vergisi VI sayılı liste", R.mipmap.ic_action_action_assignment_turned_in, "http://www.gib.gov.tr/fileadmin/mevzuatek/otv_oranlari_tum/11_09_2014_IV_Sayili_Liste.htm");
        Info i19 = new Info("Tecil Faizi Oranı", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/tecil_faizi.htm");
        Info i20 = new Info("Veraset ve İntikal Vergisi Oranları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/veraset_intikal.htm");
        Info i21 = new Info("Vergi Cezaları", R.mipmap.ic_action_action_assignment_turned_in, "http://www.gib.gov.tr/sites/default/files/fileadmin/user_upload/Yararli_Bilgiler/vergicezalari.pdf");
        Info i22 = new Info("Vergi Takvimi ", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/vergi_takvimi.htm");
        Info i23 = new Info("Vergi Türü Kodları  ", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/vergi_turu_kodlari.htm");
        Info i24 = new Info("Yeniden Değerleme Oranları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/yeniden_degerleme_oranlari.htm");

        arrayList.add(i1);
        arrayList.add(i2);
        arrayList.add(i3);
        arrayList.add(i4);
        arrayList.add(i5);
        arrayList.add(i6);
        arrayList.add(i7);
        arrayList.add(i8);
        arrayList.add(i9);
        arrayList.add(i10);
        arrayList.add(i11);
        arrayList.add(i12);
        arrayList.add(i13);
        arrayList.add(i14);
        arrayList.add(i15);
        arrayList.add(i16);
        arrayList.add(i17);
        arrayList.add(i18);
        arrayList.add(i19);
        arrayList.add(i20);
        arrayList.add(i21);
        arrayList.add(i22);
        arrayList.add(i23);
        arrayList.add(i24);


        return arrayList;


    }

    public ArrayList<Info> getTab2() {
        ArrayList<Info> arrayList = new ArrayList<Info>();

        Info i = new Info("4A ye tabi olanların prim tutarları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/4A.htm");
        Info i2 = new Info("4B ye tabi olanların prim tutarları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/4B.htm");
        Info i3 = new Info("Yıllar  İtibariyle Brüt Asgari Ücret Tutarları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/brut_asgari_ucret.htm");
        Info i4 = new Info("2016 Yılı Asgari Ücret Maliyeti", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/asgari_ucret_maliyet.htm");
        Info i5 = new Info("SGK Taban ve Tavan Tutarları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/sgk_tavan_taban.htm");
        Info i6 = new Info("İşsizlik Sigortası Prim Oranları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/issizlik_oran.htm");
        Info i7 = new Info("2016 yılı Asgari Geçim İndirimi Tutarları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/agi_2016.htm");
        Info i8 = new Info("Engellilik İndirim Tutarları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/engellilik.htm");
        Info i9 = new Info("2016 yılı Kapıcı Maaşları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/kapici.htm");
        Info i10 = new Info("İsteğe Bağlı Prim Oranları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/istege_bagli.htm");

        arrayList.add(i);
        arrayList.add(i2);
        arrayList.add(i3);
        arrayList.add(i4);
        arrayList.add(i5);
        arrayList.add(i6);
        arrayList.add(i7);
        arrayList.add(i8);
        arrayList.add(i9);
        arrayList.add(i10);


        return arrayList;

    }

    public ArrayList<Info> getTab3() {
        ArrayList<Info> arrayList = new ArrayList<Info>();

        Info i = new Info("GSYH (Cari Fiyatlarla)", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/GSYH_cari.htm");
        Info i2 = new Info("GSYH (Sabit Fiyatlarla)", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/GSYH_sabit.htm");
        Info i3 = new Info("Mevsim ve Takvim Etkisinden Arındırılmış GSYH", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/GSYH_mevsim.htm");
        Info i4 = new Info("Saatlik İşgücü Maliyeti Endeksi", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/isgucu_maliyet.htm");
        Info i6 = new Info("Aylık Ortalama Brüt Ücret ve Yıllık Ortalama Brüt Kazanç", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/ortalama_kazanc.htm");
        Info i7 = new Info("İstihdam Edilenlerin Yıllara Göre Dağılımı", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/istihdam.htm");
        Info i8 = new Info("Tüketici Fiyat Endeks Rakamları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/TUFE.htm");
        Info i9 = new Info("Üretici Fiyat Endeks Rakamları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/UFE.htm");
        Info i10 = new Info("Dış Ticaret, 1997-2016", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/dis_ticaret.htm");
        Info i11 = new Info("Konut Satış Sayıları", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/konut_satis.htm");
        Info i12 = new Info("Sanayi Ciro Endeksi", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/sanayi_ciro.htm");
        Info i13 = new Info("Sanayi Üretim Endeksi", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/sanayi_uretim.htm");
        Info i14 = new Info("Ticaret ve Hizmet Endeksleri", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/ticaret_hizmet.htm");
        Info i15 = new Info("Tüketici Güven Endeksi", R.mipmap.ic_action_action_assignment_turned_in, "http://malibilgiler.hayatimizburada.com/tuketici_guven.htm");

        arrayList.add(i);
        arrayList.add(i2);
        arrayList.add(i3);
        arrayList.add(i4);
        arrayList.add(i6);
        arrayList.add(i7);
        arrayList.add(i8);
        arrayList.add(i9);
        arrayList.add(i10);
        arrayList.add(i11);
        arrayList.add(i12);
        arrayList.add(i13);
        arrayList.add(i14);
        arrayList.add(i15);

        return arrayList;

    }

    public ArrayList<Info> getTab4() {
        ArrayList<Info> arrayList = new ArrayList<Info>();

        arrayList.addAll(getTab1());
        arrayList.addAll(getTab2());
        arrayList.addAll(getTab3());


        return arrayList;

    }
}
