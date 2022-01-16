import com.cytech.gestionFichiers.Client;
import com.cytech.ingredient.Boisson;
import com.cytech.ingredient.Cocktail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.*;


/**
 *
 * @author Ader
 */
public class Main {

    private static final String BAR_R = "com/cytech/collections/bar.txt";
    private static final String BOISSONS_R = "com/cytech/collections/boissons.txt";
    private static final String BOISSONS_W = "com/cytech/collections/boissonsw.txt";
    private static final String COCKTAILS_R = "com/cytech/collections/cocktails.txt";
    private static final String COCKTAILS_W = "com/cytech/collections/cocktailsw.txt";
    private static final String COMMANDES_R = "com/cytech/collections/commandes.txt";
    private static final String COMMANDES_W = "com/cytech/collections/commandesw.txt";
    
    
    /*

    BIENVENUE DANS LE MENU BARCOCKTAIL,
    AFFICHAGE DES COCKTAILS ET BOISSONS PRESENT SUR LA CARTE
    COMMANDER UN BOISSON ET COMMANDER COCKTAIL ENREGISTRENT LES COMMANDES DANS LE FICHIER COMMANDES.TXT
    TENTATIVE GESTION CAISSE
    TENTATIVE DE CREATION DE COCKTAIL
    TENTATIVE DE MODIFICATION DE STOCK
    
     */
    public static void main(String[] args) throws IOException {

        PageConnexion h = new PageConnexion();
        h.setVisible(true);

        /*
            
        Scanner sc = new Scanner(System.in);
        int menu = -1;
        String afficher = "n";

        System.out.println("");
        System.out.println("\t\t**************************************************************************");
        System.out.println("\t\tBonjour, bienvenue dans notre bar");
        System.out.println("\t\t**************************************************************************");
        System.out.println("");

        for (int i = 0; i < 2; i++) {
            System.out.println("Etes vous un client ou un barman? (c/b) : ");
            String reponse = (sc.nextLine()).toLowerCase(); 
            switch (reponse) {
                case "c":
                    reponse = "client";
                    i = 2; // Quand le client quittera le bar, on ne revient pas dans la boucle de départ
                    System.out.println("Bonjour, vous êtes bien un client");
                    System.out.println("Souhaitez vous afficher les boissons et cocktails disponibles ? (o/n) : ");
                    afficher = "n"; // Sécurité si l'utilisateur arrive a ne rien saisir
                    afficher = (sc.nextLine()).toLowerCase();
                    if (afficher.equals("o") || afficher.equals("oui")){
                        System.out.println("");
                        System.out.println("Voici les boissons :");
                        afficherBoissons();
                        System.out.println("");
                        System.out.println("Voici les cocktails :");}
                        afficherCocktails();
                        System.out.println("");
                        choixMenu(reponse);
                        menu = sc.nextInt();
                        switch (menu) {
                            case 0:
                                commanderBoisson();
                                break;
                            case 1:
                                commanderCocktail();
                                break;
                            case 2:
                                creerCocktailClient();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Cette valeur est indisponible"); // Pour toutes les valeurs différentes de 0, 1,2 et 3
                                break;
                        }
                    break;
                case "b":
                    reponse = "barman";
                    i = 2; // Quand le client quittera le bar, on ne revient pas dans la boucle de départ
                    System.out.println("Bonjour, vous êtes bien un barman");
                    System.out.println("Souhaitez vous afficher les boissons et cocktails disponibles ? (o/n) : ");
                    afficher = "n"; // Sécurité si l'utilisateur arrive a ne rien saisir
                    afficher = (sc.nextLine()).toLowerCase();
                    if (afficher.equals("o") || afficher.equals("oui")){
                        System.out.println("Voici les boissons :");
                        afficherBoissons();
                        System.out.println("Voici les cocktails :");
                        afficherCocktails();}
                        menu = (choixMenu(reponse));
                        switch (menu) {
                            case 0:
                                facturerCommande();
                                break;
                            case 1:
                                creerCocktailBarman();
                                break;
                            case 2:
                                modifierStock();
                                break;
                            case 3:
                                gererCaisse();
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Cette valeur est indisponible"); // Pour toutes les valeurs différentes de 0, 1, 2 et 3
                                break;
                        }
                default:
                    System.out.println("Je ne comprends pas bien qui vous êtes"); // On recommence la boucle 
                    break;
            }
        }
        sc.close();
        System.out.println("\t\tAu revoir, bonne soirée !");
    }
    
    
    public static int choixMenu(String reponse) {
        int menuChoisi = -1; 

        if (reponse.equals("client")) {
            menuClient();
        }else if(reponse.equals("barman")) {
            menuBarman();
        }
        if (menuChoisi == -1) {// Si après les deux boucles on a une valeur d'erreur, alors on donne renvoie la valeur de "quitter"
            menuChoisi = 0;}
        return menuChoisi; 
    }
    
        // CLIENT
    public static void menuClient() {
        System.out.println("Que souhaitez-vous faire ?");
        System.out.println("\t0. Commander une boisson");
        System.out.println("\t1. Commander un cocktail");
        System.out.println("\t2. Créer un cocktail");
        System.out.println("\t3. Quitter le bar");   
    }
    
    public static void afficherCocktails() throws IOException {
        File reader = new File(COCKTAILS_R);
        BufferedReader br = new BufferedReader(new FileReader(reader));
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line.substring(0, line.indexOf(",")));
        }
    }

    public static void afficherBoissons() throws IOException { 
        File reader = new File(BOISSONS_R);
        BufferedReader br = new BufferedReader(new FileReader(reader));
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line.substring(0, line.indexOf(",")));
        }
    }

    private static void commanderCocktail() throws IOException { // ECRIT LE COCKTAIL DANS LE FICHIER COMMANDE
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Quel cocktail voulez-vous commander ? ");


        afficherCocktails();
        String nomCocktail = sc1.nextLine();
        System.out.print("Vous avez commandé le cocktail : ");
        System.out.println(nomCocktail);
        Client.commanderCocktails(nomCocktail);
        sc1.close();
    }


    private static void commanderBoisson() throws IOException { // ECRIT LE BOISSON DANS LE FICHIER COMMANDE
        Scanner sc = new Scanner(System.in);
        System.out.println("Quelle boisson voulez-vous commmander ? ");
        String nomBoisson = sc.nextLine();
        System.out.print("Vous avez commandé la boisson : ");
        System.out.println(nomBoisson);
        Client.commanderBoissons(nomBoisson);
        sc.close();
    }

    private static void creerCocktailClient() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean isAlcool = true, isSoft = true;
        String nom;
        String [] composition = new String[100];
        double contenance, prix, degree;
        String boissoni;
        int nombreBoissons;
        String ajouter = "n";
        System.out.println("Combien de boissons contiendra votre cocktail ? ");
        nombreBoissons = sc.nextInt();
        System.out.println("Quelles sont ces boissons ?");
        for (int i=0; i<nombreBoissons; i++){
            boissoni = sc.nextLine();
            composition[i]=boissoni;
        }
        System.out.println("Comment s'appelle ce nouveau cocktail ?");
        nom = sc.nextLine();
        //Cocktail(nom, composition);
        sc.close();
    }
    
    
    
        // BARMAN
    public static void menuBarman() {
        System.out.println("Que souhaitez-vous faire ?");
        System.out.println("\t0. Facturer une commande");
        System.out.println("\t1. Créer un cocktail");
        System.out.println("\t2. Modifier le stock d'une boisson");
        System.out.println("\t3. Gérer la caisse");   
        System.out.println("\t4. Quitter le bar");   
    }
    
    public static void facturerCommande() {
        
    }
    
    public static void creerCocktailBarman() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean isAlcool = true, isSoft = true;
        String nom;
        String [] composition = new String[100];
        double contenance, prix, degree;
        String boissoni;
        int nombreBoissons;
        String ajouter = "n";
        System.out.println("Combien de boissons contiendra votre cocktail ? ");
        nombreBoissons = sc.nextInt();
        System.out.println("Quelles sont ces boissons ?");
        for (int i=0; i<nombreBoissons; i++){
            boissoni = sc.nextLine();
            composition[i]=boissoni;
        }
        System.out.println("Comment s'appelle ce nouveau cocktail ?");
        nom = sc.nextLine();
        //new Cocktail(nom, composition);
        sc.close();
    }
        

    public static void modifierStock() {
        Scanner sc = new Scanner(System.in);
        System.out.println("De quelle boisson souhaitez vous modifier le stock ?");
        String stockNomBoisson = sc.nextLine();
        System.out.println("Souhaitez vous augmenter ou diminuer le stock de cette boisson? (a/d)");
        String choix = (sc.nextLine()).toLowerCase();
        switch(choix){
            case "a":
                System.out.println("De quelle quantité voulez vous augmenter le stock ?");
                Integer qte = sc.nextInt();
                stockNomBoisson.getBoissStock() += qte;
            break;
            case "d":
                System.out.println("De quelle quantité voulez vous diminuer le stock ?")
                Integer quant = sc.nextInt();

            break;
        }
        sc.close();
    }
        
    
    public static void gererCaisse() {
        File reader = new File(BAR_R);
        BufferedReader br = new BufferedReader(new FileReader(reader));
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line.substring(0, line.indexOf(",")));
    }
        
    
    */
}
}