package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import modelclass1.Person;

import utilitytools.UtilityTools;

public class ObjectReflectionService {

	UtilityTools reflectUtils;
	
	public ObjectReflectionService(){
		reflectUtils = new UtilityTools();
	}
	
	public void debugObject( Object paramObj ){
		
		//==================== display object name ===============================
		reflectUtils.linebreaks();
		System.out.println("Starting ObjectReflectionService -> debugObject : ");
		System.out.println(" Object name : " + paramObj.getClass().toString() );
		
		Method [] classMethods = paramObj.getClass().getMethods();		
		
		
		//==================== reflect object constuctor(s) ======================
		reflectUtils.linebreaks();
		Object [] classMethods2 = paramObj.getClass().getConstructors();
		
		for( Object element : classMethods2 ){
			System.out.println("Constructor name " + element.toString()  );
		}
		
		//==================== reflect object methods ===========================
		reflectUtils.linebreaks();
		System.out.println("Display current object all methods : " );
		for( Method element : classMethods ){
			System.out.println("Method name " + element.toGenericString()  );
		}
		
		//==================== reflect object variables, types and values ========
		reflectUtils.linebreaks();
		System.out.println(" Display current object variables, types and values : " );
		
		String tempStr = paramObj.getClass().toString();
		String [] tempStr2 = tempStr.split(" ");
		String objectClassName = tempStr2[1];
		
		Field [] ff = paramObj.getClass().getDeclaredFields();
		
		for( Field element : ff ){
			
			element.setAccessible(true); 
			
			String subElement = "";
			
			subElement  += ("Object name : " + element.getName() );
			subElement  += (", type : " + element.getType() );
			subElement  += (", modifier : " + element.getModifiers() );
			
			Object value = null;
			
			try {
				 value = element.get(paramObj);
				
				 subElement  += (", value : " + value );
				 
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println( subElement);
			
		} // for
		
		//========================================================================
	}
	
	
	public String getXSDContent( Object paramObj ){
		
		System.out.println("Starting ObjectReflectionService -> getXSDContent : ");
		reflectUtils.linebreaks();
		System.out.println("Object name : " + paramObj.getClass().toString() );
		String tempStr = paramObj.getClass().toString();
		String [] tempStr2 = tempStr.split(" ");
		String objectClassName = tempStr2[1];
		
		String xsElement= "";
		
		xsElement += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		xsElement += "\n<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">";
		xsElement += "\n\t<xs:element name=\""+objectClassName+"\">";
		xsElement += "\n\t\t <xs:sequense>";   
		Field [] ff = paramObj.getClass().getDeclaredFields();
		
		for( Field element : ff ){
			
			
			element.setAccessible(true); 
			
			Object value = null;
			
			try {
				 value = element.get(paramObj);
				 		
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 xsElement += "\n\t\t\t <xs:element";
			 xsElement += " name=\""+element.getName()+"\"";
			
			if( element.getType().toString().equals("class java.lang.String") ){
			  xsElement += " type=\"xs:string\"";	
			  xsElement += " fixed=\""+value+"\"";
			}
			
			else if( element.getType().toString().equals("int") ){
				  xsElement += " type=\"xs:integer\"";
				  xsElement += " fixed=\""+value+"\"";
			}
			
			else if( element.getType().toString().equals("class java.util.Date") ){
				  xsElement += " type=\"xs:date\"";
				  xsElement += " fixed=\""+value+"\"";
			}
			
			else if( element.getType().toString().equals("boolean") ){
				  xsElement += " type=\"xs:boolean\"";
				  xsElement += " fixed=\""+value+"\"";
			}
			
			else if( element.getType().toString().equals("long") ){
				  xsElement += " type=\"xs:long\"";
				  xsElement += " fixed=\""+value+"\"";
			}
			
			
			xsElement += " />";
			
		}
		
		 xsElement += "\n\t\t </xs:sequense>"; 
		 xsElement += "\n\t</xs:element>";
		 xsElement += "\n</xs:schema>";
		 System.out.println(""+xsElement);
		
		 return xsElement;
	}
	
	
	public Person findClassVariableCollisionByKey( Object paramObj, HashMap<String, String> mapData ){
		
		Person transferPerson = new Person();
		
		//Field [] ff = paramObj.getClass().getDeclaredFields();
		Field [] ff = transferPerson.getClass().getDeclaredFields();
		
		for( Field element : ff ){
			
			//String subElement = "";
			
			//subElement  += ("Object name : " + element.getName() );
			//subElement  += (", type : " + element.getType() );
			//subElement  += (", modifier : " + element.getModifiers() );
			
			Object value = null;
			
			try {
				 value = element.get(paramObj);
				 
				 ConcurrentHashMap<Object, Object> concHashMap = new ConcurrentHashMap<Object, Object>();
				 
				 if( mapData.containsKey( element.getName() ) ){
				
					 concHashMap.put(element.getName(), mapData.get(element.getName()) );
					 element.set(transferPerson, concHashMap);
					 
					 	System.out.println("ObjectReflection -> collision found : " + element.getName() + " and value form map is : "+ mapData.get(element.getName()) );
	
					 	/*
						if(element.getType().equals("integer") ){
							concHashMap.put(element.getName(), mapData.get(element.getName()) );
							//element.set(paramObj, concHashMap);
							element.set(transferPerson, concHashMap);
							
						}
						else if(element.getType().equals("string") ){
							concHashMap.put(element.getName(), mapData.get(element.getName()) );
							//element.set(paramObj, concHashMap);
							element.set(transferPerson, concHashMap);
						}
						else if(element.getType().equals("date") ){
							concHashMap.put(element.getName(), mapData.get(element.getName()) );
							//element.set(paramObj, concHashMap);
							element.set(transferPerson, concHashMap);
						}
						
						else if(element.getType().equals("boolean") ){
							concHashMap.put( element.getName() , mapData.get(element.getName()) );
							//element.set(paramObj, concHashMap);
							element.set(transferPerson, concHashMap);
						}
						*/
				 }
				 
				 
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} // for
		
		return transferPerson;
	}
	
}
