window.onload = function() {
    // //验证码
    // var code = document.getElementById("code");
    // //刷新验证码
    // function change() {
    //     // 验证码组成库
    //     var arrays = new Array(
    //         '2', '3', '4', '5', '6', '7', '8', '9',
    //         'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j',
    //         'k', 'm', 'n', 'p', 'q', 'r', 's', 't',
    //         'u', 'v', 'w', 'x', 'y', 'z',
    //         'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
    //         'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T',
    //         'U', 'V', 'W', 'X', 'Y', 'Z'
    //     );
    //     // 重新初始化验证码
    //     codes = '';
    //     // 随机从数组中获取四个元素组成验证码
    //     for (var i = 0; i < 4; i++) {
    //         // 随机获取一个数组的下标
    //         var r = parseInt(Math.random() * arrays.length);
    //         codes += arrays[r];
    //     }
    //     // 验证码添加到input里
    //     code.value = codes;
    // }
    //
    // change();
    // //单击更换验证码
    // code.onclick = change;

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

    var getVerification = document.getElementById("getVerification");
    getVerification.onclick = getVer;

    //单击验证
    var account = document.getElementById("account");
    var adminPswd = document.getElementById("adminPswd");
    var check = document.getElementById("check");
    var input = document.getElementById("input");



    //验证码验证
    check.onclick = function() {
        if(document.getElementById("user").checked){
            $.ajax({
                url: "/account/signon",
                type: "POST",
                data: {
                    username: $(account).value,
                    password: $(adminPswd).value,
                    verification: $(verification).value
                },
                contentType: "application/json;charset=UTF-8",
                success: function () {
                    console.log("success");
                },
                error: function () {
                    console.log("error");
                }
            });
        }else if(document.getElementById("admin").checked){
            $.ajax({
                url: "/account/signonAdmin",
                type: "POST",
                data: {
                    username: $(account).value,
                    password: $(adminPswd).value
                },
                contentType: "application/json;charset=UTF-8"
            })
                .done(function(){
                    console.log("success");
                })
                .error(function(){
                    console.log("error");
                })
        }else {
            alert("请选择以什么身份登录");
        }
    }
}