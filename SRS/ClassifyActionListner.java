/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdpproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author gokulkarthik
 */
public class ClassifyActionListner implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
        JTextArea jTextArea1 = (JTextArea) MainFrame.hashmap.get("jTextArea1");
        
        if(!(MainFrame.textSelected.equals(""))){
            ClassifyController classifyController = new ClassifyController();
            classifyController.classify(jTextArea1.getSelectedText(),
                                    item.getClientProperty("type").toString(),
                                    (PhraseComponent)item.getClientProperty("appendTo")
            );
        }
        
        
        MainFrame frame = (MainFrame) MainFrame.hashmap.get("frame");
        frame.updateRequirements();
        MainFrame.textSelected="";
    }
    
}
