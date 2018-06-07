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
public class Action extends PhraseComponent{

    public Action(String phrase) {
           super.setPhrase(phrase);
    }

    @Override
    public String getAllInfo(String relativeIndex) {
        String str = getPhrase()+"\n";
        return str;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
