// package esp;

// import java.util.ArrayList;

// import dao.LoaiSanPhamDao;
// import dao.impl.LoaiSanPhamIml;
// import dto.LoaiSanPham;

// public class LoaiSanPhamServiceImpl implements LoaiSanPhamService{

// 	private LoaiSanPhamDao loaiSanPhamDao = new LoaiSanPhamIml();

// 	@Override
// 	public ArrayList<LoaiSanPham> getTatCaLoaiSanPham() {
// 		// TODO Auto-generated method stub
// 		return loaiSanPhamDao.getTatCaLoaiSanPham();
// 	}

// 	@Override
// 	public boolean themLoaiSanPham(LoaiSanPham loaiSanPham) {
// 		// TODO Auto-generated method stub
// 		return loaiSanPhamDao.themLoaiSanPham(loaiSanPham);
// 	}

// 	@Override
// 	public boolean xoaLoaiSanPham(String maLoaiSanPham) {
// 		// TODO Auto-generated method stub
// 		return loaiSanPhamDao.xoaLoaiSanPham(maLoaiSanPham);
// 	}

// 	@Override
// 	public boolean capNhatLoaiSanPham(LoaiSanPham loaiSanPham) {
// 		// TODO Auto-generated method stub
// 		return loaiSanPhamDao.capNhatLoaiSanPham(loaiSanPham);
// 	}

// 	@Override
// 	public ArrayList<LoaiSanPham> timKiemLoaiSanPham(String tuKhoa) {
// 		// TODO Auto-generated method stub
// 		return loaiSanPhamDao.timKiemLoaiSanPham(tuKhoa);
// 	}
// }
