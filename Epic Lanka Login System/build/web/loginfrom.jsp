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
    <section id="login">
  <div class="cont">
    <section id="view1">
    <div class="form sign-in">
      <h2>Sign In</h2>
      <form action="<%=request.getContextPath()%>/login" method="post">
      <label>
        <span>User Name</span>
        <input id="login_uname" class="input1" type="text" name="uname" required="">
        <span id="login_span_uname" class="lbl-error"></span>
      </label>
      <label>
        <span>Password</span>
        <input id="login_password" class="input1" type="password" name="password" required="">
      </label>
      <input type="submit" class="submit button1" value="Sign In" />
      </form>
      <p class="forgot-pass" id="new">Forgot Password ?</p>

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
          <span>What is your mother name</span>
          <input id="mother" class="input1" type="text" required="" name="f=mname" />
          
        </label>
        <label>
          <span>Role</span>
          <select id="role" required="" name="role">
            <option value="ADMIN">ADMIN</option>
            <option value="USER">USER</option>
          </select>
        </label>
<!--        <input type="submit" class="submit button1"value="Sign Up Now" />-->
            <button type="button" class="submit button1" id="signupuser">Sign Up Now</button>
<!--          </form>-->

      </div>
    </div>
    </section>
  </div>
    </section>
<section id="forgetPassword" style="position: relative">
    
    <div class="cont">
    <section id="view1">
    <div class="form sign-in">
      <h2>Forget Password</h2>
      
      <label>
        <span>User Name</span>
        <input id="fuser" class="input1" type="text" name="uname" required="">
        <span id="login_span_uname" class="lbl-error"></span>
      </label>
      <label>
        <span>Conatct Number</span>
        <input id="Fcontact" class="input1" type="text"  required="">
      </label>
      <label>
        <span>What is your Mother Name</span>
        <input id="FMname" class="input1" type="text"  required="">
      </label>
      <label>
        <span>New Password</span>
        <input id="Newpassword" class="input1" type="text"  required="">
      </label>
      
      <input type="submit" class="submit button1" id="change" value="Change Password" />
      
      <p class="forgot-pass" id="back">Go back</p>
      
      <div class="sub-cont">
      <div class="img">
          <div class="img-text m-up">
          <h2>New Password?</h2>
          <p>please don't forget password</p>
        </div>
<!--      <img src="images/undraw_Weather_notification_re_3pad.png" alt="password" width="500" height="600">-->
      </div>
      </div>
    </section>
  </div>
    
</section>

  <script src="assests/js/jquery-3.6.0.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="assests/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.0/sweetalert.min.js"></script>

  <script type="text/javascript" src="assests/js/script.js"></script>
  <script src="assests/js/validation.js"></script>
  <script src="assests/js/data.js"></script>

  
  <script>
      
      var v1=document.getElementById('login');
var v2=document.getElementById('forgetPassword');



views();

function views(){
    v1.style.display='block';
    v2.style.display='none';
}

$("#back").click(function (){
    window.location.href="loginfrom.jsp"
});

$("#new").click(function (){
    v1.style.display='none';
    v2.style.display='block';;
});

$("#change").click(function (){
    
        var userName = $("#fuser").val();
        var contact = $("#Fcontact").val();
        var mother = $("#FMname").val();
        var password = $("#Newpassword").val();
    $.ajax({
            url: '/Epic_Lanka_Login_System/rest',
            method: 'GET',
            async: true,
            data: {
 
                "mother":mother,
                "user_name":userName,
                "conatct":contact,                            
            },
            dataType: "json",
            success: function (response,textState, xhr) {
                if (response.operation==="success"){
            $.ajax({
            url: '/Epic_Lanka_Login_System/rest',
            type: 'PUT',
            async: true,
            contentType: "application/json",
            data:JSON.stringify( {
                
                "user_name":userName,
                "password":password,
            }),
            success: function (response,textState, xhr) {
                if (response.operation==="success"){
                    swal("User Password Reset Success", "Success");
                    clearRest();
    
                }else{
                    
                    swal("User Password Reset Fail", "Fail");
                }
            
            },

        });
                }else{
                    
                    swal("Data does not match", "Fail");
                }
            },

        });
});



$("#signupuser").click(function (){
    
    let size=$('#uname').val().length;
    let size1=$('#address').val().length;
    let size2=$('#emailaddress').val().length;
    let size3=$('#number').val().length;
    let size4=$('#password').val().length;
    if ((size==0) || (size1==0) || (size2==0) || (size3==0) || (size4==0)){
        swal("Field cannot be empty", "Error");
    }else {
        
        var userName = $("#uname").val();
        var address = $("#address").val();
        var email = $("#emailaddress").val();
        var contact = $("#number").val();
        var password = $("#password").val();
        var mother = $("#mother").val();
        var role = document.getElementById("role").value;
        // var form = $("#signinForm").serialize();
        
        console.log(mother);

        console.log("hello")
        $.ajax({
            url: '/Epic_Lanka_Login_System/newuser',
            method: 'GET',
            async: true,
            data: {
                
                "user_name":userName,
            },
            dataType: "json",
            success: function (response,textState, xhr) {
                if (response.operation==="success"){
                    swal("This User Name Already Taken", "Error");
                }else{
                    console.log(mother);
            $.ajax({
            url: '/Epic_Lanka_Login_System/newpassword',
            method: 'GET',
            async: true,
            data: {
                "password":password,
            },
            dataType: "json",
            success: function (response,textState, xhr) {
                if (response.operation==="success"){
                    swal("This Password CanNot Get", "Error");
                }else{
                    console.log("new password")
                    
                                     $.ajax({
            url: '/Epic_Lanka_Login_System/signup',
            method: 'POST',
            async: true,
            data: {
                
                
                "mother":mother,
                "user_name":userName,
                "address":address,
                "email_address":email,
                "conatct":contact,
                "password":password,
                "role":role,
                
                                        
            },
            dataType: "json",
            success: function (response,textState, xhr) {
                if (response.operation==="success"){
                    window.location.href="loginfrom.jsp"
                }else{
                    
                    swal("User Registerion Fail", "Fail");
                }
            },

        });
                    
                }
            },

        });
                }
            },

        });

    }
    });
    
    function clearRest(){
        $("#fuser").val("");
        $("#Fcontact").val("");
        $("#FMname").val("");
        $("#Newpassword").val("");
    }

  </script>
  
  
</body>
</html>
