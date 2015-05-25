package com.ibm.dst.frame.ssm.test.model;

import java.text.DecimalFormat;

import com.ibm.dst.frame.ssm.common.base.model.BaseModel;

public class Employee extends BaseModel {

	private static final long serialVersionUID = 6231635300919598822L;
	
	private String empNo = null;
	private String empName = null;
	private String empSalary = null;
	private String hiredate = null;
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSalary() {
		if(null == empSalary||"".equals(empSalary)) {
			return "0.0";
		} else {
			DecimalFormat df = new DecimalFormat("####0.0");
			return df.format(Double.parseDouble(empSalary));
		}
	}
	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
}
