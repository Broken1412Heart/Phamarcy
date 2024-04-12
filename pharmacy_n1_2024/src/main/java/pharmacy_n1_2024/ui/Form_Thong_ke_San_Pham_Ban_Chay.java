package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import esp.ThongKeSanPhamSersvice;
import esp.ThongKeSanPhamServiceImpl;
import connectDB.ConnectDataBase;
import entity.ChiTietHoaDon;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;

public class Form_Thong_ke_San_Pham_Ban_Chay extends JFrame implements ActionListener {

	public static JPanel contentPane;
	private JTextField txtNam;
	private JTable table;
	private static DefaultTableModel tablemodel;
	private ThongKeSanPhamSersvice thongKeSanPhamSersvice = new ThongKeSanPhamServiceImpl();
	private JComboBox comboBox;
	private JLabel lblTongSanPham;
	private JButton btnLoc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Thong_ke_San_Pham_Ban_Chay frame = new Form_Thong_ke_San_Pham_Ban_Chay();
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
	public Form_Thong_ke_San_Pham_Ban_Chay() {
		try {
			ConnectDataBase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1334, 56);
		panel.setBackground(new Color(255, 240, 245));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("THỐNG KÊ SẢN PHẨM BÁN CHẠY THEO THÁNG");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(467, 15, 586, 30);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(57, 67, 1241, 167);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tháng:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(107, 29, 88, 25);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Năm:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(394, 32, 88, 25);
		panel_1.add(lblNewLabel_2);

		txtNam = new JTextField();
		txtNam.setBackground(Color.WHITE);
		txtNam.setBounds(519, 32, 307, 23);
		panel_1.add(txtNam);
		txtNam.setColumns(10);

		btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLoc.addActionListener(this);
		btnLoc.setForeground(Color.BLACK);
		btnLoc.setBackground(new Color(255, 240, 245));
		btnLoc.setBounds(872, 23, 114, 33);
		panel_1.add(btnLoc);

		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);

		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.addItem("11");
		comboBox.addItem("12");
		comboBox.setMaximumRowCount(12);
		comboBox.setBounds(205, 31, 133, 25);
		panel_1.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("Tổng sản phẩm bán được:");
		lblNewLabel_3.setBounds(394, 85, 226, 20);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		lblTongSanPham = new JLabel("");
		lblTongSanPham.setBounds(643, 85, 174, 20);
		panel_1.add(lblTongSanPham);
		lblTongSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 286, 1314, 314);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setBackground(new Color(240, 255, 255));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng" }));
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 255, 255));
		panel_2.setBounds(377, 245, 582, 30);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Top 10 sản phẩm bán chạy theo tháng");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setBounds(122, 0, 393, 25);
		panel_2.add(lblNewLabel_4);
	}

	public void xoaAllDuLieuTable() {
		tablemodel = (DefaultTableModel) table.getModel();
		for (int i = tablemodel.getRowCount(); i > 0; i--) {
			tablemodel.removeRow(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLoc)) {
			try {
				xoaAllDuLieuTable();
				tinhTongSPTheoThangNam();
			} catch (Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Lỗi");
			}
		}

	}

	public void tinhTongSPTheoThangNam() {
		int thang = Integer.parseInt(comboBox.getSelectedItem().toString());
		String namNhap = txtNam.getText().trim();

		if (namNhap.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập năm");
			return;

		}
		int nam = Integer.parseInt(namNhap);
		int tongSP = thongKeSanPhamSersvice.tinhTongSanPhamBanDuocTheoThang(thang, nam);
		lblTongSanPham.setText(String.valueOf(tongSP));

		List<ChiTietHoaDon> chiTietHoaDons = thongKeSanPhamSersvice.lay10SanPhamBanChayTheoThangNam(thang, nam);
		tablemodel.setRowCount(0);
		for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDons) {
			tablemodel.addRow(new Object[] { tablemodel.getRowCount(),
					chiTietHoaDon.getSanPham().getMaSanPham(), chiTietHoaDon.getSanPham().getTenSanPham(),
					chiTietHoaDon.getSoLuong()
			});
		}
	}
}
