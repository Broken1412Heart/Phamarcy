package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenStartMainRole extends JFrame {

    public ScreenStartMainRole() {
        // Thiết lập tiêu đề cho cửa sổ
        setTitle("Pharmacy Management System");

        // Thiết lập kích thước cửa sổ
        setSize(400, 300);

        // Thiết lập cửa sổ xuất hiện ở giữa màn hình
        setLocationRelativeTo(null);

        // Thiết lập hành động mặc định khi click vào nút đóng cửa sổ là thoát ứng dụng
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Tạo Panel chính để chứa các thành phần
        JPanel mainPanel = new JPanel();
        // Sử dụng GridLayout để sắp xếp các nút
        mainPanel.setLayout(new GridLayout(1, 2, 10, 10)); // rows, cols, hgap, vgap

        // Tạo các nút và thêm chúng vào mainPanel
        JButton btnManager = new JButton("Quản lý");
        JButton btnEmployee = new JButton("Nhân viên");
        mainPanel.add(btnManager);
        mainPanel.add(btnEmployee);

        btnEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị màn hình quản lý nhân viên khi click vào nút Nhân viên
                ScreenMainOfEmployee screenEmployeeManagement = new ScreenMainOfEmployee();
                screenEmployeeManagement.setVisible(true);
            }
        });

        btnManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị màn hình quản lý khi click vào nút Quản lý
                ScreenMainOfManager screenManagerManagement = new ScreenMainOfManager();
                screenManagerManagement.setVisible(true);
            }
        });

        // Tạo nút thoát và đặt nó ở góc phải dưới của cửa sổ
        JButton btnExit = new JButton("Thoát");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thoát ứng dụng khi click vào nút Thoát
                System.exit(0);
            }
        });

        // Tạo một panel mới cho nút Thoát và đặt nó ở phía dưới cùng của frame
        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        exitPanel.add(btnExit);

        // Thêm mainPanel và exitPanel vào frame
        add(mainPanel, BorderLayout.CENTER);
        add(exitPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Tạo và hiển thị màn hình
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ScreenStartMainRole frame = new ScreenStartMainRole();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
