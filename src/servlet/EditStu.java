package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DbManager;
import bean.StudentInfo;

public class EditStu extends HttpServlet
{

	/**
	 * Constructor of the object.
	 */
	public EditStu()
	{
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

	
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
        String id = (String) request.getParameter("update_id");
		String name = (String) request.getParameter("name");
		String year = (String) request.getParameter("year");
		String month = (String) request.getParameter("month");
		String date = (String) request.getParameter("date");
		String number = (String) request.getParameter("number");
		String status = (String) request.getParameter("status");
		
		String gdate = (String) request.getParameter("gradate");
		String gyear = (String) request.getParameter("grayear");
		String gmonth = (String) request.getParameter("gramonth");
		
	     name = new String(name.getBytes("ISO-8859-1"), "UTF-8"); 
         status = new String(status.getBytes("ISO-8859-1"), "UTF-8");  

		StudentInfo stuInfo = new StudentInfo();
		stuInfo.setId(Integer.parseInt(id.trim()));
		stuInfo.setName(name);
		String birthday = year + "." + month + "." + date;
		stuInfo.setBirthday(birthday);
		stuInfo.setSocialNumber(number);
		stuInfo.setStatus(status);
		String graday = gyear + "." + gmonth + "." + gdate;
		stuInfo.setGraduationDate(graday);
		DbManager dbManager = new DbManager();
		dbManager.updateStudent(stuInfo);
		
		 response.sendRedirect(request.getContextPath()
					+ "/Registar/StudentInfo/studentInfo.jsp?msg=edit student successfully");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException
	{
		// Put your code here
	}

}
