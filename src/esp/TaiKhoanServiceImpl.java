// package esp;

// import dao.TaiKhoanDao;
// import dao.impl.TaiKhoanImpl;
// import dto.TaiKhoan;

// public class TaiKhoanServiceImpl implements TaiKhoanService{
// 	private TaiKhoanDao taiKhoanDao = new TaiKhoanImpl();
// 	@Override
// 	public boolean themTaiKhoan(TaiKhoan taiKhoan) {
// 		return taiKhoanDao.themTaiKhoan(taiKhoan);
// 	}
// 	@Override
// 	public TaiKhoan layThongTinTaKhoanTheoMaTaiKhoan(String maTaiKhoan) {
// 		return taiKhoanDao.layThongTinTaKhoanTheoMaTaiKhoan(maTaiKhoan);
// 	}
// 	@Override
// 	public String layMaNhanVienTheoEmail(String email) {
// 		return taiKhoanDao.layMaNhanVienTheoEmail(email);
// 	}
// 	@Override
// 	public boolean doiMatKhau(TaiKhoan taiKhoan) {
// 		return taiKhoanDao.doiMatKhau(taiKhoan);
// 	}

// }
