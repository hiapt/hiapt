package maintenance.model.service;

import maintenance.model.dao.BillDao;

import static common.JDBCTemplate.*;

public class BillService {
	// 의존성 주입
	private BillDao bdao = new BillDao();
	
	// 기본 생성자
	public BillService() {}
	
}
