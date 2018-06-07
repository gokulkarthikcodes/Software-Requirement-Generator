/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdpproject;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author gokulkarthik
 */
class GenerateController {
	
	private String[] displayText =new String[1000];
    private int numberLines = 0;

    /**
     * saveAsXml function must be provided two parameters:
     * @param requirement
     * @param path
     * 			parameter: path should be included the fileName and fileSuffix (E.g. path="D:/.../requirement.xml) 
     */
    public void saveAsXml(Requirement requirement,String path){
    	
    	Requirement r=requirement;
    	ArrayList<BusinessProcess> bpList=r.getAggregates();
    	try {
    		Document doc=new Document();
    		
    		Element root=new Element("Requirement");
    		doc.addContent(root);
    		
    		for(BusinessProcess bp : bpList){
    			Element bpe=new Element("BusinessProcess");
    			bpe.setAttribute("name", bp.getPhrase());
    			bpe.setAttribute("priority", String.valueOf(bp.getPriority()));
    			if(bp.getAggregates().size()!=0){
    				for(Step s : bp.getAggregates()){
    					Element se=new Element("Step");
    					se.setAttribute("name",s.getPhrase());
    					if(s.getActions().size()!=0){
    						for(Action a : s.getActions()){
    							Element ae=new Element("Action");
    							ae.setAttribute("name", a.getPhrase());
    							se.addContent(ae);
    						}
    					}
    					bpe.addContent(se);
    				}
    			}
    			root.addContent(bpe);
    			
    		}
    		
    		XMLOutputter outputter = new XMLOutputter();
    		outputter.output(doc, new FileOutputStream(path));
    		} catch (Exception e) {
    		e.printStackTrace();
    		}
    	
    }
    
    /**
     * loadFormXml function must be provided one parameter "path" (E.g.  path="D:/.../requirement.xml)
     * this function will return a Requirement instance.
     * @param path
     * @return
     */
    public Requirement loadFromXml(String path){
    	Requirement r=new Requirement();
    	try {

    		// Build w/ SAX and JAXP, no validation
    		SAXBuilder b = new SAXBuilder();
    		// Create the document
    		Document doc = b.build(new File(path));

    		Element root=doc.getRootElement();  		
    		if(root.getChildren().size()!=0 
    				&& root.getChildren().get(0).getName().equals("BusinessProcess")){
    			List bpelist=root.getChildren();
    			for(int i=0;i<bpelist.size();i++){
    				Element bpe=(Element)bpelist.get(i);
    				BusinessProcess bp= new BusinessProcess(bpe.getAttributeValue("name"),bpe.getAttribute("priority").getIntValue());
    				if(bpe.getChildren().size()!=0
    						&& bpe.getChildren().get(0).getName().equals("Step")){
    					List selist=bpe.getChildren();
    					for(int j=0;j<selist.size();j++){
    						Element se=(Element)selist.get(j);
    						Step s=new Step(se.getAttributeValue("name"));
    						if(se.getChildren().size()!=0
    								&& se.getChildren().get(0).getName().equals("Action")){
    							List alist=se.getChildren();
    							for(int k=0;k<alist.size();k++){
    								Element ae=(Element)alist.get(k);
    								Action a = new Action(ae.getAttributeValue("name"));
    								s.append(a);
    							}
    						}
    						bp.append(s);
    					}
    				}
    				r.getAggregates().add(bp);
    			}
    		}

    		} catch (Exception e) {

    		e.printStackTrace();
    		}
    	
    	return r;
    }
    
    
    
    
    public String generate(Requirement r){
        //System.out.println(r.getAllInfo("R"));
        return r.getInfo("R");
        
        /*
    	childLoop(r.getAggregates(),"",0,0);
    	String []text=new String[numberLines];
    	for(int i=0;i<numberLines;i++){
    		text[i]=displayText[i];
    	}
    	return text;
        */
    }
    private  void childLoop(ArrayList objects , String indentation, int bpNumber,int sNumber)
    {
        if (objects.size() == 0) {
            return;
        }
        String type = objects.get(0).getClass().getSimpleName();

        switch (type) {
            case "BusinessProcess": {
            	int length=objects.size();
            	for(int i=0;i<length;i++){
            		BusinessProcess bp=(BusinessProcess)objects.get(i);
            		displayText[numberLines] = indentation;
            		 displayText[numberLines] +=
                             "R"+(i+1)+". "+bp.getPhrase();
                         numberLines++;
                         if(bp.getAggregates().size()!=0){
                        	 indentation += "    ";
                        	 childLoop(bp.getAggregates(),indentation,i+1,0);
                        	 indentation=indentation.substring(0,
                                     indentation.length() - 4);
                         }
            	}
                break;
             }

             case "Step": {
            	 int length=objects.size();
            	 int bpN=bpNumber;
            	 
            	 for(int i=0;i<length;i++){
            		 Step s=(Step)objects.get(i);
            		 displayText[numberLines] = indentation;
                     displayText[numberLines] += "R"+bpNumber+"."+(i+1)+". ";
                     displayText[numberLines] += s.getPhrase();
                     numberLines++;
                     if(s.getActions().size()!=0){
                    	 indentation += "    ";
                    	 childLoop(s.getActions(),indentation,bpN,i+1);
                    	 indentation=indentation.substring(0,
                                 indentation.length() - 4);
                    	 
                     }
            	 }
                 break;
             }

             case "Action": {
            	 int length=objects.size();
            	
            	 for(int i=0;i<length;i++){
            		 Action a=(Action)objects.get(i);
            		 displayText[numberLines] = indentation;
                     displayText[numberLines] += "R"+bpNumber+"."+(sNumber) +"." +(i+1)+". ";
                     displayText[numberLines] += a.getPhrase();
                     numberLines++;
            	 }
                 break;
                
             }

        }
        
    }
    
}
