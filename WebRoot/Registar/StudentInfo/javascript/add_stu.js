function add_stu() {
	var name = document.getElementById("name").value;
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var date = document.getElementById("date").value;
	var number = document.getElementById("number").value;
	var status = document.getElementById("status").value;
	
	var gyear = document.getElementById("grayear").value;
	var gmonth = document.getElementById("gramonth").value;
	var gdate = document.getElementById("gradate").value;

	if (name.length == 0 && name != " ") {
		window.alert("请输入姓名");
		return false;
	}
	if (year.length == 0 && year != " ") {
		window.alert("请输入生日");
		return false;
	}
	if (month.length == 0 && month != " ") {
		window.alert("请输入生日");
		return false;
	}
	if (date.length == 0 && date != " ") {
		window.alert("请输入生日");
		return false;
	}
	if (number.length == 0 && number != " ") {
		window.alert("请输入社会保障号码");
		return false;
	}
	if (status.length == 0 && status != " ") {
		window.alert("请输入身份");
		return false;
	}
	if (gyear.length == 0 && gyear != " ") {
		window.alert("请输入毕业日期");
		return false;
	}
	if (gmonth.length == 0 && gmonth != " ") {
		window.alert("请输入毕业日期");
		return false;
	}
	if (gdate.length == 0 && gdate != " ") {
		window.alert("请输入毕业日期");
		return false;
	}

	var y = parseInt(year);
	var m = parseInt(month);
	var d = parseInt(date);
	
	var gy = parseInt(gyear);
	var gm = parseInt(gmonth);
	var gd = parseInt(gdate);
	if (!(y > 1900 && y < 3000) || !(gy > 1900 && gy < 3000)) {
		window.alert("日期年份格式错误");
		return  false;
	}
	if (!(m > 0 && m < 13) || !(gm > 0 && gm < 13)) {
		window.alert("日期月份格式错误");
		return false;
	}
	if (!(d > 0 && d < 32) || !(gd > 0 && gd < 32)) {
		window.alert("日期日格式错误");
		return false;
	}

	return true;
}