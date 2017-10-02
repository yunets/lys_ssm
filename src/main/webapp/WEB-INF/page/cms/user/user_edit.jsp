<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
user





<!-- <form class="form-horizontal" role="form"  > -->

    <div class="form-group col-sm-12">
		<label for="loginName">登录账号：</label>
		<input type="text" class="form-control" id="loginName" 
				   placeholder="登录账号">
	</div>
	<div class="form-group col-sm-12">
		<label for="loginPwd">登录密码：</label>
		<input type="text" class="form-control" id="loginPwd" 
				   placeholder="登录密码">
	</div>
	<div class="form-group col-sm-12">
		<label for="userName">姓名：</label>
		<input type="text" class="form-control" id="userName" 
				   placeholder="姓名">
	</div>
	 
	<div class="form-group col-sm-12">
		<label for="userTelephone">手机号码：</label>
		<input type="text" class="form-control" id="userTelephone" 
				   placeholder="手机号码">
	</div> 
	
	<div class="form-group col-sm-12">
		<label for="userEmail">邮箱地址：</label>
		<input type="text" class="form-control" id="userEmail" 
				   placeholder="邮箱地址">
	</div> 
  
 
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button   class="btn btn-default" onclick="user_insert();">提交</button>
			<button type="submit" class="btn btn-default">取消</button>
		</div>
	</div>
<!-- </form> -->


<script type="text/javascript">
function user_insert(){
		$.ajax({
			url:'user_insert',
			data:{
				loginName:$("#loginName").val(),
				loginPwd:$("#loginPwd").val(),
				userName:$("#userName").val(),
				userTelephone:$("#userTelephone").val(),
				userEmail:$("#userEmail").val() 
	         },
			dataType:'json',
			type:'post',
			success:function(data){
				 
				alert('提交成功');
				 
	 		},
	 		error:function(data){
	 			alert('提交失败');
			}
		});
	
}

</script>


</body>
</html>