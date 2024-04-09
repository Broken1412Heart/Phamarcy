package entity;

public class BillDetail {
    private int amount;
    private Bill bill;
    private Medicine drugs;

    public BillDetail() {
    }

    public BillDetail(int amount, Bill bill, Medicine drugs) {
        this.amount = amount;
        this.bill = bill;
        this.drugs = drugs;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Medicine getDrugs() {
        return drugs;
    }

    public void setDrugs(Medicine drugs) {
        this.drugs = drugs;
    }

    public double tinhTongTien() {
        return (drugs.getMedicinePrice() * amount) * (1 - drugs.getMedicinePrice()* amount * 0.01);
    }

    @Override
    public String toString() {
        return "BillDetail [amount=" + amount + ", bill=" + bill + ", drugs=" + drugs + "]";
    }


}
