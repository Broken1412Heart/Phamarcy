package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import entity.Medicine;
import entity.MedicineList;

public class ScreenDrugUpdate extends JFrame implements ActionListener, MouseListener {

    public static Component contentPane;
    JMenuBar menuBar = new JMenuBar();
    JMenu menuHeThong = new JMenu("Hệ thống");
    JMenu menuThuoc = new JMenu("Thuốc");
    JMenu menuNhanVien = new JMenu("Nhân viên");
    JMenu menuentity.Staff=new JMenu("Khách hàng");
    JMenu menuHoaDon = new JMenu("Hoá đơn");
    JMenu menuThongKe = new JMenu("Danh sách thống kê");
    JMenu menuHoTro = new JMenu("Hỗ trợ");

    String[] col = { "Mã thuốc", "Tên thuốc", "Loại Thuốc", "Đơn giá", "Số lượng", "Trạng thái",
            "Nhà cung cấp", "Hạn sử dụng" };
    private JTextField txtMedicineID;
    private JTextField txtMedicineName;
    private JButton btnAdd;
    private JButton btnClear;
    private JButton btnModify;
    private JButton btnDelete;
    private JButton btnSave;
    private JComboBox cboSearchByID;
    private DefaultComboBoxModel cboModel;
    private DefaultTableModel tblModelMedicine;
    private JTable tblMedicine;
    private MedicineList lstMedicine = new MedicineList();
    private JTextField txtNhaCungCap;
    private JLabel lblNhaCungCap;

    public ScreenDrugUpdate() {
        // TODO Auto-generated constructor stub
        setTitle("Phamarcy System");
        setSize(1500, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addControl();

    }

    public void addControl() {
        JPanel pnMain = new JPanel();
        // Tạo menu bar
        JMenuBar menuBar = new JMenuBar();
        String[] mainMenuNames = { "Hệ thống", "Thuốc", "Nhân viên",
                "Khách hàng", "Hoá đơn", "Danh sách thống kê",
                "Hỗ trợ" };
        menuBar.setFont(new Font("Arial", Font.BOLD, 20)); // Thiết lập font và kích thước chữ
        // for (String menuName : mainMenuNames) {
        // JMenu menu = new JMenu(menuName);
        // menuBar.add(menu);
        // }
        setJMenuBar(menuBar);
        setVisible(true);
        // Add sub menu bar
        // Hệ thống" gồm có "Đăng nhập bằng tài khoản khác" và "Thoát"
        JMenuItem menuItem1 = new JMenuItem("Đăng nhập bằng tài khoản khác");
        JMenuItem menuItem2 = new JMenuItem("Thoát");
        menuHeThong.add(menuItem1);
        menuHeThong.add(menuItem2);
        menuBar.add(menuHeThong);
        // Thuốc" gồm có "Danh sách thuốc" và "Thêm thuốc" và "Sửa thông tin thuốc" và
        // "Xóa thuốc"
        JMenuItem menuItem3 = new JMenuItem("Danh sách thuốc");
        JMenuItem menuItem4 = new JMenuItem("Thêm thuốc");
        JMenuItem menuItem5 = new JMenuItem("Sửa thông tin thuốc");
        JMenuItem menuItem6 = new JMenuItem("Xóa thuốc");
        menuThuoc.add(menuItem3);
        menuThuoc.add(menuItem4);
        menuThuoc.add(menuItem5);
        menuThuoc.add(menuItem6);
        menuBar.add(menuThuoc);
        // Nhân viên
        JMenuItem menuItem7 = new JMenuItem("Danh sách nhân viên");
        JMenuItem menuItem8 = new JMenuItem("Thêm nhân viên");
        JMenuItem menuItem9 = new JMenuItem("Sửa thông tin nhân viên");
        JMenuItem menuItem10 = new JMenuItem("Xóa nhân viên");
        menuNhanVien.add(menuItem7);
        menuNhanVien.add(menuItem8);
        menuNhanVien.add(menuItem9);
        menuNhanVien.add(menuItem10);
        menuBar.add(menuNhanVien);
        // Khách hàng" gồm có "Danh sách khách hàng" và "Thêm khách hàng" và "Sửa thông
        // tin khách hàng" và "Xóa khách hàng"
        JMenuItem menuItem11 = new JMenuItem("Danh sách khách hàng");
        JMenuItem menuItem12 = new JMenuItem("Thêm khách hàng");
        JMenuItem menuItem13 = new JMenuItem("Sửa thông tin khách hàng");
        JMenuItem menuItem14 = new JMenuItem("Xóa khách hàng");
        menuentity.Staff.add(menuItem11);
        menuentity.Staff.add(menuItem12);
        menuentity.Staff.add(menuItem13);
        menuentity.Staff.add(menuItem14);
        menuBar.add(menuentity.Staff);
        // Hoá đơn" gồm có "Danh sách hoá đơn" và "Thêm hoá đơn" và "Sửa thông tin hoá
        // đơn" và "Xóa hoá đơn"
        JMenuItem menuItem15 = new JMenuItem("Danh sách hoá đơn");
        JMenuItem menuItem16 = new JMenuItem("Thêm hoá đơn");
        JMenuItem menuItem17 = new JMenuItem("Sửa thông tin hoá đơn");
        JMenuItem menuItem18 = new JMenuItem("Xóa hoá đơn");
        menuHoaDon.add(menuItem15);
        menuHoaDon.add(menuItem16);
        menuHoaDon.add(menuItem17);
        menuHoaDon.add(menuItem18);
        menuBar.add(menuHoaDon);
        // Danh sách thống kê" gồm có "Danh sách thuốc" và "Danh sách thuốc" và
        // "Danh sách khách hàng" và "Danh sách hoá đơn"
        JMenuItem menuItem19 = new JMenuItem("Danh sách thuốc");
        JMenuItem menuItem20 = new JMenuItem("Danh sách nhân viên");
        JMenuItem menuItem21 = new JMenuItem("Danh sách khách hàng");
        JMenuItem menuItem22 = new JMenuItem("Danh sách hoá đơn");
        menuThongKe.add(menuItem19);
        menuThongKe.add(menuItem20);
        menuThongKe.add(menuItem21);
        menuThongKe.add(menuItem22);
        menuBar.add(menuThongKe);
        // Hỗ trợ" gồm có "Hướng dẫn sử dụng" và "Thông tin phiên bản"
        JMenuItem menuItem23 = new JMenuItem("Hướng dẫn sử dụng");
        JMenuItem menuItem24 = new JMenuItem("Thông tin phiên bản");
        menuHoTro.add(menuItem23);
        menuHoTro.add(menuItem24);
        menuBar.add(menuHoTro);
        // =========
        // Tạo giao diện
        // pnMain = new JPanel();

        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

        JPanel pnRecord = new JPanel();
        pnRecord.setLayout(new BoxLayout(pnRecord, BoxLayout.X_AXIS));
        pnRecord.setBorder(BorderFactory.createTitledBorder("Phamarcy System - Medicine Update"));

        JPanel pnLeftOfNorth = new JPanel();
        pnLeftOfNorth.setLayout(new BoxLayout(pnLeftOfNorth, BoxLayout.Y_AXIS));

        JPanel pnID = new JPanel();
        JLabel lblMaThuoc, lblTuaMedicine, lblDonGia;
        JLabel lblChucVu;

        pnID.add(lblMaThuoc = new JLabel("Mã thuốc:"));
        pnID.add(txtMedicineID = new JTextField());
        FlowLayout flowLayout = (FlowLayout) pnID.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        txtMedicineID.setText("Med007");
        txtMedicineID.setPreferredSize(new Dimension(380, 20));
        pnLeftOfNorth.add(pnID);

        JPanel pnMedicineName = new JPanel();
        pnMedicineName.add(lblTuaMedicine = new JLabel("Tên thuốc:"));
        FlowLayout flowLayout2 = (FlowLayout) pnMedicineName.getLayout();
        flowLayout2.setAlignment(FlowLayout.LEFT);
        pnMedicineName.add(txtMedicineName = new JTextField(25));
        txtMedicineName.setText("Metoprolol 50mg");
        pnLeftOfNorth.add(pnMedicineName);
        pnLeftOfNorth.add(Box.createVerticalStrut(5));

        JPanel pnDecribe = new JPanel();
        pnDecribe.add(lblTuaMedicine = new JLabel("Mô tả: "));
        FlowLayout flowLayout3 = (FlowLayout) pnDecribe.getLayout();
        flowLayout3.setAlignment(FlowLayout.LEFT);
        // Thêm jtextfield lớn khoảng 3 dòng
        JTextArea txtDecribe = new JTextArea(3, 40);
        // thiết lập boder màu đen
        txtDecribe.setBorder(BorderFactory.createLineBorder(null));
        txtDecribe.setText("Thuốc giảm huyết áp");
        pnDecribe.add(txtDecribe);

        pnLeftOfNorth.add(pnDecribe);
        pnRecord.add(pnLeftOfNorth);

        JPanel pnMiddleOfNorth = new JPanel();
        pnMiddleOfNorth.setLayout(new BoxLayout(pnMiddleOfNorth, BoxLayout.Y_AXIS));

        JPanel pnStatus = new JPanel();
        JLabel lblGioiTinh;
        pnStatus.add(lblGioiTinh = new JLabel("Trạng thái:"));
        FlowLayout fl1 = (FlowLayout) pnStatus.getLayout();
        fl1.setAlignment(FlowLayout.LEFT);
        // Tạo combobox trạng thái
        String[] status = { "Còn hàng", "Hết hàng" };
        JComboBox<String> cboStatus = new JComboBox<String>(status);
        pnStatus.add(cboStatus);
        pnMiddleOfNorth.add(pnStatus);

        fl1.setAlignment(FlowLayout.LEFT);
        pnMiddleOfNorth.add(pnStatus);

        // Thêm đơn giá và số lượng
        JPanel pnPrice = new JPanel();
        pnPrice.add(lblDonGia = new JLabel("Đơn giá:"));
        FlowLayout fl2 = (FlowLayout) pnPrice.getLayout();
        fl2.setAlignment(FlowLayout.LEFT);
        JTextField txtPrice = new JTextField(28);
        pnPrice.add(txtPrice);
        pnMiddleOfNorth.add(pnPrice);

        JPanel pnQuantity = new JPanel();
        pnQuantity.add(lblDonGia = new JLabel("Số lượng:"));
        FlowLayout fl3 = (FlowLayout) pnQuantity.getLayout();
        fl3.setAlignment(FlowLayout.LEFT);
        JTextField txtQuantity = new JTextField(28);
        pnQuantity.add(txtQuantity);
        pnMiddleOfNorth.add(pnQuantity);

        pnRecord.add(pnMiddleOfNorth);
        JPanel pnRightOfNorth = new JPanel();
        pnRightOfNorth.setLayout(new BoxLayout(pnRightOfNorth, BoxLayout.Y_AXIS));

        JPanel pnNhaCungCap = new JPanel();
        pnNhaCungCap.add(lblNhaCungCap = new JLabel("Nhà cung cấp:"));
        FlowLayout fl4 = (FlowLayout) pnNhaCungCap.getLayout();
        fl4.setAlignment(FlowLayout.LEFT);
        pnNhaCungCap.add(txtNhaCungCap = new JTextField(40));
        pnRightOfNorth.add(pnNhaCungCap);

        // JtextField hạn sử dụng date ngày tháng năm
        JPanel pnExpiryDate = new JPanel();
        pnExpiryDate.add(lblDonGia = new JLabel("Hạn sử dụng:"));
        FlowLayout fl5 = (FlowLayout) pnExpiryDate.getLayout();
        fl5.setAlignment(FlowLayout.LEFT);
        JDateChooser txtExpiryDate = new JDateChooser();
        txtExpiryDate.setPreferredSize(new Dimension(380, 20));
        pnExpiryDate.add(txtExpiryDate);
        pnRightOfNorth.add(pnExpiryDate);

        pnRecord.add(pnRightOfNorth);

        pnMain.add(pnRecord);
        pnMain.add(Box.createVerticalStrut(10));

        // ========= chức năng
        JPanel pnChucNang = new JPanel();
        pnChucNang.add(btnAdd = new JButton("Thêm"));
        pnChucNang.add(btnClear = new JButton("Xóa rỗng"));
        pnChucNang.add(btnModify = new JButton("Sửa"));
        pnChucNang.add(btnDelete = new JButton("Xóa"));
        pnChucNang.add(btnSave = new JButton("Lưu"));
        pnChucNang.add(new JLabel("                Tìm mã thuốc:  "));
        // === khoi tao combobox
        pnChucNang.add(cboSearchByID = new JComboBox());
        pnMain.add(pnChucNang);
        pnMain.add(Box.createVerticalStrut(10));

        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
        pnSouth.setBorder(BorderFactory.createTitledBorder("Danh sách thuốc"));

        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.Y_AXIS));
        tblModelMedicine = new DefaultTableModel(col, 0);

        loadCbo();
        loadDataToTable(MedicineList.getAll(), tblModelMedicine);
        tblMedicine = new JTable(tblModelMedicine);
        pnTable.add(new JScrollPane(tblMedicine));
        pnSouth.add(pnTable);
        pnMain.add(pnSouth);
        this.add(pnMain);

        // ============= Action =============
        btnClear.addActionListener(this);
        btnModify.addActionListener(this);
        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnSave.addActionListener(this);
        tblMedicine.addMouseListener(this);
        cboSearchByID.addActionListener(this);
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

    public void cleadCbo() {
        for (Medicine i : MedicineList.getAll())
            cboSearchByID.removeItem(i);
    }

    @SuppressWarnings("unchecked")
    public void loadCbo() {
        cboModel = new DefaultComboBoxModel();
        for (Medicine i : MedicineList.getAll())
            cboModel.addElement(i.getMedicineID());
        cboSearchByID.setModel(cboModel);
    }

    public void loadDataToTable(ArrayList<Medicine> lst, DefaultTableModel tblModel) {
        for (Medicine i : lst) {
            Object[] obj = { i.getMedicineID(), i.getMedicineName(), i.getMedicineType(), i.getPrice(), i.getQuantity(),
                    i.getStatus(), i.getSupplier(), i.getExpiryDate() };
            tblModel.addRow(obj);
        }
    }

    public void clearText() {

    }

    public Medicine taoMedicine() {

        Medicine a = new Medicine();
        return a;
    }

    public void MedicineToTextBox(Medicine item) {
        // txtMa.setText(item.getMaS());
        // txtTua.setText(item.getTuaMedicine());
        // txtTacGia.setText(item.getTacGia());
        // txtNhaXuatBan.setText(item.getNxb());
        // txtNam.setText(item.getNamXB() + "");
        // txtISBN.setText(item.getIsbn());
        // txtSoTrang.setText(item.getPage() + "");
        // txtDonGia.setText(item.getDonGia() + "");
    }

    public boolean kiemTraTextBox() {
        if (txtMedicineID.getText().isEmpty() || txtMedicineName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn phải nhập đầy đủ thông tin!");
            return false;
        } else {
            String thongBao = "";
            // Mã thuốc
            char ch = txtMedicineName.getText().charAt(0);
            String patternStrMa = "^Med" + ch + "[0-9]{3}$";
            Pattern patternMa = Pattern.compile(patternStrMa, Pattern.CASE_INSENSITIVE);
            Matcher matchMa = patternMa.matcher(txtMedicineID.getText());
            Boolean matchFoundMa = matchMa.matches();

            if (!matchFoundMa)
                thongBao += "Mã thuốc phải có ký tự đầu là Med tiếp sau phải là số từ 0 đến 9!";

            if (thongBao.isEmpty())// không có lỗi
                return true;
            else {
                JOptionPane.showMessageDialog(null, thongBao);
                return false;
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object obj = e.getSource();
        if (obj.equals(btnAdd)) {
            if (kiemTraTextBox()) {
                Medicine a = taoMedicine();
                if (lstMedicine.getAll().contains(a))
                    JOptionPane.showMessageDialog(null, "Mã thuốc không được trùng!!!");
                else {
                    lstMedicine.addMedicine(a);
                    Object[] ob = {};
                    tblModelMedicine.addRow(ob);
                    loadCbo();
                }
            }

        } else if (obj.equals(btnClear)) {
            clearText();

        } else if (obj.equals(btnSave)) {
            if (lstMedicine.getAll().size() < 0)
                JOptionPane.showMessageDialog(null, "Không có dữ liệu để lưu!!!!");
            try {
                // new FileData().luuDuLieuMedicine("src/data/DuLieu.txt", lstMedicine);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        } else if (obj.equals(btnModify)) {
            int select = tblMedicine.getSelectedRow();
            if (select > 0) {
                if (kiemTraTextBox()) {
                    int hoi = JOptionPane.showConfirmDialog(null, "Ban co muon sua khong? ", "ThongBao",
                            JOptionPane.YES_NO_OPTION);
                    if (hoi == JOptionPane.YES_OPTION) {
                        Medicine a = taoMedicine();
                        lstMedicine.updateMedicine(a);
                        tblMedicine.setModel(tblModelMedicine = new DefaultTableModel(col, 0));
                        loadDataToTable(lstMedicine.getAll(), tblModelMedicine);
                    }
                }

            }
        } else if (obj.equals(btnDelete)) {
            int select = tblMedicine.getSelectedRow();
            if (select >= 0 && select < lstMedicine.getAll().size()) {
                int hoi = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Thông Báo",
                        JOptionPane.YES_NO_OPTION);
                if (hoi == JOptionPane.YES_OPTION) {
                    Medicine a = lstMedicine.getAll().get(select);
                    lstMedicine.deleteMedicine(a);
                    tblModelMedicine.removeRow(select);
                    loadCbo();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chưa chọn đối tượng để xóa");

            }
        } else if (e.getSource().equals(cboSearchByID)) {
            String chon = (String) cboSearchByID.getSelectedItem();
            Medicine a = lstMedicine.searchId(chon);
            tblMedicine.setModel(tblModelMedicine = new DefaultTableModel(col, 0));
            Object[] ob = {};
            tblModelMedicine.addRow(ob);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        int select = tblMedicine.getSelectedRow();
        if (select >= 0) {
            MedicineToTextBox(lstMedicine.getAll().get(select));
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    // Test demo
    public static void main(String[] args) {
        new ScreenDrugUpdate().setVisible(true);
    }

}
