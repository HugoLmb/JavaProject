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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class CocktailBarman extends JFrame{

    public static void EnregistrerCocktailCree(String cocktail) throws IOException {
        File reader = new File("com/cytech/collections/cocktails.txt");
        File writer = new File("com/cytech/collections/cocktailsw.txt");
        BufferedReader br = new BufferedReader(new FileReader(reader));
        BufferedWriter bw = new BufferedWriter(new FileWriter(writer));
        String line;
        while((line = br.readLine()) != null) {
            bw.write(line + ",\n");
        }
        bw.write(cocktail + ",\n");
        br.close();
        bw.close();
        reader.delete();
        writer.renameTo(new File("com/cytech/collections/cocktails.txt"));
    };

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

    CocktailBarman(){
    JFrame cadre = new JFrame("Bar à Cocktails");
    JPanel panneau = new JPanel();
    panneau.setPreferredSize(new Dimension(700, 600));
    cadre.setContentPane(panneau);
    JLabel nomBoiss = new JLabel("Quel est le nom de votre cocktail ?");
    cadre.getContentPane().add(nomBoiss);
    JTextField nomB = new JTextField(10);
    cadre.getContentPane().add(nomB);
    String name=nomB.getText();
    JLabel quellesBoiss = new JLabel("Veuillez choisir les boissons que contiendra votre cocktail " + name);
    cadre.getContentPane().add(quellesBoiss);

    try {
                            
        int N = afficherBoissons().size();
        JButton[] buttons = new JButton[N];

        for (int i=0; i<N; i++)
        {
            String text = afficherBoissons().get(i);
            buttons[i] = new JButton(text);
            cadre.getContentPane().add(buttons[i]);
            System.out.println(i);
            JLabel l = new JLabel(" ");
            cadre.getContentPane().add(l);
            buttons[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {

                    l.setText(text + " sera ajouté dans votre cocktail");
                }
            });
          cadre.setVisible(true);
        }
        JButton soumettre = new JButton("Soumettre");
        cadre.getContentPane().add(soumettre);
        JLabel fini = new JLabel(" ");
        cadre.getContentPane().add(fini);
        soumettre.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String name=nomB.getText();
                fini.setText("Vous avez bien ajouté le cocktail " + name);
                try {
                    EnregistrerCocktailCree(name);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        JButton retour = new JButton("Retour");
        cadre.getContentPane().add(retour);
        retour.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                PageBarman pb = new PageBarman();
                pb.setVisible(true);
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

