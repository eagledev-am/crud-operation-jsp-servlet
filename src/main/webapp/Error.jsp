<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
<style type="text/css">
   h1 , h3{
     background-color: #525D76;
     color: white;
   }
   
   h3{
     font-weight: 12px;
   }
}
</style>
</head>
<body>
        <h1>Error</h1> <hr>
        <h3>message</h3>
        <p><%=exception.getMessage()%></p>
</body>
</html>