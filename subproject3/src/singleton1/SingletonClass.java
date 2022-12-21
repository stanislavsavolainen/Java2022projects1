package singleton1;

public class SingletonClass {

	public String str1="1234"; 
	private static SingletonClass classInstance = null;
	
	public static SingletonClass getInstance() throws Exception {
		
		if( classInstance == null ){
			classInstance = new SingletonClass();
			System.out.println();
			System.out.println("Class inited successfully, hashCode : "+classInstance.hashCode());
		} 
		
		else {
			System.out.println();
			System.out.println("Fail to init new class, hashCode : " +classInstance.hashCode() );
			throw new Exception("Exception: Singleton class already exsist "); 
		}
				
		return classInstance;
	}

}
