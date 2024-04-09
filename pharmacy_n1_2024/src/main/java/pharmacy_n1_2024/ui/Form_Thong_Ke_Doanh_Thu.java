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

import esp.ThongKeDoanhThuService;
import esp.ThongKeDoanhThuServiceImpl;
import connectDB.ConnectDataBase;
import entity.Bill;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;

public class Form_Thong_Ke_Doanh_Thu extends JFrame implements ActionListener {

	public static JPanel contentPane;
	private JTextField txtNam;
	private JTable table;
	private static DefaultTableModel tablemodel;
	private JComboBox comboBox;
	private JButton btnLoc;
	private JLabel lblTongTien;
	private ThongKeDoanhThuService thongKeDoanhThuService = new ThongKeDoanhThuServiceImpl();
	private JLabel lblTongTien2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Thong_Ke_Doanh_Thu frame = new Form_Thong_Ke_Doanh_Thu();
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
	public Form_Thong_Ke_Doanh_Thu() {
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
		panel.setBounds(0, 0, 1334, 87);
		panel.setBackground(new Color(255, 240, 245));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("THỐNG KÊ DOANH THU THEO THÁNG");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(474, 27, 586, 30);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(51, 108, 1241, 167);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tháng:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(262, 29, 88, 25);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Năm:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(600, 29, 88, 25);
		panel_1.add(lblNewLabel_2);

		txtNam = new JTextField();
		txtNam.setBackground(Color.WHITE);
		txtNam.setBounds(700, 29, 108, 23);
		panel_1.add(txtNam);
		txtNam.setColumns(10);

		btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLoc.addActionListener(this);
		btnLoc.setForeground(Color.BLACK);
		btnLoc.setBackground(new Color(255, 240, 245));
		btnLoc.setBounds(844, 23, 114, 33);
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
		comboBox.setBounds(394, 29, 133, 25);
		panel_1.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("Tổng tiền bán được:");
		lblNewLabel_3.setBounds(435, 85, 174, 20);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		lblTongTien = new JLabel("0");
		lblTongTien.setBounds(637, 85, 174, 20);
		panel_1.add(lblTongTien);
		lblTongTien.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JLabel lblNewLabel_4 = new JLabel("Tổng tiền lãi:");
		lblNewLabel_4.setBounds(435, 120, 174, 20);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		lblTongTien2 = new JLabel("0");
		lblTongTien2.setBounds(637, 120, 180, 20);
		panel_1.add(lblTongTien2);
		lblTongTien2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 286, 1314, 314);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(240, 255, 255));

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã hóa đơn", "Tên nhân viên", "Tên khách hàng", "Ngày đặt hàng", "Tổng tiền" }));
		scrollPane.setViewportView(table);
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
				tinhTongTienTheoThangNam();
			} catch (Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Lỗi");
			}
		}

	}

	public void tinhTongTienTheoThangNam() {
		int thang = Integer.parseInt(comboBox.getSelectedItem().toString());
		String namNhap = txtNam.getText().trim();

		if (namNhap.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập năm");
			return;

		}
		int nam = Integer.parseInt(namNhap);
		DecimalFormat formatTien = new DecimalFormat("###,###,### VND");
		double tongTien = thongKeDoanhThuService.tinhTongTienBanDuocTheoThang(thang, nam);
		lblTongTien.setText(formatTien.format(tongTien));
		double tongTien2 = thongKeDoanhThuService.tinhTongTienLaiTheoThang(thang, nam);
		lblTongTien2.setText(formatTien.format(tongTien2));

		List<HoaDon> hoaDons = thongKeDoanhThuService.layTatCaHoaDonTheoThangNam(thang, nam);
		tablemodel.setRowCount(0);
		for (HoaDon hoaDon : hoaDons) {
			tablemodel.addRow(new Object[] { tablemodel.getRowCount(),
					hoaDon.getMaHoaDon(), hoaDon.getNhanVien().getTenNhanVien(),
					hoaDon.getentity.Staff().getTenentity.Staff(),
					hoaDon.getNgayDat(), hoaDon.getTongTien()
			});
		}
	}
}
