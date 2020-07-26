package com.EShop.Model;

public class Statistic {
    private String Date;
    private int Revenunes;
    private int Benefis;

    public Statistic() {
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getRevenunes() {
        return Revenunes;
    }

    public void setRevenunes(int revenunes) {
        Revenunes = revenunes;
    }

    public int getBenefis() {
        return Benefis;
    }

    public void setBenefis(int benefis) {
        Benefis = benefis;
    }
}
