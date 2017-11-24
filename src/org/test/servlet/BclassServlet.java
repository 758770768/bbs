package org.test.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.test.bean.Bclass;
import org.test.bean.User;
import org.test.dao.BclassDao;
import org.test.utils.Page;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class BclassServlet
 */
@WebServlet("/bclassServlet")
public class BclassServlet extends ServletMain {
	private BclassDao bd = new BclassDao();

	public BclassServlet() {
		super();
	}

	public void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Page page = bd.selectAll();
		String json = JSON.toJSONString(page);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(json);
	}

	/**
	 * 下午12:51:12 2017年11月24日 选择板块依据id
	 */
	public void selectBclassById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("bid");
		Bclass b = bd.selectBclassWithId(Integer.parseInt(cid));
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("bclass", b);
		request.getRequestDispatcher("getway/bclass.jsp").forward(request, response);
		return;
	}

	/**
	 * 下午12:51:03 2017年11月24日 添加板块
	 */
	public void newBclass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory df = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(df);
		List<FileItem> fl = null;
		Bclass bc = new Bclass();
		try {
			fl = sfu.parseRequest(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (FileItem item : fl) {
			if (item.isFormField()) {
				String name = item.getFieldName();
				if ("className".equals(name)) {
					bc.setClassName(item.getString("utf-8"));
				}
				if ("classMsg".equals(name)) {
					bc.setClassMsg(item.getString("utf-8"));
				}
			} else {
				String fileName = item.getName();
				// String upload =
				// request.getServletContext().getRealPath("upload");
				File file = new File("D:/apache-tomcat-7.0.81-windows-x86/apache-tomcat-7.0.81/webapps/image",
						fileName);
				try {
					item.write(file);
					bc.setClassPicture("http://localhost:8080/image/" + fileName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		User user = (User) request.getSession().getAttribute("user");
		bc.setSignCount(0);
		bc.setThemeCount("0");
		bc.setModeratorName(user.getUserName());
		bd.addBclass(bc);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("ok");
		return;
	}

}
