package com.revature.beans;

public class Form {

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
	
	public Form() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	@Override
	public String toString() {
		return "Form [fullName=" + fullName + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", location=" + location + ", description=" + description + ", cost=" + cost + ", gradingFormat="
				+ gradingFormat + ", eventType=" + eventType + ", supervisor=" + supervisor + ", benCo=" + benCo + "]";
	}
	
	
}