package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class MedicineList implements Serializable {
    private static ArrayList<Medicine> lstMedicine;

    public MedicineList() {
        lstMedicine = new ArrayList<Medicine>();
    }

    public static ArrayList<Medicine> getAll() {
        // TODO Auto-generated method stub
        return lstMedicine;
    }

    public boolean addMedicine(Medicine staff) {
        if (lstMedicine.contains(staff))
            return false;

        lstMedicine.add(staff);
        return true;

    }

    public boolean deleteMedicine(Medicine staff) {
        int index = lstMedicine.indexOf(staff);
        lstMedicine.remove(index);
        return true;
    }

    public boolean updateMedicine(Medicine staff) {
        int index = lstMedicine.indexOf(staff);
        lstMedicine.set(index, staff);
        return true;
    }

    public Medicine searchId(String ID) {
        for (Medicine i : lstMedicine)
            if (i.getMedicineID().equalsIgnoreCase(ID))
                return i;

        return null;
    }
}
