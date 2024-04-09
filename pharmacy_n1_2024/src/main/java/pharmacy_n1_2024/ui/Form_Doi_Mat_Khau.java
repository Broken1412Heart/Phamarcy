package ui;

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

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Form_Doi_Mat_Khau extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4988454772471512347L;
	private JPanel contentPane;
	private static JTextField textMaNhanVien;
	private JPasswordField pwdMatKhauCu;
	private JButton btnDoiMatKhau;

	private TaiKhoanService taiKhoanService = new TaiKhoanServiceImpl();
	private NhanVienService nhanVienService = new NhanVienServiceImpl();
	private JPasswordField pwdMatKhauMoi;
	private JPasswordField pwdNhapLaiMatKhauMoi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Doi_Mat_Khau frame = new Form_Doi_Mat_Khau();
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
	public Form_Doi_Mat_Khau() {
		// DAO
		try {
			ConnectDataBase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBounds(10, 10, 566, 55);
		pnTieuDe.setBackground(new Color(255, 240, 245));
		contentPane.add(pnTieuDe);
		pnTieuDe.setLayout(null);

		JLabel lblNewLabel = new JLabel("ĐỔI MẬT KHẨU");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(156, 0, 259, 55);
		pnTieuDe.add(lblNewLabel);

		JPanel pnThemTK = new JPanel();
		pnThemTK.setBounds(10, 75, 566, 318);
		pnThemTK.setBackground(new Color(240, 255, 255));
		contentPane.add(pnThemTK);
		pnThemTK.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tài Khoản:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(60, 11, 103, 25);
		pnThemTK.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Mật Khẩu cũ:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(60, 65, 103, 25);
		pnThemTK.add(lblNewLabel_2);

		textMaNhanVien = new JTextField();
		textMaNhanVien.setBackground(new Color(255, 255, 255));
		textMaNhanVien.setEditable(false);
		textMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMaNhanVien.setBounds(200, 11, 300, 25);
		pnThemTK.add(textMaNhanVien);
		textMaNhanVien.setColumns(10);

		pwdMatKhauCu = new JPasswordField();
		pwdMatKhauCu.setBackground(new Color(255, 255, 255));
		pwdMatKhauCu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdMatKhauCu.setBounds(200, 65, 300, 25);
		pnThemTK.add(pwdMatKhauCu);

		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setBackground(new Color(255, 240, 245));
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDoiMatKhau.setBounds(210, 268, 141, 39);
		pnThemTK.add(btnDoiMatKhau);

		pwdMatKhauMoi = new JPasswordField();
		pwdMatKhauMoi.setBackground(new Color(255, 255, 255));
		pwdMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdMatKhauMoi.setBounds(200, 119, 300, 25);
		pnThemTK.add(pwdMatKhauMoi);

		JLabel lblNewLabel_2_1 = new JLabel("Mật Khẩu mới:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(60, 119, 103, 25);
		pnThemTK.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Nhập lại mật khẩu mới:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(10, 179, 153, 25);
		pnThemTK.add(lblNewLabel_2_1_1);

		pwdNhapLaiMatKhauMoi = new JPasswordField();
		pwdNhapLaiMatKhauMoi.setBackground(new Color(255, 255, 255));
		pwdNhapLaiMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdNhapLaiMatKhauMoi.setBounds(200, 179, 300, 25);
		pnThemTK.add(pwdNhapLaiMatKhauMoi);

		btnDoiMatKhau.addActionListener(this);
		ShowMaNhanVien();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnDoiMatKhau)) {
			doiMatKhau();
		}
	}

	public void ShowMaNhanVien() {
		try {
			textMaNhanVien.setText(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
			// Boolean themNV = Form_Nhan_Vien.themMoiNhanVien();
			// Form_Nhan_Vien.docDuLieu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doiMatKhau() {
		TaiKhoan taiKhoan1 = null;
		NhanVien nhanVien = nhanVienService
				.layThongTinNhanVienTheoMaNhanVien(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim());
		TaiKhoan taiKhoan = taiKhoanService.layThongTinTaKhoanTheoMaTaiKhoan(nhanVien.getMaNhanVien());
		String pwdMKCu = String.valueOf(pwdMatKhauCu.getPassword());
		String pwdMKMoi = String.valueOf(pwdMatKhauMoi.getPassword());
		String pwdMKNhapLai = String.valueOf(pwdNhapLaiMatKhauMoi.getPassword());
		System.out.println(taiKhoan.getMatKhau());
		if (pwdMKCu.equalsIgnoreCase(taiKhoan.getMatKhau().trim()) && pwdMKNhapLai.equalsIgnoreCase(pwdMKMoi.trim())) {
			try {
				taiKhoan1 = new TaiKhoan(pwdMKMoi);
				taiKhoan1.setNhanVien(nhanVien);
				Boolean kq = taiKhoanService.doiMatKhau(taiKhoan1);
				this.setVisible(false);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Thêm tài khoản bị lỗi !");
				e2.printStackTrace();
			}
		}
	}
}
