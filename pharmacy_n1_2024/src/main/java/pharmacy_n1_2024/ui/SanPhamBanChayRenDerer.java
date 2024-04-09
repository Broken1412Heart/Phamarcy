package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import entity.Phong;

public class SanPhamBanChayRenDerer extends JPanel implements ListCellRenderer<Phong> {
	private JLabel lblHinhAnh = new JLabel();
	private JLabel lblTenSanPham = new JLabel();
	private JLabel lblDonGia = new JLabel();
	private JLabel lblGiamGia = new JLabel();
	private JLabel lblGiaDaGiam = new JLabel();
	private JPanel panel;
	private JPanel panel_1;
	private JPanel contentPane;
	private double tinhLaiGiamGia;
	private double giaDaGiam;

	public SanPhamBanChayRenDerer() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 5, 10));

		contentPane.setLayout(new BorderLayout(5, 5));

		lblHinhAnh = new JLabel();
		lblHinhAnh.setSize(200, 250);
		contentPane.add(lblHinhAnh, BorderLayout.NORTH);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		// panel.setBorder(new EmptyBorder(0, 30, 0, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(0, // top
				2, // left
				0, // bottom
				28) // right
		);
		// panel.setLayout(new GridLayout(3, 0, 0, 0));
		panel.setLayout(new GridLayout(0, 1));

		lblTenSanPham = new JLabel();
		lblTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblTenSanPham);

		lblGiamGia = new JLabel("5% Giảm");
		panel.add(lblGiamGia);

		panel_1 = new JPanel();
		panel.add(panel_1);
		// panel_1.setBorder(BorderFactory.createEmptyBorder(0, //top
		// 5, //left
		// 0, //bottom
		// 0) //right
		// );
		panel_1.setLayout(new GridLayout(1, 0));

		lblDonGia = new JLabel();
		// lblDonGia.setForeground(new Color(255, 0, 0));
		panel_1.add(lblDonGia);

		lblGiaDaGiam = new JLabel("175000.0");
		// lblGiaDaGiam.setForeground(new Color(255, 0, 0));
		panel_1.add(lblGiaDaGiam);

		add(contentPane);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Phong> list, Phong value, int index,
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		if (!(value.getHinhAnh().equals(""))) {
			lblHinhAnh.setIcon(ResizeImage(value.getHinhAnh()));
			// System.out.println(value.getHinhAnh());
		}

		lblTenSanPham.setText(value.getTenSanPham());
		tinhLaiGiamGia = value.getGiamGia() * 100;
		Double d = new Double(tinhLaiGiamGia);
		int giamGiaSP = d.intValue();
		lblGiamGia.setText(String.valueOf(giamGiaSP + "% Giảm giá"));

		lblDonGia.setText(String.valueOf(value.getDonGia()));
		lblDonGia.setForeground(new Color(255, 0, 0));
		Font font = lblDonGia.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
		lblDonGia.setFont(font.deriveFont(attributes));

		giaDaGiam = value.getDonGia() * (1 - value.getGiamGia());

		lblGiaDaGiam.setText(String.valueOf(giaDaGiam));
		lblGiaDaGiam.setForeground(new Color(255, 0, 0));

		lblHinhAnh.setOpaque(true);
		lblTenSanPham.setOpaque(true);
		lblDonGia.setOpaque(true);

		if (isSelected) {
			lblHinhAnh.setBackground(new Color(255, 240, 245));
			lblTenSanPham.setBackground(new Color(255, 240, 245));
			lblDonGia.setBackground(new Color(255, 240, 245));
			contentPane.setBackground(new Color(255, 240, 245));
			panel.setBackground(new Color(255, 240, 245));
			panel_1.setBackground(new Color(255, 240, 245));
			// lblNewLabel.setBackground(new Color(255, 240, 245));
			// lblNewLabel_1.setBackground(new Color(255, 240, 245));
			// lblNewLabel_2.setBackground(new Color(255, 240, 245));

			setBackground(list.getSelectionBackground());
		} else { // when don't select
			lblHinhAnh.setBackground(list.getBackground());
			lblTenSanPham.setBackground(list.getBackground());
			lblDonGia.setBackground(list.getBackground());
			contentPane.setBackground(list.getBackground());
			panel.setBackground(list.getBackground());
			panel_1.setBackground(list.getBackground());
			// lblNewLabel.setBackground(list.getBackground());
			// lblNewLabel_1.setBackground(list.getBackground());
			// lblNewLabel_2.setBackground(list.getBackground());
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
