package maintenance.model.service;

import maintenance.model.dao.BaseViewDao;
import maintenance.model.vo.BaseView;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class BaseViewService {
	private BaseViewDao badao = new BaseViewDao();
	
	public BaseViewService() {}

	// 전체 LIST 갯수 count로 가져온다.
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = badao.getListCount(conn);
		close(conn);
		
		return listCount;
	}
	
	// page 가져오기
	public ArrayList<BaseView> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<BaseView> list = badao.selectList(conn, startRow, endRow);
		close(conn);
		return list;
	}
	
}
