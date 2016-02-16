var date = new Date();
var year = date.getFullYear(); // 获取完整的年份(4位,1970-????)
var month = date.getMonth() + 1; // 获取当前月份(0-11,0代表1月)
var day = date.getDate(); // 获取当前日(1-31)
// var weekdays = date.getDay(); //获取当前星期X(0-6,0代表星期天)
// var hour =date.getHours(); //获取当前小时数(0-23)
// var minute = date.getMinutes(); //获取当前分钟数(0-59)
// var second = date.getSeconds(); //获取当前秒数(0-59)
var weekday = WeekdayOfFristDay(year, month - 1); //指定年月的第一天的星期
var days = DaysOfMonth(year, month); // 指定年月为多少天
$(function() {
	var $calendar = $("#calendar"); // 日历组件顶层元素
	var parentWidth = $calendar.parent().width();  //日历组件父元素的宽度
	var parentHeight = $calendar.parent().height(); // 日历组件父元素的高度
	$calendar.css({"width":parentWidth+"px","height":"300px","background-color":"#FFFFFF"});
	$calendar
	.append("<div id=\"year_month\" style=\"width:100%;height:12%;text-align:center;margin:1px;padding-top:5%;\"><\/div>")
	.append("<hr>")
	.append("<div id=\"week\" style=\"width:100%;height:12%;\"><\/div>")
	.append("<div id=\"cal_days\" style=\"width:100%;height:72%;\"><\/div>");
	$("#year_month")
	.append("<div id=\"cal_year_minus\" ><span class=\"glyphicon glyphicon-chevron-left\"></span><\/div>")
	.append("<div id=\"cal_year\"><\/div>")
	.append("<div id=\"cal_year_plus\"><span class=\"glyphicon glyphicon-chevron-right\"></span><\/div>")
	.append("<div id=\"cal_month_minus\"><span class=\"glyphicon glyphicon-chevron-left\"></span><\/div> ")
	.append("<div id=\"cal_month\"></div>")
	.append("<div id=\"cal_month_plus\"><span class=\"glyphicon glyphicon-chevron-right\"></span><\/div>");
	$("#week")
	.append("<div>日</div>")
	.append("<div>一</div>")
	.append("<div>二</div>")
	.append("<div>三</div>")
	.append("<div>四</div>")
	.append("<div>五</div>")
	.append("<div>六</div>")
	// 设置年月元素下子元素的样式
	$("#year_month").children().css({"width":"16%","text-align":"center","float":"left","font-size":"1.5em"});
	// 设置星期标题元素下的子元素样式
	$("#week").children().css({"width":"13.5%","height":"100%","float":"left","text-align":"center","background":"#eee","margin":"1px","padding-top":"4%"});
	var $year = $("#cal_year");   // 年份显示的元素
	var $month = $("#cal_month"); // 月份显示的元素
	var $day = $("#cal_days"); // 显示日期的元素
	
	// 显示年份
	$year.text(year);
	// 显示月份
	$month.text(month);
	// 显示日期
	SetDate(year,month, day);
	
	// 年份递减
	$("#cal_year_minus").bind("click", function() {
		var y = $year.text();
		var m = $month.text();
		if (y == 1970) {
			$year.text(1970);
		} else {
			y--;
			$year.text(y);
		}
		SetDate(y, m, day);
		return false;
	});

	// 年份递增
	$("#cal_year_plus").click(function() {
		var y = $year.text();
		var m = $month.text();
		y++;
		$year.text(y);
		SetDate(y, m, day);
		return false;
	});

	// 月份递减
	$("#cal_month_minus").click(function() {
		var m = $month.text();
		var y = $year.text();
		if (m == 1) {
			$month.text(1);
		} else {
			m--;
			$month.text(m);
		}
		SetDate(y, m, day);
		return false;
	});
	// 月份递增
	$("#cal_month_plus").bind("click", function() {
		var m = $month.text();
		var y = $year.text();
		if (m == 12) {
			$month.text(12);
		} else {
			m++;
			$month.text(m);
		}
		SetDate(y, m, day);
		return false;
	});

});

// 获取指定年份下指定月份第一天为星期几
function WeekdayOfFristDay(year, month) {
	var d = new Date(year, month, 1);
	return d.getDay();
}

// 获取指定月份为多少天
function DaysOfMonth(year, month) {
	var days;
	switch (month) {
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
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			days = 29;
		} else {
			days = 28;
		}
		break;
	}
	return days;
}

// 对日历显示进行处理
function SetDate(year, month, day) {
	var y = parseInt(year);
	var m = parseInt(month);
	var $d = $(".cal_day");
	var $day = $("#cal_days");
	$d.remove();
	var weekday = WeekdayOfFristDay(y, m - 1);
	var days = DaysOfMonth(y, m);
	for (var i = 0; i < days + weekday; i++) {
		if (i < weekday) {
			$day.append("<div class=\"cal_day\"><\/div>");
		} else if ((currentDate = i + 1 - weekday) == day) {
			$day.append("<div class=\"cal_day\">"+ currentDate + "<\/div>");
		} else {
			$day.append("<div class=\"cal_day\">"+ currentDate + "<\/div>");
		}
	}
	// 设置日期显示元素下的子元素的样式
	$day.children().css({"width":"13.5%","height":"12%","text-align":"center","float":"left","background":"#eee","margin":"1px","padding-top":"2%"});
	$(".cal_day:contains("+day+")").css({"background":"#ffffff"})
}