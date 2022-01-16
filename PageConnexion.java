import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.*;

public class PageConnexion extends JFrame{
    public PageConnexion(){
        
        
        JFrame cadre = new JFrame("Bar à Cocktails");
        JPanel panneau = new JPanel();
        panneau.setPreferredSize(new Dimension(700, 600));
        cadre.setContentPane(panneau);

        JLabel bienvenue=new JLabel("Bonjour, bienvenue dans notre bar. ");
        cadre.getContentPane().add(bienvenue);
        JLabel quiestu=new JLabel("Etes vous un client ou un barman?");
        cadre.getContentPane().add(quiestu);
        JButton client=new JButton("Client");
        cadre.getContentPane().add(client);
        JButton barman=new JButton("Barman");
        cadre.getContentPane().add(barman);
        JLabel a=new JLabel(" ");
        cadre.getContentPane().add(a);

        panneau.setBackground(Color.PINK);
        cadre.setLocation(400, 300);

        cadre.pack();
        cadre.setVisible(true);
        cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ACTION BOUTTON CLIENT
        client.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                PageClient pc = new PageClient();
                pc.setVisible(true);
                cadre.setVisible(false);
            }
        });
        
        //ACTION BOUTTON BARMAN
        barman.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            PageBarman pc = new PageBarman();
            pc.setVisible(true);
            cadre.setVisible(false);
            }
        });

    }
    
}