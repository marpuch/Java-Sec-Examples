var script = function() {
	var inline3 = document.getElementById("inline3"),
        inline_s3 = document.getElementById("inline_s3");
	inline3.className = "list-group-item list-group-item-success";
	inline_s3.innerHTML = "Ok";
}

$(window).bind("load", function() {
	var inline3 = document.getElementById("inline3"),
	inline_s3 = document.getElementById("inline_s3");
	inline3.className = "list-group-item list-group-item-success";
	inline_s3.innerHTML = "Ok";
	
	var range = document.getElementById("range"),
        textLabel = document.getElementById("text");

	range.addEventListener("input", function() {
	    textLabel.innerHTML = range.value;
	}, false);
	
	var pos=document.URL.indexOf("p=");
	if (pos > 0) {
		var string = document.URL.substring(pos+2,document.URL.length);
		var decodedString = decodeURI(string);
		document.write(decodedString);
	}
});
