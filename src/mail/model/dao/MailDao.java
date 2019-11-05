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

	/*//받은 메일함 메일 개수
		public int getListCountR(Connection conn, String email) {
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
		
		//보낸메일함 메일 개수
		public int getListCountS(Connection conn, String email) {
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
		
		//임시보관함 메일 개수
		public int getListCountT(Connection conn, String email) {
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
		
		//내게 쓴 편지함 메일 개수
		public int getListCountSelf(Connection conn, String email) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select count(*) from mailm where separator = ? and mailcode = 4";
			
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
		
		//휴지통 메일 개수
		public int getListCountW(Connection conn, String email) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select count(*) from mailm where separator = ? and mailcode = 5";
			
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
		}*/
	
	/*//받은 메일함 지정 리스트
		public ArrayList<Mailm> selectListR(Connection conn, String email, int startRow, int endRow) {
			ArrayList<Mailm> list = new ArrayList<Mailm>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select * from(select rownum rnum, mailno, empemail, mailtitle, mailtime, fileyn " + 
					"from(select * " + 
					"from mailm " + 
					"where separator = ? and mailcode 1 " + 
					"order by mailtime desc)) " + 
					"where rnum >= ? and rnum <= ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, email);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rset = pstmt.executeQuery();
				
				while((rset.next())) {
					Mailm mailm = new Mailm();
					
					mailm.setMailNo(rset.getInt("mailno"));
					mailm.setEmpEmail(rset.getString("empemail"));
					mailm.setMailTitle(rset.getString("mailtitle"));
					mailm.setMailTime(rset.getDate("mailtime"));
					mailm.setFileYN(rset.getString("fileyn"));
					
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

		//보낸 메일함 지정 리스트
		public ArrayList<Mailm> selectListS(Connection conn, String email, int startRow, int endRow) {
			ArrayList<Mailm> list = new ArrayList<Mailm>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select * from(select rownum rnum, mailno, recipient, mailtitle, mailtime, fileyn " + 
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

				while((rset.next())) {
					Mailm mailm = new Mailm();
					
					mailm.setMailNo(rset.getInt("mailno"));
					mailm.setRecipient(rset.getString("recipient"));
					mailm.setMailTitle(rset.getString("mailtitle"));
					mailm.setMailTime(rset.getDate("mailtime"));
					mailm.setFileYN(rset.getString("fileyn"));
					
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
		
		//임시 보관함 지정 리스트
		public ArrayList<Mailm> selectListT(Connection conn, String email, int startRow, int endRow) {
			ArrayList<Mailm> list = new ArrayList<Mailm>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select * from(select rownum rnum, mailno, recipient, mailtitle, mailtime, fileyn " + 
					"from(select * " + 
					"from mailm " + 
					"where separator = ? and mailcode = 3" + 
					"order by mailtime desc)) " + 
					"where rnum >= ? and rnum <= ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, email);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rset = pstmt.executeQuery();

				while((rset.next())) {
					Mailm mailm = new Mailm();
					
					mailm.setMailNo(rset.getInt("mailno"));
					mailm.setRecipient(rset.getString("recipient"));
					mailm.setMailTitle(rset.getString("mailtitle"));
					mailm.setMailTime(rset.getDate("mailtime"));
					mailm.setFileYN(rset.getString("fileyn"));
					
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

		//내게 쓴 메일함 지정 리스트
		public ArrayList<Mailm> selectListSelf(Connection conn, String email, int startRow, int endRow) {
			ArrayList<Mailm> list = new ArrayList<Mailm>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select * from(select rownum rnum, mailno, empemail, mailtitle, mailtime, fileyn " + 
					"from(select * " + 
					"from mailm " + 
					"where separator = ? and mailcode = 4 " + 
					"order by mailtime desc)) " + 
					"where rnum >= ? and rnum <= ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, email);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rset = pstmt.executeQuery();

				while((rset.next())) {
					Mailm mailm = new Mailm();
					
					mailm.setMailNo(rset.getInt("mailno"));
					mailm.setEmpEmail(rset.getString("empemail"));
					mailm.setMailTitle(rset.getString("mailtitle"));
					mailm.setMailTime(rset.getDate("mailtime"));
					mailm.setFileYN(rset.getString("fileyn"));
					
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

		//휴지통 지정 리스트
		public ArrayList<Mailm> selectListW(Connection conn, String email, int startRow, int endRow) {
			ArrayList<Mailm> list = new ArrayList<Mailm>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select * from(select rownum rnum, mailno, empemail, mailtitle, mailtime, fileyn " + 
					"from(select * " + 
					"from mailm " + 
					"where separator = ? and mailcode = 5 " + 
					"order by mailtime desc)) " + 
					"where rnum >= ? and rnum <= ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, email);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rset = pstmt.executeQuery();

				while((rset.next())) {
					Mailm mailm = new Mailm();
					
					mailm.setMailNo(rset.getInt("mailno"));
					mailm.setEmpEmail(rset.getString("empemail"));
					mailm.setMailTitle(rset.getString("mailtitle"));
					mailm.setMailTime(rset.getDate("mailtime"));
					mailm.setFileYN(rset.getString("fileyn"));
					
					list.add(mailm);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}*/
	
	//전체 메일함 메일 개수
	public int getListCountA(Connection conn, String email) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from mailm where separator = ? and (mailcode = 1 or mailcode = 4)";
		
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
	
	//메일함 번호에 따른 메일 개수
	public int getListCount(Connection conn, String email, int mcode) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = null;
		if(mcode == 0)
		query = "select count(*) from mailm where separator = ? and (mailcode = 1 or mailcode = 4)";
		else
		query = "select count(*) from mailm where separator = ? and mailcode = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			if(mcode != 0)
			pstmt.setInt(2, mcode);
			
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
	
	//전체 메일함 지정 리스트
	public ArrayList<Mailm> selectListA(Connection conn, String email, int startRow, int endRow) {
		ArrayList<Mailm> list = new ArrayList<Mailm>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, mailno, empemail, mailtitle, mailtime, mailcode, fileyn " + 
				"from(select * " + 
				"from mailm " + 
				"where separator = ? and (mailcode = 1 or mailcode = 4) " + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while((rset.next())) {
				Mailm mailm = new Mailm();
				
				mailm.setMailNo(rset.getInt("mailno"));
				mailm.setEmpEmail(rset.getString("empemail"));
				mailm.setMailTitle(rset.getString("mailtitle"));
				mailm.setMailTime(rset.getDate("mailtime"));
				mailm.setMailCode(rset.getInt("mailcode"));
				mailm.setFileYN(rset.getString("fileyn"));
				
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
	
	// 메일함 번호에 따른 지정 리스트
	public ArrayList<Mailm> selectList(Connection conn, String email, int mcode, int startRow, int endRow) {
		ArrayList<Mailm> list = new ArrayList<Mailm>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = null;
		if(mcode == 0) {
		query = "select * from(select rownum rnum, mailno, empemail, recipient, mailtitle, mailtime, mailcode, fileyn, mailboxname " + 
				"from(select * " + 
				"from mailm " + 
				"where separator = ? and (mailcode = 1 or mailcode = 4) " + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		}else {
		query = "select * from(select rownum rnum, mailno, empemail, recipient, mailtitle, mailtime, mailcode, fileyn, mailboxname " + 
				"from(select * " + 
				"from mailm " + 
				"where separator = ? and mailcode = ? " + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(mcode == 0) {
				pstmt.setString(1, email);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			}else {
				pstmt.setString(1, email);
				pstmt.setInt(2, mcode);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
			}
			
			
			rset = pstmt.executeQuery();
			
			while((rset.next())) {
				Mailm mailm = new Mailm();
				
				mailm.setMailNo(rset.getInt("mailno"));
				mailm.setEmpEmail(rset.getString("empemail"));
				mailm.setRecipient(rset.getString("recipient"));
				mailm.setMailTitle(rset.getString("mailtitle"));
				mailm.setMailTime(rset.getDate("mailtime"));
				mailm.setFileYN(rset.getString("fileyn"));
				mailm.setMailCode(rset.getInt("mailcode"));
				mailm.setMailBoxName(rset.getString("mailboxname"));
				
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

	

	//메일 상세보기
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
				mailm.setFileYN(rset.getString("fileyn"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return mailm;
	}

	//지정 메일 휴지통으로 보냄 
	public int moveWaste(Connection conn, int mailno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update mailm set mailcode = 5 where mailno = ?";
		
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
	
	//지정 메일 영구 삭제
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

	//편지쓰기 - 보낸사람(나)
	public int writeMail(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="insert into mailm(MAILNO, MAILCODE, EMPEMAIL, MAILTITLE, MAILTIME, MAILCONTENTS, RECIPIENT, SEPARATOR, fileyn) values(mailno_seq.nextval, 2, ?, ?, sysdate, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mailm.getEmpEmail());
			pstmt.setString(2, mailm.getMailTitle());
			pstmt.setString(3, mailm.getMailContents());
			pstmt.setString(4, mailm.getRecipient());
			pstmt.setString(5, mailm.getEmpEmail());
			pstmt.setString(6, mailm.getFileYN());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	//편지쓰기 - 받는사람
	public int writeMailC(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="insert into mailm(MAILNO, MAILCODE, EMPEMAIL, MAILTITLE, MAILTIME, MAILCONTENTS, RECIPIENT, SEPARATOR, fileyn) values(mailno_seq.nextval, 1, ?, ?, sysdate, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mailm.getEmpEmail());
			pstmt.setString(2, mailm.getMailTitle());
			pstmt.setString(3, mailm.getMailContents());
			pstmt.setString(4, mailm.getRecipient());
			pstmt.setString(5, mailm.getRecipient());
			pstmt.setString(6, mailm.getFileYN());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	//임시보관 메일
	public int writeMailT(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="insert into mailm(MAILNO, MAILCODE, EMPEMAIL, MAILTITLE, MAILTIME, MAILCONTENTS, RECIPIENT, SEPARATOR, fileyn) values(mailno_seq.nextval, 3, ?, ?, sysdate, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mailm.getEmpEmail());
			pstmt.setString(2, mailm.getMailTitle());
			pstmt.setString(3, mailm.getMailContents());
			pstmt.setString(4, mailm.getRecipient());
			pstmt.setString(5, mailm.getEmpEmail());
			pstmt.setString(6, mailm.getFileYN());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	//내게 쓴 메일
	public int selfWriteMail(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="insert into mailm(MAILNO, MAILCODE, EMPEMAIL, MAILTITLE, MAILTIME, MAILCONTENTS, RECIPIENT, SEPARATOR, fileyn) values(mailno_seq.nextval, 4, ?, ?, sysdate, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mailm.getEmpEmail());
			pstmt.setString(2, mailm.getMailTitle());
			pstmt.setString(3, mailm.getMailContents());
			pstmt.setString(4, mailm.getEmpEmail());
			pstmt.setString(5, mailm.getEmpEmail());
			pstmt.setString(6, mailm.getFileYN());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	//임시 보관 메일 완성 - 보낸사람(나)
	public int completeMail(Connection conn, Mailm mailm) {
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

	//임시 보관 메일 완성 - 받는사람
	public int completeMailC(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="insert into mailm(MAILNO, MAILCODE, EMPEMAIL, MAILTITLE, MAILTIME, MAILCONTENTS, RECIPIENT, SEPARATOR) values(mailno_seq.nextval, 1, ?, ?, sysdate, ?, ?, ?)";

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

	//임시 보관 메일 - 내게쓰기 
	public int completeMailS(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="update mailm set MAILCODE = 4, EMPEMAIL = ?, MAILTITLE = ?, MAILCONTENTS = ?, RECIPIENT = ?, MAILTIME = sysdate where mailno = ?";

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

	//임시 저장 메일 - 수정 
	public int updateMailT(Connection conn, Mailm mailm) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query ="update mailm set MAILCODE = 3, EMPEMAIL = ?, MAILTITLE = ?, MAILCONTENTS = ?, RECIPIENT = ?, MAILTIME = sysdate where mailno = ?";

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
	
	//파일 저장 위해 마지막 메일번호 확인
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

	//내 메일함 이름 리스트
	public ArrayList<MailBoxType> selectMailBoxList(Connection conn, String email) {
		ArrayList<MailBoxType> list = new ArrayList<MailBoxType>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from mailboxtype where empemail = ? and mailcode >= 6 order by mailcode";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();

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

	//내 메일함 등록
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

	//제목 검색된 결과 갯수
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

	//제목 검색된 지정 리스트
	public ArrayList<Mailm> selectListSearchT(Connection conn, String email, String title, int startRow, int endRow) {
		ArrayList<Mailm> list = new ArrayList<Mailm>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, mailno, empemail, mailtitle, mailtime, mailcode, mailboxname " + 
				"from(select * " + 
				"from mailm " + 
				"where SEPARATOR = ? and MAILTITLE like ? " + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, "%" + title + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();

			while((rset.next())) {
				Mailm mailm = new Mailm();
				
				mailm.setMailNo(rset.getInt("mailno"));
				mailm.setEmpEmail(rset.getString("empemail"));
				mailm.setMailTitle(rset.getString("mailtitle"));
				mailm.setMailTime(rset.getDate("mailtime"));
				mailm.setMailCode(rset.getInt("mailcode"));
				mailm.setMailBoxName(rset.getString("mailboxname"));
				
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

	//메일함 전체 리스트
	public ArrayList<MailBoxType> selectMailBoxListAll(Connection conn, String email) {
		ArrayList<MailBoxType> list = new ArrayList<MailBoxType>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from mailboxtype where empemail = ? order by mailcode";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();
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

	//파일 추가 - 보낸사람
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

	//파일 추가 - 받는사람
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

	//지정 번호 파일 찾기
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

	
	public int moveMailBoxSelf(Connection conn, int mailno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update mailm set mailcode = 4 where mailno = ?";
		
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

	public int getListCountMy(Connection conn, String email, int mcode) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from mailm where separator = ? and mailcode = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setInt(2, mcode);
			
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

	public ArrayList<Mailm> selectListMy(Connection conn, int mcode, String email, int startRow, int endRow) {
		ArrayList<Mailm> list = new ArrayList<Mailm>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, mailno, empemail, mailtitle, mailtime, mailcode, fileyn, mailboxname " + 
				"from(select * " + 
				"from mailm " + 
				"where separator = ? and mailcode = ? " + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setInt(2, mcode);
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
				mailm.setMailBoxName(rset.getString("mailboxname"));
				
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

	public int moveMailBoxReceive(Connection conn, int mailno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update mailm set mailcode = 2 where mailno = ?";
		
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

	public int getListCountSearchS(Connection conn, String email, String sender) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from mailm where SEPARATOR = ? and empemail like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, "%" + sender + "%");
			
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

	public ArrayList<Mailm> selectListSearchS(Connection conn, String email, String sender, int startRow, int endRow) {
		ArrayList<Mailm> list = new ArrayList<Mailm>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, mailno, empemail, mailtitle, mailtime, mailcode, mailboxname " + 
				"from(select * " + 
				"from mailm " + 
				"where SEPARATOR = ? and empemail like ? " + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, "%" + sender + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();

			while((rset.next())) {
				Mailm mailm = new Mailm();
				
				mailm.setMailNo(rset.getInt("mailno"));
				mailm.setEmpEmail(rset.getString("empemail"));
				mailm.setMailTitle(rset.getString("mailtitle"));
				mailm.setMailTime(rset.getDate("mailtime"));
				mailm.setMailCode(rset.getInt("mailcode"));
				mailm.setMailBoxName(rset.getString("mailboxname"));
				
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

	public int getListCountSearchR(Connection conn, String email, String recipient) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from mailm where SEPARATOR = ? and recipient like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, "%" + recipient + "%");
			
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

	public ArrayList<Mailm> selectListSearchR(Connection conn, String email, String recipient, int startRow,
			int endRow) {
		ArrayList<Mailm> list = new ArrayList<Mailm>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, mailno, recipient, empemail, mailtitle, mailtime, mailcode, mailboxname " + 
				"from(select * " + 
				"from mailm " + 
				"where SEPARATOR = ? and recipient like ? " + 
				"order by mailtime desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, "%" + recipient + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();

			while((rset.next())) {
				Mailm mailm = new Mailm();
				
				mailm.setMailNo(rset.getInt("mailno"));
				mailm.setRecipient(rset.getString("recipient"));
				mailm.setEmpEmail(rset.getString("empemail"));
				mailm.setMailTitle(rset.getString("mailtitle"));
				mailm.setMailTime(rset.getDate("mailtime"));
				mailm.setMailCode(rset.getInt("mailcode"));
				mailm.setMailBoxName(rset.getString("mailboxname"));
				
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

	public MailBoxType selectOneMailBox(Connection conn, String mbox, String email) {
		MailBoxType mbt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from MailBoxType where empemail = ? and mailboxname = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, mbox);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mbt = new MailBoxType();
				
				mbt.setEmpEmail(email);
				mbt.setMailBoxName(mbox);
				mbt.setMailCode(rset.getInt("mailcode"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return mbt;
	}

	public int moveMailBox(Connection conn, int mailno, int mcode) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update mailm set mailcode = ? where mailno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mcode);
			pstmt.setInt(2, mailno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	

	
	

		
	

	

	

	
	

	

	

}
