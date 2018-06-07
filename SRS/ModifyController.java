/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdpproject;

/**
 *
 * @author gokulkarthik
 */
class ModifyController {

    Requirement modify(String modifyType, PhraseComponent selectedObject, PhraseComponent parentOfSelectedObject, String newphrase, int priorityRanking) {
        if(modifyType==null || modifyType=="")
            return null;
        
        else if(modifyType=="Edit"&&(newphrase!=null | newphrase!=""))
        {
            PhraseComponent p= (PhraseComponent)selectedObject;
            p.setPhrase(newphrase);

        }
        else if(modifyType=="Delete")
        {
            
            /*
            if(selectedObject.getClass().getSimpleName().equals("BusinessProcess")){
                Requirement requirement=(Requirement)parentOfSelectedObject;
                BusinessProcess businessProcess = (BusinessProcess)selectedObject;
                requirement.remove(businessProcess);

            }
            else if(selectedObject.getClass().getSimpleName().equals("Step")){
                BusinessProcess businessProcess=(BusinessProcess)parentOfSelectedObject;
                Step step=(Step)selectedObject;
                businessProcess.remove(step);

            }
            else if(selectedObject.getClass().getSimpleName().equals("Action")){
                Step step=(Step)parentOfSelectedObject;
                Action action=(Action)selectedObject;
                step.remove(action);

            }
               */
            
            parentOfSelectedObject.remove(selectedObject);
        }
        else if(modifyType=="Prioritize" && priorityRanking!=0)
        {
             BusinessProcess businessProcess = (BusinessProcess)selectedObject;
             businessProcess.setPriority(priorityRanking);
        }

        
        
        return null;
    }
    
}
