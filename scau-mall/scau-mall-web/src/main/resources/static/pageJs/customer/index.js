;!function(){
    var laypage = layui.laypage,
        table = layui.table,
        form = layui.form,
        layer = layui.layer,
        $ = layui.$;
    
    layui.$("#left-nav-bar > li:eq(1)").addClass("layui-nav-itemed");
    /*$(".layui-input-inline").css("width","350px");
    $(".layui-form-label").css("width","100px");*/
    
    $(".layui-input-inline").css("width","70%");
    $(".layui-form-label").css("width","20%");
    
    function setDefaultDate() {
    	if (strIsBlank($("#start_time").val())) {
    		/**
             * 日期选择器
             */
            layui.use('laydate', function(){
        	  var laydate = layui.laydate;
        	  
        	  var now = new Date();
              lastMonth = new Date(now.getFullYear(),now.getMonth()-1,now.getDate());
        	  
        	  laydate.render({
        	    elem: '#start_time', //指定元素
        	    type: 'datetime',
        	    value: lastMonth
        	  });
        	  
        	  laydate.render({
        	    elem: '#end_time', //指定元素
        	    type: 'datetime',
        	    value: now
        	  });
        	});
    	}
    	else {
            layui.use('laydate', function(){
        	  var laydate = layui.laydate;
        	  
        	  laydate.render({
        	    elem: '#start_time', //指定元素
        	    type: 'datetime'
        	  });
        	  
        	  laydate.render({
        	    elem: '#end_time', //指定元素
        	    type: 'datetime'
        	  });
        	});
    	}
    }
    setDefaultDate();

    function refreshTable(clickSearch){
        
        var loaddingMsg = layer.msg('加载中', {icon: 16, shade: 0.1, time:30000});
        table.render({
            elem: '#table',
            id: 'table',
            url: '/api/v1/customer/list?'+$("form").serialize(),
            page: true,
            limits: [20],
            limit: 20,
            cols: [[
                {field: 'name', title: '姓名', width: '10%'},
                {field: 'id_number', title: '身份证号码', width: '10%'},
                {field: 'telephone', title: '手机号码', width: '10%'},
                {field: 'address', title: '地址', width: '9.5%'},
                {field: 'type', title: '贷款类型', width: '9.5%'},
                {field: 'amount', title: '贷款金额', width: '9.5%'},
                {field: 'status', title: '贷款状态', width: '9.5%'},
                {field: 'cz', title: '操作', align: 'center', toolbar: '#editBar'}
            ]],
            done: function(res, curr, count){
                layer.close(loaddingMsg);
            }
        });
        table.on('tool', function(obj){
        	var data = obj.data,
            layEvent = obj.event;
	        if(layEvent === 'detail'){
	        	var loaddingMsg = layer.msg('加载中', {icon: 16, shade: 0.1, time:30000});
	        	window.location.href = "/backend/orders/detail?order_no="+data.order_no;
	            return false;
	        }
        });
    }
    refreshTable(false);
    
    $("#submitBtn").click(function(){
		refreshTable(true);
        return false;
    });

//    $("#resetBtn").click(function(){
//    	layui.use('laydate', function(){
//		  var laydate = layui.laydate;
//		  
//		  var now = new Date();
//	      lastMonth = new Date(now.getFullYear(),now.getMonth()-1,now.getDate());
//		  
//		  laydate.render({
//		    elem: '#start_time', //指定元素
//		    value: lastMonth
//		  });
//		  
//		  laydate.render({
//		    elem: '#end_time', //指定元素
//		    value: now
//		  });
//		});
//    });
    
    function strIsBlank(value) {
    	if (value == null || value == undefined || value == '' || $.trim(value) == '') { 
    		return true;
    	} 
    	else {
    		return false;
    	}
    }
    
}();
