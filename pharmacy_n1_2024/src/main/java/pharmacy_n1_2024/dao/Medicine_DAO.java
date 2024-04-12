package dao;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Medicine;

public interface Medicine_DAO {
    public ArrayList<Medicine> getTatCaSanPham();

    public boolean themSanPham(Medicine sanPham);

    public boolean xoaSanPham(String maSanPham);

    public boolean capNhatSanPham(Medicine sanPham);

    public ArrayList<Medicine> timKiemSanPham(String keywordword);

    public ArrayList<Medicine> timKiemSanPhamTheoLoai(String keyword);

    public Medicine timSanPhamTheoMa(String ma);

    public boolean themSanPhamTuExcel(File file) throws IOException, SQLException;
}