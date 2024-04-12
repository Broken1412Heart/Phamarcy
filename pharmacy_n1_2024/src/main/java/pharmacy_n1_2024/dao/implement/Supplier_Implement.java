package dao.implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDataBase;
import dao.Supplier_DAO;
import entity.Supplier;

// import dao.NhaCungCapDao;
// import entity.NhaCungCap;
// import entity.Supplier;

public class Supplier_Implement implements Supplier_DAO {

	Connection con;
	PreparedStatement preStm;
	ResultSet rs;

	@Override
	public ArrayList<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		ArrayList<Supplier> danhSachNhacungCap = new ArrayList<Supplier>();
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "SELECT * \r\n"
					+ "FROM Nha_Cung_Cap\r\n"
					+ "ORDER BY tenNhaCungCap";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maNhaCungCap = rs.getString(1);
				String tenNhaCungCap = rs.getString(2);
				Date ngayHopTac = rs.getDate(3);
				String diaChi = rs.getString(4);
				String soDienThoai = rs.getString(5);
				String email = rs.getString(6);
				Supplier nhaCungCap = new Supplier(tenNhaCungCap, diaChi, soDienThoai, email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachNhacungCap;
	}

	@Override
	public boolean addSupplier(Supplier nhaCungCap) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "INSERT dbo.Nha_Cung_Cap\r\n"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, nhaCungCap.getSupplierID());
			preStm.setString(2, nhaCungCap.getSupplierName());
			// preStm.setDate(3, nhaCungCap.getSupplierPhone());
			preStm.setString(4, nhaCungCap.getSupplierAddress());
			preStm.setString(5, nhaCungCap.getSupplierPhone());
			preStm.setString(6, nhaCungCap.getEmail());
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
	public boolean deleteSupplier(String maNhaCungCap) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "DELETE FROM dbo.Nha_Cung_Cap\r\n"
					+ "WHERE maNhaCungCap = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maNhaCungCap);
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
	public boolean updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		boolean n = false;
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "UPDATE dbo.Nha_Cung_Cap\r\n"
					+ "SET \r\n"
					+ "tenNhaCungCap = ?,\r\n"
					+ "ngayHopTac = ?,\r\n"
					+ "diaChi = ?,\r\n"
					+ "soDienThoai = ?,\r\n"
					+ "email = ?\r\n"
					+ "WHERE maNhaCungCap = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, supplier.getSupplierName());
			preStm.setDate(2, supplier.getNgayHopTac());
			preStm.setString(3, supplier.getSupplierAddress());
			preStm.setString(4, supplier.getSupplierPhone());
			preStm.setString(5, supplier.getEmail());
			preStm.setString(6, supplier.getSupplierID());
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
	public ArrayList<Supplier> searchSupplier(String keyword) {
		// TODO Auto-generated method stub
		ArrayList<Supplier> danhSachNhacungCap = new ArrayList<Supplier>();
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "SELECT * \r\n"
					+ "FROM Nha_Cung_Cap\r\n"
					+ "WHERE maNhaCungCap LIKE ? OR tenNhaCungCap LIKE ?\r\n"
					+ "ORDER BY tenNhaCungCap";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, "%" + keyword + "%");
			preStm.setString(2, "%" + keyword + "%");
			rs = preStm.executeQuery();
			while (rs.next()) {
				String maNhaCungCap = rs.getString(1);
				String tenNhaCungCap = rs.getString(2);
				Date ngayHopTac = rs.getDate(3);
				String diaChi = rs.getString(4);
				String soDienThoai = rs.getString(5);
				String email = rs.getString(6);
				Supplier nhaCungCap = new Supplier(maNhaCungCap, tenNhaCungCap, ngayHopTac, diaChi, soDienThoai,
						email);
				danhSachNhacungCap.add(nhaCungCap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachNhacungCap;
	}
}
