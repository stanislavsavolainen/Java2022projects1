import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="java_hibernate_demo1_product")
public class ProductModel1 {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="product_name")
	String name;
	
	@Column(name="product_uuid")
	String uuid;
	
	@Column(name="product_price")
	double price;
	
	@Column(name="product_description")
	String description;
	
	public ProductModel1(){}
	
	public ProductModel1( String uuid , String name , double price, String description ){
		
		this.uuid = uuid;
		this.name = name;
		this.price = price;
		this.description = description;
		
	}

	public int getId() { return id; }
	
	public String getUuid() { return uuid; }
	
	public String getName() { return name; }

	public double getPrice() { return price; }
	
	public String getDescription() {  return description; }
	
	
	public void setUuid( String uuid) { this.uuid = uuid;  }
	
	public void setId( int id ) { this.id = id; }
	
	public void setName(String name){ this.name = name; }
	
	public void setPrice(double price){ this.price = price; }
	
	public void setDescription(String description ){ this.description = description; }
	
}
