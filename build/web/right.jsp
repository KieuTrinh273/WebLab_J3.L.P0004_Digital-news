<%-- 
    Document   : right
    Created on : May 23, 2021, 11:41:39 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>right</title>
        <link rel="stylesheet" href="css/right.css"/>
    </head>
    <body>
        <div class="right">
            <div class="newsRecent">
                <div class="newsTitle">${top1.title}</div>
                <div class="description">${top1.description}</div>
            </div>

            <div>
                <div class="otherTitle">Search</div>
                <form action="search">
                    <input class="searchBox" type="text" name="txtSearch"  required size="16">
                    <input class="searchButton" type="submit" value="Go">
                </form>
            </div>

            <div class="newsRecent">
                <div class="newsTitle">Last Articles</div>
                <c:forEach items="${top5}" var="listNews">
                    <div class="top5Recent">
                        <a href="detail?id=${listNews.id}">${listNews.title}</a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
