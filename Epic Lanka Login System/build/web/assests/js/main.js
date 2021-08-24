const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
    container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
    container.classList.remove("right-panel-active");
});

$('#btnSignup').click(function () {

    let name = $('#nameid').val();
    let email = $('#emailid').val();
    let mobileNumber = $('#mobileid').val();
    let address = $('#addressid').val();
    let userName = $('#unameid').val();
    let password = $('#passwordid').val();
    let state = "user";

    console.log(name);
    $.ajax({
        method: "POST",
        contentType: "application/json",
        url: "http://localhost:8079/api/v1/user/save",
        crossDomain:true,
        crossOrigin:true,
        data: JSON.stringify({
            'name': name,
            'email': email,
            'mobileNumber': mobileNumber,
            'address':address,
            'userName': userName,
            'password': password,
            'state':state
        }),
        success: function (resp) {
            confirm("User Added");
            // console.log("respnd udin");
            // console.log(resp.code);
            if (resp.code == 200) {
                confirm("User Added");
                console.log("respond yatin")
            }

        }
    })
});

$('#btn-login').on('click', function () {

    let userName = $('#txtUsername').val();
    let passwordd = $('#passwordd').val();

    $.ajax({
        method: "GET",
        url: "http://localhost:8079/api/v1/user/onebyuserName/"+userName,
        async: true,
        success:function (resp) {
            console.log(resp.password);
            if (resp.password == passwordd && resp.state == "user"){
                console.log("ela")
                switchToLogin();
            }else if (resp.password == passwordd && resp.state == "admin"){
                console.log("ela22")
                switchToLogin2()

            }else {
                confirm("Signup First..!")
            }
        }

    });
});

function switchToLogin() {
    window.location.replace('http://localhost:63342/FrontEnd/Loginpage/index.html?_ijt=fvig49754oonvkjci7an7q85i2');
}

function switchToLogin2() {
    window.location.replace('http://localhost:63342/FrontEnd/Userpage2/index.html?_ijt=v0bvd3isbne7n6lio17ihmnorl');
}


