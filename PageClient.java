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


public class PageClient extends JFrame{


    PageClient(){

        JFrame cadre = new JFrame("Bar à Cocktails");
        JPanel panneau = new JPanel();
        panneau.setPreferredSize(new Dimension(700, 600));
        cadre.setContentPane(panneau);
        JLabel a=new JLabel(" ");
        cadre.getContentPane().add(a);

        a.setText("Vous êtes bien un client. Souhaitez vous afficher les boissons et cocktails disponibles ?");
                JButton boissButton=new JButton("Commander Boisson");
                cadre.getContentPane().add(boissButton);
                JButton cockButton=new JButton("Commander Cocktail");
                cadre.getContentPane().add(cockButton);
                JButton creerCock=new JButton("Créer Cocktail");
                cadre.getContentPane().add(creerCock);
                JButton Panier = new JButton("Panier");
                cadre.getContentPane().add(Panier);
                JLabel b=new JLabel("");
                cadre.getContentPane().add(b);

                boissButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        PageChoixBoisson choixBoiss = new PageChoixBoisson();
                        choixBoiss.setVisible(true);
                        cadre.setVisible(false);                    
                        
                     }
                });
                cockButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        PageChoixCock choixCock = new PageChoixCock();
                        choixCock.setVisible(true);
                        cadre.setVisible(false);
                     }
                });

                 //ACTION BOUTTON CREER COCKTAIL
            creerCock.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    CocktailClient pc = new CocktailClient();
                    pc.setVisible(true);
                    cadre.setVisible(false);
                }
            });

            Panier.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    PageCommande pc = new PageCommande();
                    pc.setVisible(true);
                    cadre.setVisible(false);
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
