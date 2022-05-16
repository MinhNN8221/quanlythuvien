package Model;

public class Vi_tri {
    private int id_vt;
    private String ten_vt;

    public Vi_tri() {
    }

    public Vi_tri(int id_vt, String ten_vt) {
        this.id_vt = id_vt;
        this.ten_vt=ten_vt;
    }

    public int getId_vt() {
        return id_vt;
    }

    public void setId_vt(int id_vt) {
        this.id_vt = id_vt;
    }

    public String getTen_vt() {
        return ten_vt;
    }

    public void setTen_vt(String ten_vt) {
        this.ten_vt = ten_vt;
    }
}
