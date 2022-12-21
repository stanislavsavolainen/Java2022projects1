package utilitytools;
import java.util.Set;

import notify1.ThreadClass1;
import notify1.ThreadClass2;


public class UtilityTools {

	public void utilityDelay(long miliseconds){
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void twoEmptyLine(){
		System.out.println();
		System.out.println();
	}
	
	public void displayAllThreadsStatus() {
		
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		
		twoEmptyLine();
		
		for (Thread s : threadSet) { 
			
			System.out.println("================");
			//System.out.println("Thread id : " + s.getId());
			//System.out.println("Thread name " + s.getName());
			displaySelectedThreadInfo(s);
			System.out.println("Thread is alive " + s.isAlive());
			System.out.println("Thread priority " + s.getPriority());
			//System.out.println("Thread state  " + s.getState());	
		}
	}
	
	public void displayMyThreadsStatus( ThreadClass1 a, ThreadClass2 b ) {
		
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		
		twoEmptyLine();
		
		for (Thread s : threadSet) { 
			
			if ( s.getId() == a.threadObjGetId() || s.getId() == b.threadObjGetId() ){
				System.out.println("=======??=======");
				//System.out.println("Thread id : " + s.getId());
				//System.out.println("Thread name " + s.getName());
				displaySelectedThreadInfo(s);
				System.out.println("Thread is alive " + s.isAlive());
				System.out.println("Thread priority " + s.getPriority());
				//System.out.println("Thread state  " + s.getState());
			}
		}
		
	}
		
	public void displaySelectedThreadInfo(Thread paramThread){
		System.out.println("Thread status in beging, class hashCode " + this.hashCode());
		System.out.println("Thread id : " + paramThread.getId());
		System.out.println("Thread name : " + paramThread.getName());
		System.out.println("Thread state : " +paramThread.getState());
	}
		
}

