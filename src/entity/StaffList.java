package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class StaffList implements Serializable {
    private static ArrayList<Medicone> lstStaff;

    public StaffList() {
        lstStaff = new ArrayList<Medicone>();
    }

    public static ArrayList<Medicone> getAll() {
        // TODO Auto-generated method stub
        return lstStaff;
    }

    public boolean addStaff(Medicone staff) {
        if (lstStaff.contains(staff))
            return false;

        lstStaff.add(staff);
        return true;

    }

    public boolean deleteStaff(Medicone staff) {
        int index = lstStaff.indexOf(staff);
        lstStaff.remove(index);
        return true;
    }

    public boolean updateStaff(Medicone staff) {
        int index = lstStaff.indexOf(staff);
        lstStaff.set(index, staff);
        return true;
    }

    public Medicone searchId(String ID) {
        for (Medicone i : lstStaff)
            if (i.getStaffID().equalsIgnoreCase(ID))
                return i;

        return null;
    }
}
