package mail.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import mail.model.dao.MailDao;
import mail.model.vo.MailBoxType;
import mail.model.vo.MailFileBox;
import mail.model.vo.Mailm;
import static common.JDBCTemplate.*;

public class MailService {

	private MailDao mdao = new MailDao();
	
	public int getListCountA(String email) {
		Connection conn = getConnection();
		int listCount = mdao.getListCountA(conn, email);
		close(conn);
		return listCount;
	}
	
	public int getListCountR(String email) {
		Connection conn = getConnection();
		int listCount = mdao.getListCountR(conn, email);
		close(conn);
		return listCount;
	}
	
	public int getListCountS(String email) {
		Connection conn = getConnection();
		int listCount = mdao.getListCountS(conn, email);
		close(conn);
		return listCount;
	}
	
	public int getListCountT(String email) {
		Connection conn = getConnection();
		int listCount = mdao.getListCountT(conn, email);
		close(conn);
		return listCount;
	}
	
	public int getListCountSelf(String email) {
		Connection conn = getConnection();
		int listCount = mdao.getListCountSelf(conn, email);
		close(conn);
		return listCount;
	}
	
	public int getListCountW(String email) {
		Connection conn = getConnection();
		int listCount = mdao.getListCountW(conn, email);
		close(conn);
		return listCount;
	}

	public ArrayList<Mailm> selectListA(String email, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Mailm> list = mdao.selectListA(conn, email, startRow, endRow);
		close(conn);
		return list;
	}
	
	public ArrayList<Mailm> selectListR(String email, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Mailm> list = mdao.selectListR(conn, email, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<Mailm> selectListS(String email, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Mailm> list = mdao.selectListS(conn, email, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<Mailm> selectListT(String email, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Mailm> list = mdao.selectListT(conn, email, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<Mailm> selectListSelf(String email, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Mailm> list = mdao.selectListSelf(conn, email, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<Mailm> selectListW(String email, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Mailm> list = mdao.selectListW(conn, email, startRow, endRow);
		close(conn);
		return list;
	}

	public Mailm selectOne(int mailno) {
		Connection conn = getConnection();
		Mailm mailm = mdao.selectOne(conn, mailno);
		close(conn);
		return mailm;
	}

	public int moveWaste(int mailno) {
		Connection conn = getConnection();
		int result = mdao.moveWaste(conn, mailno);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteMail(int mailno) {
		Connection conn = getConnection();
		int result = mdao.deleteMail(conn, mailno);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int writeMail(Mailm mailm) {
		Connection conn = getConnection();
		int result = mdao.writeMail(conn, mailm);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int writeMailC(Mailm mailm) {
		Connection conn = getConnection();
		int result = mdao.writeMailC(conn, mailm);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int writeMailT(Mailm mailm) {
		Connection conn = getConnection();
		int result = mdao.writeMailT(conn, mailm);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int selfWriteMail(Mailm mailm) {
		Connection conn = getConnection();
		int result = mdao.selfWriteMail(conn, mailm);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int completeMail(Mailm mailm) {
		Connection conn = getConnection();
		int result = mdao.completeMail(conn, mailm);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int completeMailC(Mailm mailm) {
		Connection conn = getConnection();
		int result = mdao.completeMailC(conn, mailm);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int completeMailS(Mailm mailm) {
		Connection conn = getConnection();
		int result = mdao.completeMailS(conn, mailm);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateMailT(Mailm mailm) {
		Connection conn = getConnection();
		int result = mdao.updateMailT(conn, mailm);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int selectMailNo() {
		Connection conn = getConnection();
		int mailNo = mdao.selectMailNo(conn);
		close(conn);
		return mailNo;
	}

	public ArrayList<MailBoxType> selectMailBoxList(String email) {
		Connection conn = getConnection();
		ArrayList<MailBoxType> list = mdao.selectMailBoxList(conn, email);
		close(conn);
		return list;
	}

	public int enrollMailBox(String mbox, String email) {
		Connection conn = getConnection();
		int result = mdao.enrollMailBox(conn, mbox, email);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int getListCountSearchT(String email, String title) {
		Connection conn = getConnection();
		int listCount = mdao.getListCountSearchT(conn, email, title);
		close(conn);
		return listCount;
	}

	public ArrayList<Mailm> selectListSearchT(String email, String title, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Mailm> list = mdao.selectListSearchT(conn, email, title, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<MailBoxType> selectMailBoxListAll(String email) {
		Connection conn = getConnection();
		ArrayList<MailBoxType> list = mdao.selectMailBoxListAll(conn, email);
		close(conn);
		return list;
	}

	public int addFile(int mailno1, String originalFileName, String renameFileName) {
		Connection conn = getConnection();
		int result = mdao.addFile(conn, mailno1, originalFileName, renameFileName);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int addFileC(int mailno2, String originalFileName, String renameFileName2) {
		Connection conn = getConnection();
		int result = mdao.addFileC(conn, mailno2, originalFileName, renameFileName2);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public MailFileBox selectFileOne(int mailno) {
		Connection conn = getConnection();
		MailFileBox mbf = mdao.selectFileOne(conn, mailno);
		close(conn);
		return mbf;
	}


	

	

	

	

	



}
