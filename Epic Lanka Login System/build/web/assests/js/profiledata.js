

getDetailByemail();

function getDetailByemail() {
    let custEmail = $("#email1").val();

    $.ajax({
        method: 'GET',
        url: '/Epic_Lanka_Login_System/getdetails',
        async: true,
        data: {
                
                "custEmail":custEmail,
            },
        dataType: "json",
        success: function (response) {
             allData=response;
                    for (var i=0; i<response.length; i++) {
                        
                            console.log(response[i].user_name)
                            console.log(response[i].address)
                            console.log(response[i].password)
                            $("#username1").val(response[i].user_name);
                            $("#address1").val(response[i].address);
                            $("#number1").val(response[i].contact);
                            $("#password1").val(response[i].password);
                            $("#role1").val(response[i].role);
                            

                                    }
                                }
    });
}

$("#update").click(function (){
    
    let size=$('#username1').val().length;
    let size1=$('#address1').val().length;
    let size2=$('#email1').val().length;
    let size3=$('#number1').val().length;
    let size4=$('#password1').val().length;
    if ((size==0) || (size1==0) || (size2==0) || (size3==0) || (size4==0)){
        swal("Field cannot be empty", "Error");
    }else {
        
        var userName = $("#username1").val();
        var address = $("#address1").val();
        var email = $("#email1").val();
        var contact = $("#number1").val();
        var password = $("#password1").val();
        var role = $("#role1").val();
        // var form = $("#signinForm").serialize();

        console.log("hello")
        console.log(userName);
            $.ajax({
            url: '/Epic_Lanka_Login_System/update',
            method: 'PUT',
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
            success: function (response) {
                if (response.operation==="success"){
                    swal("User Update Success", "success");
                }else{
                    
                    swal("User Update Fail", "Fail");
                }
            },

        });

    }
    });