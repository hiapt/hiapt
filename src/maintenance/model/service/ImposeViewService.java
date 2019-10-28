package maintenance.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import maintenance.model.dao.ImposeViewDao;
import maintenance.model.vo.ImposeView;

public class ImposeViewService {
	private ImposeViewDao imdao = new ImposeViewDao();
	
	public ImposeViewService() {}
	
	//관리비 금액 등록
	public int insertImposeView(ImposeView impose) {
		Connection conn = getConnection();
		int result = imdao.insertImposeView(conn, impose);
		if(result > 0) 
			commit(conn);
		else
			rollback(conn);
		
		close(conn);
		System.out.println("service impose 갯수 : " + result );
		return result;
		
	} // end insert
}
