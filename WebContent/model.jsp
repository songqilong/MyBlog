<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->

  </head>
  <body>
  
  
  
    	<!--顶级div start-->
	<div id="calendar" class="container" style="width:300px;height:300px;background-color:#00CED1;">
		<!--第一行div start-->
		<div style="width:100%">
			<div id="cal_year_minus" style="width:16%;float:left;">&lt;&lt;</div> 
			<div id="cal_year" style="width:20%;float:left;"></div>
			<div id="cal_year_plus" style="width:16%;float:left;">&gt;&gt;</div>
			 <div id="cal_month_minus" style="width:16%;float:left;">&lt;&lt;</div> 
			 <div id="cal_month" style="width:16%;float:left;"></div>
			 <div id="cal_month_plus" style="width:16%;float:left;">&gt;&gt;</div>
		</div>
		<!--第一行div end-->
		<hr>
		<!--第二行div start-->
		<div style="width:100%;">
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">周日</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">周一</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">周二</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">周三</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">周四</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">周五</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">周六</div>
		</div>
		<!--第二行div end-->
		<hr>
		<!--第三行div start-->
		<div id="cal_days" style="width:100%;">
		<!-- 
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">1</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">2</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">3</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">4</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">5</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">6</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">7</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">8</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">9</div>
			<div style="width:13%;float:left;;text-align=center;background:#F0FFFF;margin:1px;">10</div> -->
		</div>
		<!--第三行div end-->
	</div>
    <!--顶级div end-->

<script type="text/javascript">
var date = new Date();
var year = date.getFullYear(); //获取完整的年份(4位,1970-????)
var month = date.getMonth()+1;  //获取当前月份(0-11,0代表1月)
var day = date.getDate(); //获取当前日(1-31)
//var weekdays = date.getDay(); //获取当前星期X(0-6,0代表星期天)
//var hour =date.getHours();       //获取当前小时数(0-23)
//var minute = date.getMinutes();     //获取当前分钟数(0-59)
//var second = date.getSeconds();     //获取当前秒数(0-59)
var weekday = WeekdayOfFristDay(year,month-1);
var days = DaysOfMonth(year,month);
$(function(){
	      var $year = $("#cal_year");
		  var $month = $("#cal_month");
		  var $day = $("#cal_days");
		  // 显示年份
		  $year.text(year);
		  // 显示月份
		  $month.text(month);
		  // 显示日期
		  for(var i=0;i<days+weekday;i++){
			  if(i<weekday){
				  $day.append("<div class=\"cal_day\" style=\"width:13%;float:left;text-align=center;background:#F0FFFF;margin:1px;\"><\/div>");  
			  }else if((currentDate= i+1-weekday)==day){
				  $day.append("<div class=\"cal_day\" style=\"width:13%;float:left;text-align=center;margin:1px;\">"+currentDate+"<\/div>"); 
			  }else{
				  $day.append("<div class=\"cal_day\" style=\"width:13%;float:left;text-align=center;background:#F0FFFF;margin:1px;\">"+currentDate+"<\/div>"); 
			  }			  
		  }
		  // 年份递减
		  $("#cal_year_minus").bind("click",function(){
			  var y = $year.text();	
			  var m = $month.text();
			  if(y == 1970){
				  $year.text(1970);
			  }else{
				  y--;
				  $year.text(y);
			  }
			  SetDate(y,m,day);
			  return false;
		});

		// 年份递增
		$("#cal_year_plus").click(function(){
			var y = $year.text();
			var m = $month.text();			
			y++;
			$year.text(y);
			SetDate(y,m,day);
			return false;
		}); 
		
		// 月份递减
		$("#cal_month_minus").click(function(){
			var m = $month.text();
			if(m ==1){
				$month.text(1);
			}else{
				m--;
				$month.text(m);
			}
			return false;
		});
		// 月份递增
		$("#cal_month_plus").bind("click",function(){
			var m = $month.text();
			if(m == 12){
				$month.text(12);
			}else{
				m++;
				$month.text(m);
			}
			return false;
		});

	});



// 对日历显示进行处理

  function WeekdayOfFristDay(year,month){
	  var d = new Date(year,month,1);
	  //alert(d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+"   "+d.getDay());
	  return d.getDay();
  }

  
  // 获取指定月份为多少天
  function DaysOfMonth(year,month){	  
	  var days;
	  switch(parseInt(month)){
	  case 1:
	  case 3:
	  case 5:
	  case 7:
	  case 8:
	  case 10:
	  case 12: 
		  days = 31;
		  break;
	  case 4:
	  case 6:
	  case 9:
	  case 11:
		  days = 30;
		  break;
	  case 2:
		  if(((year%4==0)&&(year%100!=0))||(year%400==0)){
			  days=29;
		  }else{
			  days = 28;
		  }
		  break;		  
	  }
	  return days;
  }
  
  function SetDate(year,month,day){
		var $d = $(".cal_day");	
		var $day = $("#cal_days");
		$d.remove();
		var weekday = WeekdayOfFristDay(year,month-1);
		var days = DaysOfMonth(year,month);
		alert(year+"年"+month+"月"+day+"日，星期"+weekday+"，本月"+days+"天");
		 for(var i=0;i<days+weekday;i++){
			  if(i<weekday){
				  $day.append("<div class=\"cal_day\" style=\"width:13%;float:left;text-align=center;background:#F0FFFF;margin:1px;\"><\/div>");  
			  }else if((currentDate= i+1-weekday)==day){
				  $day.append("<div class=\"cal_day\" style=\"width:13%;float:left;text-align=center;margin:1px;\">"+currentDate+"<\/div>"); 
			  }else{
				  $day.append("<div class=\"cal_day\" style=\"width:13%;float:left;text-align=center;background:#F0FFFF;margin:1px;\">"+currentDate+"<\/div>"); 
			  }			  
		  }
	}
</script>
  </body>
</html>