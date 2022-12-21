package notify1;

import java.util.Date;

import utilitytools.UtilityTools;

public class ThreadClass1 extends Thread {

	private long currentThreadId = -1;
	
	public long threadObjGetId(){ return currentThreadId; }
	
	private void threadObjSetId( long paramThreadId){
		currentThreadId = paramThreadId;
	}
	
	
	@Override
	public void run(){
		
		Thread threadInfo = Thread.currentThread();
		threadObjSetId(threadInfo.getId());
		
		UtilityTools threadUtils = new UtilityTools();
		
		 synchronized (this){
			 
			 System.out.println(
		                Thread.currentThread().getName()
		                + "...starts, ThreadClass1 at: " + (new Date().toString()));
			 
			 try {
				//compare to JavaScript async await, lock here until resolve come from Promise 
				this.wait();
	
				threadUtils.utilityDelay(5000);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 System.out.println(
		                Thread.currentThread().getName()
		                + " continue working : "+(new Date().toString() )); 
			 
		 }
		
	}
	
	
}
