package maintenance.model.service;

import maintenance.model.dao.BillViewDao;
import maintenance.model.vo.BillView;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class BillViewService {
	// 의존성 주입
	private BillViewDao bwdao = new BillViewDao();
	
	// 기본 생성자
	public BillViewService() {}
	
	//고지서 간략 조회 리스트 용
	public ArrayList<BillView> selectList() {
		Connection conn = getConnection();
		ArrayList<BillView> list = bwdao.selectList(conn);
		close(conn);
		
		return list;
	}
	
	// 페이징 처리를 위한 메소드, 전체 갯수
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = bwdao.getListCount(conn);
		close(conn);
		
		return listCount;
	}
	
	// 페이징 처리를 위한 메소드, 시작페이지와 끝 페이지용
	public ArrayList<BillView> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<BillView> list = bwdao.selectList(conn, startRow, endRow);
		close(conn);
		
		return list;
	}
}
