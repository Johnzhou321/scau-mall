;!function(){
	
	var $ = layui.$;

    $.fn.extend({
       serializeObject:function(){
           if(this.length>1){
              return false;
           }
           var arr=this.serializeArray();
           var obj=new Object;
           $.each(arr,function(k,v){
              obj[v.name]=v.value;
           });
           return obj;
       }
    });
    
    
    //freemarker 后台model传dateTime过来 时分秒无法正常显示， 需要做特殊调整
    freemarkerDateResolverAdjust = function(){
    	for(var i=0; i<arguments.length; i++){
    		var dateStr = arguments[i].val();
    		if(dateStr){
    			var head = dateStr.substr(0, 10);
        		var tail = dateStr.substr(10);
        		arguments[i].val(head + " " + tail);
    		}
    	}
    }
    
    //计算主页面表格的cell的缩放系数，这里假设主页面的表格代码设定的初始宽度总和是1100
    getMainFrameTableScale = function(tableWidth){
    	var mainFrameWidth = $("body").width();
    	var initWidth = 1100;
    	if(tableWidth){
    		initWidth = tableWidth;
    	}
    	if(mainFrameWidth && mainFrameWidth > initWidth+44){
    		return (mainFrameWidth - 44) / initWidth;
    	}
    	return 1;
    }
    
    //截取字符串 直达匹配到matchStr
    getStrUtilCharIs = function(destStr, matchStr){
    	if(destStr){
    		var array = destStr.split(matchStr, 1);
        	return array[0];
    	}
    	return destStr;
    }


    //如果使用 FileSaver.js 就不要同时使用以下函数
    saveAs = function(obj, fileName) {//当然可以自定义简单的下载文件实现方式
        var tmpa = document.createElement("a");
        tmpa.download = fileName || "下载";
        tmpa.href = URL.createObjectURL(obj); //绑定a标签
        tmpa.click(); //模拟点击实现下载
        setTimeout(function () { //延时释放
            URL.revokeObjectURL(obj); //用URL.revokeObjectURL()来释放这个object URL
        }, 100);
    }

    const wopts = { bookType: 'xlsx', bookSST: false, type: 'binary' };//这里的数据是用来定义导出的格式类型

    downloadExl = function(data, fileName, type) {
        const wb = { SheetNames: ['Sheet1'], Sheets: {}, Props: {} };
        wb.Sheets['Sheet1'] = XLSX.utils.json_to_sheet(data);//通过json_to_sheet转成单页(Sheet)数据
        saveAs(new Blob([s2ab(XLSX.write(wb, wopts))], { type: "application/octet-stream" }), fileName + '.' + (wopts.bookType=="biff2"?"xls":wopts.bookType));
    }

    s2ab = function(s) {
        if (typeof ArrayBuffer !== 'undefined') {
            var buf = new ArrayBuffer(s.length);
            var view = new Uint8Array(buf);
            for (var i = 0; i != s.length; ++i) view[i] = s.charCodeAt(i) & 0xFF;
            return buf;
        } else {
            var buf = new Array(s.length);
            for (var i = 0; i != s.length; ++i) buf[i] = s.charCodeAt(i) & 0xFF;
            return buf;
        }
    }
    
    /*
     * 表单元素校验
     * type 类型：phone 手机号码；email电子邮件；number 数字类型
     * str  表单文本
     * 检验通过返回true，否则返回false
     */
    formCheck = function(type, str){
    	debugger;
    	if(type && str){
    		if(type == 'phone'){
    			return str.match(/^1[34578]\d{9}$/);
    		}else if(type == 'email'){
    			return str.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/);
    		}else if(type == 'number'){
    			return str.match(/^[0-9]*$/);
    		}else if(type == 'idNo'){
    			   return str.match(/^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/);
    		}else if(type == 'name'){
    			   return str.match(/^[^\s0-9\~\`\!\@\#\$\%\^\&\*\(\)\-\_\+\=\|\\\[\]\{\}\;\:\"\'\,\<\.\?\/\>\uFF10-\uFF19\uFF21-\uFF3A\uFF41-\uFF5A\u3040-\u309F\u30A0-\u30FF\uFF01-\uFF5E\uFFE0\uFFE5]+$|^[a-zA-Z]{1}[a-zA-Z\s]+[a-zA-Z]{1}$/);
    		}
    	}
    	return false;
    }
    
    /**
     * 从对象数组中删除属性为objPropery，值为objValue元素的对象
     * @param Array arrPerson  数组对象
     * @param String objPropery  对象的属性
     * @param String objPropery  对象的值
     * @return Array 过滤后数组
     */
	objectArrayRemove = function(arrPerson,objPropery,objValue){
        return $.grep(arrPerson, function(cur,i){
        	return cur[objPropery]!=objValue;
        });
	}
    
	/**
	 * 组装开关模板
	 */
	switchTpl = function(field,text, checkedValue, id_key){//开关,field字段名称(必填),text文本(必填),checkedValue选中值(必填),id_key主键键值(必填)
		return '<input data-id="{{d.'+id_key+'}}" type="checkbox" name="' + field + '" value="{{d.' + field + '}}" lay-skin="switch" lay-text="' + text + '" lay-filter="switch_'+field+'" {{ d.' + field + ' == "'+checkedValue+'" ? "checked" : "" }}>';
    }
	
	/**
     * 异步加载依赖的javascript文件
     * src：script的路径
     * callback：当外部的javascript文件被load的时候，执行的回调
     */
    load_js = function(src, callback) {
        var srcArray = src.split("?")[0].split("/");
        var scr_src = srcArray[srcArray.length - 1];

        // 判断要 添加的脚本是否存在如果存在则不继续添加了
        var scripts = document.getElementsByTagName("script");
        if (!!scripts && 0 != scripts.length) {
            for (var i = 0; i < scripts.length; i++) {
                if (-1 != scripts[i].src.indexOf(scr_src)) {
                    callback();
                    return true;
	
                }
            }
        }

        // 不存在需要的则添加
        var head = document.getElementsByTagName("head")[0];
        var script = document.createElement("script");
        script.setAttribute("type", "text/javascript");
        script.setAttribute("src", src);
        script.setAttribute("async", true);
        script.setAttribute("defer", true);
        head.appendChild(script);

        //fuck ie! duck type
        if (document.all) {
            script.onreadystatechange = function() {
                var state = this.readyState;
                if (state === 'loaded' || state === 'complete') {
                    callback();
                }
            };
        } else {
            //firefox, chrome
            script.onload = function() {
                callback();
            };
        }
    }
    
    //导航栏打开-关闭控制
    $("#left-nav-bar").find('li').click(function(){
		if(!$(this).is('.layui-nav-itemed')){
			$(this).removeClass("layui-nav-itemed");
		}else{
			$("#left-nav-bar").find('li').each(function(){
				$(this).removeClass("layui-nav-itemed");
			});
			$(this).addClass("layui-nav-itemed");
		}
	});
    
    // 面包屑点击跳转
	$(".layui-breadcrumb").find("a.breadcrumb-link").click(function() {
		var title = $(this).attr("data-title"),
			link = $(this).attr("data-link");
		parent.changeCurrentTabElementTitle(title);
        window.location.href = link;
	});
	
	createViewerObj = function(id, images) {
        if(!id) return;
        if(images && images.length > 0) {
            $("#"+id).empty();
            for(var i = 0; i < images.length; i++) {
                $("#"+id).append('<li><img src="'+images[i].url+'" alt="'+images[i].name+'"></li>')
            }
            var viewer = new Viewer(document.getElementById(id), {
              minWidth:600,
              minHeight:400
            });
            viewer.show(true);
            return viewer;
        } else {
            return;
        }

    }

}();