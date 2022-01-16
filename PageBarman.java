import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.*;

import com.cytech.gestionFichiers.Client;
import com.cytech.ingredient.Boisson;
import com.cytech.ingredient.Cocktail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class PageBarman extends JFrame{


    public ArrayList<String> afficherBoissons() throws IOException { 


        File reader = new File("com/cytech/collections/boissons.txt");
        BufferedReader br = new BufferedReader(new FileReader(reader));
        String line;

        ArrayList<String> tableauBoiss = new ArrayList<>();

        String boiss = "";
        while((line = br.readLine()) != null) {
            System.out.println(line.substring(0, line.indexOf(",")));
            boiss = line.substring(0, line.indexOf(",")); //bloucle et écrase la valeur de boisson, il ne reste donc que la denière à corriger
            tableauBoiss.add(boiss);
        }
        return tableauBoiss;}

        public ArrayList<String> afficherCocktails() throws IOException { 


            File reader = new File("com/cytech/collections/cocktails.txt");
            BufferedReader br = new BufferedReader(new FileReader(reader));
            String line;
    
            ArrayList<String> tableauCock = new ArrayList<>();
    
            String cock = "";
            while((line = br.readLine()) != null) {
                System.out.println(line.substring(0, line.indexOf(",")));
                cock = line.substring(0, line.indexOf(",")); //bloucle et écrase la valeur de boisson, il ne reste donc que la denière à corriger
                tableauCock.add(cock);
            }
            return tableauCock;}



    PageBarman(){

        JFrame cadre = new JFrame("Bar à Cocktails");
        JPanel panneau = new JPanel();
        panneau.setPreferredSize(new Dimension(700, 600));
        cadre.setContentPane(panneau);
        JLabel a=new JLabel(" ");
        cadre.getContentPane().add(a);

        a.setText("Vous êtes bien un barman. Souhaitez vous afficher les boissons et cocktails disponibles ?");
                JButton OuiButton=new JButton("Oui");
                cadre.getContentPane().add(OuiButton);
                JButton NonButton=new JButton("Non");
                cadre.getContentPane().add(NonButton);
                JButton FactureButton=new JButton("Facturer une commande");
                cadre.getContentPane().add(FactureButton);
                JButton CreationCocktail=new JButton("Créer un cocktail");
                cadre.getContentPane().add(CreationCocktail);
                JButton ModifStock=new JButton("Modifier le stock d'une boisson");
                cadre.getContentPane().add(ModifStock);
                JButton GererCaisse=new JButton("Gérer la caisse");
                cadre.getContentPane().add(GererCaisse);
                JButton QuitterBar=new JButton("Quitter le bar");
                cadre.getContentPane().add(QuitterBar);
                JLabel b=new JLabel("");
                cadre.getContentPane().add(b);
                CreationCocktail.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        CocktailBarman pc = new CocktailBarman();
                        pc.setVisible(true);
                        cadre.setVisible(false);
                    }
                });
                OuiButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("a");
                    
                        try {
                            
                            int N = afficherBoissons().size();
                            JButton[] buttons = new JButton[N];

                            for (int i=0; i<N; i++)
                            {
                                String text = afficherBoissons().get(i);
                                buttons[i] = new JButton(text);
                                cadre.getContentPane().add(buttons[i]);
                                System.out.println(i);
                              }
                              cadre.setVisible(true);
                               


                        } catch (IOException e1) {
                            
                            e1.printStackTrace();
                        }
                     }
                });
                NonButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("a");
                    
                        try {
                            
                            int N = afficherCocktails().size();
                            JButton[] buttons = new JButton[N];

                            for (int i=0; i<N; i++)
                            {
                                String text = afficherCocktails().get(i);
                                buttons[i] = new JButton(text);
                                cadre.getContentPane().add(buttons[i]);
                                System.out.println(i);
                              }
                              cadre.setVisible(true);
                               


                        } catch (IOException e1) {
                            
                            e1.printStackTrace();
                        }
                     }
                });
        
        panneau.setBackground(Color.PINK);
        cadre.setContentPane(panneau);
        cadre.setLocation(400, 300);
        cadre.pack();
        cadre.setVisible(true);
        cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        
    }

    
    
}
