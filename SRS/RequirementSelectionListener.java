/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdpproject;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeSelectionModel;

/**
 *
 * @author gokulkarthik
 */
public class RequirementSelectionListener implements javax.swing.event.TreeSelectionListener {
    
    public RequirementSelectionListener() {
       
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) e.getNewLeadSelectionPath().getLastPathComponent();
        DefaultTreeSelectionModel jTree1 = (DefaultTreeSelectionModel) e.getSource();
        //System.out.println(jTree1);
        
        //System.out.println(jTree1.getSelectionCount());
        PhraseComponent p = (PhraseComponent)selectedNode.getUserObject();
        
        //System.out.println(p.getPhrase());
        //System.out.println(jTree1.getSelectionPath().getPathCount());
        int pathCount = jTree1.getSelectionPath().getPathCount();
        
        DefaultMutableTreeNode node;
        System.out.println("");
        System.out.println(jTree1.getSelectionCount());
        if(jTree1.getSelectionCount()==1){
            switch(pathCount){
            case 2: MainFrame.selectedObject = (BusinessProcess)selectedNode.getUserObject();
                    
                     node = (DefaultMutableTreeNode) (e.getNewLeadSelectionPath().getParentPath().getLastPathComponent());
                    MainFrame.selectedParentObject =(PhraseComponent) node.getUserObject();
                    
                       System.out.println(MainFrame.selectedObject);
             System.out.println(MainFrame.selectedParentObject);
          
                    break;
            case 3: MainFrame.selectedObject = (Step)selectedNode.getUserObject();
                    
                    node = (DefaultMutableTreeNode) (e.getNewLeadSelectionPath().getParentPath().getLastPathComponent());
                    MainFrame.selectedParentObject = (BusinessProcess)node.getUserObject();
                    break;
                    
            case 4: MainFrame.selectedObject = (Action)selectedNode.getUserObject();
                    
                    node = (DefaultMutableTreeNode) (e.getNewLeadSelectionPath().getParentPath().getLastPathComponent());
                    MainFrame.selectedParentObject = (Step)node.getUserObject();
                    break;
            }
        }
        
//        System.out.println(selectedObject);
//        System.out.println(selectedParentObject);
//        
        
        
    }
    
}
