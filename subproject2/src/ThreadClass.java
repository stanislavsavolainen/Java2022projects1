
public class ThreadClass extends Thread {

	private long currentThreadId = -1;
	
	
	public long threadObjGetId(){ return currentThreadId; }
	
	private void threadObjSetId( long paramThreadId){
		currentThreadId = paramThreadId;
	}
	
	
	@Override
	public void run(){  
		
		//return current thread info
		 Thread threadInfo = Thread.currentThread();
		 
		 System.out.println("Thread status in beging ");
		 System.out.println("Thread id : " + threadInfo.getId());
		 System.out.println("Thread name " + threadInfo.getName());
		 System.out.println("Thread is alive " + threadInfo.isAlive());
		 System.out.println("Thread priority " + threadInfo.getPriority());
		 System.out.println("Thread state  " + threadInfo.getState());
		 
		 for(int i =0; i < 20; i++){
			
			 try {
				Thread.sleep(500);
				
				//System.out.println("Thread running, counter : " + i);
				
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			
		 }
		
	}
		
}
