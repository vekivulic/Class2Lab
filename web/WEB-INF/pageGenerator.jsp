<%-- 
    Document   : pageGenerator
    Created on : Sep 5, 2017, 6:06:35 PM
    Author     : vekivulic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Generator 2 (Using JSP)</title>
        <title>Sample Page Generator</title>
            <link rel="stylesheet" type="text/css" href="indexStyleSheet.css">
    </head>
    <body>
        <h1>
            Page Generator 2 (Using a JSP) at <%=request.getContextPath()%> 
        </h1>
        <table border="5">
            <%
                int NUM_ROWS_TABLE = 12;
                int NUM_COLUMNS_TABLE = 5;
            %>
            <% 
                for(int j =1 ; j < NUM_COLUMNS_TABLE+1; j++){ 
                
            %>
                <th> 
                    heading <%=j%>
                </th>
            <% 
                } 
            %>
            <%        
                for(int i = 1 ; i < NUM_ROWS_TABLE+1 ; i++){   
            %>             
                <tr>
            <%        
                for(int j =1 ; j < NUM_COLUMNS_TABLE+1 ; j++){
            %>
                <td> 
                    row <%=i%> cell <%=j%>
                </td>
            <%    
                }
            %>
                </tr>
            <%
                }
            %>    
            
        </table>
        <br>
        <a href="index.jsp">
            Back to Home
        </a>
        <br>
        <br>
        <footer> 
            Distributed Java
        </footer>
    </body>
</html>
