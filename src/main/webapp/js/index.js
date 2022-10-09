function changeColor(current) {
	var buttons = document.getElementsByClassName("n1_a");
	for (var i = 0; i < buttons.length; i++) {
		buttons[i].style.backgroundColor = "#fffce6";
	}
	current.style.backgroundColor = "red";
}