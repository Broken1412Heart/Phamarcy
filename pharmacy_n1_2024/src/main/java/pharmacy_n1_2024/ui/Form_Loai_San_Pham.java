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

import esp.TypeMedicineService;
import esp.TypeMedicineServiceImpl;
import connectDB.ConnectDataBase;
import entity.TypeMedicine;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Form_Loai_San_Pham extends JFrame {

	private JPanel contentPane;
	private JTextField textMaTypeMedicine;
	private JTextField textTenTypeMedicine;
	private JTable tableDanhSachTypeMedicine;
	private JPanel panelNhaCungCap;
	private JTextField textTimKiem;
	private DefaultTableModel modelTypeMedicine;

	private TypeMedicineService TypeMedicineService = new TypeMedicineServiceImpl();
	private JLabel lblTBMaLoai;
	private JLabel lblTBTenLoai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Loai_San_Pham frame = new Form_Loai_San_Pham();
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
	public Form_Loai_San_Pham() {
		try {
			ConnectDataBase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		setBounds(100, 100, 971, 654);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelNhaCungCap = new JPanel();
		panelNhaCungCap.setBackground(new Color(240, 255, 255));
		panelNhaCungCap
				.setBorder(new TitledBorder(null, "Loại sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNhaCungCap.setBounds(31, 159, 355, 152);
		contentPane.add(panelNhaCungCap);
		panelNhaCungCap.setLayout(null);

		JLabel lblMaTypeMedicine = new JLabel("Mã Loại sản phẩm:");
		lblMaTypeMedicine.setBounds(10, 39, 142, 13);
		panelNhaCungCap.add(lblMaTypeMedicine);

		textMaTypeMedicine = new JTextField();
		textMaTypeMedicine.setBackground(Color.WHITE);
		textMaTypeMedicine.setBounds(151, 36, 149, 19);
		textMaTypeMedicine.setText("Tự động khi để trống");
		textMaTypeMedicine.setForeground(new Color(153, 153, 153));
		panelNhaCungCap.add(textMaTypeMedicine);
		textMaTypeMedicine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textMaTypeMedicine.getText().equals("Tự động khi để trống")) {
					textMaTypeMedicine.setText("");
					textMaTypeMedicine.setForeground(new Color(0, 0, 0));
				}
			}
		});
		textMaTypeMedicine.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textMaTypeMedicine.getText().equals("Tự động khi để trống")) {
					textMaTypeMedicine.setText("Tự động khi để trống");
					textMaTypeMedicine.setForeground(new Color(153, 153, 153));
				} else if (!textMaTypeMedicine.getText().matches("LSP[\\d]{1,14}")) {
					lblTBMaLoai.setText("* Không hợp lệ! LSP***********!");
					if (textMaTypeMedicine.getText().equals("Tự động khi để trống")) {
						lblTBMaLoai.setText("");
					}
				} else {
					lblTBMaLoai.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textMaTypeMedicine.getText().equals("")) {
					textMaTypeMedicine.setText("Tự động khi để trống");
					textMaTypeMedicine.setForeground(new Color(153, 153, 153));
				} else if (!textMaTypeMedicine.getText().matches("LSP[\\d]{1,14}")) {
					lblTBMaLoai.setText("* Không hợp lệ! LSP***********!");
					if (textMaTypeMedicine.getText().equals("Tự động khi để trống")) {
						lblTBMaLoai.setText("");
					}
				} else {
					lblTBMaLoai.setText("");
				}
			}
		});
		textMaTypeMedicine.setColumns(10);

		JLabel lblTenTypeMedicine = new JLabel("Tên Loại sản phẩm:");
		lblTenTypeMedicine.setBounds(10, 80, 118, 13);
		panelNhaCungCap.add(lblTenTypeMedicine);

		textTenTypeMedicine = new JTextField();
		textTenTypeMedicine.setBackground(Color.WHITE);
		textTenTypeMedicine.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textTenTypeMedicine.getText().length() == 0) {
					lblTBTenLoai.setText("* Không để trống!");
				} else if (textTenTypeMedicine.getText().length() > 50) {
					lblTBTenLoai.setText("* Quá dài!");
				} else {
					lblTBTenLoai.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textTenTypeMedicine.getText().length() == 0) {
					lblTBTenLoai.setText("* Không để trống!");
				} else if (textTenTypeMedicine.getText().length() > 50) {
					lblTBTenLoai.setText("* Quá dài!");
				} else {
					lblTBTenLoai.setText("");
				}
			}
		});
		textTenTypeMedicine.setBounds(151, 77, 149, 19);
		panelNhaCungCap.add(textTenTypeMedicine);
		textTenTypeMedicine.setColumns(10);

		lblTBMaLoai = new JLabel("");
		lblTBMaLoai.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBMaLoai.setForeground(Color.RED);
		lblTBMaLoai.setBounds(151, 54, 149, 19);
		panelNhaCungCap.add(lblTBMaLoai);

		lblTBTenLoai = new JLabel("");
		lblTBTenLoai.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTBTenLoai.setForeground(Color.RED);
		lblTBTenLoai.setBounds(151, 95, 142, 19);
		panelNhaCungCap.add(lblTBTenLoai);

		JPanel panelChucNang = new JPanel();
		panelChucNang.setBackground(new Color(240, 255, 255));
		panelChucNang.setBounds(31, 390, 355, 138);
		contentPane.add(panelChucNang);
		panelChucNang.setLayout(null);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(255, 240, 245));
		btnThem.setBounds(10, 10, 100, 30);
		panelChucNang.add(btnThem);

		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				themTypeMedicine();
			}
		});

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(255, 240, 245));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTypeMedicine();
			}
		});
		btnXoa.setBounds(120, 10, 100, 30);
		panelChucNang.add(btnXoa);

		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(255, 240, 245));
		btnSua.setBounds(230, 10, 100, 30);
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
		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaRong();
			}
		});
		btnXoaRong.setBounds(120, 64, 100, 30);
		panelChucNang.add(btnXoaRong);

		JButton btnHoanTac = new JButton("Hoàn tác");
		btnHoanTac.setBackground(new Color(255, 240, 245));
		btnHoanTac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableDanhSachTypeMedicine.getSelectedRow();
				hoanTac(row);
			}
		});
		btnHoanTac.setBounds(230, 64, 100, 30);
		panelChucNang.add(btnHoanTac);

		JPanel panelDanhSach = new JPanel();
		panelDanhSach.setBackground(new Color(240, 255, 255));
		panelDanhSach.setBorder(
				new TitledBorder(null, "Danh sách Loại sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDanhSach.setBounds(419, 64, 488, 512);
		contentPane.add(panelDanhSach);
		panelDanhSach.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelDanhSach.add(scrollPane);

		String[] colHeader = { "STT", "Mã Loại sản phẩm", "Tên Loại" };
		modelTypeMedicine = new DefaultTableModel(colHeader, 0);
		tableDanhSachTypeMedicine = new JTable(modelTypeMedicine);
		tableDanhSachTypeMedicine.setBackground(new Color(240, 255, 255));
		tableDanhSachTypeMedicine.addMouseListener(new MouseListener() {

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
				int row = tableDanhSachTypeMedicine.getSelectedRow();
				textMaTypeMedicine.setText(modelTypeMedicine.getValueAt(row, 1).toString());
				textTenTypeMedicine.setText(modelTypeMedicine.getValueAt(row, 2).toString());
				textMaTypeMedicine.setEditable(false);
			}
		});
		scrollPane.setViewportView(tableDanhSachTypeMedicine);

		scrollPane.setViewportView(tableDanhSachTypeMedicine);

		textTimKiem = new JTextField();
		textTimKiem.setBackground(Color.WHITE);
		textTimKiem.setBounds(595, 33, 179, 19);
		contentPane.add(textTimKiem);
		textTimKiem.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setBackground(new Color(255, 240, 245));
		btnTimKiem.setBounds(803, 32, 104, 21);
		contentPane.add(btnTimKiem);
		btnTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timKiemTypeMedicine();
			}
		});
		docDuLieu();
	}

	private void docDuLieu() {
		ArrayList<TypeMedicine> danhSachTypeMedicine = TypeMedicineService.getAllTypeMedicine();
		modelTypeMedicine.setRowCount(0);
		int sST = 0;
		for (TypeMedicine lSP : danhSachTypeMedicine) {
			sST++;
			modelTypeMedicine.addRow(new Object[] {
					sST, lSP.getTypeMedicineID(), lSP.getTypeMedicineName()
			});
		}
	}

	private void themTypeMedicine() {
		String maTypeMedicine = textMaTypeMedicine.getText().trim();
		String tenTypeMedicine = textTenTypeMedicine.getText().trim();
		if (kiemTraDuLieu()) {
			if (maTypeMedicine.equals("") || maTypeMedicine.equals("Tự động khi để trống")) {
				maTypeMedicine = taoMaTuDong();
			}
			TypeMedicine TypeMedicine = new TypeMedicine(maTypeMedicine, tenTypeMedicine);
			if (!TypeMedicineService.getAllTypeMedicine().contains(TypeMedicine)) {
				TypeMedicineService.themTypeMedicine(TypeMedicine);
				docDuLieu();
				xoaRong();
			} else {
				JOptionPane.showMessageDialog(this, "Mã Loại san phẩm đã tồn tại!");
			}

		}
	}

	private void xoaTypeMedicine() {
		int row = tableDanhSachTypeMedicine.getSelectedRow();
		if (row != -1) {
			int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa!", JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				String maTypeMedicine = tableDanhSachTypeMedicine.getValueAt(row, 1).toString();
				TypeMedicineService.xoaTypeMedicine(maTypeMedicine);
				xoaRong();
				docDuLieu();
				if (row < TypeMedicineService.getAllTypeMedicine().size() - 1) {
					selectedRow(row);
				} else if (TypeMedicineService.getAllTypeMedicine().size() > 0) {
					row = 0;
					selectedRow(row);
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Phải chọn dòng!");
		}
	}

	private void suaLoaiSanPam() {
		int row = tableDanhSachTypeMedicine.getSelectedRow();
		if (row != -1) {
			int ask = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật?", "Cập nhật!",
					JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				String maTypeMedicine = textMaTypeMedicine.getText();
				String tenTypeMedicine = textTenTypeMedicine.getText();
				TypeMedicine TypeMedicine = new TypeMedicine(maTypeMedicine, tenTypeMedicine);
				if (kiemTraDuLieu()) {
					TypeMedicineService.capNhatTypeMedicine(TypeMedicine);
					xoaRong();
					docDuLieu();
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Phải chọn dòng!");
		}
	}

	private void timKiemTypeMedicine() {
		String key = textTimKiem.getText().trim();
		if (keyword.equals("")) {
			docDuLieu();
		} else {
			ArrayList<TypeMedicine> danhSachTypeMedicine = TypeMedicineService.timKiemTypeMedicine(keyword);
			;
			modelTypeMedicine.setRowCount(0);
			int sST = 0;
			for (TypeMedicine lSP : danhSachTypeMedicine) {
				sST++;
				modelTypeMedicine.addRow(new Object[] {
						sST, lSP.getTypeMedicineID(), lSP.getTypeMedicineName()
				});
			}
		}
	}

	private void xoaRong() {
		textMaTypeMedicine.setText("Tự động khi để trống");
		textMaTypeMedicine.setForeground(new Color(153, 153, 153));
		textMaTypeMedicine.setEditable(true);
		textTenTypeMedicine.setText("");
		textMaTypeMedicine.requestFocus();
		lblTBMaLoai.setText("");
		lblTBTenLoai.setText("");
	}

	private void selectedRow(int row) {
		if (row != -1) {
			tableDanhSachTypeMedicine.setRowSelectionInterval(row, row);
			tableDanhSachTypeMedicine.scrollRectToVisible(tableDanhSachTypeMedicine.getCellRect(row, row, true));
		}
	}

	private void hoanTac(int row) {
		if (row != -1) {
			tableDanhSachTypeMedicine.setRowSelectionInterval(row, row);
			tableDanhSachTypeMedicine.scrollRectToVisible(tableDanhSachTypeMedicine.getCellRect(row, row, true));
			textMaTypeMedicine.setText(modelTypeMedicine.getValueAt(row, 1).toString());
			textTenTypeMedicine.setText(modelTypeMedicine.getValueAt(row, 2).toString());
		}
	}

	private String taoMaTuDong() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime ngayNhap = LocalDateTime.now();
		String res = "LSP" + formatter.format(ngayNhap);
		return res;
	}

	private boolean kiemTraDuLieu() {
		String maTypeMedicine = textMaTypeMedicine.getText().trim();
		String tenTypeMedicine = textTenTypeMedicine.getText().trim();

		lblTBMaLoai.setText("");
		lblTBTenLoai.setText("");

		if (!maTypeMedicine.equals("Tự động khi để trống")) {
			if (!(maTypeMedicine.length() > 0 && maTypeMedicine.length() < 50
					&& maTypeMedicine.matches("LSP[\\d]{1,14}"))) {
				lblTBMaLoai.setText("* Không hợp lệ! LSP**************");
				return false;
			}
		}

		if (!(tenTypeMedicine.length() > 0 && tenTypeMedicine.length() < 50
				&& tenTypeMedicine.matches("[\\W\\w\\s]+"))) {
			lblTBTenLoai.setText("* Không hợp lệ!");
			return false;
		}
		return true;
	}
}
