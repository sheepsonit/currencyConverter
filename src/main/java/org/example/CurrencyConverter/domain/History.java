package org.example.CurrencyConverter.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String initCurrencyName;
    private String targetCurrencyName;
    private String initCurrency;
    private String targetCurrency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInitCurrencyName() {
        return initCurrencyName;
    }

    public void setInitCurrencyName(String initCurrencyName) {
        this.initCurrencyName = initCurrencyName;
    }

    public String getTargetCurrencyName() {
        return targetCurrencyName;
    }

    public void setTargetCurrencyName(String targetCurrencyName) {
        this.targetCurrencyName = targetCurrencyName;
    }

    public String getInitCurrency() {
        return initCurrency;
    }

    public void setInitCurrency(String initCurrency) {
        this.initCurrency = initCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }
}