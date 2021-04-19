package escobarsnow.classes;

public class Pal {
    private int idPals;
    private String marcaPals;
    private String colorPals;
    private int tallaPals;
    private double preuPals;
    private String categoriaPals;

 
    public Pal(){

    }
    
    public void Pals(int idPals, String marcaPals, String colorPals, int tallaPals, double preuPals, String categoriaPals){
        this.idPals = idPals;
        this.marcaPals = marcaPals;
        this.colorPals = colorPals;
        this.tallaPals = tallaPals;
        this.preuPals = preuPals;
        this.categoriaPals = categoriaPals;
    }
     public int getIdPals() {
         return this.idPals;
     }
 
     public void setIdPals(int idPals) {
         this.idPals = idPals;
     }
 
     public String getMarcaPals() {
         return this.marcaPals;
     }
 
     public void setMarcaPals(String marcaPals) {
         this.marcaPals = marcaPals;
     }
     public String getColorPal() {
        return this.colorPals;
    }

    public void setColorPal(String colorPal) {
        this.colorPals = colorPals;
    }
 
     public int getTallaPals() {
         return this.tallaPals;
     }
 
     public void setTallaPals(int tallaPals) {
         this.tallaPals = tallaPals;
     }
 
     public double getPreuPals() {
         return this.preuPals;
     }
 
     public void setPreuPals(double preuPals) {
         this.preuPals = preuPals;
     }

     public String getCategoriaPals() {
        return this.categoriaPals;
    }

    public void setCategoriaPals(String categoriaPals) {
        this.categoriaPals = categoriaPals;
    } 
     public String toString() {
        return  " ID Pal: " + this.idPals + " Marca: " + this.marcaPals + " Color: " + this.colorPals + " Talla: " + this.tallaPals + " Preu: " + this.preuPals + " Categoria: " + this.categoriaPals; 
    }
}
