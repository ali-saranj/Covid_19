package com.example.covid_19;

public class contry {

    String img_flag ;
    String name_contry;
    int cases;
    int today_cases;
    int deaths;
    int today_deaths;
    int recovered;
    int today_recovered;
    int active;

    public contry(String img_flag, String name_contry, int cases, int today_cases, int deaths, int today_deaths, int recovered, int today_recovered, int active) {
        this.img_flag = img_flag;
        this.name_contry = name_contry;
        this.cases = cases;
        this.today_cases = today_cases;
        this.deaths = deaths;
        this.today_deaths = today_deaths;
        this.recovered = recovered;
        this.today_recovered = today_recovered;
        this.active = active;
    }

    public String getImg_flag() {
        return img_flag;
    }

    public void setImg_flag(String img_flag) {
        this.img_flag = img_flag;
    }

    public String getName_contry() {
        return name_contry;
    }

    public void setName_contry(String name_contry) {
        this.name_contry = name_contry;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getToday_cases() {
        return today_cases;
    }

    public void setToday_cases(int today_cases) {
        this.today_cases = today_cases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getToday_deaths() {
        return today_deaths;
    }

    public void setToday_deaths(int today_deaths) {
        this.today_deaths = today_deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getToday_recovered() {
        return today_recovered;
    }

    public void setToday_recovered(int today_recovered) {
        this.today_recovered = today_recovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
