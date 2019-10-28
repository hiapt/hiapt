package maintenance.model.service;

import maintenance.model.dao.BillDao;
import maintenance.model.vo.Bill;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class BillService {
	// 의존성 주입
	private BillDao bdao = new BillDao();
	
	// 기본 생성자
	public BillService() {}
	
	// 고지서 전체 리스트 조회용
	public ArrayList<Bill> selectList() {
		Connection conn = getConnection();
		ArrayList<Bill> list = bdao.selectList(conn);
		close(conn);
		System.out.println("sevice list : " + list);
		return list;
	}// end selectList()
	
	
	// 고지서 페이징 처리용 count
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = bdao.getListCount(conn);
		close(conn);
		
		return listCount;
	}
	
	// 페이징 처리용 시작과 끝 번호
	public ArrayList<Bill> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Bill> list = bdao.selectList(conn, startRow, endRow);
		close(conn);
		System.out.println("list service : " + list);
		return list;
	}
	
}// end class
