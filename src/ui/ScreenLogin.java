package ui;

import javax.swing.*;
import java.awt.*;

public class ScreenLogin extends JFrame {
    private JLabel lblLogo;
    private JTextField txtEmployeeId;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnExit;

    public ScreenLogin() {
        setTitle("Pharmacy Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Cấu hình chung cho GridBagConstraints
        gbc.insets = new Insets(4, 4, 4, 4); // Padding giữa các thành phần

        // Logo "Pharmacy"
        lblLogo = new JLabel("Pharmacy");
        lblLogo.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(lblLogo, gbc);

        // Employee ID Field
        txtEmployeeId = new JTextField(20);
        txtEmployeeId.setText("ID"); // Giả sử chúng ta không dùng HintTextFieldUI ở đây
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(txtEmployeeId, gbc);

        // Password Field
        txtPassword = new JPasswordField(20);
        txtPassword.setText("Password"); // Giả sử chúng ta không dùng HintTextFieldUI ở đây
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(txtPassword, gbc);

        // Nút Đăng nhập
        btnLogin = new JButton("Đăng nhập");
        gbc.gridx = 0; // Nằm ở cột 0
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Chiếm 1 cột
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnLogin, gbc);

        // Nút Thoát
        btnExit = new JButton("Thoát");
        gbc.gridx = 1; // Nằm ở cột 1, bên phải nút Đăng nhập
        gbc.gridy = 3;
        add(btnExit, gbc);

        btnExit.addActionListener(e -> System.exit(0)); // Xử lý sự kiện cho nút Thoát

        setVisible(true);
    }

    public static void main(String[] args) {
        new ScreenLogin(); // Tạo và hiển thị giao diện đăng nhập
    }
}
