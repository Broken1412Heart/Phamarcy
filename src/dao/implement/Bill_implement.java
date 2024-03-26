package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connectDB.ConnectDataBase;
import dao.Bill_DAO;
import entity.Bill;
import entity.BillDetail;
import entity.Customer;
import entity.Medicine;
import entity.Medicone;
import entity.Supplier;

public class Bill_implement implements Bill_DAO {
    static Connection con;
    static PreparedStatement preStm;
    static ResultSet rs;

    public List<Medicine> getThuocTim(String noidung) {
        // TODO Auto-generated method stub
        List<Medicine> danhSachThuoc = new ArrayList<Medicine>();
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "SELECT maThuoc, tenThuoc, Loai_San_Pham.maLoaiThuoc+ ' ' + tenLoai AS 'loaiThuoc', donGia,\r\n"
                    + "	trangThai, soLuong, moTa, mauSac, kichThuoc, gioiTinh, hinhAnh, chatLieu,\r\n"
                    + "	Nha_Cung_Cap.maNhaCungCap + ' ' + tenNhaCungCap AS 'nhaCungCap', giamGia\r\n"
                    + "FROM dbo.San_Pham \r\n"
                    + "JOIN dbo.Loai_San_Pham\r\n"
                    + "ON Loai_San_Pham.maLoaiThuoc = San_Pham.maLoaiThuoc\r\n"
                    + "JOIN dbo.Nha_Cung_Cap\r\n"
                    + "ON Nha_Cung_Cap.maNhaCungCap = San_Pham.maNhaCungCap\r\n"
                    + "WHERE maThuoc LIKE ? OR tenThuoc LIKE ?\r\n"
                    + "ORDER BY tenThuoc";
            preStm = con.prepareStatement(sql);
            preStm.setString(1, "%" + noidung + "%");
            preStm.setString(2, "%" + noidung + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String maThuoc = rs.getString(1);
                String tenThuoc = rs.getString(2);
                String maLoaiThuoc = rs.getString(3);
                Double donGia = rs.getDouble(4);
                String trangThai = rs.getString(5);
                int soLuong = rs.getInt(6);
                String moTa = rs.getString(7);
                String maNhaCungCap = rs.getString(13);
                Double giamGia = rs.getDouble(14);
                // LoaiThuoc loaiThuoc = new LoaiThuoc(maLoaiThuoc);
                Supplier supplier = new Supplier(maNhaCungCap);
                Medicine Thuoc = new Medicine(maThuoc, tenThuoc, moTa, donGia, soLuong, giamGia,
                        trangThai, supplier);
                danhSachThuoc.add(Thuoc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachThuoc;
    }

    public List<Medicine> getTatCaThuoc() {

        List<Medicine> danhSachThuoc = new ArrayList<Medicine>();
        // TODO Auto-generated method stub
        try {
            con = ConnectDataBase.getInstance().getConnection();

            String sql = "SELECT maThuoc, tenThuoc, Loai_San_Pham.maLoaiThuoc + ' ' + tenLoai AS 'loaiThuoc', donGia,\r\n"
                    + "	trangThai, soLuong, moTa, mauSac, kichThuoc, gioiTinh, hinhAnh, chatLieu,\r\n"
                    + "	Nha_Cung_Cap.maNhaCungCap + ' ' + tenNhaCungCap AS 'nhaCungCap', giamGia\r\n"
                    + "FROM dbo.San_Pham \r\n" + "JOIN dbo.Loai_San_Pham\r\n"
                    + "ON Loai_San_Pham.maLoaiThuoc = San_Pham.maLoaiThuoc\r\n" + "JOIN dbo.Nha_Cung_Cap\r\n"
                    + "ON Nha_Cung_Cap.maNhaCungCap = San_Pham.maNhaCungCap\r\n" + "ORDER BY tenThuoc";
            preStm = con.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String maThuoc = rs.getString(1);
                String tenThuoc = rs.getString(2);
                String maLoaiThuoc = rs.getString(3);
                Double donGia = rs.getDouble(4);
                String trangThai = rs.getString(5);
                int soLuong = rs.getInt(6);
                String moTa = rs.getString(7);

                String maNhaCungCap = rs.getString(13);
                Double giamGia = rs.getDouble(14);
                // LoaiThuoc loaiThuoc = new LoaiThuoc(maLoaiThuoc);
                Supplier supplier = new Supplier(maNhaCungCap);
                Medicine Thuoc = new Medicine(maThuoc, tenThuoc, moTa, donGia, soLuong, giamGia, trangThai, supplier);
                danhSachThuoc.add(Thuoc);
            }
            return danhSachThuoc;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Medicine layThuocTheoMa(String ma) {
        // TODO Auto-generated method stub
        Medicine Thuoc = null;
        // TODO Auto-generated method stub
        try {
            con = ConnectDataBase.getInstance().getConnection();

            String sql = "SELECT maThuoc, tenThuoc, Loai_San_Pham.maLoaiThuoc + ' ' + tenLoai AS 'loaiThuoc', donGia,\r\n"
                    + "	trangThai, soLuong, moTa, mauSac, kichThuoc, gioiTinh, hinhAnh, chatLieu,\r\n"
                    + "	Nha_Cung_Cap.maNhaCungCap + ' ' + tenNhaCungCap AS 'nhaCungCap', giamGia\r\n"
                    + "FROM dbo.San_Pham \r\n"
                    + "JOIN dbo.Loai_San_Pham\r\n"
                    + "ON Loai_San_Pham.maLoaiThuoc = San_Pham.maLoaiThuoc\r\n"
                    + "JOIN dbo.Nha_Cung_Cap\r\n"
                    + "ON Nha_Cung_Cap.maNhaCungCap = San_Pham.maNhaCungCap\r\n"
                    + "WHERE maThuoc =?\r\n "
                    + "ORDER BY tenThuoc";
            preStm = con.prepareStatement(sql);
            preStm.setString(1, ma);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String maThuoc = rs.getString(1);
                String tenThuoc = rs.getString(2);
                String maLoaiThuoc = rs.getString(3);
                Double donGia = rs.getDouble(4);
                String trangThai = rs.getString(5);
                int soLuong = rs.getInt(6);
                String moTa = rs.getString(7);
                String maNhaCungCap = rs.getString(13);
                Double giamGia = rs.getDouble(14);
                // LoaiThuoc loaiThuoc = new LoaiThuoc(maLoaiThuoc);
                Supplier supplier = new Supplier(maNhaCungCap);
                Thuoc = new Medicine(maThuoc, tenThuoc, moTa, donGia, soLuong, giamGia, trangThai, supplier);
            }

            return Thuoc;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BillDetail> getCT_BillTheoBill(String maBill) {
        List<BillDetail> dSCT_Bill = new ArrayList<BillDetail>();
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "select * from Chi_Tiet_Hoa_Don where maBill = ?";
            preStm = con.prepareStatement(sql);
            preStm.setString(1, maBill);
            rs = preStm.executeQuery();
            while (rs.next()) {
                BillDetail ct = new BillDetail();
                String maSP = rs.getString(2);
                int soLuong = rs.getInt(3);

                Bill hd = new Bill();
                hd.setBillID(maSP);
                Medicine sp = new Medicine();
                sp.setMedicineID(maBill);
                ct.setBill(hd);
                ct.setDrugs(sp);
                ct.setAmount(soLuong);
                dSCT_Bill.add(ct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dSCT_Bill;
    }

    public BillDetail get_TungCT_Bill(String maBill, String maSP) {
        BillDetail ct = null;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "select * from Chi_Tiet_Hoa_Don where maBill = ? and maThuoc = ?";
            preStm = con.prepareStatement(sql);
            preStm.setString(1, maBill);
            preStm.setString(2, maSP);
            rs = preStm.executeQuery();
            ct = new BillDetail();
            while (rs.next()) {
                int soLuong = rs.getInt(3);
                Bill hd = getBill(maBill);
                Medicine sp = layThuocTheoMa(maSP);
                ct.setBill(hd);
                ct.setDrugs(sp);
                ct.setAmount(soLuong);
            }
            return ct;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BillDetail> getAllDSCT_Bill() {
        List<BillDetail> dSCT_Bill = new ArrayList<BillDetail>();
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "select * from Chi_Tiet_Hoa_Don";
            preStm = con.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                BillDetail ct = new BillDetail();
                String maHD = rs.getString(1);
                String maSP = rs.getString(2);
                int soLuong = rs.getInt(3);

                Bill hd = new Bill(maHD);
                Medicine sp = new Medicine();
                sp.setMedicineID(maSP);
                ct.setBill(hd);
                ct.setDrugs(sp);
                ct.setAmount(soLuong);
                dSCT_Bill.add(ct);
            }
            return dSCT_Bill;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Bill getBill(String maBill) {
        Bill hd = null;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "select * from Hoa_Don where maBill = ?";
            preStm = con.prepareStatement(sql);
            preStm.setString(1, maBill);
            rs = preStm.executeQuery();
            hd = new Bill();
            while (rs.next()) {
                String maHD = rs.getString(1);
                Date ngayDat = rs.getDate(2);
                Boolean trangThai = rs.getBoolean(3);
                String maNV = rs.getString(4);
                String maKH = rs.getString(5);
                Double giamGia = rs.getDouble(6);

                Medicone nv = new Medicone(maNV);
                Customer kh = new Customer(maKH);

                hd.setBillID(maHD);
                hd.setDate(ngayDat);
                hd.setStatus(trangThai);
                hd.setStaff(nv);
                hd.setCustomer(kh);
                hd.setDiscountAmount(giamGia);

            }
            return hd;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Bill> getAllDSBill(String maNhanVien) {
        List<Bill> dSBill = new ArrayList<Bill>();

        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "select * from Hoa_Don where maNhanVien = '" + maNhanVien + "'";
            preStm = con.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                Bill hd = new Bill();
                String maHD = rs.getString("maBill");
                Date ngayDat = rs.getDate("ngayDat");
                Boolean trangThai = rs.getBoolean("trangThai");
                String maNV = rs.getString("maNhanVien");
                String maKH = rs.getString("maKhachHang");
                Double giamGia = rs.getDouble("giamGia");

                Medicone nv = new Medicone(maNV);
                Customer kh = new Customer(maKH);

                hd.setBillID(maHD);
                hd.setDate(ngayDat);
                hd.setStatus(trangThai);
                hd.setStaff(nv);
                hd.setCustomer(kh);
                hd.setDiscountAmount(giamGia);

                dSBill.add(hd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dSBill;
    }

    public Customer timKiemKhachHangtheoMa(String maKH) {
        Customer customer = null;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "select * from Khach_Hang where maKhachHang = ?";
            preStm = con.prepareStatement(sql);

            preStm.setString(1, maKH);
            rs = preStm.executeQuery();
            customer = new Customer();

            while (rs.next()) {
                String tenKH = rs.getString("tenKhachHang");
                String soDienThoai = rs.getString("soDienThoai");
                Boolean gioiTinh = rs.getBoolean("gioiTinh");
                customer = new Customer(maKH, tenKH, soDienThoai, gioiTinh);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return customer;
    }

    public boolean themBill(Bill Bill) {
        boolean n = false;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "insert into Hoa_Don values(?,?,?,?,?,?)";

            preStm = con.prepareStatement(sql);

            preStm.executeUpdate();
            preStm.setString(1, Bill.getBillID());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();

            preStm.setDate(2, new java.sql.Date(date.getTime()));
            preStm.setBoolean(3, Bill.isStatus());
            preStm.setString(4, Bill.getStaff().getStaffID());
            preStm.setString(5, Bill.getCustomer().getCustomerID());
            preStm.setDouble(6, Bill.getDiscountAmount());

            n = preStm.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public boolean themCT_Bill(Bill hd, Medicine sp, int soLuong) {
        boolean n = false;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "insert into Chi_Tiet_Hoa_Don values(?,?,?)";

            preStm = con.prepareStatement(sql);

            preStm.setString(1, hd.getBillID());
            preStm.setString(2, sp.getMedicineID());
            preStm.setInt(3, soLuong);

            n = preStm.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public List<Customer> timKiemKhachHangtheoNoiDung(String noiDungTim) {
        List<Customer> dskhachHang = new ArrayList<Customer>();
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "select * from Khach_Hang where soDienThoai like ? or tenKhachHang like ?";
            preStm = con.prepareStatement(sql);

            preStm.setString(1, "%" + noiDungTim + "%");
            preStm.setString(2, "%" + noiDungTim + "%");
            rs = preStm.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();
                String maKH = rs.getString("maKhachHang");
                String tenKH = rs.getString("tenKhachHang");
                String soDienThoai = rs.getString("soDienThoai");
                Boolean gioiTinh = rs.getBoolean("gioiTinh");
                customer = new Customer(maKH, tenKH, soDienThoai, gioiTinh);
                dskhachHang.add(customer);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return dskhachHang;
    }

    public Customer timKiemKhachHangtheoSDT(String sdt) {
        Customer customer = null;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "select * from Khach_Hang where soDienThoai = ?";
            preStm = con.prepareStatement(sql);

            preStm.setString(1, sdt);
            rs = preStm.executeQuery();
            customer = new Customer();
            while (rs.next()) {
                String maKH = rs.getString("macustomer");
                String tenKH = rs.getString("tencustomer");
                String soDienThoai = rs.getString("soDienThoai");
                Boolean gioiTinh = rs.getBoolean("gioiTinh");
                customer = new Customer(soDienThoai, sdt, sql, maKH, tenKH, soDienThoai, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return customer;
    }

    public Customer timKiemCustomertheoTen(String tenKHang) {
        Customer customer = null;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "select * from Khach_Hang where tenKhachHang = ?";
            preStm = con.prepareStatement(sql);

            preStm.setString(1, tenKHang);
            rs = preStm.executeQuery();
            customer = new Customer();
            while (rs.next()) {
                String maKH = rs.getString("maKhachHang");
                String tenKH = rs.getString("tenKhachHang");
                String soDienThoai = rs.getString("soDienThoai");
                Boolean gioiTinh = rs.getBoolean("gioiTinh");
                customer = new Customer(soDienThoai, tenKHang, sql, maKH, tenKH, soDienThoai, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return customer;
    }

    public boolean xoaHD(String maBill) {
        boolean check = false;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "delete Hoa_don where maBill = ?";
            preStm = con.prepareStatement(sql);
            preStm.setString(1, maBill);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return check;
    }

    public boolean xoaCT_HD(String maBill, String maSP) {
        boolean check = false;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "delete Chi_Tiet_Hoa_Don where maBill = ? and maThuoc = ?";
            preStm = con.prepareStatement(sql);
            preStm.setString(1, maBill);
            preStm.setString(2, maSP);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return check;
    }

    public boolean capNhatSLThuoc(String maSP, int soluong) {
        boolean n = false;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "Update San_Pham set soLuong = ? where maThuoc = ?";

            preStm = con.prepareStatement(sql);
            preStm.setInt(1, soluong);
            preStm.setString(2, maSP);

            n = preStm.executeUpdate() > 0;

        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return n;
    }

    public boolean capNhatSLCT_Bill(String maHD, String maSP, int soluong) {
        boolean n = false;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "Update Chi_Tiet_Hoa_Don set soLuong = ? where maBill = ? and maThuoc = ?";

            preStm = con.prepareStatement(sql);
            preStm.setInt(1, soluong);
            preStm.setString(2, maHD);
            preStm.setString(3, maSP);

            n = preStm.executeUpdate() > 0;

        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return n;
    }

    public boolean capNhatTrangThai(Bill hd) {
        boolean n = false;
        try {
            con = ConnectDataBase.getInstance().getConnection();
            String sql = "Update Hoa_Don set trangThai = 1, giamGia = ? where maBill = ?";

            preStm = con.prepareStatement(sql);
            preStm.setDouble(1, hd.getDiscountAmount());
            preStm.setString(2, hd.getBillID());
            n = preStm.executeUpdate() > 0;

        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return n;
    }

    @Override
    public List<Medicine> getSanPhamTim(String noidung) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSanPhamTim'");
    }

    @Override
    public List<Medicine> getTatCaSanPham() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTatCaSanPham'");
    }

    @Override
    public Medicine laySanPhamTheoMa(String ma) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'laySanPhamTheoMa'");
    }

    @Override
    public List<Customer> timKiemCustomertheoNoiDung(String noiDungTim) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timKiemCustomertheoNoiDung'");
    }

    @Override
    public Customer timKiemCustomertheoSDT(String sdt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timKiemCustomertheoSDT'");
    }

    @Override
    public boolean capNhatSLSanPham(String maSP, int soluong) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'capNhatSLSanPham'");
    }

    @Override
    public Customer timKiemCustomertheoMa(String maKH) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timKiemCustomertheoMa'");
    }
}
