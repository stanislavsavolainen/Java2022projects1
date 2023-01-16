import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;


public class SoapRequestContent {

	
	public String read( HttpServletRequest request ){
		
		   ServletInputStream i; 

	        int c = 0;

	        String xmlrpc = "";

	        try{
	        	
	        	i = request.getInputStream();
	        	
	        	while((c = i.read()) != -1 ){ 
	        		
	        		xmlrpc += (char)c; 
	        		
	        	}
	        	
	        	
	        	
	        }catch(IOException e){
	        	
	        }
		
		
		return xmlrpc;
	}
	
}
