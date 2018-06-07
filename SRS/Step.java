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
public class Step extends PhraseComponent{
    ArrayList<Action> actions = new ArrayList<Action>();

    Step(){
    
    }
    Step(String phrase){
        super.setPhrase(phrase);
    }
    
    public ArrayList<Action> getActions() {
        return actions;
    }

   
   

    @Override
    public void append(PhraseComponent o) {
        Action action= (Action)o;
        actions.add(action);
    }

    @Override
    public void remove(PhraseComponent o) {
        Action action= (Action)o;
        actions.remove(action);
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public String getAllInfo(String relativeIndex) {
        String str = getPhrase()+"\n";
        for (int i = 0; i < actions.size(); i++) {
            String relativeIndexLocal="   "+relativeIndex+"."+(i+1);
            PhraseComponent component = actions.get(i);
            str=str+relativeIndexLocal+" "+component.getInfo(relativeIndexLocal);
        }
        return str;
    }
    
}
