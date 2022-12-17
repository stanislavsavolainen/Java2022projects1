package polymorphism1;

public class Windows extends OperationSystem {

	
	@Override
	public String fileSystem() {
		// TODO Auto-generated method stub
		return "NTFS";
	}

	@Override
	public String hardDisk() {
		// TODO Auto-generated method stub
		return "C:";
	}

	@Override
	public String downloads(String username) {
		// TODO Auto-generated method stub
		return "C:/Users/"+username+"/Downloads";
	}

	@Override
	public String SystemName() {
		// TODO Auto-generated method stub
		return "Windows";
	}
	
	// don't need Override annotation, because it is not abstract function 
	// we do method overriding which is not mandatory 
	// https://www.javatpoint.com/method-overriding-in-java
	public String license(){
		return "EULA - license";
	}
	
	

}
