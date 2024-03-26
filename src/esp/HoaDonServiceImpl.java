// package esp;

// import java.sql.Date;
// import java.util.List;

// import dao.HoaDonDao;
// import dao.impl.HoaDonImpl;
// import dto.ChiTietHoaDon;
// import dto.HoaDon;
// import dto.KhachHang;
// import dto.Phong;

// public class HoaDonServiceImpl implements BillService {
// 	private HoaDonDao hoaDonDao = new HoaDonImpl();

// 	@Override
// 	public List<Phong> getSanPhamTim(String noidung) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.getSanPhamTim(noidung);
// 	}

// 	@Override
// 	public List<Phong> getTatCaSanPham() {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.getTatCaSanPham();
// 	}

// 	@Override
// 	public Phong laySanPhamTheoMa(String ma) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.laySanPhamTheoMa(ma);
// 	}

// 	@Override
// 	public List<ChiTietHoaDon> getCT_HoadonTheoHoaDon(String mahoadon) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.getCT_HoadonTheoHoaDon(mahoadon);
// 	}

// 	@Override
// 	public boolean themHoaDon(HoaDon hoadon) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.themHoaDon(hoadon);
// 	}

// 	@Override
// 	public boolean themCT_HoaDon(HoaDon hd, Phong sp, int soLuong) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.themCT_HoaDon(hd, sp, soLuong);
// 	}

// 	@Override
// 	public List<KhachHang> timKiemKhachHangtheoNoiDung(String noiDungTim) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.timKiemKhachHangtheoNoiDung(noiDungTim);
// 	}

// 	@Override
// 	public HoaDon getHoaDon(String mahoadon) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.getHoaDon(mahoadon);
// 	}

// 	@Override
// 	public boolean xoaHD(String maHoaDon) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.xoaHD(maHoaDon);
// 	}

// 	@Override
// 	public boolean capNhatSLSanPham(String maSP, int soluong) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.capNhatSLSanPham(maSP, soluong);
// 	}

// 	@Override
// 	public List<ChiTietHoaDon> getAllDSCT_Hoadon() {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.getAllDSCT_Hoadon();
// 	}

// 	@Override
// 	public boolean capNhatTrangThai(HoaDon hd) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.capNhatTrangThai(hd);
// 	}

// 	@Override
// 	public boolean capNhatSLCT_HoaDon(String maHD, String maSP, int soluong) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.capNhatSLCT_HoaDon(maHD, maSP, soluong);
// 	}

// 	@Override
// 	public boolean xoaCT_HD(String mahoadon, String maSP) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.xoaCT_HD(mahoadon, maSP);
// 	}

// 	@Override
// 	public KhachHang timKiemKhachHangtheoMa(String maKH) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.timKiemKhachHangtheoMa(maKH);
// 	}

// 	@Override
// 	public ChiTietHoaDon get_TungCT_HoaDon(String mahoadon, String maSP) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.get_TungCT_HoaDon(mahoadon, maSP);
// 	}

// 	@Override
// 	public List<HoaDon> getAllDSHoadon(String maNhanVien) {
// 		return hoaDonDao.getAllDSHoadon(maNhanVien);
// 	}

// 	@Override
// 	public KhachHang timKiemKhachHangtheoSDT(String sdt) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.timKiemKhachHangtheoSDT(sdt);
// 	}

// 	@Override
// 	public KhachHang timKiemKhachHangtheoTen(String tenKHang) {
// 		// TODO Auto-generated method stub
// 		return hoaDonDao.timKiemKhachHangtheoTen(tenKHang);
// 	}

// }