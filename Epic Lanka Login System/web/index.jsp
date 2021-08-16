<%-- 
    Document   : index
    Created on : Aug 16, 2021, 9:26:24 AM
    Author     : MCTech
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login System</title>
        <link rel="stylesheet" href="assests/css/loginstyle.css">
    </head>
    <body class="body">
        
        <div style="display: flex;flex-direction: column">
            <h1 style="font-size: 48px;color: #dc9044">welcome Epic Lanka <br> <span style="color: #86bec0;font-size: 32px">login system</span> </h1>
            <button type="button" class="btnSignin1" id="goHome">Go Home</button>
        </div>
        
        
        
            <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script>
        $("#goHome").click(function (){
            window.location.href="loginfrom.jsp";
        })
    </script>
        
    </body>
</html>
