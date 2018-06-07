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
public abstract class PhraseComponent extends Phrase {

    @Override
    public String getPhrase() {
        return super.getPhrase(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPhrase(String phrase) {
        super.phrase = phrase;
    }

    
    
	public int getPriority() {
		return 0;
	}

	public void setPriority(int priority) {
		
	}

    public String getInfo(String relativeIndex){
        return getAllInfo(relativeIndex);
                
    }

    
    public abstract String getAllInfo(String relativeIndex);
    
    public void append(PhraseComponent component) {
        
    }

    
    public void remove(PhraseComponent component) {
        
    }
    
    
    
}
