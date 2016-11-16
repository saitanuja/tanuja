<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head><title>Category</title>
</head>
<body>

 <center> <c:url var="addAction" value="addCategory" ></c:url>

<form:form action="${addAction}" modelAttribute="category" id="btn-add">
   <h3>
                    <c:if test="$(category.cid==0}">
		       Add New Item
	            </c:if>
	            <c:if test="${!empty category.cid}">
	            <font color=#9B2335 >
	            THIS IS CATEGORY PAGE<br><br>
		      Update  Item  For CID: <c:out value="${category.cid}"/></font>
		     <%--  <form:hidden path="cid"/> --%>
	            </c:if>
         </h3>
	  <table>
	  
	  <tr>  <c:if test="${category.cid!=0}">
	   <td> Id:</td> <td><form:input  path="cid"/></td> 
	  </c:if>
	  <tr> <td> Name:</td> <td><form:input  path="cname"/></td> 
	    <tr> <td>Description:</td> <td><form:input path="cdescription"/> </td> 
	    
		
  
	    <tr> <td colspan="2">
    	        <c:if test="${category.cid==0}">
			      <input type="submit" value="Add" id="btn-add"> 
	         </c:if>
	         <c:if test="${product.cid!=0}">
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
       <th>CITY</th>
      </tr>
    </thead>
	  <c:forEach var="obj" items="${categoryList}">
		     <tr>
		     
		       <td> <c:out value="${obj.cid}"/> </td>
		      
		        <td> <c:out value="${obj.cname}"/> </td>
		        
				<td> <c:out value="${obj.cdescription}"/> </td>
				 
				
				 <td> <a href="deleteBycid/${obj.cid}">Delete </a> |
				     <a href="editBycid/${obj.cid}">Edit</a> 
				 </td>
		     </tr>
	      </c:forEach>
      </table>    
 </form:form>
 </center>


</body>
</html>
