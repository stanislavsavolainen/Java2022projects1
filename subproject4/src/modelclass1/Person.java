package modelclass1;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -618265888698742953L;
	public String fullname;
	public int age;
	public boolean isonline;
	public Date birthdate;
	
	public Person(){}
	
	public Person( String fullname, int age, Date birthdate){
		this.fullname = fullname;
		this.age = age;
		this.birthdate = birthdate;
	}
	
	public void setFullName( String fullname ) { this.fullname = fullname; }
	
	public void setAge( int age) { this.age = age; }
	
	public void setBirthDate(Date birthdate) { this.birthdate = birthdate; }
	
	public void setIsonline( boolean isonline ){ this.isonline = isonline; }
		
	public String getFullname() { return fullname; }
	
	public int getAge() { return age;  }
	
	public Date getBirthdate() { return birthdate;  }
	
	public boolean getIsonline() { return isonline;  }
	
	@Override
	public String toString(){
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String convertBirthDateToStr = sdf2.format(birthdate);
		
		return "Person[fullname="+fullname+",age="+age+",birthdate="+convertBirthDateToStr+",isonline="+isonline+"]";
	}
	
}
