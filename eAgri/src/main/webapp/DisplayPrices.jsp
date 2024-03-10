<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="admin.CropPrice" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.DAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crop Prices</title>
    <!-- Include any necessary CSS styles -->
</head>
<body>
<%@ include file="ExporterHeader.jsp" %>
    <h1>Crop Prices</h1>
    
    <table>
        <tr>
            <th>Crop Name</th>
            <th>Base Price</th>
        </tr>
        <%
            DAO cropPriceDAO = new DAO();
            List<CropPrice> cropPrices = cropPriceDAO.getAllCropPrices();

            for (CropPrice cropPrice : cropPrices) {
        %>
        <tr>
            <td><%= cropPrice.getCropName() %></td>
            <td><%= cropPrice.getBasePrice() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
