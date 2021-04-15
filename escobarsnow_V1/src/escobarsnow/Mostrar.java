/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escobarsnow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author JO
 */
public class Mostrar {
    
    static Scanner teclat = new Scanner (System.in);
    static String opcio;

    void mostrar() {
        Scanner teclat = new Scanner(System.in);

    boolean sortir=false;
    String opcio;

    try{

        //FEM LA CONNEXIÓ AMB LA BD    

        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escobarsnow", "root", "");
        ConnexioBD conn = new ConnexioBD();
        conn.connbd();

        //COMANDA PER A MOSTRAR TOTS ELS PRODUCTES

        String query = "SELECT * FROM esquis";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        //ESTRUCTURA DE LA TAULA ON ES MOSTRARAN ELS PRODUCTES
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-1s %-20s %-20s %-20s %-20s %-20s %-20s", "", "ID", "MARCA", "COLOR", "TALLA", "CATEGORIA", "PREU");
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        while (rs.next())
        {
          int id_esquis = rs.getInt("id_esquis");
          String marca = rs.getString("marca");
          String color = rs.getString("color");
          String talla = rs.getNString("talla");
          String categoria = rs.getNString("categoria");
          String preu = rs.getString("preu");

          System.out.format("%-1s %-20s %-20s %-20s %-20s %-20s %-20s\n", "", id_esquis, marca, color, talla, categoria, preu + "€");
        }
        st.close();

    }
    catch (Exception e)
        {
        System.err.println("Got an exception! ");
        e.printStackTrace();
        }
    }
        
    }
    /**
    
    
    public static void mostrar ( {

    Scanner teclat = new Scanner(System.in);

    boolean sortir=false;
    String opcio;

    try{

        //FEM LA CONNEXIÓ AMB LA BD    

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsagency", "root", "");


        //COMANDA PER A MOSTRAR TOTS ELS PRODUCTES

        String query = "SELECT * FROM productes";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        //ESTRUCTURA DE LA TAULA ON ES MOSTRARAN ELS PRODUCTES

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-20s %-50s %-40s %-25s %-25s", "ID PRODUCTE", "PRODUCTE", "LOCALITZACIÓ", "CONCEPTE", "PREU");
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

        while (rs.next())
        {
          int id_producte = rs.getInt("id_producte");
          String nom_producte = rs.getString("nom_producte");
          String localitzacio = rs.getString("localitzacio");
          String concepte = rs.getNString("concepte");
          String preu = rs.getString("preu");

          System.out.format("%-20s %-50s %-40s %-25s %-25s\n", id_producte, nom_producte, localitzacio, concepte, preu + "€");
        }
        st.close();

    }
    catch (Exception e)
        {
        System.err.println("Got an exception! ");
        e.printStackTrace();
        }
    }
    */

