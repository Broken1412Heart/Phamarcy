package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScreenMainOfEmployee extends JFrame {
    protected JMenu menuStaff;
    protected JMenu menuStatisticRevenue;
    protected JMenu menuStatisticsBestSale;

    public ScreenMainOfEmployee() {
        // Thiết lập cửa sổ chính
        setTitle("Trung Tâm Quản Lý");
        setSize(800, 600); // Kích thước cửa sổ
        setLocationRelativeTo(null); // Đặt cửa sổ giữa màn hình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng chương trình khi đóng cửa sổ

        // Thiết lập layout
        setLayout(new BorderLayout());

        // Tạo và thêm logo
        // Giả sử logo là một JLabel (bạn có thể thay thế bằng hình ảnh của mình)
        JLabel logoLabel = new JLabel("LOGO");
        logoLabel.setPreferredSize(new Dimension(100, 100)); // Kích thước logo
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(logoLabel, BorderLayout.WEST);

        // Tạo và thêm nút thoát
        JButton exitButton = new JButton("Thoát");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Thoát chương trình
            }
        });
        topPanel.add(exitButton, BorderLayout.EAST);

        // Thêm topPanel vào cửa sổ chính
        add(topPanel, BorderLayout.NORTH);

        // Tạo menu bar
        JMenuBar menuBar = new JMenuBar();
        String[] mainMenuNames = { "Quản lý thuốc", "Quản lý khách hàng", "Quản lý hoá đơn", "Báo cáo thống kê" };
        for (String name : mainMenuNames) {
            JMenu menu = new JMenu(name);
            menu.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    // Thêm các menu items khi cần
                    // Ví dụ: menu.add(new JMenuItem("Sub Item 1"));
                }
            });
            menuBar.add(menu);
        }

        // Thêm menu bar vào cửa sổ
        setJMenuBar(menuBar);

        // Hiển thị cửa sổ
        setVisible(true);
    }

    public static void main(String[] args) {
        // Tạo và hiển thị giao diện
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ScreenMainOfEmployee();
            }
        });
    }
}
