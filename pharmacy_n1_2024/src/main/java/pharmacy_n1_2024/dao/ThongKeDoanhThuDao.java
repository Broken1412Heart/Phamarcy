package dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import entity.Bill;

public interface ThongKeDoanhThuDao {
	public double tinhTongTienBanDuocTheoThang(int thang, int nam);
	public double tinhTongTienLaiTheoThang(int thang, int nam);
	public List<Bill> layTatCaHoaDonTheoThangNam(int thang, int nam);
	public Bill layHoaDonTheoMa(String maHoaDon);
	public double tinhTongTienBanDuocTheoNgay(Date ngayHienTai, String maNhanVien, String maHoaDon);
}
