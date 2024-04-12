package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;

import javax.swing.border.EmptyBorder;

import entity.HDSD;

public class HDSDRenDerer extends JPanel implements ListCellRenderer<HDSD> {
	private JLabel lblHinhAnh = new JLabel();
	private JLabel lblNoiDung = new JLabel();
	private JPanel panel;
	private JPanel panel_1;
	private JPanel contentPane;
	private JTextArea area;

	public HDSDRenDerer() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 5, 0));

		contentPane.setLayout(new BorderLayout(5, 0));

		lblHinhAnh = new JLabel();
		// lblHinhAnh.setSize(200, 1340);
		lblHinhAnh.setPreferredSize(new Dimension(1310, 800));
		contentPane.add(lblHinhAnh, BorderLayout.NORTH);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		// panel.setBorder(new EmptyBorder(0, 30, 0, 0));
		// panel.setBorder(BorderFactory.createEmptyBorder(0, //top
		// 2, //left
		// 0, //bottom
		// 28) //right
		// );
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		// lblNoiDung = new JLabel();
		// lblNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		// panel.add(lblNoiDung);
		area = new JTextArea(20, 0);
		panel.add(area);
		add(contentPane);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends HDSD> list, HDSD value, int index,
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		if (!(value.getHinhAnh().equals(""))) {
			lblHinhAnh.setIcon(ResizeImage(value.getHinhAnh()));
			// System.out.println(value.getHinhAnh());

		}

		// lblNoiDung.setText(value.getNoiDung());
		area.setText(value.getNoiDung());

		lblHinhAnh.setOpaque(true);
		lblNoiDung.setOpaque(true);

		if (isSelected) {
			lblHinhAnh.setBackground(new Color(255, 240, 245));
			lblNoiDung.setBackground(new Color(255, 240, 245));
			contentPane.setBackground(new Color(255, 240, 245));
			panel.setBackground(new Color(255, 240, 245));
			setBackground(list.getSelectionBackground());
		} else { // when don't select
			lblHinhAnh.setBackground(list.getBackground());
			lblNoiDung.setBackground(list.getBackground());
			contentPane.setBackground(list.getBackground());
			panel.setBackground(list.getBackground());
			setBackground(list.getBackground());
		}
		return this;
	}

	private ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(1310, 800, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}

}
