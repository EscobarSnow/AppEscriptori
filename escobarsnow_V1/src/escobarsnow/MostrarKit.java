package escobarsnow;


import escobarsnow.classes.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class MostrarKit {
    
    static Scanner teclat = new Scanner (System.in);
    static String opcio;
    public static int cercar = 0; 
    private final int TAMANYARRAY = 200;
    Bota[] botes = new Bota[200];
    Esqui[] esquis = new Esqui[200];
    Pal[] pals = new Pal[200];
    Kit[] kits = new Kit[200];
    Connection conn = null;

    public static boolean MostrarKit() {
        Scanner teclat = new Scanner(System.in);

        boolean sortir=false;
        int opcio; //Cambi de string a int

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
                System.out.println("│                                   __  __              _                       _     _  _                                         │");
                System.out.println("│                                  |  \\/  |  ___   ___ | |_  _ __  __ _  _ __  | | __(_)| |_                                        │");
                System.out.println("│                                  | |\\/| | / _ \\ / __|| __|| '__|/ _` || '__| | |/ /| || __|                                         │");
                System.out.println("│                                  | |  | || (_) |\\__ \\| |_ | |  | (_| || |    |   < | || |_                                         │");
                System.out.println("│                                  |_|  |_| \\___/ |___/ \\__||_|   \\__,_||_|    |_|\\_\\|_| \\__|                                                  │");
                System.out.println("│                                                                                                             │");
                System.out.println(" ==============================================================================================================");
                System.out.println("│  _      _  __ _  _         _        _       _  _                                                                                                                   │");
                System.out.println("│ / |    | |/ /(_)| |_    __| |  ___ | |   __| |(_)  __ _                                                                                                            │");
                System.out.println("│ | |    | ' / | || __|  / _` | / _ \\| |  / _` || | / _` |                                                                                                           │");
                System.out.println("│ | | _  | . \\ | || |_  | (_| ||  __/| | | (_| || || (_| |                                                                                                           │");
                System.out.println("│ |_|(_) |_|\\_\\|_| \\__|  \\__,_| \\___||_|  \\__,_||_| \\__,_|                                                                                                           │");
                System.out.println("│                                                                                                             │");
                System.out.println("│ ____       _  __ _  _                                                                                                                 │");
                System.out.println("│ |___ \\     | |/ /(_)| |_  ___                                                                                                          │");
                System.out.println("│   __) |    | ' / | || __|/ __|                                                                                                         │");
                System.out.println("│  / __/  _  | . \\ | || |_ \\__ \\                                                                                                         │");
                System.out.println("│ |_____|(_) |_|\\_\\|_| \\__||___/                                                                                                         │");
                System.out.println("│                                                                                                             │");
                System.out.println("│ _____     _  __ _  _                  __                                                                                                                                  │");
                System.out.println("│ |___ /    | |/ /(_)| |_   _ __ ___    /_/  ___    ___  __ _  _ __                                                                                                           │");
                System.out.println("│   |_ \\    | ' / | || __| | '_ ` _ \\  / _ \\/ __|  / __|/ _` || '__|                                                                                                         │");
                System.out.println("│  ___) |_  | . \\ | || |_  | | | | | ||  __/\\__ \\ | (__| (_| || |                                                                                                            │");
                System.out.println("│ |____/(_) |_|\\_\\|_| \\__| |_| |_| |_| \\___||___/  \\___|\\__,_||_|                                                                                                           │");
                System.out.println("│                                                                                                            │");
                System.out.println("│  _  _       _____                                                                                                                                         │");
                System.out.println("│ | || |     |_   _|___   _ __  _ __    __ _  _ __                                                                                                          │");
                System.out.println("│ | || |_      | | / _ \\ | '__|| '_ \\  / _` || '__|                                                                                                         │");
                System.out.println("│ |__   _|_    | || (_) || |   | | | || (_| || |                                                                                                            │");
                System.out.println("│    |_| (_)   |_| \\___/ |_|   |_| |_| \\__,_||_|                                                                                                           │");
                System.out.println("│                                                                                                             │");
                System.out.println(" ==============================================================================================================");


                 if (!teclat.hasNextInt()) {
                    System.out.println("Has d'introduir un nº com a opció");
                    teclat.next();
                } else {
                    // agafem les opcions que ens donen per a navegar (1, 2 i 3)
                    opcio = teclat.nextInt();
                    switch (opcio) {
                        case 1:
                            if (kitsDia()) {
                            } else {
                                System.out.println("Torna a intentar");
                            }

                            break;

                        case 2:
                            if (kitMostrar()) {
                            } else {
                                System.out.println("Torna a intentar");
                            }
                           
                            break;

                        case 3:

                            break;

                        case 4:

                            sortir = true;
                            break;
                    
                        default:
                            break;
                    }
                }
        }

        return true;
    }

    // Mostrar els kits d'un dia

    public static boolean kitsDia() {
        
        MostrarKit dia = new MostrarKit();
        dia.showKitsDia();

        return true;
    }

    private void showKitsDia() {
        
        if (!conseguirKits()) {
            System.out.println("error");
        }
    }

    private boolean conseguirKits() {
        
        try {
            conseguirKitsDia();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    private void conseguirKitsDia() {
        
        boolean trobat = false;
        int x = 0;

        System.out.println("Insereix una data");
        Scanner teclat = new Scanner(System.in);

        String data = teclat.next();
        

        while (!trobat){
            Kit kit = new Kit();
            System.out.println("Kit: "+kits[x].getIdKit());
            if (kits[x].getData() == data) {
                System.out.println("Els kits trobats el dia " +data);
                kit.toString();
                   trobat = true;
                cercar++;
                
            } else { x++;}
        }
        if (cercar > 0) {
            System.out.println("Els esquis existeixen");
        } else{
            System.out.println("Els esquis no existeixen");
        }
        visualitzarKits();
    }

    //Mostrar tots els kits
    public static boolean kitMostrar() {
        MostrarKit tenda = new MostrarKit();
        tenda.showKits();
        return true;
    }

    private void showKits() {
        if (!obtenirKitsBD()) {
            System.out.println("Error");
        }
    }

    private boolean obtenirKitsBD() {
      
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escobarsnow", "root", "");
           
            obtenirKits();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private void obtenirKits() {
        try {
            Statement st = conn.createStatement();
            String kitsProd = "SELECT * FROM kit;";
            ResultSet rs = st.executeQuery(kitsProd); 

            int i=0;
                while (rs.next()) {
                    
                    Kit kit = new Kit();
                    kit.setIdKit(rs.getInt("id_kit"));
                  
                        System.out.println("Quanttat: "+esquis.length);
                        boolean trobat = false;
                        int x = 0;
                        while (!trobat){
                        
                            int test = (rs.getInt("id_esquis"));
                            System.out.println("esqui: "+esquis[x].getIdEsquis()+"test: "+test);
                            if (esquis[x].getIdEsquis() == test) {
                                System.out.println("Els esquis trobats");
                                   kit.setEsqui(esquis[x]);
                                   trobat = true;
                                cercar++;
                            } else { x++;}
                        }
                        if (cercar > 0) {
                            System.out.println("Els esquis existeixen");
                        } else{
                            System.out.println("Els esquis no existeixen");
                        }

                        while (!trobat){
                        
                            int test = (rs.getInt("id_botes"));
                            System.out.println("Botas: "+botes[x].getIdBotes()+"test: "+test);
                            if (botes[x].getIdBotes() == test) {
                                System.out.println("Les botes trobades");
                                   kit.setBota(botes[x]);
                                   trobat = true;
                                cercar++;
                            } else { x++;}
                        }
                        if (cercar > 0) {
                            System.out.println("Les botes existeixen");
                        } else{
                            System.out.println("Les botes no existeixen");
                        }
                        while (!trobat){
                        
                            int test = (rs.getInt("id_pals"));
                            System.out.println("Pal: "+pals[x].getIdPals()+"test: "+test);
                            if (pals[x].getIdPals() == test) {
                                System.out.println("Els pals trobats");
                                   kit.setPal(pals[x]);
                                   trobat = true;
                                cercar++;
                            } else { x++;}
                        }
                        if (cercar > 0) {
                            System.out.println("Els pals existeixen");
                        } else{
                            System.out.println("Els pals no existeixen");
                        }
 
                    kits[i] = kit;

                    i++;

                    kit.toString();
                }

                visualitzarKits();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void visualitzarKits(){ 
        System.out.println("");
       System.out.println("ELS KITS QUE HI HAN SÓN: \n");
   
           for(int i = 0; (i < TAMANYARRAY && kits[i] !=null); i++){
               System.out.println("Kits: " + kits[i]);
           }
    } 
}
