window.onload = function() {

    var ver = document.getElementById("getVerification");
    ver.onclick = getVer;
    //单机获取验证码
    function getVer() {
        var username = document.getElementById("username");
        var email = document.getElementById("email");
        if (username.value == null || username.value == "") {
            //alert("请先输入用户名");
            $("#inf").html("请先输入用户名");
        }else if(email.value == null || email.value == "") {
            //alert("请输入邮箱");
            $("#inf").html("请输入邮箱");
        }else{
                $.ajax({
                    url: "/account/getVerificationSignOn",
                    type: "POST",
                    data: {
                        'username': username.value,
                        'email': email.value
                    },
                    //contentType: "application/json;charset=UTF-8"
                })
                    .done(function (data) {
                        //60秒后可以再次获得验证码
                        var wait = 60;
                        time(wait);
                        alert(data);
                    })
                    .fail(function (data) {
                        console.log("error");
                        alert(data);
                    });
            }
    }

    //验证码获取间隔60秒
    function time(wait) {
        if (wait == 0) {
            $(getVerification).attr("disabled", false);
            $(getVerification).val("获取验证码");
        } else {
            $(getVerification).attr("disabled", true);
            $(getVerification).val(wait + "秒后重新获取");
            wait--;
            setTimeout(function () {time(wait);}, 1000);
        }
    }

    var check = document.getElementById("check");
    check.onclick = creat;
    //点击创建账号
    function creat(){
        var username = document.getElementById("username");
        var email = document.getElementById("email");
        var password = document.getElementById("password");
        var passwordConfirm = document.getElementById("passwordConfirm");
        var verification = document.getElementById("verification");
        if (username.value == null || username.value == "") {
           // alert("用户名不能为空");
            $("#inf").html("用户名不能为空");
        }else if(email.value == null || email.value == "") {
            //alert("邮箱不能为空");
            $("#inf").html("邮箱不能为空");
        }else if(password.value == null || password.value == ""){
           // alert("密码不能为空");
            $("#inf").html("密码不能为空");
        }else if(passwordConfirm.value == null || passwordConfirm.value == ""){
            //alert("二次确认密码不能为空");
            $("#inf").html("二次确认密码不能为空");
        }else if(password.value != passwordConfirm.value){
           // alert("两次输入的密码不同");
            $("#inf").html("两次输入的密码不同");
        }else{
            $.ajax({
                url: "/account/newAccount",
                type: "POST",
                data:{
                    username: username.value,
                    password: password.value,
                    email: email.value,
                    verification: verification.value
                },
                //contentType: "application/json;charset=UTF-8",
            })
                .done(function (data){
                    $("#inf").html(data);
                    console.log("success");
                })
                .fail(function (){
                    console.log("error");
                })
        }
    }

    var use = document.getElementById("username");
    use.onchange = checkName;
    //自动检查用户名是否存在
    function checkName(){
        var username = document.getElementById("username");

        $.ajax({
            url: "/account/checkAccount",
            type: "POST",
            // contentType: "application/json;charset=UTF-8"
            data:{
                'username':username.value
            }
        })
            .done(function (data){
                $("#inf").html(data);
            })
            .fail(function (){
                console.log("error");
            })
    }


    var passCon = document.getElementById("passwordConfirm");
    passCon.onchange = checkPassword;
    //自动判断两次密码输入是否相同
    function checkPassword(){
        var password = document.getElementById("password");
        var passwordConfirm = document.getElementById("passwordConfirm");
        if(password.value != passwordConfirm.value){
            $("#inf").html("两次输入的密码不同，请检查");
        }else{
            $("#inf").html("");
        }
    }


}
