
public class SyncClass1 {

	
	synchronized int handleData( String threadInfo,  int paramNumber, int count ){
		
		int answer = paramNumber;
		
		for( int i = 0; i < count; i++){
			try {
				Thread.sleep(500);
				answer += paramNumber;
				String debugLogMsg = "";
				debugLogMsg += "Debug thread "+threadInfo + ">>> sync function answer :" + answer;
				debugLogMsg += "( param :"+paramNumber + "and count : " + count + ")";
				System.out.println(debugLogMsg);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
	
		}
		
		return answer;
	}
	
}
