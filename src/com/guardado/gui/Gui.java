/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardado.gui;

import com.guardado.threads.AnimalThread;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author allan
 */
public class Gui extends JFrame{
    private JLabel [] labels;
    
    private JButton inicio;
    
    private String[] nombres = {"raton", "tortuga", "dragon"};
    
    public Gui(){
        super("Carrera de animales");
        initialComponents();
    }
    
    public void initialComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        labels = new JLabel[3];
        inicio = new JButton("Inicio");
        Container container = getContentPane();
        
        for(int i = 0; i<3; i++){
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i]+".jpg")));
            labels[i].setBounds(10, (i*220)+10,200,200);
            container.add(labels[i]);
        }
        
        inicio.setBounds(10,0,100,30);
        container.add(inicio);
        
        inicio.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                AnimalThread raton = new AnimalThread("raton",labels[0].getX(),labels[0].getY(), 510, labels[0]);
                AnimalThread tortuga = new AnimalThread("tortuga",labels[1].getX(),labels[1].getY(), 510, labels[1]);
                AnimalThread dragon = new AnimalThread("dragon",labels[2].getX(),labels[2].getY(), 510, labels[2]);
                raton.start();
                tortuga.start();
                dragon.start();
            }
        });
        setSize(700,650);
    }
}
