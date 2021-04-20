package escobarsnow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import escobarsnow.classes.*;
import escobarsnow.GuardarArray.*;

public class Insersio {
    static Scanner teclat = new Scanner (System.in);
    
    public static void main(String[] args){
        boolean sortir=false;
        int opcio;

        while (!sortir) {
    System.out.println("======================================== MENU PRINCIPAL =======================================");
    System.out.println("|                                                                                              |");
    System.out.println("|                   _    ___                               _                              |");
    System.out.println("|                 / |    |_ _| _ __   ___   ___  _ __  ___ (_)  ___                        |");
    System.out.println("|                 | |    | | | '_ \\ / __| / _ \\| '__|/ __|| | / _ \\                       |");
    System.out.println("|                 | | _  | | | | | |\\__ \\|  __/| |  | (__ | || (_) |                      |");
    System.out.println("|                 |_|(_)|___||_| |_||___/ \\___||_|   \\___||_| \\___/                       |");                                        
    System.out.println("|                                                                                             |");
    System.out.println("|                                                                                              |");
    System.out.println("|                                                                                              |");
    System.out.println("===============================================================================================");

    opcio=teclat.nextInt();

    switch (opcio){
        
                case 1:
                    System.out.println("Has triat l'opcio 1");
                    
                    Insersio tenda = new Insersio();
                    tenda.llogarKits();
                    break;

                case 2:
                    System.out.println("Adeu");
                    sortir=true;
                    break;
        
                default:
                    System.out.println("FORMAT ERRONI");
            }
    
        }
        
    }
    
    // Inserir productes

    private final int TA = 200;
    Bota[] botes = GuardarArray.getBotes();
    Esqui[] esquis = GuardarArray.getEsqui();
    Pal[] pals =  GuardarArray.getPals();
    Connection con = null;
        
    private void llogarKits(){
        
        if (!obtenirKitsBotesPalsEsquisBD()){
            
            System.out.println("ERROR: No s'han pogut carregar a memòria: esquis, botes, pals, esquis");
            System.out.println("Intentau un altre dia");
            
        } else {
            
        }
    
    }
    
    private boolean obtenirKitsBotesPalsEsquisBD(){  
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/escobarsnow", "root", "");
            
            obtenirEsquis();
            obtenirPals();
            obtenirBotes();
                    
        } catch(Exception e){
            
        }
        return true;
    }
    
    private void obtenirEsquis(){
        
        try{
            
        Statement st = con.createStatement();
        String esquisprod = "SELECT * FROM esquis;";
        ResultSet rs = st.executeQuery(esquisprod);
        int i=0;
        
        while (rs.next()){
            
            Esqui esqui = new Esqui();
            esqui.setIdEsquis(rs.getInt("id_esquis"));
            esqui.setMarcaEsquis(rs.getString("marca"));
            esqui.setColorEsquis(rs.getString("color"));
            esqui.setTallaEsquis(rs.getInt("talla"));
            esqui.setPreuEsquis(rs.getDouble("preu"));
            
            esquis[i] = esqui;
            i++; 
            
            esqui.toString();
        }
        visualitzarEsquis();
        } catch (Exception e){
            
        }
        
    }
    
    private void obtenirPals(){
        
        try{
            
        Statement st = con.createStatement();
        String palsprod = "SELECT * FROM pals;";
        ResultSet rs = st.executeQuery(palsprod);
        int i=0;
        
        while (rs.next()){
            
            Pal pal = new Pal();
            pal.setIdPals(rs.getInt("id_pals"));
            pal.setMarcaPals(rs.getString("marca"));
            pal.setColorPal(rs.getString("color"));
            pal.setTallaPals(rs.getInt("talla"));
            pal.setPreuPals(rs.getDouble("preu"));
            
            pals[i] = pal;
            i++; 
            
            pal.toString();
        }
        visualitzarPals();
        } catch (Exception e){
            
        }
        
    }
     
    private void obtenirBotes(){
        
        try{
            
        Statement st = con.createStatement();
        String botesprod = "SELECT * FROM botes;";
        ResultSet rs = st.executeQuery(botesprod);
        int i=0;
        
        while (rs.next()){
            
            Bota bota = new Bota();
            bota.setIdBotes(rs.getInt("id_botes"));
            bota.setMarcaBotes(rs.getString("marca"));
            bota.setColorBota(rs.getString("color"));
            bota.setTallaBotes(rs.getInt("talla"));
            bota.setPreuBotes(rs.getDouble("preu"));
            
            botes[i] = bota;
            i++; 
            
            bota.toString();
        }
        visualitzarEsquis();
        } catch (Exception e){
            
        }
        
    } 
    
    private void visualitzarEsquis(){
    System.out.println("ELS ESQUIS QUE HI HA: \n");
    for (int i=0; (i<TA && esquis[i] !=null); i++){
    System.out.println("Esqui: " + esquis [i]);
      }
    }
    
    private void visualitzarPals(){
    System.out.println("ELS PALS QUE HI HA: \n");
    for (int i=0; (i<TA && pals[i] !=null); i++){
    System.out.println("Pal: " + pals [i]);
      }
    }
        
    private void visualitzarBotes(){
    System.out.println("ELS BOTES QUE HI HA: \n");
    for (int i=0; (i<TA && botes[i] !=null); i++){
    System.out.println("Bota: " + botes [i]);
      }
    }
    
    
}
