package modelclass1;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAccessType;


//import from mvn-repository/maven jakarta-libray -> alternative to javax.xml
//import jakarta.xml.bind.JAXBContext;



@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8395609785695151774L;
	
	@XmlElement
	public String fullname;
	@XmlElement
	public int age;
	@XmlElement
	public boolean isonline;
	@XmlElement
	public Date birthdate;
	
	public Person2(){
		super();
	}
	
	public Person2( String fullname, int age, Date birthdate){
		super();
		this.fullname = fullname;
		this.age = age;
		this.birthdate = birthdate;
	}
	
	
	public void setFullName( String fullname ) { this.fullname = fullname; }
	public void setAge( int age) { this.age = age; }
	public void setBirthDate(Date birthdate) { this.birthdate = birthdate; }
	public void setIsonline( boolean isonline ){ this.isonline = isonline; }
	
	public String getFullname() { return this.fullname; }
	public int getAge() { return this.age;  }
	public Date getBirthdate() { return this.birthdate;  }
	public boolean getIsonline() { return this.isonline;  }
	
	
	@Override
	public String toString(){
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String convertBirthDateToStr = sdf2.format(birthdate);
		
		return "Person2[fullname="+fullname+",age="+age+",birthdate="+convertBirthDateToStr+",isonline="+isonline+"]";
	}
	
}
