<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  


</head>
<body>
user

 <div> 
    <div class="panel panel-default">
    <div class="panel-body">
    <div id="searchDiv" class="col-xs-12 col-sm-12"> 
    	 <div class="form-group col-sm-3">
		   <label for="userName">新闻标题：</label>
		   <input type="text" class="form-control" id="userName" 
				   placeholder="新闻标题">
	    </div>
	    <div class="form-group col-sm-3">
		   <label for="newsType">类型：</label>
		  <select name="size" class="form-control" id="newsType">
		  		<option value="">----</option>
		  </select>
	    </div>	     
	     <div class="form-group col-sm-3">
	     	<label for="name">开始时间：</label>
 			<script src="<%=request.getContextPath()%>/static/My97DatePicker/WdatePicker.js" type="text/javascript"></script>   
	   		 <input onclick="WdatePicker()" type="text" id="startTime" class="form-control" placeholder="开始时间" required autofocus> 
    	</div>
    	 <div class="form-group col-sm-3">
	     	<label for="name">结束时间：</label>
 			<script src="<%=request.getContextPath()%>/static/My97DatePicker/WdatePicker.js" type="text/javascript"></script>   
	   		 <input onclick="WdatePicker()" type="text" id="endTime" class="form-control" placeholder="结束时间" required autofocus> 
    	</div>
    	<button   class="btn btn-default    " onclick="paginationNews();"> 查询</button>
    	<button   class="btn btn-default    " onclick="resetAll();"> 重置</button>
    	<a class="btn btn-default    " href="jspView?jsp=cms/news/news_edit">新增</a>
    </div>
      </div>
	
</div>
		<table  class="table table-hover" >
		   <caption>用户列表</caption>
	<thead>
		<tr>
			<th >用户名称</th>
			<th >登录账号</th>
			<th>手机号</th>
			<th>邮箱</th>
			<th>创建时间</th>
			<th>修改时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody id="tb1"> </tbody>
    </table>
		<ul id='bp-element' class="col-xs-12 col-sm-12" ></ul>
	</div>
	<script src="<%=request.getContextPath()%>/static/js/bootstrap-paginator.js" ></script>
	<script type="text/javascript">
	$(function(){ 
		paginationNews();
	}); 
	//获取新闻并分页
	function paginationNews(){
		$.ajax({
			url:'user_selectUserNPBySearch',
			data:{
				page:0,
				rows:5,
				userName:$("#userName").val(),
				startTime:$("#startTime").val(),
				endTime:$("#endTime").val()
	         },
			dataType:'json',
			type:'post',
			success:function(data){
				var resultData1=data;
				makePage(resultData1);
				var resultData=data.rows;
				makeNewsTable(resultData);
				 
	 		},
	 		error:function(data){
	 			alert('提交失败');
			}
		});
	}
	
	
	
	//生成底部分页
	function makePage(resultData){
		var element = $('#bp-element');
        options = {
            bootstrapMajorVersion:3, //对应的bootstrap版本
            currentPage: resultData.pageNo, //当前页数，这里是用的EL表达式，获取从后台传过来的值
            size:"large",//设置控件的显示大小，是个字符串. 允许的值: mini, small, normal,large。值：mini版的、小号的、正常的、大号的。
            numberOfPages: 10, //每页页数
            totalPages:resultData.total/5+1, //总页数，这里是用的EL表达式，获取从后台传过来的值
            shouldShowPage:true,//是否显示该按钮
            itemTexts: function (type, page, current) {//设置显示的样式，默认是箭头
                switch (type) {
                    case "first":
                        return "首页";
                    case "prev":
                        return "上一页";
                    case "next":
                        return "下一页";
                    case "last":
                        return "末页";
                    case "page":
                        return page;
                }
            },
            //点击事件
            onPageClicked: function (event, originalEvent, type, page) {
            	$.ajax({
        			url:'user_selectUserNPBySearch',
        			data:{
        				page:page,
        				rows:5,
        				userName:$("#userName").val(),
        				startTime:$("#startTime").val(),
        				endTime:$("#endTime").val()
        	         },
        			dataType:'json',
        			type:'post',
        			success:function(data){
        				var resultData=data.rows;
        				makeNewsTable(resultData);
        	 		},
        	 		error:function(data){
        	 			alert('提交失败');
        			}
        		});
                
            
            }
        };
        element.bootstrapPaginator(options);
	}
	//新闻置顶
	 function cms_CmsNews_to_top(newsId){
		 $.ajax({
				url:'cms_CmsNews_update',
				data:{
					newsId:newsId 
		         },
				dataType:'json',
				type:'post',
				success:function(data){
					paginationNews();
		 		},
		 		error:function(data){
		 			alert('提交失败');
				}
			});
	 }
	 //新闻放入回收站
	 function cms_CmsNews_noshow(newsId){
		 $.ajax({
				url:'cms_CmsNews_update',
				data:{
					newsId:newsId,
					isShow:"no"
		         },
				dataType:'json',
				type:'post',
				success:function(data){
					paginationNews();
		 		},
		 		error:function(data){
		 			alert('提交失败');
				}
			});
	 }
	function makeNewsTable(resultData){
		var str=""
		for(var i=0;i<resultData.length;i++){
			str+="<tr>";
			str+="<td>"+resultData[i].userName+"</td>";
			str+="<td>"+resultData[i].loginName+"</td>";
			str+="<td>"+resultData[i].createTime+"</td>";
			str+="<td>"+resultData[i].updateTime+"</td>";
			str+="<td><button type=\"button\" class=\"btn btn-info btn-sm\" onclick=\"cms_CmsNews_noshow('"+resultData[i].newsId+"');\">删除</button> ";
			str+=" <button type=\"button\" class=\"btn btn-info btn-sm\" onclick=\"cms_CmsNews_to_top('"+resultData[i].newsId+"');\">置顶</button> "; 
			str+=" <button type=\"button\" class=\"btn btn-info btn-sm\" onclick=\"cms_CmsNews_editById('"+resultData[i].newsId+"');\">编辑</button> "; 
			str+=" <button type=\"button\" class=\"btn btn-info btn-sm\" onclick=\"cms_CmsNews_editImgById('"+resultData[i].newsId+"');\">替换导航图片</button>"; 
			str+=" <button type=\"button\" class=\"btn btn-info btn-sm\" onclick=\"cms_CmsNews_viewById('"+resultData[i].newsId+"');\">详情查看</button></td>"; 
			str+="<tr>";
		}
		$("#tb1").empty();
		$("#tb1").append(str);
	}
	//重置清空input的值
	function resetAll(){
		$("#userName").val(null);
		$("#startTime").val(null);
		$("#endTime").val(null);
	}
	//详情查看界面的跳转
	function cms_CmsNews_viewById(newsId){
		location.href="cms_CmsNews_viewById?newsId="+newsId;
	}
	function cms_CmsNews_editById(newsId){
		location.href="cms_CmsNews_editById?newsId="+newsId;
	}
	function cms_CmsNews_editImgById(newsId){
		location.href="cms_CmsNews_editImgById?newsId="+newsId;
	}

		</script>


</body>
</html>