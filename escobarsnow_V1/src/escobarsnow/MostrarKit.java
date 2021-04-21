// Pantalla per a les funcions de mostrar kits
package escobarsnow;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;  

import escobarsnow.classes.*;
import escobarsnow.GuardarArray.*;


public class MostrarKit {
    
    static Scanner teclat = new Scanner (System.in);
    static String opcio;

    // Cridar arrays amb les dades
    private final int TA = 200;
    static Bota[] botes = GuardarArray.getBotes();
    static Esqui[] esquis = GuardarArray.getEsqui();
    static Pal[] pals =  GuardarArray.getPals();
    static Kit[] kits = GuardarArray.getKits();

    Connection conn = null;

    public static boolean MostrarKit() {
        Scanner teclat = new Scanner(System.in);

        boolean sortir=false;
        int opcio; 
        
            // Menú
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
                System.out.println("│                                   __  __              _                       _     _  _                    │");
                System.out.println("│                                  |  \\/  |  ___   ___ | |_  _ __  __ _  _ __  | | __(_)| |_                  │");
                System.out.println("│                                  | |\\/| | / _ \\ / __|| __|| '__|/ _` || '__| | |/ /| || __|                 │");
                System.out.println("│                                  | |  | || (_) |\\__ \\| |_ | |  | (_| || |    |   < | || |_                  │");
                System.out.println("│                                  |_|  |_| \\___/ |___/ \\__||_|   \\__,_||_|    |_|\\_\\|_| \\__|                 │");
                System.out.println("│                                                                                                             │");
                System.out.println(" ==============================================================================================================");
                System.out.println("│  _      _  __ _  _         _        _       _  _                                                            │");
                System.out.println("│ / |    | |/ /(_)| |_    __| |  ___ | |   __| |(_)  __ _                                                     │");
                System.out.println("│ | |    | ' / | || __|  / _` | / _ \\| |  / _` || | / _` |                                                    │");
                System.out.println("│ | | _  | . \\ | || |_  | (_| ||  __/| | | (_| || || (_| |                                                    │");
                System.out.println("│ |_|(_) |_|\\_\\|_| \\__|  \\__,_| \\___||_|  \\__,_||_| \\__,_|                                                    │");
                System.out.println("│                                                                                                             │");
                System.out.println("│ ____       _  __ _  _                                                                                       │");
                System.out.println("│ |___ \\     | |/ /(_)| |_  ___                                                                               │");
                System.out.println("│   __) |    | ' / | || __|/ __|                                                                              │");
                System.out.println("│  / __/  _  | . \\ | || |_ \\__ \\                                                                              │");
                System.out.println("│ |_____|(_) |_|\\_\\|_| \\__||___/                                                                              │");
                System.out.println("│                                                                                                             │");
                System.out.println("│ _____     _  __ _  _                               __               _                                       │");
                System.out.println("│ |___ /    | |/ /(_)| |_    ___   ___  ___   _ __    \\_\\   _ __ ___  (_)  ___                                │");
                System.out.println("│   |_ \\    | ' / | || __|  / _ \\ / __|/ _ \\ | '_ \\  / _ \\ | '_ ` _ \\ | | / __|                               │");
                System.out.println("│  ___) |_  | . \\ | || |_  |  __/| (__| (_) || | | || (_) || | | | | || || (__                                │");
                System.out.println("│ |____/(_) |_|\\_\\|_| \\__|  \\___| \\___|\\___/ |_| |_| \\___/ |_| |_| |_||_| \\___|                               │");
                System.out.println("│                                                                                                             │");
                System.out.println("│                                                                                                             │");
                System.out.println("│  _  _       ____                   _                    _     _  _                                          │");
                System.out.println("│ | || |     |  _ \\  _ __  ___    __| |      ___  _ __   | | __(_)| |_  ___                                   │");
                System.out.println("│ | || |_    | |_) || '__|/ _ \\  / _` |     / _ \\| '_ \\  | |/ /| || __|/ __|                                  │");
                System.out.println("│ |__   _|_  |  __/ | |  | (_) || (_| | _  |  __/| | | | |   < | || |_ \\__ \\                                  │");
                System.out.println("│    |_| (_) |_|    |_|   \\___/  \\__,_|(_)  \\___||_| |_| |_|\\_\\|_| \\__||___/                                  │");
                System.out.println("│                                                                                                             │");
                System.out.println("│                                                                                                             │");
                System.out.println("│                                                                                                             │");
                System.out.println("│                                                                                                             │");
                System.out.println("│                                                                                                             │");
                System.out.println("│  ____      _____                                                                                            │");
                System.out.println("│ | ___|    |_   _|___   _ __  _ __    __ _  _ __                                                             │");
                System.out.println("│ |___ \\      | | / _ \\ | '__|| '_ \\  / _` || '__|                                                            │");
                System.out.println("│  ___) |_    | || (_) || |   | | | || (_| || |                                                               │");
                System.out.println("│ |____/(_)   |_| \\___/ |_|   |_| |_| \\__,_||_|                                                               │");
                System.out.println("│                                                                                                             │");
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

                            if (kitEconomic()) {
                            }else{
                                System.out.println("Torna a intentar");
                            }

                            break;

                        case 4:

                            if (prodEnKits()) {
                            } else {
                                System.out.println("Torna a intentar");
                            }
                            
                        case 5:

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

    private void conseguirKitsDia(){
        
        System.out.println("Insereix una data");
        String data = teclat.next();
        
        boolean trobarData = false;
        int k = 0;

        while (!trobarData) {
                
                if (kits[k].getData().equals(data)) {
                    System.out.println("Els kits que existeixen el dia " + data + " són: " + kits[k]);
                    
                    trobarData = true;
                } else {
                    k++;
                }

        }
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
                  
                        boolean trobatEsq = false;
                        int j = 0;
                        while (!trobatEsq){
                        
                            int test = (rs.getInt("id_esquis"));
                            // System.out.println("esqui: "+esquis[j].getIdEsquis()+"test: "+test);
                            if (esquis[j].getIdEsquis() == test) {
                                // System.out.println("Els esquis trobats");
                                   kit.setEsqui(esquis[j]);
                                   trobatEsq = true;
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
                            } else { l++;}
                        }
                        
                        kit.setPreuTotal(rs.getDouble("preuTotal"));
                        kit.setData(rs.getString("data"));

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
   
           for(int i = 0; (i < TA && kits[i] !=null); i++){
               System.out.println("Kits: " + kits[i]);
           }
    } 

    // Mostrar kits económics

    public static boolean kitEconomic() {
        
        MostrarKit economic = new MostrarKit();
        economic.showKitsEconomics();

        return true;
    }

    private void showKitsEconomics(){

        if (!conseguirKitsEco()) {
            System.out.println("Error");
        }
    }

    private boolean conseguirKitsEco(){
        
        try {
            conseguirKitsEconomics();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private void conseguirKitsEconomics(){
        
        int i = 0;
        double preuMin = 1000000;

        Kit kitMin = null;

        while (kits[i] != null) {
            
            if (kits[i].getPreuTotal() < preuMin) {
                preuMin = kits[i].getPreuTotal();
                kitMin = kits[i];
            }
            i++;
        }
        System.out.println("Kit més barat: " + kitMin.toString());
    }

    // Mostrar en quants kits forma part un prod
    
    public static boolean prodEnKits(){

        System.out.println("\nApreta E per mostrar els esquis");
        System.out.println("Apreta P per mostrar els pals");
        System.out.println("Apreta B per mostrar les botes");
        System.out.println("Apreta X per sortir....");

        boolean sortir=false;
        opcio=teclat.next();
            switch(opcio.charAt(0)){

                case 'E':
                    if (esquisKits()) {
                    } else{
                        System.out.println("Torna a intentar");
                    }
                    break;

                case 'P':
                    if (palsKits()) {
                    } else{
                        System.out.println("Torna a intentar");
                    }
                    break;

                case 'B':
                    if (botesKits()) {
                    } else{
                        System.out.println("");
                    }
                    break;

                case 'X':
                        sortir = true;
                    break;



            }
        return true;
    }

    public static boolean esquisKits(){
            System.out.println("Quin id d'esqui vols contar?");

            int num = teclat.nextInt();
            int contador = 0;
            
            int i = 0;
            boolean trobat = false;

            while (!trobat) {
                     
                    if (num == kits[i].getEsqui().getIdEsquis()) {
                        contador++;
                        System.out.println("Els kits en que pertany: " + kits[i]);
                    trobat = true;

                    } else{
                        // i++;  
                        System.out.println("No forma part de cap Kit");
                        trobat = true;   
                    }
                
            }
        return true;
    }

    public static boolean botesKits(){
        System.out.println("Quin id de botes vols contar?");

            int num = teclat.nextInt();
            int contador = 0;
            
            int i = 0;
            boolean trobat = false;

            while (!trobat) {
                     
                    if (num == kits[i].getBota().getIdBotes()) {
                        contador++;
                        System.out.println("Els kits en que pertany: " + kits[i]);
                    trobat = true;

                    } else{
                        // i++;  
                        System.out.println("No forma part de cap Kit");
                        trobat = true;   
                    }
                
            }
        return true;
    }

    public static boolean palsKits(){

        System.out.println("Quin id de pals vols contar?");

            int num = teclat.nextInt();
            int contador = 0;
            
            int i = 0;
            boolean trobat = false;

            while (!trobat) {
                     
                    if (num == kits[i].getPal().getIdPals()) {
                        contador++;
                        System.out.println("Els kits en que pertany: " + kits[i]);
                    trobat = true;

                    } else {
                        // i++;  
                        System.out.println("No forma part de cap Kit");
                        trobat = true;  
                    } 
                
            }
        return true;
    }

}