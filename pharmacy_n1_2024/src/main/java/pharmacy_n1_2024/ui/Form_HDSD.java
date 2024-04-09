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

import esp.HDSDService;
import esp.HDSDServiceImpl;

import entity.HDSD;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

public class Form_HDSD extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	private JList<HDSD> listHDSD;
	private DefaultListModel<HDSD> listModelHDSD;
	private HDSDService hdsdService = new HDSDServiceImpl();
	public static JScrollPane scrollHDSD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_HDSD frame = new Form_HDSD();
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
	public Form_HDSD() {
		// DAO
		// try {
		// ConnectDataBaseHDSD.getInstance().connect();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		// contentPane.setPreferredSize(new Dimension(200,100));
		// scrollHDSD = new JScrollPane(contentPane);
		// scrollHDSD.setBorder(null);
		// scrollHDSD.setPreferredSize(new Dimension(800,600));
		// getContentPane().add(scrollHDSD);
		setSize(1380, 780);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(new Color(240, 255, 255));
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 0, 1362, 686);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		// panel.setLayout(null);
		panel.setBorder(null);

		listModelHDSD = new DefaultListModel<HDSD>();
		listHDSD = new JList<HDSD>(listModelHDSD);
		listHDSD.setForeground(new Color(0, 0, 0));
		// listHDSD.setLayoutOrientation(JList.VERTICAL_WRAP);
		listHDSD.setVisibleRowCount(0);

		// panel.add(listHDSD, BorderLayout.CENTER);
		scrollHDSD = new JScrollPane(listHDSD);
		// scrollHDSD.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// scrollHDSD.setVerticalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scrollHDSD, BorderLayout.WEST);
		contentPane.add(panel);
		createListHDSD();
	}

	private void createListHDSD() {
		listModelHDSD.clear();
		ArrayList<HDSD> danhSachHDSD = hdsdService.getTatCaHuongDan();
		for (HDSD hdsd : danhSachHDSD) {
			listModelHDSD.addElement(hdsd);
			// System.out.println(hdsd);
		}

		listHDSD.setBackground(new Color(240, 255, 255));
		listHDSD.setModel(listModelHDSD);
		listHDSD.setCellRenderer(new HDSDRenDerer());
	}
}
