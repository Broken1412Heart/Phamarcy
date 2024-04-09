package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import esp.NhanVienService;
import esp.NhanVienServiceImpl;
import connectDB.ConnectDataBase;
import entity.NhanVien;
import entity.TaiKhoan;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;

public class Form_Dang_Nhap extends JFrame implements ActionListener, KeyListener, MouseListener {

	public static JPanel contentPane;
	public static JTextField txtTaiKhoan;
	public static JPasswordField pwdMatkhau;
	private JButton btnDangNhap;
	private JButton btnThoat;

	public static boolean TrangThaiDangNhapNhanVien = false;
	public static boolean TrangThaiDangNhapQuanLy = false;
	public static String usernameToGetNhanVien = "";
	private JLabel lblMatKhau;

	public static TaiKhoan taiKhoan = new TaiKhoan();
	public static NhanVien nhanVien = new NhanVien();
	private JLabel lblQuenMatKhau;

	private NhanVienService nhanVienService = new NhanVienServiceImpl();

	public static void main(String[] args) {
		Form_Dang_Nhap a = new Form_Dang_Nhap();
		a.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public Form_Dang_Nhap() {
		// DAO
		try {
			ConnectDataBase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Hinh/iconBook.png"));

		JLabel lblImgNhaNam = new JLabel();
		lblImgNhaNam.setIcon(new ImageIcon("./HinhAnh/background/CuaHangQuanAo.jpg"));
		lblImgNhaNam.setBounds(0, 0, 330, 333);
		contentPane.add(lblImgNhaNam);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.requestFocus();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTaiKhoan.setBounds(371, 105, 230, 30);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		// txtTaiKhoan.addMouseListener(new MouseAdapter() {
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// if (txtTaiKhoan.getText().equals("Nhập mã nhân viên")) {
		// txtTaiKhoan.setText("");
		// txtTaiKhoan.setForeground(new Color(0, 0, 0));
		// }
		// }
		// });

		// txtTaiKhoan.addFocusListener(new FocusAdapter() {
		// @Override
		// public void focusGained(FocusEvent e) {
		// if (txtTaiKhoan.getText().equals("Nhập mã nhân viên")) {
		// txtTaiKhoan.setText("");
		//// txtTaiKhoan.setForeground(new Color(153, 153, 153));
		// }
		// }
		// @Override
		// public void focusLost(FocusEvent e) {
		// if (txtTaiKhoan.getText().equals("")) {
		// txtTaiKhoan.setText("Nhập mã nhân viên");
		// txtTaiKhoan.setForeground(new Color(153, 153, 153));
		// }
		// }
		// });

		pwdMatkhau = new JPasswordField();
		pwdMatkhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (txtTaiKhoan.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(btnDangNhap, "Tài khoản không được  để trống");
						return;
					} else if (pwdMatkhau.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(btnDangNhap, "Mật khẩu không được  để trống");
						return;
					}

					logIn();
				}
			}
		});
		// pwdMatkhau.setText("Nhập mật khẩu");
		pwdMatkhau.setEchoChar('•');
		pwdMatkhau.setBounds(371, 167, 230, 30);
		contentPane.add(pwdMatkhau);
		pwdMatkhau.setColumns(10);

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBackground(new Color(240, 240, 240));
		btnDangNhap.setFont(new Font("Arial", Font.BOLD, 13));
		// btnDangNhap.setIcon(new ImageIcon("./HinhAnh/image/enter.png"));
		btnDangNhap.setBounds(371, 256, 123, 30);
		contentPane.add(btnDangNhap);

		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(240, 240, 240));
		// btnThoat.setIcon(new ImageIcon("./HinhAnh/image/close.png"));
		btnThoat.setFont(new Font("Arial", Font.BOLD, 13));
		btnThoat.setBounds(504, 256, 97, 30);
		contentPane.add(btnThoat);

		lblQuenMatKhau = new JLabel("Bạn quên mật khẩu ?");
		lblQuenMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		lblQuenMatKhau.setForeground(new Color(30, 144, 255));
		lblQuenMatKhau.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblQuenMatKhau.setBounds(371, 297, 181, 23);
		contentPane.add(lblQuenMatKhau);

		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setBounds(429, 11, 123, 30);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));

		JCheckBox chckbxHienMatKhau = new JCheckBox();
		chckbxHienMatKhau.setFont(new Font("Arial", Font.PLAIN, 13));
		chckbxHienMatKhau.setBackground(Color.WHITE);
		chckbxHienMatKhau.setBounds(371, 215, 21, 23);
		chckbxHienMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxHienMatKhau.isSelected()) {
					lblMatKhau.setText("Ẩn mật khẩu");
					pwdMatkhau.setEchoChar((char) 0);
				} else {
					lblMatKhau.setText("Hiện mật khẩu");
					pwdMatkhau.setEchoChar('•');
				}
			}
		});

		contentPane.add(chckbxHienMatKhau);

		lblMatKhau = new JLabel("Hiện mật khẩu");
		lblMatKhau.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblQuenMatKhau.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblMatKhau.setBounds(408, 215, 193, 23);
		contentPane.add(lblMatKhau);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("./HinhAnh/image/unauthorized-person.png"));
		lblNewLabel_1.setBounds(336, 105, 32, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("./HinhAnh/image/padlock.png"));
		lblNewLabel_1_1.setBounds(336, 167, 32, 32);
		contentPane.add(lblNewLabel_1_1);
		btnThoat.addActionListener(this);
		btnDangNhap.addActionListener(this);
		lblQuenMatKhau.addMouseListener(this);
		this.addKeyListener(this);

	}

	public void phanQuyenDangNhap(String tenDangNhap, String matKhau) {
		try {
			PreparedStatement preStm = null;
			Connection con = ConnectDataBase.getInstance().getConnection();
			String sql = "SELECT  tk.[maNhanVien], [matKhau], [chucVu]      \r\n"
					+ "FROM            Nhan_Vien nv INNER JOIN\r\n"
					+ "                         Tai_Khoan tk ON nv.maNhanVien = tk.maNhanVien\r\n"
					+ "						 where tk.[maNhanVien] = ? and [matKhau] = ?\r\n"
					+ "group by tk.[maNhanVien], [matKhau], [chucVu]\r\n"
					+ "";
			preStm = con.prepareStatement(sql);
			preStm.setString(1, tenDangNhap);
			preStm.setString(2, matKhau);
			ResultSet rs = preStm.executeQuery();
			while (rs.next()) {
				String tenTaiKhoan = rs.getString(1).trim();
				String matKhauNV = rs.getString(2).trim();
				String chucVu = rs.getString(3).trim();
				nhanVien = nhanVienService.layThongTinNhanVienTheoMaNhanVien(tenTaiKhoan);
				taiKhoan.setNhanVien(nhanVien);
				taiKhoan.setMatKhau(matKhauNV);
				nhanVien.setChucVu(chucVu);
				// System.out.println(taiKhoan);
				// System.out.println(nhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {

		if (taiKhoan.getNhanVien().getMaNhanVien().equalsIgnoreCase(tenDangNhap)
				&& taiKhoan.getMatKhau().equalsIgnoreCase(matKhau)
				&& nhanVien.getChucVu().equalsIgnoreCase("NVBH")) {
			TrangThaiDangNhapNhanVien = true;
			return true;
		} else if (taiKhoan.getNhanVien().getMaNhanVien().equalsIgnoreCase(tenDangNhap)
				&& taiKhoan.getMatKhau().equalsIgnoreCase(matKhau)
				&& nhanVien.getChucVu().equalsIgnoreCase("NVQL")) {
			TrangThaiDangNhapQuanLy = true;
			return true;
		}
		return false;
	}

	public void logIn() {

		try {
			String tenDN = txtTaiKhoan.getText().trim();
			String matKhau = pwdMatkhau.getText().trim();
			phanQuyenDangNhap(tenDN, matKhau);

			if (kiemTraDangNhap(tenDN, matKhau) && TrangThaiDangNhapNhanVien == true) {
				usernameToGetNhanVien = txtTaiKhoan.getText();
				// System.out.println("1 " + usernameToGetNhanVien);
				Form_Man_Hinh_Chinh formManHinhChinh = new Form_Man_Hinh_Chinh();
				formManHinhChinh.mnNhanVien.setEnabled(false);
				formManHinhChinh.mntmThongKeDoanhThu.setEnabled(false);
				// formManHinhChinh.mntmThongKeentity.Staff.setEnabled(false);
				formManHinhChinh.mntmThongKeSanPhamBanChay.setEnabled(false);
				formManHinhChinh.setVisible(true);
				this.setVisible(false);
			} else if (kiemTraDangNhap(tenDN, matKhau) && TrangThaiDangNhapQuanLy == true) {
				usernameToGetNhanVien = txtTaiKhoan.getText();
				// System.out.println("2 " + usernameToGetNhanVien);
				Form_Man_Hinh_Chinh formManHinhChinh = new Form_Man_Hinh_Chinh();
				formManHinhChinh.setVisible(true);
				this.setVisible(false);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
			// e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnThoat)) {
			System.exit(0);
		} else if (obj.equals(btnDangNhap)) {
			if (txtTaiKhoan.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(btnDangNhap, "Tài khoản không được  để trống");
				return;
			}
			if (pwdMatkhau.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(btnDangNhap, "Mật khẩu không được  để trống");
				return;
			}

			logIn();
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Form_Gui_Ma_Xac_Thuc form_Gui_Ma_Xac_Thuc = new Form_Gui_Ma_Xac_Thuc();
		this.setVisible(false);
		form_Gui_Ma_Xac_Thuc.setVisible(true);
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
}
