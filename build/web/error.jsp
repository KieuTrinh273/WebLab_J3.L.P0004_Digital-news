<%-- 
    Document   : error
    Created on : Jun 6, 2021, 8:27:08 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
        <link rel="stylesheet" href="css/common.css">
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp" %>

            <div class="content">
                <div class="left">
                    <h3 class="error">${err}</h3>
                </div>
            </div>

            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>

