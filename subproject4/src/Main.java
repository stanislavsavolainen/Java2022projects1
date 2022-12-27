
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import utilitytools.UtilityTools;
import utilitytools.FilesArray;
import modelclass1.Person;
import serializer1.SerializationService;
import jaxbmarshaller1.JaxbService;
import modelclass1.Person2;
import reflection.ObjectReflectionService;

public class Main {

	public static void main( String [] args ){
		
		
		UtilityTools myUtils = new UtilityTools();
		FilesArray mainFilesArray = new FilesArray();
		
		//=================== Serializer demo =========================
		
		System.out.println("\t\tSerializer demo ");
		
		Person myCharacter = null;
		SerializationService mySerializer = new SerializationService();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			Date birthDate1 = sdf1.parse("1992-07-26");
			
			myCharacter = new Person( "Kalle Makinen", 40, birthDate1 );
			
			myUtils.linebreaks();
			System.out.println("Begin serialization service : ");
			mySerializer.serialize(myCharacter);
			System.out.println("Serialization is done ");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed parsering Serializer Person-object, reason : " + e);
			e.printStackTrace();
		}
		
		myUtils.linebreaks();
		System.out.println("Begin deserialization service : ");
		Person cloneCharacter = new Person();
		System.out.println( "Clone fullname :" + cloneCharacter.getFullname() );
		System.out.println( "Clone age :" + cloneCharacter.getAge() );
		System.out.println( "Clone birthdate :" + cloneCharacter.getBirthdate() );
		System.out.println( "Clone is online:" + cloneCharacter.getIsonline() );
		
		myUtils.linebreaks();
		cloneCharacter = (Person) mySerializer.deserialize();
		
		System.out.println("Deserialization is done ");
		System.out.println( "Clone fullname :" + cloneCharacter.getFullname() );
		System.out.println( "Clone age :" + cloneCharacter.getAge() );
		System.out.println( "Clone birthdate :" + cloneCharacter.getBirthdate() );
		System.out.println( "Clone is online:" + cloneCharacter.getIsonline() );
		
		//=================== JAXB Marshaller demo ====================
		
		myUtils.linebreaks();
		System.out.println("\t\tJAXB Marshaller demo ");
		JaxbService myJaxbMarshaller = new JaxbService();
		
		Person2 myCharacter2 = null;
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			Date birthDate2 = sdf3.parse("1996-11-09");
			
			myCharacter2 = new Person2( "Jorma Kukkonen", 60, birthDate2 );
			
			myUtils.linebreaks();
			System.out.println("Begin jaxb-marshaller service : ");
			myJaxbMarshaller.jaxbMarshaller(myCharacter2);
			System.out.println("jaxb-marshaller is done ");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed parsering Jaxb-Marshaller Person-object, reason : " + e);
			e.printStackTrace();
		}
		
		
		myUtils.linebreaks();
		System.out.println("Begin jaxb-unmarshaller service : ");
		Person2 cloneCharacter2 = new Person2();
		System.out.println( "Clone fullname :" + cloneCharacter2.getFullname() );
		System.out.println( "Clone age :" + cloneCharacter2.getAge() );
		System.out.println( "Clone birthdate :" + cloneCharacter2.getBirthdate() );
		System.out.println( "Clone is online:" + cloneCharacter2.getIsonline() );
		cloneCharacter2 = myJaxbMarshaller.jaxbUnmarshaller();
		System.out.println("Jaxb-unmarshaller is done ! ");
		System.out.println( "Clone fullname :" + cloneCharacter2.getFullname() );
		System.out.println( "Clone age :" + cloneCharacter2.getAge() );
		System.out.println( "Clone birthdate :" + cloneCharacter2.getBirthdate() );
		System.out.println( "Clone is online:" + cloneCharacter2.getIsonline() );
		
		//=================== Java reflection ( debug object ) ========
		
		myUtils.linebreaks();
		System.out.println("\t\tJava reflection demo ( debug object ) ");
		ObjectReflectionService debugObj = new ObjectReflectionService();
		debugObj.debugObject(myCharacter);
		myUtils.linebreaks();
		debugObj.debugObject(myCharacter2);
		
		String xsdFileDebug1 = "";
		xsdFileDebug1 += debugObj.getXSDContent(myCharacter);
		myUtils.writeToFile(xsdFileDebug1, mainFilesArray.filepath + mainFilesArray.debugOutputXSD1);
		xsdFileDebug1 = "";
		xsdFileDebug1 += debugObj.getXSDContent(myCharacter2);
		myUtils.writeToFile(xsdFileDebug1, mainFilesArray.filepath + mainFilesArray.debugOutputXSD2);
		
	}
	
}
