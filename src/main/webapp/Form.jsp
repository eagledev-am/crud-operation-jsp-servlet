<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
<%@include file="/WEB-INF/Css/form.css"%>
<%@include file="/WEB-INF/Css/normalize.css"%>
</style>
<title>Form</title>
</head>
<body>

          
         <div class="header">
             <h3>Book Management app</h3>
         </div>
         
             <div class="form">
             <div class="container">
                <c:if test="${Book == null}">
                    <h1>Add New Book</h1>
                </c:if>  
                
                <c:if test="${Book != null}">
                    <h1>Edit Book</h1>
                </c:if>   
                
                    <form action="/insert">
                      <label for="book-id">Book Id</label>
                      <input type="text" name="book-id" id="book-id" value="<c:out value='${Book.book_id}'/>">
                      <label for="title" >Title</label>
                      <input type="text" name="title" id="title" value="<c:out value='${Book.title}'/>">
                      <label for="author" >Author</label>
                      <input type="text" name="author"  id="author" value="<c:out value='${Book.author}'/>">
                      <label for="price">price</label>
                      <input type="text" name="price" id="price" value="<c:out value='${Book.price}'/>">
                      
                      <c:if test="${Book == null}">
                         <button formaction="<%=request.getContextPath()%>/insert">Add</button>
                      </c:if> 
                      
                      <c:if test="${Book != null}">
                         <button formaction="<%=request.getContextPath()%>/update">save</button>
                      </c:if> 
                     
                    </form>
             </div>
             </div>
         
        <div class="footer">
           &copy; 2023 All the rights reserved eagles
        </div>
</body>
</html>