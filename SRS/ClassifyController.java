package sdpproject;


public class ClassifyController {
	public void classify(String phrase,String type, PhraseComponent parent)
	{
		if(type=="BusinessProcess"){
			BusinessProcess businessProcess = new BusinessProcess(phrase,1);
			parent.append(businessProcess);
			//System.out.println("Added business process");
			
		}
                
                
		else if(type=="Step")
		{
			Step step= new Step(phrase);
			 parent.append(step);
			//System.out.println("Added step to business process");
		}
                
		else if(type=="Action")
		{
			Action action=new Action(phrase);
			 parent.append(action);
			//System.out.println("Added action to step");
		}
	}
}