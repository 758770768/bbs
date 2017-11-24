package org.test.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.test.bean.Bclass;
import org.test.bean.Reply;
import org.test.bean.Theme;
import org.test.utils.DBM;
import org.test.utils.Page;

public class ReplyDao {
	private QueryRunner qr = new QueryRunner();
	private Connection conn = DBM.getConn();
	private Page page = new Page();

	public List<Reply> selectAllWithUserPicture(int i) {
		String sqlPage1 = "select u.userPicture,r.replyTime,u.userName,r.replyId,r.replyBody from reply r,users u where r.userId=u.userId and themeId=? order by r.replyTime asc";
		List<Reply> rl=null;
		try {
			 rl= qr.query(conn, sqlPage1, new BeanListHandler<Reply>(Reply.class),i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rl;
	}

	public Theme selectWithId(int parseInt) {
             String sql="select * from reply r,users u where r.userId=u.userId and r.themeId=? order by r.replyTime asc";
             List<Theme> tl=null;
             try {
				tl = qr.query(conn, sql, new BeanListHandler<Theme>(Theme.class), parseInt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return tl.size()>0?tl.get(0):null;
	}

	public void replayTheme(Reply reply) {
               String sql="insert into reply(themeId,replyBody,userId,userName,replyTime) values(?,?,?,?,?)";
		  try {
				qr.update(conn, sql, reply.getThemeId(),reply.getReplyBody(),reply.getUserId(),reply.getUserName(),reply.getReplyTime());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	/**
	 * 上午11:18:58 2017年11月23日
	 * 删除回复贴
	 */
	public void delReplyWithId(int parseInt) {
               String sql="delete from reply where replyId=?";		
               try {
				qr.update(conn, sql, parseInt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	} 

}
