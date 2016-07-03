package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DbManager
{
	public String checkUser(int id, String password)
	{
		String type = null;
		String sql = "SELECT Type FROM user WHERE ID = " + id
				+ " AND Password = " + password + ";";
		Connection con = MyUtil.getDBConnection();
		Statement stat;
		try
		{
			stat = (Statement) con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			if (rs.next())
			{
				type = rs.getString(1);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return type;
	}

	public void checkCourceNumber()
	{
		String sql = "SELECT CouOffer_id,Pro_id FROM teach WHERE Student_count <3;";
		Connection con = MyUtil.getDBConnection();

		ArrayList<Integer> couIds = new ArrayList<Integer>();
		ArrayList<Integer> proIds = new ArrayList<Integer>();
		try
		{
			Statement stat = (Statement) con.createStatement();
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next())
			{
				couIds.add(rs.getInt("CouOffer_id"));
				proIds.add(rs.getInt("Pro_id"));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		if (couIds.size() > 0)
		{
			String sql2 = "DELETE FROM teach WHERE ( CouOffer_id="
					+ couIds.get(0) + " AND  Pro_id=" + proIds.get(0) + " )";
			for (int i = 1; i < couIds.size(); i++)
			{
				sql2 += " OR ( CouOffer_id=" + couIds.get(i) + " AND "
						+ " Pro_id=" + proIds.get(i) + " ) ";
			}
			sql2 += ";";

			String sql3 = "DELETE FROM takes WHERE ( CouOffer_id="
					+ couIds.get(0) + " AND  Pro_id=" + proIds.get(0) + " )";
			for (int i = 1; i < couIds.size(); i++)
			{
				sql3 += " OR ( CouOffer_id=" + couIds.get(i) + " AND "
						+ " Pro_id=" + proIds.get(i) + " ) ";
			}
			sql3 += ";";

			try
			{
				Statement stat2 = (Statement) con.createStatement();
				stat2.executeUpdate(sql2);

				Statement stat3 = (Statement) con.createStatement();
				stat3.executeUpdate(sql3);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

	}

	public ArrayList<Integer> queryStuCouCount(int stuId)
	{
		String sql = "SELECT* FROM student_take_count WHERE StuId=" + stuId
				+ ";";
		Connection con = MyUtil.getDBConnection();
		ArrayList<Integer> infos = new ArrayList<Integer>();

		try
		{
			Statement stat = (Statement) con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			if (rs.next())
			{
				infos.add(rs.getInt("MainCount"));
				infos.add(rs.getInt("AlterCount"));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return infos;
	}

	public ArrayList<ProfessorInfo> queryALLProfessorInfo()
	{

		String sql = "SELECT* FROM professor";
		Connection con = MyUtil.getDBConnection();
		ArrayList<ProfessorInfo> infos = new ArrayList<ProfessorInfo>();
		try
		{
			Statement stat = (Statement) con.createStatement();
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next())
			{
				ProfessorInfo pf = new ProfessorInfo();

				pf.setId(rs.getInt("ID"));
				pf.setSocialNumber(rs.getString("SocialNumber"));
				pf.setName(rs.getString("Name"));
				pf.setBirthday(rs.getString("Birthday"));
				pf.setDepartment(rs.getString("Department"));
				pf.setStatus(rs.getString("Status"));
				System.out.println(pf.getId() + " " + pf.getName() + " "
						+ pf.getBirthday() + " " + pf.getStatus() + " "
						+ pf.getSocialNumber() + " " + pf.getDepartment());
				infos.add(pf);

			}
		} catch (SQLException e)
		{
			System.out.print("连接数据库失败查询所有教师");
		}
		// for(int i=0;i<infos.size();i++)
		// {
		// System.out.println(infos.get(i).getName());
		// }

		return infos;

	}

	public ProfessorInfo queryProfessorInfo(int id)
	{
		String sql = "SELECT* FROM professor WHERE ID = " + id + ";";
		Connection con = MyUtil.getDBConnection();
		ProfessorInfo pf = null;
		try
		{
			Statement stat = (Statement) con.createStatement();

			ResultSet rs = stat.executeQuery(sql);
			if (rs.next())
			{
				pf = new ProfessorInfo();
				pf.setId(rs.getInt("ID"));
				pf.setSocialNumber(rs.getString("SocialNumber"));
				pf.setName(rs.getString("Name"));
				pf.setBirthday(rs.getString("Birthday"));
				pf.setDepartment(rs.getString("Department"));
				pf.setStatus(rs.getString("Status"));

			}
		} catch (SQLException e)
		{
			System.out.print("连接数据库失败查询单个教师");
		}
		// System.out.println(pf.getId()+" "+pf.getName()+" "+pf.getBirthday()+" "+pf.getStatus()+" "+pf.getSocialNumber()+" "+pf.getDepartment()
		// );
		return pf;

	}

	public StudentInfo queryStudentInfo(int id)
	{
		String sql = "SELECT* FROM student WHERE ID = " + id + ";";
		Connection con = MyUtil.getDBConnection();
		StudentInfo pf = null;
		try
		{
			Statement stat = (Statement) con.createStatement();

			ResultSet rs = stat.executeQuery(sql);
			if (rs.next())
			{
				pf = new StudentInfo();
				pf.setId(rs.getInt("ID"));
				pf.setSocialNumber(rs.getString("SocialNumber"));
				pf.setName(rs.getString("Name"));
				pf.setBirthday(rs.getString("Birthday"));
				pf.setGraduationDate(rs.getString("GraduationDate"));
				pf.setStatus(rs.getString("Status"));

			}
		} catch (SQLException e)
		{
			System.out.print("连接数据库失败查询单个教师");
		}
		// System.out.println(pf.getId()+" "+pf.getName()+" "+pf.getBirthday()+" "+pf.getStatus()+" "+pf.getSocialNumber()+" "+pf.getDepartment()
		// );
		return pf;

	}

	public ArrayList<StudentInfo> queryALLStudentInfo()
	{
		String sql = "SELECT* FROM student";
		Connection con = MyUtil.getDBConnection();
		ArrayList<StudentInfo> infos = new ArrayList<StudentInfo>();
		try
		{
			Statement stat = (Statement) con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next())
			{

				StudentInfo pf = new StudentInfo();
				pf.setId(rs.getInt("ID"));
				pf.setSocialNumber(rs.getString("SocialNumber"));
				pf.setName(rs.getString("Name"));
				pf.setBirthday(rs.getString("Birthday"));
				pf.setGraduationDate(rs.getString("GraduationDate"));
				pf.setStatus(rs.getString("Status"));
				// System.out.println(pf.getId()+" "+pf.getName()+" "+pf.getBirthday()+" "+pf.getStatus()+" "+pf.getSocialNumber()+" "+pf.getGraduationDate()
				// );
				infos.add(pf);
			}
		} catch (SQLException e)
		{
			System.out.print("连接数据库失败查询所有学生信息");
		}
		// for(int i=0;i<infos.size();i++)
		// {
		// System.out.println(infos.get(i).getName());
		// }
		return infos;

	}

	public void insertProfessor(ProfessorInfo pi)
	{
		String name = pi.getName();
		String birth = pi.getBirthday();
		String social = pi.getSocialNumber();
		String sta = pi.getStatus();
		String dep = pi.getDepartment();

		String sql = "INSERT INTO user (Type,Password) VALUES('professor',123)";
		Connection con = MyUtil.getDBConnection();
		try
		{
			Statement stat = (Statement) con.createStatement();
			int i = stat.executeUpdate(sql);

			if (i != 0)
			{
				Statement stat2 = (Statement) con.createStatement();
				ResultSet rSet = stat2.executeQuery("select LAST_INSERT_ID()");

				int id = 0;
				if (rSet.next())
					id = rSet.getInt(1);
				System.out.println("---------------" + id);

				String sql3 = "INSERT INTO professor (ID,Name,Birthday,Status,SocialNumber,Department) VALUES('"
						+ id
						+ "','"
						+ name
						+ "','"
						+ birth
						+ "','"
						+ sta
						+ "','" + social + "','" + dep + "')";
				Statement stat3 = (Statement) con.createStatement();
				stat3.executeUpdate(sql3);
			} else
			{
				System.out.println("插入失败");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void insertStudent(StudentInfo si)
	{
		String name = si.getName();
		String birth = si.getBirthday();
		String social = si.getSocialNumber();
		String sta = si.getStatus();
		String dep = si.getGraduationDate();

		String sql = "INSERT INTO user (Type,Password) VALUES('student',123)";
		Connection con = MyUtil.getDBConnection();
		try
		{
			Statement stat = (Statement) con.createStatement();

			int i = stat.executeUpdate(sql);
			if (i != 0)
			{
				Statement stat2 = (Statement) con.createStatement();
				ResultSet rSet = stat2.executeQuery("select LAST_INSERT_ID()");

				int id = 0;
				if (rSet.next())
					id = rSet.getInt(1);

				String sql3 = "INSERT INTO student (ID,Name,Birthday,SocialNumber,Status,GraduationDate) VALUES('"
						+ id
						+ "','"
						+ name
						+ "','"
						+ birth
						+ "','"
						+ social
						+ "','" + sta + "','" + dep + "')";
				Statement stat3 = (Statement) con.createStatement();
				stat3.executeUpdate(sql3);
			} else
			{
				System.out.println("插入失败");
			}

		} catch (SQLException e)
		{
			System.out.println("连接数据库失败插入学生");
		}

	}

	public void updateProfessor(ProfessorInfo pi)
	{
		int id = pi.getId();
		String name = pi.getName();
		String birth = pi.getBirthday();
		String social = pi.getSocialNumber();
		String sta = pi.getStatus();
		String dep = pi.getDepartment();
		String sql = "UPDATE professor SET Name='" + name + "', Birthday='"
				+ birth + "', Status='" + sta + "', SocialNumber='" + social
				+ "', Department='" + dep + "' WHERE ID=" + id;
		Connection con = MyUtil.getDBConnection();
		try
		{

			Statement stat = (Statement) con.createStatement();

			int i = stat.executeUpdate(sql);
			if (i != 0)
			{
				System.out.println("插入成功");
			} else
			{
				System.out.println("插入失败");
			}

		} catch (SQLException e)
		{
			System.out.println("连接数据库失败更新教授");
		}

	}

	public void updateStudent(StudentInfo si)
	{
		int id = si.getId();
		String name = si.getName();
		String birth = si.getBirthday();
		String social = si.getSocialNumber();
		String sta = si.getStatus();
		String dep = si.getGraduationDate();
		String sql = "UPDATE student SET Name='" + name + "', Birthday='"
				+ birth + "', Status='" + sta + "', SocialNumber='" + social
				+ "', GraduationDate='" + dep + "' WHERE ID=" + id;
		Connection con = MyUtil.getDBConnection();
		try
		{

			Statement stat = (Statement) con.createStatement();

			int i = stat.executeUpdate(sql);
			if (i != 0)
			{
				System.out.println("插入成功");
			} else
			{
				System.out.println("插入失败");
			}

		} catch (SQLException e)
		{
			System.out.println("连接数据库失败更新学生");
		}

	}

	public boolean deleteProfessor(int proId)
	{
		String sql2 = "DELETE FROM user WHERE id=" + proId;
		Connection con = MyUtil.getDBConnection();
		try
		{

			Statement stat2 = (Statement) con.createStatement();
			int i = stat2.executeUpdate(sql2);
			if (i != 0)
			{
				System.out.println("删除成功");
				return true;
			} else
			{
				System.out.println("删除失败");
				return false;
			}

		} catch (SQLException e)
		{
			System.out.println("连接数据库失败删除教师");
		}

		return false;
	}

	public boolean deleteStudent(int stuId)
	{
		return deleteProfessor(stuId);
	}

	public boolean insertTeach(Teach teach)
	{

		int couoffferid = teach.getCouOffer_id();
		int proid = teach.getPro_id();
		int year = teach.getYear();
		int semester = teach.getSemester();
		// int startweek=teach.getStartweek();
		// int endweek=teach.getEndweek();
		int student_count = teach.getStudent_count();
		// String title=teach.getTitle();
		// ArrayList<TimeSlot> timeSlot=teach.getTimeSlot();

		String sql = "INSERT INTO teach VALUES(" + couoffferid + "," + proid
				+ "," + student_count + "," + year + "," + semester + ")";
		Connection con = MyUtil.getDBConnection();
		try
		{

			Statement stat = (Statement) con.createStatement();

			int i = stat.executeUpdate(sql);
			if (i != 0)
			{
				System.out.println("插入成功");
			} else
			{
				System.out.println("插入失败");
			}

		} catch (SQLException e)
		{
			return false;
		}
		return true;
	}

	public boolean deleteTeach(int couoffId, int proId)
	{
		String sql = "DELETE FROM teach WHERE  Pro_id=" + proId
				+ " and CouOffer_id=" + couoffId;
		Connection con = MyUtil.getDBConnection();
		try
		{

			Statement stat = (Statement) con.createStatement();

			int i = stat.executeUpdate(sql);
			if (i != 0)
			{
				return true;
			} else
			{
				return false;
			}

		} catch (SQLException e)
		{
			return false;
		}
	}

	public boolean insertTake(Take take)
	{

		int couoffferid = take.getCouOffer_id();
		int stuid = take.getStu_id();
		int proid = take.getPro_id();
		int year = take.getYear();
		int semester = take.getSemester();
		String grade = take.getGrade();
		String sql = "INSERT INTO takes VALUES(" + stuid + "," + proid + ","
				+ couoffferid + ",'" + grade + "'," + year + "," + semester
				+ ",'" + take.getType() + "')";
		Connection con = MyUtil.getDBConnection();
		try
		{

			Statement stat = (Statement) con.createStatement();

			int i = stat.executeUpdate(sql);
			if (i != 0)
			{
				return true;
			} else
			{
				return false;

			}

		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteTake(int couoffId, int proId, int stuId)
	{

		String sql = "DELETE FROM Takes WHERE Stu_id=" + stuId + " and Pro_id="
				+ proId + " and CouOffer_id=" + couoffId;

		Connection con = MyUtil.getDBConnection();
		try
		{

			Statement stat = (Statement) con.createStatement();

			int i = stat.executeUpdate(sql);
			if (i != 0)
			{
				System.out.println("删除成功");
				return true;
			} else
			{
				System.out.println("删除失败");
				return false;
			}

		} catch (SQLException e)
		{
			System.out.println("连接数据库失败删除take");
			return true;
		}

	}

	public ArrayList<CourseOffering> queryEligibleCourse(int id)
	{

		Calendar calendar = Calendar.getInstance();
		int cyear = calendar.get(Calendar.YEAR);
		int cmonth = calendar.get(Calendar.MONTH);

		int y;
		int s;
		if (cmonth < 8)
		{
			y = cyear - 1;
			s = 2;
		} else
		{
			y = cyear;
			s = 1;
		}

		String sql = "SELECT * FROM courseoffering,time_slot WHERE courseoffering.time_slot_id=time_slot.time_slot_id and courseoffering.Year="
				+ y
				+ " and courseoffering.Semester="
				+ s
				+ " AND Dept_Name= (SELECT Department FROM professor WHERE ID= "
				+ id + ");";

		Connection con = MyUtil.getDBConnection();

		ArrayList<CourseOffering> courses = new ArrayList<CourseOffering>();
		try
		{
			Statement stat = (Statement) con.createStatement();

			ResultSet rs = stat.executeQuery(sql);
			int lastId = -1;

			CourseOffering co = null;
			ArrayList<TimeSlot> tSlots = null;
			while (rs.next())
			{
				System.out.println(rs.getString("Title"));
				if (lastId != rs.getInt("ID"))
				{
					lastId = rs.getInt("ID");

					if (co != null)
					{
						co.setTimeSlots(tSlots);
						courses.add(co);
					}
					tSlots = new ArrayList<TimeSlot>();
					co = new CourseOffering();
					co.setId(rs.getInt("ID"));
					co.setTitle(rs.getString("Title"));
					co.setDept_name(rs.getString("Dept_Name"));
					co.setStart_week(rs.getInt("Start_Week"));
					co.setEnd_week(rs.getInt("End_Week"));
					co.setYear(rs.getInt("Year"));
					co.setSemester(rs.getInt("semester"));

				}
				TimeSlot ts = new TimeSlot();
				ts.setDay(rs.getInt("Day"));
				ts.setStart_time(rs.getInt("Start_time"));
				ts.setEnd_time(rs.getInt("End_time"));
				tSlots.add(ts);

			}
			if (co != null)
			{
				co.setTimeSlots(tSlots);
				courses.add(co);
			}
		} catch (SQLException e)
		{
			System.out.println("连接数据库失败查询所有teach");
		}
		return courses;
	}

	public ArrayList<Teach> queryLastALLTeach()
	{
		Calendar calendar = Calendar.getInstance();
		int cyear = calendar.get(Calendar.YEAR);
		int cmonth = calendar.get(Calendar.MONTH);

		int y;
		int s;
		if (cmonth < 8)
		{
			y = cyear - 1;
			s = 1;
		} else
		{
			y = cyear - 1;
			s = 2;
		}

		String sql1 = "SELECT* FROM professor,teach,courseoffering,time_slot WHERE professor.ID=teach.Pro_id AND teach.CouOffer_id=courseoffering.ID "
				+ " and courseoffering.time_slot_id=time_slot.time_slot_id and teach.Year="
				+ y + " and teach.Semester=" + s + ";";

		Connection con = MyUtil.getDBConnection();

		ArrayList<Teach> infos = new ArrayList<Teach>();
		try
		{
			Statement stat = (Statement) con.createStatement();

			ResultSet rs = stat.executeQuery(sql1);

			int m = -1;
			int pro = -1;

			int n = 1;
			Teach pf = new Teach();

			ArrayList<TimeSlot> tt = new ArrayList<TimeSlot>();
			while (rs.next())
			{

				TimeSlot ts = new TimeSlot();

				if (n == 1)
				{

					pro = rs.getInt("pro_id");
					m = rs.getInt("couOffer_id");
					ts.setDay(rs.getInt("day"));
					ts.setStart_time(rs.getInt("start_time"));
					ts.setEnd_time(rs.getInt("end_time"));
					tt.add(ts);
					pf.setTimeSlot(tt);
					pf.setStudent_count(rs.getInt("Student_count"));
					pf.setCouOffer_id(rs.getInt("couOffer_id"));
					pf.setPro_id(rs.getInt("pro_id"));
					pf.setProName(rs.getString("Name"));
					pf.setStudent_count(rs.getInt("student_count"));
					pf.setYear(rs.getInt("Year"));
					pf.setSemester(rs.getInt("semester"));
					pf.setTitle(rs.getString("Title"));
					pf.setStartweek(rs.getInt("start_week"));
					pf.setEndweek(rs.getInt("END_week"));

					n = 2;
				}

				else
				{
					if (rs.getInt("couOffer_id") != m
							|| (rs.getInt("couOffer_id") == m && rs
									.getInt("pro_id") != pro))
					{

						infos.add(pf);
						pf = new Teach();

						tt = new ArrayList<TimeSlot>();

						m = rs.getInt("couOffer_id");
						pro = rs.getInt("pro_id");
						ts.setDay(rs.getInt("day"));
						ts.setStart_time(rs.getInt("start_time"));
						ts.setEnd_time(rs.getInt("end_time"));
						tt.add(ts);
						pf.setTimeSlot(tt);
						pf.setStudent_count(rs.getInt("Student_count"));
						pf.setCouOffer_id(rs.getInt("couOffer_id"));
						pf.setPro_id(rs.getInt("pro_id"));
						pf.setProName(rs.getString("Name"));
						pf.setStudent_count(rs.getInt("student_count"));
						pf.setYear(rs.getInt("Year"));
						pf.setSemester(rs.getInt("semester"));
						pf.setTitle(rs.getString("Title"));
						pf.setStartweek(rs.getInt("start_week"));
						pf.setEndweek(rs.getInt("END_week"));

					} else
					{
						ts.setDay(rs.getInt("day"));
						ts.setStart_time(rs.getInt("start_time"));
						ts.setEnd_time(rs.getInt("end_time"));
						tt.add(ts);
						pf.setTimeSlot(tt);
					}
				}

			}

			infos.add(pf);
		} catch (SQLException e)
		{
			System.out.print("连接数据库失败查询所有teach");
		}
		/*
		 * for(int i=0;i<infos.size();i++) {
		 * System.out.print(infos.get(i).getCouOffer_id
		 * ()+" "+infos.get(i).getPro_id()+infos.get(i).getTitle());
		 * 
		 * for(int ii=0;ii<infos.get(i).getTimeSlot().size();ii++) {
		 * System.out.print
		 * (infos.get(i).getTimeSlot().get(ii).getDay()+" "+infos
		 * .get(i).getTimeSlot
		 * ().get(ii).getStart_time()+" "+infos.get(i).getTimeSlot
		 * ().get(ii).getEnd_time()+" "); } System.out.println(" ");
		 * 
		 * }
		 */
		return infos;
	}

	public ArrayList<Teach> queryCurrALLTeach()
	{
		Calendar calendar = Calendar.getInstance();
		int cyear = calendar.get(Calendar.YEAR);
		int cmonth = calendar.get(Calendar.MONTH);

		int y;
		int s;
		if (cmonth < 8)
		{
			y = cyear - 1;
			s = 2;
		} else
		{
			y = cyear;
			s = 1;
		}

		String sql1 = "SELECT* FROM professor,teach,courseoffering,time_slot WHERE professor.ID=teach.Pro_id AND teach.CouOffer_id=courseoffering.ID "
				+ " and courseoffering.time_slot_id=time_slot.time_slot_id and teach.Year="
				+ y + " and teach.Semester=" + s + ";";

		Connection con = MyUtil.getDBConnection();

		ArrayList<Teach> infos = new ArrayList<Teach>();
		try
		{
			Statement stat = (Statement) con.createStatement();

			ResultSet rs = stat.executeQuery(sql1);

			int m = -1;
			int pro = -1;

			int n = 1;
			Teach pf = new Teach();

			ArrayList<TimeSlot> tt = new ArrayList<TimeSlot>();
			while (rs.next())
			{

				TimeSlot ts = new TimeSlot();

				if (n == 1)
				{

					pro = rs.getInt("pro_id");
					m = rs.getInt("couOffer_id");
					ts.setDay(rs.getInt("day"));
					ts.setStart_time(rs.getInt("start_time"));
					ts.setEnd_time(rs.getInt("end_time"));
					tt.add(ts);
					pf.setTimeSlot(tt);
					pf.setStudent_count(rs.getInt("Student_count"));
					pf.setCouOffer_id(rs.getInt("couOffer_id"));
					pf.setPro_id(rs.getInt("pro_id"));
					pf.setProName(rs.getString("Name"));
					pf.setStudent_count(rs.getInt("student_count"));
					pf.setYear(rs.getInt("Year"));
					pf.setSemester(rs.getInt("semester"));
					pf.setTitle(rs.getString("Title"));
					pf.setStartweek(rs.getInt("start_week"));
					pf.setEndweek(rs.getInt("END_week"));

					n = 2;
				}

				else
				{
					if (rs.getInt("couOffer_id") != m
							|| (rs.getInt("couOffer_id") == m && rs
									.getInt("pro_id") != pro))
					{

						infos.add(pf);
						pf = new Teach();

						tt = new ArrayList<TimeSlot>();

						m = rs.getInt("couOffer_id");
						pro = rs.getInt("pro_id");
						ts.setDay(rs.getInt("day"));
						ts.setStart_time(rs.getInt("start_time"));
						ts.setEnd_time(rs.getInt("end_time"));
						tt.add(ts);
						pf.setTimeSlot(tt);
						pf.setStudent_count(rs.getInt("Student_count"));
						pf.setCouOffer_id(rs.getInt("couOffer_id"));
						pf.setPro_id(rs.getInt("pro_id"));
						pf.setProName(rs.getString("Name"));
						pf.setStudent_count(rs.getInt("student_count"));
						pf.setYear(rs.getInt("Year"));
						pf.setSemester(rs.getInt("semester"));
						pf.setTitle(rs.getString("Title"));
						pf.setStartweek(rs.getInt("start_week"));
						pf.setEndweek(rs.getInt("END_week"));

					} else
					{
						ts.setDay(rs.getInt("day"));
						ts.setStart_time(rs.getInt("start_time"));
						ts.setEnd_time(rs.getInt("end_time"));
						tt.add(ts);
						pf.setTimeSlot(tt);
					}
				}

			}

			infos.add(pf);
		} catch (SQLException e)
		{
			System.out.print("连接数据库失败查询所有teach");
			e.printStackTrace();
		}
		/*
		 * for(int i=0;i<infos.size();i++) {
		 * System.out.print(infos.get(i).getCouOffer_id
		 * ()+" "+infos.get(i).getPro_id()+infos.get(i).getTitle());
		 * 
		 * for(int ii=0;ii<infos.get(i).getTimeSlot().size();ii++) {
		 * System.out.print
		 * (infos.get(i).getTimeSlot().get(ii).getDay()+" "+infos
		 * .get(i).getTimeSlot
		 * ().get(ii).getStart_time()+" "+infos.get(i).getTimeSlot
		 * ().get(ii).getEnd_time()+" "); } System.out.println(" ");
		 * 
		 * }
		 */
		return infos;
	}

	public boolean checkConflit(int couid, ArrayList<Integer> oldCouids)
	{
		if (oldCouids.size() < 1)
			return false;

		String sql = "SELECT * FROM courseoffering,time_slot WHERE courseoffering.time_slot_id=time_slot.time_slot_id AND ( ID="
				+ oldCouids.get(0) + " ";

		for (int i = 1; i < oldCouids.size(); i++)
		{
			sql += " || ID=" + oldCouids.get(i);
		}
		sql += " );";

		Connection con = MyUtil.getDBConnection();

		ArrayList<CourseOffering> courses = new ArrayList<CourseOffering>();
		try
		{
			Statement stat = (Statement) con.createStatement();

			ResultSet rs = stat.executeQuery(sql);
			int lastId = -1;

			CourseOffering co = null;
			ArrayList<TimeSlot> tSlots = null;
			while (rs.next())
			{
				System.out.println(rs.getString("Title"));
				if (lastId != rs.getInt("ID"))
				{
					lastId = rs.getInt("ID");

					if (co != null)
					{
						co.setTimeSlots(tSlots);
						courses.add(co);
					}
					tSlots = new ArrayList<TimeSlot>();
					co = new CourseOffering();
					co.setId(rs.getInt("ID"));
					co.setTitle(rs.getString("Title"));
					co.setDept_name(rs.getString("Dept_Name"));
					co.setStart_week(rs.getInt("Start_Week"));
					co.setEnd_week(rs.getInt("End_Week"));
					co.setYear(rs.getInt("Year"));
					co.setSemester(rs.getInt("semester"));

				}
				TimeSlot ts = new TimeSlot();
				ts.setDay(rs.getInt("Day"));
				ts.setStart_time(rs.getInt("Start_time"));
				ts.setEnd_time(rs.getInt("End_time"));
				tSlots.add(ts);

			}
			if (co != null)
			{
				co.setTimeSlots(tSlots);
				courses.add(co);
			}
		} catch (SQLException e)
		{
			System.out.println("连接数据库失败查询所有teach");
		}
		// ------------------------
		String sql2 = "SELECT * FROM courseoffering,time_slot WHERE courseoffering.time_slot_id=time_slot.time_slot_id AND ID="
				+ couid + ";";

		ArrayList<CourseOffering> courses2 = new ArrayList<CourseOffering>();
		try
		{
			Statement stat = (Statement) con.createStatement();

			ResultSet rs = stat.executeQuery(sql2);
			int lastId = -1;

			CourseOffering co = null;
			ArrayList<TimeSlot> tSlots = null;
			while (rs.next())
			{
				System.out.println(rs.getString("Title"));
				if (lastId != rs.getInt("ID"))
				{
					lastId = rs.getInt("ID");

					if (co != null)
					{
						co.setTimeSlots(tSlots);
						courses.add(co);
					}
					tSlots = new ArrayList<TimeSlot>();
					co = new CourseOffering();
					co.setId(rs.getInt("ID"));
					co.setTitle(rs.getString("Title"));
					co.setDept_name(rs.getString("Dept_Name"));
					co.setStart_week(rs.getInt("Start_Week"));
					co.setEnd_week(rs.getInt("End_Week"));
					co.setYear(rs.getInt("Year"));
					co.setSemester(rs.getInt("semester"));

				}
				TimeSlot ts = new TimeSlot();
				ts.setDay(rs.getInt("Day"));
				ts.setStart_time(rs.getInt("Start_time"));
				ts.setEnd_time(rs.getInt("End_time"));
				tSlots.add(ts);

			}
			if (co != null)
			{
				co.setTimeSlots(tSlots);
				courses2.add(co);
			}
		} catch (SQLException e)
		{
			System.out.println("连接数据库失败查询所有teach");
		}

		boolean isConflit = false;

		CourseOffering c = courses2.get(0);
		for (CourseOffering cou : courses)
		{
			if (c.getEnd_week() < cou.getStart_week()
					|| c.getStart_week() > cou.getEnd_week())
				continue;

			ArrayList<TimeSlot> tcs = c.getTimeSlots();
			ArrayList<TimeSlot> tcous = cou.getTimeSlots();

			for (TimeSlot tc : tcs)
			{
				for (TimeSlot tcou : tcous)
				{
					if (tc.getDay() != tcou.getDay())
					{
						continue;
					}

					if (!(tc.getEnd_time() < tcou.getStart_time() || tc
							.getStart_time() > tcou.getEnd_time()))
					{
						isConflit = true;
						break;
					}
				}
				if (isConflit)
					break;
			}
			if (isConflit)
				break;
		}

		return isConflit;
	}

	public ArrayList<Teach> queryCurrTeach(int proId)
	{
		Calendar calendar = Calendar.getInstance();
		int cyear = calendar.get(Calendar.YEAR);
		int cmonth = calendar.get(Calendar.MONTH);

		int y;
		int s;
		if (cmonth < 8)
		{
			y = cyear - 1;
			s = 2;
		} else
		{
			y = cyear;
			s = 1;
		}

		String sql1 = "SELECT* FROM teach,courseoffering,time_slot WHERE teach.CouOffer_id=courseoffering.ID and courseoffering.time_slot_id=time_slot.time_slot_id and teach.Year="
				+ y + " and teach.Semester=" + s + ";";

		Connection con = MyUtil.getDBConnection();

		ArrayList<Teach> infos = new ArrayList<Teach>();
		try
		{
			Statement stat = (Statement) con.createStatement();

			ResultSet rs = stat.executeQuery(sql1);

			int m = -1;
			int n = 1;
			Teach pf = new Teach();

			ArrayList<TimeSlot> tt = new ArrayList<TimeSlot>();
			while (rs.next())
			{
				if (rs.getInt("pro_id") == proId)
				{
					TimeSlot ts = new TimeSlot();

					if (n == 1)
					{

						m = rs.getInt("couOffer_id");
						ts.setDay(rs.getInt("day"));
						ts.setStart_time(rs.getInt("start_time"));
						ts.setEnd_time(rs.getInt("end_time"));
						tt.add(ts);
						pf.setTimeSlot(tt);
						pf.setCouOffer_id(rs.getInt("couOffer_id"));
						pf.setPro_id(rs.getInt("pro_id"));
						pf.setStudent_count(rs.getInt("student_count"));
						pf.setDepartment(rs.getString("Dept_Name"));
						pf.setYear(rs.getInt("Year"));
						pf.setSemester(rs.getInt("semester"));
						pf.setTitle(rs.getString("Title"));
						pf.setStartweek(rs.getInt("start_week"));
						pf.setEndweek(rs.getInt("END_week"));

						n = 2;
					}

					else
					{
						if (rs.getInt("couOffer_id") != m)
						{

							infos.add(pf);

							pf = new Teach();

							tt = new ArrayList<TimeSlot>();

							m = rs.getInt("couOffer_id");
							ts.setDay(rs.getInt("day"));
							ts.setStart_time(rs.getInt("start_time"));
							ts.setEnd_time(rs.getInt("end_time"));
							tt.add(ts);
							pf.setTimeSlot(tt);
							pf.setCouOffer_id(rs.getInt("couOffer_id"));
							pf.setPro_id(rs.getInt("pro_id"));
							pf.setStudent_count(rs.getInt("student_count"));
							pf.setDepartment(rs.getString("Dept_Name"));
							pf.setYear(rs.getInt("Year"));
							pf.setSemester(rs.getInt("semester"));
							pf.setTitle(rs.getString("Title"));
							pf.setStartweek(rs.getInt("start_week"));
							pf.setEndweek(rs.getInt("END_week"));

						} else
						{
							ts.setDay(rs.getInt("day"));
							ts.setStart_time(rs.getInt("start_time"));
							ts.setEnd_time(rs.getInt("end_time"));
							tt.add(ts);
							pf.setTimeSlot(tt);
						}
					}
				}

			}

			infos.add(pf);
		} catch (SQLException e)
		{
			System.out.print("连接数据库失败查询所有teach");
		}
		/*
		 * for(int i=0;i<infos.size();i++) {
		 * System.out.print(infos.get(i).getCouOffer_id
		 * ()+infos.get(i).getTitle());
		 * 
		 * for(int ii=0;ii<infos.get(i).getTimeSlot().size();ii++) {
		 * System.out.print
		 * (infos.get(i).getTimeSlot().get(ii).getDay()+" "+infos
		 * .get(i).getTimeSlot
		 * ().get(ii).getStart_time()+" "+infos.get(i).getTimeSlot
		 * ().get(ii).getEnd_time()+" "); } System.out.println(" ");
		 * 
		 * }
		 */
		return infos;

	}

	public ArrayList<Teach> queryLastTeach(int proId)
	{
		Calendar calendar = Calendar.getInstance();
		int cyear = calendar.get(Calendar.YEAR);
		int cmonth = calendar.get(Calendar.MONTH);

		int y;
		int s;
		if (cmonth < 8)
		{
			y = cyear - 1;
			s = 1;
		} else
		{
			y = cyear - 1;
			s = 2;
		}

		String sql1 = "SELECT* FROM teach,courseoffering,time_slot WHERE teach.CouOffer_id=courseoffering.ID and courseoffering.time_slot_id=time_slot.time_slot_id and teach.Year="
				+ y + " and teach.Semester=" + s + ";";

		Connection con = MyUtil.getDBConnection();

		ArrayList<Teach> infos = new ArrayList<Teach>();
		try
		{
			Statement stat = (Statement) con.createStatement();

			ResultSet rs = stat.executeQuery(sql1);

			int m = -1;
			int n = 1;
			Teach pf = new Teach();

			ArrayList<TimeSlot> tt = new ArrayList<TimeSlot>();
			while (rs.next())
			{
				if (rs.getInt("pro_id") == proId)
				{
					TimeSlot ts = new TimeSlot();

					if (n == 1)
					{

						m = rs.getInt("couOffer_id");
						ts.setDay(rs.getInt("day"));
						ts.setStart_time(rs.getInt("start_time"));
						ts.setEnd_time(rs.getInt("end_time"));
						tt.add(ts);
						pf.setTimeSlot(tt);
						pf.setCouOffer_id(rs.getInt("couOffer_id"));
						pf.setPro_id(rs.getInt("pro_id"));
						pf.setStudent_count(rs.getInt("student_count"));
						pf.setDepartment(rs.getString("Dept_Name"));
						pf.setYear(rs.getInt("Year"));
						pf.setSemester(rs.getInt("semester"));
						pf.setTitle(rs.getString("Title"));
						pf.setStartweek(rs.getInt("start_week"));
						pf.setEndweek(rs.getInt("END_week"));

						n = 2;
					}

					else
					{
						if (rs.getInt("couOffer_id") != m)
						{

							infos.add(pf);

							pf = new Teach();

							tt = new ArrayList<TimeSlot>();

							m = rs.getInt("couOffer_id");
							ts.setDay(rs.getInt("day"));
							ts.setStart_time(rs.getInt("start_time"));
							ts.setEnd_time(rs.getInt("end_time"));
							tt.add(ts);
							pf.setTimeSlot(tt);
							pf.setCouOffer_id(rs.getInt("couOffer_id"));
							pf.setPro_id(rs.getInt("pro_id"));
							pf.setStudent_count(rs.getInt("student_count"));
							pf.setDepartment(rs.getString("Dept_Name"));
							pf.setYear(rs.getInt("Year"));
							pf.setSemester(rs.getInt("semester"));
							pf.setTitle(rs.getString("Title"));
							pf.setStartweek(rs.getInt("start_week"));
							pf.setEndweek(rs.getInt("END_week"));

						} else
						{
							ts.setDay(rs.getInt("day"));
							ts.setStart_time(rs.getInt("start_time"));
							ts.setEnd_time(rs.getInt("end_time"));
							tt.add(ts);
							pf.setTimeSlot(tt);
						}
					}
				}

			}

			infos.add(pf);
		} catch (SQLException e)
		{
			System.out.print("连接数据库失败查询所有teach");
		}
		/*
		 * for(int i=0;i<infos.size();i++) {
		 * System.out.print(infos.get(i).getCouOffer_id
		 * ()+infos.get(i).getTitle());
		 * 
		 * for(int ii=0;ii<infos.get(i).getTimeSlot().size();ii++) {
		 * System.out.print
		 * (infos.get(i).getTimeSlot().get(ii).getDay()+" "+infos
		 * .get(i).getTimeSlot
		 * ().get(ii).getStart_time()+" "+infos.get(i).getTimeSlot
		 * ().get(ii).getEnd_time()+" "); } System.out.println(" ");
		 * 
		 * }
		 */
		return infos;

	}

	public ArrayList<StudentGrade> queryALLStudents(int couoffId, int proId)
	{
		String sql = "SELECT* FROM student,takes WHERE student.ID=takes.Stu_Id ";
		Connection con = MyUtil.getDBConnection();
		ArrayList<StudentGrade> infos = new ArrayList<StudentGrade>();
		try
		{

			Statement stat = (Statement) con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next())
			{
				if (rs.getInt("Pro_Id") == proId
						&& rs.getInt("CouOffer_Id") == couoffId)
				{
					StudentGrade pf = new StudentGrade();
					pf.setId(rs.getInt("ID"));
					// pf.setSocialNumber(rs.getString("SocialNumber"));
					pf.setName(rs.getString("Name"));
					pf.setGrade(rs.getString("Grade"));
					// pf.setBirthday(rs.getString("Birthday"));
					// pf.setGraduationDate(rs.getString("GraduationDate"));
					// pf.setStatus(rs.getString("Status"));
					// System.out.println(pf.getId() + " " + pf.getName() + " "
					// + pf.getBirthday() + " " + pf.getStatus() + " "
					// + pf.getSocialNumber() + " "
					// + pf.getGraduationDate());
					infos.add(pf);
				}
			}
		} catch (SQLException e)
		{
			System.out.print("连接数据库失败查询所有学生");
		}
		// for(int i=0;i<infos.size();i++)
		// {
		// System.out.println(infos.get(i).getName());
		// }
		return infos;

	}

	public void updateStudentGrade(int couoffId, int proId, int stuId,
			String grade)
	{

		String sql = "UPDATE takes SET Grade= '" + grade + "' WHERE Stu_id="
				+ stuId + " and Pro_id=" + proId + " and CouOffer_id="
				+ couoffId;
		Connection con = MyUtil.getDBConnection();
		try
		{

			Statement stat = (Statement) con.createStatement();

			int i = stat.executeUpdate(sql);

			if (i != 0)
			{
				System.out.println("插入成功");
			} else
			{
				System.out.println("插入失败");
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

	public ArrayList<Take> queryCurrALLTakes(int stuId)
	{
		Calendar calendar = Calendar.getInstance();
		int cyear = calendar.get(Calendar.YEAR);
		int cmonth = calendar.get(Calendar.MONTH);

		int y;
		int s;
		if (cmonth < 8)
		{
			y = cyear - 1;
			s = 2;
		} else
		{
			y = cyear;
			s = 1;
		}

		String sql1 = "SELECT Type,Grade,CouOffer_id,title,pro_id,stu_id,Name,takes.year,takes.semester,Start_Week,End_Week,Day,Start_time,End_time,grade FROM professor,courseoffering,time_slot,takes WHERE takes.Pro_id=professor.ID and courseoffering.time_slot_id=time_slot.time_slot_id "
				+ " and takes.CouOffer_id=courseoffering.ID"
				+ " and courseoffering.time_slot_id=time_slot.time_slot_id and takes.Year="
				+ y + " and takes.Semester=" + s + ";";

		Connection con = MyUtil.getDBConnection();

		ArrayList<Take> infos = new ArrayList<Take>();
		try
		{
			if(con == null)
				return null;
			Statement stat = (Statement) con.createStatement();

			ResultSet rs = stat.executeQuery(sql1);

			int m = -1;
			int n = 1;
			Take pf = new Take();

			ArrayList<TimeSlot> tt = new ArrayList<TimeSlot>();
			while (rs.next())
			{
				if (rs.getInt("stu_id") == stuId)
				{
					TimeSlot ts = new TimeSlot();

					if (n == 1)
					{

						m = rs.getInt("couOffer_id");
						ts.setDay(rs.getInt("day"));
						ts.setStart_time(rs.getInt("start_time"));
						ts.setEnd_time(rs.getInt("end_time"));
						tt.add(ts);
						pf.setGrade(rs.getString("Grade"));
						pf.setType(rs.getString("Type"));
						pf.setTimeSlot(tt);
						pf.setCouOffer_id(rs.getInt("couOffer_id"));
						pf.setPro_id(rs.getInt("pro_id"));
						pf.setProfessorName(rs.getString("Name"));
						pf.setYear(rs.getInt("Year"));
						pf.setSemester(rs.getInt("semester"));
						pf.setTitle(rs.getString("Title"));
						pf.setStartweek(rs.getInt("start_week"));
						pf.setEndweek(rs.getInt("END_week"));
						pf.setStu_id(rs.getInt("stu_id"));

						n = 2;
					}

					else
					{
						if (rs.getInt("couOffer_id") != m)
						{

							infos.add(pf);

							pf = new Take();

							tt = new ArrayList<TimeSlot>();

							m = rs.getInt("couOffer_id");
							ts.setDay(rs.getInt("day"));
							ts.setStart_time(rs.getInt("start_time"));
							ts.setEnd_time(rs.getInt("end_time"));
							tt.add(ts);
							pf.setTimeSlot(tt);
							pf.setGrade(rs.getString("Grade"));
							pf.setType(rs.getString("Type"));
							pf.setCouOffer_id(rs.getInt("couOffer_id"));
							pf.setPro_id(rs.getInt("pro_id"));
							pf.setProfessorName(rs.getString("Name"));
							pf.setYear(rs.getInt("Year"));
							pf.setSemester(rs.getInt("semester"));
							pf.setTitle(rs.getString("Title"));
							pf.setStartweek(rs.getInt("start_week"));
							pf.setEndweek(rs.getInt("END_week"));
							pf.setStu_id(rs.getInt("stu_id"));

						} else
						{
							ts.setDay(rs.getInt("day"));
							ts.setStart_time(rs.getInt("start_time"));
							ts.setEnd_time(rs.getInt("end_time"));
							tt.add(ts);
							pf.setTimeSlot(tt);
						}
					}

				}
			}
			if (pf.getTimeSlot() != null)
			{
				infos.add(pf);
			}
		} catch (SQLException e)
		{
			System.out.print("连接数据库失败查询所有teach");
		}
		/*
		 * for(int i=0;i<infos.size();i++) {
		 * System.out.print(infos.get(i).getCouOffer_id
		 * ()+infos.get(i).getTitle()
		 * +infos.get(i).getPro_id()+infos.get(i).getProfessorName());
		 * 
		 * for(int ii=0;ii<infos.get(i).getTimeSlot().size();ii++) {
		 * System.out.print
		 * (infos.get(i).getTimeSlot().get(ii).getDay()+" "+infos
		 * .get(i).getTimeSlot
		 * ().get(ii).getStart_time()+" "+infos.get(i).getTimeSlot
		 * ().get(ii).getEnd_time()+" "); } System.out.println(" ");
		 * 
		 * }
		 */

		return infos;

	}

	public ArrayList<Take> queryBeforeALLTakes(int stuId)
	{
		Calendar calendar = Calendar.getInstance();
		int cyear = calendar.get(Calendar.YEAR);
		int cmonth = calendar.get(Calendar.MONTH);

		int y;
		int s;
		if (cmonth < 8)
		{
			y = cyear - 1;
			s = 2;
		} else
		{
			y = cyear;
			s = 1;
		}

		String sql1 = "SELECT Type,Grade,CouOffer_id,title,pro_id,stu_id,Name,takes.year,takes.semester,Start_Week,End_Week,Day,Start_time,End_time,grade FROM professor,courseoffering,time_slot,takes WHERE takes.Pro_id=professor.ID and courseoffering.time_slot_id=time_slot.time_slot_id "
				+ " and takes.CouOffer_id=courseoffering.ID"
				+ " and courseoffering.time_slot_id=time_slot.time_slot_id and  ( takes.Year <>"
				+ y + " or takes.Semester <>" + s + " );";

		Connection con = MyUtil.getDBConnection();

		ArrayList<Take> infos = new ArrayList<Take>();
		try
		{
			Statement stat = (Statement) con.createStatement();

			ResultSet rs = stat.executeQuery(sql1);

			int m = -1;
			int n = 1;
			Take pf = new Take();

			ArrayList<TimeSlot> tt = new ArrayList<TimeSlot>();
			while (rs.next())
			{
				if (rs.getInt("stu_id") == stuId)
				{
					TimeSlot ts = new TimeSlot();

					if (n == 1)
					{

						m = rs.getInt("couOffer_id");
						ts.setDay(rs.getInt("day"));
						ts.setStart_time(rs.getInt("start_time"));
						ts.setEnd_time(rs.getInt("end_time"));
						tt.add(ts);
						pf.setGrade(rs.getString("Grade"));
						pf.setType(rs.getString("Type"));
						pf.setTimeSlot(tt);
						pf.setCouOffer_id(rs.getInt("couOffer_id"));
						pf.setPro_id(rs.getInt("pro_id"));
						pf.setProfessorName(rs.getString("Name"));
						pf.setYear(rs.getInt("Year"));
						pf.setSemester(rs.getInt("semester"));
						pf.setTitle(rs.getString("Title"));
						pf.setStartweek(rs.getInt("start_week"));
						pf.setEndweek(rs.getInt("END_week"));
						pf.setStu_id(rs.getInt("stu_id"));

						n = 2;
					}

					else
					{
						if (rs.getInt("couOffer_id") != m)
						{

							infos.add(pf);

							pf = new Take();

							tt = new ArrayList<TimeSlot>();

							m = rs.getInt("couOffer_id");
							ts.setDay(rs.getInt("day"));
							ts.setStart_time(rs.getInt("start_time"));
							ts.setEnd_time(rs.getInt("end_time"));
							tt.add(ts);
							pf.setTimeSlot(tt);
							pf.setGrade(rs.getString("Grade"));
							pf.setType(rs.getString("Type"));
							pf.setCouOffer_id(rs.getInt("couOffer_id"));
							pf.setPro_id(rs.getInt("pro_id"));
							pf.setProfessorName(rs.getString("Name"));
							pf.setYear(rs.getInt("Year"));
							pf.setSemester(rs.getInt("semester"));
							pf.setTitle(rs.getString("Title"));
							pf.setStartweek(rs.getInt("start_week"));
							pf.setEndweek(rs.getInt("END_week"));
							pf.setStu_id(rs.getInt("stu_id"));

						} else
						{
							ts.setDay(rs.getInt("day"));
							ts.setStart_time(rs.getInt("start_time"));
							ts.setEnd_time(rs.getInt("end_time"));
							tt.add(ts);
							pf.setTimeSlot(tt);
						}
					}

				}
			}
			if (pf.getTimeSlot() != null)
			{
				infos.add(pf);
			}
		} catch (SQLException e)
		{
			System.out.print("连接数据库失败查询所有teach");
		}
		/*
		 * for(int i=0;i<infos.size();i++) {
		 * System.out.print(infos.get(i).getCouOffer_id
		 * ()+infos.get(i).getTitle()
		 * +infos.get(i).getPro_id()+infos.get(i).getProfessorName());
		 * 
		 * for(int ii=0;ii<infos.get(i).getTimeSlot().size();ii++) {
		 * System.out.print
		 * (infos.get(i).getTimeSlot().get(ii).getDay()+" "+infos
		 * .get(i).getTimeSlot
		 * ().get(ii).getStart_time()+" "+infos.get(i).getTimeSlot
		 * ().get(ii).getEnd_time()+" "); } System.out.println(" ");
		 * 
		 * }
		 */

		return infos;

	}

	public boolean deleteALLTakes(int stuId)
	{
		String sql = "DELETE FROM Takes WHERE Stu_id=" + stuId;

		Connection con = MyUtil.getDBConnection();
		try
		{

			Statement stat = (Statement) con.createStatement();

			int i = stat.executeUpdate(sql);

			if (i != 0)
			{
				System.out.println("删除成功");
				return true;
			} else
			{
				System.out.println("删除失败");
				return false;
			}

		} catch (SQLException e)
		{
			System.out.println("连接数据库失败删除alltake");
			return false;
		}
	}
}
