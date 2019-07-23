let emp = {};

window.onload = function() {
	populateEmployee();
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