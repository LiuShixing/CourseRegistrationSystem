package bean;

import java.util.ArrayList;

public class CourseOffering 
{
	private int id;
	private String title;
	private String dept_name;
	private int start_week;
	private int end_week;
	private ArrayList<TimeSlot> timeSlots;
	private int year;
	private int semester;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public int getStart_week() {
		return start_week;
	}
	public void setStart_week(int start_week) {
		this.start_week = start_week;
	}
	public int getEnd_week() {
		return end_week;
	}
	public void setEnd_week(int end_week) {
		this.end_week = end_week;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}

	public ArrayList<TimeSlot> getTimeSlots()
	{
		return timeSlots;
	}
	public void setTimeSlots(ArrayList<TimeSlot> timeSlots)
	{
		this.timeSlots = timeSlots;
	}
	

}
