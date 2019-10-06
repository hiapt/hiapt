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
		return list;
	}// end selectList()
	
}// end class
