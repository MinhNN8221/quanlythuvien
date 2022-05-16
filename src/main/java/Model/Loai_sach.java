package Model;

public class Loai_sach {
    private int id_ls;
    private String ten_ls;

    public Loai_sach() {
    }

    public Loai_sach(int id_ls, String ten_ls) {
        this.id_ls = id_ls;
        this.ten_ls = ten_ls;
    }

    public int getId_ls() {
        return id_ls;
    }

    public void setId_ls(int id_ls) {
        this.id_ls = id_ls;
    }

    public String getTen_ls() {
        return ten_ls;
    }

    public void setTen_ls(String ten_ls) {
        this.ten_ls = ten_ls;
    }
}
