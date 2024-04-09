package dao;

import java.util.List;

import entity.Customer;

public interface Customer_DAO {
    public List<Customer> getAllCustomer();

    public boolean addCustomer(Customer customer);

    public boolean updateCustomer(Customer customer);

    public boolean deleteCustomer(String customerID);

    public List<Customer> SearchCustomer(String searchContent);

    public Customer getInfomationOfCusomer(String customerID);
}
