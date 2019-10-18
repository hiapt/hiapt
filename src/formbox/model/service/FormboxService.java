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

}
