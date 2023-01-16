import java.util.ArrayList;

//http://ivoronline.com/Coding/Languages/JAVA/APIS/JAVA%20-%20Servlets%20-%20SOAP.php

public class SoapXMLModel1 {

	
	public String upBlock(){
		
		   String xml = "";	
		
		   xml += "<?xml version=\"1.0\"?>";
           xml += "<SOAP-ENV:Envelope>";
           xml += "<SOAP-ENV:Body>";
           
           return xml;
		
	}
	
	
	public String midleBlock( String soapAction ){
		
		String xml = "";
		
		 xml += "<result>";
		 xml += "<soapAction>"+soapAction +"</soapAction>";
		 xml += "</result>";
		
		return xml;
		
	}
	
	
	public String midleBlock(ProductModel1 paramProduct , String soapAction ){
		
		String xml = "";
		
		 xml += "<result>";
		 xml += "<soapAction>"+soapAction + "</soapAction>";
		 xml += "</result>";
		
		return xml;
		
	}
	
	
	public String midleBlockOfAllProducts( ArrayList <ProductModel1> paramAllProducts ){
		
		String xml = "";
		
		xml += "<result>";
		xml += "<products>";
		for( ProductModel1 element : paramAllProducts ){
			xml += "<product>";
			xml += "<uuid>"+element.getUuid()+"</uuid>";
			xml += "<name>"+element.getName()+"</name>";
			xml += "<price>"+element.getPrice()+"</price>";
			xml += "<description>"+element.getDescription()+"</description>";
			xml += "</product>";
		}
		xml += "</products>";
		xml += "</result>";
		
		return xml;
		
	}
	
	
	public String downBlock(){
		
		 String xml = "";
		
		 xml += "</SOAP-ENV:Body>";
         xml += "</SOAP-ENV:Envelope>";
		
         return xml;
	}
	
	
	public String parseData( String xmlrpc ){
		
		String outputData = "";	
		
		/*
		 xml += "    <person>"; 
   	  	 xml += "    <name type='xsd:string'>"+paramName+"</name>";	
   	     xml += "    <price type='xsd:double'>"+paramPrice+"</price>";	
   	     xml += "    <description type='xsd:string'>"+paramDescription+"</description>";	
         xml += "    </person>";
		*/
		
		
		int startTag = xmlrpc.indexOf("<name type='xsd:string'>");
		int endTag   = xmlrpc.indexOf("</name>");
		String parameter = xmlrpc.substring(startTag,endTag).replaceAll("<name type='xsd:string'>","");
        parameter = parameter.trim();
        outputData += ""+parameter + ":";
            
        startTag = xmlrpc.indexOf("<price type='xsd:double'>");
        endTag   = xmlrpc.indexOf("</price>");
        parameter = xmlrpc.substring(startTag,endTag).replaceAll("<price type='xsd:double'>","");
        parameter = parameter.trim();
        outputData += ""+parameter + ":";
        
        startTag = xmlrpc.indexOf("<description type='xsd:string'>");
        endTag   = xmlrpc.indexOf("</description>");
        parameter = xmlrpc.substring(startTag,endTag).replaceAll("<description type='xsd:string'>","");
        parameter = parameter.trim();
        outputData += ""+parameter;
        
       
        return outputData;
	}
	
	
	
}
