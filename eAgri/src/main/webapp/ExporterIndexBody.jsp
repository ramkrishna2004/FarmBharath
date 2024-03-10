<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="News.NewsRetrieveServlet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
      background-size: 100%;
      background-position-y: 100%;
      font-family: myFont;
    }
    p {
      font-family: myFont;
    }
button{
background-color:rgb(154 189 31);;
padding:10px;
font-size:19px;
border-radius: 4px;
border-style: solid;
}
h1{
text:bold;

}

</style>
</head>
<body>
	<div>
<a href="DisplayCrops.jsp">Crops Available</a>
</div>
<div>
<a href="NewsRetrieveServlet">News</a>
</div>


</body>
</html>