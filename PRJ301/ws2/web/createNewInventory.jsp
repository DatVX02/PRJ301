<%-- 
    Document   : createNewInventory
    Created on : Apr 24, 2023, 4:33:08 PM
    Author     : lnhtr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Inventory</title>
    </head>
    <body>
        <form action="createInventoryAction" method="POST">
            ID <input type="text" name="txtID" value="" />
            Name <input type="text" name="txtName" value="" />
            Quantity <input type="text" name="txtQuantity" value="" />
            <input type="submit" value="Submit" />
        </form>

    </body>
</html>
