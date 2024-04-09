package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class Form_Man_Hinh_Chinh extends JFrame implements ActionListener, MenuListener {
	public static JPanel contentPane;
	private Form_Khach_Hang form_Khach_Hang = new Form_Khach_Hang();
	public Form_Nhan_Vien form_Nhan_Vien = new Form_Nhan_Vien();
	private Form_Quan_Ly_Tai_Khoan form_Quan_Ly_Tai_Khoan = new Form_Quan_Ly_Tai_Khoan();
	private Form_Dang_Nhap form_Dang_Nhap = new Form_Dang_Nhap();
	private Form_San_Pham form_San_Pham = new Form_San_Pham();
	public Form_Thong_Ke_Doanh_Thu form_Thong_Ke_Doanh_Thu = new Form_Thong_Ke_Doanh_Thu();
	public Form_Thong_ke_San_Pham_Ban_Chay form_Thong_ke_San_Pham_Ban_Chay = new Form_Thong_ke_San_Pham_Ban_Chay();
	private Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien = new Form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien();
	private Form_Trang_Chu form_Trang_Chu = new Form_Trang_Chu();
	private Form_HoaDon form_HoaDon = new Form_HoaDon();
	private Form_HDSD form_HDSD = new Form_HDSD();
	public static JTabbedPane tabbedPane;
	public static JMenuItem mntmQuanLyTaiKhoan;
	private JMenuItem mntmDangXuat;
	public static JMenu mnentity.Staff;
	public static JMenu mnNhanVien;
	public static JMenuItem mntmThongKeDoanhThu;
	public static JMenuItem mntmThongKeSanPhamBanChay;
	public static JMenuItem mntmThongKeentity.Staff;
	public static JMenuItem mntmThongKeHoaDonLapTheoNhanVien;
	public static JMenu mnSanPham;
	public static JMenu mnBanHang;
	public static JMenu mnTrangChu;
	public static JMenu mnHuongDanSuDung, mnThongKe, mnTaiKhoan;
	private JMenuBar menuBarBanHang, menuBarTrangChu, menuBarSanPham, menuBarTaiKhoan, menuBarentity.Staff,menuBarThongKe,menuBarNhanVien,menuHuongDanSuDung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Man_Hinh_Chinh frame = new Form_Man_Hinh_Chinh();
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
	public Form_Man_Hinh_Chinh() {
		// DAO
		// try {
		// ConnectDataBase.getInstance().connect();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		setBackground(Color.WHITE);
		// getContentPane().setForeground(Color.GREEN);
		// getContentPane().setBackground(Color.WHITE);
		// getContentPane().setLayout(null);
		setTitle("THE SKY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		// setSize(869, 427);
		setBounds(100, 100, 450, 300);
		setSize(1380, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// contentPane.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setBounds(0, 0, 1364, 50);
		toolBar.setBackground(Color.WHITE);
		toolBar.setFont(new Font("Arial", Font.PLAIN, 16));
		toolBar.setFloatable(false);
		contentPane.add(toolBar);

		menuBarTrangChu = new JMenuBar();
		menuBarTrangChu.setBackground(Color.WHITE);
		toolBar.add(menuBarTrangChu);

		mnTrangChu = new JMenu("<html><p style='text-align:center; width: 160;height: 26'>THE SKY</p></html>");
		mnTrangChu.setBackground(Color.WHITE);
		// mnTrangChu.setPreferredSize(new Dimension(160,
		// mnTrangChu.getPreferredSize().height));
		mnTrangChu.setForeground(new Color(0, 0, 255));
		mnTrangChu.setFont(new Font("Arial", Font.BOLD, 16));
		menuBarTrangChu.add(mnTrangChu);

		menuBarBanHang = new JMenuBar();
		menuBarBanHang.setBackground(Color.WHITE);
		toolBar.add(menuBarBanHang);

		mnBanHang = new JMenu("Bán Hàng");
		mnBanHang.setBackground(Color.WHITE);
		mnBanHang.setPreferredSize(new Dimension(160, mnBanHang.getPreferredSize().height));
		Icon iconBanHang = new ImageIcon("./HinhAnh/icon/iconBanHang.png");
		mnBanHang.setFont(new Font("Arial", Font.BOLD, 16));
		mnBanHang.setIcon(new ImageIcon("./HinhAnh/icon/iconBanHang-removebg-preview.png"));
		menuBarBanHang.add(mnBanHang);

		menuBarSanPham = new JMenuBar();
		menuBarSanPham.setBackground(Color.WHITE);
		toolBar.add(menuBarSanPham);

		mnSanPham = new JMenu("Sản Phẩm");
		mnSanPham.setBackground(Color.WHITE);
		mnSanPham.setPreferredSize(new Dimension(160, mnSanPham.getPreferredSize().height));
		mnSanPham.setIcon(new ImageIcon("./HinhAnh/icon/iconSanPham.png"));
		mnSanPham.setFont(new Font("Arial", Font.BOLD, 16));
		menuBarSanPham.add(mnSanPham);

		menuBarThongKe = new JMenuBar();
		menuBarThongKe.setBackground(Color.WHITE);
		toolBar.add(menuBarThongKe);

		mnThongKe = new JMenu("Thống Kê");
		mnThongKe.setBackground(Color.WHITE);
		mnThongKe.setPreferredSize(new Dimension(160, mnThongKe.getPreferredSize().height));
		mnThongKe.setIcon(new ImageIcon("./HinhAnh/icon/iconThongKe.png"));
		mnThongKe.setFont(new Font("Arial", Font.BOLD, 16));
		menuBarThongKe.add(mnThongKe);

		mntmThongKeDoanhThu = new JMenuItem("Thống kê doanh thu");
		mntmThongKeDoanhThu.setBackground(Color.WHITE);
		mntmThongKeDoanhThu.setIcon(new ImageIcon("./HinhAnh/icon/growth.png"));
		mntmThongKeDoanhThu.setFont(new Font("Arial", Font.BOLD, 14));
		mnThongKe.add(mntmThongKeDoanhThu);

		mntmThongKeSanPhamBanChay = new JMenuItem("Thống kê sản phẩm bán chạy");
		mntmThongKeSanPhamBanChay.setBackground(Color.WHITE);
		mntmThongKeSanPhamBanChay.setIcon(new ImageIcon("./HinhAnh/icon/sell.png"));
		mntmThongKeSanPhamBanChay.setFont(new Font("Arial", Font.BOLD, 14));
		mnThongKe.add(mntmThongKeSanPhamBanChay);

		// mntmThongKeentity.Staff = new JMenuItem("Thống kê khách hàng");
		// mntmThongKeentity.Staff.setIcon(new ImageIcon("./HinhAnh/icon/diagram.png"));
		// mntmThongKeentity.Staff.setBackground(new Color(240, 240, 240));
		// mntmThongKeentity.Staff.setForeground(new Color(0, 0, 0));
		// mntmThongKeentity.Staff.setSelected(false);
		// mntmThongKeentity.Staff.setFont(new Font("Arial", Font.BOLD, 14));
		// mntmThongKeentity.Staff.setEnabled(true);
		// mnThongKe.add(mntmThongKeentity.Staff);

		mntmThongKeHoaDonLapTheoNhanVien = new JMenuItem("Thống kê hóa đơn lập theo nhân viên");
		mntmThongKeHoaDonLapTheoNhanVien.setBackground(Color.WHITE);
		mntmThongKeHoaDonLapTheoNhanVien.setIcon(new ImageIcon("./HinhAnh/icon/bill.png"));
		mntmThongKeHoaDonLapTheoNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		mnThongKe.add(mntmThongKeHoaDonLapTheoNhanVien);

		menuBarNhanVien = new JMenuBar();
		menuBarNhanVien.setBackground(Color.WHITE);
		toolBar.add(menuBarNhanVien);

		mnNhanVien = new JMenu("Nhân Viên");
		mnNhanVien.setBackground(Color.WHITE);
		mnNhanVien.setPreferredSize(new Dimension(160, mnNhanVien.getPreferredSize().height));
		mnNhanVien.setIcon(new ImageIcon("./HinhAnh/icon/iconNhanVien.png"));
		mnNhanVien.setFont(new Font("Arial", Font.BOLD, 16));
		menuBarNhanVien.add(mnNhanVien);

		menuBarentity.Staff = new JMenuBar();
		menuBarentity.Staff.setBackground(Color.WHITE);
		toolBar.add(menuBarentity.Staff);

		mnentity.Staff = new JMenu("Khách hàng");
		mnentity.Staff.setBackground(Color.WHITE);
		mnentity.Staff.setPreferredSize(new Dimension(160, mnentity.Staff.getPreferredSize().height));
		mnentity.Staff.setIcon(new ImageIcon("./HinhAnh/icon/customer.png"));
		mnentity.Staff.setFont(new Font("Arial", Font.BOLD, 16));
		menuBarentity.Staff.add(mnentity.Staff);

		menuBarTaiKhoan = new JMenuBar();
		menuBarTaiKhoan.setBackground(Color.WHITE);
		toolBar.add(menuBarTaiKhoan);

		mnTaiKhoan = new JMenu("Tài Khoản");
		mnTaiKhoan.setBackground(Color.WHITE);
		mnTaiKhoan.setPreferredSize(new Dimension(160, mnTaiKhoan.getPreferredSize().height));
		mnTaiKhoan.setIcon(new ImageIcon("./HinhAnh/icon/account-removebg-preview.png"));
		mnTaiKhoan.setFont(new Font("Arial", Font.BOLD, 16));
		menuBarTaiKhoan.add(mnTaiKhoan);

		mntmQuanLyTaiKhoan = new JMenuItem("Quản lý tài khoản");
		mntmQuanLyTaiKhoan.setBackground(Color.WHITE);
		mntmQuanLyTaiKhoan.setIcon(new ImageIcon("./HinhAnh/icon/account-manager.png"));
		mntmQuanLyTaiKhoan.setFont(new Font("Arial", Font.BOLD, 14));
		mnTaiKhoan.add(mntmQuanLyTaiKhoan);

		mntmDangXuat = new JMenuItem("Đăng xuất");
		mntmDangXuat.setBackground(Color.WHITE);
		mntmDangXuat.setIcon(new ImageIcon("./HinhAnh/icon/logout.png"));
		mntmDangXuat.setFont(new Font("Arial", Font.BOLD, 14));
		mnTaiKhoan.add(mntmDangXuat);

		menuHuongDanSuDung = new JMenuBar();
		menuHuongDanSuDung.setBackground(Color.WHITE);
		toolBar.add(menuHuongDanSuDung);

		mnHuongDanSuDung = new JMenu("Hướng dẫn sử dụng");
		mnHuongDanSuDung.setBackground(Color.WHITE);
		mnHuongDanSuDung.setPreferredSize(new Dimension(240, mnHuongDanSuDung.getPreferredSize().height));
		mnHuongDanSuDung.setIcon(new ImageIcon("./HinhAnh/icon/information.png"));
		mnHuongDanSuDung.setFont(new Font("Arial", Font.BOLD, 16));
		menuHuongDanSuDung.add(mnHuongDanSuDung);

		tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 50, 1364, 780);
		contentPane.add(tabbedPane);
		tabbedPane.setVisible(false);
		tabbedPane.remove(tabbedPane.getSelectedComponent());
		tabbedPane.add(form_Trang_Chu.contentPane);
		tabbedPane.setSelectedComponent(form_Trang_Chu.contentPane);
		tabbedPane.setVisible(true);

		mntmQuanLyTaiKhoan.addActionListener(this);
		mntmDangXuat.addActionListener(this);
		mnentity.Staff.addMenuListener(this);
		mnNhanVien.addMenuListener(this);
		mnSanPham.addMenuListener(this);
		mntmThongKeDoanhThu.addActionListener(this);
		mntmThongKeSanPhamBanChay.addActionListener(this);
		mnBanHang.addMenuListener(this);
		mntmThongKeHoaDonLapTheoNhanVien.addActionListener(this);
		mnTrangChu.addMenuListener(this);
		mnHuongDanSuDung.addMenuListener(this);
		mnThongKe.addMenuListener(this);
		mnTaiKhoan.addMenuListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(mntmQuanLyTaiKhoan)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Quan_Ly_Tai_Khoan.contentPane);
			tabbedPane.setVisible(true);
		} else if (o.equals(mntmDangXuat)) {
			this.setVisible(false);
			form_Dang_Nhap.setVisible(true);
		} else if (o.equals(mntmThongKeDoanhThu)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Thong_Ke_Doanh_Thu.contentPane);
			tabbedPane.setVisible(true);
		} else if (o.equals(mntmThongKeSanPhamBanChay)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Thong_ke_San_Pham_Ban_Chay.contentPane);
			tabbedPane.setVisible(true);
		} else if (o.equals(mntmThongKeHoaDonLapTheoNhanVien)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Thong_Ke_Hoa_Don_Lap_Theo_Nhan_Vien.contentPane);
			tabbedPane.setVisible(true);
		}

	}

	public void menuSelected(MenuEvent e) {
		Object o = e.getSource();
		if (o.equals(mnentity.Staff)) {
			int r = 171;
			int g = 219;
			int b = 227;
			Color color = new Color(r, g, b);
			menuBarentity.Staff.setBackground(color);
			menuBarBanHang.setBackground(Color.WHITE);
			menuBarTrangChu.setBackground(Color.WHITE);
			menuBarNhanVien.setBackground(Color.WHITE);
			menuBarSanPham.setBackground(Color.WHITE);
			menuBarTaiKhoan.setBackground(Color.WHITE);
			menuBarThongKe.setBackground(Color.WHITE);
			menuHuongDanSuDung.setBackground(Color.WHITE);

			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Khach_Hang.contentPane);
			tabbedPane.setSelectedComponent(form_Khach_Hang.contentPane);
			tabbedPane.setVisible(true);
		} else if (o.equals(mnNhanVien)) {
			int r = 171;
			int g = 219;
			int b = 227;
			Color color = new Color(r, g, b);
			menuBarNhanVien.setBackground(color);
			menuBarBanHang.setBackground(Color.WHITE);
			menuBarTrangChu.setBackground(Color.WHITE);
			menuBarentity.Staff.setBackground(Color.WHITE);
			menuBarSanPham.setBackground(Color.WHITE);
			menuBarTaiKhoan.setBackground(Color.WHITE);
			menuBarThongKe.setBackground(Color.WHITE);
			menuHuongDanSuDung.setBackground(Color.WHITE);

			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Nhan_Vien.contentPane);
			tabbedPane.setSelectedComponent(form_Nhan_Vien.contentPane);
			tabbedPane.setVisible(true);
		} else if (o.equals(mnSanPham)) {
			int r = 171;
			int g = 219;
			int b = 227;
			Color color = new Color(r, g, b);
			menuBarSanPham.setBackground(color);
			menuBarBanHang.setBackground(Color.WHITE);
			menuBarTrangChu.setBackground(Color.WHITE);
			menuBarentity.Staff.setBackground(Color.WHITE);
			menuBarNhanVien.setBackground(Color.WHITE);
			menuBarTaiKhoan.setBackground(Color.WHITE);
			menuBarThongKe.setBackground(Color.WHITE);
			menuHuongDanSuDung.setBackground(Color.WHITE);

			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_San_Pham.contentPane);
			tabbedPane.setSelectedComponent(form_San_Pham.contentPane);
			tabbedPane.setVisible(true);
		} else if (o.equals(mnBanHang)) {
			int r = 171;
			int g = 219;
			int b = 227;
			Color color = new Color(r, g, b);
			menuBarBanHang.setBackground(color);
			menuBarTrangChu.setBackground(Color.WHITE);
			menuBarentity.Staff.setBackground(Color.WHITE);
			menuBarNhanVien.setBackground(Color.WHITE);
			menuBarSanPham.setBackground(Color.WHITE);
			menuBarTaiKhoan.setBackground(Color.WHITE);
			menuBarThongKe.setBackground(Color.WHITE);
			menuHuongDanSuDung.setBackground(Color.WHITE);

			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_HoaDon.contentPane);
			tabbedPane.setSelectedComponent(form_HoaDon.contentPane);
			tabbedPane.setVisible(true);
		} else if (o.equals(mnTrangChu)) {
			int r = 171;
			int g = 219;
			int b = 227;
			Color color = new Color(r, g, b);
			menuBarTrangChu.setBackground(color);
			menuBarBanHang.setBackground(Color.WHITE);
			menuBarentity.Staff.setBackground(Color.WHITE);
			menuBarNhanVien.setBackground(Color.WHITE);
			menuBarSanPham.setBackground(Color.WHITE);
			menuBarTaiKhoan.setBackground(Color.WHITE);
			menuBarThongKe.setBackground(Color.WHITE);
			menuHuongDanSuDung.setBackground(Color.WHITE);

			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_Trang_Chu.contentPane);
			tabbedPane.setSelectedComponent(form_Trang_Chu.contentPane);
			tabbedPane.setVisible(true);
		} else if (o.equals(mnHuongDanSuDung)) {
			int r = 171;
			int g = 219;
			int b = 227;
			Color color = new Color(r, g, b);
			menuHuongDanSuDung.setBackground(color);
			menuBarBanHang.setBackground(Color.WHITE);
			menuBarentity.Staff.setBackground(Color.WHITE);
			menuBarNhanVien.setBackground(Color.WHITE);
			menuBarSanPham.setBackground(Color.WHITE);
			menuBarTaiKhoan.setBackground(Color.WHITE);
			menuBarThongKe.setBackground(Color.WHITE);
			menuBarTrangChu.setBackground(Color.WHITE);

			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(form_HDSD.contentPane);
			tabbedPane.setSelectedComponent(form_HDSD.contentPane);
			tabbedPane.setVisible(true);
		} else if (o.equals(mnThongKe)) {
			int r = 171;
			int g = 219;
			int b = 227;
			Color color = new Color(r, g, b);
			menuBarThongKe.setBackground(color);
			menuBarBanHang.setBackground(Color.WHITE);
			menuBarentity.Staff.setBackground(Color.WHITE);
			menuBarNhanVien.setBackground(Color.WHITE);
			menuBarSanPham.setBackground(Color.WHITE);
			menuBarTaiKhoan.setBackground(Color.WHITE);
			menuHuongDanSuDung.setBackground(Color.WHITE);
			menuBarTrangChu.setBackground(Color.WHITE);

			// tabbedPane.remove(tabbedPane.getSelectedComponent());
			// tabbedPane.add(form_HDSD.contentPane);
			// tabbedPane.setSelectedComponent(form_HDSD.contentPane);
			// tabbedPane.setVisible(true);
		} else if (o.equals(mnTaiKhoan)) {
			int r = 171;
			int g = 219;
			int b = 227;
			Color color = new Color(r, g, b);
			menuBarTaiKhoan.setBackground(color);
			menuBarBanHang.setBackground(Color.WHITE);
			menuBarentity.Staff.setBackground(Color.WHITE);
			menuBarNhanVien.setBackground(Color.WHITE);
			menuBarSanPham.setBackground(Color.WHITE);
			menuBarThongKe.setBackground(Color.WHITE);
			menuHuongDanSuDung.setBackground(Color.WHITE);
			menuBarTrangChu.setBackground(Color.WHITE);

			// tabbedPane.remove(tabbedPane.getSelectedComponent());
			// tabbedPane.add(form_HDSD.contentPane);
			// tabbedPane.setSelectedComponent(form_HDSD.contentPane);
			// tabbedPane.setVisible(true);
		}

	}

	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub

	}

}
