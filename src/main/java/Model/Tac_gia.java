package Model;

public class Tac_gia {
    private int id_tg;
    private String ten_tg;
    private String dia_chi;

    public Tac_gia() {
    }

    public Tac_gia(int id_tg, String ten_tg, String dia_chi) {
        this.id_tg = id_tg;
        this.ten_tg = ten_tg;
        this.dia_chi = dia_chi;
    }

    public int getId_tg() {
        return id_tg;
    }

    public void setId_tg(int id_tg) {
        this.id_tg = id_tg;
    }

    public String getTen_tg() {
        return ten_tg;
    }

    public void setTen_tg(String ten_tg) {
        this.ten_tg = ten_tg;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
}
