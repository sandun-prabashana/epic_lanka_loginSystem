

getDetailByemail();

function getDetailByemail() {

    let name = $("#username1").val();

    $.ajax({
        method: 'GET',
        url: '/Epic_Lanka_Login_System/getdetails',
        async: true,
        data: {
                
                "name":name,
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
                            $("#email1").val(response[i].email_address)
                            $("#conatct1").val(response[i].contact);
                            $("#password1").val(response[i].password);
                            $("#role1").val(response[i].role);
                            
                            console.log(response[i].image);
                                 $(imgshow).attr("src", "images/"+response[i].image);


                                    }
                                }
    });
}

$("#update").click(function (){
    
    let size=$('#username1').val().length;
    let size1=$('#address1').val().length;
    let size2=$('#email1').val().length;
    let size3=$('#conatct1').val().length;
    let size4=$('#password1').val().length;
    if ((size==0) || (size1==0) || (size2==0) || (size3==0) || (size4==0)){
        swal("Field cannot be empty", "Error");
    }else {
        
        var userName = $("#username1").val();
        var address = $("#address1").val();
        var email = $("#email1").val();
        var contact = $("#conatct1").val();
        var password = $("#password1").val();
        var role = $("#role1").val();

        console.log("hello")
        console.log(contact);
            $.ajax({
            url: '/Epic_Lanka_Login_System/update',
            type: 'PUT',
            async: true,
            contentType: "application/json",
            data:JSON.stringify( {
                "user_name":userName,
                "address":address,
                "email_address":email,
                "contact":contact,
                "password":password,
                "role":role,
            }),
            success: function (response,textState, xhr) {
                if (response.operation==="success"){
                    swal("User Update Success", "Success");
                    getDetailByemail();
                }else{
                    
                    swal("User Update Fail", "Fail");
                }
            
            },

        });

    }
    });
    
    
//    $("#uploadImage").click(function (){
//
//
//        var filename = $('#imgload').val();
//        if (filename.substring(3,11) == 'fakepath') {
//            filename = filename.substring(12);
//        } // Remove c:\fake at beginning from localhost chrome
//        console.log(filename);
//
//        var email = $("#email1").val();
////        var image = $("#imgload").val();
////            var image = document.getElementById("imgload").files[0];
//
//        $.ajax({
//            url: '/Epic_Lanka_Login_System/updateImage',
//            type: 'PUT',
//            async: true,
//            contentType: "application/json",
//            data:JSON.stringify( {
//                "email_address":email,
//                "image":filename,
//            }),
//            success: function (response,textState, xhr) {
//                if (response.operation==="success"){
//                    swal("User Image Update Success", "Success");
//                    getDetailByemail();
//                }else{
//                    
//                    swal("User Image Update Fail", "Fail");
//                }
//            
//            },
//
//        });
//    });    
//                