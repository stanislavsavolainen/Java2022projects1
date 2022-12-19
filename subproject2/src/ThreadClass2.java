
public class ThreadClass2 extends Thread {

	private int paramNumber; 
	private int count;
	
	private SyncClass1 syncObject;
	
	public ThreadClass2( SyncClass1 paramSyncObject, int paramNumber, int count ){
		syncObject = paramSyncObject;
		this.paramNumber = paramNumber;
		this.count = count;
	}
	
	@Override
	public void run(){  

		 Thread threadInfo = Thread.currentThread();
		 System.out.println("******************************");
		 System.out.println("Thread status in beging ");
		 System.out.println("Thread id : " + threadInfo.getId());
		 System.out.println("Thread name " + threadInfo.getName());
		 System.out.println("Thread is alive " + threadInfo.isAlive());
		 System.out.println("Thread priority " + threadInfo.getPriority());
		 System.out.println("Thread state  " + threadInfo.getState());
		 System.out.println("******************************");
		 
		 String debugMsg = "name="+threadInfo.getName() + ",id="+threadInfo.getId();
		 
		 System.out.println("*************====*************");
		 int answer = syncObject.handleData( debugMsg, paramNumber, count);
		 System.out.println( "Thread " + debugMsg + " >>>>  answer is :" + answer);
		 System.out.println("*************====*************");
	}
	
}
