import java.util.ArrayList;

import utilitytools.UtilityTools;
import singleton1.SingletonClass;
import notify1.ThreadClass1;
import notify1.ThreadClass2;
import volatile1.VolatileClass;
import volatile1.ThreadClass;

public class Main {

	//singleton demo 
	static int classCount = 10;
	
	//volatile demo
	static int mainValue1 = 0;
	static int mainValue2 = 0;
	static int amountOfThreads = 5;
	
	public static void main( String [] args ){
		
		UtilityTools myUtils = new UtilityTools();
		
		//=====================================================================
		myUtils.twoEmptyLine();
		System.out.println("\t\tSingleton class demo ");
		myUtils.twoEmptyLine();
		
		ArrayList<SingletonClass> singletonList = new ArrayList<SingletonClass>();
		
		for(int i = 0; i < classCount; i++){
		
			try{
				
				singletonList.add( new SingletonClass());
				singletonList.get(i).getInstance();
				
				//eliminated by singleton, because static -> hold original value
				if( i == 3 ) singletonList.get(i).str1 = "fdfsd";  
			
				//eliminated by singleton, because static -> hold original value
				if( i == 7 ) singletonList.get(i).str1 = "fjsdklfjl";
				
			}catch(Exception e){
				System.out.println("Error creating class " + e);
			}
		
		}
		
		
		myUtils.twoEmptyLine();
		
		for(int i = 0; i < classCount; i++){
			System.out.println( "Singleton-class variable value " + singletonList.get(i).str1 );
		}
		
		//=====================================================================
		myUtils.twoEmptyLine();
		System.out.println("\t\tThread-Notify wait & sleep demo ");
		myUtils.twoEmptyLine();
		
		ThreadClass1 myThread1 = new ThreadClass1();
		ThreadClass2 myThread2 = new ThreadClass2(myThread1);
		
		myThread1.start();
		myUtils.utilityDelay(5000);
		myThread2.start();
		myUtils.utilityDelay(2000);
		
		myUtils.twoEmptyLine();
		myUtils.displayMyThreadsStatus( myThread1, myThread2 );
		myUtils.twoEmptyLine();
		myUtils.utilityDelay(10000);
		myUtils.twoEmptyLine();
		System.out.println("Display threads after notify and wait compleated ! ");
		System.out.println( "thread1 name = "+ myThread1.getName() + ", thread1 state=" + myThread1.getState() );
		System.out.println( "thread2 name = "+ myThread2.getName() + ", thread2 state=" + myThread2.getState() );
		//=====================================================================
		myUtils.twoEmptyLine();
		System.out.println("\t\tStatic-volatile thread demo ");
		myUtils.twoEmptyLine();
		VolatileClass myVolatileObject = new VolatileClass();
		//myVolatileObject.value1 = mainValue1;
		//myVolatileObject.value2 = mainValue2;
		
		ArrayList<ThreadClass> volatileThreadList = new ArrayList<ThreadClass>();
		System.out.println("ArrayList of ThreadClass1, hashCode : " + volatileThreadList.hashCode());
		
		for( int i = 0; i < amountOfThreads; i++) {
			volatileThreadList.add( new ThreadClass( mainValue1, mainValue2 ) );
			System.out.println("created threadClass, hashCode : " + volatileThreadList.get(i).hashCode());
		}
		
		for( int i = 0; i < amountOfThreads; i++) volatileThreadList.get(i).start();
			
		myUtils.utilityDelay(2000);
		
		System.out.println("In main volatile object value1 = " + myVolatileObject.value1 );
		System.out.println("In main volatile object value2 = " + myVolatileObject.value2 );
		System.out.println("ArrayList of ThreadClass1, hashCode : " + volatileThreadList.hashCode());
		//=====================================================================
		
	}
	
}
