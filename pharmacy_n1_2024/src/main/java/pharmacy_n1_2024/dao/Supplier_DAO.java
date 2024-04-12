package dao;

import java.util.ArrayList;

import entity.Supplier;

public interface Supplier_DAO {
    public ArrayList<Supplier> getAllSupplier();

    public boolean addSupplier(Supplier supplier);

    public boolean deleteSupplier(String supplierID);

    public boolean updateSupplier(Supplier supplier);

    public ArrayList<Supplier> searchSupplier(String keyword);
}
