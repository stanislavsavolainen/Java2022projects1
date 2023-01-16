<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">

	.divStyle1{
		background-color : bisque;
	}


</style>

<script type="text/javascript">
        function soap(soapAction) {
        
            console.log("Button clicked");	
        
            var url = "";
            if(soapAction === "create") url = "http://localhost:8080/SoapDemo1/soap/createProduct";
            else if(soapAction === "viewall") url = "http://localhost:8080/SoapDemo1/soap/getAllProducts";
            else if(soapAction === "dbcreate") url = "http://localhost:8080/SoapDemo1/soap/createDBProduct";
            else if(soapAction === "dbviewall") url = "http://localhost:8080/SoapDemo1/soap/getAllDBProducts";
            
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.open('POST', url, true);
            //request.setRequestHeader('Accept', 'application/json');
            xmlhttp.setRequestHeader("Content-Type", "text/xml");
            	
        
        	   var input = 20;
                
                   var xml = "";            

                  xml += "<?xml version='1.0'?>                     \n"; 

                  xml += "<SOAP-ENV:Envelope>                       \n";            

                  xml += "  <SOAP-ENV:Body>                         \n";
 
                  if(soapAction === "create" || soapAction === "dbcreate") {
                	  
                	  let paramName = document.getElementById("productName").value;
                	  let paramPrice = document.getElementById("productPrice").value;
                	  let paramDescription = document.getElementById("productDescription").value;
                	  
                	  xml += "    <person>"; 
                	  xml += "    <name type='xsd:string'>"+paramName+"</name>";	
                	  xml += "    <price type='xsd:double'>"+paramPrice+"</price>";	
                	  xml += "    <description type='xsd:string'>"+paramDescription+"</description>";	
                      xml += "    </person>";
                	  
                  }
                  
                  else if(soapAction === "viewall" || soapAction === "dbviewall") {}
                  

                  xml += "  </SOAP-ENV:Body>                        \n";

                  xml += "</SOAP-ENV:Envelope>                      \n";
                
                  // build SOAP request
                  var sr = xml;	
        
        	xmlhttp.send(xml);
        
        	xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4) {
                    if (xmlhttp.status == 200) {
                        //alert(xmlhttp.responseText);
                        //document.getElementById("response").innerHTML = ""+xmlhttp.responseText;
                       
                        //document.getElementById("response").innerHTML = (new XMLSerializer()).serializeToString(xmlhttp.responseText);
                        
                        //var parser = new DOMParser(); 
                        //var xmlDoc = parser.parseFromString(xmlhttp.responseText, "text/xml");
                        //document.getElementById("response").textContent = new XMLSerializer().serializeToString(xmlDoc.documentElement);
                        
                        console.log(xmlhttp.responseText);
                        document.getElementById("response").textContent = xmlhttp.responseText;
                        
                        
                        //var xmlDoc = new DOMParser().parseFromString(xml, "application/xml");

                        //document.getElementById("doc").textContent = new XMLSerializer().serializeToString(xmlDoc);
                        //document.getElementById("documentElement").textContent = new XMLSerializer().serializeToString(xmlDoc.documentElement);
                        
                        // alert('done. use firebug/console to see network response');
                    }
                }
            }
              	        
        }    
</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br><button onclick="soap('viewall')"> view all products </button>
	 <br>
	 	<div class="divStyle1">
	 		<br>Product name : <input type="text" name="" id="productName">
	 		<br>Product price : <input type="text" name="" id="productPrice">
	 		<br>Product description : <input type="text" name="" id="productDescription">
	 		<br><button onclick="soap('create')"> create product </button>
	 	</div>
	 
	 <br><br>
	 Raw soap response : <div id="response" class="divStyle1"></div>
	 <br><br>
	 <br><button onclick="soap('dbviewall')"> view all products of database </button>
	 <br><button onclick="soap('dbcreate')"> create product in database </button>
</body>
</html>