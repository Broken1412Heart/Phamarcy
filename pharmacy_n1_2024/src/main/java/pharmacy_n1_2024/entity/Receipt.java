package entity;

public class Receipt {
    
    //Phiếu nhập thuốc
    private String receiptID;
    private String employeeID;
    private String date;
    private int total;
    private String supplierID;

    public Receipt() {
    }

    public Receipt(String receiptID) {
        this.receiptID = receiptID;
    }

    public Receipt(String receiptID, String employeeID, String date, int total, String supplierID) {
        this.receiptID = receiptID;
        this.employeeID = employeeID;
        this.date = date;
        this.total = total;
        this.supplierID = supplierID;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
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

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((receiptID == null) ? 0 : receiptID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Receipt other = (Receipt) obj;
        if (receiptID == null) {
            if (other.receiptID != null)
                return false;
        } else if (!receiptID.equals(other.receiptID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Receipt [receiptID=" + receiptID + ", employeeID=" + employeeID + ", date=" + date + ", total=" + total
                + ", supplierID=" + supplierID + "]";
    }

    
}
