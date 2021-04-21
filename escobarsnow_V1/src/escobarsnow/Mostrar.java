// Pantalla per a mostrar tots els productes o un tipus de producte (esquis, botes o pals)
package escobarsnow;

import escobarsnow.classes.*;
import escobarsnow.GuardarArray.*;

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
                            // esquis.obtenirEsquis();
                            esquis.visualitzarEsquis();
                            
                            System.out.println("\nApreta RETURN per sortir al submenu");
                            teclat.nextLine();
                            teclat.nextLine();
                            break;
                            
                        case 'P':
                            System.out.format("%-2s %-20s %-15s %-15s %-15s %-15s %-15s", "", "ID PRODUCTE", "MARCA", "COLOR", "TALLA", "PREU", "CATEGORIA");
                            System.out.println("");
                            Mostrar pals = new Mostrar();
                            // pals.obtenirPals();
                            pals.visualitzarPals();
                            
                            System.out.println("\nApreta RETURN per sortir al submenu");
                            teclat.nextLine();
                            teclat.nextLine();
                        break;
                        
                        case 'B':
                            System.out.format("%-2s %-20s %-15s %-15s %-15s %-15s %-15s", "", "ID PRODUCTE", "MARCA", "COLOR", "TALLA", "PREU", "CATEGORIA");
                            System.out.println("");
                            Mostrar botes = new Mostrar();
                            // botes.obtenirBotes();
                            botes.visualitzarBotes();
                            
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

    // Crida dels arrays ja creats en l'arxiu GuardarArray.java
    private final int TA = 200;
    Bota[] botes = GuardarArray.getBotes();
    Esqui[] esquis = GuardarArray.getEsqui();
    Pal[] pals =  GuardarArray.getPals();
        
    // Mètodes de mostrar els productes
    private void llogarKits(){
        if (!obtenirKitsBotesPalsEsquisBD()){
            System.out.println("ERROR");
        }
    }
    
    // Obtenir dades dels arrays
    private boolean obtenirKitsBotesPalsEsquisBD() {
        try{

            visualitzarEsquis();
            visualitzarPals();
            visualitzarBotes();


        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    
    // Visualitzar els esquis
    private void visualitzarEsquis(){
        //System.out.println("ESQUIS des de ARRAYS: \n");
        
        for (int i = 0; (i < TA && esquis [i] != null); i++){
            System.out.println(esquis[i]);
        }
    }
    
    private void visualitzarBotes(){
        //System.out.println("Botes des de ARRAYS: \n");
        
        for (int i = 0; (i < TA && botes [i] != null); i++){
            System.out.println(botes[i]);
        }
    }
    
    private void visualitzarPals(){
        //System.out.println("PALS des de ARRAYS: \n");
        
        for (int i = 0; (i < TA && pals [i] != null); i++){
            System.out.println(pals[i]);
        }
    }
}