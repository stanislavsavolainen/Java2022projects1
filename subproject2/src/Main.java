import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

public class Main {

	public static void displayAllThreadStatus( ) {
	
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		
		for(int i = 0; i < 2; i++)System.out.println();
		
		for (Thread s : threadSet) { 
			
				System.out.println("================");
				System.out.println("Thread id : " + s.getId());
				System.out.println("Thread name " + s.getName());
				System.out.println("Thread is alive " + s.isAlive());
				System.out.println("Thread priority " + s.getPriority());
				System.out.println("Thread state  " + s.getState());
			
		}
	}
	
	
	public static void displayMyThreadStatus( ThreadClass a, ThreadClass b ) {
		
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		
		for(int i = 0; i < 2; i++)System.out.println();
		
			for (Thread s : threadSet) { 
			
				if ( s.getId() == a.threadObjGetId() || s.getId() == b.threadObjGetId() ){
					System.out.println("=======??=======");
					System.out.println("Thread id : " + s.getId());
					System.out.println("Thread name " + s.getName());
					System.out.println("Thread is alive " + s.isAlive());
					System.out.println("Thread priority " + s.getPriority());
					System.out.println("Thread state  " + s.getState());
				}
		}
		
	}
	
	public static void myThreadDebugSchedulerReportLog(ArrayList<ThreadClass2> paramThreadList ){
		
		String debugString="";
		// google -> java arraylist iterator
		//https://www.geeksforgeeks.org/arraylist-iterator-method-in-java-with-examples/
		Iterator<ThreadClass2> syncThreadIterator = paramThreadList.iterator();
		while (syncThreadIterator.hasNext()) {
					
			try{
				ThreadClass2 tempElement = syncThreadIterator.next();
				debugString = "";
				debugString += "\t Sceduler debug >>> ";
				debugString += "name="+tempElement.getName();
				debugString += ", id ="+tempElement.getId();
				debugString += ", state ="+tempElement.getState();
				
				System.out.println(debugString);
				
			} catch(java.util.NoSuchElementException e ){
				System.out.println("Error in scheduler iterator " + e);
			}
			
		 }
		
	}
	
	
	public static void main( String [] args){
		
		for(int i = 0; i < 2; i++)System.out.println();
		System.out.println("\t\tBasic thread demo with info begins ! ");
		for(int i = 0; i < 2; i++)System.out.println();
		
		
		ThreadClass mythreadobj1 = new ThreadClass();
		mythreadobj1.start();
		
		mythreadobj1.threadObjGetId();
		
		try {
			Thread.sleep(500);
						
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ThreadClass mythreadobj2 = new ThreadClass();
		mythreadobj2.start();
		
		try {
			Thread.sleep(2000);
						
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// ==  find what happen with my threads after run()- methon end ====
		System.out.println("Display my thread status in process");
		displayMyThreadStatus(mythreadobj1, mythreadobj2);
		System.out.println("Display all thread status in process");
		displayAllThreadStatus();
		
		try {
			Thread.sleep(5000);
						
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(" Display all threads ");
		displayMyThreadStatus(mythreadobj1, mythreadobj2);
		mythreadobj1.stop();
		mythreadobj2.stop();
		displayMyThreadStatus(mythreadobj1, mythreadobj2);
		
		//==================================================================
		try {
			Thread.sleep(3000);
						
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Display all thread status after tread-stop");
		displayAllThreadStatus();
		
		System.out.println( mythreadobj1.getState().toString() );
		System.out.println( mythreadobj2.getState().toString() );

		//============ JAVA synchronized methods with thread ==============
		for(int i = 0; i < 2; i++)System.out.println();
		System.out.println("\t\tSynchronized demo begins ! ");
		for(int i = 0; i < 2; i++)System.out.println();
		SyncClass1 mySyncObj = new SyncClass1();
		
		ArrayList<ThreadClass2> syncThreadList = new ArrayList<ThreadClass2>();
		
		syncThreadList.add( new ThreadClass2( mySyncObj, 2, 10) );
		syncThreadList.add( new ThreadClass2( mySyncObj, 5, 10) );
		syncThreadList.add( new ThreadClass2( mySyncObj, 8, 20) );
		
		for (int syncThreadIndex = 0; syncThreadIndex < syncThreadList.size(); syncThreadIndex++) {
			//start all theads from list by each index
			syncThreadList.get(syncThreadIndex).start();
		}
			
		//========= independent scheduler locked in main =====================
		for(int i = 0; i < 10; i++){
			
			try {
				Thread.sleep(500*5);
							
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Scheduler activated !");
			myThreadDebugSchedulerReportLog(syncThreadList);
			
		}
		
		//=====================================================================
	
	}
	
}
