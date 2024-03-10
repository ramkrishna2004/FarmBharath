<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload News</title>
    <style>
        /* Add your CSS styles here */
    </style>
</head>
<body>
    <h1>Upload News</h1>
    <div class="container">
        <% String errorMsg = request.getParameter("msg"); %>
        <% if (errorMsg != null && errorMsg.equals("ImageMissing")) { %>
            <p style="color: red;">Error: Please select an image to upload.</p>
        <% } %>
        <form action="UploadNewsServlet" method="post" enctype="multipart/form-data">
        
        	<label for="id">News Id</label>
        	            <input type="number" id="id" name="id" required>
        	
            <label for="title">శీర్షిక:</label>
            <input type="text" id="title" name="title" required>
            
            <label for="content">Content:</label>
            <textarea id="content" name="content" rows="5" required></textarea>
            
            <label for="author">Author:</label>
            <input type="text" id="author" name="author">
            
            <label for="date_published">Date Published:</label>
            <input type="date" id="date_published" name="date_published">
            
            <label for="category">Category:</label>
            <input type="text" id="category" name="category">
            
            <label for="image">Image:</label>
            <input type="file" id="image" name="image">
             
            <label for="source_url">Source URL:</label>
            <input type="url" id="source_url" name="source_url">
            
            <input type="submit" value="Upload News">
        </form>
    </div>
</body>
</html>
