package dao;

import java.util.List;

import entity.Medicone;

public interface Staff_DAO {
    public List<Medicone> getTatCaStaff();

    public boolean themStaff(Medicone Staff);

    public boolean capNhatThongTinStaff(Medicone Staff);

    public boolean xoaStaff(String maStaff);

    public List<Medicone> timKiemStaff(String noiDungTim);

    public Medicone layThongTinStaffTheoMaStaff(String maStaff);
}
