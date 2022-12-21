package volatile1;

//import UtilityTools;
import utilitytools.UtilityTools;

public class ThreadClass extends Thread {

	private int value1;
	private int value2;
	private volatile VolatileClass volatileObject;
	private UtilityTools threadUtils;
	
	public ThreadClass( ){
		volatileObject = new VolatileClass();
		threadUtils = new UtilityTools();
	}
	
	public ThreadClass( int param1, int param2 ){
		volatileObject = new VolatileClass();
		threadUtils = new UtilityTools();
		value1 = param1;
		value2 = param2;
	}
	
	public ThreadClass( VolatileClass paramVolatileObject){
		volatileObject = paramVolatileObject;
		threadUtils = new UtilityTools();
		value1 = volatileObject.value1;
		value1 = volatileObject.value2;
	}
	
	@Override
	public void run(){ 
		
		 value1++;
		 value2++;
		 
		 volatileObject.value1++;
		 volatileObject.value2++;
		
		 Thread threadInfo = Thread.currentThread();
		 System.out.println("******************************");
		 threadUtils.displaySelectedThreadInfo(threadInfo);
		 System.out.println("Thread volaileObject value1 = " + volatileObject.value1 + " value2 = " + volatileObject.value2 );
		 System.out.println("Thread Object value1 = " + value1 + " value2 = " + value2 );
		 System.out.println("******************************");
		
		 
	}
	
	
}
