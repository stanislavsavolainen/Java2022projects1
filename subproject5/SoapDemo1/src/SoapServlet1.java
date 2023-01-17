import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns={"/soap/createProduct" , "/soap/getAllProducts"})
//@WebServlet("/soap")
//@WebServlet("/soap/:soapAction")
@WebServlet("/soap/*")
public class SoapServlet1 extends HttpServlet {

  /**
   *
   */
    private static final long serialVersionUID = 7409574594601068553L;

    ArrayList<ProductModel1> productData = new ArrayList<ProductModel1>();

    public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

        //allow cross-origin
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader(
          "Access-Control-Allow-Methods",
          "POST, GET, OPTIONS, PUT, DELETE, HEAD"
        );
        response.addHeader(
          "Access-Control-Allow-Headers",
          "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept"
        );
        response.addHeader("Access-Control-Max-Age", "1728000");

        //String soapAction = request.getParameter("SOAPAction");
        String soapAction = request.getPathInfo().substring(1);

        SoapRequestContent clientRequestContent = new SoapRequestContent();
        String requestContent = clientRequestContent.read(request);

        String xmlResponse = "";
        SoapXMLModel1 soapResponseSchema = new SoapXMLModel1();
        xmlResponse += soapResponseSchema.upBlock();

        if (soapAction.equals("createProduct")) {

            String rawData = soapResponseSchema.parseData(requestContent);
            System.out.println("raw data : " + rawData);
            String dataArr[] = rawData.split(":");

            UUID uuid = UUID.randomUUID();
            String productUuid = uuid.toString();
            String name = dataArr[0];
            double price = Double.parseDouble(dataArr[1]);
            String description = dataArr[2];

            ProductModel1 tempProduct = new ProductModel1(
              productUuid,
              name,
              price,
              description
           );
           productData.add(tempProduct);

           xmlResponse += soapResponseSchema.midleBlock(soapAction);

        } 

        else if (soapAction.equals("getAllProducts")) {

            xmlResponse += soapResponseSchema.midleBlockOfAllProducts(productData);

        }

        if (soapAction.equals("createDBProduct")) {

            String rawData = soapResponseSchema.parseData(requestContent);
            String dataArr[] = rawData.split(":");

            String name = dataArr[0];
            double price = Double.parseDouble(dataArr[1]);
            String description = dataArr[2];

            //ProductModel1 tempProduct = new ProductModel1(productUuid , name , price, description);

            HibernateService database = new HibernateService();
            database.addProduct(name, price, description);
    
        } 

        else if (soapAction.equals("getAllDBProducts")) {

             //xmlResponse += soapResponseSchema.midleBlockOfAllProducts(productData);

             ArrayList<ProductModel1> productsOfDatabase = new ArrayList<ProductModel1>();

             HibernateService database = new HibernateService();
             productsOfDatabase = database.getAllProducts();

             xmlResponse += soapResponseSchema.midleBlockOfAllProducts(productsOfDatabase);
    
        }

        xmlResponse += soapResponseSchema.downBlock();

        response.setContentType("application/xml");
        response.getWriter().println(xmlResponse);
  
    }

}
