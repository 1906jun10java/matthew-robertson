package com.revature.beans;

public class R_Request {
	
	private int requestId;
	private int employeeId;
	private String rDate;
	private String rDescription;
	private double rCost;
	
	public R_Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public R_Request(int employeeId, String rDate, String rDescription, double rCost) {
		super();
		this.employeeId = employeeId;
		this.rDate = rDate;
		this.rDescription = rDescription;
		this.rCost = rCost;
	}

	public R_Request(int requestId, int employeeId, String rDate, String rDescription, double rCost) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.rDate = rDate;
		this.rDescription = rDescription;
		this.rCost = rCost;
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

	public void setEmployee_Id(int employeeId) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		long temp;
		temp = Double.doubleToLongBits(rCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rDate == null) ? 0 : rDate.hashCode());
		result = prime * result + ((rDescription == null) ? 0 : rDescription.hashCode());
		result = prime * result + requestId;
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
		return true;
	}

	@Override
	public String toString() {
		return "R_Request [requestId=" + requestId + ", employeeId=" + employeeId + ", rDate=" + rDate
				+ ", rDescription=" + rDescription + ", rCost=" + rCost + "]\n";
	}

	
}
