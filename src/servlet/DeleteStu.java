package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DbManager;

public class DeleteStu extends HttpServlet
{

	/**
	 * Constructor of the object.
	 */
	public DeleteStu()
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
		String contextPath = request.getContextPath();

        DbManager dbManager = new DbManager();
        String id = request.getParameter("id");
    
        if(id!=null)
        {
       	 if(dbManager.deleteStudent(Integer.parseInt(id)))
       	 {
       		 response.sendRedirect(contextPath + "/Registar/StudentInfo/studentInfo.jsp?msg=delete student successfully");
       	 }
       	 else {
       		 response.sendRedirect(contextPath + "/Registar/errorPage.jsp?msg=delete student failure");
			}
		}
        else {
       	 response.sendRedirect(contextPath + "/Registar/errorPage.jsp?msg=delete student failure");
		}
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
		
        doGet(request, response);
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
