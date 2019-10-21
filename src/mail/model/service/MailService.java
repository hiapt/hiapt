package mail.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import mail.model.dao.MailDao;
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

	

	

	

	

	



}
