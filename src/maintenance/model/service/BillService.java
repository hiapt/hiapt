package maintenance.model.service;

import maintenance.model.dao.BillDao;
import maintenance.model.vo.Bill;
import maintenance.model.vo.UserBill;

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
	// insert 용
	public int insertBill(Bill bill) {
		Connection conn = getConnection();
		int result = bdao.insertBill(conn, bill);
		if(result > 0) 
			commit(conn);
		else
			rollback(conn);
		
		close(conn);
		System.out.println("service impose 갯수 : " + result );
		return result;
	}
	
	// 직원용
	public Bill selectOne(long merchantUid) {
		Connection conn = getConnection();
		Bill bill = bdao.selectOne(conn, merchantUid);
		close(conn);
		
		return bill;
	}
	
	// update
	public int updateBill(Bill bill) {
		Connection conn = getConnection();
		int result = bdao.updateBill(conn, bill);
		if(result > 0) 
			commit(conn);
		else
			rollback(conn);
		
		close(conn);
		System.out.println("service impose 갯수 : " + result );
		return result;
	}// update
	
	// 상세보기하면 조회 수 1 증가
	public void updateImposeCount(long merchantUid) {
		Connection conn = getConnection(); // 한개에 대한 결과문을 받아야 한다. 여기서는
		int result = bdao.updateImposeCount(conn, merchantUid);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}
	
}// end class
