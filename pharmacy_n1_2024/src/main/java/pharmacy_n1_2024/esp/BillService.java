package esp;

import java.util.List;

import entity.Bill;
import entity.BillDetail;
import entity.Customer;
import entity.Medicine;

// import entity.BillDetail;
// import entity.Bill;
// import entity.Customer;
// import entity.Medicine;

public interface BillService {
	public List<Medicine> getSanPhamTim(String noidung);

	public List<Medicine> getTatCaSanPham();

	public Medicine laySanPhamTheoMa(String ma);

	public List<BillDetail> getCT_BillTheoBill(String maBill);

	public List<Bill> getAllDSBill(String maNhanVien);

	public boolean themBill(Bill Bill);

	public boolean themCT_Bill(Bill hd, Medicine sp, int soLuong);

	public List<Customer> timKiemCustomertheoNoiDung(String noiDungTim);

	public Customer timKiemCustomertheoSDT(String sdt);

	public Customer timKiemCustomertheoTen(String tenKHang);

	public Bill getBill(String maBill);

	public boolean xoaHD(String maBill);

	public boolean capNhatSLSanPham(String maSP, int soluong);

	public List<BillDetail> getAllDSCT_Bill();

	public boolean capNhatTrangThai(Bill hd);

	public boolean capNhatSLCT_Bill(String maHD, String maSP, int soluong);

	public boolean xoaCT_HD(String maBill, String maSP);

	public Customer timKiemCustomertheoMa(String maKH);

	public BillDetail get_TungCT_Bill(String maBill, String maSP);
}
