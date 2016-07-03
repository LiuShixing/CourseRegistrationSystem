function add_pro() {
	var name = document.getElementById("name").value;
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var date = document.getElementById("date").value;
	var number = document.getElementById("number").value;
	var status = document.getElementById("status").value;
	var department = document.getElementById("department").value;

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
	if (department.length == 0 && department != " ") {
		window.alert("请输入院系");
		return false;
	}

	var y = parseInt(year);
	var m = parseInt(month);
	var d = parseInt(date);
	if (!(y > 1900 && y < 3000)) {
		window.alert("日期年份格式错误");
		return false;
	}
	if (!(m > 0 && m < 13)) {
		window.alert("日期月份格式错误");
		return false;
	}
	if (!(d > 0 && d < 32)) {
		window.alert("日期日格式错误");
		return false;
	}
	return true;
}