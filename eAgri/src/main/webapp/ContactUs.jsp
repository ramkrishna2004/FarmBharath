<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Crops</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">
</head>
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
  </style>
<body class="">
     <%@ include file="Header.jsp" %>


    <div class="container mx-auto p-6">
        <h1 style="background-color: rgb(154 189 31);" class="text-3xl font-semibold text-white bg-green-300 p-2 mb-6">Crop Data</h1>
        <table class="border-collapse border border-green-800 bg-white shadow-lg rounded-lg">
            <thead>
                <tr>
                    <th class="border border-green-600 px-4 py-2">Phone</th>
                    <th class="border border-green-600 px-4 py-2">Crop Name</th>
                    <th class="border border-green-600 px-4 py-2">Quantity</th>
                    
                    <th class="border border-green-600 px-4 py-2">Pincode</th>
                    <th class="border border-green-600 px-4 py-2">Status</th>
                </tr>
            </thead>
   </table>
    </div>
         <%@ include file="Footer.jsp" %>
    
</body>
</html>