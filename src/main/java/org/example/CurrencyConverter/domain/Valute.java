package org.example.CurrencyConverter.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Valute {
    Valute() {}
    Valute(Integer valute_id, String numCode, String nominal, String name, float value) {
        this.valute_id = valute_id;
        this.numCode = numCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer valute_id;

    private String numCode;
    private String nominal;
    private String name;
    private float value;



}
