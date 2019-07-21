/**
 * 公共设置
 */
$.ajaxSetup({
    contentType: "application/x-www-form-urlencoded; charset=utf-8"
});

/**
 * @注释：把Object数据提交到服务器
 * @param url    访问地址。
 * @param pars    参数对象 Object
 * @param sucessCallBack    成功后回调方法
 * @param errorBack        失败后回掉方法
 * @param parentFun        session失效后重新登录后的回掉方法  获取数据的时候如果需要重新登录，设置回掉方法，如果是提交数据失败后最好不要设置回掉方法，让用户手工再操作一遍。
 * @param syn 是否同步，同步显示等待，不同步不等待。
 * @param alertError 是否自动显示错误信息
 * @param hidenLay ,是否关闭显示进度
 * @param timeOutAlert ,掉线是否提醒，默认false 提醒
 */
function postDataServiceObject(url, pars, sucessCallBack, errorBack, parentFun, syn, alertError, hidenLay, timeOutAlert) {
    var turl = url;
    try {
        $.support.cors = true;
        $.ajax({
            type: "POST",
            url: url,
            data: pars,
            dataType: 'json',
            crossDomain: true,
            async: !syn,
            beforeSend: function (xhr) {
                return true;
            },

            success: function (msg, status, xhr) {
                try {
                    resultFilter(msg, sucessCallBack, errorBack, parentFun, alertError, url, timeOutAlert);
                } catch (error) {
                    ealert("resultFilter:" + error.message);
                }
            },
            error: function (msg) {
                try {
                    errrorFilter(msg, sucessCallBack, errorBack);
                } catch (error) {
                    ealert("visite error:" + error.message);
                }
            }
        });
    } catch (error) {
        alert(error);
    }
}



//if($.browser.webkit){
function postParsPreClear(pars){
    if(pars){
        for(var i = 0; i < pars.length; i++){
            var v=pars[i];
//				判断是否是字符
            if((typeof v=='string')&&v.constructor==String){
                if(v){
                    v=v.replace(/\n|\r|\t/g,"  ");
                    pars[attr]=v;
                }
            }else{
                postParsPreClear(v);
            }
        }
    }
}