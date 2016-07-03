package bean;

import java.util.ArrayList;

public class Teach 
{

	private int couOffer_id;
	private int pro_id;
	private String proName;
	private String department;
	private int year;
	private int semester;
	private int startweek;
	private int endweek;
	private int student_count;
	private String title;
	private ArrayList<TimeSlot> timeSlot;
	public int getCouOffer_id() {
		return couOffer_id;
	}
	public void setCouOffer_id(int couOffer_id) {
		this.couOffer_id = couOffer_id;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
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
	public int getStartweek() {
		return startweek;
	}
	public void setStartweek(int startweek) {
		this.startweek = startweek;
	}
	public int getEndweek() {
		return endweek;
	}
	public void setEndweek(int endweek) {
		this.endweek = endweek;
	}
	public int getStudent_count() {
		return student_count;
	}
	public void setStudent_count(int student_count) {
		this.student_count = student_count;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<TimeSlot> getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(ArrayList<TimeSlot> timeSlot) {
		this.timeSlot = timeSlot;
	}
	public String getDepartment()
	{
		return department;
	}
	public void setDepartment(String string)
	{
		this.department = string;
	}
	public String getProName()
	{
		return proName;
	}
	public void setProName(String string)
	{
		this.proName = string;
	}
}
