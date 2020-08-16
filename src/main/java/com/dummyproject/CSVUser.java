package com.dummyproject;

import com.opencsv.bean.CsvBindByName;
public class CSVUser {
    @CsvBindByName
    private String name;

    @CsvBindByName(column = "email")
    private String email;

    @CsvBindByName(column = "phone")
    private String phoneNo;

    @CsvBindByName
    private String country;

    public CSVUser() {
    }

    public CSVUser(String name, String email, String phoneNo, String country) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;
    }

    @Override
    public String toString() {
        return "CSVUser{" +
                "name ='" + name + '\'' +
                ",email ='" + email + '\'' +
                ",phoneNo ='" + phoneNo + '\'' +
                ",country ='" + country + '\'' +
                '}';
    }
}
