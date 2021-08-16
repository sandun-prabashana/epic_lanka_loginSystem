
////$('#btnSignup').click(function () {
////    let size=$('#uname').val().length;
////    let size1=$('#fname').val().length;
////    let size2=$('#number').val().length;
////    let size3=$('#email').val().length;
////    let size4=$('#password').val().length;
////    if ((size==0) || (size1==0) || (size2==0) || (size3==0) || (size4==0)){
////        swal("Field cannot be empty", "Error");
////    }else {
////        let userName = $('#uname').val();
////        let name = $('#fname').val();
////        let mobileNumber = $('#number').val();
////        let email = $('#email').val();
////        let password = $('#password').val();
////        let state = document.getElementById("role").value;
////        console.log("hi");
////        console.log(state);
////        $.ajax({
////            method: "POST",
////            contentType: "application/json",
////            url: "http://localhost:8079/api/v1/user/save",
////            crossDomain: true,
////            crossOrigin: true,
////            data: JSON.stringify({
////                'userName': userName,
////                'name': name,
////                'mobileNumber': mobileNumber,
////                'email': email,
////                'password': password,
////                'state': state
////            }),
////            success: function (resp) {
////                swal("User Added success", "success");
////                clear()
////                if (resp.code == 200) {
////                    swal("User Added success", "success");
////                    clear()
////                }
////
////            }
////        })
////    }
////});
////
////$('#btnLogin').on('click', function () {
////    let size=$('#login_uname').val().length;
////    let size1=$('#login_password').val().length;
////    if ((size==0) || (size1==0)){
////        swal("Field cannot be empty", "Error");
////    }else {
////    let userName = $('#login_uname').val();
////    let password = $('#login_password').val();
////
////    $.ajax({
////        method: "GET",
////        url: "http://localhost:8079/api/v1/user/userName/"+userName,
////        async: true,
////        success:function (resp) {
////            console.log(resp.password);
////            if (resp.password == password) {
////                if (resp.state == "USER"){
////                    console.log("user");
////                    view1();
////                    document.getElementById("user").innerHTML = resp.name;
////                }else {
////                    console.log("admin");
////                    view2();
////                    document.getElementById("admin").innerHTML = resp.name;
////                }
////            }else {
////                    swal("Login First ", "Error");
////            }
////        }
////
////    });
////    }
////});
//
//function clear() {
//    $('#uname').val("");
//    $('#fname').val("");
//    $('#number').val("");
//    $('#email').val('');
//    $('#password').val('');
//}

$("#signup").click(function (){
    let size=$('#id').val().length;
    let size1=$('#uname').val().length;
    let size2=$('#emailaddress').val().length;
    let size3=$('#number').val().length;
    let size4=$('#password').val().length;
    if ((size==0) || (size1==0) || (size2==0) || (size3==0) || (size4==0)){
        swal("Field cannot be empty", "Error");
    }else {
        var id = $("#id").val();
        var userName = $("#uname").val();
        var email = $("#emailaddress").val();
        var contact = $("#number").val();
        var password = $("#password").val();
        var role = document.getElementById("role").value;
        // var form = $("#signinForm").serialize();

        $.ajax({
            url: '/Epic_Lanka_Login_System/signup',
            method: 'POST',
            async: true,
            data: {
                "id":id,
                "user_name":userName,
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
                    
                    swal("User Already Registered", "Fail");
                }
            },

        });
    }
    });