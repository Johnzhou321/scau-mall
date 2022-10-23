<!DOCTYPE html>
<!-- saved from url=(0096)http://qianmin.kunhonganjie.site/app/index.php?i=2&c=entry&do=register&m=qianmin_server&yqm=1315 -->
<html style="font-size: 100px;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title></title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link href="./index_files/public.css" rel="stylesheet" type="text/css">
<!--    <link href="http://qianmin.kunhonganjie.site/addons/qianmin_server/images/mobile/css/style.css" rel="stylesheet" type="text/css"/>-->
    <script src="./index_files/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="/common.js"></script>
    

    <style>
    @charset "utf-8";
    /* CSS Document */
    .warp{
        width: 100%;
        /*overflow: hidden;*/
        /*min-height: 100vh;*/
        position: relative;
        padding-bottom: 1.4rem;
    }
    .user{
        background: url(http://qianmin.kunhonganjie.site/addons/qianmin_server/images/mobile/images/user-bg.png)  no-repeat scroll top center  #f7f8f9;
        background-size:100%;
    }
    .hall{
        /*background: url(http://qianmin.kunhonganjie.site/addons/qianmin_server/images/mobile/images/hall-bg.png)  no-repeat scroll top center  #f7f8f9;*/
        background-size:100%;
    }
    .register{
        background: url(http://qianmin.kunhonganjie.site/addons/qianmin_server/images/mobile/images/register-bg.png)  no-repeat scroll top center  #fff;
        background-size:100%;
    }
    .warp .personal{
        margin-top: .57rem;
        padding-left: .3rem;
        width: 100%;
        display: flex;
        position: relative;
        margin-bottom: .7rem;
    }
    .warp .personal .tx{
        width: 1.49rem;
        height: 1.49rem;
        margin-right: .3rem;
    }
    .warp .personal h1 span{
        font-size: .36rem;
        color: #ffffff;
        font-family: pfb;
        margin-top: .25rem;
        display: block;
    }
    .warp .personal h1 p{
        display: flex;
        align-items: center;
        margin-top: .15rem;
    }
    .warp .personal h1 p img{
        width: .17rem;
        height: .27rem;
    }
    .warp .personal h1 em{
        font-size: .24rem;
        color: #ffffff;
        font-family: pfb;
        margin-left: .08rem;
    }
    .warp .personal .Notice{
        display: flex;
        width: 1.67rem;
        height: .66rem;
        background-color: #36c394;
        align-items: center;
        padding-left: .38rem;
        border-top-left-radius: .4rem;
        border-bottom-left-radius: .4rem;
        position: absolute;
        top: 40%;
        right: 0;
        transform: translate(-0%, -50%);
    }
    .warp .personal .Notice p{
        font-size: .28rem;
        color: #ffffff;
        font-family: pfm;
    }
    .warp .personal .Notice img{
        width: .14rem;
        height: .25rem;
        margin-left: .25rem;
    }
    .warp .profit{
        margin: 0 .3rem;
        background-color: #fff;
        height: 1.79rem;
        border-radius: .2rem;
        box-shadow: 0 .02rem .3rem#e6e6e6;
    }
    .warp .profit ul{
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    .warp .profit ul li{
        width: 33.333%;
        text-align: center;
        padding: .35rem 0;
        position: relative;
    }
    .warp .profit ul li p{
        font-size: .42rem;
        font-family: pfb;
        color: #f55f5f;
        margin-bottom: .1rem;
    }
    .warp .profit ul li.partner p{
        color: #0aa06d;
    }
    .warp .profit ul li span{
        font-size: .26rem;
        font-family: pfm;
        color: #807f7f;
    }
    .warp .profit ul li .border{
        position: absolute;
        left: 0;
        top: 50%;
        width: 1px;
        height: .43rem;
        background-color: #d8d8d8;
        transform: translate(-0%, -50%);
    }
    .warp .list{
        margin: 0 .3rem;
        padding: .4rem 0;
        background-color: #fff;
        border-radius: .2rem;
        margin-top: .3rem;
        box-shadow: 0 .02rem .3rem #e6e6e6;
    }
    .warp .list ul{
        display: flex;
        justify-content: space-between;
        align-items: center;
        flex-wrap: wrap;
    }
    .warp .list ul li{
        width: 33.333%;
        height: 2rem;
        text-align: center;
        position: relative;
    }
    .warp .list ul li a{
        display: block;
        padding: .3rem 0 .4rem 0;
    }
    .warp .list ul li img{
        width: .52rem;
        margin: 0 auto;
    }
    .warp .list ul li p{
        font-size: .26rem;
        color: #807f7f;
        font-family: pfm;
        margin-top: .32rem;
    }
    .warp .list ul li.kf span{
        width: .47rem;
        height: .38rem;
        line-height: .35rem;
        background-color: #f55757;
        border-radius: .3rem;
        display: block;
        font-size: .26rem;
        color: #fff;
        font-family: pfb;
        border: 1px solid #fff;
        position: absolute;
        top: .1rem;
        right: .65rem;

    }

    .warp .conter{
        width: 100%;
        background-color: #fff;
        /*min-height: 91vh;*/
        position: relative;
        /*margin-bottom: 1.4rem;*/
    }
    .warp .hall-nav{
        margin: 0 .3rem;
        padding: .4rem 0;
    }
    .warp .hall-nav ul{
        display: flex;
        justify-content: space-between;
        text-align: center;
    }
    .warp .hall-nav ul li img{
        width: 1.05rem;
    }
    .warp .hall-nav ul li a{
        display: block;
    }
    .warp .hall-nav ul li p{
        margin-bottom: .1rem;
        font-size: .2403rem;
        color: #434343;
        font-family: pfb;
    }
    .warp .hall-list{
        margin: 0 .3rem;
    }
    .warp .hall-list ul li{
        background-color: #f7f7f8;
        margin-bottom: .2rem;
        display: flex;
        align-items: center;
        padding:  .15rem .25rem;
        border-radius: .12rem;
    }
    .warp .hall-list ul li em:nth-child(1){
        width: 23%;
    }
    .warp .hall-list ul li em:nth-child(2){
        width: 59%;
        padding-top: .04rem;
    }
    .warp .hall-list ul li em:nth-child(3){
        width: 18%;
    }
    .warp .hall-list ul li em{
        display: block;
        color: #01b075;
        font-size: .3rem;
        font-family: pfb;
    }
    .warp .hall-list ul li em p{
        color: #646464;
        font-size: .24rem;
        font-family: pfb;
    }
    .warp .hall-list ul li em span{
        color: #646464;
        font-size: .24rem;
        font-family: pfb;
        margin-right: .35rem;
    }
    .warp .hall-list ul li em button,.dingdan_con_right button{
        width: 1.16rem;
        height: .53rem;
        border-radius: .3rem;
        border: none;
        outline: none;
        color: #fff;
        font-size: .22rem;
        font-family: pfb;
        background-color: #01b075;
        box-shadow: 0 5px 5px #bfe7da;
    }
    .warp .paging{
        width: 100%;
        padding: .37rem .3rem;
        display: flex;
        justify-content: space-between;
        position: absolute;
        bottom: 0;
        left: 0;
    }
    .warp .paging a{
        width: 1.22rem;
        height: .5rem;
        display: block;
        line-height: .5rem;
        text-align: center;
        font-size: .28rem;
        color: #8d9daf;
        background-color: #e2e8ef;
        border-radius: .25rem;
        font-family: pfb;
    }
    .warp .paging a.previous{
        background-color: #01b075;
        color: #fff;
    }
    .warp .paging a.next{
        background-color: #01b075;
        color: #fff;
    }
    .warp .paging a.page{
        background-color: #f4f6f7;
    }
    .warp .paging a.page span{
        color: #222;
        font-family: pfb;
    }

    .warp .logon{
        margin: 0 .3rem;
        background-color: #fff;
        margin-top: 2rem;
        border-radius: .2rem;
        padding: .4rem 0;
        box-shadow: 0 60px 100px #e7e7e7;
    }
    .warp .logon>ul{
        margin: 0 .4rem;
    }
    .warp .logon>ul>li{
        position: relative;
    }
    .warp .logon>ul>li.name p{
        color:#3e4a59;
        font-size: .24rem;
        font-family: pfm;
        padding-left: .2rem;
    }
    .warp .logon>ul>li input{
        width: 100%;
        height: .9rem;
        font-size: .24rem;
        color: #3e4a59;
        font-family: pfm;
        border-bottom: 1px solid #d3dfef;
        margin-bottom: .1rem;
        padding-left: .2rem;
    }
    .warp .logon>ul>li input::placeholder{
        color: #3e4a59;
    }
    .warp .logon>ul>li.activ input{
        font-family: pfr;
        font-size: .33rem;
        color: #24272b;
        border-bottom: 3px solid #01ad73;
    }
    .warp .logon>ul>li.name>.yes{
        top: 62%;
    }
    .warp .logon>ul>li>.yes,
    .warp .logon>ul>li>.xl{
        position: absolute;
        width: .36rem;
        top: 50%;
        right: 1%;
        transform: translate(-0%, -50%);
    }
    .warp .logon .Industry{
        position: relative;
    }
    .warp .logon .Industry ul{
        position: absolute;
        background-color: #fff;
        width: 100%;
        overflow: hidden;
        z-index: 1;
        display: none;
    }
    .warp .logon .Industry ul li{
        padding-left: .2rem;
        border-bottom: 1px solid #f1f1f1;
        line-height: .6rem;
        font-family: pfm;
        font-size: .24rem;
        color: #3e4a59;
    }
    .warp .logon .xieyi{
        display: flex;
        align-items: center;
        float: right;
        margin-top: .35rem;
        margin-bottom: .15rem;
    }
    .warp .logon .xieyi img{
        width: .3rem;
        height: .3rem;
    }
    .warp .logon .xieyi em{
        width: .26rem;
        height: .26rem;
        border: 1px solid #bbb;
        border-radius: 50%;
    }
    .warp .logon .xieyi em.click{
        width: .3rem;
        height: .3rem;
        border: none;
        background: url(http://qianmin.kunhonganjie.site/addons/qianmin_server/images/mobile/images/yes.png);
        background-size: 100% 100%;
    }
    .warp .logon .xieyi span{
        font-size: .24rem;
        color: #02bf8d;
        font-family: pfm;
        margin-left: .15rem;
    }
    .warp .logon-btn{
        width: 5.8rem;
        height: .99rem;
        line-height: .99rem;
        background-color: #02c290;
        background-image: linear-gradient(to right,#01ad70,#02c494);
        font-size: .33rem;
        color: #fff;
        font-family: pfb;
        letter-spacing: .03rem;
        border: none;
        display: flex;
        justify-content: center;
        margin: 0 auto;
        border-radius: .5rem;
        margin-top: .73rem;
        outline: none;
        box-shadow: 0 10px 10px #cff0e5;
    }
    .warp .logon-btn a,.warp .tuiguang-btn a{ color:#FFF;}
    .warp .tuiguang-btn {
        width: 5.8rem;
        height: .99rem;
        line-height: .99rem;
        background-color:#F60;
        background-image: linear-gradient(to right,#F60,#F60);
        font-size: .33rem;
        color: #fff;
        font-family: pfb;
        letter-spacing: .03rem;
        border: none;
        display: flex;
        justify-content: center;
        margin: 0 auto;
        border-radius: .5rem;
        margin-top: .73rem;
        outline: none;
        box-shadow: 0 10px 10px #cff0e5;
    }
    .warp .foot{
        margin-top: 1.45rem;
        margin-bottom: 2rem;
        position: relative;
        text-align: center;
    }
    .warp .foot .bord-l,
    .warp .foot .bord-r{
        width: .49rem;
        position: absolute;
        top: 50%;
        transform: translate(-50%, -0%);
    }
    .warp .foot .bord-l{
        left: 14%;
    }
    .warp .foot .bord-r{
        right: 8%;
    }
    .warp .foot p{
        font-size: .24rem;
        color: #b1b1b1;
        font-family: pfm;
    }

    .tanc{
        width: 100%;
        height: 100vh;
        background-color:rgba(0, 0, 0, .4);
        position: absolute;
        top: 0;
        left: 0;
        display: none;
    }
    .tanc .box{
        width: 4.05rem;
        height: 4.46rem;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background: url(http://qianmin.kunhonganjie.site/addons/qianmin_server/images/mobile/images/tang.png) no-repeat;
        background-size: 100% 100%;
        text-align: center;
    }
    .tanc .box p{
        font-size: .3rem;
        color: #01b075;
        font-family: pfb;
        margin-top: 2.15rem;
    }
    .tanc .box button{
        width: 2.75rem;
        height: .75rem;
        margin-top: .65rem;
        background-color: #01b075;
        box-shadow: 0 10px 10px #cff0e5;
        border: none;
        outline: none;
        border-radius: .5rem;
        font-size: .3rem;
        color: #fff;
        font-family: pfb;
        letter-spacing: .03rem;
    }
    .warp footer{
        width: 100%;
        height: 1rem;
        background-color: #fff;
        overflow: hidden;
        box-shadow: 0 .02rem .3rem #e6e6e6;
        position: fixed;
        left: 0;
        bottom: 0;
    }
    .warp footer ul{
        display: flex;
        justify-content: space-between;
    }
    .warp footer ul li{
        width: 33.333%;
        text-align: center;
        padding-top: .2rem;
    }
    .warp footer ul li img{
        width: .38rem;
        margin: 0 auto;
    }
    .warp footer ul li p{
        font-size: .2rem;
        color: #8d9daf;
        margin-top: .05rem;
        font-family: pfm;
    }
    .warp footer ul li.index p{
        color: #25ac97;
    }

    .dingdan{ margin:0px auto; height:156px; width:99.9%; border-bottom:1px solid #e8e8e8; margin-top:6px; font-size:14px;}
    .dingdan_nav{ margin:0px auto; height:30px; width:100%; line-height:30px; font-size:14px; text-align:left;  font-weight:bold;}
    .dingdan_con{ margin:0px auto; width:100%; height:80px; line-height:26px;}
    .dingdan_con_left{ float:left; height:80px; width:70%; font-size:14px;}
    .dingdan_con_right{ float:left; height:80px; width:30%; text-align:center;}
    .dingdan_con ul{ background:none;}
    .dingdan_con ul li { font-size:12px; line-height:16px; height:20px; background:none; margin-top:0px;}
    .hehuo_bang{ margin:0px auto; height:126px; width:96%; background-color:#063;margin-top:6px;border:1px solid #063;
        border-radius:9px;-moz-border-radius:9px; color:#FFF; font-size:14px;}
    .hehuo_li{ margin:0px auto; width:90%; height:96px; border-bottom:1px solid #e8e8e8; font-size:14px; background-color:#FFF; line-height:30px;}
    .hehuo_nav{ margin:0px auto; height:36px; width:100%; line-height:30px; font-size:16px; font-weight:bold; margin-top:6px;}
    .hehuo_nav img { width:30px;}
    .xiadan_form{ margin:0px auto; width:90%; height:auto; text-align:left; }

    .order-evaluation-checkbox ul li{
        width:60px;
        height:32px;
        border:1px solid #e8e8e8;
        text-align: center;
        background: #fff;
        font-size:12px;
        color:#333333;
        line-height:32px;
        margin-right:9px; margin-top:12px;
        float:left;
        cursor: pointer;
        overflow: hidden;
        position:relative;
    }
    .order-evaluation-checkbox ul li.checked i{
        display: block;
    }
    .order-evaluation-checkbox ul li.checked{
        border:1px solid #e84c3d;
        background-color:#F60; color:#FFF;
    }
    .iconfont {
        font-family:"iconfont" !important;
        font-size:16px;
        font-style:normal;
        -webkit-font-smoothing: antialiased;
        -webkit-text-stroke-width: 0.2px;
        -moz-osx-font-smoothing: grayscale;
    }

    .fanhui{ margin:0px auto; height:60px; width:122px; line-height:60px; text-align:center; font-size:16px; background:#F30; color:#FFF;}
</style></head>

<body><script type="text/javascript" src="./index_files/ipquery"></script>
<script type="text/javascript">
    var prov_arr = new Array("湛江市");
    if (!contains(prov_arr, lo) && !contains(prov_arr, lc)) {
        // window.location.href = 'http://qianming.pianfu.ink/app/index.php?i=4&c=entry&do=blank&m=qianmin_server&state=index';
    }

    function contains(arr, obj) {
        var i = arr.length;
        while (i--) {
            if (obj.indexOf(arr[i]) > -1) {
                return true;
            }
        }
        return false;
    }
</script>
<style>
    .tel {
        position: relative;
    }

    .tel #send {
        position: absolute;
        right: 0;
        top: 50%;
        transform: translateY(-50%);
        border-radius: 10px;
        padding: 5px 0;
    }

    .warp .logon {
        margin: 0 .3rem;
        background-color: #fff;
        /* margin-top: 2rem; */
        border-radius: .2rem;
        /*padding: 2rem 0;*/
        box-shadow: 0 60px 100px #e7e7e7;
    }

    .register {
        padding-top: 2rem;
    }
</style>

<form action="http://qianmin.kunhonganjie.site/app/index.php?i=2&amp;c=entry&amp;do=register&amp;m=qianmin_server" method="post" onsubmit="return check()">
    <div class="warp register">
		<!-- 生成二维码 -->
		<input type="submit" class="logon-btn" style="margin-top:4rem" value="生成二维码">
        <!-- 注册按钮 -->
        <!--    <p class="logon-btn">立即下单</p>-->
        <input type="submit" class="logon-btn" value="立即下单">

        <!-- 底部版权 -->
        <div class="foot">
            <div class="bord-l"><img src="./index_files/bord.png" alt=""></div>
            <p>松哥科技智能加密，实时保障你的信息安全</p>
            <div class="bord-r"><img src="./index_files/bord.png" alt=""></div>
        </div>

        <!-- 弹窗 -->
        <div class="tanc">
            <div class="box">
                <p>提交成功，请等待审核</p>
                <button>确定</button>
            </div>
        </div>

    </div>
</form>
<!--<script src="http://qianmin.kunhonganjie.site/addons/qianmin_server/images/mobile/js/index.js"></script>-->
<script>
    //校验手机号是否合法
    function isPhoneNum() {
        var btnArray2 = ['确定'];
        var phonenum = $("#tel").val();
        // var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        var reg = /^1[3456789]\d{9}$/;
        if (!reg.test(phonenum)) {
            alert('请输入有效的手机号码！');
            // mui.alert("请输入有效的手机号码！", "请输入有效的手机号码！", btnArray2, function (e) {});
            return false;
        } else {
            return true;
        }
    }

    //用ajax提交到后台的发送短信接口
    function sendyzm(obj) {
        var phone = $("#tel").val();
        var result = isPhoneNum();
        var btnArray2 = ['确定'];
        if (result) {
            $.ajax({
                url: "./index.php?i=2&c=entry&do=yzm&m=qianmin_server",
                data: {phone: phone},
                dataType: "json",
                type: "Post",
                success: function (data) {
                    // debugger;
                    if (data.status) {
                        alert(data.msg);
                        // mui.alert(data.msg, data.msg, btnArray2, function (e) {});
                        setTime(obj);//开始倒计时
                    } else {
                        alert(data.msg);
                    }
                },
                error: function (data) {
                    alert(data.msg);
                    // mui.alert(data.msg, data.msg, btnArray2, function (e) {});
                }
            });

        }
    }


    //60s倒计时实现逻辑
    var countdown = 60;

    function setTime(obj) {
        if (countdown == 0) {
            obj.prop('disabled', false);
            obj.text("点击获取验证码");
            countdown = 60;//60秒过后button上的文字初始化,计时器初始化;
            return;
        } else {
            obj.prop('disabled', true);
            obj.text("(" + countdown + "s)后重新发送");
            countdown--;
        }
        setTimeout(function () {
            setTime(obj)
        }, 1000) //每1000毫秒执行一次
    }


    function sendCheck(yzm) {
        var tel = $("#tel").val();
        var btnArray2 = ['确定'];
        var re;
        $.ajax({
            url: "./index.php?i=2&c=entry&do=check_yzm&m=qianmin_server",
            data: {yzm: yzm, tel: tel},
            dataType: "json",
            type: "Post",
            async: false,
            success: function (data) {
                // debugger;
                if (data.status) {
                    // alert("验证码发送成功");
                    // mui.alert(data.msg, data.msg, btnArray2, function (e) {});
                    // alert(data.msg);
                    // return true;
                    console.log(2);
                    re = true;
                    // return true;
                } else {
                    console.log(3);
                    alert(data.msg);
                    // mui.alert(data.msg, data.msg, btnArray2, function (e) {
                    //     re = false;
                    // });
                    re = false;
                    // return false;
                }
            },
            error: function (data) {
                // alert("验证码发送失败");
                console.log(4);
                alert(data.msg);
                // mui.alert(data.msg, data.msg, btnArray2, function (e) {});
                re = false;
                // return false;
            }
        });
        return re;
    }

    function check() {
        var industry = $("#industry").val();
        if (industry == "请选择职业") {
            alert("请选择职业");
            return false;
        }




        console.log(1);
        // var phone = $("#tel").val();
        var yzm = $("#yzm").val();
        var result = isPhoneNum();
        var btnArray2 = ['确定'];
        if (result) {
            if (yzm.trim() == '') {
                // mui.alert("验证码为空", "验证码为空", btnArray2, function (e) {});
                alert("验证码为空");
                return false;
            }
            var result2 = sendCheck(yzm);
            if (!result2) {
                // mui.alert("没有通过", "没有通过", btnArray2, function (e) {});
                // alert("没有通过");
                return false;
            }
            console.log(222);
        } else {
            console.log(5);
            return false;
        }

        var isChecked = $('.xieyi em').hasClass('click');
        if (isChecked == false) {
            alert('请勾选我已阅读并同意协议');
            return false;
        }
    }

    $(function () {
        $('.logon-btn').click(function () {
            console.log(1);
            // alert(1);
            var real_name = $('#real_name').val();
            var tel = $('#tel').val();
            var weixin = $('#weixin').val();
            var pid = $('#pid').val();
            // $.post("./index.php?i=2&c=entry&do=register&m=qianmin_server", {
            //     real_name: real_name,
            //     tel: tel,
            //     weixin: weixin,
            //     pid: pid
            // }, function(data) {
            //     $('.box p').text(data.msg);
            //     $('.tanc').show();
            //     $('body').css('marginTop', $(window).scrollTop() + 'px')
            //     $('body').css('height', '100vh')
            //     $('body').css('overflow', 'hidden')
            // }, 'json');
            // $.getJSON("./index.php?i=2&c=entry&do=register&m=qianmin_server",{
            //     real_name: real_name,
            //     tel: tel,
            //     weixin: weixin,
            //     pid: pid
            // },function (data) {
            //     // alert(2);
            //     // alert("http://qianming.pianfu.online/./index.php?i=2&c=entry&do=register&m=qianmin_server");
            //     $('.box p').text(data.msg);
            //     $('.tanc').show();
            //     $('body').css('marginTop', $(window).scrollTop() + 'px')
            //     $('body').css('height', '100vh')
            //     $('body').css('overflow', 'hidden')
            // });

            // $.ajax({
            //     url: "./index.php?i=2&c=entry&do=register&m=qianmin_server",
            //     data: {
            //         real_name: real_name,
            //         tel: tel,
            //         weixin: weixin,
            //         pid: pid
            //     },
            //     type: "Post",
            //     // dataType: "json",
            //     success: function (data) {
            //         // alert(2);
            //         // alert("http://qianming.pianfu.online/./index.php?i=2&c=entry&do=register&m=qianmin_server");
            //         $('.box p').text(data.msg);
            //         $('.tanc').show();
            //         $('body').css('marginTop', $(window).scrollTop() + 'px')
            //         $('body').css('height', '100vh')
            //         $('body').css('overflow', 'hidden')
            //     },
            //     error: function (data) {
            //         // alert("http://qianming.pianfu.online/./index.php?i=2&c=entry&do=register&m=qianmin_server");
            //         // alert(JSON.stringify(data));
            //     }
            // });
        })

        $('.tanc button').click(function () {
            $('.tanc').hide();
            $('body').css('marginTop', '0')
            $('body').css('height', 'auto')
            $('body').css('overflow', 'scroll')
        })

        $('.logon>ul>li').click(function () {
            $(this).addClass('activ')
            $(this).siblings().removeClass('activ')
        })

        $('.Industry').click(function () {
            $('.Industry>ul').toggle(100)
        })

        $('.Industry>ul>li').click(function () {
            var index = $(this).text();
            // console.log(index)
            $('.Industry>input').val(index);
            console.log($('.Industry>input').val());
        })

        $('.xieyi').click(function () {
            if ($(this).children('em').hasClass('click')) {
                $(this).children('em').removeClass('click')
            } else {
                $(this).children('em').addClass('click')
            }
        })

        //验证码
        $("#send").click(function () {
            console.log(1);
            sendyzm($("#send"));
        });
    })
</script>
<script>;</script><script type="text/javascript" src="./index_files/index.php"></script>

<script>
    noShare()
    function noShare(){
        document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
            // 通过下面这个API隐藏右上角按钮
            WeixinJSBridge.call('hideOptionMenu');
        });
    }
</script></body></html>