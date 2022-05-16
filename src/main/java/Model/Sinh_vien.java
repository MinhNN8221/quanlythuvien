package Model;

public class Sinh_vien {
    private String ma_sv, ten_sv, lop, email;

    public Sinh_vien() {
    }

    public Sinh_vien(String ma_sv, String ten_sv, String lop, String email) {
        this.ma_sv = ma_sv;
        this.ten_sv = ten_sv;
        this.lop = lop;
        this.email = email;
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
}
