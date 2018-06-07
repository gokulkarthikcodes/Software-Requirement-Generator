/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdpproject;

import java.util.ArrayList;

/**
 *
 * @author gokulkarthik
 */
public class Requirement extends PhraseComponent{
    ArrayList<BusinessProcess> businessProcesses = new ArrayList<BusinessProcess>();

    public Requirement() {
            

    }
    
    
    
    ArrayList <BusinessProcess> getAggregates(){
        return businessProcesses;
    }
    
    
    
    public void append(PhraseComponent o) {
        BusinessProcess businessProcess = (BusinessProcess)o;
        businessProcesses.add(businessProcess);
    }

    
    public void remove(PhraseComponent o) {
        BusinessProcess businessProcess = (BusinessProcess)o;
        businessProcesses.remove(businessProcess);
    }
    
    @Override        

    public String getAllInfo(String relativeIndex) {
        String str = "";
        
        for (int i = 0; i < businessProcesses.size(); i++) 
        {
            String relativeIndexLocal=relativeIndex+(i+1);
            PhraseComponent component = businessProcesses.get(i);
            str=str+relativeIndexLocal+" "+component.getInfo(relativeIndexLocal);
        }
        return str;
    }
}
