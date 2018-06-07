/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdpproject;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author gokulkarthik
 */
class ModifyPopUp extends JPopupMenu{
    JMenuItem editItem;
    JMenuItem deleteItem;
    JMenuItem prioritizeItem;
    public ModifyPopUp() {
        JTree jTree1 =(JTree) MainFrame.hashmap.get("jTree1");
        editItem = new JMenuItem("Edit");
        editItem.putClientProperty("type", "Edit");
        
         if(jTree1.getSelectionCount()<1){
            editItem.putClientProperty("selectedObject", MainFrame.selectedObject);
            editItem.putClientProperty("selectedParentObject", MainFrame.selectedParentObject);
        
             System.out.println(MainFrame.selectedObject);
             System.out.println(MainFrame.selectedParentObject);
             
         }
        
        deleteItem = new JMenuItem("Delete");
        deleteItem.putClientProperty("type", "Delete");
         if(jTree1.getSelectionCount()<1){
            deleteItem.putClientProperty("selectedObject", MainFrame.selectedObject);
            deleteItem.putClientProperty("selectedParentObject", MainFrame.selectedParentObject);
        
         }
         
        
        prioritizeItem = new JMenuItem("Prioritize");
        prioritizeItem.putClientProperty("type", "Prioritize");
         if(jTree1.getSelectionCount()<1){
            prioritizeItem.putClientProperty("selectedObject", MainFrame.selectedObject);
            prioritizeItem.putClientProperty("selectedParentObject", MainFrame.selectedParentObject);
        
         }
         
        add(editItem);
        add(deleteItem);
         editItem.addActionListener(new ModifyActionListner());
        deleteItem.addActionListener(new ModifyActionListner());
        
        
        
        if(MainFrame.selectedObject.getClass().getSimpleName().equals("BusinessProcess")){
            add(prioritizeItem);
            prioritizeItem.addActionListener(new ModifyActionListner());
        }
        
        
        
        
        
        //System.out.println(jTree1.toString());
    }
    
    
}
