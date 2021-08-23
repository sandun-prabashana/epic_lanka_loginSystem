var v1=document.getElementById('login');
var v2=document.getElementById('forgetPassword');



views();

function views(){
    v1.style.display='none';
    v2.style.display='block';
}

$("#back").click(function (){
    window.location.href="loginfrom.jsp"
});

$("#new").click(function (){
    views();
});




    
    
    
