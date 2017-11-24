package org.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.test.bean.Bclass;
import org.test.bean.Theme;
import org.test.bean.User;
import org.test.dao.BclassDao;
import org.test.dao.ThemeDao;
import org.test.utils.Page;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class BclassServlet
 */
@WebServlet("/themeServlet")
public class themeServlet extends ServletMain {
	private ThemeDao td = new ThemeDao();

	public themeServlet() {
		super();
	}

	/**
	 * ����12:47:17 2017��11��23��
	 * ��ѯ������
	 */
	public void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Page page = td.selectAll();
		String json = JSON.toJSONString(page);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(json);
	}

	/**
	 * ����12:47:17 2017��11��23��
	 * ��ѯָ���������
	 */
	public void selectAllByBclassId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid = request.getParameter("bid");
		Page page = td.selectAllByBclassId(Integer.parseInt(bid));
		String json = JSON.toJSONString(page);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(json);
	}

 

	/**
	 * ����12:47:27 2017��11��23��
	 * ����id����
	 */
	public void selectWithId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             String tid = request.getParameter("tid");
             Theme theme= td.selectWithId(Integer.parseInt(tid));
             td.addThemeViewCount(tid);
             response.setContentType("text/html;charset=utf-8");
             request.setAttribute("theme", theme);
             request.getRequestDispatcher("getway/theme.jsp").forward(request, response);
             return;
	
	}

	/**
	 * ����12:47:39 2017��11��23��
	 * �����ö���ȡ��
	 */
	public void topTheme(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tid = request.getParameter("tid");
		String top = request.getParameter("top");
		Theme theme= td.selectWithId(Integer.parseInt(tid));
		td.topTheme(tid,top);
		/*response.setContentType("text/html;charset=utf-8");
		request.setAttribute("theme", theme);
		request.getRequestDispatcher("getway/theme.jsp").forward(request, response);*/
		return;
		
	}
	
	/**
	 * ����12:47:39 2017��11��23��
	 * ���Ӿ�����ȡ��
	 */
	public void signTheme(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tid = request.getParameter("tid");
		String sign = request.getParameter("sign");
		//Theme theme= td.selectWithId(Integer.parseInt(tid));
		td.signTheme(tid,sign);
		/*response.setContentType("text/html;charset=utf-8");
		request.setAttribute("theme", theme);
		request.getRequestDispatcher("getway/theme.jsp").forward(request, response);*/
		return;
		
	}

	/**
	 * ����12:47:39 2017��11��23��
	 * ���Ӿ�����ȡ��
	 */
	public void newTheme(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String themeTitle = request.getParameter("themeTitle");
		String themeBody = request.getParameter("themeBody");
		String classId = request.getParameter("classId");
		User user = (User) request.getSession().getAttribute("user");
		Theme theme = new Theme();
		theme.setClassId(Integer.parseInt(classId));
		theme.setThemeBody(themeBody);
		theme.setThemeIsTop(0);
		theme.setThemeSign(0);
		theme.setThemeTime(new Date().toLocaleString());
		theme.setThemeViewCount(0);
		theme.setUserId(Integer.parseInt(user.getUserId()));
		theme.setUserName(user.getUserName());
		theme.setThemeTitle(themeTitle);
		//Theme theme= td.selectWithId(Integer.parseInt(tid));
		td.newTheme(theme);
		/*response.setContentType("text/html;charset=utf-8");
		request.setAttribute("theme", theme);
		request.getRequestDispatcher("getway/theme.jsp").forward(request, response);*/
		return;
		
	}

}
