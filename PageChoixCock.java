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


public class PageChoixCock extends JFrame{

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

        PageChoixCock(){

        JFrame cadre = new JFrame("Bar à Cocktails");
        JPanel panneau = new JPanel();
        panneau.setPreferredSize(new Dimension(700, 600));
        
        cadre.setContentPane(panneau);
        JLabel a=new JLabel(" ");
        cadre.getContentPane().add(a);

        try {
                    
            int N = afficherCocktails().size();
            JButton[] buttons = new JButton[N];

            for (int i=0; i<N; i++)
            {
                String text = afficherCocktails().get(i);
                buttons[i] = new JButton(text);
                cadre.getContentPane().add(buttons[i]);
                System.out.println(i);
                JLabel l = new JLabel("");
                cadre.getContentPane().add(l);
                buttons[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {

                        try {
                            Client.commanderCocktails(text);
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }

                        l.setText("Vous avez bien commandé la boisson : " + text);
                     }
                });
            }
            cadre.setVisible(true);
            JButton retour = new JButton("Retour");
            cadre.getContentPane().add(retour);
            retour.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    PageClient pc = new PageClient();
                    pc.setVisible(true);
                    cadre.setVisible(false);
                }
            });   


        } catch (IOException e1) {
            
            e1.printStackTrace();
        }

        panneau.setBackground(Color.PINK);
        cadre.setContentPane(panneau);
        cadre.setLocation(400, 300);
        cadre.pack();
        cadre.setVisible(true);
        cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}