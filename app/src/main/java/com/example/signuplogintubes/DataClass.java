package com.example.signuplogintubes;

public class DataClass {

    private String dataNoteList;
    private String dataNoteTime;


    public String getDataNoteList() {
        return dataNoteList;
    }

    public String getDataNoteTime() {
        return dataNoteTime;
    }


    public DataClass(String dataNoteList, String dataNoteTime) {
        this.dataNoteList = dataNoteList;
        this.dataNoteTime = dataNoteTime;
    }

    public DataClass(){

    }
}
