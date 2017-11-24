package org.test.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.test.bean.User;
import org.test.utils.DBM;
import org.test.utils.Page;

public class UserDao {
	private QueryRunner qr = new QueryRunner();
	private Connection conn = DBM.getConn();
	private Page page = new Page();

	public Page selectAll() {
		String sql = "select * from users";
		String sqlCount = "select count(*) from users";
		try {
			Long total = qr.query(conn, sqlCount, new ScalarHandler<Long>(1));
			List<User> ul = qr.query(conn, sql, new BeanListHandler<User>(User.class));
			page.setRows(ul);
			page.setTotal(total.intValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	public User selectUserByUserName(String userName) {
		String sql = "select * from users where userName=?";
		List<User> ul = null;
		try {
			ul = qr.query(conn, sql, new BeanListHandler<User>(User.class), userName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ul.size()>0?ul.get(0):null;
	}

	public User selectUserByUserId(int parseInt) {
		String sql = "select * from users where userId=?";
		List<User> ul = null;
		try {
			ul = qr.query(conn, sql, new BeanListHandler<User>(User.class), parseInt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ul.size()>0?ul.get(0):null;
	}

	/**
	 * 下午8:27:04 2017年11月23日
	 * 用户黑名单
	 */
	public void signTheme(String uid, String state) {
		String sql="update users set state=? where userId=?";
        try {
			qr.update(conn, sql, Integer.parseInt(state),Integer.parseInt(uid));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
