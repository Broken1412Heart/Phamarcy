package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import entity.Phong;

public class SanPhamRenDerer extends JPanel implements ListCellRenderer<Phong> {
	private JLabel lblHinhAnh = new JLabel();
	private JLabel lblMaSanPham = new JLabel();
	private JLabel lblTenSanPham = new JLabel();
	private JLabel lblMauSac = new JLabel();
	private JLabel lblKichThuoc = new JLabel();
	private JLabel lblDonGia = new JLabel();
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JLabel lblSoLuong;

	public SanPhamRenDerer() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 5, 0));
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setLayout(new BorderLayout(5, 5));

		lblHinhAnh = new JLabel();
		lblHinhAnh.setSize(200, 150);
		contentPane.add(lblHinhAnh, BorderLayout.WEST);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setBorder(new EmptyBorder(0, 30, 0, 0));
		panel.setLayout(new GridLayout(4, 0, 0, 0));

		lblMaSanPham = new JLabel();
		panel.add(lblMaSanPham);

		lblTenSanPham = new JLabel();
		lblTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblTenSanPham);

		panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		lblNewLabel = new JLabel("Kích thước:");
		panel_1.add(lblNewLabel);

		lblKichThuoc = new JLabel();
		panel_1.add(lblKichThuoc);

		lblNewLabel_1 = new JLabel("Màu sắc:");
		panel_1.add(lblNewLabel_1);

		lblMauSac = new JLabel();
		panel_1.add(lblMauSac);

		lblNewLabel_2 = new JLabel("Số lượng:");
		panel_1.add(lblNewLabel_2);

		lblSoLuong = new JLabel();
		panel_1.add(lblSoLuong);

		lblDonGia = new JLabel();
		lblDonGia.setForeground(new Color(255, 0, 0));
		panel.add(lblDonGia);

		add(contentPane);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Phong> list, Phong value, int index,
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		if (!(value.getHinhAnh().equals(""))) {
			lblHinhAnh.setIcon(ResizeImage(value.getHinhAnh()));
		}
		lblMaSanPham.setText(value.getMaSanPham());
		lblTenSanPham.setText(value.getTenSanPham());
		lblKichThuoc.setText(value.getKichThuoc());
		lblMauSac.setText(value.getMauSac());
		lblSoLuong.setText(String.valueOf(value.getSoLuong()));
		lblDonGia.setText(String.valueOf(value.getDonGia()));

		lblHinhAnh.setOpaque(true);
		lblMaSanPham.setOpaque(true);
		lblTenSanPham.setOpaque(true);
		lblKichThuoc.setOpaque(true);
		lblMauSac.setOpaque(true);
		lblSoLuong.setOpaque(true);
		lblDonGia.setOpaque(true);

		if (isSelected) {
			lblHinhAnh.setBackground(new Color(255, 240, 245));
			lblMaSanPham.setBackground(new Color(255, 240, 245));
			lblTenSanPham.setBackground(new Color(255, 240, 245));
			lblKichThuoc.setBackground(new Color(255, 240, 245));
			lblMauSac.setBackground(new Color(255, 240, 245));
			lblSoLuong.setBackground(new Color(255, 240, 245));
			lblDonGia.setBackground(new Color(255, 240, 245));
			contentPane.setBackground(new Color(255, 240, 245));
			panel.setBackground(new Color(255, 240, 245));
			panel_1.setBackground(new Color(255, 240, 245));
			lblNewLabel.setBackground(new Color(255, 240, 245));
			lblNewLabel_1.setBackground(new Color(255, 240, 245));
			lblNewLabel_2.setBackground(new Color(255, 240, 245));

			setBackground(list.getSelectionBackground());
		} else { // when don't select
			lblHinhAnh.setBackground(list.getBackground());
			lblMaSanPham.setBackground(list.getBackground());
			lblTenSanPham.setBackground(list.getBackground());
			lblKichThuoc.setBackground(list.getBackground());
			lblMauSac.setBackground(list.getBackground());
			lblSoLuong.setBackground(list.getBackground());
			lblDonGia.setBackground(list.getBackground());
			contentPane.setBackground(list.getBackground());
			panel.setBackground(list.getBackground());
			panel_1.setBackground(list.getBackground());
			lblNewLabel.setBackground(list.getBackground());
			lblNewLabel_1.setBackground(list.getBackground());
			lblNewLabel_2.setBackground(list.getBackground());
			setBackground(list.getBackground());
		}
		return this;
	}

	private ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
}
