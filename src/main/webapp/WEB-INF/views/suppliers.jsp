<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en-US">
<head><title>Supplier</title>
</head>
<body>
 <center> <c:url var="addAction" value="addSupplier" ></c:url>

<form:form action="${addAction}" modelAttribute="supplier" id="btn-add">
   <h3>
                    <c:if test="$(supplier.sid==0}">
		       Add New Item
	            </c:if>
	            <c:if test="${!empty supplier.sid}">
	            <font color=#9B2335>
	            THIS IS SUPPLIER PAGE<br><br>
		      Update Item For SID: <c:out value="${supplier.sid}"/></font>
		     <%--  <form:hidden path="sid"/> --%>
	            </c:if>
    </h3>     
	  <table>
	  
	  <tr>  <c:if test="${supplier.sid!=0}">
	   <td> Id:</td> <td><form:input  path="sid"/></td> 
	  </c:if>
	  <tr> <td> Name:</td> <td><form:input  path="sname"/></td> 
	    <tr> <td>Adress:</td> <td><form:input path="saddress"/> </td> 
	   
		
  
	    <tr> <td colspan="2">
    	        <c:if test="${supplier.sid==0}">
			      <input type="submit" value="Add" id="btn-add"> 
	         </c:if>
	         <c:if test="${supplier.sid!=0}">
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
        <th>ADDRESS</th>
        <th>CITY</th>
      </tr>
    </thead> 
    	      <c:forEach var="obj" items="${allData}">
		      <tr>
		                 <td> <c:out value="${obj.sid}"/> </td>
		                 <td> <c:out value="${obj.sname}"/> </td>
				         <td> <c:out value="${obj.saddress}"/> </td>
				
				
				 <td> <a href="deleteBySupplier/${obj.sid}">Delete </a> |
				     <a href="editBySupplier/${obj.sid}">Edit</a> 
				 </td>
		      </tr>
	      </c:forEach>
          </table> 
 </form:form>
  </center>


</body>
</html>
