// Pantalla principal de l'aplicació on es pot dirigir a les operacions requerides
package escobarsnow;

import java.sql.SQLException;
import java.util.Scanner;
import escobarsnow.GuardarArray;

public class Escobarsnow {

    static Scanner teclat = new Scanner (System.in);
    static String opcio;
    
    public static void main (String[] args) throws SQLException {
        // Executem aquesta classe per a obtenir les dades de la bd i inseir-les en arrays
        GuardarArray.saveArray();

    Scanner teclat = new Scanner(System.in);

    boolean sortir=false;
    int opcio; 
            
    //MENU DE L'APLICACIO

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
        System.out.println("│        _     __  __           _                      _____     ____                       _    _ _          │");
        System.out.println("│       / |   |  \\/  | ___  ___| |_ _ __ __ _ _ __    |___ /    / ___|_ __ ___  __ _ _ __  | | _(_) |_        │");
        System.out.println("│       | |   | |\\/| |/ _ \\/ __| __| '__/ _` | '__|     |_ \\   | |   | '__/ _ \\/ _` | '__| | |/ / | __|       │");
        System.out.println("│       | |_  | |  | | (_) \\__ \\ |_| | | (_| | |       ___) |  | |___| | |  __/ (_| | |    |   <| | |_        │");
        System.out.println("│       |_(_) |_|  |_|\\___/|___/\\__|_|  \\__,_|_|      |____(_)  \\____|_|  \\___|\\__,_|_|    |_|\\_\\_|\\__|       │");
        System.out.println("│                                                                                                             │");
        System.out.println("│   ____      ___                     _          _  _      __  __           _                    _    _ _     │");
        System.out.println("│  |___ \\    |_ _|_ __  ___  ___ _ __(_)_ __    | || |    |  \\/  | ___  ___| |_ _ __ __ _ _ __  | | _(_) |_   │");
        System.out.println("│    __) |    | || '_ \\/ __|/ _ \\ '__| | '__|   | || |_   | |\\/| |/ _ \\/ __| __| '__/ _` | '__| | |/ / | __|  │");
        System.out.println("│   / __/ _   | || | | \\__ \\  __/ |  | | |      |__   _|  | |  | | (_) \\__ \\ |_| | | (_| | |    |   <| | |_   │");
        System.out.println("│  |_____(_) |___|_| |_|___/\\___|_|  |_|_|         |_|(_) |_|  |_|\\___/|___/\\__|_|  \\__,_|_|    |_|\\_\\_|\\__|  │");
        System.out.println("│                                                                                                             │");
        System.out.println("│                                     ____     ____             _   _                                         │");
        System.out.println("│                                    | ___|   / ___|  ___  _ __| |_(_)_ __                                    │");
        System.out.println("│                                    |___ \\   \\___ \\ / _ \\| '__| __| | '__|                                   │");
        System.out.println("│                                     ___) |   ___) | (_) | |  | |_| | |                                      │");
        System.out.println("│                                    |____(_) |____/ \\___/|_|   \\__|_|_|                                      │");
        System.out.println("│                                                                                                             │");
        System.out.println(" ==============================================================================================================");

        opcio=teclat.nextInt();

    //OCIONS DEL MENU PER CRIDAR CADA METODE

    switch (opcio){

                        
                case 1:
                    if (Mostrar.Mostrar()) {
                    } else {
                        System.out.println("Torna a intentar");
                    }
                break;
                
                case 2:
                    if (Insersio.Insersio()) {
                        
                    } else{
                        System.out.println("Torna a intentar");
                    }
                    break;
                case 3:
                    if (CrearKit.CrearKit()) {
                    } else {
                        System.out.println("Torna a intentar");
                    }
                    break;
                case 4:
                    if (MostrarKit.MostrarKit()) {
                    } else {
                        System.out.println("Torna a intentar");
                    }
                   
                break;
                
                case 5:
                    System.out.println("Fins una altra.");
                    sortir=true;
                    break;

                default:
                    System.out.println("FORMAT ERRONI");
            }
        }
    }

}
