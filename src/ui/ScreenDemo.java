package ui;

import javax.swing.*;
import java.awt.*;

public class ScreenDemo extends JPanel {
    private JTextField txtID, txtName, txtNgaySinh, txtNgayDiLam, txtSoDienThoai, txtDiaChi, txtSoCCCD;
    private JComboBox<String> cboRole, cboGender;

    public ScreenDemo() {
        setLayout(new BorderLayout());
        add(createMainPanel(), BorderLayout.NORTH);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createTitledBorder("Pharmacy System - Staff Update"));

        mainPanel.add(createSectionPanel("Mã nhân viên:", txtID = new JTextField("NV001", 20)));
        mainPanel.add(createSectionPanel("Họ và tên:", txtName = new JTextField("Harry Thurston", 20)));
        mainPanel.add(
                createComboBoxPanel("Chức vụ:", cboRole = new JComboBox<>(), new String[] { "Quản lý", "Nhân viên" }));
        mainPanel.add(createComboBoxPanel("Giới Tính:", cboGender = new JComboBox<>(),
                new String[] { "Nam", "Nữ", "LGBT", "Khác" }));
        mainPanel.add(createSectionPanel("Ngày sinh:", txtNgaySinh = new JTextField(20)));
        mainPanel.add(createSectionPanel("Ngày đi làm:", txtNgayDiLam = new JTextField(20)));
        mainPanel.add(createSectionPanel("Số điện thoại:", txtSoDienThoai = new JTextField(20)));
        mainPanel.add(createSectionPanel("Địa chỉ:", txtDiaChi = new JTextField(20)));
        mainPanel.add(createSectionPanel("Số CCCD:", txtSoCCCD = new JTextField(20)));

        return mainPanel;
    }

    private JPanel createSectionPanel(String label, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(label));
        panel.add(textField);
        return panel;
    }

    private JPanel createComboBoxPanel(String label, JComboBox<String> comboBox, String[] items) {
        for (String item : items) {
            comboBox.addItem(item);
        }
        return createSectionPanel(label, comboBox);
    }

    private JPanel createSectionPanel(String label, JComboBox<String> comboBox) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(label));
        panel.add(comboBox);
        return panel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 800);
        frame.add(new ScreenDemo());
        frame.setVisible(true);
    }
}
