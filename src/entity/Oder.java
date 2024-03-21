package entity;

public class Oder {

    // Phiếu đặt thuốc
    private String oderID;
    private String customerID;
    private String date;

    public Oder() {
    }

    public Oder(String oderID) {
        this.oderID = oderID;
    }

    public Oder(String oderID, String customerID, String date) {
        this.oderID = oderID;
        this.customerID = customerID;
        this.date = date;
    }

    public String getOderID() {
        return oderID;
    }

    public void setOderID(String oderID) {
        this.oderID = oderID;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oderID == null) ? 0 : oderID.hashCode());
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
        Oder other = (Oder) obj;
        if (oderID == null) {
            if (other.oderID != null)
                return false;
        } else if (!oderID.equals(other.oderID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Oder [oderID=" + oderID + ", customerID=" + customerID + ", date=" + date + "]";
    }

}
