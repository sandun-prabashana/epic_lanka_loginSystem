
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800&display=swap" rel="stylesheet">
        <link href="assests/css/loginstyle.css" rel="stylesheet" type="text/css">
        <title>Success</title>
    </head>
    <section class="bgimg">
      <div class="middle">
        <h1>Hello Aliens,</h1>
        <h1 id="user"><%= request.getParameter("email") %></h1>
      </div>
    </section>
</html>
