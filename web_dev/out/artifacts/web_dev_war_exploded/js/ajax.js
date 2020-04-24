function ajax(url, fnSucc, fnFaild){

	// 1. 创建Ajax对象
	var oAjax = new XMLHttpRequest();
	
	// 2. 连接服务器
	// open(方法，文件名， 异步传输)
	oAjax.open('GET',url, true);
	
	// 3. 发送请求
	oAjax.send();
	
	// 4. 接收返回
	oAjax.onreadystatechange=function(){
		// oAjx.readyState 浏览器和服务器，进行到哪一步了
		if(oAjax.readyState==4){ //读取完成
			if(oAjax.status==200){ //成功
				fnSucc(oAjax.responseText);
			}else{
				if(fnFaild){
					fnFaild(oAjax.status);
				}
			}
		}
	}

}