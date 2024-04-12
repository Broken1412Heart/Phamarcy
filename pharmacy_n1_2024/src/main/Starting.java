package main;

import java.sql.SQLException;

import connectDB.ConnectDataBase;
import ui.ScreenLogin;

public class Starting {
    public static void main(String[] args) throws SQLException {
        int count = 2;
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ConnectDataBase.getInstance().connect();
        ScreenLogin frm_Login = new ScreenLogin();
        frm_Login.setVisible(true);
        frm_Login.setLocationRelativeTo(null);

    }
}
