// package esp;

// import java.util.List;

// import dao.Staff_DAO;
// import dao.impl.NhanVienImpl;
// import entity.NhanVien;
// import entity.TaiKhoan;

// public class NhanVienServiceImpl implements NhanVienService{
// private Staff_DAO Staff_DAO = new NhanVienImpl();
// @Override
// public List<NhanVien> getTatCaNhanVien() {
// return Staff_DAO.getTatCaNhanVien();
// }

// @Override
// public boolean themNhanVien(NhanVien nhanVien) {
// return Staff_DAO.themNhanVien(nhanVien);
// }

// @Override
// public boolean capNhatThongTinNhanVien(NhanVien nhanVien) {
// return Staff_DAO.capNhatThongTinNhanVien(nhanVien);
// }

// @Override
// public boolean xoaNhanVien(String maNhanVien) {
// return Staff_DAO.xoaNhanVien(maNhanVien);
// }

// @Override
// public List<NhanVien> timKiemNhanVien(String noiDungTim) {
// return Staff_DAO.timKiemNhanVien(noiDungTim);
// }

// @Override
// public NhanVien layThongTinNhanVienTheoMaNhanVien(String maNhanVien) {
// return Staff_DAO.layThongTinNhanVienTheoMaNhanVien(maNhanVien);
// }

// // @Override
// // public void phanQuyenDangNhap(String tenDangNhap, String matKhau) {
// // Staff_DAO.phanQuyenDangNhap(tenDangNhap, matKhau);
// //
// // }

// }
