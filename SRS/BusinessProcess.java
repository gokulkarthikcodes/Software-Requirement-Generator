
package sdpproject;
import java.util.ArrayList;


public class BusinessProcess extends PhraseComponent{
	
	int priority;
	ArrayList<Step> steps = new ArrayList<Step>();

        public BusinessProcess(String phrase,int priority) {
            super.setPhrase(phrase);
            this.setPriority(priority);
            
        }
	
        
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}



	public ArrayList<Step> getAggregates() {
		return steps;
	}



	
	
	
	public String toString(){
            String str = super.getPhrase()+" (Priority : "+getPriority()+")";
            return str;
        }

	
	
	

        @Override
        public void append(PhraseComponent o) {
            Step step = (Step)o;
            steps.add(step);
        }

        @Override
        public void remove(PhraseComponent o) {
            Step step=(Step)o;
            steps.remove(step);
        }
        
        @Override
        public String getAllInfo(String relativeIndex) {
            String str = getPhrase()+"\n";
            for (int i = 0; i < steps.size(); i++) {
                String relativeIndexLocal="   "+relativeIndex+"."+(i+1);
                PhraseComponent component = steps.get(i);
                str=str+relativeIndexLocal+" "+component.getInfo(relativeIndexLocal);
            }
            return str;
        }
	

}
