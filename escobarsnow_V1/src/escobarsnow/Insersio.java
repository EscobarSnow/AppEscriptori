// Pantalla per inserir productes
package escobarsnow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import escobarsnow.classes.*;
import escobarsnow.GuardarArray.*;

public class Insersio {

    static Scanner teclat = new Scanner (System.in);

    // Crida dels arrays amb les dades
    private final int TA = 200;
    Bota[] botes = GuardarArray.getBotes();
    Esqui[] esquis = GuardarArray.getEsqui();
    Pal[] pals =  GuardarArray.getPals();
    static Connection conn = null;
    static Scanner sc = null;
    static PreparedStatement ps = null;

    // Menú
    public static boolean Insersio(){
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
    System.out.println("|                                                                                             |");
    System.out.println("|                                                                                             |");
    System.out.println("|       1. Esquis                                                                                         |");
    System.out.println("|                                                                                             |");
    System.out.println("|       2. Botes                                                                                      |");
    System.out.println("|                                                                                             |");
    System.out.println("|       3.Pals                                                                                       |");
    System.out.println("|                                                                                             |");
    System.out.println("|                                                                                             |");
    System.out.println("|       4.Tornar                                                                                      |");
    System.out.println("|                                                                                              |");
    System.out.println("===============================================================================================");

    opcio=teclat.nextInt();

    switch (opcio){
        
                case 1:
                        inserirEsquis();
                    break;

                case 2:
                        inserirBotes();
                    break;

                case 3:
                        inserirPals();
                    break;

                case 4:
                    System.out.println("Adeu");
                    sortir=true;
                    break;
        
                default:
                    System.out.println("FORMAT ERRONI");
            }
    
        }
        return true; 
    }
    
    // Inserir productes
    
    // Inserir botes (insereix tant a la bd com a l'array)
    public static boolean inserirBotes(){

        try {
            sc = new Scanner(System.in);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escobarsnow", "root", "");

                if (conn != null) {
                    ps = conn.prepareStatement("INSERT INTO botes (marca, color, talla, preu, categoria) VALUES (?, ?, ?, ?, ?)");

                    if (ps != null) {
                                                
                        System.out.println("Insererix la marca");
                        String marca = sc.next();

                        System.out.println("Insereix el color");
                        String color = sc.next();

                        System.out.println("Insereix la talla");
                        int talla = sc.nextInt();

                        System.out.println("Insereix el preu");
                        Double preu = sc.nextDouble();

                        System.out.println("Insereix la categoria");
                        String categoria = sc.next();

                        ps.setString(1, marca);
                        ps.setString(2, color);
                        ps.setInt(3, talla);
                        ps.setDouble(4, preu);
                        ps.setString(5, categoria);

                        int res = ps.executeUpdate();

                        Bota bota = new Bota();

                        bota.setMarcaBotes(marca);
                        bota.setColorBota(color);
                        bota.setTallaBotes(talla);
                        bota.setPreuBotes(preu);
                        bota.setCategoriaBotes(categoria);

                        if (res == 0) {
                            System.out.println("No s'ha pogut inserir el producte");
                        } else{
                            System.out.println("El producte s'ha inserit correctament");
                        }

                    }

                }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try{
                if (conn != null) {
                    conn.close();
                }
            }catch (SQLException se){
                se.printStackTrace();
            }            
        }

        return true;
    }
        
    // Inserir esquis (insereix tant a la bd com a l'array)
    public static boolean inserirEsquis(){

        try {
            sc = new Scanner(System.in);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escobarsnow", "root", "");

                if (conn != null) {
                    ps = conn.prepareStatement("INSERT INTO esquis (marca, color, talla, preu, categoria) VALUES (?, ?, ?, ?, ?)");

                    if (ps != null) {
                                                
                        System.out.println("Insererix la marca");
                        String marca = sc.next();

                        System.out.println("Insereix el color");
                        String color = sc.next();

                        System.out.println("Insereix la talla");
                        int talla = sc.nextInt();

                        System.out.println("Insereix el preu");
                        Double preu = sc.nextDouble();

                        System.out.println("Insereix la categoria");
                        String categoria = sc.next();

                        ps.setString(1, marca);
                        ps.setString(2, color);
                        ps.setInt(3, talla);
                        ps.setDouble(4, preu);
                        ps.setString(5, categoria);

                        int res = ps.executeUpdate();

                        Esqui esqui = new Esqui();

                        esqui.setMarcaEsquis(marca);
                        esqui.setColorEsquis(color);
                        esqui.setTallaEsquis(talla);
                        esqui.setPreuEsquis(preu);
                        esqui.setCategoriaEsquis(categoria);

                        if (res == 0) {
                            System.out.println("No s'ha pogut inserir el producte");
                        } else{
                            System.out.println("El producte s'ha inserit correctament");
                        }

                    }

                }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try{
                if (conn != null) {
                    conn.close();
                }
            }catch (SQLException se){
                se.printStackTrace();
            }            
        }
        return true;
    }

    // Inserir pals (insereix tant a la bd com a l'array)
    public static boolean inserirPals(){

        try {
            sc = new Scanner(System.in);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escobarsnow", "root", "");

                if (conn != null) {
                    ps = conn.prepareStatement("INSERT INTO pals (marca, color, talla, preu, categoria) VALUES (?, ?, ?, ?, ?)");

                    if (ps != null) {
                                                
                        System.out.println("Insererix la marca");
                        String marca = sc.next();

                        System.out.println("Insereix el color");
                        String color = sc.next();

                        System.out.println("Insereix la talla");
                        int talla = sc.nextInt();

                        System.out.println("Insereix el preu");
                        Double preu = sc.nextDouble();

                        System.out.println("Insereix la categoria");
                        String categoria = sc.next();

                        ps.setString(1, marca);
                        ps.setString(2, color);
                        ps.setInt(3, talla);
                        ps.setDouble(4, preu);
                        ps.setString(5, categoria);

                        int res = ps.executeUpdate();

                        Pal pal = new Pal();

                        pal.setMarcaPals(marca);
                        pal.setColorPal(color);
                        pal.setTallaPals(talla);
                        pal.setPreuPals(preu);
                        pal.setCategoriaPals(categoria);

                        if (res == 0) {
                            System.out.println("No s'ha pogut inserir el producte");
                        } else{
                            System.out.println("El producte s'ha inserit correctament");
                        }

                    }

                }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try{
                if (conn != null) {
                    conn.close();
                }
            }catch (SQLException se){
                se.printStackTrace();
            }            
        }
        return true;
    }
}