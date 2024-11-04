
function printR(x,id) {
	var t = document.getElementById(id);
	var i;	
	for (i=0;i<=10;i++) {
		t.innerHTML += i+"x"+x+"="+(i*x)+" ";
	}	
	t.innerHTML += "<br>";
}

function ch(id) {
	var h = document.defaultView.outerHeight;
	var b = document.defaultView.outerWidth;
	var hi = document.defaultView.innerHeight;
	var bi = document.defaultView.innerWidth;
	var ausgabe = document.getElementById(id);
	document.close()
	ausgabe.innerHTML = "Dein Fenster ist "+b+"x"+h+"Pixel groß<br>";
	ausgabe.innerHTML += "Dein Text ist "+bi+"x"+hi+"Pixel groß<br>";
}