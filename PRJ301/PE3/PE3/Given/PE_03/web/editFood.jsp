<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Food</title>
</head>
<body>
    <h3>Edit Food</h3>
    <form action="UpdateFoodServlet" method="POST">
    
        <input type="hidden" name="action" value="updateFood">
        <input type="hidden" name="id" value="<%= request.getAttribute("foodId") %>">

        <label for="foodName">Food Name:</label>
        <input type="text" id="foodName" name="foodName" value="<%= request.getAttribute("foodName") %>" required><br>

        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="<%= request.getAttribute("description") %>" required><br>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" value="<%= request.getAttribute("price") %>" required><br>

        <label for="cookingTime">Cooking Time (minutes):</label>
        <input type="number" id="cookingTime" name="cookingTime" value="<%= request.getAttribute("cookingTime") %>" required><br>

        <!-- Automatically fill current time to createDate -->
        <input type="hidden" name="createDate" value="<%= new java.util.Date() %>">

        <!-- Default status value is true -->
        <input type="hidden" name="status" value="true">

        <input type="submit" value="Save Changes">
   </form>
</body>
</html>
