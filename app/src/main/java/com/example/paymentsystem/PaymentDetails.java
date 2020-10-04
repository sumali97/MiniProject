package com.example.paymentsystem;

public class PaymentDetails {

    private int orderId;
    private double subTotal;
    private double deliveryPeice;
    private double total;
    private String foodName;
    private int quantity;
    private double totalOfFodds;

    public PaymentDetails() {

    }

    public PaymentDetails(double subTotal, double deliveryPeice, double total, String foodName, int quantity, double totalOfFodds) {
        this.subTotal = subTotal;
        this.deliveryPeice = deliveryPeice;
        this.total = total;
        this.foodName = foodName;
        this.quantity = quantity;
        this.totalOfFodds = totalOfFodds;
    }

    public PaymentDetails(int orderId, double subTotal, double deliveryPeice, double total, String foodName, int quantity, double totalOfFodds) {
        this.orderId = orderId;
        this.subTotal = subTotal;
        this.deliveryPeice = deliveryPeice;
        this.total = total;
        this.foodName = foodName;
        this.quantity = quantity;
        this.totalOfFodds = totalOfFodds;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDeliveryPeice() {
        return deliveryPeice;
    }

    public void setDeliveryPeice(double deliveryPeice) {
        this.deliveryPeice = deliveryPeice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalOfFodds() {
        return totalOfFodds;
    }

    public void setTotalOfFodds(double totalOfFodds) {
        this.totalOfFodds = totalOfFodds;
    }
}