package com.example.listycitylab3;

public class City {
    private String name;
    private String province;

    public City() {
        this.name = "default";
        this.province = "default";
    }
    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }
    // getters and setters
    public String getName() {
        return name;
    }
    public String getProvince() {
        return province;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setProvince(String province) {
        this.province = province;
    }
}
