package entity;

import java.io.Serializable;

public class AccountSystem implements Serializable {
    private String password;
    private Staff staff;

    public AccountSystem() {
    }

    public AccountSystem(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "AccountSystem [password=" + password + ", staff=" + staff + "]";
    }

}