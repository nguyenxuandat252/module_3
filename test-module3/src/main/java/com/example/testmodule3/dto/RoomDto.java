package com.example.testmodule3.dto;

public class RoomDto {
    private int id;
    private String code;
    private String name;
    private String phone;
    private String startDate;
    private int idPay;
    private String form;
    private String note;

    public RoomDto() {
    }

    public RoomDto(int id, String code, String name, String phone, String startDate, int idPay, String form, String note) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.startDate = startDate;
        this.idPay = idPay;
        this.form = form;
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

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
