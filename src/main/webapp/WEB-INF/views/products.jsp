<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head><title>Product</title>
</head>
<body>
  <center><c:url var="addAction" value="addProduct" ></c:url>

<form:form action="${addAction}" modelAttribute="product" id="btn-add">
   <h3>
                    <c:if test="$(product.id==0}">
		       Add New Item
	            </c:if>
	            <c:if test="${!empty product.id}">
	            <font color=#9B2335>
	            THIS IS PRODUCT PAGE<br><br>
		      Update Item For PID: <c:out value="${product.id}"/></font>
		     <%--  <form:hidden path="id"/> --%>
	            </c:if>
         </h3>
	  <table>
	  
	  <tr>  <c:if test="${product.id!=0}">
	   <td> Id:</td> <td><form:input  path="id"/></td> 
	  </c:if>
	  <tr> <td> Name:</td> <td><form:input  path="name"/></td> 
	    <tr> <td>Description:</td> <td><form:input path="description"/> </td> 
	    <tr> <td>Price: </td> <td><form:input path="price"/></td> 
		
  
	    <tr> <td colspan="2">
    	        <c:if test="${product.id==0}">
			      <input type="submit" value="Add" id="btn-add"> 
	         </c:if>
	         <c:if test="${product.id!=0}">
			      <input type="submit" value="Update" id="btn-update"> 
	         </c:if>
		</td> 
		<tr> <td colspan="2" class="success-msg">
		   <c:out value="${msg}"/>
		</td> 
	  </table>
	  
		<table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>DESCRIPTION</th>
        <th>PRICE</th>
       <th>CITY</th>
      </tr>
    </thead> 
		
    	      <c:forEach var="obj" items="${allData}">
		      <tr>
		                 <td> <c:out value="${obj.id}"/> </td>
		                 <td> <c:out value="${obj.name}"/> </td>
				 <td> <c:out value="${obj.description}"/> </td>
				 <td> <c:out value="${obj.price}"/> </td>
				
				 <td> <a href="deleteById/${obj.id}">Delete </a> |
				     <a href="editById/${obj.id}">Edit</a> 
				 </td>
		      </tr>
	      </c:forEach>
          </table> 
 </form:form>
  </center>


</body>
</html>
