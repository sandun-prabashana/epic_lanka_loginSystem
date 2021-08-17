<%-- 
    Document   : loginfrom
    Created on : Aug 11, 2021, 9:44:09 AM
    Author     : MCTech
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800&display=swap" rel="stylesheet">
        <link href="assests/css/loginstyle.css" rel="stylesheet" type="text/css">
        <title>Login Form</title>
    </head>
<body>
  <div class="cont">
    <section id="view1">
    <div class="form sign-in">
      <h2>Sign In</h2>
      <form action="<%=request.getContextPath()%>/login" method="post">
      <label>
        <span>Email Address</span>
        <input id="login_uname" class="input1" type="text" name="email" required="">
        <span id="login_span_uname" class="lbl-error"></span>
      </label>
      <label>
        <span>Password</span>
        <input id="login_password" class="input1" type="password" name="password" required="">
      </label>
      <input type="submit" class="submit button1" value="Sign In" />
      </form>
      <p class="forgot-pass">Forgot Password ?</p>

      <div class="social-media">
        <ul>
            <li><img src="assests/img/facebook.png"></li>
          <li><img src="assests/img//twitter.png"></li>
          <li><img src="assests/img//linkedin.png"></li>
          <li><img src="assests/img/instagram.png"></li>
        </ul>
      </div>
    </div>

    <div class="sub-cont">
      <div class="img">
        <div class="img-text m-up">
          <h2>New here?</h2>
          <p>Sign up and discover great amount of new opportunities!</p>
        </div>
        <div class="img-text m-in">
          <h2>One of us?</h2>
          <p>If you already has an account, just sign in. We've missed you!</p>
        </div>
        <div class="img-btn">
          <span class="m-up">Sign Up</span>
          <span class="m-in">Sign In</span>
        </div>
      </div>
        
      <div class="form sign-up">
        <h2>Sign Up</h2>
<!--        <form action="<%= request.getContextPath() %>/register" method="post">-->
        

        <label>
          <span>User Name</span>
          <input id="uname" class="input1" type="text" required="" name="user_name"/>
          <span id="spanuname" class="lbl-error"></span>
        </label>
        <label>
          <span>Address</span>
          <input id="address" class="input1" type="text" required="" name="address"/>
          <span id="spanfname" class="lbl-error"></span>
        </label>
        <label>
          <span>Email Address</span>
          <input id="emailaddress" class="input1" type="text" required="" name="email_address"/>
          <span id="spannumber" class="lbl-error"></span>
        </label>
        <label>
          <span>Contact</span>
          <input id="number" class="input1" type="text" required="" name="conatct" />
          <span id="spanemail" class="lbl-error"></span>
        </label>
        <label>
          <span>Password</span>
          <input id="password" class="input1" type="password" required="" name="password" />
        </label>
        <label>
          <span>Role</span>
          <select id="role" required="" name="role">
            <option value="ADMIN">ADMIN</option>
            <option value="USER">USER</option>
          </select>
        </label>
<!--        <input type="submit" class="submit button1"value="Sign Up Now" />-->
            <button type="button" class="submit button1" id="signup">Sign Up Now</button>
<!--          </form>-->

      </div>
    </div>
    </section>
  </div>

  <script src="assests/js/jquery-3.6.0.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="assests/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.0/sweetalert.min.js"></script>

  <script type="text/javascript" src="assests/js/script.js"></script>
  <script src="assests/js/validation.js"></script>
  <script src="assests/js/data.js"></script>

  
</body>
</html>
