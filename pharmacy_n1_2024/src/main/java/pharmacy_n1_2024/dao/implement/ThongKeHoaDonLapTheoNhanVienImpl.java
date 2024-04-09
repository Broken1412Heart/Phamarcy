package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDataBase;
import dao.ThongKeHoaDonLapTheoStaff_DAO;
import gui.Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien;

public class ThongKeHoaDonLapTheoNhanVienImpl implements ThongKeHoaDonLapTheoStaff_DAO {
	@Override
	public void thongKeNhanVienLapHoaDonTheoNgay(int ngay, int thang, int nam, String maNhanVien) {
		DecimalFormat tien = new DecimalFormat("###,###,### VND");
		Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien.tablemodel = (DefaultTableModel) Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien.table
				.getModel();
		try {

			Connection con = ConnectDataBase.getInstance().getConnection();
			PreparedStatement stmt = null;
			String sql = "SELECT        Chi_Tiet_Hoa_Don.maHoaDon, Nhan_Vien.maNhanVien, \r\n"
					+ "Nhan_Vien.[tenNhanVien], Hoa_Don.[ngayDat], \r\n"
					+ "sum(Chi_Tiet_Hoa_Don.[soLuong] * [donGia] * (1 - San_Pham.[giamGia])) * 1.1  as TongTien, \r\n"
					+ "sum(Chi_Tiet_Hoa_Don.soLuong), count(Chi_Tiet_Hoa_Don.maHoaDon)\r\n"
					+ "FROM            Chi_Tiet_Hoa_Don INNER JOIN\r\n"
					+ "                         Hoa_Don ON Chi_Tiet_Hoa_Don.maHoaDon = Hoa_Don.maHoaDon INNER JOIN\r\n"
					+ "                         Nhan_Vien ON Hoa_Don.maNhanVien = Nhan_Vien.maNhanVien INNER JOIN\r\n"
					+ "                         San_Pham ON Chi_Tiet_Hoa_Don.maSanPham = San_Pham.maSanPham\r\n"
					+ "WHERE DAY([ngayDat]) = ?  and MONTH([ngayDat]) = ? and YEAR([ngayDat]) = ? and Nhan_Vien.maNhanVien = ?\r\n"
					+ "GROUP BY Chi_Tiet_Hoa_Don.maHoaDon, Nhan_Vien.maNhanVien, \r\n"
					+ "Nhan_Vien.[tenNhanVien], Hoa_Don.[ngayDat]";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ngay);
			stmt.setInt(2, thang);
			stmt.setInt(3, nam);
			stmt.setString(4, maNhanVien);
			ResultSet rs = stmt.executeQuery();
			int i = 0;
			String maHoaDonSoSanh = "";
			Object[] ds = null;
			int checkNull = 0;
			double tongTienDaBan = 0;
			int tongSoLuongSachDaBan = 0;
			int soLuongHoaDon = 0;
			while (rs.next()) {
				if (rs.getString("maHoaDon").equalsIgnoreCase(maHoaDonSoSanh) == false) {
					++i;
					String stt = i + "";
					ds = new String[] { stt, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							tien.format(rs.getDouble(5)), rs.getString(6) };
					maHoaDonSoSanh = rs.getString(1);
					Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien.tablemodel.addRow(ds);
					tongTienDaBan += rs.getDouble(5);
					tongSoLuongSachDaBan += rs.getInt(6);
					soLuongHoaDon += rs.getInt(7);
					checkNull++;
				}
			}
			if (checkNull == 0) {
				JOptionPane.showMessageDialog(null, "Khong co du lieu cua ngay:" + ngay + "/" + thang + "/" + nam);

			}
			Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien.lblTongTien.setText(tien.format(tongTienDaBan));
			Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien.lblTongHoaDon.setText(soLuongHoaDon + "");
			Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien.lblTongSanPham.setText(tongSoLuongSachDaBan + "");

			System.out.println(ds.toString());
			System.out.println(tongSoLuongSachDaBan);
			System.out.println(tongTienDaBan);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
