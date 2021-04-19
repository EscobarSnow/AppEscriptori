
package escobarsnow;

import escobarsnow.classes.Bota;
import escobarsnow.classes.Esqui;
import escobarsnow.classes.Kit;
import escobarsnow.classes.Pal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Mostrar {
    
    static Scanner teclat = new Scanner (System.in);
    static String opcio;

    public static boolean Mostrar() throws SQLException {
        Scanner teclat = new Scanner(System.in);

    boolean sortir=false;
    String opcio;

    while (!sortir) {
                        System.out.println(" ==============================================================================================================");
                        System.out.println("│                                                                                                             │");
                        System.out.println("│ █████╗░████╗░███╗░░██╗░████╗░░██╗░████╗░░████╗██░░█╗░██╗░█╗░░░░░░░█╗ │\n" +
                                           "│ █╔═══╝█╔═══╝█╔══█╗█╔═█╗█╔═██╗█╔═█╗█╔═██╗█╔═══╝███░█║█╔═█╗█║░░██╗░░█║ │\n" +
                                           "│ ███╗░░╚███╗░█║░░╚╝█║░█║████╦╝████║████╔╝╚███╗░█╔███║█║░█║╚█╗████╗█╔╝ │\n" +
                                           "│ █╔═╝░░░╚══█╗█║░░█╗█║░█║█╔═██╗█╔═█║█╔═██╗░╚══█╗█║╚██║█║░█║░███╔═███║░ │\n" +
                                           "│ █████╗████╔╝╚███╔╝╚██╔╝████╦╝█║░█║█║░██║████╔╝█║░╚█║╚██╔╝░╚█╔╝░╚█╔╝░ │\n" +
                                           "│ ╚════╝╚═══╝░░╚══╝░░╚═╝░╚═══╝░╚╝░╚╝╚╝░╚═╝╚═══╝░╚╝░░╚╝░╚═╝░░░╚╝░░░╚╝░░ │");
                        System.out.println("│                                                                                                             │");
                        System.out.println("│                                ____                _            _                                           │");
                        System.out.println("│                               |  _ \\ _ __ ___   __| |_   _  ___| |_ ___  ___                                │");
                        System.out.println("│                               | |_) | '__/ _ \\ / _` | | | |/ __| __/ _ \\/ __|                               │");
                        System.out.println("│                               |  __/| | | (_) | (_| | |_| | (__| ||  __/\\__ \\                               │");
                        System.out.println("│                               |_|   |_|  \\___/ \\__,_|\\__,_|\\___|\\__\\___||___/                               │");
                        System.out.println("│                                                                                                             │");
                        System.out.println(" ==============================================================================================================");
                        System.out.format("%-2s %-20s %-15s %-15s %-15s %-15s %-15s", "", "ID PRODUCTE", "MARCA", "COLOR", "TALLA", "PREU", "CATEGORIA");
                        System.out.println("");
                        Mostrar tenda = new Mostrar();
                        tenda.llogarKits();
                        
                        System.out.println("\nApreta E per mostrar els esquis");
                        System.out.println("Apreta P per mostrar els pals");
                        System.out.println("Apreta B per mostrar les botes");
                        System.out.println("Apreta X per sortir....");
                        
                        opcio=teclat.next();
                        switch(opcio.charAt(0)){
                        
                        //SUBMENU
                        
                        case 'E':
                            System.out.format("%-2s %-20s %-15s %-15s %-15s %-15s %-15s", "", "ID PRODUCTE", "MARCA", "COLOR", "TALLA", "PREU", "CATEGORIA");
                            System.out.println("");
                            Mostrar esquis = new Mostrar();
                            esquis.obtenirEsquis();
                            
                            System.out.println("\nApreta RETURN per sortir al submenu");
                            teclat.nextLine();
                            teclat.nextLine();
                            break;
                            
                        case 'P':
                            System.out.format("%-2s %-20s %-15s %-15s %-15s %-15s %-15s", "", "ID PRODUCTE", "MARCA", "COLOR", "TALLA", "PREU", "CATEGORIA");
                            System.out.println("");
                            Mostrar pals = new Mostrar();
                            pals.obtenirPals();
                            
                            System.out.println("\nApreta RETURN per sortir al submenu");
                            teclat.nextLine();
                            teclat.nextLine();
                        break;
                        
                        case 'B':
                            System.out.format("%-2s %-20s %-15s %-15s %-15s %-15s %-15s", "", "ID PRODUCTE", "MARCA", "COLOR", "TALLA", "PREU", "CATEGORIA");
                            System.out.println("");
                            Mostrar botes = new Mostrar();
                            botes.obtenirBotes();
                            
                            System.out.println("\nApreta RETURN per sortir al submenu");
                            teclat.nextLine();
                            teclat.nextLine();
                        break;
                        
                        case 'X':
                            sortir = true;
                        break;
                        }
    }
        return true;
}
    private final int TAMANYARRAY = 200;
    
    //variables globals
    Bota[] botes = new Bota [TAMANYARRAY];
    Esqui[] esquis = new Esqui [TAMANYARRAY];
    Pal[] pals = new Pal [TAMANYARRAY];
    Kit[] kits = new Kit [TAMANYARRAY];
    
    //guardar el numero de kits
    int numKits = 0;
    
    private void llogarKits(){
        if (!obtenirKitsBotesPalsEsquisBD()){
            System.out.println("ERROR");
        }
    }
    
    private boolean obtenirKitsBotesPalsEsquisBD() {
        try{
         
            obtenirEsquis();
            obtenirPals();
            obtenirBotes();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    
    private void obtenirEsquis() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escobarsnow", "root", "");
        try{
            Statement st = conn.createStatement();
            String query = "SELECT * FROM esquis";

            ResultSet rs = st.executeQuery(query);

            int i = 0;
            while (rs.next()){

            Esqui esqui = new Esqui();
            esqui.setIdEsquis (rs.getInt("id_esquis"));
            esqui.setMarcaEsquis(rs.getString("Marca"));
            esqui.setColorEsquis (rs.getString("Color"));
            esqui.setTallaEsquis (rs.getInt("Talla"));
            esqui.setPreuEsquis (rs.getDouble("Preu"));
            esqui.setCategoriaEsquis (rs.getString("Categoria"));

            esquis[i] = esqui;
            i++;
            
            esqui.toString();
            
            } 
            visualitzarEsquis();
        }catch (Exception e){
            e.printStackTrace();
        }
    
    }

    private void obtenirBotes() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escobarsnow", "root", "");
        try{
            Statement st = conn.createStatement();
            String query = "SELECT * FROM botes";

            ResultSet rs = st.executeQuery(query);

            int i = 0;
            while (rs.next()){

            Bota bota = new Bota();
            bota.setIdBotes (rs.getInt("id_botes"));
            bota.setMarcaBotes (rs.getString("Marca"));
            bota.setColorBota (rs.getString("Color"));
            bota.setTallaBotes (rs.getInt("Talla"));
            bota.setPreuBotes (rs.getDouble("Preu"));
            bota.setCategoriaBotes (rs.getString("Categoria"));

            botes[i] = bota;
            
            i++;
            
            bota.toString();
            
            } 
            visualitzarBotes();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    private void obtenirPals() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escobarsnow", "root", "");
        try{
            Statement st = conn.createStatement();
            String query = "SELECT * FROM pals";

            ResultSet rs = st.executeQuery(query);

            int i = 0;
            while (rs.next()){

            Pal pal = new Pal();
            pal.setIdPals (rs.getInt("id_pals"));
            pal.setMarcaPals (rs.getString("Marca"));
            pal.setColorPal (rs.getString("Color"));
            pal.setTallaPals (rs.getInt("Talla"));
            pal.setPreuPals (rs.getDouble("Preu"));
            pal.setCategoriaPals (rs.getString("Categoria"));

            pals[i] = pal;
            
            i++;
            pals.toString();
            
            } 
            visualitzarPals();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    private void visualitzarEsquis(){
        //System.out.println("ESQUIS des de ARRAYS: \n");
        
        for (int i = 0; (i < TAMANYARRAY && esquis [i] != null); i++){
            System.out.println(esquis[i]);
        }
    }
    
    private void visualitzarBotes(){
        //System.out.println("Botes des de ARRAYS: \n");
        
        for (int i = 0; (i < TAMANYARRAY && botes [i] != null); i++){
            System.out.println(botes[i]);
        }
    }
    
    private void visualitzarPals(){
        //System.out.println("PALS des de ARRAYS: \n");
        
        for (int i = 0; (i < TAMANYARRAY && pals [i] != null); i++){
            System.out.println(pals[i]);
        }
    }
}