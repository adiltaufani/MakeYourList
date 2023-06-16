package com.example.signuplogintubes;

public class DataWorkClass {

    private String dataWorkList;
    private String dataWorkTime;


    public String getDataWorkList() {
        return dataWorkList;
    }

    public String getDataWorkTime() {
        return dataWorkTime;
    }


    public DataWorkClass(String dataWorkList, String dataWorkTime) {
        this.dataWorkList = dataWorkList;
        this.dataWorkTime = dataWorkTime;
    }
}
