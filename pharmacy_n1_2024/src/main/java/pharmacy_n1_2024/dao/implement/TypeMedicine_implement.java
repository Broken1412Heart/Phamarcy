package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDataBase;
import dao.TypeMedicine_DAO;
import entity.TypeMedicine;

public class TypeMedicine_implement implements TypeMedicine_DAO {

	Connection con;
	PreparedStatement preStm;
	ResultSet rs;

	@Override
	public ArrayList<TypeMedicine> getAllTypeMedicine() {
		// TODO Auto-generated method stub
		ArrayList<TypeMedicine> danhSachTypeMedicine = new ArrayList<TypeMedicine>();
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "SELECT * \r\n"
					+ "FROM Loai_San_Pham \r\n"
					+ "ORDER BY tenLoai";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maTypeMedicine = rs.getString(1);
				String tenLoai = rs.getString(2);
				TypeMedicine TypeMedicine = new TypeMedicine(maTypeMedicine, tenLoai);
				danhSachTypeMedicine.add(TypeMedicine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachTypeMedicine;
	}

	@Override
	public boolean themTypeMedicine(TypeMedicine TypeMedicine) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "INSERT Loai_San_Pham\r\n"
					+ "VALUES (?, ?)";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, TypeMedicine.getTypeMedicineID());
			preStm.setString(2, TypeMedicine.getTypeMedicineName());
			n = preStm.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				preStm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n;
	}

	@Override
	public boolean xoaTypeMedicine(String maTypeMedicine) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "DELETE FROM Loai_San_Pham \r\n"
					+ "WHERE maTypeMedicine = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maTypeMedicine);
			n = preStm.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				preStm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n;
	}

	@Override
	public boolean capNhatTypeMedicine(TypeMedicine TypeMedicine) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "UPDATE dbo.Loai_San_Pham \r\n"
					+ "SET tenLoai = ? \r\n"
					+ "WHERE maTypeMedicine = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(2, TypeMedicine.getTypeMedicineID());
			preStm.setString(1, TypeMedicine.getTypeMedicineName());
			n = preStm.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				preStm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n;
	}

	@Override
	public ArrayList<TypeMedicine> timKiemTypeMedicine(String keyword) {
		// TODO Auto-generated method stub
		ArrayList<TypeMedicine> danhSachTypeMedicine = new ArrayList<TypeMedicine>();
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "SELECT * \r\n"
					+ "FROM Loai_San_Pham\r\n"
					+ "WHERE maTypeMedicine LIKE ? \r\n"
					+ "OR tenLoai LIKE ?"
					+ "ORDER BY tenLoai";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, "%" + keyword + "%");
			preStm.setString(2, "%" + keyword + "%");
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maTypeMedicine = rs.getString(1);
				String tenLoai = rs.getString(2);
				TypeMedicine TypeMedicine = new TypeMedicine(maTypeMedicine, tenLoai);
				danhSachTypeMedicine.add(TypeMedicine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachTypeMedicine;
	}

}
