(function ($){
	//全局系统对象
    window['jtUtil'] = {};
    
    /**
     * 保留三位有效数字
     * @param e
     * @returns {Boolean}
     */
    jtUtil.noNumbers = function noNumbers(e) {
    	return checkNum(e,3,false);
    }

    /**
     * 保留三位有效数字 可输入正负数
     * @param e
     * @returns {Boolean}
     */
    jtUtil.noNumbersZF = function noNumbersZF(e) {
    	return checkNum(e,3);
    }

    /**
     * 只能输入整数数字
     */
    jtUtil.noNumbersInt = function noNumbersInt(e) {
        return checkNum(e,0,false);
    }

    /**
     * 
     * @param e 事件
     * @param len 限制输入几位小数
     * @param isN 可输入负数:true,false 默认可以输入
     * @returns
     */
    function checkNum(e,len,isN) {
        var obj=e.srcElement || e.target;
        var dot=obj.value.indexOf(".");//alert(e.which);
        len =(typeof(len)=="undefined")?3:len;
        isN =(typeof(isN)=="undefined")?true:isN;
        var  key=e.keyCode || e.which;
        if(key==8 || key==9 || (key>=37  && key<=40)){//这里为了兼容Firefox的backspace,tab,del,方向键
        	return true;
        }
        if(len==0 && key==46){
        	return false;
        }
        if(key==46 && obj.value.indexOf('.') == 0){
        	obj.value = ''; //解决多 .号问题
        	return true;
        }
        //是否可以输入负数
        if(key == 45 && isN){
        	if(obj.value.indexOf('-') == 0){
        		obj.value = ''; //解决多 负号问题
        	}
        	return true;
        }
        if (key<=57 && key>=48) { //数字
            if(dot==-1)//没有小数点
                return true;
            else if(obj.value.length<=dot+len)//小数位数
                return true;
            } else if((key==46) && dot==-1){//小数点
                return true;
        }       
        return false;
    }
    /**
     * 获取全选
     * @returns
     */
    jtUtil.getCheckData = function(table,checkId){
    	if(table == null) return [];
    	return table.checkStatus(checkId).data;
    }
    
    /**
     * 删除行
     * @param title
     * @param url
     * @param delObj
     */
    jtUtil.delRow = function(title,url,delObj,jquery){
		layer.confirm(title, function(index){
			jtUtil.loading();
			var $ = jquery;
	        $.ajax({
	        	url:url,
	        	type:'get',
	        	success:function(res){
	        		if(res){
	        			if(res.code == 1){
	        				layer.closeAll();
	        				delObj.del();
	        			}else{
	        				layer.msg(res.msg);
	        			}
	        		}
	        	}
	        });
	    },function(index){ //退出
	    	jtUtil.closeLoading();
	    });
    }
    /**
     * loading
     */
    var load;
    jtUtil.loading = function(type,time){
    	if(!type){
    		type = 2;
    	}
    	if(!time){
    		time = 5 * 1000;
    	}
    	load = layer.load(type,{time:time});
    }
    /**
     * close loading
     */
    jtUtil.closeLoading =function(){
    	layer.close(load);
    }
    
    /**
     * 详情页
     * @param title
     * @param url
     */
	jtUtil.detailRow = function(title,url){
		layer.open({
			type: 2,
			title: title,
			shadeClose: true, //点击遮罩关闭层
			area: ['100%', '100%'],
			content: url
			,btn: ['关闭']
		});
	}
	var $table;
    /**
     * 新增行
     * @param title
     * @param url
     * @param width
     * @param height
     */
    jtUtil.addRow = function(table,title,url,width , height){
    	$table = table;
		var _w = '800px';
		var _h = '600px';
		if(width!=null) _w=width+"px";
		if(height!=null) _h=height+"px";
		layer.open({
			type: 2,
			title: title,
			shadeClose: true, //点击遮罩关闭层
			area : [_w , _h],
			maxmin: true, //开启最大化最小化按钮
			content: url
			,yes: function(index, layero){
				var body = layer.getChildFrame('body', index);
			}
		});
	}
    
    jtUtil.reloadTable1 = function(){
    	window.location.reload();
    }
    jtUtil.reloadTable2 = function(){
    	$table.reload('jtTableReload');   
    }
    /**
     * 关闭所有
     */
    jtUtil.closeAll = function(){
    	layer.closeAll();
	}
    
})(this);
