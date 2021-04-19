package escobarsnow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Insersió {
    static Scanner teclat = new Scanner (System.in);
    
    public static void main(String[] args){
        boolean sortir=false;
        String opcio;

        while (!sortir) {
    System.out.println("======================================== MENU PRINCIPAL =======================================");
    System.out.println("|                                                                                             |");
    System.out.println("|                                                                                             |");
    System.out.println("|           _     __  __              _                          _          __                |");
    System.out.println("|         / |   |  \\/  |  ___   ___ | |_  _ __  __ _  _ __    (_) _ __   / _|  ___            |");
    System.out.println("|         | |   | |\\/| | / _ \\ / __|| __|| '__|/ _` || '__|  | || '_ \\| |_  / _ \\             |");
    System.out.println("|         | | _ | |  | || (_) |\\__ \\| |_ | |  | (_| || |     | || | | ||  _|| (_) |           |");
    System.out.println("|         |_|(_)|_|  |_| \\___/ |___/ \\__||_|   \\__,_||_|    |_||_| |_||_|   \\___/             |");                                                                               
    System.out.println("|                                                                                             |");
    System.out.println("|                                                                                             |");
    System.out.println("|                  ____      ___                               _                              |");
    System.out.println("|                 |___ \\    |_ _| _ __   ___   ___  _ __  ___ (_)  ___                        |");
    System.out.println("|                   __) |    | | | '_ \\ / __| / _ \\| '__|/ __|| | / _ \\                       |");
    System.out.println("|                  / __/  _  | | | | | |\\__ \\|  __/| |  | (__ | || (_) |                      |");
    System.out.println("|                 |_____|(_)|___||_| |_||___/ \\___||_|   \\___||_| \\___/                       |");                                        
    System.out.println("|                                                                                             |");
    System.out.println("|                                                                                              |");
    System.out.println("|                                                                                              |");
    System.out.println("===============================================================================================");

    opcio=teclat.next();

    switch (opcio.charAt(0)){
        
                case '1':
                    System.out.println("Has triat l'opcio 1");
                    
                    infoinsercio tenda = new infoinsercio();
                    tenda.llogarKits();
                    break;
                case '2':
                    System.out.println("Has triat l'opcio 2"); 
                    break;
                case '3':
                    System.out.println("Adeu");
                    sortir=true;
                    break;
        
                default:
                    System.out.println("FORMAT ERRONI");
            }
    
        }
        
    }
    
    private final int TA=200;
    //Scanner teclat = new Scanner(System.in);
    Bota[] botes = new Bota[TA];
    Esqui[] esquis = new Esqui[TA];
    Pal[] pals = new Pal[TA];
    Kit[] kits = new Kit[TA];
    int numKits = 0;
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
            esqui.setIdEsqui(rs.getInt("id_esquis"));
            esqui.setMarcaEsqui(rs.getString("marca"));
            esqui.setColorEsqui(rs.getString("color"));
            esqui.setTallaEsqui(rs.getInt("talla"));
            esqui.setPreuEsqui(rs.getDouble("preu"));
            
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
            pal.setIdPal(rs.getInt("id_pals"));
            pal.setMarcaPal(rs.getString("marca"));
            pal.setColorPal(rs.getString("color"));
            pal.setTallaPal(rs.getInt("talla"));
            pal.setPreuPal(rs.getDouble("preu"));
            
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
            bota.setIdBota(rs.getInt("id_botes"));
            bota.setMarcaBota(rs.getString("marca"));
            bota.setColorBota(rs.getString("color"));
            bota.setTallaBota(rs.getInt("talla"));
            bota.setPreuBota(rs.getDouble("preu"));
            
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
    
    private void visualitzarKits(){
    System.out.println("ELS KITS QUE HI HA: \n");
    for (int i=0; (i<TA && kits[i] !=null); i++){
    System.out.println("Kit: " + kits [i]);
      }
    }
    
}
