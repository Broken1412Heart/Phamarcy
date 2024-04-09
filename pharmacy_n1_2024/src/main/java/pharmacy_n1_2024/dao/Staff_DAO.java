package dao;

import java.util.List;

import entity.Staff;

public interface Staff_DAO {
    public List<Staff> getAllStaff();

    public boolean themStaff(Staff staff);

    public boolean capNhatThongTinStaff(Staff staff);

    public boolean xoaStaff(String maStaff);

    public List<Staff> timKiemStaff(String noiDungTim);

    public Staff layThongTinStaffTheoMaStaff(String maStaff);
}
