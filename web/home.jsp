<%-- 
    Document   : home
    Created on : May 23, 2021, 11:49:31 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="css/common.css">
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp" %>

            <div class="content">
                <!--display the most recent news (title, image, content,...)-->
                <div class="left">
                    <div class="tittle">
                        ${top1.title}
                    </div>

                    <div class="image">
                        <img src="${imagePath}${top1.image}">
                    </div>
                    <div class="newsContent">
                        ${top1.newsContent}
                    </div>

                    <div class="signature">
                        <div class="comment"></div>
                        <div class="time"></div> 
                        By ${top1.writer} | ${top1.datePublished}
                    </div>
                    
                </div>
                        <%@include file="right.jsp" %>
                
            </div>

            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
