<!DOCTYPE html>
<!-- saved from url=(0160)http://admin.xiangrikui.com:6954/oauth/show?response_type=code&client_id=ldap-accounts&redirect_uri=http://admin.xiangrikui.com:6954/admin/oauth_redirect&state= -->
<html style="font-size: 100px;" lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/show_files/bootstrap.min.css">
<link rel="stylesheet" href="/show_files/login.css">
<script type="text/javascript" src="/show_files/jquery-1.11.0.js"></script>
<script type="text/javascript" src="/show_files/login.js"></script>
<script type="text/javascript" src="/common.js"></script>
</head><body>
 <div class="container">
<div class="jumbotron" style="background-color:#fff;">
 <div class="center-block" style="">
		<h2>请使用自己的账号登录, 不能借用他人账号
		<br>
		<br>
		初次登陆或忘记密码，请点<a href="#" target="_blank">找回密码</a>
		</h2>
		<br>
		<div class="well">
		有问题请联系运维值（QQ:819291943, 手机:15217976491）
		</div>
	</div>
</div>
      <form class="form-signin" action="/login/submit" method="post">
        <h2 class="form-signin-heading">登录<small>账号管理</small></h2>
        <input type="hidden" name="client_id" value="ldap-accounts">
		<input type="hidden" name="response_type" value="code">
		<input type="hidden" name="redirect_uri" value="http://admin.xiangrikui.com:6954/admin/oauth_redirect">
		<input type="hidden" name="state" value="">
        <label for="username" class="sr-only">Email address</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" autofocus="">
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
	
    </div> <!-- /container -->


</body></html>