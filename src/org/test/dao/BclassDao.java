package org.test.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.test.bean.Bclass;
import org.test.utils.DBM;
import org.test.utils.Page;

public class BclassDao {
	private QueryRunner qr = new QueryRunner();
	private Connection conn = DBM.getConn();
	private Page page = new Page();

	public Page selectAll() {
		String sqlPage1 = "select * from bclass";
		String sqlCount = "select count(*) from bclass";
		try {
			List<Bclass> bl = qr.query(conn, sqlPage1, new BeanListHandler<Bclass>(Bclass.class));
			Long total = qr.query(conn, sqlCount, new ScalarHandler<Long>(1));
			page.setRows(bl);
			page.setTotal(total.intValue());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

	public Bclass selectBclassWithId(int cid) {
             String sql="select * from bclass where classId=?";
             List<Bclass> bl=null;
             try {
		      bl = qr.query(conn, sql, new BeanListHandler<Bclass>(Bclass.class),cid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return bl.size()>0?bl.get(0):null;
	}

	/**
	 * 下午1:04:26 2017年11月24日
	 * 添加板块
	 */
	public void addBclass(Bclass bc) {
		 String sql="insert into bclass(className,classMsg,moderatorName,themeCount,signCount,classPicture) values(?,?,?,?,?,?)";
		 try {
			qr.update(conn, sql, bc.getClassName(),bc.getClassMsg(),bc.getModeratorName(),bc.getThemeCount(),bc.getSignCount(),bc.getClassPicture());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return;
	}

}
