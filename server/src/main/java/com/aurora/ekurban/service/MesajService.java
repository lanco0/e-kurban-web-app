package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.Hissedar;
import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.domain.Mesaj;
import com.aurora.ekurban.enumeration.KurbanDurum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesajService {

    @Autowired
    KurbanService kurbanService;

    public Mesaj sendMesaj(KurbanDurum kurbanDurum, Hissedar hissedar, Kurban kurban) {
        Mesaj mesaj = new Mesaj();
        String hissedarAdSoyad = hissedar.getAd() + " " + hissedar.getSoyad() + ". ";

        String finalMesaj = "";

        //TODO Her bir hissedara sms olarak mesaj atılacak

        if (kurbanDurum == KurbanDurum.KESILDI) {
            finalMesaj = "Sayın " + hissedarAdSoyad + kurban.getKupeNo() +
                    " küpe numarasına ait kurbanınız kesilmiştir. Cenab - ı Hak kabul eylesin.";
        } else if (kurbanDurum == KurbanDurum.TELEF) {
            finalMesaj = "Sayın " + hissedarAdSoyad + kurban.getKupeNo() + " küpe numaralı hayvanınız telef olmuştur. " +
                    "Yeni kurban işlemleri için en yakın zamanda kursumuzu ziyaret ediniz.";
        } else {
            finalMesaj = "Sayın " + hissedarAdSoyad + kurban.getKupeNo() + " küpe nolu, " +
                    kurban.getCins() + " cinsli kurban kaydınız alınmıştır.";
        }

        mesaj.setMesaj(finalMesaj);
        mesaj.setTur(kurbanDurum);

        return mesaj;

    }
}
