
public class SyncClass1 {

	
	synchronized int handleData( String threadInfo,  int paramNumber, int count ){
		
		int answer = paramNumber;
		
		for( int i = 0; i < count; i++){
			try {
				Thread.sleep(500);
				answer += paramNumber;
				System.out.println("Debug thread "+threadInfo + ">>> sync function answer :" + answer + "( param :"+paramNumber + "and count : " + count + ")");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
	
		}
		
		return answer;
	}
	
}
