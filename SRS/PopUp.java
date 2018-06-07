/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdpproject;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ActionMap;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

/**
 *
 * @author gokulkarthik
 */

class PopUp extends JPopupMenu {
    JMenuItem businessProcessItem;
    JMenu step;
    JMenu action;
    Requirement requirement;
    public PopUp(){
        requirement = MainFrame.requirement;
        businessProcessItem = new JMenuItem("Business Process");
        step = new JMenu("Step");
        action = new JMenu("Action");
        
        
        businessProcessItem.putClientProperty("appendTo", requirement );
        businessProcessItem.putClientProperty("type", "BusinessProcess" );
        
        businessProcessItem.addActionListener(new ClassifyActionListner());
        
        add(businessProcessItem);
        add(step);
        add(action);
        
        
        addMenuItemsForStepItem(step);
        addMenuItemsForActionItem(action);
        
        
    }

    private void addMenuItemsForStepItem(JMenu stepMenu) {
        
        
       
        
        for (BusinessProcess businessProcess : requirement.getAggregates()) {
            JMenuItem jMenuItem = new JMenuItem(businessProcess.getPhrase());
            jMenuItem.putClientProperty("appendTo", businessProcess);
            jMenuItem.putClientProperty("type", "Step");
            jMenuItem.addActionListener(new ClassifyActionListner());
            stepMenu.add(jMenuItem);
            
        }
        
        
    }

    private void addMenuItemsForActionItem(JMenu actionMenu) {
        
        
        
        for (BusinessProcess businessProcess : requirement.getAggregates()) {
            for (Step step : businessProcess.getAggregates()) {
                JMenuItem jMenuItem = new JMenuItem(step.getPhrase());
                jMenuItem.putClientProperty("appendTo", step);
                jMenuItem.putClientProperty("type", "Action");
                jMenuItem.addActionListener(new ClassifyActionListner());
                actionMenu.add(jMenuItem);

            }
            
        }
        
        
    }
}