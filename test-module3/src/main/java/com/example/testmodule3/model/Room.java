package com.example.testmodule3.model;

public class Room {
    private int id;
    private String code;
    private String name;
    private String phone;
    private String startDate;
    private int idPay;
    private String note;

    public Room() {
    }

    public Room(int id, String code, String name, String phone, String startDate, int idPay, String note) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.startDate = startDate;
        this.idPay = idPay;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getIdPay() {
        return idPay;
    }

    public void setIdPay(int idPay) {
        this.idPay = idPay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
