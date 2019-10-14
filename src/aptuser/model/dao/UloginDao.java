package aptuser.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aptuser.model.vo.Aptuser;
import static common.JDBCTemplate.close;

public class UloginDao {

	public Aptuser loginCheck(Connection conn, String userId, String userPwd) {
		Aptuser aptuser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from aptuser where userid = ? and userpwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				aptuser = new Aptuser();
				
				aptuser.setUserId(userId);
				aptuser.setUserPwd(userPwd);
				aptuser.setUserName(rset.getString("username"));
				aptuser.setUserEnroll(rset.getDate("userenroll"));
				aptuser.setUserBirth(rset.getDate("userbirth"));
				aptuser.setUserPhone(rset.getString("userphone"));
				aptuser.setUserEmail(rset.getString("useremail"));
				aptuser.setUserEtc(rset.getString("useretc"));
				aptuser.setCarType(rset.getString("cartype"));
				aptuser.setCarNo(rset.getString("carno"));
				aptuser.setCarEnroll(rset.getDate("carenroll"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return aptuser;
	}

}
