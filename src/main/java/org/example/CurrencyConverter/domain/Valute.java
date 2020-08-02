package org.example.CurrencyConverter.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Valute {
    public Valute() {}
    public Valute(String valute_id, String numCode, String charCode, Integer nominal, String name, float value) {
        this.valute_id = valute_id;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
        System.out.println(this.valute_id + " " + this.numCode + " " + this.charCode + " " + this.nominal + " " + this.name + " " + this.value);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String valute_id;

    private String numCode;
    private String charCode;
    private Integer nominal;
    private String name;
    private float value;

    public String getValute_id() {
        return this.valute_id;
    }
    public void setValute_id(String valute_id) { this.valute_id = valute_id; }

    public String getNumCode() { return this.numCode; }
    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() { return this.charCode;}
    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public Integer getNominal() {
        return this.nominal;
    }
    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return this.value;
    }
    public void setValue(float value) {
        this.value = value;
    }
}
