package entity;

import java.util.Objects;

public class TypeMedicine {

    private String TypeMedicineID;
    private String TypeMedicineName;

    public TypeMedicine() {

    }

    public void finalize() throws Throwable {

    }

    /**
     * 
     * @param TypeMedicineID
     * @param TypeMedicineName
     */

    public TypeMedicine(String TypeMedicineID) {
        super();
        this.TypeMedicineID = TypeMedicineID;
    }

    public TypeMedicine(String TypeMedicineID, String TypeMedicineName) {
        super();
        this.TypeMedicineID = TypeMedicineID;
        this.TypeMedicineName = TypeMedicineName;
    }

    public String toString() {
        return "";
    }

    public String getTypeMedicineID() {
        return TypeMedicineID;
    }

    public void setTypeMedicineID(String TypeMedicineID) {
        this.TypeMedicineID = TypeMedicineID;
    }

    public String getTypeMedicineName() {
        return TypeMedicineName;
    }

    public void setTypeMedicineName(String TypeMedicineName) {
        this.TypeMedicineName = TypeMedicineName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(TypeMedicineID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TypeMedicine other = (TypeMedicine) obj;
        return Objects.equals(TypeMedicineID, other.TypeMedicineID);
    }

}