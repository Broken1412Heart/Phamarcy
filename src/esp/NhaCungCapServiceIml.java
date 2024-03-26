// package esp;

// import java.util.ArrayList;

// import dao.NhaCungCapDao;
// import dao.impl.NhaCungCapIml;
// import dto.NhaCungCap;

// public class NhaCungCapServiceIml implements NhaCungCapSerVice{

// 	private NhaCungCapDao nhaCungCapDao = new NhaCungCapIml();
// 	@Override
// 	public ArrayList<NhaCungCap> getTatCaNhaCungCap() {
// 		// TODO Auto-generated method stub
// 		return nhaCungCapDao.getTatCaNhaCungCap();
// 	}

// 	@Override
// 	public boolean themNhaCungCap(NhaCungCap nhaCungCap) {
// 		// TODO Auto-generated method stub
// 		return nhaCungCapDao.themNhaCungCap(nhaCungCap);
// 	}

// 	@Override
// 	public boolean xoaNhaCungCap(String maNhaCungCap) {
// 		// TODO Auto-generated method stub
// 		return nhaCungCapDao.xoaNhaCungCap(maNhaCungCap);
// 	}

// 	@Override
// 	public boolean capNhatNhaCungCap(NhaCungCap nhaCungCap) {
// 		// TODO Auto-generated method stub
// 		return nhaCungCapDao.capNhatNhaCungCap(nhaCungCap);
// 	}

// 	@Override
// 	public ArrayList<NhaCungCap> timKiemNhaCungCap(String tuKhoa) {
// 		// TODO Auto-generated method stub
// 		return nhaCungCapDao.timKiemNhaCungCap(tuKhoa);
// 	}

// }
