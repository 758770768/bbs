package org.test.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.test.bean.Bclass;
import org.test.bean.Theme;
import org.test.utils.DBM;
import org.test.utils.Page;

public class ThemeDao {
	private QueryRunner qr = new QueryRunner();
	private Connection conn = DBM.getConn();
	private Page page = new Page();

	/**
	 * 下午12:51:12 查询所有返回page2017年11月23日
	 */
	public Page selectAll() {
		String sqlPage1 = "select * from theme    order by themeSign desc,themeTime desc";
		String sqlCount = "select count(*) from theme";
		try {
			List<Theme> bl = qr.query(conn, sqlPage1, new BeanListHandler<Theme>(Theme.class));
			Long total = qr.query(conn, sqlCount, new ScalarHandler<Long>(1));
			page.setRows(bl);
			page.setTotal(total.intValue());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

	/**
	 * 下午12:51:12 查询所有返回page2017年11月23日
	 */
	public Page selectAllByBclassId(Integer bid) {
		String sqlPage1 = "select * from theme where classId=? order by themeSign desc,themeTime desc";
		String sqlCount = "select count(*) from theme";
		try {
			List<Theme> bl = qr.query(conn, sqlPage1, new BeanListHandler<Theme>(Theme.class),bid);
			Long total = qr.query(conn, sqlCount, new ScalarHandler<Long>(1));
			page.setRows(bl);
			page.setTotal(total.intValue());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

	/**
	 * 下午12:50:58 2017年11月23日
	 * 查询帖子依据ID
	 */
	public Theme selectWithId(int parseInt) {
             String sql="select * from theme where themeId=?";
             List<Theme> tl=null;
             try {
				tl = qr.query(conn, sql, new BeanListHandler<Theme>(Theme.class), parseInt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return tl.size()>0?tl.get(0):null;
	}

	/**
	 * 下午12:50:50 2017年11月23日
	 * 修改点击量
	 */
	public void addThemeViewCount(String tid) {
        String sql="update theme set themeViewCount=themeViewCount+1 where themeId=?";
        try {
			qr.update(conn, sql, Integer.parseInt(tid));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/**
	 * 下午12:50:42 2017年11月23日
	 * 置顶帖
	 */
	public void topTheme(String tid, String top) {
		 String sql="update theme set themeIsTop=? where themeId=?";
	        try {
				qr.update(conn, sql, Integer.parseInt(top),Integer.parseInt(tid));
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}

	/**
	 * 下午5:24:57 2017年11月23日
	 * 精华
	 */
	public void signTheme(String tid, String sign) {
		 String sql="update theme t,bclass b set themeSign=?,signCount=signCount+1 where t.classId=b.classId and t.themeId=?";
	        try {
				qr.update(conn, sql, Integer.parseInt(sign),Integer.parseInt(tid));
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}

	/**
	 * 下午9:09:58 2017年11月23日
	 * 添加新帖
	 */
	public void newTheme(Theme theme) {
        String sql1="select * from bclass where classId=?";
		String sql="insert into theme(userId,classId,themeTitle,themeBody,themeTime,themeViewCount,themeSign,themeIsTop,className,userName) values(?,?,?,?,?,?,?,?,?,?)";
		String updateBclass="update bclass set themeCount=themeCount+1 where classId=?";
		try {
			Bclass bclass = qr.query(conn, sql1, new BeanListHandler<Bclass>(Bclass.class), theme.getClassId()).get(0);
           qr.insert(conn, sql, new ScalarHandler<Long>(1),  theme.getUserId(),theme.getClassId(),theme.getThemeTitle(),theme.getThemeBody(),theme.getThemeTime(),theme.getThemeViewCount(),theme.getThemeSign(),theme.getThemeIsTop(),bclass.getClassName(),theme.getUserName());
           qr.update(conn,updateBclass, theme.getClassId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
