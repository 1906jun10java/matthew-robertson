let emp = {};

window.onload = function() {
	populateEmployee();
	document.getElementById('viewRRequests').addEventListener('click', getRequests);
	//document.getElementById('viewEmpList').addEventListener('click', getEmpList);
	//document.getElementById('viewManC1EmpR_Requests').addEventListener('click', getEmpReqList)
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

function getEmpReqList() {
	fetch("http://localhost:8084/P1/managerC1ViewR_Requests").then(function(response){
		let reqList = response.json();
		return reqList;
	}).then(function(reqList){
		console.log(reqList);
		erTableGen(reqList);
	})
}

function erTableGen(data) {
	// Create a HTML Table element.
	let table = document.createElement("TABLE");
	table.border = "1";

	// Add the header row.
	let row = table.insertRow(-1);
	let headerCell = document.createElement("TH");

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "RequestID";
	
	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "EmployeeID";
	
	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Date";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Description";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Cost";
	
	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Manager Class";

	// Add th data rows.
	for (let i = 0; i < data.length; i++) {
		row = table.insertRow(-1);

		let cell = row.insertCell(-1);
		cell.innerHTML = data[i].requestId;
		
		cell = row.insertCell(-1);
		cell.innerHTML = data[i].employeeId;
		
		cell = row.insertCell(-1);
		cell.innerHTML = data[i].rDate;

		cell = row.insertCell(-1);
		cell.innerHTML = data[i].rDescription;

		cell = row.insertCell(-1);
		cell.innerHTML = "$" + data[i].rCost;
		
		cell = row.insertCell(-1);
		cell.innerHTML = data[i].managerClass;

	}

	// replace the empty div with a table
	let newTable = document.getElementById("ManC1EmpR_Requests");
	newTable.innerHTML = "";
	newTable.appendChild(table);
}

function getEmpList(){
	fetch("http://localhost:8084/P1/viewC1ManagerEmpList").then(function(response) {
		let empList = response.json();
		return empList;
	}).then(function(empList){
		console.log(empList);
		eTableGen(empList);
	})
}

function eTableGen(data) {
	// Create a HTML Table element.
	let table = document.createElement("TABLE");
	table.border = "1";

	// Add the header row.
	let row = table.insertRow(-1);
	let headerCell = document.createElement("TH");

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "EmployeeId";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Firstname";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Lastname";
	
	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Username";
	
	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Email";
	
	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Mananger Class";

	// Add th data rows.
	for (let i = 0; i < data.length; i++) {
		row = table.insertRow(-1);

		let cell = row.insertCell(-1);
		cell.innerHTML = data[i].employeeId;

		cell = row.insertCell(-1);
		cell.innerHTML = data[i].firstName;

		cell = row.insertCell(-1);
		cell.innerHTML = data[i].lastName;
		
		cell = row.insertCell(-1);
		cell.innerHTML = data[i].userName;
		
		cell = row.insertCell(-1);
		cell.innerHTML = data[i].email;
		
		cell = row.insertCell(-1);
		cell.innerHTML = data[i].managerClass;

	}

	// replace the empty div with a table
	let newTable = document.getElementById("EmpList");
	newTable.innerHTML = "";
	newTable.appendChild(table);
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
	headerCell.innerHTML = "RequestID";
	
	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "EmployeeID";
	
	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Date";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Description";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Cost";
	
	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Status";
	
	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Manager Class";

	// Add th data rows.
	for (let i = 0; i < data.length; i++) {
		row = table.insertRow(-1);

		let cell = row.insertCell(-1);
		cell.innerHTML = data[i].requestId;
		
		cell = row.insertCell(-1);
		cell.innerHTML = data[i].employeeId;
		
		cell = row.insertCell(-1);
		cell.innerHTML = data[i].rDate;

		cell = row.insertCell(-1);
		cell.innerHTML = data[i].rDescription;

		cell = row.insertCell(-1);
		cell.innerHTML = "$" + data[i].rCost;
		
		cell = row.insertCell(-1);
		cell.innerHTML = data[i].status;
		
		cell = row.insertCell(-1);
		cell.innerHTML = data[i].managerClass;

	}

	// replace the empty div with a table
	let newTable = document.getElementById("R_Requests");
	newTable.innerHTML = "";
	newTable.appendChild(table);
}