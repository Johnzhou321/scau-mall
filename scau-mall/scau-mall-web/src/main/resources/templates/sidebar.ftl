<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" lay-filter="test" id="left-nav-bar">
            <li class="layui-nav-item"><a href="/"><i class="layui-icon">&#xe68e;</i> 首页</a></li>
            <!--客户管理-->
            <li class="layui-nav-item">
                <a class="" href="javascript:"><i class="layui-icon">&#xe61d;</i> 客户管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="/api/v1/customer/index"> 客户贷款申请管理</a></dd>
                </dl>
            </li>
            
        </ul>
    </div>
</div>