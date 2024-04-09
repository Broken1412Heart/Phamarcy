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

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Form_Reset_Password extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4988454772471512347L;
	private JPanel contentPane;
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
					Form_Reset_Password frame = new Form_Reset_Password();
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
	public Form_Reset_Password() {
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
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(156, 0, 259, 55);
		pnTieuDe.add(lblNewLabel);

		JPanel pnThemTK = new JPanel();
		pnThemTK.setBounds(10, 75, 566, 318);
		pnThemTK.setBackground(new Color(240, 255, 255));
		contentPane.add(pnThemTK);
		pnThemTK.setLayout(null);

		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setBackground(new Color(255, 240, 245));
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDoiMatKhau.setBounds(210, 163, 141, 39);
		pnThemTK.add(btnDoiMatKhau);

		pwdMatKhauMoi = new JPasswordField();
		pwdMatKhauMoi.setBackground(Color.WHITE);
		pwdMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdMatKhauMoi.setBounds(200, 27, 300, 25);
		pnThemTK.add(pwdMatKhauMoi);

		JLabel lblNewLabel_2_1 = new JLabel("Mật Khẩu mới:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(65, 27, 103, 25);
		pnThemTK.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Nhập lại mật khẩu mới:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(15, 96, 153, 25);
		pnThemTK.add(lblNewLabel_2_1_1);

		pwdNhapLaiMatKhauMoi = new JPasswordField();
		pwdNhapLaiMatKhauMoi.setBackground(Color.WHITE);
		pwdNhapLaiMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdNhapLaiMatKhauMoi.setBounds(200, 96, 300, 25);
		pnThemTK.add(pwdNhapLaiMatKhauMoi);

		btnDoiMatKhau.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnDoiMatKhau)) {
			if (pwdMatKhauMoi.getText().trim() == "" || pwdNhapLaiMatKhauMoi.getText().trim() == "") {
				JOptionPane.showMessageDialog(null, "Vui lòng không để trống");
			} else if (pwdMatKhauMoi.getText().trim().equals(pwdNhapLaiMatKhauMoi.getText().trim())) {
				checkDoiMk();
			}
		}
	}

	public void checkDoiMk() {
		TaiKhoan taiKhoan = null;
		NhanVien nhanVien = null;
		try {
			taiKhoan = new TaiKhoan(pwdMatKhauMoi.getText().trim());
			nhanVien = nhanVienService.layThongTinNhanVienTheoMaNhanVien(Form_Gui_Ma_Xac_Thuc.maNhanVien);
			taiKhoan.setNhanVien(nhanVien);
			Boolean kq = taiKhoanService.doiMatKhau(taiKhoan);
			JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
			Form_Dang_Nhap form_Dang_Nhap = new Form_Dang_Nhap();
			form_Dang_Nhap.setVisible(true);
			this.setVisible(false);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2);
		}
	}

}
