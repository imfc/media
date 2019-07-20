function submitLoginForm(){
    var $form = $("#loginForm");
    var userId =$form.find("[name='userId']").val();
    var password = $form.find("[name='password']").val();
    var user = new Object();
    user.userId= userId;
    user.password=password;

    $.ajax({
        type: 'POST',
        url: "http://localhost:9090/login",
        data: user,
        dataType: "json",
        // beforeSend:function(xhr){
        //     xhr.setRequestHeader("CORS_ORIGIN_ALLOW_ALL",true);
        // },
        success: function (rtdata) {
            console.log(rtdata);
        },
        error: function (rtdata) {
            console.log(rtdata);
        }
    });
}