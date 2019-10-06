package maintenance.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import maintenance.model.vo.Bill;

public class BillDao {
	// 기본생성자
	public BillDao() {}
	
	// 고지서 전체 조회용 리스트
	public ArrayList<Bill> selectList(Connection conn) {
		ArrayList<Bill> list = new ArrayList<Bill>();
		Statement stmt = null;
		ResultSet rset = null;
		
		
		return null;
	}
	
	
}
