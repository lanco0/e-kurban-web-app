package com.aurora.ekurban.domain;

import com.aurora.ekurban.enumeration.KurbanDurum;

import javax.persistence.*;

/**
 * Hissedarlara kesecekleri kurbanlarının durumları hakkında sistemde kayıtlı olan mesajları şablon olarak tutan sınıf
 * @author mehmetercan
 */
@Entity
public class Mesaj {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Hissedara gönderilecek olan mesajın içeriği
     */
    private String mesaj;

    /**
     * Hissedara gönderilecek olan mesajın türü
     * Bu türler şunlardır: KESİLDİ, TELEF,
     */
    private KurbanDurum tur;
}
