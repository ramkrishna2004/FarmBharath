<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="admin.CropPrice, dao.DAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Crop Price</title>
</head>
<body>
    <h1>Update Crop Price</h1>
    <form action="UpdateCropPriceServlet" method="post">
        Crop Name: <input type="text" name="cropName" required><br>
        New Base Price: <input type="number" step="0.01" name="basePrice" required><br>
        <input type="submit" value="Update Price">
    </form>
</body>
</html>
