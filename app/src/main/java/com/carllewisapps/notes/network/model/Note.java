package com.carllewisapps.notes.network.model;

public class Note {

    private int id;
    private String note;
    private String timeStamp;


    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
