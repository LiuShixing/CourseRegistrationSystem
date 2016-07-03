function query() {
	var edit = document.getElementById("idEditText");
	var id = edit.value;
	if (id != null) {
		window.location.href = '/CoRegSystem/Registar/professorInfo.jsp?queryid='
				+ id;
	}
}