package setup_tool;

import java.sql.SQLException;

import connectDB.ConnectDataBase;
import ui.Form_Dang_Nhap;

public class CountDownThread extends Thread {
	public void run() {
		int count = 2;
		for (int i = 0; i < count; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			ConnectDataBase.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Form_Dang_Nhap form_Dang_Nhap = new Form_Dang_Nhap();
		form_Dang_Nhap.setVisible(true);
		form_Dang_Nhap.setLocationRelativeTo(null);

	}
}
