/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdpproject;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
    
    JPanel leftPanel;
    JPanel rightPanel;
    
    Frame(){
        
        setVisible(true);
        setSize(800,800);
        
        setLayout(new GridLayout(3, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        
        
        
    }
    
    
    
}