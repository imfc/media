/*
	//基于jquery的ajax
	$.ajax({
		'url': url,			//请求的url
		'data': data,		//请求的参数
		'type': post,		//请求的类型
		'dataType': json,	//接收数据类型
		'async': true,		//异步请求
		'cache': false,		//浏览器缓存
		'success': function () {},	//请求成功后执行的函数
		'error': function () {},	//请求失败后执行的函数
		'jsonpCallback': 'jsonp' + (new Date()).valueOf().toString().substr(-4),//通过jsonp跨域请求的回调函数名
		'beforeSend': function () {}//请求前要处理的函数
	});
*/
//全局配置
$.ajaxSetup({
	contentType:'application/html,text'
})

//页面加载所要进行的操作
$(function () {
	//设置ajax当前状态(是否可以发送);
	ajaxStatus = true;
});

// ajax封装
function ajax(url, data, success, cache, alone, async, type, dataType, error) {
	var type = type || 'post';//请求类型
	var dataType = dataType || 'json';//接收数据类型
	var async = async || true;//异步请求
	var alone = alone || false;//独立提交（一次有效的提交）
	var cache = cache || false;//浏览器历史缓存
	var success = success || function (data) {
		/*console.log('请求成功');*/
		setTimeout(function () {
			layer.msg(data.msg);//通过layer插件来进行提示信息
		},500);
		if(data.status){//服务器处理成功
			setTimeout(function () {
				if(data.url){
					location.replace(data.url);
				}else{
					location.reload(true);
				}
			},1500);
		}else{//服务器处理失败
			if(alone){//改变ajax提交状态
				ajaxStatus = true;
			}
		}
	};
	var error = error || function (data) {
		/*console.error('请求成功失败');*/
		/*data.status;//错误状态吗*/
		layer.closeAll('loading');
		setTimeout(function () {
			if(data.status == 404){
				layer.msg('请求失败，请求未找到');
			}else if(data.status == 503){
				layer.msg('请求失败，服务器内部错误');
			}else {
				layer.msg('请求失败,网络连接超时');
			}
			ajaxStatus = true;
		},500);
	};
	/*判断是否可以发送请求*/
	if(!ajaxStatus){
		return false;
	}
	ajaxStatus = false;//禁用ajax请求
	/*正常情况下1秒后可以再次多个异步请求，为true时只可以有一次有效请求（例如添加数据）*/
	if(!alone){
		setTimeout(function () {
			ajaxStatus = true;
		},1000);
	}
	$.ajax({
		'url': url,
		'data': data,
		'type': type,
		'dataType': dataType,
		'async': async,
		'success': success,
		'error': error,
		'jsonpCallback': 'jsonp' + (new Date()).valueOf().toString().substr(-4),
		'beforeSend': function () {
			layer.msg('加载中', { //通过layer插件来进行提示正在加载
				icon:16,
				shade:0.01
		});
		},
	});
}

// submitAjax(post方式提交)
function submitAjax($form, success, cache, alone) {
	cache = cache || true;
	var url = $form.attr('action');
	var data = getFormData($form);
	ajax(url, data, success, cache, alone, false, 'post','json');
}

function getFormData($form) {
	var unindexed_array = $form.serializeArray();
	var indexed_array = {};

	$.map(unindexed_array, function (n, i) {
		indexed_array[n['name']] = n['value'];
	});

	return indexed_array;
}

/*//调用实例
$(function () {
    $('#form-login').submit(function () {
        submitAjax('#form-login');
        return false;
    });
});*/

// ajax提交(post方式提交)
function post(url, data, success, cache, alone) {
	ajax(url, data, success, cache, alone, false, 'post','json');
}

// ajax提交(get方式提交)
function get(url, success, cache, alone) {
	ajax(url, {}, success, alone, false, 'get','json');
}

// jsonp跨域请求(get方式提交)
function jsonp(url, success, cache, alone) {
	ajax(url, {}, success, cache, alone, false, 'get','jsonp');
}