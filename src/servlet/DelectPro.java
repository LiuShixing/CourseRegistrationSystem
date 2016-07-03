package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.model.core.ID;

import bean.DbManager;

public class DelectPro extends HttpServlet
{

	/**
	 * Constructor of the object.
	 */
	public DelectPro()
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
        	 if(dbManager.deleteProfessor(Integer.parseInt(id)))
        	 {
        		 response.sendRedirect(contextPath + "/Registar/ProfessorInfo/professorInfo.jsp?msg=delete professor successfully");
        	 }
        	 else {
        		 response.sendRedirect(contextPath + "/Registar/errorPage.jsp?msg=delete professor failure");
			}
		}
         else {
        	 response.sendRedirect(contextPath + "/Registar/errorPage.jsp?msg=delete professor failure");
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
