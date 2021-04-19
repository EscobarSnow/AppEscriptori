package escobarsnow.classes;

public class Bota {
    private int idBotes;
    private String marcaBotes;
    private String colorBota;
    private int tallaBotes;
    private double preuBotes;
    private String categoriaBotes;

   
 
    public Bota(){

    }
    public void Botes(int idBotes, String marcaBotes, String colorBota,  int tallaBotes, double preuBotes, String categoriaBotes){
        this.idBotes = idBotes;
        this.marcaBotes = marcaBotes;
        this.colorBota = colorBota;
        this.tallaBotes = tallaBotes;
        this.preuBotes = preuBotes;
        this.categoriaBotes = categoriaBotes;
    }


     public int getIdBotes() {
         return this.idBotes;
     }
 
     public void setIdBotes(int idBotes) {
         this.idBotes = idBotes;
     }
 
     public String getMarcaBotes() {
         return this.marcaBotes;
     }
 
     public void setMarcaBotes(String marcaBotes) {
         this.marcaBotes = marcaBotes;
     }
 
     public String getColorBota() {
        return this.colorBota;
    }

    public void setColorBota(String colorBota) {
        this.colorBota = colorBota;
    }
     public int getTallaBotes() {
         return this.tallaBotes;
     }
 
     public void setTallaBotes(int tallaBotes) {
         this.tallaBotes = tallaBotes;
     }
 
     public double getPreuBotes() {
         return this.preuBotes;
     }
 
     public void setPreuBotes(double preuBotes) {
         this.preuBotes = preuBotes;
     }
     public String getCategoriaBotes() {
        return this.categoriaBotes;
    }

    public void setCategoriaBotes(String categoriaBotes) {
        this.categoriaBotes = categoriaBotes;
    }
     public String toString() {
        return  " ID Bota: " + this.idBotes + " Marca: " + this.marcaBotes + " Color: " + this.colorBota + " Talla: " + this.tallaBotes + " Preu: " + this.preuBotes + " Categoria: " + this.categoriaBotes;
    }
}
