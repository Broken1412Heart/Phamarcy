package ui;

import java.awt.EventQueue;
import java.awt.Font;
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

import esp.entity.StaffService;
import esp.entity.StaffServiceImpl;
import connectDB.ConnectDataBase;
import entity.entity.Staff;
import handle.RoundJTextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;

public class Form_Khach_Hang extends JFrame implements ActionListener, MouseListener {

	public static JPanel contentPane;
	private JTextField textMaentity.Staff;
	private JTextField textTenentity.Staff;
	private JTextField textSoDienThoai;
	private JTable tableentity.Staff;
	private DefaultTableModel dataModelentity.Staff;
	private JScrollPane scrollentity.Staff;
	private JTextField textTimKiem;
	private entity.StaffService entity.StaffService=new entity.StaffServiceImpl();
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private JButton btnXoaRong;
	private JButton btnThem;
	private ButtonGroup btnGroupGioiTinh;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnTimKiem;
	private JButton btnHoanTac;
	private JLabel lblTBTenentity.Staff;
	private JLabel lblTBSoDienThoai;
	private JLabel lblTBMaentity.Staff;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Khach_Hang frame = new Form_Khach_Hang();
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
	public Form_Khach_Hang() {
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

		JPanel panelThongTinentity.Staff = new JPanel();
		panelThongTinentity.Staff.setBackground(new Color(240, 255, 255));
		panelThongTinentity.Staff.setBorder(
				new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinentity.Staff.setBounds(306, 87, 784, 130);
		contentPane.add(panelThongTinentity.Staff);
		panelThongTinentity.Staff.setLayout(null);

		JLabel lblMaentity.Staff = new JLabel("Mã Khách Hàng:");
		lblMaentity.Staff.setBounds(24, 35, 126, 14);
		panelThongTinentity.Staff.add(lblMaentity.Staff);

		JLabel lblTenentity.Staff = new JLabel("Tên Khách Hàng:");
		lblTenentity.Staff.setBounds(24, 79, 126, 14);
		panelThongTinentity.Staff.add(lblTenentity.Staff);

		textMaentity.Staff = new JTextField();
		textMaentity.Staff.setBackground(Color.WHITE);
		textMaentity.Staff.setText("Tự động khi để trống");
		textMaentity.Staff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textMaentity.Staff.getText().equals("Tự động khi để trống")) {
					textMaentity.Staff.setText("");
					textMaentity.Staff.setForeground(new Color(0, 0, 0));
				}
			}
		});
		textMaentity.Staff.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textMaentity.Staff.getText().equals("Tự động khi để trống")) {
					// textMaSanPham.setText("Tự động khi để trống");
					textMaentity.Staff.setForeground(new Color(153, 153, 153));
					lblTBMaentity.Staff.setText("");
				} else if (!textMaentity.Staff.getText().matches("KH[\\d]{1,14}")) {
					lblTBMaentity.Staff.setText("* Không hợp lệ! KH***********!");
					if (textMaentity.Staff.getText().equals("Tự động khi để trống")) {
						lblTBMaentity.Staff.setText("");
					}
				} else {
					lblTBMaentity.Staff.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textMaentity.Staff.getText().equals("")) {
					textMaentity.Staff.setText("Tự động khi để trống");
					textMaentity.Staff.setForeground(new Color(153, 153, 153));
				}
				if (!textMaentity.Staff.getText().matches("KH[\\d]{1,14}")) {
					lblTBMaentity.Staff.setText("* Không hợp lệ! KH***********!");
					if (textMaentity.Staff.getText().equals("Tự động khi để trống")) {
						lblTBMaentity.Staff.setText("");
					}
				} else {
					lblTBMaentity.Staff.setText("");
				}
			}
		});

		textMaentity.Staff.setBounds(177, 32, 197, 20);
		panelThongTinentity.Staff.add(textMaentity.Staff);
		textMaentity.Staff.setColumns(10);

		textTenentity.Staff = new JTextField();
		textTenentity.Staff.setBackground(Color.WHITE);
		textTenentity.Staff.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textTenentity.Staff.getText().length() == 0) {
					lblTBTenentity.Staff.setText("* Không để trống!");
				} else if (textTenentity.Staff.getText().length() > 50) {
					lblTBTenentity.Staff.setText("* Quá dài!");
				} else {
					lblTBTenentity.Staff.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textTenentity.Staff.getText().length() == 0) {
					lblTBTenentity.Staff.setText("* Không để trống!");
				} else if (textTenentity.Staff.getText().length() > 50) {
					lblTBTenentity.Staff.setText("* Quá dài!");
				} else {
					lblTBTenentity.Staff.setText("");
				}
			}
		});
		textTenentity.Staff.setColumns(10);
		textTenentity.Staff.setBounds(177, 77, 197, 20);
		panelThongTinentity.Staff.add(textTenentity.Staff);

		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setBounds(466, 35, 83, 14);
		panelThongTinentity.Staff.add(lblGioiTinh);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBackground(new Color(240, 255, 255));
		rdbtnNam.setBounds(555, 31, 60, 23);
		panelThongTinentity.Staff.add(rdbtnNam);
		rdbtnNam.setSelected(true);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBackground(new Color(240, 255, 255));
		rdbtnNu.setBounds(636, 31, 47, 23);
		panelThongTinentity.Staff.add(rdbtnNu);

		btnGroupGioiTinh = new ButtonGroup();
		btnGroupGioiTinh.add(rdbtnNam);
		btnGroupGioiTinh.add(rdbtnNu);

		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setBounds(466, 79, 83, 14);
		panelThongTinentity.Staff.add(lblSoDienThoai);

		textSoDienThoai = new JTextField();
		textSoDienThoai.setBackground(Color.WHITE);
		textSoDienThoai.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textSoDienThoai.getText().length() == 0) {
					lblTBSoDienThoai.setText("* Không để trống!");
				} else if (!textSoDienThoai.getText().matches("(84|0[3|5|7|8|9])([0-9]{8})")) {
					lblTBSoDienThoai.setText("* Không hợp lệ!");
				} else {
					lblTBSoDienThoai.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textSoDienThoai.getText().length() == 0) {
					lblTBSoDienThoai.setText("* Không để trống!");
				} else if (!textSoDienThoai.getText().matches("(84|0[3|5|7|8|9])([0-9]{8})")) {
					lblTBSoDienThoai.setText("* Không hợp lệ!");
				} else {
					lblTBSoDienThoai.setText("");
				}
			}
		});
		textSoDienThoai.setColumns(10);
		textSoDienThoai.setBounds(555, 77, 197, 20);
		panelThongTinentity.Staff.add(textSoDienThoai);

		lblTBMaentity.Staff = new JLabel("");
		lblTBMaentity.Staff.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBMaentity.Staff.setForeground(Color.RED);
		lblTBMaentity.Staff.setBounds(177, 54, 197, 20);
		panelThongTinentity.Staff.add(lblTBMaentity.Staff);

		lblTBTenentity.Staff = new JLabel("");
		lblTBTenentity.Staff.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBTenentity.Staff.setForeground(Color.RED);
		lblTBTenentity.Staff.setBounds(177, 100, 197, 20);
		panelThongTinentity.Staff.add(lblTBTenentity.Staff);

		lblTBSoDienThoai = new JLabel("");
		lblTBSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBSoDienThoai.setForeground(Color.RED);
		lblTBSoDienThoai.setBounds(555, 100, 197, 20);
		panelThongTinentity.Staff.add(lblTBSoDienThoai);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(157, 235, 1037, 45);
		contentPane.add(panel);
		panel.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(255, 240, 245));
		btnThem.setBounds(58, 11, 89, 23);
		panel.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(255, 240, 245));
		btnXoa.setBounds(186, 11, 89, 23);
		panel.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(255, 240, 245));
		btnSua.setBounds(321, 11, 89, 23);
		panel.add(btnSua);

		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBackground(new Color(255, 240, 245));
		btnXoaRong.setBounds(451, 11, 102, 23);
		panel.add(btnXoaRong);

		btnHoanTac = new JButton("Hoàn Tác");
		btnHoanTac.setBackground(new Color(255, 240, 245));
		btnHoanTac.setBounds(579, 11, 102, 23);
		panel.add(btnHoanTac);

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setBackground(new Color(255, 240, 245));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setBounds(880, 11, 102, 23);
		panel.add(btnTimKiem);

		textTimKiem = new RoundJTextField(15);
		textTimKiem.setBackground(Color.WHITE);
		textTimKiem.setBounds(716, 12, 154, 20);
		panel.add(textTimKiem);
		textTimKiem.setColumns(10);

		JPanel panelDanhSachentity.Staff = new JPanel();
		panelDanhSachentity.Staff.setBackground(new Color(240, 255, 255));
		panelDanhSachentity.Staff.setBounds(10, 309, 1330, 385);
		panelDanhSachentity.Staff.setBorder(
				new TitledBorder(null, "Danh sách khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelDanhSachentity.Staff);
		panelDanhSachentity.Staff.setLayout(null);

		String[] tieuDe = new String[] { "Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính", "Số Điện Thoại", "Chọn" };
		dataModelentity.Staff = new DefaultTableModel(tieuDe, 0) {
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
				if (column == 4) {
					return true;
				} else {
					// all other columns to false
					return false;
				}
			}
		};
		scrollentity.Staff = new JScrollPane();
		scrollentity.Staff.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollentity.Staff.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollentity.Staff.setBounds(10, 20, 1309, 355);
		panelDanhSachentity.Staff.add(scrollentity.Staff);
		tableentity.Staff = new JTable(dataModelentity.Staff);
		tableentity.Staff.setBackground(new Color(240, 255, 255));
		tableentity.Staff.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollentity.Staff.setViewportView(tableentity.Staff);

		btnXoaRong.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnHoanTac.addActionListener(this);
		tableentity.Staff.addMouseListener(this);

		docDuLieu();

	}

	public void docDuLieu() {
		List<entity.Staff> dsKH = entity.StaffService.getTatCaentity.Staff();
		dataModelentity.Staff.setRowCount(0);
		for (entity.Staff kh : dsKH) {
			dataModelentity.Staff.addRow(new Object[] {
					kh.getMaentity.Staff(), kh.getTenentity.Staff().trim(), kh.isGioiTinh() == true ? "Nam" : "Nữ",
					kh.getSoDienThoai().trim()
			});
		}
	}

	private void xoaRong() {
		textMaentity.Staff.setText("Tự động khi để trống");
		textTenentity.Staff.setText("");
		textSoDienThoai.setText("");
		rdbtnNam.setSelected(true);
		textTimKiem.setText("");
		lblTBMaentity.Staff.setText("");
		lblTBSoDienThoai.setText("");
		lblTBTenentity.Staff.setText("");
		textMaentity.Staff.setEditable(true);
	}

	public boolean themMoientity.Staff() {
		entity.Staff entity.Staff = null;
		String maentity.Staff = textMaentity.Staff.getText().trim();
		if (maentity.Staff.equals("Tự động khi để trống")) {
			maentity.Staff = taoMaTuDong();
		}
		String tenentity.Staff = textTenentity.Staff.getText().trim();
		String soDienThoai = textSoDienThoai.getText().trim();
		boolean gioiTinh = false;
		if (rdbtnNam.isSelected()) {
			gioiTinh = true;
		}
		entity.Staff = new entity.Staff(maentity.Staff, tenentity.Staff, soDienThoai, gioiTinh);
		boolean kq = entity.StaffService.thementity.Staff(entity.Staff);
		return kq;
	}

	public void timKiementity.Staff(String noidungTim) {
		List<entity.Staff> entity.Staffs = entity.StaffService.timKiementity.Staff(noidungTim);
		dataModelentity.Staff.getDataVector().removeAllElements();
		for (entity.Staff kh : entity.Staffs) {
			dataModelentity.Staff.addRow(new Object[] {
					kh.getMaentity.Staff(), kh.getTenentity.Staff(), kh.isGioiTinh() == true ? "Nam" : "Nữ",
					kh.getSoDienThoai()
			});
		}

		tableentity.Staff.setModel(dataModelentity.Staff);
	}

	public boolean capNhatentity.Staff() {
		boolean kq = false;
		int row = tableentity.Staff.getSelectedRow();
		entity.Staff kh;
		String maentity.Staff = textMaentity.Staff.getText().trim();
		String tenentity.Staff = textTenentity.Staff.getText().trim();
		String soDienThoai = textSoDienThoai.getText().trim();
		boolean gioiTinh = false;
		if (rdbtnNam.isSelected()) {
			gioiTinh = true;
		}

		kh = new entity.Staff(maentity.Staff, tenentity.Staff, soDienThoai, gioiTinh);
		kq = entity.StaffService.capNhatThongTinentity.Staff(kh);

		if (kq) {
			tableentity.Staff.setValueAt(textMaentity.Staff.getText(), row, 0);
			tableentity.Staff.setValueAt(textTenentity.Staff.getText(), row, 1);
			tableentity.Staff.setValueAt(textSoDienThoai.getText(), row, 3);
			Xoadata();
			docDuLieu();
			tableentity.Staff.clearSelection();
		}

		return kq;
	}

	public boolean xoaentity.Staff() {
		Boolean kq = false;
		String maKH = "";
		DefaultTableModel model = (DefaultTableModel) tableentity.Staff.getModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			maKH = (String) model.getValueAt(i, 0);
			Boolean checked = (Boolean) model.getValueAt(i, 4);

			if (checked != null && checked) {
				kq = entity.StaffService.xoaentity.Staff(maKH);
				model.removeRow(i);
				i--;
			}
		}

		return kq;
	}

	private void Xoadata() {
		dataModelentity.Staff.getDataVector().removeAllElements();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaRong)) {
			xoaRong();
		} else if (o.equals(btnThem)) {
			if (kiemTraDuLieu()) {
				Boolean kq = themMoientity.Staff();
				docDuLieu();
				xoaRong();
			}
		} else if (o.equals(btnXoa)) {
			if (tableentity.Staff.getSelectedRow() != -1) {
				int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa!", JOptionPane.YES_NO_OPTION);
				if (ask == JOptionPane.YES_OPTION) {
					Boolean kq = xoaentity.Staff();
					docDuLieu();
					xoaRong();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Phải chọn khách hàng");
			}
		} else if (o.equals(btnTimKiem)) {
			String noidungTim = textTimKiem.getText().trim();
			if (noidungTim.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("./HinhAnh/IconChucNang/warning.png"));
			} else {
				timKiementity.Staff(noidungTim);
			}
		} else if (o.equals(btnSua)) {
			if (kiemTraDuLieu()) {
				Boolean kq = capNhatentity.Staff();
				xoaRong();
			}

		} else if (o.equals(btnHoanTac)) {
			docDuLieu();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// int row = tableentity.Staff.getSelectedRow();
		// textMaentity.Staff.setText(dataModelentity.Staff.getValueAt(row,
		// 0).toString());
		// textTenentity.Staff.setText(dataModelentity.Staff.getValueAt(row,
		// 1).toString());
		// textSoDienThoai.setText(dataModelentity.Staff.getValueAt(row, 3).toString());
		// textMaentity.Staff.setEditable(false);

		int row = tableentity.Staff.getSelectedRow();
		String maKH = dataModelentity.Staff.getValueAt(row, 0).toString();
		try {
			entity.Staff kh = entity.StaffService.layThongTinentity.StaffTheoMaentity.Staff(maKH);
			textMaentity.Staff.setText(maKH + "");
			textTenentity.Staff.setText(kh.getTenentity.Staff());
			textSoDienThoai.setText(kh.getSoDienThoai());
			if (kh.isGioiTinh() == true) {
				rdbtnNam.setSelected(true);
			} else {
				rdbtnNu.setSelected(true);
			}
			textMaentity.Staff.setEditable(false);

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

	private boolean kiemTraDuLieu() {
		String maentity.Staff = textMaentity.Staff.getText().trim();
		String tenentity.Staff = textTenentity.Staff.getText().trim();
		String soDienThoai = textSoDienThoai.getText().trim();

		lblTBMaentity.Staff.setText("");
		lblTBTenentity.Staff.setText("");
		lblTBSoDienThoai.setText("");

		if (!maentity.Staff.equals("Tự động khi để trống")) {
			if (maentity.Staff.length() == 0) {
				lblTBMaentity.Staff.setText("* Không để trống!");
				return false;
			} else if (!(maentity.Staff.matches("KH[\\d]{1,14}") && maentity.Staff.length() < 20)) {
				lblTBMaentity.Staff.setText("* Không hợp lệ! KH***********");
				return false;
			}
		}

		if (tenentity.Staff.length() == 0) {
			lblTBTenentity.Staff.setText("* Không để trống!");
			return false;
		} else if (!(tenentity.Staff.length() < 100)) {
			lblTBTenentity.Staff.setText("* Không hợp lệ!");
			return false;
		}

		if (soDienThoai.length() == 0) {
			lblTBSoDienThoai.setText("* Không để trống!");
			return false;
		} else if (!soDienThoai.matches("(84|0[3|5|7|8|9])([0-9]{8})")) {
			lblTBSoDienThoai.setText("* Không hợp lệ!");
			return false;
		}

		return true;
	}

	private String taoMaTuDong() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime ngayNhap = LocalDateTime.now();
		String res = "KH" + formatter.format(ngayNhap);
		return res;
	}
}
