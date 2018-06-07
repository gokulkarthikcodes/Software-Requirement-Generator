/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdpproject;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author gokulkarthik
 */
public class TreeClickListener implements MouseListener {

    public TreeClickListener() {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger())
            doModifyPop(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger())
            doModifyPop(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    private void doModifyPop(MouseEvent e){
        ModifyPopUp modifyPopUp = new ModifyPopUp();
        modifyPopUp.show(e.getComponent(), e.getX(), e.getY());
    }
}
