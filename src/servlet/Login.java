package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.servlet.RequestDispatcher;

import bean.DbManager;
import bean.User;

//http://localhost:8080/CoRegSystem
/*
 * request.getParameter()获取请求参数
 *        .set/get Attribute()可用来在请求转发时传递 数据
 */
public class Login extends HttpServlet
{
	private String userName;
	private String password;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		userName = (String) request.getParameter("userName");
		password = (String) request.getParameter("password");
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		DbManager dbManager = new DbManager();
		if (userName != null)
		{
			String type=null;
			try
			{
				type= dbManager.checkUser(Integer.parseInt(userName),
						password);
			} catch (NumberFormatException e)
			{
				response.sendRedirect(contextPath
						+ "/login.jsp?errInfo=ErrUserNameFormat");
				return;
			}
		 

			if (type != null)
			{
				User user = new User(Integer.parseInt(userName));
				session.setAttribute("user", user);
				if (type.equals("professor"))
				{

					response.sendRedirect(contextPath
							+ "/Professor/home.jsp?userName=" + userName);

				} else if (type.equals("student"))
				{

					response.sendRedirect(contextPath
							+ "/Student/home.jsp?userName=" + userName);

				} else if (type.equals("registrar"))
				{

					response.sendRedirect(contextPath
							+ "/Registar/home.jsp?userName=" + userName);

				}
			} else
			{
				response.sendRedirect(contextPath
						+ "/login.jsp?errInfo=errUserName");
			}
		} else
		{
			response.sendRedirect(contextPath
					+ "/login.jsp?errInfo=errUserName");
		}

	}

}
