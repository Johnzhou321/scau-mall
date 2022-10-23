<#import "/master.ftl" as layout/>

<style type="text/css">
.layui-body{overflow-y: scroll !important;}
.layui-table-cell {
    height: auto !important;
    white-space: normal !important;
    word-wrap: break-word;
    word-break: break-all;
}
</style>
<@layout.master>
    <div class="layui-row">
        <span class="layui-breadcrumb">
            <a href="/">首页</a>
            <a href="/api/v1/customer/index"><cite>客户贷款申请管理</cite></a>
        </span>
    </div>
    <br /><br />
        
    <div class="layui-row">
        <form class="layui-form" action="">
	        <div class="layui-form-item">
	            <div class="layui-inline">
	                <label class="layui-form-label">姓名</label>
	                <div class="layui-input-inline">
	                    <input type="text" name="biz_no" class="layui-input" />
	                </div>
	            </div>
	            
	            <div class="layui-inline">
	                <label class="layui-form-label">手机号码</label>
	                <div class="layui-input-inline">
	                    <input type="text" name="biz_type" class="layui-input"/>
	                </div>
	            </div>
	            
	             <div class="layui-inline">
	                <label class="layui-form-label">贷款类型</label>
	                <div class="layui-input-inline">
	                    <select name="product_type">
	                      <option value="" selected>请选择</option>
	                      <option value="all">all-不区分</option>
	                      <option value="short">short-短险</option>
	                      <option value="long">long-长险</option>
	                      <option value="group">group-团险</option>
	                      <option value="personal">personal-个险</option>
	                    </select>     
	                </div>
	            </div>
	    
	            <div class="layui-inline">
	                <label class="layui-form-label"></label>
	                <div class="layui-input-inline">
	                    <button type="button" id="submitBtn" class="layui-btn">查询</button>
	                </div>
	            </div>
	        </div>
	    </form>
    </div>
    
    <div class="layui-row">
        <table id="table"></table>
    </div>
    <script src="/pageJs/customer/index.js"></script>
    <script type="text/javascript" src="/master_files/layui.all.js"></script>
</@layout.master>