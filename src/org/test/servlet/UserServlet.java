package org.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.test.bean.User;
import org.test.dao.UserDao;
import org.test.utils.Page;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userServlet")
public class UserServlet extends ServletMain {
	private UserDao ud = new UserDao();

	public UserServlet() {
		super();
	}

	public void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Page page = ud.selectAll();
		String json = JSON.toJSONString(page);
		PrintWriter out = response.getWriter();
		out.write(json);

	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
	/*	PrintWriter out = response.getWriter();
		out.write("ok");*/
		return;

	}
	
	public void selectWithId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String uid = request.getParameter("uid");
		User user= ud.selectUserByUserId(Integer.parseInt(uid));
		String json = JSON.toJSONString(user);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(json);
		return;
		
	}

	public void selectWithUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		User user= ud.selectUserByUserName(userName);
		PrintWriter out = response.getWriter();
		String state="error";
        if(user==null){
          state="yes";
        }
        out.write(state);
		return;
		
	}

	/**
	 * 上午8:44:18 2017年11月22日 登录
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = ud.selectUserByUserName(userName);

		if (user == null || user.getState().equals("1")) {
		} else {
			if (user.getUserPwd().equals(password)) {
				request.getSession().setAttribute("user", user);
				out.write("ok");
				return;
			}
		}
		out.write("账号密码错误或是你已被加入黑名单!");

	}

	
	/**
	 * 下午12:47:39 2017年11月23日
	 * 用户黑名单
	 */
	public void userBlack(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String state = request.getParameter("state");
		//Theme theme= td.selectWithId(Integer.parseInt(tid));
		ud.signTheme(uid,state);
		/*response.setContentType("text/html;charset=utf-8");
		request.setAttribute("theme", theme);
		request.getRequestDispatcher("getway/theme.jsp").forward(request, response);*/
		return;
		
	}
	
}
