package dao.implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDataBase;
import dao.Staff_DAO;
import entity.Staff;

public class Staff_Implement implements Staff_DAO {
	Connection con;
	PreparedStatement preStm;
	ResultSet rs;

	public List<Staff> getAllStaff() {
		List<Staff> danhSachStaff = new ArrayList<Staff>();
		Staff Staff = null;
		try {
			ConnectDataBase.getInstance();
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "select * from Nhan_Vien";
			preStm = con.prepareStatement(sql);
			rs = preStm.executeQuery();
			danhSachStaff = new ArrayList<Staff>();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenStaff = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String email = rs.getString(5);
				String chucVu = rs.getString(6);
				Boolean trangThai = rs.getBoolean(7);
				Staff = new Staff(maNV, email, ngaySinh, tenStaff, gioiTinh, chucVu, trangThai);
				danhSachStaff.add(Staff);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSachStaff;
	}

	public boolean themStaff(Staff Staff) {
		boolean n = false;
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "insert into Nhan_Vien values(?,?,?,?,?,?,?)";

			preStm = con.prepareStatement(sql);

			preStm.setString(1, Staff.getStaffID());
			preStm.setString(2, Staff.getStaffName());
			preStm.setBoolean(3, Staff.isStaffGender());
			preStm.setDate(4, (Date) Staff.getStaffDOB());
			preStm.setString(5, Staff.getStaffEmail());
			preStm.setString(6, Staff.getChucVu());
			preStm.setBoolean(7, Staff.isStaffStatus);

			n = preStm.executeUpdate() > 0;

		} catch (Exception e) {
		}
		return n;
	}

	@Override
	public boolean capNhatThongTinStaff(Staff Staff) {
		boolean n = false;
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "Update Nhan_Vien set tenStaff = ?, gioiTinh = ?, ngaySinh = ?, email = ?, chucVu = ?, trangThai = ? where maStaff = ?";

			preStm = con.prepareStatement(sql);
			preStm.setString(1, Staff.getStaffName());
			preStm.setBoolean(2, Staff.isStaffGender());
			preStm.setDate(3, (Date) Staff.getStaffDOB());
			preStm.setString(4, Staff.getStaffEmail());
			preStm.setString(5, Staff.getChucVu());
			preStm.setBoolean(6, Staff.isStaffStatus());
			preStm.setString(7, Staff.getStaffID());

			n = preStm.executeUpdate() > 0;

		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return n;
	}

	@Override
	public boolean xoaStaff(String maStaff) {
		boolean check = false;
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "delete Nhan_Vien where maStaff = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maStaff);
			check = preStm.executeUpdate() > 0;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return check;
	}

	@Override
	public List<Staff> timKiemStaff(String noiDungTim) {
		List<Staff> Staffs = null;
		Staff Staff;
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "select * from Nhan_Vien where maStaff like ? or tenStaff like ? or email like ?";
			preStm = con.prepareStatement(sql);

			preStm.setString(1, "%" + noiDungTim + "%");
			preStm.setString(2, "%" + noiDungTim + "%");
			preStm.setString(3, "%" + noiDungTim + "%");
			rs = preStm.executeQuery();

			Staffs = new ArrayList<Staff>();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenStaff = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String email = rs.getString(5);
				String chucVu = rs.getString(6);
				Boolean trangThai = rs.getBoolean(7);
				Staff = new Staff(maNV, email, ngaySinh, tenStaff, gioiTinh, chucVu, trangThai);
				Staffs.add(Staff);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
		}
		return Staffs;
	}

	@Override
	public Staff layThongTinStaffTheoMaStaff(String maStaff) {
		Staff Staff = null;
		try {
			con = ConnectDataBase.getInstance().getConnection();
			String sql = "Select * from Nhan_Vien where maStaff = ?";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, maStaff);
			rs = preStm.executeQuery();
			if (rs.next()) {
				String tenStaff = rs.getString(2);
				Boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String email = rs.getString(5);
				String chucVu = rs.getString(6);
				Boolean trangThai = rs.getBoolean(7);
				Staff = new Staff(maStaff, email, ngaySinh, tenStaff, gioiTinh, chucVu, trangThai);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Staff;
	}

	// @Override
	// public void phanQuyenDangNhap(String tenDangNhap, String matKhau) {
	// try {
	// Staff Staff = null;
	// TaiKhoan taiKhoan = null;
	// con = ConnectDataBase.getInstance().getConnection();
	// String sql = "SELECT tk.[maStaff], [matKhau], [chucVu] \r\n"
	// + "FROM Nhan_Vien nv INNER JOIN\r\n"
	// + " Tai_Khoan tk ON nv.maStaff = tk.maStaff\r\n"
	// + " where tk.[maStaff] = ? and [matKhau] = ?\r\n"
	// + "group by tk.[maStaff], [matKhau], [chucVu]\r\n"
	// + "";
	// preStm = con.prepareStatement(sql);
	// preStm.setString(1, tenDangNhap);
	// preStm.setString(2, matKhau);
	// rs = preStm.executeQuery();
	// while (rs.next()) {
	// String tenTaiKhoan = rs.getString(1).trim();
	// String matKhauNV = rs.getString(2).trim();
	// String chucVu = rs.getString(3).trim();
	// Staff = layThongTinStaffTheoMaStaff(tenDangNhap);
	// taiKhoan.setStaff(Staff);
	// taiKhoan = new TaiKhoan(matKhauNV);
	// Staff.setChucVu(chucVu);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }

}
