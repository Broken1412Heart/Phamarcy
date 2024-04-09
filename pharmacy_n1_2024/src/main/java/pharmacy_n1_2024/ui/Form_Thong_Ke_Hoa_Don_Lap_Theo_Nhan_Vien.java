package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import esp.ThongKeHoaDonLapTheoNhanVienService;
import esp.ThongKeHoaDonLapTheoNhanVienServiceImpl;
import connectDB.ConnectDataBase;

import javax.swing.border.TitledBorder;
import java.awt.ScrollPane;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien extends JFrame {

	public static JPanel contentPane;
	public static JTable table;
	private JComboBox cboNgay;
	private JComboBox cboThang;
	public static DefaultComboBoxModel cboModeMaSP = new DefaultComboBoxModel();
	public static JLabel lblTongSanPham;
	public static JLabel lblTongTien;
	public static JLabel lblTongHoaDon;
	public static DefaultTableModel tablemodel = new DefaultTableModel();
	private JTextField txtnam;
	private ThongKeHoaDonLapTheoNhanVienService thongKeHoaDonLapTheoNhanVienService = new ThongKeHoaDonLapTheoNhanVienServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien frame = new Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien() {
		setBackground(new Color(240, 255, 255));
		try {
			ConnectDataBase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnthemHD = new JPanel();
		pnthemHD.setBackground(new Color(240, 255, 255));
		pnthemHD.setBorder(
				new TitledBorder(null, "Th\u00F4ng tin chung", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnthemHD.setBounds(10, 97, 660, 147);
		contentPane.add(pnthemHD);
		pnthemHD.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ngày:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 22, 62, 20);
		pnthemHD.add(lblNewLabel);

		Button XemBC = new Button("Xem Báo Cáo");
		XemBC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ngay = cboNgay.getSelectedItem().toString();
				String thang = cboThang.getSelectedItem().toString();
				String nam = txtnam.getText();
				if (nam.equalsIgnoreCase("")) {

					JOptionPane.showMessageDialog(XemBC, "Chua nhap nam");
					return;
				}

				int ngay1 = Integer.parseInt(ngay);
				int thang1 = Integer.parseInt(thang);
				int nam1 = Integer.parseInt(nam);
				System.out.println("================");
				System.out.println(ngay1);
				System.out.println(thang1);
				System.out.println(nam1);
				String maNhanVien = Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim();
				xoaAllDuLieuTable();
				thongKeHoaDonLapTheoNhanVienService.thongKeNhanVienLapHoaDonTheoNgay(ngay1, thang1, nam1, maNhanVien);

			}
		});
		XemBC.setBackground(new Color(255, 240, 245));
		XemBC.setFont(new Font("Times New Roman", Font.BOLD, 13));
		XemBC.setBounds(252, 80, 142, 45);
		pnthemHD.add(XemBC);

		cboNgay = new JComboBox();
		cboNgay.setBackground(Color.WHITE);
		cboNgay.addItem("1");
		cboNgay.addItem("2");
		cboNgay.addItem("3");
		cboNgay.addItem("4");
		cboNgay.addItem("5");
		cboNgay.addItem("6");
		cboNgay.addItem("7");
		cboNgay.addItem("8");
		cboNgay.addItem("9");
		cboNgay.addItem("10");
		cboNgay.addItem("11");
		cboNgay.addItem("12");
		cboNgay.addItem("13");
		cboNgay.addItem("14");
		cboNgay.addItem("15");
		cboNgay.addItem("16");
		cboNgay.addItem("17");
		cboNgay.addItem("18");
		cboNgay.addItem("19");
		cboNgay.addItem("20");
		cboNgay.addItem("21");
		cboNgay.addItem("22");
		cboNgay.addItem("23");
		cboNgay.addItem("24");
		cboNgay.addItem("25");
		cboNgay.addItem("26");
		cboNgay.addItem("27");
		cboNgay.addItem("28");
		cboNgay.addItem("29");
		cboNgay.addItem("30");
		cboNgay.addItem("31");

		cboNgay.setMaximumRowCount(10);
		cboNgay.setEditable(true);
		cboNgay.setBounds(82, 21, 89, 20);
		pnthemHD.add(cboNgay);

		JLabel lblNewLabel_6 = new JLabel("Tháng: ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(181, 22, 61, 20);
		pnthemHD.add(lblNewLabel_6);

		cboThang = new JComboBox();
		cboThang.setBackground(Color.WHITE);
		cboThang.addItem("1");
		cboThang.addItem("2");
		cboThang.addItem("3");
		cboThang.addItem("4");
		cboThang.addItem("5");
		cboThang.addItem("6");
		cboThang.addItem("7");
		cboThang.addItem("8");
		cboThang.addItem("9");
		cboThang.addItem("10");
		cboThang.addItem("11");
		cboThang.addItem("12");
		cboThang.setMaximumRowCount(10);
		cboThang.setEditable(true);
		cboThang.setBounds(252, 22, 142, 21);
		pnthemHD.add(cboThang);

		JLabel lblNewLabel_7 = new JLabel("Năm:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(401, 22, 47, 20);
		pnthemHD.add(lblNewLabel_7);

		txtnam = new JTextField();
		txtnam.setBackground(Color.WHITE);
		txtnam.setBounds(458, 22, 192, 20);
		pnthemHD.add(txtnam);
		txtnam.setColumns(10);

		Label label = new Label("THỐNG KÊ NHÂN VIÊN LẬP HÓA ĐƠN THEO NGÀY");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Arial", Font.BOLD, 25));
		label.setBackground(new Color(255, 240, 245));
		label.setBounds(361, 36, 730, 32);
		contentPane.add(label);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBackground(new Color(255, 240, 245));
		scrollPane.setBounds(10, 10, 1284, 81);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(680, 97, 614, 147);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Tổng sản phẩm đã bán:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 22, 198, 22);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Tổng tiền đã bán:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 55, 174, 22);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Tổng số hóa đơn:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(10, 88, 190, 17);
		panel.add(lblNewLabel_5);

		lblTongSanPham = new JLabel("");
		lblTongSanPham.setBounds(225, 22, 368, 20);
		panel.add(lblTongSanPham);

		lblTongTien = new JLabel("");
		lblTongTien.setBounds(225, 58, 368, 20);
		panel.add(lblTongTien);

		lblTongHoaDon = new JLabel("");
		lblTongHoaDon.setBounds(225, 88, 368, 20);
		panel.add(lblTongHoaDon);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 255, 1284, 345);
		contentPane.add(scrollPane_1);

		table = new JTable(tablemodel);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"STT", "Mã hóa đơn", "Mã nhân viên", "Tên nhân viên", "Ngày đặt hàng", "Tổng tiền", "Số lượng"
				}));
		table.getColumnModel().getColumn(3).setPreferredWidth(84);
		scrollPane_1.setViewportView(table);
	}

	public void xoaAllDuLieuTable() {
		for (int i = tablemodel.getRowCount(); i > 0; i--) {
			tablemodel.removeRow(0);
		}
	}

	public void thongKeNhanVienLapHoaDonTheoNgay(int ngay, int thang, int nam) {
		DecimalFormat tien = new DecimalFormat("###,###,### VND");
		tablemodel = (DefaultTableModel) table.getModel();
		xoaAllDuLieuTable();
		try {

			Connection con = ConnectDataBase.getInstance().getConnection();
			PreparedStatement stmt = null;
			String sql = "SELECT        CT_HoaDon.maHoaDon, NhanVien.maNV, NhanVien.tenNV, NhanVien.caLamViec, HoaDon.ngayLap, HoaDon.tongTien,sum( CT_HoaDon.soLuong) as SoLuong\r\n"
					+ "FROM            CT_HoaDon INNER JOIN\r\n"
					+ "                         SanPham ON CT_HoaDon.maSanPham = SanPham.maSanPham INNER JOIN\r\n"
					+ "                         HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
					+ "                         NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
					+ "where	Day(ngayLap)=? and month(ngayLap)=? and year(ngayLap)=?\r\n"
					+ "group by  CT_HoaDon.maHoaDon, NhanVien.maNV, NhanVien.tenNV, NhanVien.caLamViec, HoaDon.ngayLap, HoaDon.tongTien";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ngay);
			stmt.setInt(2, thang);
			stmt.setInt(3, nam);
			ResultSet rs = stmt.executeQuery();
			int i = 0;
			String maHoaDonSoSanh = "";
			Object[] ds = null;
			int checkNull = 0;
			double tongTienDaBan = 0;
			int tongSoLuongSachDaBan = 0;
			while (rs.next()) {
				if (rs.getString("maHoaDon").equalsIgnoreCase(maHoaDonSoSanh) == false) {
					++i;
					String stt = i + "";
					ds = new String[] { stt, rs.getString("maHoaDon"), rs.getString("maNV"), rs.getString("tenNV"),
							rs.getString("caLamViec"), rs.getString("ngayLap"), tien.format(rs.getDouble("tongTien")),
							rs.getString("soLuong") };
					maHoaDonSoSanh = rs.getString("maHoaDon");
					Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien.tablemodel.addRow(ds);
					tongTienDaBan += rs.getDouble("tongTien");
					tongSoLuongSachDaBan += rs.getInt("soLuong");
					checkNull++;
				}
			}
			if (checkNull == 0) {
				JOptionPane.showMessageDialog(null, "Khong co du lieu cua ngay:" + ngay + "/" + thang + "/" + nam);

			}

			System.out.println(ds.toString());
			System.out.println(tongSoLuongSachDaBan);
			System.out.println(tongTienDaBan);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void thongKeNhanVienLapHoaDonTheoNgay_maNV(int manv) {
		DecimalFormat tien = new DecimalFormat("###,###,### VND");
		tablemodel = (DefaultTableModel) table.getModel();

		try {

			Connection con = ConnectDataBase.getInstance().getConnection();
			PreparedStatement stmt = null;
			String sql = "SELECT        CT_HoaDon.maHoaDon, NhanVien.maNV, NhanVien.tenNV, NhanVien.caLamViec, HoaDon.ngayLap, HoaDon.tongTien,sum( CT_HoaDon.soLuong) as SoLuong\r\n"
					+ "FROM            CT_HoaDon INNER JOIN\r\n"
					+ "                         SanPham ON CT_HoaDon.maSanPham = SanPham.maSanPham INNER JOIN\r\n"
					+ "                         HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN\r\n"
					+ "                         NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
					+ "where	NhanVien.maNV=?\r\n"
					+ "group by  CT_HoaDon.maHoaDon, NhanVien.maNV, NhanVien.tenNV, NhanVien.caLamViec, HoaDon.ngayLap, HoaDon.tongTien";

			stmt = con.prepareStatement(sql);

			stmt.setInt(1, manv);
			ResultSet rs = stmt.executeQuery();
			int i = 0;
			String maHoaDonSoSanh = "";
			Object[] ds = null;
			int checkNull = 0;
			double tongTienDaBan = 0;
			int tongSoLuongSachDaBan = 0;
			while (rs.next()) {
				if (rs.getString("maHoaDon").equalsIgnoreCase(maHoaDonSoSanh) == false) {
					++i;
					String stt = i + "";
					ds = new String[] { stt, rs.getString("maHoaDon"), rs.getString("maNV"), rs.getString("tenNV"),
							rs.getString("caLamViec"), rs.getString("ngayLap"), tien.format(rs.getDouble("tongTien")),
							rs.getString("soLuong") };
					maHoaDonSoSanh = rs.getString("maHoaDon");
					Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien.tablemodel.addRow(ds);
					tongTienDaBan += rs.getDouble("tongTien");
					tongSoLuongSachDaBan += rs.getInt("soLuong");
					checkNull++;
				}
			}
			if (checkNull == 0) {
				JOptionPane.showMessageDialog(null, "Khong co du lieu ");

			}

			System.out.println(ds);
			System.out.println(tongSoLuongSachDaBan);
			System.out.println(tongTienDaBan);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
