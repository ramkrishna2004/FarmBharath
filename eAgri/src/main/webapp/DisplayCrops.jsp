<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@page import="crop.Crop"%>
<!DOCTYPE html>
<html>
<head> 

</head>
<body>
    <%@ include file="ExporterHeader.jsp" %>

    <div class="container mx-auto p-6">

        <!-- Filter form -->
        
        <!-- Display filtered crops here -->
        <div class="container mx-auto p-6">
            <h1 style="background-color: rgb(154 189 31);" class="text-3xl font-semibold text-white bg-green-300 p-2 mb-6">Crop Data</h1>
            <form action="DisplayCropsServlet" method="GET">
                <label for="selectedCrop">Select Crop:</label>
                <select id="selectedCrop" name="selectedCrop">
                    <!-- Add options for crop selection based on your data -->
                    <option value="Mirchi">Mirchi</option>
                    <option value="cotton">Cotton</option>
                    <!-- Add more options as needed -->
                </select>
                
                <label for="pincode">Enter Pincode:</label>
                <input type="text" id="pincode" name="pincode" placeholder="Enter Pincode">
                
                <button type="submit">Apply Filters</button>
            </form>
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
            <% 
            // Use scriptlet code to iterate over the 'crops' list and display data
            @SuppressWarnings("unchecked") // Suppress the unchecked cast warning
            
            java.util.List<Crop> crops = (java.util.List<Crop>) request.getAttribute("crops");
        if (crops != null) {
            for (Crop crop : crops) {
                %> 
            <tbody>

                <tr>
                    <td class="border border-green-600 px-4 py-2"><%= crop.getPhone() %></td>
                    <td class="border border-green-600 px-4 py-2"><%= crop.getCropName() %></td>
                    <td class="border border-green-600 px-4 py-2"><%= crop.getQuantity() %></td>
                    <td class="border border-green-600 px-4 py-2"><%= crop.getPincode() %></td>
                    
                    <td class="border border-green-600 px-4 py-2"><%= crop.getState() %></td>
                </tr>
     
            </tbody>
            <%
            }
        }
        %>
        </table>
    </div>
    </div> 
    <%@ include file="Footer.jsp" %>
    
</body>

</html>