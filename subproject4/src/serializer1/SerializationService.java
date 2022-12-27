package serializer1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import modelclass1.Person;

import utilitytools.UtilityTools;
import utilitytools.FilesArray;
import reflection.ObjectReflectionService;

class KeyValuePair{
	String key;
	String value;
}

public class SerializationService {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	UtilityTools serializerUtility;
	ObjectReflectionService reflect;
	FilesArray serializerIOFiles;
	
	//String filepath = "/home/unk900t2/programming2022/java2022proj1/serialized/1"; 
	//String filename = "serialized_person1.txt";
	//String filename_xsd = "serialized_person1.xsd";
	
	String filepath = serializerIOFiles.filepath;
	String filename = serializerIOFiles.filename;
	String filename_xsd = serializerIOFiles.filename_xsd;
	
	public SerializationService() {
		serializerUtility = new UtilityTools();
		reflect = new ObjectReflectionService();
	}
	
	
	public void serialize( Object paramObj ){
			 
		System.out.println("SerializationService -> serialize : ");
		serializerUtility.writeToFile( paramObj.toString() , serializerIOFiles.filepath+serializerIOFiles.filename);
		//serializerUtility.writeToFile( reflect.getXSDContent(paramObj) , filepath+filename_xsd);
	
	}
	
	public Object deserialize(){
		
		Person clonePerson = new Person();
		
		System.out.println("SerializationService -> deserialize : ");
		String objectStr = serializerUtility.readFile(filepath+filename);
		System.out.println("File content : " + objectStr);
	
		
		//objectStr.charAt(index)
		String objectName = "";
		int objectLength = 0;
		
		//clear junkElements
		for(int i= 0; i < objectStr.length() ; i++ ){
			
			char check = (char) objectStr.charAt(i);
			
			if( check != '['){
				objectName += check;
				objectLength++;
				
			} else break;
			
			
		}
		
		//String objectStr = objectStr.replaceAll("]", "");
		 
		 objectStr = objectStr.substring(0, objectStr.length()-1);
		 System.out.println("File content 2 : " + objectStr);
		 System.out.println("Length : " + objectStr.length() + "and object length : " + objectLength  );
		 objectStr = objectStr.substring( (objectLength + 1) , objectStr.length() );
		 System.out.println("File content 3 : " + objectStr  );
		 
		String elemets [] = objectStr.split(",");
		
		
		HashMap <String, String> rawKeyValuePairsList = new HashMap<String, String>();
		
		System.out.println("Parse deserialization elements :");
		for( String element : elemets ){
			
			System.out.println("\t"+element);
		
			String [] rawKeyValuePairs = element.split("=");
			String key = rawKeyValuePairs[0];
			String value = rawKeyValuePairs[1];
			
			rawKeyValuePairsList.put(key, value);
			
		}
		
		try{
			
			clonePerson.setFullName( rawKeyValuePairsList.get("fullname") );
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			Date birthDate2 = sdf2.parse( rawKeyValuePairsList.get("birthdate"));
			clonePerson.setBirthDate(birthDate2);
			
			String isonline = rawKeyValuePairsList.get("isonline");
			if( isonline.equals("true") ) clonePerson.setIsonline(true);
			else if( isonline.equals("false") ) clonePerson.setIsonline(false);
			
			clonePerson.setAge( Integer.parseInt(rawKeyValuePairsList.get("age") ) );
			
		} catch(Exception e){
			System.out.println("Deserialization failed at parsering data , reason : " + e);
		}
		//return reflect.findClassVariableCollisionByKey( paramObject, rawKeyValuePairsList);
		return clonePerson;
		
	}
	
}
