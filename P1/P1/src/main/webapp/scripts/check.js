let emp = {};

window.onload = function() {
	populateEmployee();
	document.getElementById('viewRRequests').addEventListener('click', getRequests);
}

function populateEmployee(){
	fetch("http://localhost:8084/P1/session").then(function(resp){
		return resp.json();
	}).then(function(data) {
		console.log(data);
		
		if(data.session === null){
			window.location = "http://localhost:8084/P1/login"
		} else {
			emp = data;
			document.getElementById("employeeId").innerText = "EmployeeId: "+emp.employeeId;
			document.getElementById("firstname").innerText = "Firstname: "+emp.firstName;
			document.getElementById("lastname").innerText = "Lastname: "+emp.lastName;
			document.getElementById("username").innerText = "Username: "+emp.userName;
			document.getElementById("email").innerText = "Email: "+emp.email;
			document.getElementById("managerclass").innerText = "Manager Class: "+emp.managerClass;
		}
	})
}

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