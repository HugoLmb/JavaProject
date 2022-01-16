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

public class PageCommande extends JFrame {

    public ArrayList<String> afficherCommande() throws IOException { 


        File reader = new File("com/cytech/collections/commandes.txt");
        BufferedReader br = new BufferedReader(new FileReader(reader));
        String line;

        ArrayList<String> tableauCommande = new ArrayList<>();

        String commande = "";
        while((line = br.readLine()) != null) {
            System.out.println(line.substring(0, line.indexOf(",")));
            commande = line.substring(0, line.indexOf(",")); //bloucle et écrase la valeur de boisson, il ne reste donc que la denière à corriger
            tableauCommande.add(commande);
        }
        return tableauCommande;
    }


    PageCommande(){



        JFrame cadre = new JFrame("Bar à Cocktails");
        JPanel panneau = new JPanel();
        panneau.setPreferredSize(new Dimension(700, 600));
        cadre.setContentPane(panneau);
        JLabel a=new JLabel(" ");
        cadre.getContentPane().add(a);
        String commande = "";

        try {
            ArrayList<String> tab = afficherCommande();
            int tabsize = tab.size();

            for (int i = 0; i < tabsize ; i++) {
                commande = tab.get(i) + " \n" +commande;
              }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    
        a.setText(commande);
                
        JButton retour = new JButton("Retour");
            cadre.getContentPane().add(retour);
            retour.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    PageClient pc = new PageClient();
                    pc.setVisible(true);
                    cadre.setVisible(false);
                }
            });

            JButton valider = new JButton("valider la commande");
            cadre.getContentPane().add(valider);
            valider.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    PageClient pc = new PageClient();
                    pc.setVisible(true);
                    cadre.setVisible(false);

                    try {
                        ArrayList<String> tab2 = afficherCommande();
                        int tabsize = tab2.size();
                        for (int i = 0; i < tabsize ; i++) {
                            Client.historique(tab2.get(i));
                          }
                    } catch (IOException historiqueError) {
                        // TODO Auto-generated catch block
                        historiqueError.printStackTrace();
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
