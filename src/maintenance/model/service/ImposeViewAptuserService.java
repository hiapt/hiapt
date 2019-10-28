package maintenance.model.service;

import maintenance.model.dao.ImposeViewAptuserDao;
import maintenance.model.vo.ImposeViewAptuser;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class ImposeViewAptuserService {
	private ImposeViewAptuserDao imvadao = new ImposeViewAptuserDao();
	
	public ImposeViewAptuserService() {}
	
	// 세대주 동호/이름 검색용
	public ArrayList<ImposeViewAptuser> selectList() {
		Connection conn = getConnection();
		ArrayList<ImposeViewAptuser> alist = imvadao.selectList(conn);
		close(conn);
		System.out.println("service : " + alist);
		return alist;
	}

	public int getListCount(String userId) {
		Connection conn = getConnection();
		int listCount = imvadao.getListCount(conn, userId);
		close(conn);
		System.out.println("service : " + listCount);
		return listCount;
	}

	public ArrayList<ImposeViewAptuser> selectUserId(String userId, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<ImposeViewAptuser> alist = imvadao.selectUserId(conn, userId, startRow, endRow);
		close(conn);
		System.out.println("service : 검색용 시작,끝 페이지 : " + alist);
		return alist;
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = imvadao.getListCount(conn);
		close(conn);
		System.out.println("service 전체리스트 : " + listCount);
		return listCount;
	}

	public ArrayList<ImposeViewAptuser> selectUserId(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<ImposeViewAptuser> alist = imvadao.selectUserId(conn, startRow, endRow);
		close(conn);
		System.out.println("service : 전체목록 갯수 : " + alist);
		return alist;
	}
	
	
	

}
