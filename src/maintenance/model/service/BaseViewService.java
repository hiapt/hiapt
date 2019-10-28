package maintenance.model.service;

import maintenance.model.dao.BaseViewDao;
import maintenance.model.vo.BaseView;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

public class BaseViewService {
	private BaseViewDao badao = new BaseViewDao();
	
	public BaseViewService() {}

	// 전체 LIST 갯수 count로 가져온다.
	public int getListCount(String months) {
		Connection conn = getConnection();
		int listCount = badao.getListCount(conn, months);
		close(conn);
		
		return listCount;
	}
	
	// page 가져오기
	public ArrayList<BaseView> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<BaseView> list = badao.selectList(conn, startRow, endRow);
		close(conn);
		System.out.println(" 전체목록 갯수 service: " + list);
		return list;
	}
	
	// search month 
	public ArrayList<BaseView> selectMonthSearch(String months) {
		Connection conn = getConnection();
		ArrayList<BaseView> list = badao.selectMonthSearch(conn, months);
		close(conn);
		
		System.out.println("service: " + list);
		return list;
	}
	
	// 전체조회
	public ArrayList<BaseView> selectAll() {
		Connection conn = getConnection();
		ArrayList<BaseView> list = badao.selectAll(conn);
		close(conn);
		
		return list;
	}
	
	// search userId(동/호)
	public ArrayList<BaseView> selectuserIdSearch(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// search list
	public ArrayList<BaseView> selectMonthSearch(String months, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<BaseView> list = badao.selectMonthSearch(conn, months, startRow, endRow);
		close(conn);
		
		System.out.println("service monts:  " + list);
		return list;
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = badao.getListCount(conn);
		close(conn);
		
		return listCount;
	}

	/*public int getbvListCount() {
		Connection conn = getConnection();
		int listCount = badao.getbvListCount(conn);
		close(conn);
		
		return listCount;
	}*/
	
}
