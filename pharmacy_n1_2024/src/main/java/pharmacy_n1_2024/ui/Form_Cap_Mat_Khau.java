package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import esp.NhanVienService;
import esp.NhanVienServiceImpl;
import esp.TaiKhoanService;
import esp.TaiKhoanServiceImpl;
import connectDB.ConnectDataBase;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Form_Cap_Mat_Khau extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4988454772471512347L;
	private JPanel contentPane;
	private static JTextField textMaNhanVien;
	private JPasswordField pwdMatKhau;
	private JButton btnThem;

	private TaiKhoanService taiKhoanService = new TaiKhoanServiceImpl();
	private NhanVienService nhanVienService = new NhanVienServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Cap_Mat_Khau frame = new Form_Cap_Mat_Khau();
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
	public Form_Cap_Mat_Khau() {
		// DAO
		try {
			ConnectDataBase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBounds(10, 10, 566, 55);
		pnTieuDe.setBackground(new Color(255, 245, 238));
		contentPane.add(pnTieuDe);
		pnTieuDe.setLayout(null);

		JLabel lblNewLabel = new JLabel("CẤP MẬT KHẨU");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(156, 0, 259, 55);
		pnTieuDe.add(lblNewLabel);

		JPanel pnThemTK = new JPanel();
		pnThemTK.setBounds(10, 75, 566, 278);
		pnThemTK.setBackground(new Color(240, 255, 255));
		contentPane.add(pnThemTK);
		pnThemTK.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tài Khoản:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(60, 70, 103, 25);
		pnThemTK.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Mật Khẩu:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(60, 150, 103, 25);
		pnThemTK.add(lblNewLabel_2);

		textMaNhanVien = new JTextField();
		textMaNhanVien.setBackground(new Color(255, 255, 255));
		textMaNhanVien.setEditable(false);
		textMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMaNhanVien.setBounds(200, 70, 300, 25);
		pnThemTK.add(textMaNhanVien);
		textMaNhanVien.setColumns(10);

		pwdMatKhau = new JPasswordField();
		pwdMatKhau.setBackground(new Color(255, 255, 255));
		pwdMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdMatKhau.setBounds(200, 150, 300, 25);
		pnThemTK.add(pwdMatKhau);

		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(255, 240, 245));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(246, 207, 105, 39);
		pnThemTK.add(btnThem);

		btnThem.addActionListener(this);

		themNhanVienAndShowMaNhanVien();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThem)) {
			try {
				String password = String.valueOf(pwdMatKhau.getPassword());
				TaiKhoan taiKhoan = new TaiKhoan(password);
				NhanVien nhanVien = nhanVienService
						.layThongTinNhanVienTheoMaNhanVien(Form_Nhan_Vien.textMaNhanVien.getText().trim());
				taiKhoan.setNhanVien(nhanVien);
				Boolean kq = taiKhoanService.themTaiKhoan(taiKhoan);
				Form_Nhan_Vien.xoaRong();
				this.setVisible(false);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Thêm tài khoản bị lỗi !");
				e2.printStackTrace();
			}
		}
	}

	public void themNhanVienAndShowMaNhanVien() {
		try {
			textMaNhanVien.setText(Form_Nhan_Vien.textMaNhanVien.getText().trim());
			// Boolean themNV = Form_Nhan_Vien.themMoiNhanVien();
			// Form_Nhan_Vien.docDuLieu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
