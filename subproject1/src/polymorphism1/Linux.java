package polymorphism1;

public class Linux extends OperationSystem {

	@Override
	public String fileSystem() {
		// TODO Auto-generated method stub
		return "ext4";
	}

	@Override
	public String hardDisk() {
		// TODO Auto-generated method stub
		return "/dev/sda1";
	}

	@Override
	public String downloads(String username) {
		// TODO Auto-generated method stub
		return "/home/"+username+"/Downloads";
	}

	@Override
	public String SystemName() {
		// TODO Auto-generated method stub
		return "Linux";
	}

}
