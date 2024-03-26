package entity;

import java.util.Date;

public class Bill {
    private String billID;
    protected Customer customer;
    protected Medicone staff;
    private Date date;
    private double total;
    private double discountAmount;

    private boolean status;

    public Bill() {
    }

    public Bill(String billID) {
        this.billID = billID;
    }

    public Bill(String billID, Customer customer, Medicone staff, Date date, double total, double discountAmount) {
        this.billID = billID;
        this.customer = customer;
        this.staff = staff;
        this.date = date;
        this.total = total;
        this.discountAmount = discountAmount;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Medicone getStaff() {
        return staff;
    }

    public void setStaff(Medicone staff) {
        this.staff = staff;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date ngayDat) {
        this.date = ngayDat;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill [billID=" + billID + ", customer=" + customer + ", staff=" + staff + ", date=" + date + ", total="
                + total + ", discountAmount=" + discountAmount + ", status=" + status + "]";
    }

}