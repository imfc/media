function submitLoginForm() {
    var $form = $("#loginForm");
    var userId = $form.find("[name='userId']").val();
    var password = $form.find("[name='password']").val();
    var user = new Object();
    user.userId = userId;
    user.password = password;
    var url = "http://localhost:9090/login";

    $.ajax({
        type:"POST",
        url:url,
        data:user,
        success:function(data,status){
            console.log("success:"+data)
            var returnUrl = getQueryVariable("returnUrl");
            window.location.href=returnUrl+"?jwt="+data;
        },
        error:function(xhr,errorText,errorType){
            console.log("complete:"+errorText);
        },
        complete:function(){
            // console.log("error:"+info);
        }
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