package utilitytools;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class UtilityTools {

	public void linebreaks(){
		for(int i = 0; i < 2; i++) System.out.println();
	}
	
	public String generateUUIDString(){
		UUID uuid = UUID.randomUUID();
		//System.out.println("UUID : " + uuid.toString());
		return uuid.toString();
	}
	
	
	 public void writeToFile( String content, String filename ) {

	        try {
	            FileWriter myWriter = new FileWriter(filename);
	            myWriter.write(content);
	            myWriter.close();
	            
	            System.out.println("Successfully wrote to the file. Check your file : " +filename );
	        } catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }        
	
	 }
	 
	 
	 public String readFile( String fullpath ){
		 
		 String content = "";
		 
		 try {
	            FileReader myReader = new FileReader(fullpath);
	            int i;    
	            while((i = myReader.read())!=-1) content += (char) i;  
	            myReader.close();
	            linebreaks();
	            System.out.println("Successfully read file : "+fullpath);
	       
		 } catch (IOException e) {
			 	linebreaks();
	            System.out.println("An error occurred :" +fullpath);
	            e.printStackTrace();
	            linebreaks();
		 }
		 
		 return content;
	 }
	 
	 
}
