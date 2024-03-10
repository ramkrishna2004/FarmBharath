
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="News.NewsItem" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>News Display</title>
    <link
    href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css"
    rel="stylesheet"
  />
  <style>
    @font-face {
      font-family: myFont;
      src: url(Chivo.ttf);
    }
    body {
      background-image: url("Images/backgournd.png");
      background-repeat: no-repeat;
      background-attachment: fixed;
	  background-size:100%;
	  
     backdrop-filter: blur(5px);
      background-position-y: 100%;
      font-family: myFont;
    }
    p {
      font-family: myFont;
    }
	#newsImage{ 
    height:430px;
    width:3000px;
    
	}
  </style>
</head>

<body>

<%@ include file="ExporterHeader.jsp" %>


    <div class="w-full h-full p-10 rounded-2xl ">
    <h1 style="font-size: 30px">News</h1>
    <%
            // Assuming you have a list of NewsItem objects named "newsList" in your request attribute
            java.util.List<NewsItem> newsList = (java.util.List<NewsItem>)request.getAttribute("newsList");
    
            if (newsList != null) {
                for (NewsItem newsItem : newsList) {
                	String datePublishedStr = newsItem.getDatePublished();
                	    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
                	java.util.Date datePublished = dateFormat.parse(datePublishedStr);
                	
        %>
            <div class="bg-white justify-between p-20 rounded-2xl px-36">
              <div class="flex">
                <div class="img rounded">
                    <img src="data:image/jpeg;base64,<%= newsItem.getImageBase64() %>" alt="News Image" class=" rounded-3xl ml-20" id="newsImage"/>
                </div>
                <div class="txt mx-10 px-36">
                  <h1 class="underline text-3xl text-center"><%= newsItem.getTitle() %></h1>
                  <p class="text-xl text-center m-5">                 
                    <p><%= newsItem.getContent() %></p><br /><br />
                    <p>Author: <%= newsItem.getAuthor() %></p><br /><br />
                    <p>Date Published:<%= dateFormat.format(datePublished) %></p><br /><br />
                    <p>Category: <%= newsItem.getCategory() %></p>
                    <p>Source URL: <a href="<%= newsItem.getSourceUrl() %>" target="_blank"><%= newsItem.getSourceUrl() %></a></p>
                
                </div>
                
                
     </div>
     </div>
     <%
                }
            }
        %>
     </div>
     <%@ include file="Footer.jsp" %>
</body>
</html>

