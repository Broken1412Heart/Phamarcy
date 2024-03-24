package entity;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private String customerID;
    private String name;
    private String Genders;
    private String address;
    private String phoneNumber;
    private String email;
    private Date dateOfBirth;

    public Customer() {
    }

    public Customer(String customerID) {
        this.customerID = customerID;
    }

    public Customer(String customerID, String name, String genders, String address, String phoneNumber, String email,
            Date dateOfBirth) {
        this.customerID = customerID;
        this.name = name;
        Genders = genders;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Customer(String maKH, String tenKH, String soDienThoai, Boolean gioiTinh) {
        //TODO Auto-generated constructor stub
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGenders() {
        return Genders;
    }

    public void setGenders(String genders) {
        Genders = genders;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
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
        Customer other = (Customer) obj;
        if (customerID == null) {
            if (other.customerID != null)
                return false;
        } else if (!customerID.equals(other.customerID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Customer [customerID=" + customerID + ", name=" + name + ", Genders=" + Genders + ", address=" + address
                + ", phoneNumber=" + phoneNumber + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
    }

}
