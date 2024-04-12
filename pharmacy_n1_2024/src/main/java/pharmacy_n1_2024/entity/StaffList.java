package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class StaffList implements Serializable {
    private static ArrayList<Staff> lstStaff;

    public StaffList() {
        lstStaff = new ArrayList<Staff>();
    }

    public static ArrayList<Staff> getAllStaff() {
        // TODO Auto-generated method stub
        return lstStaff;
    }

    public boolean addStaff(Staff staff) {
        if (lstStaff.contains(staff))
            return false;

        lstStaff.add(staff);
        return true;

    }

    public boolean deleteStaff(Staff staff) {
        int index = lstStaff.indexOf(staff);
        lstStaff.remove(index);
        return true;
    }

    public boolean updateStaff(Staff staff) {
        int index = lstStaff.indexOf(staff);
        lstStaff.set(index, staff);
        return true;
    }

    public Staff searchId(String ID) {
        for (Staff i : lstStaff)
            if (i.getStaffID().equalsIgnoreCase(ID))
                return i;

        return null;
    }
}
