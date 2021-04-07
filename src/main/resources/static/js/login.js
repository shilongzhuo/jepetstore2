window.onload = function() {

    //单机获取验证码
    function getVer() {
        //选择的为user
        if(document.getElementById("user").checked) {
            var username = document.getElementById("account");
            if (username.value == null || username.value == "") {
                alert("请先输入用户名");
            } else {
                $.ajax({
                    url: "/account/getVerification",
                    type: "GET",
                    data: {
                        username: account.value
                    },
                    contentType: "application/json;charset=UTF-8"
                })
                    .done(function(data){
                        if(data != "用户名不存在"){
                            //60秒后可以再次获得验证码
                            var wait = 60;
                            time(wait);
                        }
                        alert(data);
                    })
                    .fail(function(data){
                        console.log("error");
                        alert(data);
                    });
            }
        }else if(document.getElementById("admin").checked){
            alert("管理员登陆不需要验证码");
        }else{
            alert("请选择使用User登录");
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

}