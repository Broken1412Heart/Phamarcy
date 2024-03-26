// package esp;

// import java.util.List;

// import dao.NhanVienDao;
// import dao.impl.NhanVienImpl;
// import dto.NhanVien;
// import dto.TaiKhoan;

// public class NhanVienServiceImpl implements NhanVienService{
// 	private NhanVienDao nhanVienDao = new NhanVienImpl();
// 	@Override
// 	public List<NhanVien> getTatCaNhanVien() {
// 		return nhanVienDao.getTatCaNhanVien();
// 	}

// 	@Override
// 	public boolean themNhanVien(NhanVien nhanVien) {
// 		return nhanVienDao.themNhanVien(nhanVien);
// 	}

// 	@Override
// 	public boolean capNhatThongTinNhanVien(NhanVien nhanVien) {
// 		return nhanVienDao.capNhatThongTinNhanVien(nhanVien);
// 	}

// 	@Override
// 	public boolean xoaNhanVien(String maNhanVien) {
// 		return nhanVienDao.xoaNhanVien(maNhanVien);
// 	}

// 	@Override
// 	public List<NhanVien> timKiemNhanVien(String noiDungTim) {
// 		return nhanVienDao.timKiemNhanVien(noiDungTim);
// 	}

// 	@Override
// 	public NhanVien layThongTinNhanVienTheoMaNhanVien(String maNhanVien) {
// 		return nhanVienDao.layThongTinNhanVienTheoMaNhanVien(maNhanVien);
// 	}



// //	@Override
// //	public void phanQuyenDangNhap(String tenDangNhap, String matKhau) {
// //		nhanVienDao.phanQuyenDangNhap(tenDangNhap, matKhau);
// //		
// //	}

	

// }
