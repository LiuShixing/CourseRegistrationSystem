package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DbManager;
import bean.Take;
import bean.Teach;

public class StuAddCou extends HttpServlet
{

	/**
	 * Constructor of the object.
	 */
	public StuAddCou()
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		int couid = Integer.parseInt(request.getParameter("couId").trim());
		int proid = Integer.parseInt(request.getParameter("proId").trim());
		int stuid = Integer.parseInt(request.getParameter("stuId").trim());
		int year = Integer.parseInt(request.getParameter("year").trim());
		int semester = Integer.parseInt(request.getParameter("semester").trim());
		String from = request.getParameter("from");

		Take take = new Take();
		take.setCouOffer_id(couid);
		take.setPro_id(proid);
		take.setStu_id(stuid);
		take.setGrade("");
		take.setYear(year);
		take.setSemester(semester);

		DbManager dbManager = new DbManager();
		
		ArrayList<Integer> counts=dbManager.queryStuCouCount(stuid);
		if (counts.get(0)<4)
		{
			take.setType("main");
		}
		else if (counts.get(1)<2)
		{
			take.setType("alternate");
		}
		else {
			if (from.equals("create"))
			{
				response.sendRedirect(request.getContextPath()
						+ "/Student/create.jsp?msg=failure!!!  schedule is full");
			} else
			{
				response.sendRedirect(request.getContextPath()
						+ "/Student/update.jsp?msg=failure!!!  schedule is full");
			}
			return;
		}
		
		
		ArrayList<Take> takes = dbManager.queryCurrALLTakes(stuid);
		ArrayList<Integer> oldCouids = new ArrayList<Integer>();
		
		for (Take t : takes)
		{
			oldCouids.add(t.getCouOffer_id());
		}
		
		if(dbManager.checkConflit(couid, oldCouids))
		{
			if (from.equals("create"))
			{
				response.sendRedirect(request.getContextPath()
						+ "/Student/create.jsp?msg=failure!!!  course conflit");
			} else
			{
				response.sendRedirect(request.getContextPath()
						+ "/Student/update.jsp?msg=failure!!!  course conflit");
			}
			return;
		}
		
		
		if (dbManager.insertTake(take))
		{
			if (from.equals("create"))
			{
				response.sendRedirect(request.getContextPath()
						+ "/Student/create.jsp?msg=select cource successfully");
			} else
			{
				response.sendRedirect(request.getContextPath()
						+ "/Student/update.jsp?msg=select cource successfully");
			}
		} else
		{
			if (from.equals("create"))
			{
				response.sendRedirect(request.getContextPath()
						+ "/Student/create.jsp?msg=cource had been selected");
			} else
			{
				response.sendRedirect(request.getContextPath()
						+ "/Student/update.jsp?msg=cource had been selected");
			}
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException
	{
		// Put your code here
	}

}
