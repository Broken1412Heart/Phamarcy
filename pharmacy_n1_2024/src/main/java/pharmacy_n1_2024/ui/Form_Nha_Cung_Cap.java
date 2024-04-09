package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import esp.NhaCungCapSerVice;
import esp.NhaCungCapServiceIml;
import connectDB.ConnectDataBase;
import entity.NhaCungCap;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Form_Nha_Cung_Cap extends JFrame {

	private JPanel contentPane;
	private JTextField textMaNhaCungCap;
	private JTextField textTenNhaCungCap;
	private JTextField textDiaChi;
	private JDateChooser dateNgayHopTac;
	private JTextField textSoDienThoai;
	private JTextField textEmail;
	private JTextField textTimKiem;
	private JPanel panelNhaCungCap;
	private JTable tableDanhSachNhaCungCap;
	private DefaultTableModel modelNhaCungCap;

	private NhaCungCapSerVice nhaCungCapSerVice = new NhaCungCapServiceIml();
	private JLabel lblTBMaNhaCungCap;
	private JLabel lblTBTenNhaCungCap;
	private JLabel lblTBNgayHopTac;
	private JLabel lblTBDiaChi;
	private JLabel lblTBSoDienThoai;
	private JLabel lblTBEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Nha_Cung_Cap frame = new Form_Nha_Cung_Cap();
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
	public Form_Nha_Cung_Cap() {

		try {
			ConnectDataBase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 518);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelNhaCungCap = new JPanel();
		panelNhaCungCap.setBackground(new Color(240, 255, 255));
		panelNhaCungCap.setBorder(
				new TitledBorder(null, "Nh\u00E0 cung c\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNhaCungCap.setBounds(29, 50, 303, 303);
		contentPane.add(panelNhaCungCap);
		panelNhaCungCap.setLayout(null);

		JLabel lblMaNhaCungCap = new JLabel("Mã nhà cung cấp:");
		lblMaNhaCungCap.setBounds(10, 26, 142, 13);
		panelNhaCungCap.add(lblMaNhaCungCap);

		textMaNhaCungCap = new JTextField();
		textMaNhaCungCap.setBackground(Color.WHITE);
		textMaNhaCungCap.setBounds(125, 23, 149, 19);
		textMaNhaCungCap.setText("Tự động khi để trống");
		textMaNhaCungCap.setForeground(new Color(153, 153, 153));
		panelNhaCungCap.add(textMaNhaCungCap);
		textMaNhaCungCap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textMaNhaCungCap.getText().equals("Tự động khi để trống")) {
					textMaNhaCungCap.setText("");
					textMaNhaCungCap.setForeground(new Color(0, 0, 0));
				}
			}
		});
		textMaNhaCungCap.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textMaNhaCungCap.getText().equals("Tự động khi để trống")) {
					textMaNhaCungCap.setText("Tự động khi để trống");
					textMaNhaCungCap.setForeground(new Color(153, 153, 153));
				} else if (!textMaNhaCungCap.getText().matches("NCC[\\d]{1,14}")) {
					lblTBMaNhaCungCap.setText("* Không hợp lệ! NCC***********!");
					if (textMaNhaCungCap.getText().equals("Tự động khi để trống")) {
						lblTBMaNhaCungCap.setText("");
					}
				} else {
					lblTBMaNhaCungCap.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textMaNhaCungCap.getText().equals("")) {
					textMaNhaCungCap.setText("Tự động khi để trống");
					textMaNhaCungCap.setForeground(new Color(153, 153, 153));
				} else if (!textMaNhaCungCap.getText().matches("NCC[\\d]{1,14}")) {
					lblTBMaNhaCungCap.setText("* Không hợp lệ! NCC***********!");
					if (textMaNhaCungCap.getText().equals("Tự động khi để trống")) {
						lblTBMaNhaCungCap.setText("");
					}
				} else {
					lblTBMaNhaCungCap.setText("");
				}
			}
		});
		textMaNhaCungCap.setColumns(10);

		JLabel lblTenNhaCungCap = new JLabel("Tên nhà cung cấp:");
		lblTenNhaCungCap.setBounds(10, 63, 142, 13);
		panelNhaCungCap.add(lblTenNhaCungCap);

		textTenNhaCungCap = new JTextField();
		textTenNhaCungCap.setBackground(Color.WHITE);
		textTenNhaCungCap.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textTenNhaCungCap.getText().length() == 0) {
					lblTBTenNhaCungCap.setText("* Không để trống!");
				} else if (textTenNhaCungCap.getText().length() > 50) {
					lblTBTenNhaCungCap.setText("* Quá dài!");
				} else {
					lblTBTenNhaCungCap.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textTenNhaCungCap.getText().length() == 0) {
					lblTBTenNhaCungCap.setText("* Không để trống!");
				} else if (textTenNhaCungCap.getText().length() > 50) {
					lblTBTenNhaCungCap.setText("* Quá dài!");
				} else {
					lblTBTenNhaCungCap.setText("");
				}
			}
		});
		textTenNhaCungCap.setBounds(125, 60, 149, 19);
		panelNhaCungCap.add(textTenNhaCungCap);
		textTenNhaCungCap.setColumns(10);

		JLabel lblNgayHopTac = new JLabel("Ngày hợp tác:");
		lblNgayHopTac.setBounds(10, 98, 142, 13);
		panelNhaCungCap.add(lblNgayHopTac);

		dateNgayHopTac = new JDateChooser();
		dateNgayHopTac.setBackground(Color.WHITE);
		dateNgayHopTac.setBounds(125, 98, 149, 19);
		dateNgayHopTac.setDate(Date.valueOf(LocalDate.now()));
		panelNhaCungCap.add(dateNgayHopTac);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(10, 140, 98, 13);
		panelNhaCungCap.add(lblDiaChi);

		textDiaChi = new JTextField();
		textDiaChi.setBackground(Color.WHITE);
		textDiaChi.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textDiaChi.getText().length() == 0) {
					lblTBDiaChi.setText("* Không để trống!");
				} else if (textDiaChi.getText().length() > 50) {
					lblTBDiaChi.setText("* Quá dài!");
				} else {
					lblTBDiaChi.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textDiaChi.getText().length() == 0) {
					lblTBDiaChi.setText("* Không để trống!");
				} else if (textDiaChi.getText().length() > 50) {
					lblTBDiaChi.setText("* Quá dài!");
				} else {
					lblTBDiaChi.setText("");
				}
			}
		});
		textDiaChi.setBounds(125, 137, 149, 19);
		panelNhaCungCap.add(textDiaChi);
		textDiaChi.setColumns(10);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setBounds(10, 182, 98, 13);
		panelNhaCungCap.add(lblSoDienThoai);

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
		textSoDienThoai.setBounds(125, 179, 149, 19);
		panelNhaCungCap.add(textSoDienThoai);
		textSoDienThoai.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 225, 98, 13);
		panelNhaCungCap.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBackground(Color.WHITE);
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
		textEmail.setBounds(125, 222, 149, 19);
		panelNhaCungCap.add(textEmail);
		textEmail.setColumns(10);

		lblTBMaNhaCungCap = new JLabel("");
		lblTBMaNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBMaNhaCungCap.setForeground(Color.RED);
		lblTBMaNhaCungCap.setBounds(125, 41, 149, 19);
		panelNhaCungCap.add(lblTBMaNhaCungCap);

		lblTBTenNhaCungCap = new JLabel("");
		lblTBTenNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBTenNhaCungCap.setForeground(Color.RED);
		lblTBTenNhaCungCap.setBounds(125, 80, 149, 19);
		panelNhaCungCap.add(lblTBTenNhaCungCap);

		lblTBNgayHopTac = new JLabel("");
		lblTBNgayHopTac.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBNgayHopTac.setForeground(Color.RED);
		lblTBNgayHopTac.setBounds(125, 115, 149, 19);
		panelNhaCungCap.add(lblTBNgayHopTac);

		lblTBDiaChi = new JLabel("");
		lblTBDiaChi.setForeground(Color.RED);
		lblTBDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBDiaChi.setBounds(125, 155, 149, 19);
		panelNhaCungCap.add(lblTBDiaChi);

		lblTBSoDienThoai = new JLabel("");
		lblTBSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBSoDienThoai.setForeground(Color.RED);
		lblTBSoDienThoai.setBounds(125, 199, 149, 19);
		panelNhaCungCap.add(lblTBSoDienThoai);

		lblTBEmail = new JLabel("");
		lblTBEmail.setForeground(Color.RED);
		lblTBEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBEmail.setBounds(125, 243, 149, 19);
		panelNhaCungCap.add(lblTBEmail);

		JPanel panelChucNang = new JPanel();
		panelChucNang.setBackground(new Color(240, 255, 255));
		panelChucNang.setBounds(29, 379, 303, 92);
		contentPane.add(panelChucNang);
		panelChucNang.setLayout(null);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(255, 240, 245));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themNhaCungCap();
			}
		});
		btnThem.setBounds(10, 10, 70, 30);
		panelChucNang.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(255, 240, 245));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaNhaCungCap();
			}
		});
		btnXoa.setBounds(109, 10, 70, 30);
		panelChucNang.add(btnXoa);

		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(255, 240, 245));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaNhaCungCap();
			}
		});
		btnSua.setBounds(209, 10, 70, 30);
		panelChucNang.add(btnSua);

		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setBackground(new Color(255, 240, 245));
		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaRong();
			}
		});
		btnXoaRong.setBounds(46, 50, 90, 32);
		panelChucNang.add(btnXoaRong);

		JButton btnHoanTac = new JButton("Hoàn tác");
		btnHoanTac.setBackground(new Color(255, 240, 245));
		btnHoanTac.setBounds(160, 50, 90, 32);

		btnHoanTac.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tableDanhSachNhaCungCap.getSelectedRow();
				hoanTac(row);
			}
		});
		panelChucNang.add(btnHoanTac);

		JPanel panelDanhSach = new JPanel();
		panelDanhSach.setBackground(new Color(240, 255, 255));
		panelDanhSach.setBorder(
				new TitledBorder(null, "Danh sách Nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDanhSach.setBounds(363, 50, 510, 421);
		contentPane.add(panelDanhSach);
		panelDanhSach.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelDanhSach.add(scrollPane);

		String[] colHeader = { "STT", "Mã Nhà cung cấp", "Tên Nhà cung cấp", "Ngày hợp tác", "Địa chỉ", "Số điện thoại",
				"Email" };
		modelNhaCungCap = new DefaultTableModel(colHeader, 0);
		tableDanhSachNhaCungCap = new JTable(modelNhaCungCap);
		tableDanhSachNhaCungCap.setBackground(new Color(240, 255, 255));

		tableDanhSachNhaCungCap.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tableDanhSachNhaCungCap.getSelectedRow();
				textMaNhaCungCap.setEditable(false);
				textMaNhaCungCap.setText(modelNhaCungCap.getValueAt(row, 1).toString());
				textTenNhaCungCap.setText(modelNhaCungCap.getValueAt(row, 2).toString());
				dateNgayHopTac.setDate(Date.valueOf(modelNhaCungCap.getValueAt(row, 3).toString()));
				textDiaChi.setText(modelNhaCungCap.getValueAt(row, 4).toString());
				textSoDienThoai.setText(modelNhaCungCap.getValueAt(row, 5).toString());
				textEmail.setText(modelNhaCungCap.getValueAt(row, 6).toString());
			}
		});

		tableDanhSachNhaCungCap.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableDanhSachNhaCungCap.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableDanhSachNhaCungCap.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableDanhSachNhaCungCap.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableDanhSachNhaCungCap.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableDanhSachNhaCungCap.getColumnModel().getColumn(5).setPreferredWidth(100);
		tableDanhSachNhaCungCap.getColumnModel().getColumn(6).setPreferredWidth(100);
		tableDanhSachNhaCungCap.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(tableDanhSachNhaCungCap);

		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.setBackground(new Color(255, 240, 245));
		btnTim.setBounds(783, 20, 90, 20);
		contentPane.add(btnTim);

		textTimKiem = new JTextField();
		textTimKiem.setBackground(Color.WHITE);
		textTimKiem.setBounds(616, 21, 136, 19);
		contentPane.add(textTimKiem);
		textTimKiem.setColumns(10);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemNhaCungCap();
			}
		});

		docDuLieu();
	}

	private void docDuLieu() {
		ArrayList<NhaCungCap> danhSachNhaCungCap = nhaCungCapSerVice.getTatCaNhaCungCap();
		modelNhaCungCap.setRowCount(0);
		int sST = 0;
		for (NhaCungCap nhaCungCap : danhSachNhaCungCap) {
			sST++;
			modelNhaCungCap.addRow(new Object[] {
					sST, nhaCungCap.getMaNhaCungCap(), nhaCungCap.getTenNhaCungCap(), nhaCungCap.getNgayHopTac(),
					nhaCungCap.getDiaChi(), nhaCungCap.getSoDienThoai(), nhaCungCap.getEmail()
			});
		}
	}

	private void themNhaCungCap() {
		String maNhaCungCap = textMaNhaCungCap.getText().trim();
		String tenNhaCungCap = textTenNhaCungCap.getText().trim();
		java.util.Date date = dateNgayHopTac.getDate();
		Date dateNngayHopTac = new Date(date.getTime());
		String diaChi = textDiaChi.getText().trim();
		String soDienThoai = textSoDienThoai.getText().trim();
		String email = textEmail.getText().trim();
		if (kiemTraDuLieu()) {
			if (maNhaCungCap.equals("") || maNhaCungCap.equals("Tự động khi để trống")) {
				maNhaCungCap = taoMaTuDong();
			}
			NhaCungCap nhaCungCap = new NhaCungCap(maNhaCungCap, tenNhaCungCap, dateNngayHopTac, diaChi, soDienThoai,
					email);
			if (!(nhaCungCapSerVice.getTatCaNhaCungCap().contains(nhaCungCap))) {
				nhaCungCapSerVice.themNhaCungCap(nhaCungCap);
				docDuLieu();
				xoaRong();
			} else {
				JOptionPane.showMessageDialog(this, "Mã nhà cung cấp đã tồn tại");
			}

		}
	}

	private void xoaNhaCungCap() {
		int row = tableDanhSachNhaCungCap.getSelectedRow();
		if (row != -1) {
			int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa!", JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				String maNhaCungCap = tableDanhSachNhaCungCap.getValueAt(row, 1).toString();
				nhaCungCapSerVice.deleteSupplier(maNhaCungCap);
				xoaRong();
				docDuLieu();
				if (row < nhaCungCapSerVice.getTatCaNhaCungCap().size() - 1) {
					selectedRow(row);
				} else if (nhaCungCapSerVice.getTatCaNhaCungCap().size() > 0) {
					row = 0;
					selectedRow(row);
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Phải chọn dòng!");
		}
	}

	private void suaNhaCungCap() {
		int row = tableDanhSachNhaCungCap.getSelectedRow();
		if (row != -1) {
			int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật?", "Cập nhật!",
					JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				String maNhaCungCap = textMaNhaCungCap.getText().trim();
				String tenNhaCungCap = textTenNhaCungCap.getText().trim();
				java.util.Date date = dateNgayHopTac.getDate();
				Date dateNngayHopTac = new Date(date.getTime());
				String diaChi = textDiaChi.getText().trim();
				String soDienThoai = textSoDienThoai.getText().trim();
				String email = textEmail.getText().trim();
				NhaCungCap nhaCungCap = new NhaCungCap(maNhaCungCap, tenNhaCungCap, dateNngayHopTac, diaChi,
						soDienThoai, email);
				if (kiemTraDuLieu()) {
					nhaCungCapSerVice.updateSupplier(nhaCungCap);
					xoaRong();
					docDuLieu();
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Phải chọn dòng!");
		}
	}

	private void timKiemNhaCungCap() {
		String keyword = textTimKiem.getText().trim();
		if (keyword.equals("")) {
			docDuLieu();
		} else {
			ArrayList<NhaCungCap> danhSachNhaCungCap = nhaCungCapSerVice.searchSupplier(keyword);
			;
			modelNhaCungCap.setRowCount(0);
			int sST = 0;
			for (NhaCungCap nhaCungCap : danhSachNhaCungCap) {
				sST++;
				modelNhaCungCap.addRow(new Object[] {
						sST, nhaCungCap.getMaNhaCungCap(), nhaCungCap.getTenNhaCungCap(),
						nhaCungCap.getNgayHopTac(), nhaCungCap.getDiaChi(), nhaCungCap.getSoDienThoai(),
						nhaCungCap.getEmail()
				});
			}
		}
	}

	private void xoaRong() {
		textMaNhaCungCap.setText("Tự động khi để trống");
		textMaNhaCungCap.setEditable(true);
		textMaNhaCungCap.setForeground(new Color(153, 153, 153));
		textTenNhaCungCap.setText("");
		dateNgayHopTac.setDate(Date.valueOf(LocalDate.now()));
		textSoDienThoai.setText("");
		textDiaChi.setText("");
		textEmail.setText("");
		dateNgayHopTac.setDate(Date.valueOf(LocalDate.now()));
		textMaNhaCungCap.requestFocus();

		lblTBMaNhaCungCap.setText("");
		lblTBTenNhaCungCap.setText("");
		lblTBNgayHopTac.setText("");
		lblTBSoDienThoai.setText("");
		lblTBDiaChi.setText("");
		lblTBEmail.setText("");
	}

	private void selectedRow(int row) {
		if (row != -1) {
			tableDanhSachNhaCungCap.setRowSelectionInterval(row, row);
			tableDanhSachNhaCungCap.scrollRectToVisible(tableDanhSachNhaCungCap.getCellRect(row, row, true));
		}
	}

	private void hoanTac(int row) {
		if (row != -1) {
			tableDanhSachNhaCungCap.setRowSelectionInterval(row, row);
			tableDanhSachNhaCungCap.scrollRectToVisible(tableDanhSachNhaCungCap.getCellRect(row, row, true));
			textMaNhaCungCap.setText(modelNhaCungCap.getValueAt(row, 1).toString());
			textTenNhaCungCap.setText(modelNhaCungCap.getValueAt(row, 2).toString());
			dateNgayHopTac.setDate(Date.valueOf(modelNhaCungCap.getValueAt(row, 3).toString()));
			textDiaChi.setText(modelNhaCungCap.getValueAt(row, 4).toString());
			textSoDienThoai.setText(modelNhaCungCap.getValueAt(row, 5).toString());
			textEmail.setText(modelNhaCungCap.getValueAt(row, 6).toString());
		}
	}

	private String taoMaTuDong() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime ngayNhap = LocalDateTime.now();
		String res = "NCC" + formatter.format(ngayNhap);
		return res;
	}

	private boolean kiemTraDuLieu() {
		String maNhaCungCap = textMaNhaCungCap.getText().trim();
		String tenNhaCungCap = textTenNhaCungCap.getText().trim();
		String diaChi = textDiaChi.getText().trim();
		String ngayHopTac = dateNgayHopTac.getDate().toString();
		String soDienThoai = textSoDienThoai.getText().trim();
		String email = textEmail.getText().trim();

		lblTBMaNhaCungCap.setText("");
		lblTBTenNhaCungCap.setText("");
		lblTBDiaChi.setText("");
		lblTBNgayHopTac.setText("");
		lblTBSoDienThoai.setText("");
		lblTBEmail.setText("");

		if (!maNhaCungCap.equals("Tự động khi để trống")) {
			if (!(maNhaCungCap.length() > 0 && maNhaCungCap.length() < 20
					&& maNhaCungCap.matches("NCC[\\d]{1,14}"))) {
				lblTBMaNhaCungCap.setText("* Không hợp lệ! NCC**************");
				return false;
			}
		}
		if (!(tenNhaCungCap.length() > 0 && tenNhaCungCap.length() < 50
				&& tenNhaCungCap.matches("[\\W\\w]+"))) {
			lblTBTenNhaCungCap.setText("* Không hợp lệ!");
			return false;
		}
		if (!(ngayHopTac.length() > 0
				&& (dateNgayHopTac.getDate().before(Date.valueOf(LocalDate.now()))
						|| dateNgayHopTac.getDate().equals(Date.valueOf(LocalDate.now()))))) {
			lblTBNgayHopTac.setText("* Trước ngày hiện tại!");
			return false;
		}
		if (!(diaChi.length() > 0 && diaChi.length() < 50
				&& diaChi.matches("[\\W\\w\\s/]+"))) {
			lblTBDiaChi.setText("* Không hợp lệ!");
			return false;
		}
		if (!(soDienThoai.length() > 0 && soDienThoai.length() < 20
				&& soDienThoai.matches("(84|0[3|5|7|8|9])([0-9]{8})"))) {
			lblTBSoDienThoai.setText("* Không hợp lệ!");
			return false;
		}
		if (!(email.length() > 0 && email.length() < 50
				&& email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))) {
			lblTBEmail.setText("* Không hợp lệ!");
			return false;
		}
		return true;
	}
}
