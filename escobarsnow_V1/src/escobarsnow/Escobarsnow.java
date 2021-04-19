/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escobarsnow;

import java.util.Scanner;
import escobarsnow.GuardarArray;

/**
 *
 * @author JO
 */
public class Escobarsnow {

    static Scanner teclat = new Scanner (System.in);
    static String opcio;
    
    public static void main (String[] args) {
        GuardarArray.saveArray();

    Scanner teclat = new Scanner(System.in);

    boolean sortir=false;
    int opcio; //De string a int
            
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

                        Mostrar prod = new Mostrar();
                        prod.mostrar();

                        System.out.println("\nApreta RETURN per sortir....");

                        teclat.nextLine();
                        teclat.nextLine();
                        //opcio=teclat.next();
                    break;
                    }
                case 2:
                    
                    break;
                case 3:
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
                    System.out.println("│                                    ____                           _     _  _                      │");
                    System.out.println("│                                   / ___| _ __  ___   __ _  _ __  | | __(_)| |_                     │");
                    System.out.println("│                                  | |    | '__|/ _ \\ / _` || '__| | |/ /| || __|                     │");
                    System.out.println("│                                  | |___ | |  |  __/| (_| || |    |   < | || |_                      │");
                    System.out.println("│                                   \\____||_|   \\___| \\__,_||_|    |_|\\_\\|_| \\__|                         │");
                    System.out.println("│                                                                                                             │");
                    System.out.println(" ==============================================================================================================");

                   

                    System.out.println("\nApreta RETURN per sortir....");

                    teclat.nextLine();
                    teclat.nextLine();
                break;
                }
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
