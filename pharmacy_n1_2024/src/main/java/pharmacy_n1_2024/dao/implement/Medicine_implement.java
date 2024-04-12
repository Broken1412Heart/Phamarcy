package dao.implement;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.Medicine_DAO;
import entity.Medicine;

public class Medicine_implement implements Medicine_DAO {

	@Override
	public ArrayList<Medicine> getTatCaSanPham() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean themSanPham(Medicine sanPham) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoaSanPham(String maSanPham) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean capNhatSanPham(Medicine sanPham) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Medicine> timKiemSanPham(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Medicine> timKiemSanPhamTheoLoai(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medicine timSanPhamTheoMa(String ma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean themSanPhamTuExcel(File file) throws IOException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
