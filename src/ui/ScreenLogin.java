package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDataBase;
import entity.AccountSystem;
import entity.Staff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ScreenLogin extends JFrame implements ActionListener, KeyListener, MouseListener {
    private JLabel lblLogo;
    private JTextField txtEmployeeId;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnExit;
    private JPanel contentPane;
    private JTextField txtAccount;
    private JPasswordField passwordLogin;
    protected boolean LoginStatus = false;
    protected static String usernameToLogin;
    protected static AccountSystem account = new AccountSystem();

    protected static Staff staff = new Staff();

    public ScreenLogin() {
        setTitle("Pharmacy Management System");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 650, 370);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("../image/IconPhamarcy.png.png"));

        JLabel lblImgNhaNam = new JLabel();
        lblImgNhaNam.setIcon(new ImageIcon("../image/IconPhamarcy.jpg"));
        lblImgNhaNam.setBounds(0, 0, 330, 333);
        contentPane.add(lblImgNhaNam);

        passwordLogin = new JPasswordField();
        passwordLogin.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (txtAccount.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(btnLogin, "Tài khoản không được để trống");
                        return;
                    } else if (txtPassword.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(btnLogin, "Mật khẩu không được để trống");
                        return;
                    }

                    AllowLogin();
                }
            }

        });

        setLocationRelativeTo(null);
        setResizable(false);

        try {
            ConnectDataBase.getInstance().connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public void AllowLogin() {
        try {
            String userLoginString = txtAccount.getText().trim();
            String passwordString = txtPassword.getText().trim();
            Decentralization(userLoginString, passwordString); // Phân quyền

            if (LoginCheck(userLoginString, passwordString) && LoginStatus == true) {
                usernameToLogin = txtAccount.getText();
                // System.out.println("1 " + usernameToGetNhanVien);
                ScreenMainOfEmployee main_screen = new ScreenMainOfEmployee();
                main_screen.menuStaff.setEnabled(false);
                main_screen.menuStatisticRevenue.setEnabled(false);
                main_screen.menuStatisticsBestSale.setEnabled(false);
                main_screen.setVisible(true);
                this.setVisible(false);
            } else if (LoginCheck(userLoginString, passwordString) && LoginStatus == true) {
                usernameToLogin = txtAccount.getText();
                // System.out.println("2 " + usernameToGetNhanVien);
                ScreenMainOfEmployee main_screen = new ScreenMainOfEmployee();
                // main_screen.menuStaff.setEnabled(true);
                // main_screen.menuStatisticRevenue.setEnabled(true);
                // main_screen.menuStatisticsBestSale.setEnabled(true);
                main_screen.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
            // e.printStackTrace();
        }
    }

    private boolean LoginCheck(String userLoginString, String passwordString) {
        if (account.getStaff().getStaffID().equalsIgnoreCase(userLoginString)
                && account.getPassword().equalsIgnoreCase(passwordString)
                && staff.getStaffRole().equalsIgnoreCase("NVBH")) {
            LoginStatus = true;
            return true;
        } else if (account.getStaff().getStaffID().equalsIgnoreCase(userLoginString)
                && account.getPassword().equalsIgnoreCase(passwordString)
                && staff.getStaffRole().equalsIgnoreCase("NVQL")) {
            LoginStatus = true;
            return true;
        }
        return false;
    }

    private void Decentralization(String userLoginString, String passwordString) {
        try {
            PreparedStatement preStm = null;
            Connection con = ConnectDataBase.getInstance().getConnection();
            String sql = "SELECT  tk.[maNhanVien], [matKhau], [chucVu]      \r\n"
                    + "FROM            Nhan_Vien nv INNER JOIN\r\n"
                    + "                         Tai_Khoan tk ON nv.maNhanVien = tk.maNhanVien\r\n"
                    + "						 where tk.[maNhanVien] = ? and [matKhau] = ?\r\n"
                    + "group by tk.[maNhanVien], [matKhau], [chucVu]\r\n"
                    + "";
            preStm = con.prepareStatement(sql);
            preStm.setString(1, userLoginString);
            preStm.setString(2, passwordString);
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {
                String username = rs.getString(1).trim();
                String staffPassword = rs.getString(2).trim();
                String role = rs.getString(3).trim();
                // staff = StaffService.layThongTinNhanVienTheoMaNhanVien(username);
                // AccountSystem.setNhanVien(staff);
                // AccountSystem.setPassWord(staffPassword);
                // staff.setChucVu(role);
                // System.out.println(account);
                // System.out.println(nhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ScreenLogin(); // Tạo và hiển thị giao diện đăng nhập
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Form_Gui_Ma_Xac_Thuc form_Gui_Ma_Xac_Thuc = new Form_Gui_Ma_Xac_Thuc();
        // this.setVisible(false);
        // form_Gui_Ma_Xac_Thuc.setVisible(true);
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
