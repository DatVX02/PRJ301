<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Book</title>
</head>
<body>
    <h3>Edit Book</h3>
    <form action="UpdateBookServlet" method="POST">
    
        <input type="hidden" name="action" value="updateBook">
        <input type="hidden" name="id" value="<%= request.getAttribute("bookId") %>">

        <label for="bookName">Book Name:</label>
        <input type="text" id="bookName" name="bookName" value="<%= request.getAttribute("bookName") %>" required><br>

        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="<%= request.getAttribute("description") %>" required><br>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" value="<%= request.getAttribute("price") %>" required><br>


        <!-- Default status value is true -->
        <input type="hidden" name="status" value="true">

        <input type="submit" value="Save Changes">
   </form>
</body>
</html>
