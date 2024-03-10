<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <script src="https://cdn.tailwindcss.com"></script>

    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">

<style>
    @font-face {
    font-family: myFont;
    src: url(Chivo.ttf);
  }
    body{
     background-image:url('Images/backgournd.png');
     background-repeat: no-repeat;
     background-attachment: fixed;
     background-size: 100%;
     backdrop-filter: blur(5px);
     background-position-y: 100%;
           font-family: myFont;


    }
    p {
      font-family: myFont;
    }
    .clr{
        background-color: rgb(154 193 30) ;
    }
</style>
</head>

<body>
<%@ include file="ExporterHeader.jsp"%>

     <div>
     <h1 class="text-3xl text-center ">Admin Panel</h1>
        <ul>
            <li class="my-20 w-screen text-center "><a href="UploadNews.jsp" class="clr  p-6 rounded-xl hover:bg-green-200 text-2xl">Upload News</a></li>
            <li class="my-20 w-screen text-center "><a href="AdminCropBasePrice.jsp" class="clr  p-6 rounded-xl hover:bg-green-200 text-2xl">Upload Crops Prices</a></li>
            <li class="my-20 w-screen text-center "><a href="DisplayPrices.jsp" class="clr  p-6 rounded-xl hover:bg-green-200 text-2xl">See latest Prices List</a></li>
        </ul>

             <form action="NewsRetrieveServlet" class="my-20 w-screen text-center">
            <button type="submit" class="btn  p-6 rounded-xl hover:bg-green-200 text-2xl" style="        background-color: rgb(154 193 30) ;
            ">News</button>
             </form>
        </div>
        <br>
        <br>
        <br>
        <br>
        
    
<%@ include file="Footer.jsp"%>
    
</body>
</html>