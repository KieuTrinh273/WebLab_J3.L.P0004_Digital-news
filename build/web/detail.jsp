<%-- 
    Document   : detail
    Created on : May 23, 2021, 11:44:00 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail</title>
        <link rel="stylesheet" href="css/common.css">

    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp" %>            
            <div class="content">
                <div class="left">
                    <c:if test = "${news==null}"> 
                        <div class="error">News not found!</div>
                    </c:if> 
                        
                    <c:if test = "${news!=null}"> 
                    <div class="tittle">
                        ${news.title}
                    </div>
                    <div class="image">
                        <img src="${imagePath}${news.image}">
                    </div>
                    <div class="newsContent">
                        ${news.newsContent}
                    </div>
                    <div class="signature">
                        <div class="comment"></div>
                        <div class="time"></div> By ${news.writer} | ${news.datePublished}
                    </div>
                    </c:if>
                </div>
                <%@include file="right.jsp" %>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
