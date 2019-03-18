package com.revature.beans;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Form {
	private final static Set<String> EVENTTYPES = Collections.unmodifiableSet(
			new	HashSet<String>(Arrays.asList("University Class","Seminar","Certification Class","Certification","Technical Training")));
	
	public Integer formID; //primary key
	
	public String fullName; //necessary for UDI contructor
	public String date;
	public String startTime;
	public String endTime;
	public String location;
	public String description;
	public Double cost;
	public String gradingFormat;
	public String eventType;
	public String supervisor;
	public String deptHead;
	public String benCo;
	
	public String superDecision; //necessary for FDI contructor
	public String superContext;
	public String headDecision;
	public String headContext;
	public String benCoDecision;
	public String benCoContext;
	
	public String finalDecision; // 
	public Double reimbursement; // should be read only
	

	
	public Form() {
		super();
	}
	public Form(String fullName, String date, String startTime, String endTime, String location, String description,
			Double cost, String gradingFormat, String eventType, String supervisor, String departmentHead, String benCo) {
		super();
		this.formID = 0;
		this.fullName = fullName;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.supervisor = supervisor;
		this.deptHead = departmentHead;
		this.benCo = benCo;
		
	}
	
	public Form(int formID, String fullName, String date, String startTime, String endTime, String location, String description, 
			Double cost, String gradingFormat, String eventType, String supervisor, String deptHead, String benCo, 
			String superDecision, String superContext, String headDecision, String headContext, String benCoDecision, String benCoContext) {
		super();
		this.formID = formID;
		this.fullName = fullName;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.supervisor = supervisor;
		this.deptHead = deptHead;
		this.benCo = benCo;
		this.superDecision = superDecision;
		this.superContext = superContext;
		this.headDecision = headDecision;
		this.headContext = headContext;
		this.benCoDecision = benCoDecision;
		this.benCoContext = benCoContext;
	}
	
	public Form(String fullName, String location, String description, Double cost, String gradingFormat,
			String supervisor, String deptHead, String benCo) {
		super();
		this.formID = 0;
		this.fullName = fullName;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.supervisor = supervisor;
		this.deptHead = deptHead;
		this.benCo = benCo;
	}

	@Override
	public String toString() {
		return "Form [fullName=" + fullName + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", location=" + location + ", description=" + description + ", cost=" + cost + ", gradingFormat="
				+ gradingFormat + ", eventType=" + eventType + ", supervisor=" + supervisor + ", benCo=" + benCo + "]";
	}
	public Integer getFormID() {
		return formID;
	}

	public void setFormID(Integer formID) {
		this.formID = formID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

	public String getBenCo() {
		return benCo;
	}

	public void setBenCo(String benCo) {
		this.benCo = benCo;
	}

	public Double getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(Double reimbursement) {
		this.reimbursement = reimbursement;
	}

	public String getSuperDecision() {
		return superDecision;
	}

	public void setSuperDecision(String superDecision) {
		this.superDecision = superDecision;
	}

	public String getSuperContext() {
		return superContext;
	}

	public void setSuperContext(String superContext) {
		this.superContext = superContext;
	}

	public String getHeadDecision() {
		return headDecision;
	}

	public void setHeadDecision(String headDecision) {
		this.headDecision = headDecision;
	}

	public String getHeadContext() {
		return headContext;
	}

	public void setHeadContext(String headContext) {
		this.headContext = headContext;
	}

	public String getBenCoDecision() {
		return benCoDecision;
	}

	public void setBenCoDecision(String benCoDecision) {
		this.benCoDecision = benCoDecision;
	}

	public String getBenCoContext() {
		return benCoContext;
	}

	public void setBenCoContext(String benCoContext) {
		this.benCoContext = benCoContext;
	}
	
	
	

	
}