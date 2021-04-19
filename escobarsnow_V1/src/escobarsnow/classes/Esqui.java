package escobarsnow.classes;

public class Esqui {
    private int idEsquis;
    private String marcaEsquis;
    private String colorEsquis;
    private int tallaEsquis;
    private double preuEsquis;
    private String categoriaEsquis;

    
 
    public Esqui(){

    }

    public void Esquis(int idEsquis, String marcaEsquis, String colorEsquis, int tallaEsquis, double preuEsquis, String categoriaEsquis ){
        this.idEsquis = idEsquis;
        this.marcaEsquis = marcaEsquis;
        this.colorEsquis = colorEsquis;
        this.tallaEsquis = tallaEsquis;
        this.preuEsquis = preuEsquis;
        this.categoriaEsquis = categoriaEsquis;
    }
    public int getIdEsquis() {
         return this.idEsquis;
     }
 
     public void setIdEsquis(int idEsquis) {
         this.idEsquis = idEsquis;
     }
 
     public String getMarcaEsquis() {
         return this.marcaEsquis;
     }
 
     public void setMarcaEsquis(String marcaEsquis) {
         this.marcaEsquis = marcaEsquis;
     }
     public String getColorEsquis() {
        return this.colorEsquis;
    }

    public void setColorEsquis(String colorEsquis) {
        this.colorEsquis = colorEsquis;
    }
 
     public int getTallaEsquis() {
         return this.tallaEsquis;
     }
 
     public void setTallaEsquis(int tallaEsquis) {
         this.tallaEsquis = tallaEsquis;
     }
 
     public double getPreuEsquis() {
         return this.preuEsquis;
     }
 
     public void setPreuEsquis(double preuEsquis) {
         this.preuEsquis = preuEsquis;
     }
 
     public String getCategoriaEsquis() {
        return this.categoriaEsquis;
    }

    public void setCategoriaEsquis(String categoriaEsquis) {
        this.categoriaEsquis = categoriaEsquis;
    }
    
     public String toString() {
         return  " ID Esqui: " + this.idEsquis + " Marca: " + this.marcaEsquis + " Color: " + this.colorEsquis + " Talla: " + this.tallaEsquis + " Preu: " + this.preuEsquis + " Categoria: " + this.categoriaEsquis;
     }
}
