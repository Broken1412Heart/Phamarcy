package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.bouncycastle.util.encoders.UTF8;

import com.toedter.calendar.JDateChooser;

import esp.HoaDonService;
import esp.HoaDonServiceImpl;
import esp.ThongKeDoanhThuService;
import esp.ThongKeDoanhThuServiceImpl;
import connectDB.ConnectDataBase;
import entity.ChiTietHoaDon;
import entity.Bill;
import entity.entity.Staff;
import entity.NhanVien;
import entity.Phong;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Form_HoaDon extends JFrame implements ActionListener, MouseListener, KeyListener, ItemListener {

	public static JPanel contentPane;
	private JTextField txtMaSanPham;
	private JTextField txtSoLuong;
	private JTextField txtSDT_entity.Staff;
	private JTable tableSanPham;
	private JTable tableDonHang;
	private JTextField txtSoTienKhachDua;
	private JTable tableHoaDon;
	private DefaultTableModel dataModelHoaDon;
	private DefaultTableModel dataModelSanPham;
	private DefaultTableModel dataModelDonHang;
	private JTextField txtSDT;
	private JComboBox cboKichThuoc;
	private JButton btnTimKiemSP;
	private JButton btnLamMoi;
	private JButton btnThemVaoCT_Don;
	private JButton btnTimKH;
	private JButton btnSuaSoLuong;
	private JButton btnXoaCT_Don;
	private JButton btnLuu;
	private JButton btnThemKH;
	private JButton btnThanhToan;
	private JButton btnLocHDtheoSDT;
	private JButton btnXoaHD;
	private JButton btnXoaRong;
	private JTextField txtNgayLap;
	private JTextField txtMaHD;
	private JTextField txtNhanVien;
	private JTextField txtentity.Staff;
	private JTextField txtTongTien;
	private JTextField txtThanhTien;
	private JTextField txtTienThua;
	private JTextField txtVAT;
	private JButton btnXuatBaoCao;
	private java.util.Date ngayHomNay = new java.util.Date();
	private Date ngayLap = new Date(ngayHomNay.getTime());
	private JScrollPane scrollSanPam;
	private HoaDonService hoaDonService = new HoaDonServiceImpl();
	private ThongKeDoanhThuService thongKeDoanhThuService = new ThongKeDoanhThuServiceImpl();
	private double tongTienBaoCao;
	private JComboBox cboTenentity.Staff;
	private JTextField txtTenOrSDT;
	private JTextField txtSoTienGiam;
	private JTextField txtPhanTramGiam;
	private JLabel lblGiamPhanTram;
	private JTextField txtSanPham;
	private JTextField txtGiamSP;
	private JTextField txtMaSPban;

	private static List<HoaDon> allHoaDon = new ArrayList<>();
	private static List<Phong> allSanPham = new ArrayList<>();
	private static List<ChiTietHoaDon> ct_HoaDontheoHD = new ArrayList<>();

	private Phong sanphamChon;
	private Phong sanphamChon_DonHang;
	private HoaDon hoadonChon;
	private JComboBox cboTinhTrangHD;
	private JComboBox cboNgay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_HoaDon frame = new Form_HoaDon();
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
	public Form_HoaDon() {
		// DAO
		try {
			ConnectDataBase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String homNay = sm.format(ngayHomNay);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1380, 780);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBackground(new Color(240, 255, 255));
		pnTimKiem.setBorder(new TitledBorder(
				new TitledBorder(
						new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "T\u00ECm ki\u1EBFm",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"T\u00ECm ki\u1EBFm ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnTimKiem.setBounds(6, 6, 607, 172);
		contentPane.add(pnTimKiem);
		pnTimKiem.setLayout(null);

		Font fntText = new Font("Arial", Font.PLAIN, 14);

		JLabel lblMaSanPham = new JLabel("Tên / mã sản phẩm:");
		lblMaSanPham.setFont(fntText);
		lblMaSanPham.setBounds(129, 23, 137, 39);
		pnTimKiem.add(lblMaSanPham);

		txtMaSanPham = new JTextField();
		txtMaSanPham.setBackground(Color.WHITE);
		txtMaSanPham.setFont(fntText);
		txtMaSanPham.setBounds(278, 29, 170, 26);
		pnTimKiem.add(txtMaSanPham);
		txtMaSanPham.setColumns(10);

		JLabel lblKichThuoc = new JLabel("Kích thước:");
		lblKichThuoc.setFont(fntText);
		lblKichThuoc.setBounds(176, 74, 90, 39);
		pnTimKiem.add(lblKichThuoc);

		cboKichThuoc = new JComboBox();
		cboKichThuoc.setBackground(Color.WHITE);
		cboKichThuoc.setModel(
				new DefaultComboBoxModel(new String[] { "Chọn Size", "S", "M", "L", "XL", "XXL", "FreeSize" }));
		cboKichThuoc.setFont(fntText);
		cboKichThuoc.setBounds(278, 81, 170, 27);
		pnTimKiem.add(cboKichThuoc);

		btnTimKiemSP = new JButton("Tìm kiếm");
		btnTimKiemSP.setBackground(new Color(255, 240, 245));
		btnTimKiemSP.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTimKiemSP.setBounds(186, 118, 117, 29);
		pnTimKiem.add(btnTimKiemSP);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(new Color(255, 240, 245));
		btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLamMoi.setBounds(315, 118, 117, 29);
		pnTimKiem.add(btnLamMoi);

		JPanel pnList_SanPham = new JPanel();
		pnList_SanPham.setBackground(new Color(240, 255, 255));
		pnList_SanPham.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnList_SanPham.setBounds(6, 189, 607, 300);
		contentPane.add(pnList_SanPham);
		pnList_SanPham.setLayout(new BorderLayout(0, 0));

		scrollSanPam = new JScrollPane();
		pnList_SanPham.add(scrollSanPam);

		tableSanPham = new JTable();
		tableSanPham.setBackground(new Color(240, 255, 255));
		tableSanPham.setFont(fntText);
		tableSanPham.setModel(dataModelSanPham = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã sản phẩm", "Tên sản phẩm", "Size", "Màu", "Đơn giá", "SL" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, String.class,
					Double.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableSanPham.getTableHeader().setFont(fntText);
		tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableSanPham.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableSanPham.getColumnModel().getColumn(2).setPreferredWidth(220);
		tableSanPham.getColumnModel().getColumn(3).setPreferredWidth(90);
		tableSanPham.getColumnModel().getColumn(4).setPreferredWidth(50);
		tableSanPham.getColumnModel().getColumn(5).setPreferredWidth(100);
		tableSanPham.getColumnModel().getColumn(6).setPreferredWidth(50);
		scrollSanPam.setViewportView(tableSanPham);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(fntText);
		txtSoLuong.setBackground(Color.WHITE);
		txtSoLuong.setBounds(343, 500, 62, 30);
		txtSoLuong.setEditable(false);
		contentPane.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		btnThemVaoCT_Don = new JButton("+");
		btnThemVaoCT_Don.setBackground(new Color(255, 240, 245));
		btnThemVaoCT_Don.setFont(fntText);
		btnThemVaoCT_Don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnThemVaoCT_Don.setBounds(415, 500, 62, 30);
		contentPane.add(btnThemVaoCT_Don);

		JPanel pnDonHang = new JPanel();
		pnDonHang.setBackground(new Color(240, 255, 255));
		pnDonHang.setBorder(new TitledBorder(null, "Th\u00F4ng tin \u0111\u01A1n h\u00E0ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnDonHang.setBounds(625, 6, 717, 184);
		contentPane.add(pnDonHang);
		pnDonHang.setLayout(null);

		JLabel lblDonHang = new JLabel("ĐƠN HÀNG");
		lblDonHang.setForeground(new Color(255, 38, 0));
		lblDonHang.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDonHang.setBounds(285, 11, 111, 39);
		pnDonHang.add(lblDonHang);

		JLabel lblNgayLap = new JLabel("Ngày lập:");
		lblNgayLap.setFont(fntText);
		lblNgayLap.setBounds(27, 46, 86, 30);
		pnDonHang.add(lblNgayLap);

		JLabel lblMaHoaDon = new JLabel("Mã hoá đơn:");
		lblMaHoaDon.setFont(fntText);
		lblMaHoaDon.setBounds(27, 88, 86, 30);
		pnDonHang.add(lblMaHoaDon);

		JLabel lblNhanVien = new JLabel("Nhân viên:");
		lblNhanVien.setFont(fntText);
		lblNhanVien.setBounds(27, 130, 86, 30);
		pnDonHang.add(lblNhanVien);

		JLabel lblSDT_entity.Staff = new JLabel("SĐT khách hàng:");
		lblSDT_entity.Staff.setFont(fntText);
		lblSDT_entity.Staff.setBounds(305, 130, 117, 30);
		pnDonHang.add(lblSDT_entity.Staff);

		txtSDT_entity.Staff = new JTextField();
		txtSDT_entity.Staff.setEditable(false);
		txtSDT_entity.Staff.setBackground(Color.WHITE);
		txtSDT_entity.Staff.setFont(fntText);
		txtSDT_entity.Staff.setBounds(434, 131, 150, 30);
		pnDonHang.add(txtSDT_entity.Staff);
		txtSDT_entity.Staff.setColumns(10);

		JLabel lblentity.Staff = new JLabel("Khách hàng:");
		lblentity.Staff.setFont(fntText);
		lblentity.Staff.setBounds(305, 88, 117, 30);
		pnDonHang.add(lblentity.Staff);

		btnTimKH = new JButton("Tìm kiếm");
		btnTimKH.setBackground(new Color(255, 240, 245));
		btnTimKH.setFont(fntText);
		btnTimKH.setBounds(596, 47, 109, 30);
		pnDonHang.add(btnTimKH);

		btnThemKH = new JButton("Thêm KH");
		btnThemKH.setBackground(new Color(255, 240, 245));
		btnThemKH.setFont(fntText);
		btnThemKH.setBounds(596, 89, 109, 30);
		pnDonHang.add(btnThemKH);

		txtNgayLap = new JTextField();
		txtNgayLap.setBackground(Color.WHITE);
		txtNgayLap.setText(homNay);
		txtNgayLap.setForeground(new Color(0, 128, 255));
		txtNgayLap.setEditable(false);
		txtNgayLap.setFont(new Font("Arial", Font.ITALIC, 14));
		txtNgayLap.setBounds(123, 47, 150, 30);
		pnDonHang.add(txtNgayLap);
		txtNgayLap.setColumns(10);

		txtMaHD = new JTextField();
		txtMaHD.setBackground(Color.WHITE);
		txtMaHD.setText("");
		txtMaHD.setForeground(new Color(0, 128, 255));
		txtMaHD.setEditable(true);
		txtMaHD.setFont(new Font("Arial", Font.ITALIC, 14));
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(125, 89, 150, 30);
		txtMaHD.setEnabled(false);
		pnDonHang.add(txtMaHD);

		txtNhanVien = new JTextField();
		txtNhanVien.setBackground(Color.WHITE);
		txtNhanVien.setText(Form_Quan_Ly_Tai_Khoan.textTenNhanVien.getText().trim());
		txtNhanVien.setForeground(new Color(0, 128, 255));
		txtNhanVien.setFont(new Font("Arial", Font.ITALIC, 14));
		txtNhanVien.setEditable(false);
		txtNhanVien.setColumns(10);
		txtNhanVien.setBounds(125, 131, 150, 30);
		pnDonHang.add(txtNhanVien);

		cboTenentity.Staff = new JComboBox();
		cboTenentity.Staff.setBackground(Color.WHITE);
		cboTenentity.Staff.setBounds(434, 89, 150, 30);
		pnDonHang.add(cboTenentity.Staff);

		txtTenOrSDT = new JTextField();
		txtTenOrSDT.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTenOrSDT.setColumns(10);
		txtTenOrSDT.setBackground(Color.WHITE);
		txtTenOrSDT.setBounds(434, 47, 150, 30);
		pnDonHang.add(txtTenOrSDT);

		JLabel lblThongTinTim = new JLabel("Tìm SDT/Tên:");
		lblThongTinTim.setFont(new Font("Arial", Font.PLAIN, 14));
		lblThongTinTim.setBounds(305, 46, 117, 30);
		pnDonHang.add(lblThongTinTim);

		// txtentity.Staff = new JTextField();
		// txtentity.Staff.setText("");
		// txtentity.Staff.setForeground(Color.RED);
		// txtentity.Staff.setFont(new Font("Arial", Font.ITALIC, 14));
		// txtentity.Staff.setEditable(false);
		// txtentity.Staff.setColumns(10);
		// txtentity.Staff.setBounds(434, 118, 150, 26);
		// pnDonHang.add(txtentity.Staff);

		JPanel pnCT_DonHang = new JPanel();
		pnCT_DonHang.setBackground(new Color(240, 255, 255));
		pnCT_DonHang.setBounds(625, 191, 717, 132);
		contentPane.add(pnCT_DonHang);
		pnCT_DonHang.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollDonHang = new JScrollPane();
		pnCT_DonHang.add(scrollDonHang);

		tableDonHang = new JTable();
		tableDonHang.setBackground(new Color(240, 255, 255));
		tableDonHang.setFont(fntText);
		tableDonHang.setModel(dataModelDonHang = new DefaultTableModel(new Object[][] {}, new String[] { "Mã sản phẩm",
				"Tên sản phẩm", "Size", "Màu", "Đơn giá", "Giảm", "SL", "Thành tiền" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Double.class,
					Double.class, Integer.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableDonHang.getTableHeader().setFont(fntText);
		tableDonHang.getColumnModel().getColumn(0).setPreferredWidth(170);
		tableDonHang.getColumnModel().getColumn(1).setPreferredWidth(180);
		tableDonHang.getColumnModel().getColumn(2).setPreferredWidth(70);
		tableDonHang.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableDonHang.getColumnModel().getColumn(4).setPreferredWidth(70);
		tableDonHang.getColumnModel().getColumn(5).setPreferredWidth(50);
		tableDonHang.getColumnModel().getColumn(6).setPreferredWidth(50);
		tableDonHang.getColumnModel().getColumn(7).setPreferredWidth(100);
		scrollDonHang.setViewportView(tableDonHang);

		JPanel pnTinhToanTien = new JPanel();
		pnTinhToanTien.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnTinhToanTien.setBackground(new Color(240, 255, 255));
		pnTinhToanTien.setBounds(625, 373, 717, 165);
		contentPane.add(pnTinhToanTien);
		pnTinhToanTien.setLayout(null);

		JLabel lblTong = new JLabel("Tổng tiền: ");
		lblTong.setFont(fntText);
		lblTong.setBounds(340, 7, 120, 30);
		pnTinhToanTien.add(lblTong);

		JLabel lblVat = new JLabel("VAT: ");
		lblVat.setFont(fntText);
		lblVat.setBounds(10, 44, 80, 30);
		pnTinhToanTien.add(lblVat);

		JLabel lblThanhTien = new JLabel("Thành tiền:");
		lblThanhTien.setFont(fntText);
		lblThanhTien.setBounds(10, 81, 80, 30);
		pnTinhToanTien.add(lblThanhTien);

		JLabel lblTienKhachDua = new JLabel("Tiền khách đưa: ");
		lblTienKhachDua.setFont(fntText);
		lblTienKhachDua.setBounds(340, 81, 120, 30);
		pnTinhToanTien.add(lblTienKhachDua);

		txtSoTienKhachDua = new JTextField();
		txtSoTienKhachDua.setFont(fntText);
		txtSoTienKhachDua.setBackground(Color.WHITE);
		txtSoTienKhachDua.setBounds(472, 81, 180, 30);
		pnTinhToanTien.add(txtSoTienKhachDua);
		txtSoTienKhachDua.setColumns(10);

		JLabel lblTienThua = new JLabel("Tiền thừa: ");
		lblTienThua.setFont(fntText);
		lblTienThua.setBounds(10, 118, 80, 30);
		pnTinhToanTien.add(lblTienThua);

		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBackground(new Color(255, 240, 245));
		btnThanhToan.setEnabled(false);
		btnThanhToan.setFont(new Font("Arial", Font.PLAIN, 14));
		btnThanhToan.setBounds(422, 118, 117, 30);
		pnTinhToanTien.add(btnThanhToan);

		txtTongTien = new JTextField();
		txtTongTien.setBackground(Color.WHITE);
		txtTongTien.setForeground(new Color(0, 128, 255));
		txtTongTien.setFont(new Font("Arial", Font.ITALIC, 14));
		txtTongTien.setEditable(false);
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(472, 7, 180, 30);
		pnTinhToanTien.add(txtTongTien);

		txtThanhTien = new JTextField();
		txtThanhTien.setBackground(Color.WHITE);
		txtThanhTien.setForeground(new Color(0, 128, 255));
		txtThanhTien.setFont(new Font("Arial", Font.ITALIC, 14));
		txtThanhTien.setEditable(false);
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(102, 81, 180, 30);
		pnTinhToanTien.add(txtThanhTien);

		txtTienThua = new JTextField();
		txtTienThua.setBackground(Color.WHITE);
		txtTienThua.setText("");
		txtTienThua.setForeground(new Color(0, 128, 255));
		txtTienThua.setFont(new Font("Arial", Font.ITALIC, 14));
		txtTienThua.setEditable(false);
		txtTienThua.setColumns(10);
		txtTienThua.setBounds(102, 118, 180, 30);
		pnTinhToanTien.add(txtTienThua);

		txtVAT = new JTextField();
		txtVAT.setBackground(Color.WHITE);
		txtVAT.setForeground(new Color(0, 128, 255));
		txtVAT.setFont(new Font("Arial", Font.ITALIC, 14));
		txtVAT.setEditable(false);
		txtVAT.setColumns(10);
		txtVAT.setBounds(102, 44, 180, 30);
		pnTinhToanTien.add(txtVAT);

		txtSoTienGiam = new JTextField();
		txtSoTienGiam.setBackground(Color.WHITE);
		txtSoTienGiam.setForeground(new Color(0, 128, 255));
		txtSoTienGiam.setFont(new Font("Arial", Font.ITALIC, 14));
		txtSoTienGiam.setEditable(false);
		txtSoTienGiam.setColumns(10);
		txtSoTienGiam.setBounds(553, 44, 101, 30);
		pnTinhToanTien.add(txtSoTienGiam);

		JLabel lblGiamHoaDon = new JLabel("Giảm %");
		lblGiamHoaDon.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGiamHoaDon.setBounds(340, 44, 55, 30);
		pnTinhToanTien.add(lblGiamHoaDon);

		txtPhanTramGiam = new JTextField();
		txtPhanTramGiam.setBackground(Color.WHITE);
		txtPhanTramGiam.setForeground(new Color(0, 128, 255));
		txtPhanTramGiam.setFont(new Font("Arial", Font.ITALIC, 14));
		txtPhanTramGiam.setColumns(10);
		txtPhanTramGiam.setBounds(407, 44, 48, 30);
		pnTinhToanTien.add(txtPhanTramGiam);

		lblGiamPhanTram = new JLabel("Giảm tiền");
		lblGiamPhanTram.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGiamPhanTram.setBounds(467, 44, 72, 30);
		pnTinhToanTien.add(lblGiamPhanTram);

		JLabel lblGiamSp = new JLabel("Giảm SP:");
		lblGiamSp.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGiamSp.setBounds(10, 7, 80, 30);
		pnTinhToanTien.add(lblGiamSp);

		txtGiamSP = new JTextField();
		txtGiamSP.setBackground(Color.WHITE);
		txtGiamSP.setEditable(false);
		txtGiamSP.setFont(new Font("Arial", Font.ITALIC, 14));
		txtGiamSP.setForeground(new Color(0, 128, 255));
		txtGiamSP.setBounds(102, 7, 180, 30);
		pnTinhToanTien.add(txtGiamSP);
		txtGiamSP.setColumns(10);

		JPanel pnHoaDonTrongNgay = new JPanel();
		pnHoaDonTrongNgay.setBackground(new Color(240, 255, 255));
		pnHoaDonTrongNgay.setBounds(8, 544, 971, 155);
		contentPane.add(pnHoaDonTrongNgay);
		pnHoaDonTrongNgay.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollHoaDon = new JScrollPane();
		pnHoaDonTrongNgay.add(scrollHoaDon);

		tableHoaDon = new JTable();
		tableHoaDon.setBackground(new Color(240, 255, 255));
		tableHoaDon.setFont(fntText);
		tableHoaDon.setModel(dataModelHoaDon = new DefaultTableModel(new Object[][] {}, new String[] { "Mã hoá đơn",
				"Mã khách hàng", "Số điện thoại", "Ngày lập", "Thành tiền", "Trạng thái" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Double.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableHoaDon.getTableHeader().setFont(fntText);
		tableHoaDon.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableHoaDon.getColumnModel().getColumn(1).setPreferredWidth(160);
		tableHoaDon.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableHoaDon.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableHoaDon.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableHoaDon.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollHoaDon.setViewportView(tableHoaDon);

		JPanel pnCongCu = new JPanel();
		pnCongCu.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnCongCu.setBackground(new Color(240, 255, 255));
		pnCongCu.setBounds(989, 544, 353, 155);
		contentPane.add(pnCongCu);
		pnCongCu.setLayout(null);

		btnLocHDtheoSDT = new JButton("Tìm kiếm");
		btnLocHDtheoSDT.setBackground(new Color(255, 240, 245));
		btnLocHDtheoSDT.setFont(fntText);
		btnLocHDtheoSDT.setBounds(241, 54, 102, 30);
		pnCongCu.add(btnLocHDtheoSDT);

		btnXoaHD = new JButton("Xoá");
		btnXoaHD.setBackground(new Color(255, 240, 245));
		btnXoaHD.setEnabled(true);
		btnXoaHD.setFont(fntText);
		btnXoaHD.setBounds(57, 103, 96, 30);
		btnXoaHD.setEnabled(false);
		pnCongCu.add(btnXoaHD);

		JLabel lblSdt = new JLabel("SDT: ");
		lblSdt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSdt.setBounds(6, 52, 40, 30);
		pnCongCu.add(lblSdt);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBackground(Color.WHITE);
		txtSDT.setBounds(58, 54, 173, 30);
		pnCongCu.add(txtSDT);

		btnXuatBaoCao = new JButton("In hóa đơn");
		btnXuatBaoCao.setBackground(new Color(255, 240, 245));
		btnXuatBaoCao.setFont(new Font("Arial", Font.PLAIN, 14));
		btnXuatBaoCao.setEnabled(true);
		btnXuatBaoCao.setBounds(191, 103, 127, 30);
		pnCongCu.add(btnXuatBaoCao);

		cboTinhTrangHD = new JComboBox();
		cboTinhTrangHD.setBackground(Color.WHITE);
		cboTinhTrangHD.setFont(new Font("Arial", Font.PLAIN, 14));
		cboTinhTrangHD.setModel(new DefaultComboBoxModel(new String[] { "Đã thanh toán", "Chưa thanh toán" }));
		cboTinhTrangHD.setBounds(58, 16, 173, 30);
		pnCongCu.add(cboTinhTrangHD);

		cboNgay = new JComboBox();
		cboNgay.setBackground(Color.WHITE);
		cboNgay.setFont(new Font("Arial", Font.PLAIN, 14));
		cboNgay.setModel(new DefaultComboBoxModel(new String[] { "Hôm nay", "Tất cả" }));
		cboNgay.setBounds(241, 16, 102, 30);
		pnCongCu.add(cboNgay);

		btnSuaSoLuong = new JButton("Sửa SL");
		btnSuaSoLuong.setBackground(new Color(255, 240, 245));
		btnSuaSoLuong.setEnabled(false);
		btnSuaSoLuong.setBounds(986, 334, 91, 30);
		contentPane.add(btnSuaSoLuong);
		btnSuaSoLuong.setFont(fntText);

		btnXoaCT_Don = new JButton("Xoá");
		btnXoaCT_Don.setBackground(new Color(255, 240, 245));
		btnXoaCT_Don.setEnabled(false);
		btnXoaCT_Don.setBounds(1087, 334, 65, 30);
		contentPane.add(btnXoaCT_Don);
		btnXoaCT_Don.setFont(fntText);

		btnLuu = new JButton("Lưu tạm");
		btnLuu.setBackground(new Color(255, 240, 245));
		btnLuu.setBounds(1162, 334, 107, 30);
		btnLuu.setEnabled(false);
		contentPane.add(btnLuu);
		btnLuu.setFont(fntText);

		JLabel lblMaSPchon = new JLabel("Sản phẩm:");
		lblMaSPchon.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMaSPchon.setBounds(16, 500, 73, 30);
		contentPane.add(lblMaSPchon);

		txtSanPham = new JTextField();
		txtSanPham.setBackground(Color.WHITE);
		txtSanPham.setEditable(false);
		txtSanPham.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSanPham.setBounds(99, 500, 159, 30);
		contentPane.add(txtSanPham);
		txtSanPham.setColumns(10);

		JLabel lblThmSl = new JLabel("Thêm SL");
		lblThmSl.setFont(new Font("Arial", Font.PLAIN, 14));
		lblThmSl.setBounds(268, 500, 65, 30);
		contentPane.add(lblThmSl);

		JLabel lblMaSPban = new JLabel("Mã SP bán:");
		lblMaSPban.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMaSPban.setBounds(678, 334, 91, 30);
		contentPane.add(lblMaSPban);

		txtMaSPban = new JTextField();
		txtMaSPban.setBackground(Color.WHITE);
		txtMaSPban.setEditable(false);
		txtMaSPban.setBounds(779, 334, 175, 30);
		contentPane.add(txtMaSPban);
		txtMaSPban.setColumns(10);

		btnXoaRong = new JButton("Xoá Rỗng F5");
		btnXoaRong.setBackground(new Color(255, 240, 245));
		btnXoaRong.setFont(new Font("Arial", Font.PLAIN, 14));
		btnXoaRong.setBounds(487, 500, 126, 30);
		contentPane.add(btnXoaRong);

		btnXoaRong.setMnemonic(KeyEvent.VK_F5);

		xoaHDChuaThanhToan();
		addEvent();
		allSanPham = hoaDonService.getTatCaSanPham();
		loadDuLieuSanPham(allSanPham);
		// allHoaDon =
		// hoaDonService.getAllDSHoadon(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
		loadTableHoaDon(allHoaDon);
	}

	public void addEvent() {
		btnLamMoi.addActionListener(this);
		btnLocHDtheoSDT.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSuaSoLuong.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnThemVaoCT_Don.addActionListener(this);
		btnThemKH.addActionListener(this);
		btnTimKH.addActionListener(this);
		btnTimKiemSP.addActionListener(this);
		btnXoaCT_Don.addActionListener(this);
		btnXoaHD.addActionListener(this);
		btnXuatBaoCao.addActionListener(this);
		tableHoaDon.addMouseListener(this);
		tableSanPham.addMouseListener(this);
		tableDonHang.addMouseListener(this);
		txtSoTienKhachDua.addKeyListener(this);
		txtSoLuong.addKeyListener(this);
		txtPhanTramGiam.addKeyListener(this);
		cboTenentity.Staff.addItemListener(this);
		cboTinhTrangHD.addItemListener(this);
		cboNgay.addItemListener(this);
		btnXoaRong.addActionListener(this);
	}

	private void xoaHDChuaThanhToan() {
		allHoaDon = hoaDonService.getAllDSHoadon(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
		List<HoaDon> list_HD = new ArrayList<>();
		for (HoaDon hd : allHoaDon) {
			if (hd.isTrangThai() == false) {
				list_HD.add(hd);
			}
		}
		for (HoaDon hd : list_HD) {
			xoaHoaDon(hd);
		}
	}

	private List<Phong> dsSanPham() {
		List<Phong> lt = new ArrayList<>();
		String noidung = txtMaSanPham.getText().trim();
		lt = hoaDonService.getSanPhamTim(noidung);
		return lt;
	}

	// Tạo hàm xuất hóa đơn
	@SuppressWarnings("deprecation")
	public void XuatHoaDon(Date ngayHomNay, double tongTien, String hoadonChon) {
		try {

			Hashtable map = new Hashtable();

			map.put("maNhanVien", Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
			map.put("ngayHomNay", ngayHomNay);
			map.put("tongTien", tongTien);
			map.put("hoadonChon", hoadonChon);

			JasperReport report = JasperCompileManager.compileReport("src/main/java/gui/rptXuatHoaDon.jrxml");

			JasperPrint p = JasperFillManager.fillReport(report, map, ConnectDataBase.getConnection());
			// JRDesignStyle jrDesignStyle = new JRDesignStyle();
			/* Set the Encoding to UTF-8 for pdf and embed font to arial */
			// jrDesignStyle.setDefault(true);
			String fontPath = "XuatHoaDon.pdf";
			// jrDesignStyle.setPdfFontName(fontPath);
			// jrDesignStyle.setPdfEncoding("Identity-H");
			// jrDesignStyle.setPdfEmbedded(true);
			// p.addStyle(jrDesignStyle);
			JasperViewer.viewReport(p, false);
			JasperExportManager.exportReportToPdfFile(p, fontPath);
			// JRPdfExporter exporter = new JRPdfExporter();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void loadDuLieuSanPham(List<Phong> lt) {
		String kichThuoc = cboKichThuoc.getSelectedItem().toString().trim();
		// System.out.println(kichThuoc);
		dataModelSanPham.setRowCount(0);
		int i = 0;
		for (Phong sanPham : lt) {
			// System.out.println(sanPham);
			String maSP = sanPham.getMaSanPham();
			String tenSP = sanPham.getTenSanPham();
			String kthuoc = sanPham.getKichThuoc().trim();
			String mauSac = sanPham.getMauSac();
			double donGia = sanPham.getDonGia();
			int soLuong = sanPham.getSoLuong();
			if (cboKichThuoc.getSelectedIndex() == 0 || kichThuoc.equals(kthuoc)) {
				i++;
				dataModelSanPham.addRow(new Object[] { i, maSP, tenSP, kthuoc, mauSac, donGia, soLuong });
			}
		}
	}

	public void loadDuLieuCT_HoaDon(HoaDon hoadon) {
		List<ChiTietHoaDon> lt = new ArrayList<>();
		lt = hoaDonService.getCT_HoadonTheoHoaDon(hoadon.getMaHoaDon());
		dataModelDonHang.setRowCount(0);
		for (ChiTietHoaDon ct : lt) {
			String maSP = ct.getSanPham().getMaSanPham();
			Phong sp = hoaDonService.laySanPhamTheoMa(maSP);
			double tongtien = (sp.getDonGia() * ct.getSoLuong()) * (1 - sp.getGiamGia());

			dataModelDonHang.addRow(new Object[] { sp.getMaSanPham(), sp.getTenSanPham(), sp.getKichThuoc(),
					sp.getMauSac(), sp.getDonGia(), sp.getGiamGia(), ct.getSoLuong(), tongtien });
		}
		tinhToan();
	}

	public void themHDvaoBang(HoaDon hd) {
		entity.Staff kh = hoaDonService.timKiementity.StafftheoMa(hd.getentity.Staff().getMaentity.Staff());
		String maHD = hd.getMaHoaDon();
		Date ngayDat = hd.getNgayDat();
		List<ChiTietHoaDon> list = hoaDonService.getCT_HoadonTheoHoaDon(hd.getMaHoaDon());
		double thanhTien = 0;
		for (ChiTietHoaDon ct : list) {
			Phong sp = hoaDonService.laySanPhamTheoMa(ct.getSanPham().getMaSanPham());
			ct.setSanPham(sp);
			thanhTien = thanhTien + ct.tinhTongTien();
			// System.out.println(ct.tinhTongTien());
		}
		double giamGia = thanhTien * hd.getGiamGia() / 100;
		thanhTien = thanhTien * 1.1 - giamGia;

		String tinhTrang = hd.isTrangThai() ? "Đã thanh toán" : "Chưa thanh toán";
		dataModelHoaDon.addRow(new Object[] { hd.getMaHoaDon(), kh.getMaentity.Staff(), kh.getSoDienThoai(), ngayDat,
				thanhTien, tinhTrang });
	}

	public void loadTableHoaDon(List<HoaDon> list) {
		dataModelHoaDon.setRowCount(0);
		String tinhTrang = (String) cboTinhTrangHD.getSelectedItem();
		boolean flag = tinhTrang.equals("Đã thanh toán") ? true : false;
		String ngay = (String) cboNgay.getSelectedItem();
		boolean flagNgay = ngay.equals("Hôm nay") ? true : false;
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String homNay = sm.format(ngayHomNay);

		for (HoaDon hd : list) {
			if (flag == true) {
				if (hd.isTrangThai()) {
					if (flagNgay == true) {
						String ngayHD = sm.format(hd.getNgayDat());
						if (ngayHD.equals(homNay)) {
							themHDvaoBang(hd);
						}
					} else {
						themHDvaoBang(hd);
					}
				}
			} else {
				if (!hd.isTrangThai()) {
					themHDvaoBang(hd);
				}
			}
		}
	}

	public void tinhToan() {
		int index = tableDonHang.getRowCount();
		double tongTien = 0;
		double tong = 0;
		double giamSP = 0;
		double giamHD = 0;
		double vat = 0;

		for (int i = 0; i < index; i++) {
			tongTien = tongTien + Double.parseDouble(tableDonHang.getValueAt(i, 7).toString());
			tong = tong + Double.parseDouble(tableDonHang.getValueAt(i, 4).toString())
					* Double.parseDouble(tableDonHang.getValueAt(i, 6).toString());
		}
		giamSP = tong - tongTien;
		if (txtPhanTramGiam.getText().equals("")) {
			giamHD = 0;
		} else {
			giamHD = (double) Math.round((Double.parseDouble(txtPhanTramGiam.getText()) * tongTien * 10) / 10) / 100;
		}
		vat = (double) Math.round(tongTien * 0.1 * 10) / 10;

		txtGiamSP.setText(Double.toString(giamSP));
		txtTongTien.setText(Double.toString(tongTien));
		txtVAT.setText(Double.toString(vat));
		txtSoTienGiam.setText(Double.toString(giamHD));
		txtThanhTien.setText(Double.toString((double) Math.round((tongTien + vat - giamHD) * 10) / 10));
		tinhTienThua();
	}

	public void tinhTienThua() {
		if (!txtSoTienKhachDua.getText().equals("")) {
			double tienKhachDua = Double.parseDouble(txtSoTienKhachDua.getText().toString().trim());
			double thanhTien = Double.parseDouble(txtThanhTien.getText().toString().trim());
			// tienKhachDua = (double) Math.round(tienKhachDua * 100) / 100;
			// thanhTien = (double) Math.round(thanhTien * 100) / 100;
			if (tienKhachDua < thanhTien) {
				txtSoTienKhachDua.setForeground(Color.RED);
				txtTienThua.setText("");
			} else {
				double tienThua = 0;
				tienThua = tienKhachDua - thanhTien;
				txtSoTienKhachDua.setForeground(Color.BLUE);
				txtTienThua.setText(Double.toString(tienThua * 1));
				// System.out.println("tienthua: " + tienThua);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Object o = e.getSource();
		if (o.equals(txtSoTienKhachDua)) {
			if (e.getKeyChar() >= 'a' & e.getKeyChar() <= 'z') {
				String s = txtSoTienKhachDua.getText();
				s = s.substring(0, s.length() - 1);
				txtSoTienKhachDua.setText(s);
			}
			tinhToan();
		} else if (o.equals(txtSoLuong)) {
			if (o.equals(txtSoLuong)) {
				if (e.getKeyChar() >= 'a' & e.getKeyChar() <= 'z') {
					String s = txtSoLuong.getText();
					s = s.substring(0, s.length() - 1);
					txtSoLuong.setText(s);
				}
			}
			if (!txtSoLuong.getText().equals("")) {
				btnThemVaoCT_Don.setEnabled(true);
			}
		} else if (o.equals(txtPhanTramGiam)) {
			if (e.getKeyChar() >= 'a' & e.getKeyChar() <= 'z') {
				String s = txtPhanTramGiam.getText();
				s = s.substring(0, s.length() - 1);
				txtPhanTramGiam.setText(s);
			} else {
				String s = txtPhanTramGiam.getText();
				if (s.length() > 2) {
					s = s.substring(0, s.length() - 1);
					txtPhanTramGiam.setText(s);
				}
			}
			tinhToan();
		}

	}

	private String maTuDong() {
		String res = "HD";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddHHmmss");
		LocalDateTime ngayNhap = LocalDateTime.now();
		res = res.toUpperCase() + formatter.format(ngayNhap);
		return res;
	}

	private boolean updateSL(Phong spchon, int soluong) {
		for (Phong sp : allSanPham) {
			if (sp.getMaSanPham().equals(spchon.getMaSanPham())) {
				sp.setSoLuong(soluong);
				return true;
			}
		}
		return false;
	}

	private Phong findSP(String maTim) {
		for (Phong sp : allSanPham) {
			if (sp.getMaSanPham().equals(maTim)) {
				return sp;
			}
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLocHDtheoSDT)) {
			List<HoaDon> locHoaDon = new ArrayList<>();
			for (HoaDon hd : allHoaDon) {
				entity.Staff kh = hoaDonService.timKiementity.StafftheoMa(hd.getentity.Staff().getMaentity.Staff());
				// System.out.println(kh);
				if (kh.getSoDienThoai().contains(txtSDT.getText())) {
					locHoaDon.add(hd);
				}
			}
			loadTableHoaDon(locHoaDon);
			txtSDT.setText("");
		} else if (o.equals(btnXoaRong)) {
			int input = JOptionPane.showConfirmDialog(btnXoaRong, "Bạn có muốn xoá rỗng không?", "Lựa chọn của bạn",
					JOptionPane.YES_NO_OPTION);
			if (input == 0) {
				xoaRong();
				cboTinhTrangHD.setSelectedIndex(0);
				xuLyNutThanhToan();
			}
		} else if (o.equals(btnLamMoi)) {
			txtMaSanPham.setText("");
			cboKichThuoc.setSelectedIndex(0);
			loadDuLieuSanPham(allSanPham);
		} else if (o.equals(btnTimKiemSP)) {
			List<Phong> ls = new ArrayList<>();
			for (Phong sp : allSanPham) {
				if (sp.getMaSanPham().contains(txtMaSanPham.getText())
						|| sp.getTenSanPham().contains(txtMaSanPham.getText())) {
					ls.add(sp);
				}
			}
			loadDuLieuSanPham(ls);
		} else if (o.equals(btnThemVaoCT_Don)) {
			if (!txtSoLuong.isEditable()) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm!");
			} else if (txtSoLuong.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng khách mua!");
			} else if (Integer.parseInt(txtSoLuong.getText().trim()) <= 0) {
				JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
			} else if (!(txtSoLuong.getText().trim().length() > 0 && txtSoLuong.getText().trim().length() < 50
					&& txtSoLuong.getText().trim().matches("[\\d.]+"))) {
				JOptionPane.showMessageDialog(this, "Số lượng mua chỉ nhập số");
			} else if (Integer.parseInt(txtSoLuong.getText().trim()) > sanphamChon.getSoLuong()) {
				JOptionPane.showMessageDialog(this, "Số lượng bán phải nhỏ hơn số lượng tồn!");
			} else {
				String maHoaDon = txtMaHD.getText().trim();
				if (!maHoaDon.equals("")) {
					hoadonChon = hoaDonService.getHoaDon(maHoaDon);
					if (hoadonChon.isTrangThai()) {
						JOptionPane.showMessageDialog(this, "Hoá đơn đã thanh toán không thể thêm!");
						xoaRong();
					} else {
						int soluong = Integer.parseInt(txtSoLuong.getText().trim());
						boolean dk = false;
						int row = 0;
						int rows = tableDonHang.getRowCount();
						if (rows == 0) {
							hoaDonService.themCT_HoaDon(hoadonChon, sanphamChon, soluong);
							hoaDonService.capNhatSLSanPham(sanphamChon.getMaSanPham(),
									sanphamChon.getSoLuong() - soluong);
							allSanPham = hoaDonService.getTatCaSanPham();
							ct_HoaDontheoHD = hoaDonService.getCT_HoadonTheoHoaDon(hoadonChon.getMaHoaDon());
							loadDuLieuCT_HoaDon(hoadonChon);
							loadDuLieuSanPham(allSanPham);
						} else {
							for (int i = 0; i < rows; i++) {
								if (txtSanPham.getText().trim().equals(dataModelDonHang.getValueAt(i, 0))) {
									dk = true;
									row = i;
								}
							}
							if (dk) {
								int soluongCu = Integer.parseInt(tableDonHang.getValueAt(row, 6).toString());
								boolean flag = hoaDonService.capNhatSLCT_HoaDon(hoadonChon.getMaHoaDon(),
										sanphamChon.getMaSanPham(), soluongCu + soluong);
								hoaDonService.capNhatSLSanPham(sanphamChon.getMaSanPham(),
										sanphamChon.getSoLuong() - soluong);
								allSanPham = hoaDonService.getTatCaSanPham();
								ct_HoaDontheoHD = hoaDonService.getCT_HoadonTheoHoaDon(hoadonChon.getMaHoaDon());
								loadDuLieuCT_HoaDon(hoadonChon);
								loadDuLieuSanPham(allSanPham);
							} else {
								hoaDonService.themCT_HoaDon(hoadonChon, sanphamChon, soluong);
								hoaDonService.capNhatSLSanPham(sanphamChon.getMaSanPham(),
										sanphamChon.getSoLuong() - soluong);
								allSanPham = hoaDonService.getTatCaSanPham();
								ct_HoaDontheoHD = hoaDonService.getCT_HoadonTheoHoaDon(hoadonChon.getMaHoaDon());
								loadDuLieuCT_HoaDon(hoadonChon);
								loadDuLieuSanPham(allSanPham);
							}
						}
					}
				} else if (maHoaDon.equals("")) {
					int soluong = Integer.parseInt(txtSoLuong.getText().trim());
					boolean dk = false;
					int row = 0;
					int rows = tableDonHang.getRowCount();
					if (rows == 0) {
						Object[] obj = new Object[8];
						obj[0] = sanphamChon.getMaSanPham();
						obj[1] = sanphamChon.getTenSanPham();
						obj[2] = sanphamChon.getKichThuoc();
						obj[3] = sanphamChon.getMauSac();
						obj[4] = sanphamChon.getDonGia();
						obj[5] = sanphamChon.getGiamGia();
						obj[6] = txtSoLuong.getText().trim();
						obj[7] = sanphamChon.getDonGia() * Integer.parseInt(txtSoLuong.getText().trim())
								* (1 - sanphamChon.getGiamGia());
						dataModelDonHang.addRow(obj);
						boolean flag = updateSL(sanphamChon, sanphamChon.getSoLuong() - soluong);
						if (flag) {
							loadDuLieuSanPham(allSanPham);
						}
					} else {
						for (int i = 0; i < rows; i++) {
							if (txtSanPham.getText().trim().equals(dataModelDonHang.getValueAt(i, 0))) {
								dk = true;
								row = i;
							}
						}
						if (dk) {
							int slmoi = Integer.parseInt(txtSoLuong.getText().trim())
									+ Integer.parseInt(dataModelDonHang.getValueAt(row, 6).toString().trim());
							dataModelDonHang.setValueAt(slmoi, row, 6);
							dataModelDonHang.setValueAt(
									slmoi * Double.parseDouble(dataModelDonHang.getValueAt(row, 4).toString().trim())
											* (1 - sanphamChon.getGiamGia()),
									row, 7);
							boolean flag = updateSL(sanphamChon, sanphamChon.getSoLuong() - soluong);
							if (flag) {
								loadDuLieuSanPham(allSanPham);
							}
						} else {
							Object[] obj = new Object[8];
							obj[0] = sanphamChon.getMaSanPham();
							obj[1] = sanphamChon.getTenSanPham();
							obj[2] = sanphamChon.getKichThuoc();
							obj[3] = sanphamChon.getMauSac();
							obj[4] = sanphamChon.getDonGia();
							obj[5] = sanphamChon.getGiamGia();
							obj[6] = txtSoLuong.getText().trim();
							obj[7] = sanphamChon.getDonGia() * Integer.parseInt(txtSoLuong.getText().trim())
									* (1 - sanphamChon.getGiamGia());
							dataModelDonHang.addRow(obj);
							boolean flag = updateSL(sanphamChon, sanphamChon.getSoLuong() - soluong);
							if (flag) {
								loadDuLieuSanPham(allSanPham);
							}
						}
					}
				}
			}
			tinhToan();
			txtSanPham.setText("");
			txtSoLuong.setText("");
			txtSoLuong.setEditable(false);
			xuLyNutThanhToan();

		} else if (o.equals(btnTimKH)) {
			String noidung = txtTenOrSDT.getText().trim();
			cboTenentity.Staff.removeAllItems();
			if (noidung.equals("")) {
				JOptionPane.showMessageDialog(btnTimKH, "Vui lòng nhập dữ liệu");
			} else {
				List<entity.Staff> dskh = new ArrayList<entity.Staff>();
				dskh = hoaDonService.timKiementity.StafftheoNoiDung(noidung);
				if (dskh.size() != 0) {
					for (entity.Staff kh : dskh) {
						cboTenentity.Staff.addItem(kh.getTenentity.Staff());
					}
				} else {
					JOptionPane.showMessageDialog(btnTimKH, "Không tìm thấy!");
				}
			}
			txtTenOrSDT.setText("");
		} else if (o.equals(btnLuu)) {
			if (txtSDT_entity.Staff.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Nhập thông tin khách hàng");
				txtTenOrSDT.setFocusable(true);
			} else if (tableDonHang.getRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Chưa thêm sản phẩm!");
			} else {
				String maHD = txtMaHD.getText().trim();
				if (maHD.equals("")) {
					maHD = maTuDong();
					HoaDon hd = taoHoaDon(maHD, false);
					hoaDonService.themHoaDon(hd);
					themCT_HoaDon(hd);
					allHoaDon = hoaDonService.getAllDSHoadon(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
					loadTableHoaDon(allHoaDon);
				}
				cboTinhTrangHD.setSelectedIndex(1);
				xoaRong();
				xuLyNutThanhToan();
			}
		} else if (o.equals(btnThanhToan)) {
			HoaDon hd = hoaDonService.getHoaDon(txtMaHD.getText().trim());
			if (txtSDT_entity.Staff.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Nhập thông tin khách hàng");
				txtTenOrSDT.setFocusable(true);
			} else {
				if (!txtTienThua.getText().equals("")) {
					int input = JOptionPane.showConfirmDialog(btnThanhToan, "Đồng ý thanh toán?", "Lựa chọn của bạn",
							JOptionPane.YES_NO_OPTION);
					if (input == 0) {
						String maHD = txtMaHD.getText().trim();
						if (maHD.equals("")) {
							maHD = maTuDong();
							hd = taoHoaDon(maHD, true);
							hoaDonService.themHoaDon(hd);
							themCT_HoaDon(hd);
							JOptionPane.showMessageDialog(btnThanhToan, "Thanh toán thành công!");
						} else {
							if (txtPhanTramGiam.getText().equals("")) {
								txtPhanTramGiam.setText("0");
							}
							hoadonChon.setGiamGia(Double.parseDouble(txtPhanTramGiam.getText()));
							hoaDonService.capNhatTrangThai(hoadonChon);
						}
						allHoaDon = hoaDonService
								.getAllDSHoadon(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
						loadTableHoaDon(allHoaDon);
						List<Phong> ls = new ArrayList<>();
						ls = hoaDonService.getTatCaSanPham();
						loadDuLieuSanPham(ls);
						xoaRong();
						xuLyNutThanhToan();
					} else {
						JOptionPane.showMessageDialog(btnThanhToan, "Thanh toán không thành công!");
					}
				} else {
					JOptionPane.showMessageDialog(btnThanhToan, "Chưa nhập đủ tiền!");
				}
			}
		} else if (o.equals(btnSuaSoLuong)) {
			int index = tableDonHang.getSelectedRow();
			int soluongcu = Integer.parseInt(tableDonHang.getValueAt(index, 6).toString());
			String m = JOptionPane.showInputDialog("Nhập số lượng mới: ");
			if (!(m.length() > 0 && m.length() < 50 && m.matches("[\\d.]+"))) {
				JOptionPane.showMessageDialog(this, "Số lượng mua chỉ nhập số");
			} else if (Integer.parseInt(m) <= 0) {
				JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
			} else if (Integer.parseInt(m) > sanphamChon_DonHang.getSoLuong() + soluongcu) {
				JOptionPane.showMessageDialog(this, "Số lượng bán phải nhỏ hơn số lượng tồn!");
			} else {
				int soluongmoi = Integer.parseInt(m);
				if (txtMaHD.getText().trim().equals("")) {
					tableDonHang.setValueAt(soluongmoi, index, 6);
					updateSL(sanphamChon_DonHang, sanphamChon_DonHang.getSoLuong() + soluongcu - soluongmoi);
					loadDuLieuSanPham(allSanPham);
				} else {
					hoaDonService.capNhatSLCT_HoaDon(hoadonChon.getMaHoaDon(), sanphamChon_DonHang.getMaSanPham(),
							soluongmoi);
					hoaDonService.capNhatSLSanPham(sanphamChon_DonHang.getMaSanPham(),
							sanphamChon_DonHang.getSoLuong() + soluongcu - soluongmoi);
					allSanPham = hoaDonService.getTatCaSanPham();
					ct_HoaDontheoHD = hoaDonService.getCT_HoadonTheoHoaDon(hoadonChon.getMaHoaDon());
					loadDuLieuCT_HoaDon(hoadonChon);
					loadDuLieuSanPham(allSanPham);
				}
			}
			txtMaSPban.setText("");
			btnSuaSoLuong.setEnabled(false);
			btnXoaCT_Don.setEnabled(false);
			xuLyNutThanhToan();

		} else if (o.equals(btnXoaCT_Don)) {
			int index = tableDonHang.getSelectedRow();
			String maHD = txtMaHD.getText().trim();
			int soluongcu = Integer.parseInt(tableDonHang.getValueAt(index, 6).toString());
			if (maHD.equals("")) {
				dataModelDonHang.removeRow(index);
				updateSL(sanphamChon_DonHang, sanphamChon_DonHang.getSoLuong() + soluongcu);
				loadDuLieuSanPham(allSanPham);
			} else {
				hoaDonService.capNhatSLSanPham(sanphamChon_DonHang.getMaSanPham(),
						sanphamChon_DonHang.getSoLuong() + soluongcu);
				hoaDonService.xoaCT_HD(hoadonChon.getMaHoaDon(), sanphamChon_DonHang.getMaSanPham());
				allSanPham = hoaDonService.getTatCaSanPham();
				ct_HoaDontheoHD = hoaDonService.getCT_HoadonTheoHoaDon(hoadonChon.getMaHoaDon());
				loadDuLieuCT_HoaDon(hoadonChon);
				loadDuLieuSanPham(allSanPham);
			}
			if (tableDonHang.getRowCount() == 0) {
				tinhToan();
				txtSanPham.setText("");
				txtSoLuong.setText("");
				txtSoLuong.setEditable(false);
				xuLyNutThanhToan();
			}
			txtMaSPban.setText("");
			btnSuaSoLuong.setEnabled(false);
			btnXoaCT_Don.setEnabled(false);
			xuLyNutThanhToan();
		} else if (o.equals(btnXoaHD)) {
			int input = JOptionPane.showConfirmDialog(btnXoaRong, "Bạn có muốn xoá không?", "Lựa chọn của bạn",
					JOptionPane.YES_NO_OPTION);
			if (input == 0) {
				boolean flag = xoaHoaDon(hoadonChon);
				if (!flag) {
					JOptionPane.showMessageDialog(btnXoaHD, "Hoá đơn đã thanh toán không thể xoá!");
				} else {
					JOptionPane.showMessageDialog(btnXoaHD, "Xoá thành công!");
				}
				xoaRong();
				xuLyNutThanhToan();
			} else {
				JOptionPane.showMessageDialog(btnXoaHD, "Không xoá!");
			}

		} else if (o.equals(btnXuatBaoCao)) {
			Date homnay = new Date(ngayHomNay.getTime());
			String hoadonduocchon = hoadonChon.getMaHoaDon();
			tongTienBaoCao = thongKeDoanhThuService.tinhTongTienBanDuocTheoNgay(homnay,
					Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim(), hoadonduocchon);
			XuatHoaDon(homnay, tongTienBaoCao, hoadonduocchon);
			// System.out.println(homnay);
			// System.out.println(Double.toString(tongTienBaoCao));
		} else if (o.equals(btnThemKH)) {
			Form_Man_Hinh_Chinh.tabbedPane.remove(Form_Man_Hinh_Chinh.tabbedPane.getSelectedComponent());
			Form_Man_Hinh_Chinh.tabbedPane.add(Form_Khach_Hang.contentPane);
			Form_Man_Hinh_Chinh.tabbedPane.setSelectedComponent(Form_Khach_Hang.contentPane);
			Form_Man_Hinh_Chinh.tabbedPane.setVisible(true);
		}
	}

	public HoaDon taoHoaDon(String maHD, Boolean flag) {
		HoaDon hd = new HoaDon();
		NhanVien nv = new NhanVien(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
		Date homnay = new Date(ngayHomNay.getTime());
		hd.setMaHoaDon(maHD);
		hd.setentity.Staff(hoaDonService.timKiementity.StafftheoSDT(txtSDT_entity.Staff.getText().trim()));
		hd.setNhanVien(nv);
		hd.setNgayDat(homnay);
		hd.setTrangThai(flag);
		if (flag) {
			if (txtPhanTramGiam.getText().equals("")) {
				txtPhanTramGiam.setText("0");
			}
			hd.setGiamGia(Double.parseDouble(txtPhanTramGiam.getText()));
		}
		return hd;
	}

	public void xoaRong() {
		txtMaHD.setText("");
		cboTenentity.Staff.removeAllItems();
		txtSDT_entity.Staff.setText("");
		txtMaHD.setToolTipText("Mã tự động");
		dataModelDonHang.setRowCount(0);
		txtPhanTramGiam.setText("");
		txtSoTienKhachDua.setText("");
		txtTienThua.setText("");
		txtMaSPban.setText("");
		txtVAT.setText("");
		txtTongTien.setText("");
		txtThanhTien.setText("");
		txtTenOrSDT.setText("");
		btnSuaSoLuong.setEnabled(false);
		btnXoaCT_Don.setEnabled(false);
		txtSoTienGiam.setText("");
		allSanPham = hoaDonService.getTatCaSanPham();
		txtGiamSP.setText("");
		loadDuLieuSanPham(allSanPham);
		btnXoaHD.setEnabled(false);
		txtMaSanPham.setText("");
		txtSanPham.setText("");
		txtSoLuong.setText("");
		txtSoLuong.setEditable(false);
		cboKichThuoc.setSelectedIndex(0);
		txtSDT.setText("");
	}

	public void themCT_HoaDon(HoaDon hd) {
		int count = tableDonHang.getRowCount();
		for (int i = 0; i < count; i++) {
			Phong sp = new Phong();
			sp = hoaDonService.laySanPhamTheoMa(tableDonHang.getValueAt(i, 0).toString());
			int soluong = Integer.parseInt(tableDonHang.getValueAt(i, 6).toString());
			hoaDonService.themCT_HoaDon(hd, sp, soluong);
			hoaDonService.capNhatSLSanPham(sp.getMaSanPham(), sp.getSoLuong() - soluong);
		}
	}

	public boolean xoaHoaDon(HoaDon hd) {
		Boolean kq = false;
		if (hd.isTrangThai() == false) {
			List<ChiTietHoaDon> list = new ArrayList<>();
			list = hoaDonService.getCT_HoadonTheoHoaDon(hd.getMaHoaDon());
			for (ChiTietHoaDon ct : list) {
				Phong sp = hoaDonService.laySanPhamTheoMa(ct.getSanPham().getMaSanPham());
				kq = hoaDonService.capNhatSLSanPham(sp.getMaSanPham(),
						sp.getSoLuong() + ct.getSoLuong());
				kq = hoaDonService.xoaCT_HD(hd.getMaHoaDon(), sp.getMaSanPham());
			}
			kq = hoaDonService.xoaHD(hd.getMaHoaDon());
			allHoaDon = hoaDonService.getAllDSHoadon(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
			loadTableHoaDon(allHoaDon);
		}
		return kq;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(tableHoaDon)) {
			int index = tableHoaDon.getSelectedRow();
			String maHoaDon = dataModelHoaDon.getValueAt(index, 0).toString();
			try {
				cboTenentity.Staff.removeAllItems();
				hoadonChon = hoaDonService.getHoaDon(maHoaDon);
				txtMaHD.setText(maHoaDon + "");
				String soDT = dataModelHoaDon.getValueAt(index, 2).toString();
				entity.Staff kh = hoaDonService.timKiementity.StafftheoSDT(soDT);
				String ngayLap = tableHoaDon.getValueAt(index, 3).toString();
				cboTenentity.Staff.addItem(kh.getTenentity.Staff());
				txtSDT_entity.Staff.setText(soDT);
				txtNgayLap.setText(ngayLap);
				double giam = hoadonChon.getGiamGia();
				// System.out.println(giam);
				txtPhanTramGiam.setText(Double.toString(hoadonChon.getGiamGia()));
				txtMaSPban.setText("");
				loadDuLieuCT_HoaDon(hoadonChon);
				tinhToan();
				xuLyNutThanhToan();
				btnXoaHD.setEnabled(true);
			} catch (Exception e2) {
				System.out.println("error mouse clicked");
				e2.printStackTrace();
			}
		} else if (o.equals(tableSanPham)) {
			int index = tableSanPham.getSelectedRow();
			sanphamChon = findSP(dataModelSanPham.getValueAt(index, 1).toString());
			txtSanPham.setText(sanphamChon.getMaSanPham());
			txtSoLuong.setEditable(true);
		} else if (o.equals(tableDonHang)) {
			int index = tableDonHang.getSelectedRow();
			String maSP = dataModelDonHang.getValueAt(index, 0).toString();
			sanphamChon_DonHang = findSP(maSP);
			if (txtMaHD.getText().equals("")) {
				btnSuaSoLuong.setEnabled(true);
				btnXoaCT_Don.setEnabled(true);
				txtMaSPban.setText(maSP);
			} else if (!hoadonChon.isTrangThai()) {
				btnSuaSoLuong.setEnabled(true);
				btnXoaCT_Don.setEnabled(true);
				txtMaSPban.setText(maSP);
			}

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void xuLyNutThanhToan() {
		if (txtMaHD.getText().equals("")) {
			if (tableDonHang.getRowCount() == 0) {
				txtSoTienKhachDua.setEditable(false);
				btnThanhToan.setEnabled(false);
				txtPhanTramGiam.setEditable(false);
				btnLuu.setEnabled(false);
			} else {
				txtSoTienKhachDua.setEditable(true);
				btnThanhToan.setEnabled(true);
				txtPhanTramGiam.setEditable(true);
				btnLuu.setEnabled(true);
			}
		} else {
			if (hoadonChon.isTrangThai()) {
				txtPhanTramGiam.setEditable(false);
				txtSoTienKhachDua.setEditable(false);
				btnThanhToan.setEnabled(false);
				btnLuu.setEnabled(false);
			} else {
				if (tableDonHang.getRowCount() == 0) {
					txtSoTienKhachDua.setEditable(false);
					btnThanhToan.setEnabled(false);
					txtPhanTramGiam.setEditable(false);
					btnLuu.setEnabled(false);
				} else {
					txtSoTienKhachDua.setEditable(true);
					btnThanhToan.setEnabled(true);
					txtPhanTramGiam.setEditable(true);
					btnLuu.setEnabled(false);
				}
			}
		}
	}

	private String taoSoHoaDonTuDong() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime ngayNhap = LocalDateTime.now();
		String res = formatter.format(ngayNhap);
		return res;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object o = e.getSource();
		if (o.equals(cboTenentity.Staff)) {
			String tenKH = (String) cboTenentity.Staff.getSelectedItem();
			// System.out.println("tenKH: " + tenKH);
			entity.Staff kh = hoaDonService.timKiementity.StafftheoTen(tenKH);
			txtSDT_entity.Staff.setText(kh.getSoDienThoai());
			if (!txtMaHD.getText().equals("")) {
				if (!hoadonChon.isTrangThai()) {
					hoadonChon.setentity.Staff(kh);
				}
			}
		} else if (o.equals(cboTinhTrangHD)) {
			loadTableHoaDon(allHoaDon);
		} else if (o.equals(cboNgay)) {
			loadTableHoaDon(allHoaDon);
		}
	}
}
