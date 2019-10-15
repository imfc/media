function submitLoginForm() {
    var $form = $("#loginForm");
    var userId = $form.find("[name='userId']").val();
    var password = $form.find("[name='password']").val();
    var user = new Object();
    user.userId = userId;
    user.password = password;
    var url = "http://localhost:9090/login?userId="+userId+"&password="+password;

    // get(url,function(rtdata){
    //     layer.msg("请求成功：jwt:"+rtdata);
    // })
    post(url,user,function(result){
        console.log(result);
    })


    function getQueryVariable(variable){
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i=0;i<vars.length;i++) {
            var pair = vars[i].split("=");
            if(pair[0] == variable){return pair[1];}
        }
        return(false);
    }

}