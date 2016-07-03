function edit_show_info() {
	var edit = document.getElementById("update_id");
	var id = edit.value;
	if (id.length == 0 || id == " ") {
		return;
	} else {
		if (!isNaN(id)) {
			window.location.href = '/CoRegSystem/Registar/StudentInfo/edit.jsp?id=' + id;
		} else {
			window.alert("用户id格式错误");
		}
	}
}
function edit_show_info2() {
	var edit = document.getElementById("update_id");
	var id = edit.value;
	if (id.length == 0 || id == " ") {
		return;
	} else {
		if (!isNaN(id)) {
			window.location.href = '/CoRegSystem/Registar/StudentInfo/delete.jsp?id=' + id;
		} else {
			window.alert("用户id格式错误");
		}
	}
}
function delete_show_info() {
	window.alert("用户id格式错误");
	var edit = document.getElementById("update_id");
	var id = edit.value;
	if (id.length == 0 || id == " ") {
		return;
	} else {
		if (!isNaN(id)) {
			window.location.href = '/CoRegSystem/Registar/StudentInfo/delete.jsp?id=' + id;
		} else {
			window.alert("用户id格式错误");
		}
	}
}