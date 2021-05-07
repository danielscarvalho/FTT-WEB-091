document.addEventListener("DOMContentLoaded", init, false);

let userURL = "/FTT-WEB-091/user";
let userTable;

function init() {
	console.log("Starting...");
	userTable = document.getElementById("");
	getUser();
}

function getUser() {

	fetch(userURL)
	.then(request => request.json())
	.then(data => console.log(data));

}

function userTableFill() {
}

function userDelete() {
}

function userUpdate() {
}

function userGet() {
}