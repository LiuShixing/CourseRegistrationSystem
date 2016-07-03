package bean;

import java.util.ArrayList;


public class Take 
{
	private int couOffer_id;
	private int pro_id;
	private int stu_id;
	private String type;
	private int year;
	private int semester;
	private int startweek;
	private int endweek;
	private String professorName;
	private String grade;
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
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
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
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
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
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}

}
