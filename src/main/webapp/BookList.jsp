<%@page import="bean.Book"%>
<%@page import="java.util.List"%>
<%@page import="bookDAO.BookDAO" errorPage="Error.jsp" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<%@include file="/WEB-INF/Css/BookList.css"%>
<%@include file="/WEB-INF/Css/normalize.css"%>
</style>
<title>BookList</title>
</head>
<body>



     <%
        BookDAO book = new BookDAO();
        List<Book> books = book.getBooks();
        request.setAttribute("Books", books);
     %>
     <div class="header">
             <h3>Book Management app</h3>
     </div>
     
     <div class="table-contents">
       <div class="container">
       <h2 class="h-head-2">List of users</h2>
     <hr>
       
       <form action="<%=request.getContextPath()%>/add" id="add"></form>
       <form action="/edit?" id="edit"></form>
       <form action="/delete" id="delete"></form>
        <button formaction="<%=request.getContextPath()%>/add" type="submit" form="add" class="add-button">Add</button>
         <table >
           <thead> 
             <tr>
               <th>ID</th>
               <th>Title</th>
               <th>Author</th>
               <th>Price</th>
               <th>Actions</th>
             </tr>
             
             <c:forEach var="i" items="${requestScope.Books}">
                 <tr>
                   <td>${i.book_id}</td>
                   <td>${i.title}</td>
                   <td>${i.author}</td>
                   <td>${i.price}</td>
                   <td>
                       <div class="buttons">
                         <button formaction="<%=request.getContextPath()%>/edit" name="id" value="<c:out value='${i.book_id}'/>" type="submit" form="edit">Edit</button>
                         <button formaction="<%=request.getContextPath()%>/delete" name="id" form="delete" value="<c:out value='${i.book_id}'/>">Delete</button>
                       </div>
                   </td>
                 </tr>
               
             </c:forEach>
           </thead> 
         </table>
         
       </div>  
     </div>
     
     <footer>
        &copy; 2023 All the rights reserved eagles
     </footer>
</body>
</html>