package escobarsnow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;  

import escobarsnow.classes.*;
import escobarsnow.GuardarArray.*;

public class CrearKit {
    private final int TA = 200;
    static Bota[] botes = GuardarArray.getBotes();
    static Esqui[] esquis = GuardarArray.getEsqui();
    static Pal[] pals =  GuardarArray.getPals();
    static Kit[] akits = GuardarArray.getKits();

    static Scanner teclat = new Scanner(System.in);

    public static boolean CrearKit(){

        Connection conn = null;
        Scanner sc = null;
    
        CrearKit tenda = new CrearKit();

        PreparedStatement ps = null;

        try {
            sc = new Scanner(System.in);

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escobarsnow", "root", "");

            if (conn != null) {
                ps = conn.prepareStatement("INSERT INTO kit (id_botes, id_esquis, id_pals, data, preuTotal) VALUES (?, ?, ?, ?, ?)");
            
                if (ps != null) {

                    // Inserir i validar Esquis
                    System.out.println("Quin esqui?");
                    int idEsq = sc.nextInt();

                    boolean trobarEsq = false;
                    int i = 0;

                        while (!trobarEsq) {
                
                            if (esquis[i].getIdEsquis() == idEsq ) {

                                int mostrar = esquis[i].getIdEsquis();

                                System.out.println("L'esqui existeix!");
                                trobarEsq = true;
                            } else {
                                i++;
                            }
                
                        }
                    
                    // Inserir i validar Botes 
                    System.out.println("Quines botes?");
                    int idBot = sc.nextInt();

                    boolean trobarBot = false;
                    int j = 0;

                    while (!trobarBot) {
                
                        if (botes[j].getIdBotes() == idBot ) {
                            System.out.println("Les botes existeixen!");
                            trobarBot = true;
                        } else {
                            j++;
                        }
            
                    }

                    //  Inserir i validar Pals
                    System.out.println("Quins pals?");
                    int idPal = sc.nextInt();

                    boolean trobarPal = false;
                    int k = 0;

                    while (!trobarPal) {
                
                        if (pals[k].getIdPals() == idPal ) {
                            System.out.println("Els pals existeixen!");
                            trobarPal = true;
                        } else {
                            k++;
                        }
            
                    }


                    System.out.println("Quina es la data inici del lloguer?");

                    String data =sc.next();

                    
                    // Calcular preu total

                    
                        if (esquis[i].getIdEsquis() == idEsq && botes[j].getIdBotes() == idBot && pals[k].getIdPals() == idPal) {
                            Double preuEsq = esquis[i].getPreuEsquis();
                            Double preuBot = botes[j].getPreuBotes();
                            Double preuPal = pals[k].getPreuPals();

                            Double preuTotalKit = preuEsq + preuBot + preuPal;

                            System.out.println("Preu total del kit: " + preuTotalKit);
                            
                            // return preuTotalKit;
                            ps.setInt(1, idBot);
                            ps.setInt(2, idEsq);
                            ps.setInt(3, idPal);
                            ps.setString(4, data);
                            ps.setDouble(5, preuTotalKit);

                            int res = ps.executeUpdate();
                            if (res == 0) {
                                System.out.println("No s'ha pogut crear el kit");
                            } else{
                                System.out.println("El kit s'ha creat correctament");
                            }
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
