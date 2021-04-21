// Arxiu per guardar les dades de la BD en arrays
package escobarsnow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import escobarsnow.classes.*;

public class GuardarArray {
  
    // Creem els arrays
    private final static int TA = 200;
    static Bota[] botes = new Bota[TA];
    static Esqui[] esquis = new Esqui[TA];
    static Pal[] pals = new Pal[TA];
    static Kit[] kits = new Kit[TA];

    Connection conn = null;

    // Fem els següents statics per poder cridar-los en altres arxius
    static Bota[] getBotes(){
        return botes.clone();
    }

    static Esqui[] getEsqui(){
        return esquis.clone();
    }

    static Pal[] getPals(){
        return pals.clone();
    }

    static Kit[] getKits(){
        return kits.clone();
    }

    // Guardar arrays

    public static void saveArray() {

        GuardarArray tenda = new GuardarArray();
        tenda.llogarKits(); 
    }

    private void llogarKits(){
        
        if (!obtenirKitsBotesPalsEsquisBD()) {
            System.out.println("ERROR: No s'ha pogut carregar les dades a la memòria");
            System.out.println("Torna a intentar");
        } 
    }

    private boolean obtenirKitsBotesPalsEsquisBD() {
      
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escobarsnow", "root", "");
           
            obtenirEsquis();
           
            obtenirBotes();
           
            obtenirPals();

            obtenirKits();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    private void obtenirEsquis(){
        try {
            Statement st = conn.createStatement();
            String esquisProd = "SELECT * FROM esquis;";
            ResultSet rs = st.executeQuery(esquisProd); 

            int i=0;
                while (rs.next()) {
                    
                    Esqui esqui = new Esqui();
                    esqui.setIdEsquis(rs.getInt("id_esquis"));
                    esqui.setMarcaEsquis(rs.getString("marca"));
                    esqui.setColorEsquis(rs.getString("color"));
                    esqui.setTallaEsquis(rs.getInt("talla"));
                    esqui.setPreuEsquis(rs.getDouble("preu"));
                    esqui.setCategoriaEsquis(rs.getString("categoria"));

                    esquis[i] = esqui;

                    i++;

                    // esqui.toString();
                }


        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void obtenirBotes(){
        try {
            Statement st = conn.createStatement();
            String botesProd = "SELECT * FROM botes;";
            ResultSet rs = st.executeQuery(botesProd); 

            int i=0;
                while (rs.next()) {
                    
                    Bota bota = new Bota();
                    bota.setIdBotes(rs.getInt("id_botes"));
                    bota.setMarcaBotes(rs.getString("marca"));
                    bota.setColorBota(rs.getString("color"));
                    bota.setTallaBotes(rs.getInt("talla"));
                    bota.setPreuBotes(rs.getDouble("preu"));
                    bota.setCategoriaBotes(rs.getString("categoria"));

                    botes[i] = bota;

                    i++;

                    // bota.toString();
                }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void obtenirPals(){
        try {
            Statement st = conn.createStatement();
            String palsProd = "SELECT * FROM pals;";
            ResultSet rs = st.executeQuery(palsProd); 

            int i=0;
                while (rs.next()) {
                    Pal pal = new Pal();
                    pal.setIdPals(rs.getInt("id_pals"));
                    pal.setMarcaPals(rs.getString("marca"));
                    pal.setColorPal(rs.getString("color"));
                    pal.setTallaPals(rs.getInt("talla"));
                    pal.setPreuPals(rs.getDouble("preu"));
                    pal.setCategoriaPals(rs.getString("categoria"));


                    pals[i] = pal;

                    i++;
                }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int cercar = 0; 

    private void obtenirKits() {
        try {
            Statement st = conn.createStatement();
            String kitsProd = "SELECT * FROM kit;";
            ResultSet rs = st.executeQuery(kitsProd); 

            int i=0;
                while (rs.next()) {
                    
                    Kit kit = new Kit();
                    kit.setIdKit(rs.getInt("id_kit"));
                        boolean trobatEsq = false;
                        int j = 0;
                        while (!trobatEsq){
                        
                            int test = (rs.getInt("id_esquis"));
                            // System.out.println("esqui: "+esquis[j].getIdEsquis()+"test: "+test);
                            if (esquis[j].getIdEsquis() == test) {
                                // System.out.println("Els esquis trobats");
                                   kit.setEsqui(esquis[j]);
                                   trobatEsq = true;
                                cercar++;
                            } else { j++;}
                        }
                       
                        boolean trobatBot = false;
                        int k = 0;

                        while (!trobatBot){
                        
                            int test = (rs.getInt("id_botes"));
                            // System.out.println("Botas: "+botes[k].getIdBotes()+"test: "+test);
                            if (botes[k].getIdBotes() == test) {
                                // System.out.println("Les botes trobades");
                                   kit.setBota(botes[k]);
                                   trobatBot = true;
                                cercar++;
                            } else { k++;}
                        }
                        
                        boolean trobatPal = false;
                        int l = 0;
                        while (!trobatPal){
                        
                            int test = (rs.getInt("id_pals"));
                            // System.out.println("Pal: "+pals[l].getIdPals()+"test: "+test);
                            if (pals[l].getIdPals() == test) {
                                // System.out.println("Els pals trobats");
                                   kit.setPal(pals[l]);
                                   trobatPal = true;
                                cercar++;
                            } else { l++;}
                        }
                    kit.setPreuTotal(rs.getDouble("preuTotal"));
                    kit.setData(rs.getString("data"));
                        
                    kits[i] = kit;

                    i++;

                }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
