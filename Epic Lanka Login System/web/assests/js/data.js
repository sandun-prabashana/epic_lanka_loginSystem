

$("#signup").click(function (){
    
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
        var role = document.getElementById("role").value;
        // var form = $("#signinForm").serialize();

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