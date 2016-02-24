package com.ktds.jgbaek.vo;

public class JobHistoryVO {
	
//	EMPLOYEE_ID	NUMBER(6,0)
//	START_DATE	DATE
//	END_DATE	DATE
//	JOB_ID	VARCHAR2(10 BYTE)
//	DEPARTMENT_ID	NUMBER(4,0)
	
	private int employeeId;
	private String startDate;
	private String endDate;
	private String jobId;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	private int departmentId;
	

}
