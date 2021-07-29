<%-- 
    Document   : search
    Created on : May 26, 2021, 9:29:32 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Search</title>
        <link href="css/common.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp" %>

            <div class="content">
                <div class="left">
                    <c:if test="${newsOnPage.size() ==0}">
                        <div class="error">News not found!</div>
                    </c:if>

                    <c:if test="${newsOnPage.size() !=0}">
                        <c:forEach items="${newsOnPage}" var="news">
                            <div class="tittle">
                                <a href="detail?id=${news.id}"> ${news.title}</a>
                            </div>

                            <div class="perNews">
                                <img src="${imagePath}${news.image}">

                                <p>
                                    ${news.description}
                                </p>
                            </div>


                            <br>
                        </c:forEach>

                        <div class="page">
                            <c:forEach begin="1" end="${numberOfPages}" var="i">
                                <a class="${i==page?"clicked":""}" 
                                   href="search?page=${i}&txtSearch=${txtSearch}">${i}</a>
                            </c:forEach>
                        </div>
                    </c:if>
                </div>
                <%@include file="right.jsp" %>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
