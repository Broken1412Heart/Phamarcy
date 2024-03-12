package entity;

public class Bill {
    private String billID;
    private String employeeID;
    private String customerID;
    private String date;
    private int total;

    public Bill() {
    }

    public Bill(String billID, String employeeID, String customerID, String date, int total) {
        this.billID = billID;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.date = date;
        this.total = total;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
}
