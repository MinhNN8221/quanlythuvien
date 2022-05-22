package Model;

public class Nhan_vien {
    private int id_nv;
    private String user, pass;

    public Nhan_vien() {
    }

    public Nhan_vien(int id_nv, String user, String pass) {
        this.id_nv = id_nv;
        this.user = user;
        this.pass = pass;
    }

    public int getId_nv() {
        return id_nv;
    }

    public void setId_nv(int id_nv) {
        this.id_nv = id_nv;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
