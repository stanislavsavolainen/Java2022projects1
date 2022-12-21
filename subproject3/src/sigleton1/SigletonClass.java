package sigleton1;

public class SigletonClass {

	public String str1="1234"; 
	private static SigletonClass classInstance = null;
	
	public static SigletonClass getInstance() throws Exception {
		
		if( classInstance == null ){
			classInstance = new SigletonClass();
			System.out.println();
			System.out.println("Class inited successfully, hashCode : "+classInstance.hashCode());
		} 
		
		else if ( classInstance != null ) {
			System.out.println();
			System.out.println("Fail to init new class, hashCode : " +classInstance.hashCode() );
			throw new Exception("Exception: Sigleton class already exsist "); 
		}
				
		return classInstance;
	}

}
