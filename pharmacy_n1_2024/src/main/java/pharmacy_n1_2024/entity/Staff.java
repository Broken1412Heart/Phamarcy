package entity;

import java.util.Date;

public class Staff {
    private String staffID;
    private String staffName;
    private String staffIndentifyCard;
    private String staffPhone;
    private String staffEmail;
    private String staffAddress;
    private String staffRole;
    private boolean staffStatus;
    private boolean staffGender;
    private Date staffDOB;
    private Date staffStartDate;
    public boolean isStaffStatus;

    public Staff() {
    }

    public Staff(String staffID) {
        this.staffID = staffID;
    }

    public Staff(String staffID, String staffName, String staffIndentifyCard, String staffPhone, String staffEmail,
            String staffAddress, String staffRole, boolean staffStatus, boolean staffGender, Date staffDOB,
            Date staffStartDate) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffIndentifyCard = staffIndentifyCard;
        this.staffPhone = staffPhone;
        this.staffEmail = staffEmail;
        this.staffAddress = staffAddress;
        this.staffRole = staffRole;
        this.staffStatus = staffStatus;
        this.staffGender = staffGender;
        this.staffDOB = staffDOB;
        this.staffStartDate = staffStartDate;
    }

    public Staff(String staffID, String staffName, String staffIndentifyCard, String staffPhone, String staffEmail,
            String staffAddress, String staffRole, boolean staffStatus, boolean staffGender, Date staffDOB,
            Date staffStartDate, boolean isStaffStatus) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffIndentifyCard = staffIndentifyCard;
        this.staffPhone = staffPhone;
        this.staffEmail = staffEmail;
        this.staffAddress = staffAddress;
        this.staffRole = staffRole;
        this.staffStatus = staffStatus;
        this.staffGender = staffGender;
        this.staffDOB = staffDOB;
        this.staffStartDate = staffStartDate;
        this.isStaffStatus = isStaffStatus;
    }

    public Staff(String maNV, String email, java.sql.Date ngaySinh, String tenStaff, Boolean gioiTinh, String chucVu,
            Boolean trangThai) {
        //TODO Auto-generated constructor stub
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffIndentifyCard() {
        return staffIndentifyCard;
    }

    public void setStaffIndentifyCard(String staffIndentifyCard) {
        this.staffIndentifyCard = staffIndentifyCard;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

    public boolean isStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(boolean staffStatus) {
        this.staffStatus = staffStatus;
    }

    public boolean isStaffGender() {
        return staffGender;
    }

    public void setStaffGender(boolean staffGender) {
        this.staffGender = staffGender;
    }

    public Date getStaffDOB() {
        return staffDOB;
    }

    public void setStaffDOB(Date staffDOB) {
        this.staffDOB = staffDOB;
    }

    public Date getStaffStartDate() {
        return staffStartDate;
    }

    public void setStaffStartDate(Date staffStartDate) {
        this.staffStartDate = staffStartDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((staffID == null) ? 0 : staffID.hashCode());
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
        Staff other = (Staff) obj;
        if (staffID == null) {
            if (other.staffID != null)
                return false;
        } else if (!staffID.equals(other.staffID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Staff [staffID=" + staffID + ", staffName=" + staffName + ", staffIndentifyCard=" + staffIndentifyCard
                + ", staffPhone=" + staffPhone + ", staffEmail=" + staffEmail + ", staffAddress=" + staffAddress
                + ", staffRole=" + staffRole + ", staffStatus=" + staffStatus + ", staffGender=" + staffGender
                + ", staffDOB=" + staffDOB + ", staffStartDate=" + staffStartDate + "]";
    }

    public Object getStaffPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStaffPosition'");
    }

    public Object getStaffStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStaffStatus'");
    }

    public String getChucVu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getChucVu'");
    }

}
