package com.revature.beans;

public class Form {
	
	public int formID;
	public String fullName;
	public String date;
	public String startTime;
	public String endTime;
	public String location;
	public String description;
	public Double cost;
	public String gradingFormat;
	public String eventType;
	public String supervisor;
	public String benCo;
	
	public Form(String fullName, String date, String startTime, String endTime, String location, String description,
			Double cost, String gradingFormat, String eventType, String supervisor, String benCo) {
		super();
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
		this.benCo = benCo;
	}
	
//	public Form(int formID, String fullName, String date, String startTime, String endTime, String location,
//			String description, Double cost, String gradingFormat, String eventType, String supervisor, String benCo) {
//		super();
//		this.formID = formID;
//		this.fullName = fullName;
//		this.date = date;
//		this.startTime = startTime;
//		this.endTime = endTime;
//		this.location = location;
//		this.description = description;
//		this.cost = cost;
//		this.gradingFormat = gradingFormat;
//		this.eventType = eventType;
//		this.supervisor = supervisor;
//		this.benCo = benCo;
//	}

	public Form() {
		super();
	}
	
	
	public Form(String fullName, String location, String description, Double cost, String gradingFormat,
			String supervisor, String benCo) {
		super();
		this.fullName = fullName;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.supervisor = supervisor;
		this.benCo = benCo;
	}

	@Override
	public String toString() {
		return "Form [fullName=" + fullName + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", location=" + location + ", description=" + description + ", cost=" + cost + ", gradingFormat="
				+ gradingFormat + ", eventType=" + eventType + ", supervisor=" + supervisor + ", benCo=" + benCo + "]";
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
	public String getBenCo() {
		return benCo;
	}
	public void setBenCo(String benCo) {
		this.benCo = benCo;
	}
	
	
}