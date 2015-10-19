if(typeof(_COMMOND) == 'undefined'){
	var _COMMOND = [];
}

_COMMOND.push(["help", "These shell commands are defined internally.  Type `help' to see this list.", "funcName"]);
_COMMOND.push(["new", "New a file. The '-t' defines title, the '-a' defines author. ", "funcName"]);
_COMMOND.push(["edit", "Edit a file. The '-t' defines title", "funcName"]);
_COMMOND.push(["list", "Show the file list.", "funcName"]);

function getCommondNameList() {
	var _arr = [];
	for(var i=0; i<_COMMOND.length; i++) {
		_arr.push(_COMMOND[i][0]);
	}
	return _arr;
}

