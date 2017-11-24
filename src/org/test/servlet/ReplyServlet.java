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
import org.test.bean.Reply;
import org.test.bean.Theme;
import org.test.bean.User;
import org.test.dao.BclassDao;
import org.test.dao.ReplyDao;
import org.test.dao.ThemeDao;
import org.test.utils.Page;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class BclassServlet
 */
@WebServlet("/replyServlet")
public class ReplyServlet extends ServletMain {
	private ReplyDao rd = new ReplyDao();

	public ReplyServlet() {
		super();
	}

	/**
	 * 上午10:45:11 2017年11月23日
	 * 查询所有回复贴
	 */
	public void selectAllWithUserPicture(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String tid = request.getParameter("tid");
		 List<Reply> rl = rd.selectAllWithUserPicture(Integer.parseInt(tid));
		String json = JSON.toJSONString(rl);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(json);
	}

	
	/**
	 * 上午10:44:45 2017年11月23日
	 * 查询帖子并值放域中跳转
	 */
	public void selectWithId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             String tid = request.getParameter("tid");
             Theme theme= rd.selectWithId(Integer.parseInt(tid));
             response.setContentType("text/html;charset=utf-8");
             request.setAttribute("theme", theme);
             request.getRequestDispatcher("getway/theme.jsp").forward(request, response);
             return;
	
	}

	/**
	 * 上午9:45:15 2017年11月23日
	 * 回复贴
	 */
	public void replyTheme(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tid = request.getParameter("tid");
		String replyBody = request.getParameter("replyBody");
		Reply reply = new Reply();
		reply.setThemeId(Integer.parseInt(tid));
		reply.setReplyBody(replyBody);
		reply.setReplyTime(new Date().toLocaleString());
		User user = (User) request.getSession().getAttribute("user");
		reply.setUserId(user.getUserId());
		reply.setUserPicture(user.getUserPicture());
		reply.setUserName(user.getUserName());
		rd.replayTheme(reply);
		 
		String json = JSON.toJSONString(reply);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(json);
		return;
		
	}
	/**
	 * 上午9:45:15 2017年11月23日
	 * 删除回复贴
	 */
	public void delReplyWithId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rid = request.getParameter("rid");
		rd.delReplyWithId(Integer.parseInt(rid));
		response.setContentType("text/html;charset=utf-8");
		response.sendRedirect(request.getContextPath()+"/getway/theme.jsp");
		return;
		
	}

}
