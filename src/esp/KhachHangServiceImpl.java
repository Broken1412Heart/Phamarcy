// package esp;


// import java.util.List;

// import dao.KhachHangDao;
// import dao.impl.KhachHangImpl;
// import dto.KhachHang;

// public class KhachHangServiceImpl implements KhachHangService{
// 	private KhachHangDao khachHangDao = new KhachHangImpl();
	
// 	public List<KhachHang> getTatCaKhachHang() {
// 		return khachHangDao.getTatCaKhachHang();
// 	}

// 	@Override
// 	public boolean themKhachHang(KhachHang khachHang) {
// 		return khachHangDao.themKhachHang(khachHang);
// 	}

// 	@Override
// 	public boolean capNhatThongTinKhachHang(KhachHang khachHang) {
// 		return khachHangDao.capNhatThongTinKhachHang(khachHang);
// 	}

// 	@Override
// 	public boolean xoaKhachHang(String maKhachHang) {
// 		return khachHangDao.xoaKhachHang(maKhachHang);
// 	}

// 	@Override
// 	public List<KhachHang> timKiemKhachHang(String noiDungTim) {
// 		return khachHangDao.timKiemKhachHang(noiDungTim);
// 	}

// 	@Override
// 	public KhachHang layThongTinKhachHangTheoMaKhachHang(String maKhachHang) {
// 		return khachHangDao.layThongTinKhachHangTheoMaKhachHang(maKhachHang);
// 	}

// }
