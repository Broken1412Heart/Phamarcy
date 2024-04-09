package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import esp.ThongKeSanPhamSersvice;
import esp.ThongKeSanPhamServiceImpl;
import connectDB.ConnectDataBase;
import entity.Phong;
import java.awt.Color;

public class Form_Trang_Chu extends JFrame {

	public static JPanel contentPane;
	private JList<Phong> listSanPham;
	private DefaultListModel<Phong> listModelSanPham;
	private ThongKeSanPhamSersvice thongKeSanPhamSersvice = new ThongKeSanPhamServiceImpl();
	public static JScrollPane scrollSP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Trang_Chu frame = new Form_Trang_Chu();
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
	public Form_Trang_Chu() {
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
		// contentPane.setPreferredSize(new Dimension(200,100));
		// scrollSP = new JScrollPane(contentPane);
		// scrollSP.setBorder(null);
		// scrollSP.setPreferredSize(new Dimension(800,600));
		// getContentPane().add(scrollSP);
		setSize(1380, 780);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(new Color(240, 255, 255));
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 0, 1362, 686);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		// panel.setLayout(null);
		panel.setBorder(null);

		listModelSanPham = new DefaultListModel<Phong>();
		listSanPham = new JList<Phong>(listModelSanPham);
		listSanPham.setForeground(new Color(240, 240, 240));
		listSanPham.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listSanPham.setVisibleRowCount(0);

		panel.add(listSanPham, BorderLayout.CENTER);
		// panel.add(scrollSP, BorderLayout.EAST);
		contentPane.add(panel);

		createListSanPham();
	}

	private void createListSanPham() {
		listModelSanPham.clear();
		ArrayList<Phong> danhSachSanPham = thongKeSanPhamSersvice.get10SanPhamBanChay();
		for (Phong sanPham : danhSachSanPham) {
			listModelSanPham.addElement(sanPham);
		}

		listSanPham.setBackground(new Color(240, 255, 255));
		listSanPham.setModel(listModelSanPham);
		listSanPham.setCellRenderer(new SanPhamBanChayRenDerer());
	}
}
