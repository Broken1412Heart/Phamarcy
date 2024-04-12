package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import esp.NhanVienService;
import esp.NhanVienServiceImpl;
import connectDB.ConnectDataBase;
import entity.NhanVien;
import handle.RoundJTextField;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class Form_Nhan_Vien extends JFrame implements ActionListener, MouseListener {

	public static JPanel contentPane;
	public static JTextField textMaNhanVien;
	private static JTextField textTenNhanVien;
	private static JTextField textEmail;
	private static JTable tableNhanVien;
	private static DefaultTableModel dataModelNhanVien;
	private JScrollPane scrollNhanVien;
	private static JTextField textTimKiem;
	private static NhanVienService nhanVienService = new NhanVienServiceImpl();
	private static JRadioButton rdbtnNam;
	private static JRadioButton rdbtnNu;
	private JButton btnXoaRong;
	public static JButton btnThem;
	private ButtonGroup btnGroupGioiTinh;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnTimKiem;
	private JButton btnHoanTac;
	private static JComboBox<String> comboBoxTrangThai;
	private static JDateChooser dateChonNgaySinh;
	private static JLabel lblTBMaNhanVien;
	private static JLabel lblTBTenNhanVien;
	private static JLabel lblTBEmail;
	private static JLabel lblTBNgaySinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Nhan_Vien frame = new Form_Nhan_Vien();
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
	public Form_Nhan_Vien() {
		// DAO
		try {
			ConnectDataBase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1380, 780);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelThongTinNhanVien = new JPanel();
		panelThongTinNhanVien.setBackground(new Color(240, 255, 255));
		panelThongTinNhanVien.setBorder(
				new TitledBorder(null, "Thông tin nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinNhanVien.setBounds(49, 79, 1249, 130);
		contentPane.add(panelThongTinNhanVien);
		panelThongTinNhanVien.setLayout(null);

		JLabel lblMaNhanVien = new JLabel("Mã Nhân Viên:");
		lblMaNhanVien.setBounds(24, 35, 83, 14);
		panelThongTinNhanVien.add(lblMaNhanVien);

		JLabel lblTenNhanVien = new JLabel("Tên Nhân Viên:");
		lblTenNhanVien.setBounds(24, 83, 110, 14);
		panelThongTinNhanVien.add(lblTenNhanVien);

		textMaNhanVien = new JTextField();
		textMaNhanVien.setBackground(Color.WHITE);
		textMaNhanVien.setBounds(177, 32, 197, 20);
		textMaNhanVien.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (!textMaNhanVien.getText().matches("NV[\\d]{3}")) {
					lblTBMaNhanVien.setText("* Không hợp lệ! NV*****!");
				} else {
					lblTBMaNhanVien.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!textMaNhanVien.getText().matches("NV[\\d]{3}")) {
					lblTBMaNhanVien.setText("* Không hợp lệ! NV***!");
				} else {
					lblTBMaNhanVien.setText("");
				}
			}
		});

		panelThongTinNhanVien.add(textMaNhanVien);
		textMaNhanVien.setColumns(10);

		textTenNhanVien = new JTextField();
		textTenNhanVien.setBackground(Color.WHITE);
		textTenNhanVien.setColumns(10);
		textTenNhanVien.setBounds(177, 81, 197, 20);
		panelThongTinNhanVien.add(textTenNhanVien);

		textTenNhanVien.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textTenNhanVien.getText().length() == 0) {
					lblTBTenNhanVien.setText("* Không để trống!");
				} else if (textTenNhanVien.getText().length() > 50) {
					lblTBTenNhanVien.setText("* Quá dài!");
				} else {
					lblTBTenNhanVien.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textTenNhanVien.getText().length() == 0) {
					lblTBTenNhanVien.setText("* Không để trống!");
				} else if (textTenNhanVien.getText().length() > 50) {
					lblTBTenNhanVien.setText("* Quá dài!");
				} else {
					lblTBTenNhanVien.setText("");
				}
			}
		});

		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setBounds(466, 35, 83, 14);
		panelThongTinNhanVien.add(lblGioiTinh);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBackground(new Color(240, 255, 255));
		rdbtnNam.setBounds(555, 31, 60, 23);
		panelThongTinNhanVien.add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBackground(new Color(240, 255, 255));
		rdbtnNu.setBounds(636, 31, 47, 23);
		panelThongTinNhanVien.add(rdbtnNu);

		btnGroupGioiTinh = new ButtonGroup();
		btnGroupGioiTinh.add(rdbtnNam);
		btnGroupGioiTinh.add(rdbtnNu);

		rdbtnNam.setSelected(true);

		JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
		lblNgaySinh.setBounds(870, 32, 83, 14);
		panelThongTinNhanVien.add(lblNgaySinh);

		dateChonNgaySinh = new JDateChooser();
		dateChonNgaySinh.setBackground(Color.WHITE);
		dateChonNgaySinh.setDateFormatString("yyyy-MM-dd");
		dateChonNgaySinh.setBounds(979, 16, 123, 36);
		panelThongTinNhanVien.add(dateChonNgaySinh);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(466, 83, 83, 14);
		panelThongTinNhanVien.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBackground(Color.WHITE);
		textEmail.setColumns(10);
		textEmail.setBounds(555, 81, 197, 20);
		panelThongTinNhanVien.add(textEmail);

		textEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textEmail.getText().length() == 0) {
					lblTBEmail.setText("* Không để trống!");
				} else if (textEmail.getText().length() > 50) {
					lblTBEmail.setText("* Quá dài!");
				} else if (!textEmail.getText().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
					lblTBEmail.setText("* Không hợp lệ!");
				} else {
					lblTBEmail.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textEmail.getText().length() == 0) {
					lblTBEmail.setText("* Không để trống!");
				} else if (textEmail.getText().length() > 50) {
					lblTBEmail.setText("* Quá dài!");
				} else if (!textEmail.getText().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
					lblTBEmail.setText("* Không hợp lệ!");
				} else {
					lblTBEmail.setText("");
				}
			}
		});

		JLabel lbTrangThai = new JLabel("Trạng Thái:");
		lbTrangThai.setBounds(870, 91, 83, 14);
		panelThongTinNhanVien.add(lbTrangThai);

		comboBoxTrangThai = new JComboBox<String>();
		comboBoxTrangThai.setBackground(Color.WHITE);
		comboBoxTrangThai.setEnabled(false);
		comboBoxTrangThai.addItem("Đang làm việc");
		comboBoxTrangThai.addItem("Thôi việc");
		comboBoxTrangThai.setBounds(979, 83, 123, 30);
		panelThongTinNhanVien.add(comboBoxTrangThai);

		lblTBMaNhanVien = new JLabel("");
		lblTBMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBMaNhanVien.setForeground(Color.RED);
		lblTBMaNhanVien.setBounds(177, 51, 197, 20);
		panelThongTinNhanVien.add(lblTBMaNhanVien);

		lblTBTenNhanVien = new JLabel("");
		lblTBTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBTenNhanVien.setForeground(Color.RED);
		lblTBTenNhanVien.setBounds(177, 100, 197, 20);
		panelThongTinNhanVien.add(lblTBTenNhanVien);

		lblTBEmail = new JLabel("");
		lblTBEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBEmail.setForeground(Color.RED);
		lblTBEmail.setBounds(555, 101, 197, 20);
		panelThongTinNhanVien.add(lblTBEmail);

		lblTBNgaySinh = new JLabel("");
		lblTBNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBNgaySinh.setForeground(Color.RED);
		lblTBNgaySinh.setBounds(979, 51, 123, 20);
		panelThongTinNhanVien.add(lblTBNgaySinh);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(126, 230, 1098, 45);
		contentPane.add(panel);
		panel.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(255, 240, 245));
		btnThem.setBounds(29, 11, 89, 23);
		panel.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(255, 240, 245));
		btnXoa.setBounds(153, 11, 89, 23);
		panel.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(255, 240, 245));
		btnSua.setBounds(284, 11, 89, 23);
		panel.add(btnSua);

		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBackground(new Color(255, 240, 245));
		btnXoaRong.setBounds(409, 11, 110, 23);
		panel.add(btnXoaRong);

		btnHoanTac = new JButton("Hoàn Tác");
		btnHoanTac.setBackground(new Color(255, 240, 245));
		btnHoanTac.setBounds(545, 11, 110, 23);
		panel.add(btnHoanTac);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(new Color(255, 240, 245));
		btnTimKiem.setBounds(999, 11, 89, 23);
		panel.add(btnTimKiem);

		textTimKiem = new RoundJTextField(15);
		textTimKiem.setBackground(Color.WHITE);
		textTimKiem.setBounds(805, 12, 184, 20);
		panel.add(textTimKiem);
		textTimKiem.setColumns(10);

		JPanel panelDanhSachNhanVien = new JPanel();
		panelDanhSachNhanVien.setBackground(new Color(240, 255, 255));
		panelDanhSachNhanVien.setBounds(10, 309, 1330, 385);
		panelDanhSachNhanVien.setBorder(
				new TitledBorder(null, "Danh sách nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelDanhSachNhanVien);
		panelDanhSachNhanVien.setLayout(null);

		String[] tieuDe = new String[] { "Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Email", "Ngày Sinh",
				"Trạng Thái", "Chức Vụ", "Chọn" };
		dataModelNhanVien = new DefaultTableModel(tieuDe, 0) {
			public Class<?> getColumnClass(int column) {
				switch (column) {
					case 0:
						return String.class;
					case 1:
						return String.class;
					case 2:
						return String.class;
					case 3:
						return String.class;
					case 4:
						return String.class;
					case 5:
						return String.class;
					case 6:
						return String.class;
					case 7:
						return Boolean.class;
					default:
						return String.class;
				}
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				/*
				 * Set the 11th column as editable and rest non-
				 * editable
				 */
				if (column == 7) {
					return true;
				} else {
					// all other columns to false
					return false;
				}
			}
		};
		scrollNhanVien = new JScrollPane();
		scrollNhanVien.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollNhanVien.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollNhanVien.setBounds(37, 10, 1309, 355);
		panelDanhSachNhanVien.add(scrollNhanVien);
		tableNhanVien = new JTable(dataModelNhanVien);
		tableNhanVien.setBackground(new Color(240, 255, 255));
		tableNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollNhanVien.setViewportView(tableNhanVien);

		btnXoaRong.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnHoanTac.addActionListener(this);
		tableNhanVien.addMouseListener(this);

		docDuLieu();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int row = tableNhanVien.getSelectedRow();
		String maNhanVien = dataModelNhanVien.getValueAt(row, 0).toString();
		try {
			NhanVien nv = nhanVienService.layThongTinNhanVienTheoMaNhanVien(maNhanVien);
			textMaNhanVien.setText(maNhanVien + "");
			textTenNhanVien.setText(nv.getTenNhanVien());
			if (nv.isGioiTinh() == true) {
				rdbtnNam.setSelected(true);
			} else {
				rdbtnNu.setSelected(true);
			}
			textEmail.setText(nv.getEmail());

			dateChonNgaySinh.setDate(nv.getNgaySinh());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String ngaySinhtxt = dateFormat.format(dateChonNgaySinh.getDate());
			Date ngaySinhsql = null;
			try {
				java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
				ngaySinhsql = new Date(ngaySinh.getTime());
				dateChonNgaySinh.setDate(ngaySinhsql);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			comboBoxTrangThai.setEnabled(true);
			comboBoxTrangThai.getModel().setSelectedItem(nv.isTrangThai() == true ? "Đang làm việc" : "Thôi việc");
			textMaNhanVien.setEditable(false);

		} catch (Exception e2) {
			System.out.println("error mouse clicked");
			e2.printStackTrace();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaRong)) {
			xoaRong();
		} else if (o.equals(btnThem)) {
			comboBoxTrangThai.setEnabled(false);
			if (kiemTraDuLieu()) {
				Boolean kq = themMoiNhanVien();
				docDuLieu();
				new Form_Cap_Mat_Khau().setVisible(true);
			}

		} else if (o.equals(btnXoa)) {
			if (tableNhanVien.getSelectedRow() != -1) {
				int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa!", JOptionPane.YES_NO_OPTION);

				if (ask == JOptionPane.YES_OPTION) {
					try {
						comboBoxTrangThai.setEnabled(false);
						Boolean kq = xoaNhanVien();
						docDuLieu();
						xoaRong();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Phải chọn nhân viên!");
			}
		} else if (o.equals(btnTimKiem)) {
			comboBoxTrangThai.setEnabled(false);
			String noidungTim = textTimKiem.getText().trim();
			if (noidungTim.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("./HinhAnh/IconChucNang/warning.png"));
			} else {
				timKiemNhanVien(noidungTim);
			}
		} else if (o.equals(btnSua)) {
			if (kiemTraDuLieu()) {
				Boolean kq = capNhatNhanVien();
				xoaRong();
			}

		} else if (o.equals(btnHoanTac)) {
			comboBoxTrangThai.setEnabled(false);
			docDuLieu();
		}

	}

	public static void docDuLieu() {
		List<NhanVien> dsNV = nhanVienService.getTatCaNhanVien();
		dataModelNhanVien.setRowCount(0);
		for (NhanVien nv : dsNV) {
			dataModelNhanVien.addRow(new Object[] {
					nv.getMaNhanVien(), nv.getTenNhanVien().trim(), nv.isGioiTinh() == true ? "Nam" : "Nữ",
					nv.getEmail().trim(), nv.getNgaySinh(),
					nv.isTrangThai() == true ? "Đang làm việc" : "Thôi việc", nv.getChucVu()
			});
		}
	}

	public static void xoaRong() {
		textMaNhanVien.setText("");
		textTenNhanVien.setText("");
		textEmail.setText("");
		rdbtnNam.setSelected(true);
		comboBoxTrangThai.setEnabled(false);
		textTimKiem.setText("");
		dateChonNgaySinh.setDate(null);
		textMaNhanVien.setEditable(true);

		lblTBMaNhanVien.setText("");
		lblTBTenNhanVien.setText("");
		lblTBNgaySinh.setText("");
		lblTBEmail.setText("");
	}

	public static boolean themMoiNhanVien() {
		NhanVien nhanVien = null;
		String maNhanVien = textMaNhanVien.getText().trim();
		String tenNhanVien = textTenNhanVien.getText().trim();
		String email = textEmail.getText().trim();
		boolean gioiTinh = false;
		if (rdbtnNam.isSelected()) {
			gioiTinh = true;
		}

		Date ngaySinhsql = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String ngaySinhtxt = dateFormat.format(dateChonNgaySinh.getDate());
			java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
			ngaySinhsql = new Date(ngaySinh.getTime());
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		boolean trangThai = false;
		if (comboBoxTrangThai.getSelectedItem().equals("Đang làm việc")) {
			trangThai = true;
		}

		nhanVien = new NhanVien(maNhanVien, email, ngaySinhsql, tenNhanVien, gioiTinh, "NVBH", trangThai);
		boolean kq = nhanVienService.themNhanVien(nhanVien);
		return kq;
	}

	public void timKiemNhanVien(String noidungTim) {
		List<NhanVien> NhanViens = nhanVienService.timKiemNhanVien(noidungTim);
		dataModelNhanVien.getDataVector().removeAllElements();
		for (NhanVien nv : NhanViens) {
			dataModelNhanVien.addRow(new Object[] {
					nv.getMaNhanVien(), nv.getTenNhanVien().trim(), nv.isGioiTinh() == true ? "Nam" : "Nữ",
					nv.getEmail().trim(), nv.getNgaySinh(),
					nv.isTrangThai() == true ? "Đang làm việc" : "Thôi việc", nv.getChucVu()
			});
		}

		tableNhanVien.setModel(dataModelNhanVien);
	}

	public boolean capNhatNhanVien() {
		boolean kq = false;
		int row = tableNhanVien.getSelectedRow();
		NhanVien nhanVien;
		String maNhanVien = textMaNhanVien.getText().trim();
		String tenNhanVien = textTenNhanVien.getText().trim();
		String email = textEmail.getText().trim();
		boolean gioiTinh = false;
		if (rdbtnNam.isSelected()) {
			gioiTinh = true;
		}

		Date ngaySinhsql = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String ngaySinhtxt = dateFormat.format(dateChonNgaySinh.getDate());
			java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
			ngaySinhsql = new Date(ngaySinh.getTime());
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		boolean trangThai = false;
		if (comboBoxTrangThai.getSelectedItem().equals("Đang làm việc")) {
			trangThai = true;
		}

		nhanVien = new NhanVien(maNhanVien, email, ngaySinhsql, tenNhanVien, gioiTinh, "NVBH", trangThai);
		kq = nhanVienService.capNhatThongTinNhanVien(nhanVien);

		if (kq) {
			tableNhanVien.setValueAt(textMaNhanVien.getText(), row, 0);
			tableNhanVien.setValueAt(textTenNhanVien.getText(), row, 1);
			tableNhanVien.setValueAt(textEmail.getText(), row, 3);
			Xoadata();
			docDuLieu();
			tableNhanVien.clearSelection();
		}

		return kq;
	}

	public boolean xoaNhanVien() {
		Boolean kq = false;
		String maNhanVien = "";
		DefaultTableModel model = (DefaultTableModel) tableNhanVien.getModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			maNhanVien = (String) model.getValueAt(i, 0);
			Boolean checked = (Boolean) model.getValueAt(i, 7);

			if (checked != null && checked
					&& maNhanVien.equals(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim())) {
				JOptionPane.showMessageDialog(this, "không thể xóa nhân viên "
						+ Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim() + " đang đăng nhập");
				// return false;
			} else if (comboBoxTrangThai.getSelectedItem().equals("Đang làm việc")) {
				JOptionPane.showMessageDialog(this, "không thể xóa nhân viên " + " đang làm việc");
				break;
			} else if (checked != null && checked) {
				kq = nhanVienService.xoaNhanVien(maNhanVien);
				model.removeRow(i);
				i--;
			}
		}

		return kq;
	}

	public static void Xoadata() {
		dataModelNhanVien = (DefaultTableModel) tableNhanVien.getModel();
		dataModelNhanVien.getDataVector().removeAllElements();
	}

	public boolean kiemtraNhanVien() {
		int row = tableNhanVien.getSelectedRow();
		String maNhanVien = dataModelNhanVien.getValueAt(row, 0).toString();
		if (maNhanVien.equals(Form_Quan_Ly_Tai_Khoan.textMaNhanVien.getText().trim())) {
			JOptionPane.showMessageDialog(this, "khong the xoa nhan vien dang nhap");
			return false;
		}
		return true;
	}

	public boolean kiemTraDuLieu() {
		String maNhanVien = textMaNhanVien.getText().trim();
		String tenNhanVien = textTenNhanVien.getText().trim();
		String email = textEmail.getText().trim();
		lblTBMaNhanVien.setText("");
		lblTBTenNhanVien.setText("");
		lblTBNgaySinh.setText("");
		lblTBEmail.setText("");

		if (!(maNhanVien.length() > 0 && maNhanVien.length() < 20
				&& maNhanVien.matches("NV[\\d]{3}"))) {
			lblTBMaNhanVien.setText("* Không hợp lệ! NV***");
			return false;
		}

		if (!(tenNhanVien.length() > 0 && tenNhanVien.length() < 100)) {
			lblTBTenNhanVien.setText("* Không hợp lệ!");
			return false;
		}

		if (!(email.length() > 0 && email.length() < 50
				&& email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))) {
			lblTBEmail.setText("* Không hợp lệ!");
			return false;
		}

		if (dateChonNgaySinh.getDate().getYear() + 16 > Date.valueOf(LocalDate.now()).getYear()) {
			lblTBNgaySinh.setText("* Phải từ 16 tuổi!");
			return false;
		}

		return true;
	}
}
