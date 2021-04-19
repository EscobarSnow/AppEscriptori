package escobarsnow.classes;

import java.sql.Date;

public class Kit {
    private int idKit;
    private double preuTotal;
    private Esqui esqui;
    private Bota bota;
    private Pal pal;
    private Date data;

   

    

    public Kit() {
    
    }

    public void Kits(int idKit, double preuTotal, Esqui esqui, Bota bota, Pal pal, Date data) {
        this.idKit = idKit;
        this.preuTotal = this.esqui.getPreuEsquis()+this.bota.getPreuBotes()+this.pal.getPreuPals();
        this.esqui = esqui;
        this.bota = bota;
        this.pal = pal;
        this.data = data;
    }
    public int getIdKit() {
        return this.idKit;
    }

    public void setIdKit(int idKit) {
        this.idKit = idKit;
    }

    public void setPreuTotal(double preuTotal) {
        this.preuTotal = this.esqui.getPreuEsquis()+this.bota.getPreuBotes()+this.pal.getPreuPals();
    }

    public Double getPreuTotal(){
        return this.esqui.getPreuEsquis()+this.bota.getPreuBotes()+this.pal.getPreuPals();
    }
    
    public Esqui getEsqui() {
        return this.esqui;
    }

    public void setEsqui(Esqui esqui) {
        this.esqui = esqui;
    }

    public Bota getBota() {
        return this.bota;
    }

    public void setBota(Bota bota) {
        this.bota = bota;
    }

    public Pal getPal() {
        return this.pal;
    }

    public void setPal(Pal pal) {
        this.pal = pal;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date date) {
        this.data = date;
    }
    
    public String toString() {
        return  " ID kit: " + this.idKit +" Esqui: "+ this.esqui + " Botes: " + this.bota + " Pals: " + this.pal + " Preu Total: " + this.preuTotal + " Data: " + this.data;
    }
   
   

}
