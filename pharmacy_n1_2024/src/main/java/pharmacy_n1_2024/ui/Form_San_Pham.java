package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import esp.TypeMedicineService;
import esp.TypeMedicineServiceImpl;
import esp.NhaCungCapSerVice;
import esp.NhaCungCapServiceIml;
import esp.SanPhamService;
import esp.SanPhamServiceImpl;
import connectDB.ConnectDataBase;
import entity.TypeMedicine;
import entity.NhaCungCap;
import entity.Phong;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Form_San_Pham extends JFrame implements KeyListener {

	public static JPanel contentPane;
	private JTextField textMaSanPham;
	private JTextField textTenSanPham;
	private JLabel lblMoTa;
	private JTextField textMauSac;
	private JTextField textSoLuong;
	private JTextField textGiamGia;
	private JTextField textDonGiaBan;
	private JTextField textTimKiem;
	private JLabel lblHinhAnh;

	private SanPhamService sanPhamservice = new SanPhamServiceImpl();
	private JTextArea textMoTa;
	private JTextArea textChatLieu;
	private JComboBox comboTypeMedicine;
	private JComboBox comboTrangThai;
	private JComboBox comboKichThuoc;
	private JCheckBox chckbxNam;
	private JCheckBox chckbxNu;
	private JComboBox comboNhaCungCap;
	private JTextField textGiaNhap;
	private JList<Phong> listSanPham;
	private DefaultListModel<Phong> listModelSanPham;
	private JLabel lblTBMaSanPham;
	private JLabel lblTBTenSanPham;
	private JLabel lblTBMoTa;
	private JLabel lblTBChatLieu;
	private JLabel lblTBMauSac;
	private JLabel lblTBSoLuong;
	private JLabel lblTBGiamGia;
	private JLabel lblTBGioiTinh;
	private JLabel lblTBGiaNhap;
	private JLabel lblTBHinhAnh;
	private JLabel lblTBGiaBan;
	private JButton btnNhapExcel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_San_Pham frame = new Form_San_Pham();
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
	public Form_San_Pham() {

		try {
			ConnectDataBase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 498);
		setSize(1380, 780);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelThongTinSanPham = new JPanel();
		panelThongTinSanPham.setBackground(new Color(240, 255, 255));
		panelThongTinSanPham.setBorder(
				new TitledBorder(null, "Thông tin sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinSanPham.setBounds(69, 33, 571, 529);
		contentPane.add(panelThongTinSanPham);
		panelThongTinSanPham.setLayout(null);

		JLabel lblMaSanPham = new JLabel("Mã Sản phẩm:");
		lblMaSanPham.setBounds(274, 21, 99, 13);
		panelThongTinSanPham.add(lblMaSanPham);

		textMaSanPham = new JTextField();
		textMaSanPham.setText("Tự động khi để trống");
		textMaSanPham.setForeground(new Color(153, 153, 153));
		textMaSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textMaSanPham.getText().equals("Tự động khi để trống")) {
					textMaSanPham.setText("");
					textMaSanPham.setForeground(new Color(0, 0, 0));
				}
			}
		});
		textMaSanPham.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textMaSanPham.getText().equals("Tự động khi để trống")) {
					// textMaSanPham.setText("Tự động khi để trống");
					textMaSanPham.setForeground(new Color(153, 153, 153));
					lblTBMaSanPham.setText("");
				} else if (!textMaSanPham.getText().matches("SP[\\d]{1,14}")) {
					lblTBMaSanPham.setText("* Không hợp lệ! SP***********!");
					if (textMaSanPham.getText().equals("Tự động khi để trống")) {
						lblTBMaSanPham.setText("");
					}
				} else {
					lblTBMaSanPham.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textMaSanPham.getText().equals("")) {
					textMaSanPham.setText("Tự động khi để trống");
					textMaSanPham.setForeground(new Color(153, 153, 153));
				}
				if (!textMaSanPham.getText().matches("SP[\\d]{1,14}")) {
					lblTBMaSanPham.setText("* Không hợp lệ! SP***********!");
					if (textMaSanPham.getText().equals("Tự động khi để trống")) {
						lblTBMaSanPham.setText("");
					}
				} else {
					lblTBMaSanPham.setText("");
				}
			}
		});
		textMaSanPham.setBounds(382, 18, 155, 19);
		panelThongTinSanPham.add(textMaSanPham);
		textMaSanPham.setColumns(10);

		JLabel lblTenSanPham = new JLabel("Tên Sản phẩm:");
		lblTenSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenSanPham.setBounds(274, 65, 99, 13);
		panelThongTinSanPham.add(lblTenSanPham);

		textTenSanPham = new JTextField();
		textTenSanPham.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textTenSanPham.getText().length() == 0) {
					lblTBTenSanPham.setText("* Không để trống!");
				} else if (textTenSanPham.getText().length() > 50) {
					lblTBTenSanPham.setText("* Quá dài!");
				} else {
					lblTBTenSanPham.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textTenSanPham.getText().length() == 0) {
					lblTBTenSanPham.setText("* Không để trống!");
				} else if (textTenSanPham.getText().length() > 50) {
					lblTBTenSanPham.setText("* Quá dài!");
				} else {
					lblTBTenSanPham.setText("");
				}
			}
		});
		textTenSanPham.setBounds(382, 62, 155, 19);
		panelThongTinSanPham.add(textTenSanPham);
		textTenSanPham.setColumns(10);

		lblMoTa = new JLabel("Mô tả:");
		lblMoTa.setBounds(274, 108, 77, 13);
		panelThongTinSanPham.add(lblMoTa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(382, 101, 155, 35);
		panelThongTinSanPham.add(scrollPane);

		textMoTa = new JTextArea();
		textMoTa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textMoTa.getText().length() == 0) {
					lblTBMoTa.setText("* Không để trống!");
				} else if (textMoTa.getText().length() > 50) {
					lblTBMoTa.setText("* Quá dài!");
				} else {
					lblTBMoTa.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textMoTa.getText().length() == 0) {
					lblTBMoTa.setText("* Không để trống!");
				} else if (textMoTa.getText().length() > 50) {
					lblTBMoTa.setText("* Quá dài!");
				} else {
					lblTBMoTa.setText("");
				}
			}
		});
		scrollPane.setViewportView(textMoTa);

		JLabel lblChatLieu = new JLabel("Chất liệu:");
		lblChatLieu.setBounds(274, 167, 91, 13);
		panelThongTinSanPham.add(lblChatLieu);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(382, 160, 155, 35);
		panelThongTinSanPham.add(scrollPane_1);

		textChatLieu = new JTextArea();
		textChatLieu.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textChatLieu.getText().length() == 0) {
					lblTBChatLieu.setText("* Không để trống!");
				} else if (textChatLieu.getText().length() > 50) {
					lblTBChatLieu.setText("* Quá dài!");
				} else {
					lblTBChatLieu.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textChatLieu.getText().length() == 0) {
					lblTBChatLieu.setText("* Không để trống!");
				} else if (textChatLieu.getText().length() > 50) {
					lblTBChatLieu.setText("* Quá dài!");
				} else {
					lblTBChatLieu.setText("");
				}
			}
		});
		scrollPane_1.setViewportView(textChatLieu);

		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setBounds(24, 261, 77, 13);
		panelThongTinSanPham.add(lblGioiTinh);

		chckbxNam = new JCheckBox("Nam");
		chckbxNam.setBackground(new Color(224, 255, 255));
		chckbxNam.setBounds(110, 257, 69, 21);
		panelThongTinSanPham.add(chckbxNam);

		chckbxNu = new JCheckBox("Nữ");
		chckbxNu.setBackground(new Color(224, 255, 255));
		chckbxNu.setBounds(189, 257, 69, 21);
		panelThongTinSanPham.add(chckbxNu);

		JLabel lblKichThuoc = new JLabel("Kích thước:");
		lblKichThuoc.setBounds(24, 304, 77, 13);
		panelThongTinSanPham.add(lblKichThuoc);

		comboKichThuoc = new JComboBox();
		comboKichThuoc.setBackground(new Color(255, 255, 255));
		comboKichThuoc.setModel(
				new DefaultComboBoxModel(new String[] { "XS", "S", "M", "L", "XL", "XXL", "XXXL", "FreeSize" }));
		comboKichThuoc.setBounds(110, 300, 148, 21);
		panelThongTinSanPham.add(comboKichThuoc);

		JLabel lblMauSac = new JLabel("Màu sắc:");
		lblMauSac.setBounds(274, 220, 77, 13);
		panelThongTinSanPham.add(lblMauSac);

		textMauSac = new JTextField();
		textMauSac.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textMauSac.getText().length() == 0) {
					lblTBMauSac.setText("* Không để trống!");
				} else if (textMauSac.getText().length() > 50) {
					lblTBMauSac.setText("* Quá dài!");
				} else {
					lblTBMauSac.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textMauSac.getText().length() == 0) {
					lblTBMauSac.setText("* Không để trống!");
				} else if (textMauSac.getText().length() > 50) {
					lblTBMauSac.setText("* Quá dài!");
				} else {
					lblTBMauSac.setText("");
				}
			}
		});
		textMauSac.setBounds(382, 217, 155, 19);
		panelThongTinSanPham.add(textMauSac);
		textMauSac.setColumns(10);

		lblHinhAnh = new JLabel();
		lblHinhAnh.setBounds(38, 21, 207, 185);
		lblHinhAnh.setIcon(ResizeImage(""));
		// System.out.println(lblHinhAnh.getText());
		panelThongTinSanPham.add(lblHinhAnh);

		JButton btnHinhAnh = new JButton("Chọn hình");
		btnHinhAnh.setBackground(new Color(255, 240, 245));

		btnHinhAnh.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					lblHinhAnh.setIcon(ResizeImage(path));
					lblHinhAnh.setText(path);
				}
			}
		});
		btnHinhAnh.setBounds(58, 216, 155, 21);
		panelThongTinSanPham.add(btnHinhAnh);

		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setBounds(274, 261, 77, 13);
		panelThongTinSanPham.add(lblSoLuong);

		textSoLuong = new JTextField();
		textSoLuong.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textSoLuong.getText().length() == 0) {
					lblTBSoLuong.setText("* Không để trống!");
				} else if (textSoLuong.getText().length() > 10) {
					lblTBSoLuong.setText("* Quá dài!");
				} else if (!textSoLuong.getText().matches("[\\d]+")) {
					lblTBSoLuong.setText("* Chỉ nhập số!");
				} else {
					lblTBSoLuong.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textSoLuong.getText().length() == 0) {
					lblTBSoLuong.setText("* Không để trống!");
				} else if (textSoLuong.getText().length() > 10) {
					lblTBSoLuong.setText("* Quá dài!");
				} else if (!textSoLuong.getText().matches("[\\d]+")) {
					lblTBSoLuong.setText("* Chỉ nhập số!");
				} else {
					lblTBSoLuong.setText("");
				}
			}
		});
		textSoLuong.setBounds(382, 258, 155, 19);
		panelThongTinSanPham.add(textSoLuong);
		textSoLuong.setColumns(10);

		JLabel lblGiamGia = new JLabel("Giảm giá:");
		lblGiamGia.setBounds(274, 304, 91, 13);
		panelThongTinSanPham.add(lblGiamGia);

		textGiamGia = new JTextField();
		textGiamGia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textGiamGia.getText().length() == 0) {
					lblTBGiamGia.setText("* Không để trống!");
				} else if (textGiamGia.getText().length() > 10) {
					lblTBGiamGia.setText("* Quá dài!");
				} else if (!textGiamGia.getText().matches("[\\d.]+")) {
					lblTBGiamGia.setText("* Chỉ nhập số!");
				} else {
					lblTBGiamGia.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textGiamGia.getText().length() == 0) {
					lblTBGiamGia.setText("* Không để trống!");
				} else if (textGiamGia.getText().length() > 10) {
					lblTBGiamGia.setText("* Quá dài!");
				} else if (!textGiamGia.getText().matches("[\\d.]+")) {
					lblTBGiamGia.setText("* Chỉ nhập số!");
				} else {
					lblTBGiamGia.setText("");
				}
			}
		});
		textGiamGia.setBounds(382, 301, 155, 19);
		panelThongTinSanPham.add(textGiamGia);
		textGiamGia.setColumns(10);

		JLabel lblGiaNhap = new JLabel("Giá nhập:");
		lblGiaNhap.setBounds(24, 344, 69, 13);
		panelThongTinSanPham.add(lblGiaNhap);

		textGiaNhap = new JTextField();
		textGiaNhap.setBounds(110, 341, 148, 19);
		panelThongTinSanPham.add(textGiaNhap);
		textGiaNhap.setColumns(10);

		textGiaNhap.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textGiaNhap.getText().length() == 0) {
					lblTBGiaNhap.setText("* Không để trống!");
				} else if (textGiaNhap.getText().length() > 10) {
					lblTBGiaNhap.setText("* Quá dài!");
				} else if (!textGiaNhap.getText().matches("[\\d.]+")) {
					lblTBGiaNhap.setText("* Chỉ nhập số!");
				} else {
					lblTBGiaNhap.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textGiaNhap.getText().length() == 0) {
					lblTBGiaNhap.setText("* Không để trống!");
				} else if (textGiaNhap.getText().length() > 10) {
					lblTBGiaNhap.setText("* Quá dài!");
				} else if (!textGiaNhap.getText().matches("[\\d.]+")) {
					lblTBGiaNhap.setText("* Chỉ nhập số!");
				} else {
					lblTBGiaNhap.setText("");
				}
			}
		});

		textGiaNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textGiaNhap.getText().length() > 0 && textGiaNhap.getText().matches("[\\d.]+")) {

					// Double giaBan = Double.valueOf(textGiaNhap.getText()) * 5;
					// textDonGiaBan.setText(String.valueOf(giaBan));
					// tinhToan();
					lblTBGiaNhap.setText("");
				} else {
					textDonGiaBan.setText("");
					lblTBGiaNhap.setText("* Chỉ nhập số!");
				}
			}
		});

		JLabel lblDonGiaBan = new JLabel("Đơn giá bán:");
		lblDonGiaBan.setBounds(274, 344, 91, 13);
		panelThongTinSanPham.add(lblDonGiaBan);

		textDonGiaBan = new JTextField();
		textDonGiaBan.setBackground(new Color(255, 255, 255));
		textDonGiaBan.setEditable(false);
		textDonGiaBan.setForeground(Color.BLACK);
		textDonGiaBan.setBounds(382, 341, 155, 19);
		panelThongTinSanPham.add(textDonGiaBan);
		textDonGiaBan.setColumns(10);

		JLabel lblTrangThai = new JLabel("Trạng thái kinh doanh:");
		lblTrangThai.setBounds(24, 392, 137, 13);
		panelThongTinSanPham.add(lblTrangThai);

		comboTrangThai = new JComboBox();
		comboTrangThai.setBackground(new Color(255, 255, 255));
		comboTrangThai.setModel(new DefaultComboBoxModel(new String[] { "Đang kinh doanh", "Ngừng kinh doanh" }));
		comboTrangThai.setBounds(182, 388, 230, 21);
		panelThongTinSanPham.add(comboTrangThai);

		JLabel lblTypeMedicine = new JLabel("Loại sản phẩm:");
		lblTypeMedicine.setBounds(24, 439, 122, 13);
		panelThongTinSanPham.add(lblTypeMedicine);

		comboTypeMedicine = new JComboBox();
		comboTypeMedicine.setBackground(new Color(255, 255, 255));
		comboTypeMedicine.setBounds(182, 435, 230, 21);
		panelThongTinSanPham.add(comboTypeMedicine);

		TypeMedicineService TypeMedicineService = new TypeMedicineServiceImpl();
		ArrayList<TypeMedicine> danhSachMaLoai = TypeMedicineService.getAllTypeMedicine();
		for (TypeMedicine TypeMedicine : danhSachMaLoai) {
			comboTypeMedicine.addItem(TypeMedicine.getTypeMedicineID() + " " + TypeMedicine.getTypeMedicineName());
		}

		JLabel lblNhaCungCap = new JLabel("Nhà cung cấp:");
		lblNhaCungCap.setBounds(24, 488, 108, 13);
		panelThongTinSanPham.add(lblNhaCungCap);

		comboNhaCungCap = new JComboBox();
		comboNhaCungCap.setBackground(new Color(255, 255, 255));
		comboNhaCungCap.setBounds(182, 484, 230, 21);
		panelThongTinSanPham.add(comboNhaCungCap);

		NhaCungCapSerVice nhaCungCapService = new NhaCungCapServiceIml();
		ArrayList<NhaCungCap> danhSachMaNhaCungCap = nhaCungCapService.getTatCaNhaCungCap();
		for (NhaCungCap nhaCungCap : danhSachMaNhaCungCap) {
			comboNhaCungCap.addItem(nhaCungCap.getMaNhaCungCap() + " " + nhaCungCap.getTenNhaCungCap());
		}

		JButton btnThemTypeMedicine = new JButton("+");
		btnThemTypeMedicine.setBackground(new Color(255, 240, 245));
		btnThemTypeMedicine.setBounds(434, 435, 85, 21);
		panelThongTinSanPham.add(btnThemTypeMedicine);

		btnThemTypeMedicine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Form_Loai_San_Pham().show();
			}
		});

		JButton btnThemNhaCungCap = new JButton("+");
		btnThemNhaCungCap.setBackground(new Color(255, 240, 245));
		btnThemNhaCungCap.setBounds(434, 484, 85, 21);
		panelThongTinSanPham.add(btnThemNhaCungCap);

		lblTBMaSanPham = new JLabel("");
		lblTBMaSanPham.setForeground(Color.RED);
		lblTBMaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBMaSanPham.setBounds(382, 39, 155, 19);
		panelThongTinSanPham.add(lblTBMaSanPham);

		lblTBTenSanPham = new JLabel("");
		lblTBTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBTenSanPham.setForeground(Color.RED);
		lblTBTenSanPham.setBounds(382, 80, 155, 19);
		panelThongTinSanPham.add(lblTBTenSanPham);

		lblTBMoTa = new JLabel("");
		lblTBMoTa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBMoTa.setForeground(Color.RED);
		lblTBMoTa.setBounds(382, 137, 155, 19);
		panelThongTinSanPham.add(lblTBMoTa);

		lblTBChatLieu = new JLabel("");
		lblTBChatLieu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBChatLieu.setForeground(Color.RED);
		lblTBChatLieu.setBounds(382, 194, 155, 19);
		panelThongTinSanPham.add(lblTBChatLieu);

		lblTBMauSac = new JLabel("");
		lblTBMauSac.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBMauSac.setForeground(Color.RED);
		lblTBMauSac.setBounds(382, 235, 155, 19);
		panelThongTinSanPham.add(lblTBMauSac);

		lblTBSoLuong = new JLabel("");
		lblTBSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBSoLuong.setForeground(Color.RED);
		lblTBSoLuong.setBounds(382, 278, 155, 19);
		panelThongTinSanPham.add(lblTBSoLuong);

		lblTBGiamGia = new JLabel("");
		lblTBGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBGiamGia.setForeground(Color.RED);
		lblTBGiamGia.setBounds(382, 318, 155, 19);
		panelThongTinSanPham.add(lblTBGiamGia);

		lblTBGioiTinh = new JLabel("");
		lblTBGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBGioiTinh.setForeground(Color.RED);
		lblTBGioiTinh.setBounds(110, 277, 148, 19);
		panelThongTinSanPham.add(lblTBGioiTinh);

		lblTBGiaNhap = new JLabel("");
		lblTBGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBGiaNhap.setForeground(Color.RED);
		lblTBGiaNhap.setBounds(110, 359, 148, 19);
		panelThongTinSanPham.add(lblTBGiaNhap);

		lblTBHinhAnh = new JLabel("");
		lblTBHinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBHinhAnh.setForeground(Color.RED);
		lblTBHinhAnh.setBounds(58, 235, 155, 19);
		panelThongTinSanPham.add(lblTBHinhAnh);

		lblTBGiaBan = new JLabel("");
		lblTBGiaBan.setForeground(Color.RED);
		lblTBGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBGiaBan.setBounds(382, 359, 155, 19);
		panelThongTinSanPham.add(lblTBGiaBan);

		btnThemNhaCungCap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Form_Nha_Cung_Cap().show();
			}
		});

		JPanel panelDanhSachSanPam = new JPanel(new BorderLayout());
		panelDanhSachSanPam.setBackground(new Color(240, 255, 255));
		panelDanhSachSanPam.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelDanhSachSanPam.setBorder(
				new TitledBorder(null, "Danh sách Sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDanhSachSanPam.setBounds(663, 33, 647, 646);

		listModelSanPham = new DefaultListModel<Phong>();
		listSanPham = new JList<Phong>(listModelSanPham);
		listSanPham.setBackground(new Color(240, 255, 255));
		JScrollPane scrollSP = new JScrollPane(listSanPham);
		panelDanhSachSanPam.add(scrollSP, BorderLayout.CENTER);
		contentPane.add(panelDanhSachSanPam);

		listSanPham.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				isSelected();
			}
		});

		createListSanPham();

		JPanel panelChucNang = new JPanel();
		panelChucNang.setBackground(new Color(240, 255, 255));
		panelChucNang.setBounds(69, 572, 571, 107);
		contentPane.add(panelChucNang);
		panelChucNang.setLayout(null);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(255, 240, 245));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaSanPham();
			}
		});
		btnXoa.setBounds(351, 10, 100, 30);
		panelChucNang.add(btnXoa);

		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(255, 240, 245));
		btnSua.setBounds(461, 10, 100, 30);
		panelChucNang.add(btnSua);

		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				suaLoaiSanPam();
			}
		});

		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setBackground(new Color(255, 240, 245));
		btnXoaRong.setBounds(351, 50, 100, 30);
		panelChucNang.add(btnXoaRong);

		btnXoaRong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource().equals(btnXoaRong)) {
					xoaRong();
				}
			}
		});

		JButton btnHoanTac = new JButton("Hoàn tác");
		btnHoanTac.setBackground(new Color(255, 240, 245));
		btnHoanTac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isSelected();
			}
		});
		btnHoanTac.setBounds(461, 50, 100, 30);
		panelChucNang.add(btnHoanTac);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(255, 240, 245));
		btnThem.setBounds(234, 10, 100, 30);
		panelChucNang.add(btnThem);
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (kiemTraDuLieu()) {
					themSanPham();
					xoaRong();
				}

			}
		});

		btnNhapExcel = new JButton("Nhập Excel");
		btnNhapExcel.setBackground(new Color(255, 240, 245));
		btnNhapExcel.setBounds(234, 50, 100, 30);
		panelChucNang.add(btnNhapExcel);

		btnNhapExcel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Excel", "xls", "xlsx");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					try {
						if (sanPhamservice.themSanPhamTuExcel(new File(path))) {
							createListSanPham();
							JOptionPane.showMessageDialog(null, "Nhập thành công!!!");
						} else {
							JOptionPane.showMessageDialog(null, "Nhập thất bại!!!");
						}
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		JComboBox<String> comboLocTypeMedicine = new JComboBox<String>();
		comboLocTypeMedicine.setBackground(new Color(255, 255, 255));
		comboLocTypeMedicine.setBounds(663, 10, 186, 20);
		contentPane.add(comboLocTypeMedicine);
		comboLocTypeMedicine.setModel(new DefaultComboBoxModel<String>(new String[] { "Tất cả" }));

		for (TypeMedicine TypeMedicine : danhSachMaLoai) {
			comboLocTypeMedicine.addItem(TypeMedicine.getTypeMedicineName());
		}

		comboLocTypeMedicine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (comboLocTypeMedicine.getSelectedItem().toString().equals("Tất cả")) {
					createListSanPham();
				} else {
					String tenLoai = comboLocTypeMedicine.getSelectedItem().toString();
					createListSanPhamTheoLoai(tenLoai);
				}
			}
		});

		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.setBackground(new Color(255, 240, 245));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setBounds(1210, 10, 100, 20);
		contentPane.add(btnTim);

		textTimKiem = new JTextField();
		textTimKiem.setBounds(993, 11, 207, 20);
		contentPane.add(textTimKiem);
		textTimKiem.setColumns(10);

		btnTim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String key = textTimKiem.getText().trim();
				timKiemSanPham(keyword);
			}
		});

		textGiaNhap.addKeyListener(this);

	}

	private ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}

	private void createListSanPham() {
		listModelSanPham.clear();
		ArrayList<Phong> danhSachSanPham = sanPhamservice.getTatCaSanPham();
		for (Phong sanPham : danhSachSanPham) {
			listModelSanPham.addElement(sanPham);
		}
		listSanPham.setModel(listModelSanPham);
		listSanPham.setCellRenderer(new SanPhamRenDerer());
	}

	private void createListSanPhamTheoLoai(String tenLoai) {
		listModelSanPham.clear();
		ArrayList<Phong> danhSachSanPham = sanPhamservice.timKiemSanPhamTheoLoai(tenLoai);
		for (Phong sanPham : danhSachSanPham) {
			listModelSanPham.addElement(sanPham);
		}
		listSanPham.setModel(listModelSanPham);
		listSanPham.setCellRenderer(new SanPhamRenDerer());
	}

	private void timKiemSanPham(String keyword) {
		listModelSanPham.clear();
		if (keyword.trim().equals("")) {
			createListSanPham();
		} else {
			ArrayList<Phong> danhSachSanPham = sanPhamservice.timKiemSanPham(keyword);
			for (Phong sanPham : danhSachSanPham) {
				listModelSanPham.addElement(sanPham);
			}
			listSanPham.setModel(listModelSanPham);
			listSanPham.setCellRenderer(new SanPhamRenDerer());
		}
	}

	private void themSanPham() {
		if (kiemTraDuLieu()) {
			String maSanPham = textMaSanPham.getText().trim();
			String tenSanPham = textTenSanPham.getText().trim();
			TypeMedicine TypeMedicine = new TypeMedicine(layMa(comboTypeMedicine.getSelectedItem().toString()));
			double donGia = Double.parseDouble(textDonGiaBan.getText().trim());
			String trangThai = comboTrangThai.getSelectedItem().toString();
			int soLuong = Integer.parseInt(textSoLuong.getText().trim());
			String moTa = textMoTa.getText().trim();
			String mauSac = textMauSac.getText().trim();
			String kichThuoc = comboKichThuoc.getSelectedItem().toString();
			String gioiTinh = "";
			if (chckbxNam.isSelected()) {
				gioiTinh += "Nam";
			}
			if (chckbxNu.isSelected()) {
				gioiTinh += "Nữ";
			}
			String hinhAnh = lblHinhAnh.getText().trim();
			String chatLieu = textChatLieu.getText().trim();
			NhaCungCap nhaCungCap = new NhaCungCap(layMa(comboNhaCungCap.getSelectedItem().toString()));
			double giamGia = Double.parseDouble(textGiamGia.getText().trim());
			double giaNhap = Double.parseDouble(textGiaNhap.getText().trim());
			if (maSanPham.equals("") || maSanPham.equals("Tự động khi để trống")) {
				maSanPham = taoMaTuDong();
			}
			Phong sanPham = new Phong();
			sanPham.setMaSanPham(maSanPham);
			sanPham.setTenSanPham(tenSanPham);
			sanPham.setTypeMedicine(TypeMedicine);
			sanPham.setDonGia(donGia);
			sanPham.setTrangThai(trangThai);
			sanPham.setSoLuong(soLuong);
			sanPham.setMota(moTa);
			sanPham.setMauSac(mauSac);
			sanPham.setKichThuoc(kichThuoc);
			sanPham.setGioiTinh(gioiTinh);
			sanPham.setHinhAnh(hinhAnh);
			sanPham.setChatLieu(chatLieu);
			sanPham.setNhaCungCap(nhaCungCap);
			sanPham.setGiamGia(giamGia);
			sanPham.setGiaNhap(giaNhap);
			if (!sanPhamservice.getTatCaSanPham().contains(sanPham)) {
				sanPhamservice.themSanPham(sanPham);
				createListSanPham();
				xoaRong();
			} else {
				JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại!");
			}
		}
	}

	private void xoaSanPham() {
		if (listSanPham.getSelectedIndex() != -1) {
			int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa!", JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				sanPhamservice.xoaSanPham(listSanPham.getSelectedValue().getMaSanPham());
				createListSanPham();
				xoaRong();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Phải chọn sản phẩm!");
		}
	}

	private void suaLoaiSanPam() {
		if (listSanPham.getSelectedIndex() != -1) {
			int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật?", "Cập nhật!",
					JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				if (kiemTraDuLieu()) {
					String maSanPham = textMaSanPham.getText().trim();
					String tenSanPham = textTenSanPham.getText().trim();
					TypeMedicine TypeMedicine = new TypeMedicine(layMa(comboTypeMedicine.getSelectedItem().toString()));
					double donGia = Double.parseDouble(textDonGiaBan.getText().trim());
					String trangThai = comboTrangThai.getSelectedItem().toString();
					int soLuong = Integer.parseInt(textSoLuong.getText().trim());
					String moTa = textMoTa.getText().trim();
					String mauSac = textMauSac.getText().trim();
					String kichThuoc = comboKichThuoc.getSelectedItem().toString();
					String gioiTinh = "";
					if (chckbxNam.isSelected()) {
						gioiTinh += "Nam";
					}
					if (chckbxNu.isSelected()) {
						gioiTinh += "Nữ";
					}
					String hinhAnh = lblHinhAnh.getText().trim();
					String chatLieu = textChatLieu.getText().trim();
					NhaCungCap nhaCungCap = new NhaCungCap(layMa(comboNhaCungCap.getSelectedItem().toString()));
					double giamGia = Double.parseDouble(textGiamGia.getText().trim());
					double giaNhap = Double.parseDouble(textGiaNhap.getText().trim());
					if (maSanPham.equals("") || maSanPham.equals("Tự động khi để trống")) {
						maSanPham = taoMaTuDong();
					}
					Phong sanPham = new Phong();
					sanPham.setMaSanPham(maSanPham);
					sanPham.setTenSanPham(tenSanPham);
					sanPham.setTypeMedicine(TypeMedicine);
					sanPham.setDonGia(donGia);
					sanPham.setTrangThai(trangThai);
					sanPham.setSoLuong(soLuong);
					sanPham.setMota(moTa);
					sanPham.setMauSac(mauSac);
					sanPham.setKichThuoc(kichThuoc);
					sanPham.setGioiTinh(gioiTinh);
					sanPham.setHinhAnh(hinhAnh);
					sanPham.setChatLieu(chatLieu);
					sanPham.setNhaCungCap(nhaCungCap);
					sanPham.setGiamGia(giamGia);
					sanPham.setGiaNhap(giaNhap);
					sanPhamservice.capNhatSanPham(sanPham);
					createListSanPham();
					xoaRong();
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Phải chọn sản phẩm!");
		}
	}

	private void xoaRong() {
		// lblHinhAnh.setIcon(ResizeImage("C:/Users/trong/Downloads/Compressed/"
		// +
		// "QuanLyCuaHangQuanAo-master/QuanLyCuaHangQuanAo-master/HinhAnh/icon/iconSanPham.png"));
		textMaSanPham.setText("Tự động khi để trống");
		textMaSanPham.setEditable(true);
		textMaSanPham.setForeground(new Color(153, 153, 153));
		textTenSanPham.setText("");
		textMoTa.setText("");
		textChatLieu.setText("");
		textMauSac.setText("");
		textSoLuong.setText("");
		textGiamGia.setText("");
		textGiaNhap.setText("");
		textDonGiaBan.setText("");
		comboTrangThai.setSelectedIndex(0);
		chckbxNam.setSelected(false);
		chckbxNu.setSelected(false);
		comboKichThuoc.setSelectedIndex(0);
		comboTypeMedicine.setSelectedIndex(0);
		comboNhaCungCap.setSelectedIndex(0);
		textMaSanPham.requestFocus();

		lblTBMaSanPham.setText("");
		lblTBTenSanPham.setText("");
		lblTBMoTa.setText("");
		lblTBChatLieu.setText("");
		lblTBMauSac.setText("");
		lblTBSoLuong.setText("");
		lblTBGiamGia.setText("");
		lblTBHinhAnh.setText("");
		lblTBGioiTinh.setText("");
		lblTBGiaNhap.setText("");
		lblTBGiaBan.setText("");
		lblHinhAnh.setIcon(ResizeImage(""));
		lblHinhAnh.setText("");
	}

	private void isSelected() {
		if (listSanPham.getSelectedValue() != null) {
			String maSanPham = listSanPham.getSelectedValue().getMaSanPham();
			Phong sanPham = sanPhamservice.timSanPhamTheoMa(maSanPham);
			textMaSanPham.setText(sanPham.getMaSanPham());
			textMaSanPham.setEditable(false);
			textTenSanPham.setText(sanPham.getTenSanPham());

			if (sanPham.getTypeMedicine() != null) {
				comboTypeMedicine.setSelectedItem(
						sanPham.getTypeMedicine().getTypeMedicineID() + " "
								+ sanPham.getTypeMedicine().getTypeMedicineName());
			}
			textDonGiaBan.setText(String.valueOf(sanPham.getDonGia()));
			comboTrangThai.setSelectedItem(sanPham.getTrangThai());
			textSoLuong.setText(String.valueOf(sanPham.getSoLuong()));
			textMoTa.setText(sanPham.getMota());
			textMauSac.setText(sanPham.getMauSac());
			comboKichThuoc.setSelectedItem(sanPham.getKichThuoc());
			chckbxNam.setSelected(false);
			chckbxNu.setSelected(false);
			if (sanPham.getGioiTinh().equals("Nam")) {
				chckbxNam.setSelected(true);
			} else if (sanPham.getGioiTinh().equals("Nữ")) {
				chckbxNu.setSelected(true);
			} else if (sanPham.getGioiTinh().equals("")) {
				chckbxNam.setSelected(false);
				chckbxNu.setSelected(false);
			} else {
				chckbxNam.setSelected(true);
				chckbxNu.setSelected(true);
			}
			lblHinhAnh.setIcon(ResizeImage(sanPham.getHinhAnh()));
			lblHinhAnh.setText(sanPham.getHinhAnh());
			textChatLieu.setText(sanPham.getChatLieu());
			if (sanPham.getNhaCungCap() != null) {
				comboNhaCungCap.setSelectedItem(
						sanPham.getNhaCungCap().getMaNhaCungCap() + " " + sanPham.getNhaCungCap().getTenNhaCungCap());
			}
			textGiamGia.setText(String.valueOf(sanPham.getGiamGia()));
			textGiaNhap.setText(String.valueOf(sanPham.getGiaNhap()));
		}
	}

	private String taoMaTuDong() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime ngayNhap = LocalDateTime.now();
		String res = "SP" + formatter.format(ngayNhap);
		return res;
	}

	private static String layMa(String ma) {
		String[] tu = ma.split(" ");
		return tu[0];
	}

	private boolean kiemTraDuLieu() {
		String maSanPham = textMaSanPham.getText().trim();
		String tenSanPham = textTenSanPham.getText().trim();
		String moTa = textMoTa.getText().trim();
		String chatLieu = textChatLieu.getText().trim();
		String mauSac = textMauSac.getText().trim();
		String soLuong = textSoLuong.getText().trim();
		String giamGia = textGiamGia.getText().trim();
		String giaNhap = textGiaNhap.getText().trim();
		String giaBan = textDonGiaBan.getText().trim();

		lblTBMaSanPham.setText("");
		lblTBTenSanPham.setText("");
		lblTBMoTa.setText("");
		lblTBChatLieu.setText("");
		lblTBMauSac.setText("");
		lblTBSoLuong.setText("");
		lblTBGiamGia.setText("");
		lblTBHinhAnh.setText("");
		lblTBGioiTinh.setText("");
		lblTBGiaNhap.setText("");
		lblTBGiaBan.setText("");

		if (!maSanPham.equals("Tự động khi để trống")) {
			if (maSanPham.length() == 0) {
				lblTBMaSanPham.setText("* Không để trống!");
				return false;
			} else if (!(maSanPham.matches("SP[\\d]{1,14}") && maSanPham.length() < 20)) {
				lblTBMaSanPham.setText("* Không hợp lệ! SP***********");
				return false;
			}
		}

		if (tenSanPham.length() == 0) {
			lblTBTenSanPham.setText("* Không để trống!");
			return false;
		} else if (!(tenSanPham.matches("[\\W\\w\\s]+") && tenSanPham.length() < 50)) {
			lblTBTenSanPham.setText("* Không hợp lệ!");
			return false;
		}

		if (moTa.length() == 0) {
			lblTBMoTa.setText("* Không để trống!");
			return false;
		} else if (!(moTa.matches("[\\W\\w\\s]+") && moTa.length() < 50)) {
			lblTBMoTa.setText("* Không hợp lệ!");
			return false;
		}

		if (chatLieu.length() == 0) {
			lblTBChatLieu.setText("* Không để trống!");
			return false;
		} else if (!(chatLieu.matches("[\\W\\w\\s]+") && chatLieu.length() < 50)) {
			lblTBChatLieu.setText("* Không hợp lệ!");
			return false;
		}

		if (mauSac.length() == 0) {
			lblTBMauSac.setText("* Không để trống!");
			return false;
		} else if (!(mauSac.matches("[\\W\\w\\s]+") && mauSac.length() < 50)) {
			lblTBMauSac.setText("* Không hợp lệ!");
			return false;
		}

		if (soLuong.length() == 0) {
			lblTBSoLuong.setText("* Không để trống!");
			return false;
		} else if (!(soLuong.matches("[\\d]+") && soLuong.length() < 10)) {
			lblTBSoLuong.setText("* Chỉ nhập số!");
			return false;
		}

		if (giamGia.length() == 0) {
			lblTBGiamGia.setText("* Không để trống!");
			return false;
		} else if (!(giamGia.matches("[\\d.]+") && giamGia.length() < 10)) {
			lblTBGiamGia.setText("* Chỉ nhập số!");
			return false;
		}
		if (lblHinhAnh.getText().equals("") || lblHinhAnh == null) {
			lblTBHinhAnh.setText("* Chọn hình!");
			return false;
		}
		if (chckbxNam.isSelected() == false && chckbxNu.isSelected() == false) {
			lblTBGioiTinh.setText("* Chọn giới tính!");
			return false;
		}

		if (giaNhap.length() == 0) {
			lblTBGiaNhap.setText("* Không để trống!");
			return false;
		} else if (!(giaNhap.matches("[\\d.]+") && giaNhap.length() < 20)) {
			lblTBGiaNhap.setText("* Chỉ nhập số!");
			return false;
		}

		if (giaBan.length() == 0) {
			lblTBGiaBan.setText("Enter Giá nhập!");
			return false;
		}
		return true;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Object o = e.getSource();
		if (o.equals(textGiaNhap)) {
			if (e.getKeyChar() >= 'a' & e.getKeyChar() <= 'z') {
				String s = textGiaNhap.getText();
				s = s.substring(0, s.length() - 1);
				textGiaNhap.setText(s);
			}
			tinhToan();
		}
	}

	public void tinhToan() {
		double giaNhap = 0;
		giaNhap = (double) Math.round((Double.parseDouble(textGiaNhap.getText()) * 10) / 10) * 5;

		textDonGiaBan.setText(Double.toString(giaNhap));
	}
}
