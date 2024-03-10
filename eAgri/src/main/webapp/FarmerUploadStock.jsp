<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Farmer Upload Stock</title>
    <link
    href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css"
    rel="stylesheet"
  />
    <style>
        /* Reset default margin and padding */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

      
    @font-face {
      font-family: myFont;
      src: url(Chivo.ttf);
    }
    body {
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

        h1 {
            text-align: center;
            margin-top: 20px;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-top: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            margin-top: 5px;
        }

        input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            margin-top: 5px;
        }

        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            margin-top: 5px;
        }

        input[type="submit"] {
            background-color:rgb(154 189 31);;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 10px 20px;
            cursor: pointer;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <div class="container">
        <form action="UploadStockServlet" method="post">
            <h1>Farmer Upload Stock</h1>
            <label for="phone">Phone Number:</label>
            <input type="text" id="phone" name="phone" required class="p-7">
            
            <label for="cropName">Crop Name:</label>
            <input type="text" id="cropName" name="cropName" required class="p-7">
            
            <label for="cropQuantity">Crop Quantity (in quintal):</label>
            <input type="number" id="cropQuantity" name="cropQuantity" required class="p-7">
            
             <lable for="pincode" >Pincoide</lable>
             <input type="number" id="pincode" name="pincode" required class="p-7">
              <lable for="state">Status(sold or unsold)</lable>
             <input type="text" id="state" name="state" required class="p-7">
             
            
            <input type="submit" value="Upload Stock" class="hover:bg-gray-500 hover:text-black hover:border-black">
        </form>
    </div>
    
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
</body>
</html>