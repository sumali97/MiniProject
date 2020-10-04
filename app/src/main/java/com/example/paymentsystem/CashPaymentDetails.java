package com.example.burgerfactorypayment;

public class CashPaymentDetails {

    private int id;
    private String full_name;
    private String phone_no;
    private String province;
    private String district;
    private String city;
    private String address;

    public CashPaymentDetails() {

    }

    public CashPaymentDetails(int id, String full_name, String phone_no, String province, String district, String city, String address) {
        this.id = id;
        this.full_name = full_name;
        this.phone_no = phone_no;
        this.province = province;
        this.district = district;
        this.city = city;
        this.address = address;
    }

    public CashPaymentDetails(String full_name, String phone_no, String province, String district, String city, String address) {
        this.full_name = full_name;
        this.phone_no = phone_no;
        this.province = province;
        this.district = district;
        this.city = city;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
