package jaxbmarshaller1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import modelclass1.Person2;
import utilitytools.FilesArray;
import utilitytools.UtilityTools;

public class JaxbService {

	FilesArray JaxbIOFiles;
	UtilityTools JaxbUtility;
	
	public JaxbService(){
		JaxbUtility = new UtilityTools();
	}
	
	public void jaxbMarshaller( Person2 paramPerson ){
	
		JaxbUtility.linebreaks();
		System.out.println("JAXB Marshaller begin");
		
	     try {
	    	 
	          JAXBContext jaxbContext = JAXBContext.newInstance(Person2.class);
	          Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	          //Jax formatting
	          jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	 
	          StringWriter sw = new StringWriter();
	          jaxbMarshaller.marshal( paramPerson, sw);
	          
	          String xmlContent = sw.toString();
	          System.out.println( "JAXB content : " );
	          System.out.println( xmlContent );
	          
	          JaxbUtility.writeToFile(xmlContent, JaxbIOFiles.filepath + JaxbIOFiles.jaxboutputfilename );
	          
	      } catch (JAXBException e) {
	          e.printStackTrace();
	      }
		
	}
	
	public Person2 jaxbUnmarshaller () {
	
		JaxbUtility.linebreaks();
		System.out.println("JAXB Unmarshaller begin");
		
		  try {
				
			  JAXBContext context = JAXBContext.newInstance(Person2.class);
			
			//return new Person();
			  try {
				  
				String filepath = JaxbIOFiles.filepath;
				String filename = JaxbIOFiles.jaxboutputfilename;
				  
				return (Person2) context.createUnmarshaller()
					      .unmarshal(new FileReader(filepath+filename));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return null;
			}
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		
		
	}
	
	
}
