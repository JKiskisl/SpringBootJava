package com.example.springbootproj.model;


public class LogRequest {
    private String coinId;
    private String vsCurrency;
    private String dataRange;

    public String getCoinId() {
        return coinId;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public String getVsCurrency() {
        return vsCurrency;
    }

    public void setVsCurrency(String vsCurrency) {
        this.vsCurrency = vsCurrency;
    }

    public String getDataRange() {
        return dataRange;
    }

    public void setDataRange(String dataRange) {
        this.dataRange = dataRange;
    }
}