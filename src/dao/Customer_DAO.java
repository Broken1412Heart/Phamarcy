package dao;

import java.util.List;

import entity.Customer;

public interface Customer_DAO {
    public List<Customer> getTatCaCustomer();

    public boolean themCustomer(Customer customer);

    public boolean capNhatThongTinCustomer(Customer customer);

    public boolean xoaCustomer(String customerID);

    public List<Customer> timKiemCustomer(String noiDungTim);

    public Customer layThongTinCustomerTheoMaCustomer(String customerID);
}
