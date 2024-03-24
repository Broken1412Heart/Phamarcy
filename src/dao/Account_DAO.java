package dao;

import entity.AccountSystem;

public interface Account_DAO {
    public boolean themTaiKhoan(AccountSystem Account);

    public AccountSystem layThongTinTaKhoanTheoMaAccount(String maAccount);

    public String layMaNhanVienTheoEmail(String email);

    public boolean doiMatKhau(AccountSystem Account);
}
