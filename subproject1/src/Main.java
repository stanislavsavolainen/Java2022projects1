import polymorphism1.OperationSystem;
import polymorphism1.Linux;
import polymorphism1.Windows;

import interface1.*;


class SubClass{
	
	public int function1( int i ){
		
		return i*i;
	}
	
}

public class Main implements Person, Profession  {

	
	public static void checkSystem( OperationSystem os, String username) {
		
		//System.out.println("===== checking "+os.SystemName()+" system ====================");
		System.out.println("Filesystem : " + os.fileSystem() );
		System.out.println("Hard-disk mounted to : " + os.hardDisk() );
		System.out.println("Default downloads folder is : " + os.downloads(username) );
		System.out.println("License type : " + os.license() ); // method override call
		System.out.println();	
	}
	
	public static void drawLineToLog(){
		System.out.println("===================================================");
		 
	}
	
	// read about Java function overloading ( same function name )
	public static void drawLineToLog( String param ){
		System.out.println("======"+ param  +"====================");	                                                    
	}

	public static void main(String[] args) {
		
		drawLineToLog();
		SubClass subclassInstance = new SubClass();
		System.out.println(  "Call subclass from main : " + subclassInstance.function1(5) );
		//google -> java system out print formatting
		System.out.printf(  "Call subclass from main : %s \n" , subclassInstance.function1(5) );
	
		drawLineToLog();
		// read about Java polymorphism and do your own solution ( this is how I handle it ) 
		OperationSystem win = new Windows();
		OperationSystem lin = new Linux();
		
		drawLineToLog( "checking "+win.SystemName()+" system ");
		checkSystem(win, "Stanislav");
		drawLineToLog( "checking "+lin.SystemName()+" system ");
		checkSystem(lin, "Stanislav");
		
		drawLineToLog();
		// read about Java interface, create your own , also you can use existing one
		 new Main().work();
		 new Main().walk();
		 drawLineToLog();
	}

	// implement your empty interface method ,  write content

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("I am working!" );
	}


	@Override
	public int earnSalary() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int payTaxes() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void talk() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("Person walking !");
		
	}
	
	
}
