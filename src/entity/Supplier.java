package entity;

public class Supplier {
    private String supplierID;
    private String supplierName;
    private String supplierAddress;
    private String supplierPhone;

    public Supplier() {
    }

    public Supplier(String supplierID) {
        this.supplierID = supplierID;
    }

    public Supplier(String supplierID, String supplierName, String supplierAddress, String supplierPhone) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((supplierID == null) ? 0 : supplierID.hashCode());
        result = prime * result + ((supplierName == null) ? 0 : supplierName.hashCode());
        result = prime * result + ((supplierAddress == null) ? 0 : supplierAddress.hashCode());
        result = prime * result + ((supplierPhone == null) ? 0 : supplierPhone.hashCode());
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
        Supplier other = (Supplier) obj;
        if (supplierID == null) {
            if (other.supplierID != null)
                return false;
        } else if (!supplierID.equals(other.supplierID))
            return false;
        if (supplierName == null) {
            if (other.supplierName != null)
                return false;
        } else if (!supplierName.equals(other.supplierName))
            return false;
        if (supplierAddress == null) {
            if (other.supplierAddress != null)
                return false;
        } else if (!supplierAddress.equals(other.supplierAddress))
            return false;
        if (supplierPhone == null) {
            if (other.supplierPhone != null)
                return false;
        } else if (!supplierPhone.equals(other.supplierPhone))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Supplier [supplierID=" + supplierID + ", supplierName=" + supplierName + ", supplierAddress="
                + supplierAddress + ", supplierPhone=" + supplierPhone + "]";
    }

    
}
