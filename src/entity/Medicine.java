package entity;

public class Medicine {
    private String MedicineID;
    private String MedicineName;
    private String MedicineType;
    private Double MedicineUnit;
    private int MedicinePrice;
    private Double MedicineQuantity;
    private String MedicineDescription;

    public Medicine() {
    }

    public Medicine(String medicineID, String medicineName, String medicineType, Double medicineUnit, int medicinePrice,
            Double medicineQuantity, String medicineDescription) {
        MedicineID = medicineID;
        MedicineName = medicineName;
        MedicineType = medicineType;
        MedicineUnit = medicineUnit;
        MedicinePrice = medicinePrice;
        MedicineQuantity = medicineQuantity;
        MedicineDescription = medicineDescription;
    }

    public Medicine(String maThuoc, String tenThuoc, String moTa, Double donGia, int soLuong, Double giamGia,
            String trangThai, Supplier supplier) {
                
    }

    public String getMedicineID() {
        return MedicineID;
    }

    public void setMedicineID(String medicineID) {
        MedicineID = medicineID;
    }

    public String getMedicineName() {
        return MedicineName;
    }

    public Double getMedicineUnit() {
        return MedicineUnit;
    }

    public void setMedicineUnit(Double medicineUnit) {
        MedicineUnit = medicineUnit;
    }

    public Double getMedicineQuantity() {
        return MedicineQuantity;
    }

    public void setMedicineQuantity(Double medicineQuantity) {
        MedicineQuantity = medicineQuantity;
    }

    public void setMedicineName(String medicineName) {
        MedicineName = medicineName;
    }

    public String getMedicineType() {
        return MedicineType;
    }

    public void setMedicineType(String medicineType) {
        MedicineType = medicineType;
    }

    

    public int getMedicinePrice() {
        return MedicinePrice;
    }

    public void setMedicinePrice(int medicinePrice) {
        MedicinePrice = medicinePrice;
    }

    public String getMedicineDescription() {
        return MedicineDescription;
    }

    public void setMedicineDescription(String medicineDescription) {
        MedicineDescription = medicineDescription;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((MedicineID == null) ? 0 : MedicineID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Medicine other = (Medicine) obj;
        if (MedicineID == null) {
            if (other.MedicineID != null)
                return false;
        } else if (!MedicineID.equals(other.MedicineID))
            return false;
        return true;
    }

}
