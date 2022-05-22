package Model;

public class Sach {
    private int id;
    private Loai_sach loai_sach;
    private Vi_tri vi_tri;
    private Tac_gia tac_gia;
    private String ten_sach;
    private int sl_bd, sl_cl;
    private Nhan_vien nhan_vien;

    public Sach() {
    }

    public Sach(int id, Loai_sach loai_sach, Vi_tri vi_tri, Tac_gia tac_gia, String ten_sach, int sl_bd, int sl_cl, Nhan_vien nhan_vien) {
        this.id = id;
        this.loai_sach = loai_sach;
        this.vi_tri = vi_tri;
        this.tac_gia = tac_gia;
        this.ten_sach = ten_sach;
        this.sl_bd = sl_bd;
        this.sl_cl = sl_cl;
        this.nhan_vien=nhan_vien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Loai_sach getLoai_sach() {
        return loai_sach;
    }

    public void setLoai_sach(Loai_sach loai_sach) {
        this.loai_sach = loai_sach;
    }

    public Vi_tri getVi_tri() {
        return vi_tri;
    }

    public void setVi_tri(Vi_tri vi_tri) {
        this.vi_tri = vi_tri;
    }

    public Tac_gia getTac_gia() {
        return tac_gia;
    }

    public void setTac_gia(Tac_gia tac_gia) {
        this.tac_gia = tac_gia;
    }

    public String getTen_sach() {
        return ten_sach;
    }

    public void setTen_sach(String ten_sach) {
        this.ten_sach = ten_sach;
    }

    public int getSl_bd() {
        return sl_bd;
    }

    public void setSl_bd(int sl_bd) {
        this.sl_bd = sl_bd;
    }

    public int getSl_cl() {
        return sl_cl;
    }

    public void setSl_cl(int sl_cl) {
        this.sl_cl = sl_cl;
    }

    public Nhan_vien getNhan_vien() {
        return nhan_vien;
    }

    public void setNhan_vien(Nhan_vien nhan_vien) {
        this.nhan_vien = nhan_vien;
    }
}
