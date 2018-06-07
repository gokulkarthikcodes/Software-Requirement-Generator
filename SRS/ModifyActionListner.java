/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdpproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author gokulkarthik
 */
public class ModifyActionListner implements ActionListener {

    public ModifyActionListner() {
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
        MainFrame frame = (MainFrame) MainFrame.hashmap.get("frame");
        String type = item.getClientProperty("type").toString();
        ModifyController modifyController = new ModifyController();
        
        
       
        if(type.equals("Edit")){
            String newPhrase = JOptionPane.showInputDialog(frame,
                            "Enter the new Phrase", null);
             modifyController.modify(type,
                (PhraseComponent)item.getClientProperty("selectedObject"),
                (PhraseComponent)item.getClientProperty("selectedParentObject"),
                newPhrase,
                0);
             System.out.println(item.getClientProperty("selectedObject"));
             System.out.println(item.getClientProperty("selectedParentObject"));
        }else if(type.equals("Delete")){
            
             modifyController.modify(type,
                (PhraseComponent)item.getClientProperty("selectedObject"),
                (PhraseComponent)item.getClientProperty("selectedParentObject"),
                "",
                0);
             System.out.println("");
        } else if(type.equals("Prioritize")){
            String priorityStr = JOptionPane.showInputDialog(frame,
                            "Enter the Priority", null);
            int priority = Integer.parseInt(priorityStr);
             modifyController.modify(type,
                (PhraseComponent)item.getClientProperty("selectedObject"),
                (PhraseComponent)item.getClientProperty("selectedParentObject"),
                "",
                priority);
             System.out.println("");
        }
        frame.updateRequirements();
        
        
    }
    
}
