package notify1;

import java.util.Date;

import utilitytools.UtilityTools;

public class ThreadClass2 extends Thread {

	private long currentThreadId = -1;
	
	ThreadClass1 firstThreadObject;
		
	public ThreadClass2( ThreadClass1 paramFirstThread ){
		firstThreadObject = paramFirstThread;
	}
	
	public long threadObjGetId(){ return currentThreadId; }
	
	private void threadObjSetId( long paramThreadId){
		currentThreadId = paramThreadId;
	}
	
	@Override
	public void run(){
		
		Thread threadInfo = Thread.currentThread();
		threadObjSetId(threadInfo.getId());
		
		UtilityTools threadUtils = new UtilityTools();
		
		synchronized (this.firstThreadObject){
			
			 System.out.println(
		                Thread.currentThread().getName()
		                + "...starts, ThreadClass2 at : "+(new Date().toString() ));
			
			threadUtils.utilityDelay(5000);
				
			//compare to JavaScript Promise resolve call to unlock await function
			this.firstThreadObject.notify(); 
			
			
			 System.out.println(
		                Thread.currentThread().getName()
		                + " continue working : "+(new Date().toString() )); 
			
		}
		
	}
	
	
}
