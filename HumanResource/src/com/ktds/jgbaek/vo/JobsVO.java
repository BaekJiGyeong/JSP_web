package com.ktds.jgbaek.vo;

public class JobsVO {
	
//	JOB_ID	VARCHAR2(10 BYTE)
//	JOB_TITLE	VARCHAR2(35 BYTE)
//	MIN_SALARY	NUMBER(6,0)
//	MAX_SALARY	NUMBER(6,0)
	
	private String jobId;
	private String jobTitle;
	private int minSalary;
	private int maxSalary;
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
	public int getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	

}
