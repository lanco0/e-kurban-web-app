package com.aurora.ekurban.domain;

import com.aurora.ekurban.enumeration.KurbanDurum;

import javax.persistence.*;

/**
 * @author mehmetercan
 */
@Entity
public class Mesaj {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String mesaj;

    private KurbanDurum tur;
}
