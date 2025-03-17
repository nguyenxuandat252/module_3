package com.example.testmodule3.model;

public class Pay {
    private int id;
    private String form;

    public Pay() {
    }

    public Pay(int id, String form) {
        this.id = id;
        this.form = form;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
