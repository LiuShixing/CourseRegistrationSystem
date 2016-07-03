function edit_show_info() {
	var edit = document.getElementById("update_id");
	var id = edit.value;
	if (id.length == 0 || id == " ") {
		return;
	} else {
		if (!isNaN(id)) {
			window.location.href = '/CoRegSystem/Registar/ProfessorInfo/edit.jsp?id=' + id;
		} else {
			window.alert("用户id格式错误");
		}
	}
}

function delete_show_info() {
	var edit = document.getElementById("update_id");
	var id = edit.value;
	if (id.length == 0 || id == " ") {
		return;
	} else {
		if (!isNaN(id)) {
			window.location.href = '/CoRegSystem/Registar/ProfessorInfo/delete.jsp?id=' + id;
		} else {
			window.alert("用户id格式错误");
		}
	}
}