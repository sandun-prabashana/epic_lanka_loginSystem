var LName=/^[A-Z]{1}[a-z]{1,9}$/;
$('#login_uname').on('keydown',function (event) {
    var input=(event.key);
    let inputName=$('#login_uname').val();
    if (LName.test(inputName)){
        $('#login_span_uname').text('');
        // $('#custName').css('border','2px solid lime');
        if (input=="Enter"){
        }
    }else {
        // $('#custName').css('border','2px solid red');
        $('#login_span_uname').text('Data format Is Wrong(Ex:-Name)');
        $('#login_uname').focus();
    }
});

var Name=/^[A-Z]{1}[a-z]{1,9}$/;
$('#uname').on('keydown',function (event) {
    var input=(event.key);
    let inputName=$('#uname').val();
    if (Name.test(inputName)){
        $('#spanuname').text('');
        // $('#custName').css('border','2px solid lime');
        console.log(input);
        if (input=="Enter"){
            $('#address').focus();
        }
    }else {
        // $('#custName').css('border','2px solid red');
        $('#spanuname').text('Data format Is Wrong(Ex:-Saman)');
        $('#uname').focus();
    }
});

var FullName=/^[A-Z]{1}[a-z]{1,9}$/;
$('#address').on('keydown',function (event) {
    var input=(event.key);
    let inputName=$('#address').val();
    if (FullName.test(inputName)){
        $('#spanfname').text('');
        // $('#custName').css('border','2px solid lime');
        if (input=="Enter"){
            $('#emailaddress').focus();
        }
    }else {
        // $('#custName').css('border','2px solid red');
        $('#spanfname').text('Data format Is Wrong(Ex:-Colombo)');
        $('#address').focus();
    }
});

var Phone=/^[a-z]{1,19}(@gmail.com)$/;
$('#emailaddress').on('keydown',function (event) {
    var input=(event.key);
    let inputName=$('#emailaddress').val();
    if (Phone.test(inputName)){
        $('#spannumber').text('');
        // $('#custPhone').css('border','2px solid lime');
        if (input=="Enter"){
            $('#number').focus();
        }
    }else {
        // $('#custPhone').css('border','2px solid red');
        $('#spannumber').text('Data format Is Wrong(Ex:-xx@gmail.com)');
        $('#emailaddress').focus();
    }
});

var Email=/^[0-9]{3}(-)[0-9]{7}$/;
$('#number').on('keydown',function (event) {
    var input=(event.key);
    let inputName=$('#number').val();
    if (Email.test(inputName)){
        $('#spanemail').text('');
        // $('#EmailAddress').css('border','2px solid lime');
        if (input=="Enter"){
            $('#password').focus();
        }
    }else {
        // $('#EmailAddress').css('border','2px solid red');
        $('#spanemail').text('Your Input Data format Is Wrong(Ex:-000-0000000)');
        $('#number').focus();
    }
});

