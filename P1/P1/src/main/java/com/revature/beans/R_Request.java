package com.revature.beans;

public class R_Request {
	
	private int requestId;
	private int employeeId;
	private String rDate;
	private String rDescription;
	private double rCost;
	private String status; 
	private int managerClass;
	
	public R_Request() {
		super();
	}

	public R_Request(int requestId, int employeeId, String rDate, String rDescription, double rCost, String status,
			int managerClass) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.rDate = rDate;
		this.rDescription = rDescription;
		this.rCost = rCost;
		this.status = status;
		this.managerClass = managerClass;
	}

	public R_Request(int employeeId, String rDate, String rDescription, double rCost, String status, int managerClass) {
		super();
		this.employeeId = employeeId;
		this.rDate = rDate;
		this.rDescription = rDescription;
		this.rCost = rCost;
		this.status = status;
		this.managerClass = managerClass;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	public String getrDescription() {
		return rDescription;
	}

	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}

	public double getrCost() {
		return rCost;
	}

	public void setrCost(double rCost) {
		this.rCost = rCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getManagerClass() {
		return managerClass;
	}

	public void setManagerClass(int managerClass) {
		this.managerClass = managerClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + managerClass;
		long temp;
		temp = Double.doubleToLongBits(rCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rDate == null) ? 0 : rDate.hashCode());
		result = prime * result + ((rDescription == null) ? 0 : rDescription.hashCode());
		result = prime * result + requestId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		R_Request other = (R_Request) obj;
		if (employeeId != other.employeeId)
			return false;
		if (managerClass != other.managerClass)
			return false;
		if (Double.doubleToLongBits(rCost) != Double.doubleToLongBits(other.rCost))
			return false;
		if (rDate == null) {
			if (other.rDate != null)
				return false;
		} else if (!rDate.equals(other.rDate))
			return false;
		if (rDescription == null) {
			if (other.rDescription != null)
				return false;
		} else if (!rDescription.equals(other.rDescription))
			return false;
		if (requestId != other.requestId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "R_Request [requestId=" + requestId + ", employeeId=" + employeeId + ", rDate=" + rDate
				+ ", rDescription=" + rDescription + ", rCost=" + rCost + ", status=" + status + ", managerClass="
				+ managerClass + "]";
	}

}