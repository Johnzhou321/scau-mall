<#macro master title="商城管理后台" headEnd="" bodyEnd="">
<!DOCTYPE html>
<!-- saved from url=(0033)http://admin.xiangrikui.com:3038/ -->
<html style="font-size: 100px;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>商城管理后台-首页</title>
        <meta name="renderer" content="webkit"> 
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">     
        <meta name="format-detection" content="telephone=no">   
        <link rel="stylesheet" type="text/css" href="/master_files/layui.css" media="all">
        <link rel="stylesheet" type="text/css" href="/master_files/global.css" media="all">
        <link rel="stylesheet" type="text/css" href="/master_files/personal.css" media="all">
        <link rel="stylesheet" type="text/css" href="/master_files/formSelects-v4.css" media="all">
        <link rel="stylesheet" type="text/css" href="/master_files/wangEditor.min.css">
        <link rel="stylesheet" type="text/css" href="/master_files/zTreeStyle.css">
        <link rel="stylesheet" type="text/css" href="/master_files/viewer.css" media="all">
        
        <script type="text/javascript" src="/master_files/layui.all.js"></script>
        <script type="text/javascript" src="/master_files/DateExtension.js"></script>
        <script type="text/javascript" src="/master_files/common.js"></script>
        <script type="text/javascript" src="/master_files/formSelects-v4.js"></script>
        <script type="text/javascript" src="/master_files/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="/master_files/wangEditor.min.js"></script>
        <script type="text/javascript" src="/master_files/jquery.ztree.core.js"></script>
        <script type="text/javascript" src="/master_files/jquery.ztree.excheck.js"></script>
        
        <script type="text/javascript" src="/master_files/index.js"></script>
        
    <link id="layuicss-laydate" rel="stylesheet" href="/master_files/laydate.css" media="all"><link id="layuicss-layer" rel="stylesheet" href="/master_files/layer.css" media="all"><link id="layuicss-skincodecss" rel="stylesheet" href="/master_files/code.css" media="all"></head>
    
    <body class="layui-layout-body">
        <div class="layui-layout layui-layout-admin">
            <#include "header.ftl">
            <#include "sidebar.ftl">
            <div class="layui-body" style="bottom: 40px;border-left: solid 2px #1AA094;">
                <!-- 内容主体区域 -->
                <div style="padding: 15px;">
                    <#nested />
                </div>
            </div>
            <div class="layui-footer" style="text-align: center;">
                © <a href="https://www.xiangrikui.com" target="_blank">xiangrikui.com</a>- xxx科技技术有限公司
            </div>
        </div>
        

</body></html>
</#macro>