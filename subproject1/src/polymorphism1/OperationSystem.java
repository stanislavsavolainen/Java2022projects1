package polymorphism1;

public abstract class OperationSystem {

	public abstract String SystemName();
	
	public abstract String fileSystem();
	
	public abstract String hardDisk();
	
	public abstract String downloads(String username);
	
	public String license(){ 
		return "undefined license !"; 
	}
	
}
