package mail.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mail.model.vo.MailBoxType;
import mail.model.vo.MailFileBox;
import mail.model.vo.Mailm;

public class MailDao {

	public int getListCountA(Connection conn, String email) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from mailm where separator = ? and (recipient = ? and mailcode is null or mailcode = 2)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int getListCountR(Connection conn, String email) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from mailm where separator = ? and recipient = ? and mailcode is null";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int getListCountS(Connection conn, String email) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from mailm where separator = ? and empemail = ? and mailcode is null";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int getListCountT(Connection conn, String email) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from mailm where separator = ? and mailcode = 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int getListCountSelf(Connection conn, String email) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from mailm where separator = ? and mailcode = 2";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int getListCountW(Connection conn, String email) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from mailm where separator = ? and mailcode = 3";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public ArrayList<Mailm> selectListA(Connection conn, String email, int startRow, int endRow) {
		ArrayList<Mailm> list = new ArrayList<Mailm>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, mailno, empemail, mailtitle, mailtime, mailcode " + 
				"from(select * " + 
				"from mailm " + 
				"where separator = ? and (recipient = ? and mailcode is null or mailcode = 2) " + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, email);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			//보낸사람 제목 시간
			while((rset.next())) {
				Mailm mailm = new Mailm();
				
				mailm.setMailNo(rset.getInt("mailno"));
				mailm.setEmpEmail(rset.getString("empemail"));
				mailm.setMailTitle(rset.getString("mailtitle"));
				mailm.setMailTime(rset.getDate("mailtime"));
				mailm.setMailCode(rset.getInt("mailcode"));
				
				list.add(mailm);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Mailm> selectListR(Connection conn, String email, int startRow, int endRow) {
		ArrayList<Mailm> list = new ArrayList<Mailm>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, mailno, empemail, mailtitle, mailtime " + 
				"from(select * " + 
				"from mailm " + 
				"where separator = ? and recipient = ? and mailcode is null " + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, email);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			//보낸사람 제목 시간
			while((rset.next())) {
				Mailm mailm = new Mailm();
				
				mailm.setMailNo(rset.getInt("mailno"));
				mailm.setEmpEmail(rset.getString("empemail"));
				mailm.setMailTitle(rset.getString("mailtitle"));
				mailm.setMailTime(rset.getDate("mailtime"));
				
				list.add(mailm);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	

	public ArrayList<Mailm> selectListS(Connection conn, String email, int startRow, int endRow) {
		ArrayList<Mailm> list = new ArrayList<Mailm>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, mailno, recipient, mailtitle, mailtime " + 
				"from(select * " + 
				"from mailm " + 
				"where separator = ? and empemail = ? and mailcode is null " + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, email);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			//보낸사람 제목 시간
			while((rset.next())) {
				Mailm mailm = new Mailm();
				
				mailm.setMailNo(rset.getInt("mailno"));
				mailm.setRecipient(rset.getString("recipient"));
				mailm.setMailTitle(rset.getString("mailtitle"));
				mailm.setMailTime(rset.getDate("mailtime"));
				
				list.add(mailm);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Mailm> selectListT(Connection conn, String email, int startRow, int endRow) {
		ArrayList<Mailm> list = new ArrayList<Mailm>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, mailno, recipient, mailtitle, mailtime " + 
				"from(select * " + 
				"from mailm " + 
				"where separator = ? and mailcode = 1" + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			//보낸사람 제목 시간
			while((rset.next())) {
				Mailm mailm = new Mailm();
				
				mailm.setMailNo(rset.getInt("mailno"));
				mailm.setRecipient(rset.getString("recipient"));
				mailm.setMailTitle(rset.getString("mailtitle"));
				mailm.setMailTime(rset.getDate("mailtime"));
				
				list.add(mailm);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Mailm> selectListSelf(Connection conn, String email, int startRow, int endRow) {
		ArrayList<Mailm> list = new ArrayList<Mailm>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, mailno, empemail, mailtitle, mailtime " + 
				"from(select * " + 
				"from mailm " + 
				"where separator = ? and mailcode = 2 " + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			//보낸사람 제목 시간
			while((rset.next())) {
				Mailm mailm = new Mailm();
				
				mailm.setMailNo(rset.getInt("mailno"));
				mailm.setEmpEmail(rset.getString("empemail"));
				mailm.setMailTitle(rset.getString("mailtitle"));
				mailm.setMailTime(rset.getDate("mailtime"));
				
				list.add(mailm);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Mailm> selectListW(Connection conn, String email, int startRow, int endRow) {
		ArrayList<Mailm> list = new ArrayList<Mailm>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, mailno, empemail, mailtitle, mailtime " + 
				"from(select * " + 
				"from mailm " + 
				"where separator = ? and mailcode = 3 " + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			//보낸사람 제목 시간
			while((rset.next())) {
				Mailm mailm = new Mailm();
				
				mailm.setMailNo(rset.getInt("mailno"));
				mailm.setEmpEmail(rset.getString("empemail"));
				mailm.setMailTitle(rset.getString("mailtitle"));
				mailm.setMailTime(rset.getDate("mailtime"));
				
				list.add(mailm);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public Mailm selectOne(Connection conn, int mailno) {
		Mailm mailm = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from mailm where mailno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mailno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mailm = new Mailm();
				
				mailm.setMailNo(mailno);
				mailm.setMailCode(rset.getInt("mailcode"));
				mailm.setEmpEmail(rset.getString("empemail"));
				mailm.setMailTitle(rset.getString("mailtitle"));
				mailm.setMailTime(rset.getDate("mailtime"));
				mailm.setMailContents(rset.getString("mailcontents"));
				mailm.setRecipient(rset.getString("recipient"));
				mailm.setSeparator(rset.getString("separator"));
				mailm.setMailBoxName(rset.getString("mailboxname"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return mailm;
	}

	public int moveWaste(Connection conn, int mailno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update mailm set mailcode = 3 where mailno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mailno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMail(Connection conn, int mailno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete mailm where mailno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mailno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int writeMail(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="insert into mailm(MAILNO, MAILCODE, EMPEMAIL, MAILTITLE, MAILTIME, MAILCONTENTS, RECIPIENT, SEPARATOR) values(mailno_seq.nextval, null, ?, ?, sysdate, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mailm.getEmpEmail());
			pstmt.setString(2, mailm.getMailTitle());
			pstmt.setString(3, mailm.getMailContents());
			pstmt.setString(4, mailm.getRecipient());
			pstmt.setString(5, mailm.getEmpEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int writeMailC(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="insert into mailm(MAILNO, MAILCODE, EMPEMAIL, MAILTITLE, MAILTIME, MAILCONTENTS, RECIPIENT, SEPARATOR) values(mailno_seq.nextval, null, ?, ?, sysdate, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mailm.getEmpEmail());
			pstmt.setString(2, mailm.getMailTitle());
			pstmt.setString(3, mailm.getMailContents());
			pstmt.setString(4, mailm.getRecipient());
			pstmt.setString(5, mailm.getRecipient());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int writeMailT(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="insert into mailm(MAILNO, MAILCODE, EMPEMAIL, MAILTITLE, MAILTIME, MAILCONTENTS, RECIPIENT, SEPARATOR) values(mailno_seq.nextval, 1, ?, ?, sysdate, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mailm.getEmpEmail());
			pstmt.setString(2, mailm.getMailTitle());
			pstmt.setString(3, mailm.getMailContents());
			pstmt.setString(4, mailm.getRecipient());
			pstmt.setString(5, mailm.getEmpEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int selfWriteMail(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="insert into mailm(MAILNO, MAILCODE, EMPEMAIL, MAILTITLE, MAILTIME, MAILCONTENTS, RECIPIENT, SEPARATOR) values(mailno_seq.nextval, 2, ?, ?, sysdate, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mailm.getEmpEmail());
			pstmt.setString(2, mailm.getMailTitle());
			pstmt.setString(3, mailm.getMailContents());
			pstmt.setString(4, mailm.getEmpEmail());
			pstmt.setString(5, mailm.getEmpEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int completeMail(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="update mailm set MAILCODE = null, EMPEMAIL = ?, MAILTITLE = ?, MAILCONTENTS = ?, RECIPIENT = ?, MAILTIME = sysdate where mailno = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mailm.getEmpEmail());
			pstmt.setString(2, mailm.getMailTitle());
			pstmt.setString(3, mailm.getMailContents());
			pstmt.setString(4, mailm.getRecipient());
			pstmt.setInt(5, mailm.getMailNo());;
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int completeMailC(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="insert into mailm(MAILNO, MAILCODE, EMPEMAIL, MAILTITLE, MAILTIME, MAILCONTENTS, RECIPIENT, SEPARATOR) values(mailno_seq.nextval, null, ?, ?, sysdate, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mailm.getEmpEmail());
			pstmt.setString(2, mailm.getMailTitle());
			pstmt.setString(3, mailm.getMailContents());
			pstmt.setString(4, mailm.getRecipient());
			pstmt.setString(5, mailm.getRecipient());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}

	public int completeMailS(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="update mailm set MAILCODE = 2, EMPEMAIL = ?, MAILTITLE = ?, MAILCONTENTS = ?, RECIPIENT = ?, MAILTIME = sysdate where mailno = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mailm.getEmpEmail());
			pstmt.setString(2, mailm.getMailTitle());
			pstmt.setString(3, mailm.getMailContents());
			pstmt.setString(4, mailm.getRecipient());
			pstmt.setInt(5, mailm.getMailNo());;
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateMailT(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="update mailm set MAILCODE = 1, EMPEMAIL = ?, MAILTITLE = ?, MAILCONTENTS = ?, RECIPIENT = ?, MAILTIME = sysdate where mailno = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mailm.getEmpEmail());
			pstmt.setString(2, mailm.getMailTitle());
			pstmt.setString(3, mailm.getMailContents());
			pstmt.setString(4, mailm.getRecipient());
			pstmt.setInt(5, mailm.getMailNo());;
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int selectMailNo(Connection conn) {
		int mailNo = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select max(mailno) from mailm";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				mailNo = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return mailNo;
	}

	public ArrayList<MailBoxType> selectMailBoxList(Connection conn, String email) {
		ArrayList<MailBoxType> list = new ArrayList<MailBoxType>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from mailboxtype where empemail = ? and mailcode >= 4 order by mailcode";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();
			//보낸사람 제목 시간
			while((rset.next())) {
				MailBoxType mbt = new MailBoxType();
				
				mbt.setMailCode(rset.getInt("mailcode"));
				mbt.setMailBoxName(rset.getString("mailboxname"));
				mbt.setEmpEmail(rset.getString("empemail"));

				list.add(mbt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int enrollMailBox(Connection conn, String mbox, String email) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="insert into mailboxtype values(mailcode_seq.nextval, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mbox);
			pstmt.setString(2, email);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int getListCountSearchT(Connection conn, String email, String title) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from mailm where SEPARATOR = ? and MAILTITLE like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, "%" + title + "%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<Mailm> selectListSearchT(Connection conn, String email, String title, int startRow, int endRow) {
		ArrayList<Mailm> list = new ArrayList<Mailm>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, mailno, empemail, mailtitle, mailtime, mailcode " + 
				"from(select * " + 
				"from mailm " + 
				"where SEPARATOR = ? and MAILTITLE like ? " + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, "%" + title + "%");
			
			rset = pstmt.executeQuery();
			//보낸사람 제목 시간
			while((rset.next())) {
				Mailm mailm = new Mailm();
				
				mailm.setMailNo(rset.getInt("mailno"));
				mailm.setEmpEmail(rset.getString("empemail"));
				mailm.setMailTitle(rset.getString("mailtitle"));
				mailm.setMailTime(rset.getDate("mailtime"));
				mailm.setMailCode(rset.getInt("mailcode"));
				
				list.add(mailm);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<MailBoxType> selectMailBoxListAll(Connection conn, String email) {
		ArrayList<MailBoxType> list = new ArrayList<MailBoxType>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from mailboxtype where empemail = ? order by mailcode";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();
			//보낸사람 제목 시간
			while((rset.next())) {
				MailBoxType mbt = new MailBoxType();
				
				mbt.setMailCode(rset.getInt("mailcode"));
				mbt.setMailBoxName(rset.getString("mailboxname"));
				mbt.setEmpEmail(rset.getString("empemail"));

				list.add(mbt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int addFile(Connection conn, int mailno1, String originalFileName, String renameFileName) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="insert into mailfilebox values(?, ?, ?, null, null)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mailno1);;
			pstmt.setString(2, originalFileName);
			pstmt.setString(3, renameFileName);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int addFileC(Connection conn, int mailno2, String originalFileName, String renameFileName2) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="insert into mailfilebox values(?, ?, ?, null, null)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mailno2);;
			pstmt.setString(2, originalFileName);
			pstmt.setString(3, renameFileName2);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public MailFileBox selectFileOne(Connection conn, int mailno) {
		MailFileBox mbf = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from MailFileBox where mailno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mailno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mbf = new MailFileBox();
				
				mbf.setMailNo(mailno);
				mbf.setOriginalfile(rset.getString("originalfile"));
				mbf.setRenamefile(rset.getString("renamefile"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return mbf;
	}

		
	

	

	

	
	

	

	

}
