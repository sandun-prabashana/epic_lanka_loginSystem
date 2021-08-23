
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800&display=swap" rel="stylesheet">
        <link href="assests/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">        
        <link href="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/css/dropify.css" rel="stylesheet">
        <title>Admin</title>
    </head>
     <body>
    <div class="container">
        <div class="main-body" style="text-align: center">
    
           <nav aria-label="breadcrumb" class="main-breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="loginfrom.jsp">Home</a></li>
              <li class="breadcrumb-item active">Admin Profile</li>
              <li class="breadcrumb-item active"><a href="manageUser.jsp">Manage Users</a></li>
            </ol>
          </nav>
    
          <div class="row gutters-sm">
            
              
              <div class="container col-md-14">
  <table class="table" id="tbl">
    <thead>
      <tr>
        <th>Edit</th>
        <th>ID</th>
        <th>Image</th>
        <th>User Name</th>
        <th>Address</th>
        <th>Email Address</th>
        <th>Conatct</th>
        <th>Password</th>
        <th>Status</th>
        <th>delete</th>
        <th>Activate</th>
        <th>Deactivate</th>
        
      </tr>
    </thead>
    <tbody id="tblUser">
       <tr>
        <td><button type='button' onclick='productDisplay(this);' class='btn btn-default click'>
        <span class='glyphicon glyphicon-edit' /></button></td>
        <td>1</td>
        <td>sandun</td>
        <td>Colombo</td>
        <td>s@gmail.com</td>
        <td>077-0297604</td>
        <td><button type='button' onclick='productDelete(this);' class='btn btn-default'>
        <span class='glyphicon glyphicon-remove' /></td>
      </tr> 
    </tbody>
<!--    <tbody>
      <tr>
        <td>Default</td>
        <td>Defaultson</td>
        <td>def@somemail.com</td>
      </tr>      
      <tr class="success">
        <td>Success</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr class="danger">
        <td>Danger</td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr>
      <tr class="info">
        <td>Info</td>
        <td>Dooley</td>
        <td>july@example.com</td>
      </tr>
      <tr class="warning">
        <td>Warning</td>
        <td>Refs</td>
        <td>bo@example.com</td>
      </tr>
      <tr class="active">
        <td>Active</td>
        <td>Activeson</td>
        <td>act@example.com</td>
      </tr>
    </tbody>-->
  </table>
</div>
              
              
              
              <div class="col-md-8 container">
              <div class="card mb-3">
                <div class="card-body">
                   <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">User ID</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <input type="text" id="id1" >
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">User Name</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <input type="text" id="username1" name="user_name">
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Address</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <input type="text" id="address1" >
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Email</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <input type="email" id="email1" disabled >
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Mobile</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <input type="text" id="conatct1" >
                    </div>
                  </div>
             
                  <hr>
                  
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Password</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <input type="text" id="password1" >
                    </div>
                  </div>
                  <hr> 
                  <div class="row">
                    <div class="col-sm-12">
                        <button class="btn btn-outline-primary" id="updateUser">edit</button>
                    </div>
                  </div>
                </div>
              </div>

            </div>
              
              
          </div>

        </div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="assests/js/jquery-3.6.0.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="assests/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.0/sweetalert.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/js/dropify.min.js"></script>
<script src="assests/js/profiledata.js"></script>

<script type="text/javascript">
    
    loadAllData();
    
  $('document').ready(function () {
    $("#imgload").change(function () {
      if (this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
          $('#imgshow').attr('src', e.target.result);
        }
        reader.readAsDataURL(this.files[0]);
      }
    });
  });
  
  function productDisplay(){
         var table = document.getElementById('tbl');

    for(var i = 0; i < table.rows.length; i++)
    {
        table.rows[i].onclick = function()
        {
            document.getElementById("id1").value = this.cells[1].innerHTML;
            document.getElementById("username1").value = this.cells[3].innerHTML;
            document.getElementById("address1").value = this.cells[4].innerHTML;
            document.getElementById("email1").value = this.cells[5].innerHTML;
            document.getElementById("conatct1").value = this.cells[6].innerHTML;
            document.getElementById("password1").value = this.cells[7].innerHTML;
        };
    }
  }
  
  
$('#updateUser').click(function () {
    
        var id = $("#id1").val();
        var userName = $("#username1").val();
        var address = $("#address1").val();
        var email = $("#email1").val();
        var contact = $("#conatct1").val();
        var password = $("#password1").val();


        console.log("hello")
        console.log(contact);
            $.ajax({
            url: '/Epic_Lanka_Login_System/updateById',
            type: 'PUT',
            async: true,
            contentType: "application/json",
            data:JSON.stringify( {
                "id":id,
                "user_name":userName,
                "address":address,
                "email_address":email,
                "contact":contact,
                "password":password,
            }),
            success: function (response,textState, xhr) {
                if (response.operation==="success"){
                    swal("User Update Success", "Success");
                    loadAllData();
                    clear();
                }else{
                    
                    swal("User Update Fail", "Fail");
                }
            
            },

        });
});


    function loadAllData(){
        $("#tblUser").empty();
        $.ajax({
            url: '/Epic_Lanka_Login_System/getAllUsers',
            method: 'GET',
            async: true,
            dataType: "json",
            contentType:"application/json",
            success: function (response) {
                for (var i=0; i<response.length; i++) {
                    
                    var url = 'images/'+response[i].image;
                    console.log(url);
                    
                    var row = $('<tr><td>' + "<button type='button' onclick='productDisplay();' class='btn btn-default'>" +
        "<span class='glyphicon glyphicon-edit' />" +
        "</button>"+ '</td><td>' + response[i].id + '</td><td id="img1" >' + "<img style="+"width:100px;"+" src="+url+" />" +'</td><td>' + response[i].user_name + '</td><td>' + response[i].address + '</td><td>' + response[i].email_address + '</td><td>' + response[i].contact + '</td><td>' + response[i].password + '</td><td>'+response[i].status + '</td><td>' + "<button type='button' onclick='productDelete();' class='btn btn-default'>" +
        "<span class='glyphicon glyphicon-trash' />" +
        "</button>" + '</td><td>'+ "<button type='button' onclick='userActivate();' class='btn btn-default'>" +
        "<span class='glyphicon glyphicon-ok' />" +
        "</button>" + '</td><td>'+ "<button type='button' onclick='userDeActivate();' class='btn btn-default'>" +
        "<span class='glyphicon glyphicon-remove' />" +
        "</button>"  + '</td>></tr>');
                    $("#tblUser").append(row);
                    
                    
                }
            }
            

        });
    }
    
    
    function userActivate(){
        var tbl1 = document.getElementById('tbl');
        
        for(var i = 0; i < tbl1.rows.length; i++){
            tbl1.rows[i].onclick = function(){
                var id= this.cells[1].innerHTML;
                var state= "ACTIVE ";

                
                
                
             
            $.ajax({
            url: '/Epic_Lanka_Login_System/userActivate',
            type: 'PUT',
            async: true,
            contentType: "application/json",
            data:JSON.stringify( {
                "id":id,
                "state":state,
            }),
            success: function (response,textState, xhr) {
                if (response.operation==="success"){
                    swal("User Activated", "Success");
                    loadAllData();
                    clear();
                }else{
                    
                    swal("User Activated Fail", "Fail");
                }
            
            },

        });
                
                
                
            }
        }
    }
    
        function userDeActivate(){
        var tbl1 = document.getElementById('tbl');
        
        for(var i = 0; i < tbl1.rows.length; i++){
            tbl1.rows[i].onclick = function(){
                var id= this.cells[1].innerHTML;
                var state= "DEACTIVATE";
                
                
                
                            $.ajax({
            url: '/Epic_Lanka_Login_System/userActivate',
            type: 'PUT',
            async: true,
            contentType: "application/json",
            data:JSON.stringify( {
                "id":id,
                "state":state,
            }),
            success: function (response,textState, xhr) {
                if (response.operation==="success"){
                    swal("User Deactivated", "Success");
                    loadAllData();
                    clear();
                }else{
                    
                    swal("User Deactivated Fail", "Fail");
                }
            
            },

        });
                
            }
        }
    }

    
    function productDelete(){
    var table = document.getElementById('tbl');
    

    for(var i = 0; i < table.rows.length; i++)
    {
        table.rows[i].onclick = function()
        {
           var id= this.cells[1].innerHTML;
            $.ajax({
            url: '/Epic_Lanka_Login_System/deleteUser',
            method: 'DELETE',
            async: true,
            data: JSON.stringify({
                id:id
            }),
            contentType: "application/json",
            success: function (response) {
                if (response.operation==="success"){
                    loadAllData();
                    swal("User Delete Success", "Success");
                    
                }else{
                    swal("User Delete Success", "Success");
                }
            },

        }); 
        };
    }
    
//    console.log(id);
  
    }

    
    function clear(){
         $("#id1").val("");
        $("#username1").val("");
        $("#address1").val("");
        $("#email1").val("");
         $("#conatct1").val("");
         $("#password1").val("");
    }
    


</script>
</body>
</html>
