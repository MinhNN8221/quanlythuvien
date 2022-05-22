package Model;

public class Sinh_vien {
    private String ma_sv, ten_sv, lop, email;
    private Nhan_vien nhan_vien;

    public Sinh_vien() {
    }

    public Sinh_vien(String ma_sv, String ten_sv, String lop, String email, Nhan_vien nhan_vien) {
        this.ma_sv = ma_sv;
        this.ten_sv = ten_sv;
        this.lop = lop;
        this.email = email;
        this.nhan_vien=nhan_vien;
    }

    public String getMa_sv() {
        return ma_sv;
    }

    public void setMa_sv(String ma_sv) {
        this.ma_sv = ma_sv;
    }

    public String getTen_sv() {
        return ten_sv;
    }

    public void setTen_sv(String ten_sv) {
        this.ten_sv = ten_sv;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Nhan_vien getNhan_vien() {
        return nhan_vien;
    }

    public void setNhan_vien(Nhan_vien nhan_vien) {
        this.nhan_vien = nhan_vien;
    }
}
