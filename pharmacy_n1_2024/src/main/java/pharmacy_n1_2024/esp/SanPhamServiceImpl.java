// package esp;

// import java.io.File;
// import java.io.IOException;
// import java.sql.SQLException;
// import java.util.ArrayList;

// import dao.SanPhamDao;
// import dao.impl.SanPhamImpl;
// import entity.Phong;

// public class SanPhamServiceImpl implements SanPhamService{

// private SanPhamDao sanPhamDao = new SanPhamImpl();

// @Override
// public ArrayList<Phong> getTatCaSanPham() {
// // TODO Auto-generated method stub
// return sanPhamDao.getTatCaSanPham();
// }

// @Override
// public boolean themSanPham(Phong sanPham) {
// // TODO Auto-generated method stub
// return sanPhamDao.themSanPham(sanPham);
// }

// @Override
// public boolean xoaSanPham(String maSanPham) {
// // TODO Auto-generated method stub
// return sanPhamDao.xoaSanPham(maSanPham);
// }

// @Override
// public boolean capNhatSanPham(Phong sanPham) {
// // TODO Auto-generated method stub
// return sanPhamDao.capNhatSanPham(sanPham);
// }

// @Override
// public ArrayList<Phong> timKiemSanPham(String keyword) {
// // TODO Auto-generated method stub
// return sanPhamDao.timKiemSanPham(keyword);
// }

// @Override
// public ArrayList<Phong> timKiemSanPhamTheoLoai(String keyword) {
// // TODO Auto-generated method stub
// return sanPhamDao.timKiemSanPhamTheoLoai(keyword);
// }

// @Override
// public Phong timSanPhamTheoMa(String ma) {
// // TODO Auto-generated method stub
// return sanPhamDao.timSanPhamTheoMa(ma);
// }

// @Override
// public boolean themSanPhamTuExcel(File file) throws IOException, SQLException
// {
// // TODO Auto-generated method stub
// return sanPhamDao.themSanPhamTuExcel(file);
// }

// }
