package dao;

import java.util.ArrayList;

import entity.TypeMedicine;

public interface TypeMedicine_DAO {
    public ArrayList<TypeMedicine> getAllTypeMedicine();

    public boolean themTypeMedicine(TypeMedicine TypeMedicine);

    public boolean xoaTypeMedicine(String maTypeMedicine);

    public boolean capNhatTypeMedicine(TypeMedicine TypeMedicine);

    public ArrayList<TypeMedicine> timKiemTypeMedicine(String keyword);
}
