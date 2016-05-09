package com.cantine.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;


@Entity
@Table(name="TBL_EMPLOYEE")
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true) 
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeId;
	private String name;
	private String gender;
	private String position;
	private float salaryPerDayInDollar;
	private Date startDate;
	private boolean isActive=true;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public float getSalaryPerDayInDollar() {
		return salaryPerDayInDollar;
	}
	public void setSalaryPerDayInDollar(float salaryPerDayInDollar) {
		this.salaryPerDayInDollar = salaryPerDayInDollar;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", gender=" + gender + ", position=" + position
				+ ", salaryPerDayInDollar=" + salaryPerDayInDollar + ", startDate=" + startDate + ", isActive="
				+ isActive + "]";
	}

	



}
