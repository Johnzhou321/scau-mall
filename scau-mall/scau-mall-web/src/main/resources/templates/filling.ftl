<!DOCTYPE html>
<!-- saved from url=(0124)http://qianming.pianfu.online/app/index.php?i=4&c=entry&do=xiadan&m=qianmin_server&goods_id=12&uid=20&wxref=mp.weixin.qq.com -->
<html style="font-size: 95.1111px;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title></title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <link href="/index_files/public.css" rel="stylesheet" type="text/css">
    <link href="/index_files/style.css" rel="stylesheet" type="text/css">
    <script src="/index_files/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="/index_files/mui.min.js"></script>
    <script type="text/javascript">
        (function (d) {
            function e() {
                var a = c.getBoundingClientRect().width;
                750 < a && (a = 750);
                a = a / 750 * 100;
                c.style.fontSize = a + "px";
                var b = parseFloat(window.getComputedStyle(document.documentElement)["font-size"]);
                b !== a && 0 < b && 1 < Math.abs(b - a) && (c.style.fontSize = a * a / b + "px")
            }

            var c = d.document.documentElement, f;
            d.addEventListener("resize", function () {
                clearTimeout(f);
                f = setTimeout(e, 100)
            }, !1);
            e()
        })(window);
    </script>
</head>

<body><style>
    .tel{
        position: relative;
    }
    .tel #send{
        position: absolute;
        right: 0;
        top: 50%;
        transform: translateY(-50%);
        border-radius: 10px;
        padding: 5px 0;
    }
</style>
<form onsubmit="return check()">
<input type="hidden" name="goods_id" value="12">
<input type="hidden" name="uid" value="20">
<input type="hidden" name="type" value="0">
<div class="warp hall">
        <!--  不是其他类型  -->
    <div class="conter">
                <img src="/index_files/duYu9uqWweu1HoBqgwefuukxbT0e0B.png">
                <br>
        <p style="margin:0px auto; width:100%; text-align:center; line-height:30px; font-size:14px; border-bottom:1px solid #CCC;">
            最高额度可达（元）<br>
            <span style="color:#F63; font-size:32px; font-weight:bold;"> 300000</span>
            <br>
            <span style="color:#CCC; font-size:12px;">快速放款&nbsp;&nbsp;  |&nbsp;&nbsp;  利息低 &nbsp;&nbsp; | &nbsp;&nbsp; 贷款期限长</span>
        </p>
        <div class="xiadan_form">
            <div class="logon" style="margin-top:0px; background:none;">
                <ul>
                    <p style=" color:#F90;">请输入正确信息，以方便你快速批款！</p>

                    
                    <li class="name">
                        <input type="text" name="name" id="name" placeholder="姓名">
                        <img class="yes" src="/index_files/yes.png" alt="" style="display: none;">
                    </li>
                    <li>
                        <input type="text" name="id_number" id="id_number" placeholder="身份证号码">
                        <img class="yes" src="/index_files/yes.png" alt="" style="display: none;">
                    </li>
                    <li class="tel">
                        <input type="text" name="telephone" id="telephone" placeholder="电话">
                        <img class="yes" src="/index_files/yes.png" alt="" style="display: none;">
                                                <!-- <button id="send" type="button"> 
                            获取验证码
                        </button>-->
                                           <!--  </li>
                                        <li>
                        <input id="yzm" type="text" class="mui-input-clear" placeholder="请输入验证码">
                    </li> -->
                                        <li>
                        <input type="text" name="amount" id="amount" placeholder="资金需求（元）">
                        <img class="yes" src="/index_files/yes.png" alt="" style="display: none;">
                    </li><br>
                    请选择你符合的资质（多选）：<br>
                    <input type="hidden" name="qualification" id="qualification" value="">
                    <div class="order-evaluation-checkbox">
                        <ul class="clearfix">
                            <li class="order-evaluation-check" data-impression="1">公积金 </li>
                            <li class="order-evaluation-check" data-impression="2">保单 </li>
                            <li class="order-evaluation-check" data-impression="3">房贷 </li>
                            <li class="order-evaluation-check" data-impression="4">代发工资 </li>
                            <li class="order-evaluation-check" data-impression="5">营业执照 </li>
                            <li class="order-evaluation-check" data-impression="6">车贷 </li>
                            <li class="order-evaluation-check" data-impression="7">全款房 </li>
                            <li class="order-evaluation-check" data-impression="8">全款车 </li>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </ul>
            </div>
        </div>
        <input type="button" class="logon-btn" id="submitBtn" value="立即申请">
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
<!--<script type="text/javascript" src="http://qianming.pianfu.online/addons/qianmin_server/images/mobile/js/jquery.min.js"></script>-->
<!--<script src="http://qianming.pianfu.online/addons/qianmin_server/images/mobile/js/index.js"></script>-->
<script>
    //校验手机号是否合法
    function isPhoneNum(){
        var btnArray2 = ['确定'];
        var phonenum = $("#telephone").val();
        var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if(!reg.test(phonenum)){
            alert('请输入有效的手机号码！');
            // mui.alert("请输入有效的手机号码！", "请输入有效的手机号码！", btnArray2, function (e) {});
            return false;
        }else{
            return true;
        }
    }

    function check(){
        var name = $("#name").val();
        var sfz = $("#id_number").val();
        var tel = $("#telephone").val();
        var amount = $("#amount").val();
        if(name.trim() == ''){
            alert('姓名不能为空');
            return false;
        }
        if(sfz.trim() == ''){
            alert('身份证不能为空');
            return false;
        }
        if(tel.trim() == ''){
            alert('电话不能为空');
            return false;
        }else{
            if(!isPhoneNum()){
                return false;
            }
        }
        if(amount < 10000){
            alert('资金填写单位为元，请正确填写');
            return false;
        }

                var yzm = $("#yzm").val();
        if(yzm.trim() == ''){
            alert('验证码不能为空');
            return false;
        }/**else{
            var yzmCheck = sendCheck(yzm);
            if (!yzmCheck){
                alert('验证码不正确');
                return false;
            }
        }*/
        
    }
    $(function () {
        // $('.logon-btn').click(function () {
        //     console.log(1);
        //     var goods_id = $('#goods_id').val();
        //     var name = $('#name').val();
        //     var sfz = $('#sfz').val();
        //     var tel = $('#tel').val();
        //     var amount = $('#amount').val();
        //     var qualification = $('#qualification').val();
        //     $.ajax({
        //         url: "./index.php?i=4&c=entry&do=order_add&m=qianmin_server",
        //         data: {
        //             goods_id: goods_id,
        //             name: name,
        //             sfz: sfz,
        //             tel: tel,
        //             amount: amount,
        //             qualification: qualification
        //         },
        //         type: "Post",
        //         dataType: "json",
        //         success: function (data) {
        //             $('.box p').text(data.msg);
        //             $('.tanc').show();
        //             $('body').css('marginTop', $(window).scrollTop() + 'px')
        //             $('body').css('height', '100vh')
        //             $('body').css('overflow', 'hidden')
        //         }
        //     });
        // })
        $("#submitBtn").click(function(){
        	var formdata = $("form").serialize();
            var jsonData = JSON.stringify(formdata);
            $.ajax({
            	type: "POST",
                url: "/api/v1/customer/add",
                data: formdata,
                //dataType: "json",
                //contentType: 'application/json',
                success: function (data) {
                    $('.tanc').show();
                    $('body').css('marginTop', $(window).scrollTop() + 'px')
                     $('body').css('height', '100vh')
                    $('body').css('overflow', 'hidden')
                    if (data.code == 0) {
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
            console.log(index)
            $('.Industry>input').val(index);
        })

        $('.xieyi').click(function () {
            if ($(this).children('em').hasClass('click')) {
                $(this).children('em').removeClass('click')
            } else {
                $(this).children('em').addClass('click')
            }
        })
    })
</script>
<script type="text/javascript">

    $(".block li").hover(function(e) {
    }, function() {
        var index = $(this).attr("data-default-index");//点击后的索引
        index = parseInt(index);
        console.log("index",index);
        $(".level").html(byIndexLeve(index-1));
        console.log(byIndexLeve(index-1));
        $(".order-evaluation ul li:eq(0)").find("img").attr("src","img/x1.png");
        for (var i=0;i<index;i++){

            $(".order-evaluation ul li:eq(0)").find("img").eq(i).attr("src","img/x2.png");
        }
    })
    $(".block li").find("img").click(function() {
        var obj = $(this);
        var li = obj.closest("li");
        var star_area_index = li.index();
        var index1 = obj.index();
        li.attr("data-default-index", (parseInt(index1)+1));
        var index = $(".block li").attr("data-default-index");//点击后的索引
        index = parseInt(index);
        console.log("index",index);
        $(".level").html(byIndexLeve(index-1));
        console.log(byIndexLeve(index-1));
        $(".order-evaluation ul li:eq(0)").find("img").attr("src","img/x1.png");
        for (var i=0;i<index;i++){
            $(".order-evaluation ul li:eq(0)").find("img").eq(i).attr("src","img/x2.png");
        }

    });

    var checkedList = [];
    //印象
    $(".order-evaluation-check").click(function(){
        if($(this).hasClass('checked')){
            //当前为选中状态，需要取消
            $(this).removeClass('checked');
            var i = $(this).attr('data-impression');
            checkedList = checkedList.filter(function(item) {
                return item != i;
            });
        }else{
            //当前未选中，需要增加选中
            $(this).addClass('checked');
            checkedList.push($(this).attr('data-impression'));
            checkedList.sort();
        }
        console.log(checkedList);
        var newArr = checkValue(checkedList);
        console.log(newArr);
        $('#qualification').val(newArr.join(','));
    });

    function checkValue(arr1) {
        var arr = [];
        arr[1] = "公积金";
        arr[2] = "保单";
        arr[3] = "房贷";
        arr[4] = "代发工资";
        arr[5] = "营业执照";
        arr[6] = "车贷";
        arr[7] = "全款房";
        arr[8] = "全款车";
        var newArr = [];
        arr1.forEach(function (item) {
            newArr.push(arr[item]);
        });
        return newArr;
    }

</script>

<script>


    //用ajax提交到后台的发送短信接口
    function sendyzm(obj){
        var phone = $("#telephone").val();
        var result = isPhoneNum();
        var btnArray2 = ['确定'];
        if(result) {
            $.ajax({
                url:"./index.php?i=4&c=entry&do=yzm_other&m=qianmin_server",
                data: {phone: phone},
                dataType: "json",
                type: "Post",
                success: function(data){
                    // debugger;
                    if(data.status){
                        alert("验证码发送成功");
                        // mui.alert(data.msg, data.msg, btnArray2, function (e) {});
                    }else{

                    }
                },
                error: function(data){
                    alert("验证码发送失败");
                    // mui.alert(data.msg, data.msg, btnArray2, function (e) {});
                }
            });
            setTime(obj);//开始倒计时
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
            obj.text("("+countdown+"s)后重新发送") ;
            countdown--;
        }
        setTimeout(function() { setTime(obj) },1000) //每1000毫秒执行一次
    }

    function sendCheck(yzm) {
        var btnArray2 = ['确定'];
        var phone = $("#telephone").val();
        var re;
        $.ajax({
            url:"./index.php?i=4&c=entry&do=check_yzm_other&m=qianmin_server",
            data: {yzm: yzm, phone: phone},
            dataType: "json",
            type: "Post",
            async: false,
            success: function(data){
                // debugger;
                if(data.status){
                    // alert("验证码发送成功");
                    // mui.alert(data.msg, data.msg, btnArray2, function (e) {});
                    // alert(data.msg);
                    // return true;
                    // console.log(2);
                    re = true;
                    // return true;
                }else{
                    // console.log(3);
                    // alert(data.msg);
                    // mui.alert(data.msg, data.msg, btnArray2, function (e) {
                    //     re = false;
                    // });
                    re = false;
                    // return false;
                }
            },
            error: function(data){
                // alert("验证码发送失败");
                // console.log(4);
                // alert(data.msg);
                // mui.alert(data.msg, data.msg, btnArray2, function (e) {});
                re = false;
                // return false;
            }
        });
        return re;
    }

    $(function () {
        //验证码
        $("#send").click(function (){
            console.log(1);
            sendyzm($("#send"));
        });
    })
</script>
<script>;</script><script type="text/javascript" src="/index_files/index.php"></script>

<script>
    noShare()
    function noShare(){
        document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
            // 通过下面这个API隐藏右上角按钮
            WeixinJSBridge.call('hideOptionMenu');
        });
    }
</script></body></html>