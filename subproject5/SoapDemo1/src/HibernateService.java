

//https://github.com/RameshMF/jsp-servlet-hibernate-mysql-tutorial/tree/master/WebContent/WEB-INF/lib
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.metamodel.Metadata;
//import org.hibernate.metamodel.MetadataSources;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.criterion.CriteriaQuery;

public class HibernateService {

	//https://www.tutorialspoint.com/hibernate/hibernate_examples.htm
	
	private static SessionFactory factory; 
	
	public HibernateService(){
		
		 try {
			 
			 //https://www.geeksforgeeks.org/hibernate-example-using-jpa-and-mysql/
	         //factory = new Configuration().configure().buildSessionFactory();
	         
	         //factory = (SessionFactory) new Configuration().addResource("ProductModel1.hbm.xml").configure();
	         
	         Configuration configuration = new Configuration();
		     configuration.configure("hibernate.cfg.xml");
		     configuration.addAnnotatedClass(ProductModel1.class);
		 
		     // Create Session Factory
		     factory= configuration.buildSessionFactory();
		    
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		 		
	}

	
	public int addProduct( String paramName, double paramPrice, String paramDescription ){
		
		Session session = factory.openSession();
		Transaction tx = null;
		Integer productID = null;
	      
		UUID uuid = UUID.randomUUID();
		String productUuid = uuid.toString();
	      
	      try {
	         tx = session.beginTransaction();
	         ProductModel1 tempProduct = new ProductModel1(productUuid , paramName , paramPrice, paramDescription);
	         productID = (Integer) session.save(tempProduct); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      
	      return productID;
		
	}
	 
	 public ArrayList<ProductModel1> getAllProducts(){
	      
		   ArrayList<ProductModel1> hibernateData = new ArrayList<ProductModel1>();
		   
		   Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         
	         List productList = session.createQuery("FROM ProductModel1").getResultList();
	       
	         for (Iterator iterator = productList.iterator(); iterator.hasNext();){
	            ProductModel1 product = (ProductModel1) iterator.next(); 
	           
	           // product.getName()
	           // product.getUuid()
	           // product.getDescription()
	           // product.getPrice()
	            
	            hibernateData.add(product);
    
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	  
	   return hibernateData;
	   }
	
	
	
}
