package dao;

import java.util.ArrayList;
import java.util.List;

import entity.BillDetail;
import entity.Medicine;

public interface ThongKeSanPhamDao {
	public int tinhTongSanPhamBanDuocTheoThang(int thang, int nam);

	public List<BillDetail> lay10SanPhamBanChayTheoThangNam(int thang, int nam);

	public ArrayList<Medicine> get10SanPhamBanChay();
}
