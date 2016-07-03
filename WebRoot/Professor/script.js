function checkInput() {
	var table = document.getElementById("ingrade");
	var grades = table.getElementsByTagName("input");
	for ( var i = 0; i < grades.length; i++) {
		if (grades[i].value != ""
				&& !(grades[i].value == 'A' || grades[i].value == 'B'
						|| grades[i].value == 'C' || grades[i].value == 'D'
						|| grades[i].value == 'F' || grades[i].value == 'I')) {
			window.alert("成绩应为A,B,C,D,F或I");
			return false;
		}
	}
	return true;
}