package ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import esp.TaiKhoanService;
import esp.TaiKhoanServiceImpl;
import connectDB.ConnectDataBase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Form_Gui_Ma_Xac_Thuc extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4988454772471512347L;
	private JPanel contentPane;
	private static JTextField textMaNhanVien;
	private JButton btnXacThuc;

	private TaiKhoanService taiKhoanService = new TaiKhoanServiceImpl();
	private JTextField textEmail;
	private JTextField textMaXacThuc;
	private JButton btnGuiMaXacThuc;
	public int randomCode;
	public static String maNhanVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Gui_Ma_Xac_Thuc frame = new Form_Gui_Ma_Xac_Thuc();
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
	public Form_Gui_Ma_Xac_Thuc() {
		// DAO
		try {
			ConnectDataBase.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBounds(10, 10, 566, 55);
		pnTieuDe.setBackground(new Color(255, 240, 245));
		contentPane.add(pnTieuDe);
		pnTieuDe.setLayout(null);

		JLabel lblNewLabel = new JLabel("GỬI MÃ XÁC THỰC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(130, 0, 325, 55);
		pnTieuDe.add(lblNewLabel);

		JPanel pnThemTK = new JPanel();
		pnThemTK.setBounds(10, 75, 566, 318);
		pnThemTK.setBackground(new Color(240, 255, 255));
		contentPane.add(pnThemTK);
		pnThemTK.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(60, 11, 103, 25);
		pnThemTK.add(lblNewLabel_1);

		textMaNhanVien = new JTextField();
		textMaNhanVien.setBackground(new Color(255, 255, 255));
		textMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMaNhanVien.setBounds(200, 11, 300, 25);
		pnThemTK.add(textMaNhanVien);
		textMaNhanVien.setColumns(10);

		btnXacThuc = new JButton("Xác thực");
		btnXacThuc.setBackground(new Color(255, 240, 245));
		btnXacThuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXacThuc.setBounds(200, 113, 141, 39);
		pnThemTK.add(btnXacThuc);

		JLabel lblNewLabel_2_1 = new JLabel("Email:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(60, 58, 103, 25);
		pnThemTK.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Nhập mã xác thực:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(26, 183, 153, 25);
		pnThemTK.add(lblNewLabel_2_1_1);

		btnGuiMaXacThuc = new JButton("Gửi mã xác thực");
		btnGuiMaXacThuc.setBackground(new Color(255, 240, 245));
		btnGuiMaXacThuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuiMaXacThuc.setBounds(200, 231, 141, 39);
		pnThemTK.add(btnGuiMaXacThuc);

		textEmail = new JTextField();
		textEmail.setBackground(new Color(255, 255, 255));
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEmail.setColumns(10);
		textEmail.setBounds(200, 58, 300, 25);
		pnThemTK.add(textEmail);

		textMaXacThuc = new JTextField();
		textMaXacThuc.setBackground(new Color(255, 255, 255));
		textMaXacThuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMaXacThuc.setColumns(10);
		textMaXacThuc.setBounds(200, 183, 300, 25);
		pnThemTK.add(textMaXacThuc);

		btnXacThuc.addActionListener(this);
		btnGuiMaXacThuc.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnXacThuc)) {
			xacThucTK();
		} else if (obj.equals(btnGuiMaXacThuc)) {
			if (Integer.valueOf(textMaXacThuc.getText()) == randomCode) {
				Form_Reset_Password form_Reset_Password = new Form_Reset_Password();
				form_Reset_Password.setVisible(true);
				this.setVisible(false);
			} else if (textMaXacThuc.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "vui lòng nhập mã xác thực");
			} else {
				JOptionPane.showMessageDialog(null, "mã xác thực không đúng");
			}
		}
	}

	public void cauHinhGuiMaXacThuc() {
		try {

			Random rand = new Random();
			randomCode = rand.nextInt(999999);
			String host = "smtp.gmail.com";
			String user = "sieunmsv22@gmail.com";
			String pass = "imandtmcjmdapcfb";
			String to = textEmail.getText().trim();
			String subject = "Gửi mã xác thực";
			String message = "Your reset code is " + randomCode;
			boolean sessionDebug = false;
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "host");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(user));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setText(message);
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			JOptionPane.showMessageDialog(null, "code has been send to the mail");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane, e);
		}
	}

	public void xacThucTK() {
		maNhanVien = textMaNhanVien.getText().trim();
		System.out.println(maNhanVien);
		String email = textEmail.getText().trim();
		String maNhanVienTemp = taiKhoanService.layMaNhanVienTheoEmail(email);
		System.out.println(maNhanVienTemp);
		if (maNhanVien == "" || email == "") {
			JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
		}
		// if (maNhanVien.equalsIgnoreCase(maNhanVienTemp)) {
		else {
			cauHinhGuiMaXacThuc();
		}
		// }

	}
}
