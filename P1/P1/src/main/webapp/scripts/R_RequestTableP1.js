/*window.onload = function() {
    document.getElementById("poke").onclick = function() {
        sendAjaxGet('http://localhost:8084/P1/ViewR_Request', populateERRTable);
    };
}
// perform Ajax call
// url represents the resource being requested
// func represents the callback function to be invoked when request is complete
function sendAjaxGet(url, func) {
    // step 1: obtain xhr object (Internet Explorer 5,6 don't have it...)
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    // step 2: define onreadystatechange
    xhr.onreadystatechange = function() {
        // readyState of 4 means request is complete
        // status of 200 means ok
        if (this.readyState == 4 && this.status == 200) {
            func(this);
        }
    }
    // step 3: prepare the request
    xhr.open("GET", url, true);
    // step 4: send the request
    xhr.send(); 
    // IF WE WERE SENDING A POST REQUEST OR ANYTHING THAT USED THE BODY
    // IT WOULD GO AS AN ARGUMENT TO SEND()
}

function populateERRTable(xhr) {
    let errTableObj = JSON.parse(xhr.responseText);
    console.log(errTableObj);
    document.getElementById("errTable").innerText = "ERRTABLE:" + errTableObj;
}
 */

//let id = null;
window.onload = function() {
	// dUser();
	document.getElementById('viewRRequests').addEventListener('click', getRequests);
}

//const URL = "http://localhost:8084/P1/viewR_Requests";

/*
 * function dUser(){ fetch("http://localhost:8084/P1/session").then(
 * function(resp){ let data = resp.json(); return data; }).then( function(data){
 * document.getElementById("welcome").innertText = "Welcome " + data.firstname + " " +
 * data.lastName; return data; }) }
 */

function getRequests() {
	fetch("http://localhost:8084/P1/viewR_Requests").then(function(response) {
		let reqList = response.json();
		return reqList;
	}).then(function(reqList) {
		console.log(reqList);
		rTableGen(reqList);
	})
}

function rTableGen(data) {
	// Create a HTML Table element.
	let table = document.createElement("TABLE");
	table.border = "1";

	// Add the header row.
	let row = table.insertRow(-1);
	let headerCell = document.createElement("TH");

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Date";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Description";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Cost";

	// Add th data rows.
	for (let i = 0; i < data.length; i++) {
		row = table.insertRow(-1);

		let cell = row.insertCell(-1);
		cell.innerHTML = data[i].rDate;

		cell = row.insertCell(-1);
		cell.innerHTML = data[i].rDescription;

		cell = row.insertCell(-1);
		cell.innerHTML = data[i].rCost;

	}

	// replace the empty div with a table
	let newTable = document.getElementById("R_Requests");
	newTable.innerHTML = "";
	newTable.appendChild(table);
}
/*
 * let employee = [ { EmployeeID: 54, Firstname: "Matthew", Lastname:
 * "Robertson", Username: "LavaLamp", Email:"matthew@gmail.com", ManagerClass: 2 }, {
 * EmployeeID: 57, Firstname: "Bill", Lastname: "Preston", Username:
 * "Excellent...", Email:"WildStallions!1@gmail.com", ManagerClass: 3 }, {
 * EmployeeID: 58, Firstname: "Ted", Lastname: "Logan", Username: "Bogus...",
 * Email:"WildStallions!2@gmail.com", ManagerClass: 3 }, { EmployeeID: 56,
 * Firstname: "Luke", Lastname: "Smith", Username: "SkyWalker",
 * Email:"NotReallyLukeS@gmail.com", ManagerClass: 4 }, { EmployeeID: 55,
 * Firstname: "Michael", Lastname: "Jackson", Username: "MoonWalker",
 * Email:"mj@gmail.com", ManagerClass: 5 } ];
 */
/*
 * function generateTableHead(table, data) { let thead = table.createTHead();
 * let row = thead.insertRow(); for (let key of data) { let th =
 * document.createElement("th"); let text = document.createTextNode(key);
 * th.appendChild(text); row.appendChild(th); } } function generateTable(table,
 * data) { for (let element of data) { let row = table.insertRow(); for (key in
 * element) { let cell = row.insertCell(); let text =
 * document.createTextNode(element[key]); cell.appendChild(text); } } }
 */
/*
 * let table = document.querySelector("table"); let data =
 * Object.keys(employee[0]); generateTable(table, employee);
 * generateTableHead(table, data);
 */