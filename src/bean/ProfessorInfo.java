package bean;

import java.util.Date;

public class ProfessorInfo
{
	public int id;
    private String name;
    private String birthday;
    private String socialNumber;
    private String status;
    private String department;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getBirthday()
	{
		return birthday;
	}
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}
	public String getSocialNumber()
	{
		return socialNumber;
	}
	public void setSocialNumber(String socialNumber)
	{
		this.socialNumber = socialNumber;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getDepartment()
	{
		return department;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
}
