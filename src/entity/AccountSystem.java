package entity;

public class AccountSystem {
    private String password;

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
    
}
