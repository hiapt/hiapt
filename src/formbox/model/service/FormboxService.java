package formbox.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import static common.JDBCTemplate.*;

import formbox.model.dao.FormboxDao;
import formbox.model.vo.Formbox;

public class FormboxService {
	private FormboxDao fdao = new FormboxDao();
	
	public FormboxService () {}
	
	public ArrayList<Formbox> selectAll (int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Formbox> list = fdao.selectAll(conn, startRow, endRow);
		close(conn);
		return list;
	}
	public Formbox selectOne (int formcode) {
		Connection conn = getConnection();
		Formbox form = fdao.selectOne(conn, formcode);
		close(conn);
		return form;
	}

	public int getFormListCount() {
		Connection conn = getConnection();
		int listCount = fdao.getFormListCount(conn);
		close(conn);
		return listCount;
	}
	public ArrayList<Formbox> selectList () {
		Connection conn = getConnection();
		ArrayList<Formbox> list = fdao.selectList(conn);
		close(conn);
		return list;
	}

	public int getFormListSearchT(String keyword) {
		Connection conn = getConnection();
		int listCount = fdao.getFormListSearchT(conn, keyword);
		close(conn);
		return listCount;
	}

	public ArrayList<Formbox> draftFormSearchName(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Formbox> list = fdao.draftFormSearchName(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}

	public int getFormListSearchF(String keyword) {
		Connection conn = getConnection();
		int listCount = fdao.getFormListSearchF(conn, keyword);
		close(conn);
		return listCount;
	}

	public ArrayList<Formbox> draftFormSearchType(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Formbox> list = fdao.draftFormSearchType(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}
}
