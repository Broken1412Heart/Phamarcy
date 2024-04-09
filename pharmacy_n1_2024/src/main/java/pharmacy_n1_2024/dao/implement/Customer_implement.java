package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDataBase;
import dao.Customer_DAO;
import entity.Customer;

public class Customer_implement implements Customer_DAO {
    private Connection con;
    private PreparedStatement prepareStatement;
    private ResultSet rs;

    public List<Customer> getAllCustomer() {
        List<Customer> lstCustomer = new ArrayList<Customer>();
        Customer customer = null;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "select * from Khach_Hang";
            prepareStatement = con.prepareStatement(sql);
            rs = prepareStatement.executeQuery();
            lstCustomer = new ArrayList<Customer>();
            while (rs.next()) {
                String customerID = rs.getString(1);
                String customerName = rs.getString(2);
                String phoneNumber = rs.getString(3);
                Boolean gender = rs.getBoolean(4);
                customer = new Customer(customerID, customerName, phoneNumber, gender);
                lstCustomer.add(customer);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstCustomer;
    }

    public boolean addCustomer(Customer customer) {
        boolean n = false;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "insert into Khach_Hang values(?,?,?,?)";

            prepareStatement = con.prepareStatement(sql);

            prepareStatement.setString(1, customer.getCustomerID());
            prepareStatement.setString(2, customer.getName());
            prepareStatement.setString(3, customer.getPhoneNumber());
            prepareStatement.setBoolean(4, customer.getGenders());

            n = prepareStatement.executeUpdate() > 0;

        } catch (Exception e) {
        }
        return n;
    }

    /**
     * Updates the information of a customer in the database.
     *
     * @param customer The customer object containing the updated information.
     * @return true if the customer information is successfully updated, false
     *         otherwise.
     */
    @Override
    public boolean updateCustomer(Customer customer) {

        boolean n = false;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "Update Khach_Hang set tencustomer = ?, phoneNumber = ?, gender = ? where macustomer = ?";

            prepareStatement = con.prepareStatement(sql);

            n = prepareStatement.executeUpdate() > 0;

        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
        }
        return n;
    }

    @Override
    public boolean deleteCustomer(String customerID) {
        boolean check = false;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "delete Khach_Hang where macustomer = ?";
            prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, customerID);
            check = prepareStatement.executeUpdate() > 0;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Customer> SearchCustomer(String searchContent) {
        List<Customer> customers = null;
        Customer customer;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "select * from Khach_Hang where macustomer like ? or tencustomer like ? or phoneNumber like ?";
            prepareStatement = con.prepareStatement(sql);

            prepareStatement.setString(1, "%" + searchContent + "%");
            prepareStatement.setString(2, "%" + searchContent + "%");
            prepareStatement.setString(3, "%" + searchContent + "%");
            rs = prepareStatement.executeQuery();

            customers = new ArrayList<Customer>();
            while (rs.next()) {
                String maKH = rs.getString("macustomer");
                String tenKH = rs.getString("tencustomer");
                String phoneNumber = rs.getString("phoneNumber");
                Boolean gender = rs.getBoolean("gender");
                customer = new Customer(maKH, tenKH, phoneNumber, gender);
                customers.add(customer);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
        }
        return customers;
    }

    @Override
    public Customer getInfomationOfCusomer(String customerID) {
        Customer customer = null;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "Select * from Khach_Hang where macustomer = ?";
            prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, customerID);
            rs = prepareStatement.executeQuery();
            if (rs.next()) {
                String tenKH = rs.getString("tencustomer");
                String phoneNumber = rs.getString("phoneNumber");
                Boolean gender = rs.getBoolean("gender");
                customer = new Customer(customerID, tenKH, phoneNumber, gender);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

}
