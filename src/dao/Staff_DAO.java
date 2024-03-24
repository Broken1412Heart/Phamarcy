package dao;

import java.util.List;

import entity.Staff;

public interface Staff_DAO {
    public List<Staff> getTatCaStaff();

    public boolean themStaff(Staff Staff);

    public boolean capNhatThongTinStaff(Staff Staff);

    public boolean xoaStaff(String maStaff);

    public List<Staff> timKiemStaff(String noiDungTim);

    public Staff layThongTinStaffTheoMaStaff(String maStaff);
}
