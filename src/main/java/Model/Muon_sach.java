package Model;

public class Muon_sach {
    private int id;
    private Sach sach;
    private Sinh_vien sinh_vien;
    private int luot_muon;
    private String ngay_muon, ngay_tra, trang_thai;

    public Muon_sach() {
    }

    public Muon_sach(int id, Sach sach, Sinh_vien sinh_vien, int luot_muon, String ngay_muon, String ngay_tra, String trang_thai) {
        this.id=id;
        this.sach = sach;
        this.sinh_vien = sinh_vien;
        this.luot_muon = luot_muon;
        this.ngay_muon = ngay_muon;
        this.ngay_tra = ngay_tra;
        this.trang_thai = trang_thai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public Sinh_vien getSinh_vien() {
        return sinh_vien;
    }

    public void setSinh_vien(Sinh_vien sinh_vien) {
        this.sinh_vien = sinh_vien;
    }

    public int getLuot_muon() {
        return luot_muon;
    }

    public void setLuot_muon(int luot_muon) {
        this.luot_muon = luot_muon;
    }

    public String getNgay_muon() {
        return ngay_muon;
    }

    public void setNgay_muon(String ngay_muon) {
        this.ngay_muon = ngay_muon;
    }

    public String getNgay_tra() {
        return ngay_tra;
    }

    public void setNgay_tra(String ngay_tra) {
        this.ngay_tra = ngay_tra;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }
}
